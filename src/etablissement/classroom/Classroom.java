/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package etablissement.classroom;

import etablissement.Discipline;
import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import etablissement.person.Student;
import etablissement.person.Teacher;

/**
 *
 * @author aroquemaurel
 */
public class Classroom implements Comparable<Classroom> {
    private final Level _level;
    private final int _number;
    private final Set<Student> _students;
    private final Set<Teacher> _teachers;
    private final Set<Discipline> _disciplines;
    private Teacher _headTeacher;
    
    public Classroom(final Level l, final int num) {
        _level = l;
        _number = num;
        _students = new TreeSet<>();
        _teachers = new TreeSet<>();
        _disciplines = new TreeSet<>();
    }
    
    public Classroom(final String cl) {
        _level = new Level(Integer.valueOf(cl.substring(0,1)));
        _number = Integer.valueOf(cl.substring(2, cl.length()));
        _students = new TreeSet<>();
        _teachers = new TreeSet<>();
        _disciplines = new TreeSet<>();
    }

    public Teacher getHeadTeacher() {
        return _headTeacher;
    }

    public void setHeadTeacher(Teacher _headTeacher) {
        this._headTeacher = _headTeacher;
    }
    
    public Level getLevel() {
        return _level;
    }

    public Set<Discipline> getDisciplines() {
        return _disciplines;
    }

    public int getNumber() {
        return _number;
    }

    public Set<Student> getStudents() {
        return _students;
    }

    public Set<Teacher> getTeachers() {
        return _teachers;
    }
    
    @Override
    public String toString() {
        return _level.getLevel()+"e"+_number;
    }
    
    @Override
    public int compareTo(Classroom t) {
        int ret;

        if(_level.equals(t.getLevel())) {
            ret = _number-t.getNumber();
        } else {
            ret = t.getLevel().compareTo(_level);
        }
        
        return ret;
    }
    
    /**
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Classroom)) {
            return false;
        }
        
        return _level.equals(((Classroom)o).getLevel()) && 
                _number == ((Classroom)o).getNumber();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this._level);
        hash = 29 * hash + this._number;
        return hash;
    }
    
    public void addStudent(Student... pStudents) {
        _students.addAll(Arrays.asList(pStudents));
        for(Student s : pStudents) {
            s.initializeNotes(_disciplines);
        }
    }
    
    public void addTeacher(Teacher... pTeachers) {
        _teachers.addAll(Arrays.asList(pTeachers));
    }
    
    public void addDiscipline(Discipline... d) {
        _disciplines.addAll(Arrays.asList(d));
    }
}
