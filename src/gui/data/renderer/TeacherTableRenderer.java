/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.data.renderer;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author aroquemaurel
 */
public class TeacherTableRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(
                            JTable table, Object value,
                            boolean isSelected, boolean hasFocus,
                            int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, 
                                                        hasFocus, row, column);
        
        if(table.getColumnCount() <= 4) {
            if((Float)table.getValueAt(row, 3) < 10) {
                c.setForeground(Color.RED);
            } else if((Float)table.getValueAt(row, 3) > 15) {
                c.setForeground(Color.GREEN);
            } else {
                c.setForeground(Color.BLACK);
            }
        } 
        
        return c;
    }


}
