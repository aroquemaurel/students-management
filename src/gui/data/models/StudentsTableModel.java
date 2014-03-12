/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.data.models;

import etablissement.Discipline;
import etablissement.person.Student;
import etablissement.person.Teacher;
import gui.MainFrame;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aroquemaurel
 */
public class StudentsTableModel extends DefaultTableModel {
    private Set<Student> _students;
    private final List<String> _columnsName;
    private boolean _isHeadTeach;
    private Discipline _currentDiscipline;
    
    public StudentsTableModel() {
        _students = new TreeSet<>();
        _columnsName = new ArrayList<>();
        _columnsName.add("Nom");
        _columnsName.add("Prénom");
        _columnsName.add("Appréciation");
        
    }
    
        @Override
    public int getColumnCount() {
        return _columnsName.size();
    }

    @Override
    public int getRowCount() {
        return (_students == null) ? 0 : _students.size();
    }
    
    @Override
    public String getColumnName(int i) {
        return _columnsName.get(i);
    }

    @Override
    public Object getValueAt(int row, int col) {
        Iterator it = _students.iterator();
        int i = 0 ; 
        Object ret = null;
        
        while(it.hasNext() && i <= row) {
            ++i;
            ret = it.next();
        }
        
        return getCol((Student)ret, col);
    }

    @Override
    public void setValueAt(Object o, int row, int col) {
        Iterator it = _students.iterator();
        Student buff = null;
        int i = 0;
        while(it.hasNext() && i <= row) {
            ++i; 
            buff = (Student) it.next(); 
        }
        if(buff != null) {
            if(col == 2) {
                if(_currentDiscipline == null) {
                    buff.setComment(o.toString());
                } else {
                    buff.getNotes().get(_currentDiscipline).setComment(o.toString());
                }
            } else if(col == 3 && _currentDiscipline != null) {
                buff.getNotes().get(_currentDiscipline).setNote(Float.valueOf(o.toString()));
            }
        }
        
    }
    
    public Object getCol(final Student t, final int col) {
        Object ret;
        switch(col) {
            case 0:
                ret = t.getLastName();
                break;
            case 1:
                ret = t.getFirstName();
                break; 
            case 2:
                if(_currentDiscipline == null) {
                    ret = t.getComment();
                } else {
                    ret = t.getNotes().get(_currentDiscipline).getComment();
                }
                break;
            default:
                ret = t.getNotes().get(new Discipline(_columnsName.get(col))).getNote();
                    
        }
        return ret;
    }

    public void setStudents(Set<Student> _students) {
        this._students = _students;
        
        if(_students.iterator().hasNext()) {
            Iterator it = ((Student)(_students.iterator().next())).getNotes().entrySet().iterator();
            _columnsName.clear();
            _columnsName.add("Nom");
            _columnsName.add("Prénom");
            _columnsName.add("Appréciation");

            if(_currentDiscipline == null) {
                while(it.hasNext()) {
                    _columnsName.add(((Map.Entry)it.next()).getKey().toString());
                }
            } else {
                _columnsName.add(_currentDiscipline.toString());
            }
        }
        
        fireTableStructureChanged();
        fireTableDataChanged();
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return (col == 2 && _isHeadTeach && _currentDiscipline == null) || 
               (_currentDiscipline.equals(
                       ((Teacher)MainFrame.currentPerson).getDiscipline())
                );
    }

    public boolean isIsHeadTeach() {
        return _isHeadTeach;
    }

    public void setIsHeadTeach(boolean _isHeadTeach) {
        this._isHeadTeach = _isHeadTeach;
    }

    public Discipline getCurrentDiscipline() {
        return _currentDiscipline;
    }

    public void setCurrentDiscipline(Discipline _currentDiscipline) {
        this._currentDiscipline = _currentDiscipline;
    }
    
    
}
