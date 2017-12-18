/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.sql.*;
import java.util.ArrayList;

/**
 * dddd
 * @author Yoann
 */
public class conn_sql {
    
     private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    private final String pilote = "org.gjt.mm.mysql.Driver";
    private String login, psw, url = "";

    public conn_sql(String login, String psw, String db) {
        this.login = login;
        this.psw = psw;
        this.url = "jdbc:mysql://localhost/" + db;
    }

    public boolean valid() {
        try {
            Class.forName(pilote);
            conn = DriverManager.getConnection(url, login, psw);
            stmt = conn.createStatement();
            return true;
        } catch (SQLException ex) {
            System.out.println("SQL Exception: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("JDBC driver not found.");
        }
        return false;
    }

    public void exec(String requete) {
        try {
            Class.forName(pilote);
            conn = DriverManager.getConnection(url, login, psw);
            stmt = conn.createStatement();
            stmt.executeUpdate(requete);
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC driver not found.");
        } catch (SQLException ex) {
            System.out.println("SQL Exception: " + ex.getMessage());
        }
    }

    public ArrayList<String[]> select(String requete) {
        ArrayList<String[]> resultat = new ArrayList<>();
        try {
            Class.forName(pilote);
            conn = DriverManager.getConnection(url, login, psw);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(requete);
            int nbCol = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                String[] row = new String[nbCol];
                for (int i = 0; i < nbCol; i++) {
                    row[i] = rs.getString(i + 1);
                }
                resultat.add(row);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC driver not found.");
        } catch (SQLException ex) {
            System.out.println("SQL Exception: " + ex.getMessage());
        }
        return resultat;
    }
    
}
