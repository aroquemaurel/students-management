/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.data.renderer;

import etablissement.Discipline;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

/**
 *
 * @author aroquemaurel
 */
public class StudentsListRenderer extends DefaultListCellRenderer {
    private Discipline _currentDiscipline;
    public Discipline getCurrentDiscipline() {
        return _currentDiscipline;
    }

    public void setCurrentDiscipline(Discipline _currentDiscipline) {
        this._currentDiscipline = _currentDiscipline;
    }
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        
        
        return c;
    }
}
