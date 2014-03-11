/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.renderer;

import etablissement.classroom.Classroom;
import java.awt.Component;
import java.awt.Font;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

/**
 *
 * @author aroquemaurel
 */
public class TeacherListRenderer extends DefaultListCellRenderer {
    Classroom _class;
    
    public void setClass(Classroom _class) {
        this._class = _class;
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        
        if (_class.getHeadTeacher().equals(value)) { // professeur principal en gras
            c.setFont(c.getFont().deriveFont(Font.BOLD));
        } else {
            c.setFont(c.getFont().deriveFont(Font.PLAIN));
        }
        
        return c;
    }

}
