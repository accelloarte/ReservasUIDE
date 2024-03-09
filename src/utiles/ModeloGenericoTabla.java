/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utiles;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author milton
 */
public class ModeloGenericoTabla extends AbstractTableModel{
    private String[] columnNames;
    private String[] fields;
    private List data;
    
    public ModeloGenericoTabla(String[] columnNames, String[] fields, List data){
        this.columnNames = columnNames;
        this.fields = fields;
        this.data = data;
    }
    
    public int getColumnCount(){
        return columnNames.length;
    }
    
    public String getColumnName(int column){
        return columnNames[column];
    }
    
    public int getRowCount(){
        return data.size();
    }
    
    public Object getObject(int row){
        return data.get(row);
    }
    
    public Object getValueAt(int row, int column){
        Object value = null;
        Object obj = data.get(row);
        try{
            value = BeanUtil.invokeGetter(obj, fields[column]);
        }catch (Exception e){
            e.printStackTrace();
        }
        return value;
    }
    public void add(Object o){
        data.add(o);
        fireTableDataChanged();
    }
    public void delete(Object o){
        data.remove(o);
         fireTableDataChanged();
    }
    
    public static int findText(AbstractTableModel atm, String textToFind, int col){
        int length = textToFind.length();
        for (int i = 0 ; i < atm.getRowCount(); i++){
            String value = atm.getValueAt(i, col).toString();
            int limit = value.length() < length ? value.length() : length;
            if (textToFind.equalsIgnoreCase(value.substring(0,limit))){
                return i;
            }
        }
        return -1;
    }
    
    
}