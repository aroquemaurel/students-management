/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package etablissement.person;

import etablissement.Discipline;
import etablissement.Etablissement;
import etablissement.classroom.Classroom;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author aroquemaurel
 */
public class Teacher extends AuthorizedPerson {
    private Discipline _discipline;
    
    public Teacher(String firstName, String lastName, String password, Discipline discipline) {
        super(firstName, lastName, password);
        _discipline = discipline;
    }
    
    @Override
    public String toString() {
        return super.toString()+ " ("+_discipline.toString()+")";
    }

    public Discipline getDiscipline() {
        return _discipline;
    }

    public void setDiscipline(Discipline _discipline) {
        this._discipline = _discipline;
    }
    
    public Set<Classroom> getClass(Etablissement e) {
        Set<Classroom> classes = e.getClasses();
        Set<Classroom> ret = new TreeSet<>();
        for(Classroom c : classes) {
            if(c.getTeachers().contains(this)) {
                ret.add(c);
            }
        }
        return ret;
    }
}
