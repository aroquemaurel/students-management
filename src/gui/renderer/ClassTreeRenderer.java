/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.renderer;

import etablissement.person.Teacher;
import java.awt.Component;
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

        super.getTreeCellRendererComponent(tree, value, sel,expanded, leaf, row,hasFocus);

          setIcon(null);
        return this;
    }
      
          
    public void setTeacher(final Teacher t) {
        _teacher = t;
    }

}
