/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package person;

/**
 *
 * @author aroquemaurel
 */
public class Person {
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
    
    
}
