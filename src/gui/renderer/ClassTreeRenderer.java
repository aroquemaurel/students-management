/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.renderer;

import etablissement.Discipline;
import etablissement.classroom.Classroom;
import etablissement.person.Teacher;
import gui.MainFrame;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

/**
 *
 * @author aroquemaurel
 */
public class ClassTreeRenderer extends DefaultTreeCellRenderer {
    Teacher _teacher;
      @Override
      public Component getTreeCellRendererComponent(JTree tree,Object value,
              boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {

        Component c = super.getTreeCellRendererComponent(tree, value, sel,expanded, leaf, row,hasFocus);
        setIcon(null);
        c.setFont(c.getFont().deriveFont(Font.PLAIN));
        
        if(_teacher != null) {
            if(_teacher.getDiscipline().equals(new Discipline(value.toString()))) {
                c.setForeground(Color.RED);
            } else if(!leaf && MainFrame.etablissement.getClass(new Classroom(value.toString())).getHeadTeacher().equals(_teacher)) {
                c.setFont(c.getFont().deriveFont(Font.BOLD));
            }
        }
        return c;
    }
      
          
    public void setTeacher(final Teacher t) {
        _teacher = t;
    }

}
