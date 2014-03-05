/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package person;

import java.util.Objects;

/**
 *
 * @author aroquemaurel
 */
public class Person implements Comparable<Person> {
    private String _firstName;
    private String _lastName;

    public Person(String _firstName, String _lastName) {
        this._firstName = _firstName;
        this._lastName = _lastName;
    }

    public String getFirstName() {
        return _firstName;
    }

    public void setFirstName(String _firstName) {
        this._firstName = _firstName;
    }

    public String getLastName() {
        return _lastName;
    }

    public void setLastName(String _lastName) {
        this._lastName = _lastName;
    }

    @Override
    public int compareTo(Person t) {
        return _lastName.compareTo(t.getLastName());
    }
    
    @Override
    public boolean equals(Object o) {
        return o instanceof Person && ((Person)o).getFirstName().equals(_firstName) 
                                   && ((Person)o).getLastName().equals(_lastName);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this._firstName);
        hash = 61 * hash + Objects.hashCode(this._lastName);
        return hash;
    }
    
    @Override
    public String toString() {
        return _lastName+ " "+_firstName;
    }
    
}
