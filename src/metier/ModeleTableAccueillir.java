package metier;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author C103-image
 */
public class ModeleTableAccueillir extends AbstractTableModel{

    private String[] columnNames = {"Référence de la salle","Nom du sport autorisé"};
    private Object[][] data= new Object[30][2];
    
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

}
    