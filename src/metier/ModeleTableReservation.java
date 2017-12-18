/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.Arrays;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author C103-image
 */
public class ModeleTableReservation  extends AbstractTableModel{

    private String[] columnNames = {"référence de la salle","date","creneau","référence de l'association"};
    private Object[][] data= new Object[10][4];
    
    @Override
    public int getRowCount() {
        return data.length;
    }
    
    @Override
    public String getColumnName(int columnIndex)
    {
        return columnNames[columnIndex];
    }
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       return data[rowIndex][columnIndex];
    }
    
    @Override
    public void setValueAt(Object value, int row, int col)
    {
        data[row][col] = value;
        fireTableCellUpdated(row, col);
        
    }

    public void removeRow(int position){
         
        int indice = 0, indice2 = 0, nbRow = this.getRowCount()-1, nbCol = this.getColumnCount();
        Object temp[][] = new Object[nbRow][nbCol];
         
        for(Object[] value : this.data){
            if(indice != position){
                temp[indice2++] = value;
            }
            indice++;
        }
        this.data = temp;
        temp = null;
        //Cette méthode permet d'avertir le tableau que les données ont été modifiées
        //Ce qui permet une mise à jours complète du tableau
        this.fireTableDataChanged();
    }


    
}
