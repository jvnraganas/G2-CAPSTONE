/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cap_stone;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.util.Arrays;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Joven
 */
public class CustomDbUtils {
    
    public static TableModel resultSetToTableModel(ResultSet rs) throws java.sql.SQLException{
        try {
        ResultSetMetaData metaData = rs.getMetaData(); 
        int columnCount;
        columnCount = metaData.getColumnCount();
      
        String[] columnNames = new String[columnCount];
        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
            columnNames[columnIndex - 1] = metaData.getColumnName(columnIndex);
        }
      
        Object[][] data = new Object[0][columnCount];
    
        int rowCount = 0;
        while (rs.next()) {
            Object[] row = new Object[columnCount];
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                row[columnIndex - 1] = rs.getObject(columnIndex);
            }
            data = Arrays.copyOf(data, data.length + 1);
            data[rowCount] = row;
            rowCount++;
        }
      
       return new DefaultTableModel(data, columnNames);
       
    } catch (Exception ex) {
        // Handle SQLException appropriately
        ex.printStackTrace();
        return null;
        
    }
}

    public static class ResultSet {

        public ResultSet() {
        }

        public Object getObject(int columnIndex) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        public boolean next() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        public ResultSetMetaData getMetaData() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }

    public static class SQLException {

        public SQLException() {
        }

        public void printStackTrace() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }
}
