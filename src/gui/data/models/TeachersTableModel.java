/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.data.models;

import etablissement.Discipline;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.swing.table.DefaultTableModel;
import etablissement.person.Teacher;
import java.util.Arrays;

/**
 *
 * @author aroquemaurel
 */
public class TeachersTableModel extends DefaultTableModel {
    private final List<String> _columnsName;
    private final Set<Teacher> _data;
    
    public TeachersTableModel(Set<Teacher> teachers) {
        super();
        _columnsName = new ArrayList<>();
        _data = teachers;
        _columnsName.add("Nom");
        _columnsName.add("Prénom");
        _columnsName.add("Matière");
    }
    
    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public int getRowCount() {

        return (_data == null) ? 0 : _data.size();
    }
    
    @Override
    public String getColumnName(int i) {
        return _columnsName.get(i);
    }

    @Override
    public Object getValueAt(int row, int col) {
        Iterator it = _data.iterator();
        int i = 0 ; 
        Object ret = null;
        
        while(it.hasNext() && i <= row) {
            ++i;
            ret = it.next();
        }
        
        return getCol((Teacher)ret, col);
    }

    @Override
    public void setValueAt(Object o, int row, int col) {
        Iterator it = _data.iterator();
        Teacher t = null;
        int i = 0;
        
        while(it.hasNext() && i <= row) {
            ++i;
            t = (Teacher) it.next();
        }
        if(t != null) {
            switch(col) {
                case 0:
                    t.setLastName(o.toString());
                    break;
                case 1:
                    t.setFirstName(o.toString());
                    break;
                case 2:
                    t.setDiscipline(new Discipline(o.toString()));
                    break;
            }
        }
        List buff = Arrays.asList(_data.toArray());
        _data.clear();
        _data.addAll(buff);
        fireTableDataChanged();
    }
    
    
    public Object getCol(final Teacher t, final int col) {
        Object ret = null;
        switch(col) {
            case 0:
                ret = t.getLastName();
                break;
            case 1:
                ret = t.getFirstName();
                break; 
            case 2:
                ret = t.getDiscipline();
                break;
        }
        return ret;
    }

    @Override
    public void addRow(Object[] os) {
        _data.add(new Teacher(os[0].toString(), os[1].toString(), "", new Discipline(os[2].toString())));
        fireTableRowsInserted(getRowCount(), getRowCount());
    }

    @Override
    public void removeRow(int row) {
        Iterator it = _data.iterator();
        int i = 0;
        
        while(it.hasNext() && i <= row) {
            ++i;
            it.next();
        }
        it.remove();
        fireTableRowsDeleted(row, row);
    }
    
    
    
    
}
