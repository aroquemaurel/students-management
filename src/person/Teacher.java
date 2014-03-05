/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package person;

import etablissement.Discipline;

/**
 *
 * @author aroquemaurel
 */
public class Teacher extends AuthorizedPerson {
    Discipline _discipline;
    
    public Teacher(String _firstName, String _lastName, String password) {
        super(_firstName, _lastName, password);
    }
    
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
    
    
}
