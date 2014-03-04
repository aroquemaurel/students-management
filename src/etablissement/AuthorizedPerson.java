/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package etablissement;

import person.Person;

/**
 *
 * @author aroquemaurel
 */
public class AuthorizedPerson extends Person {
    private String _password; 

    public AuthorizedPerson(String _firstName, String _lastName) {
        super(_firstName, _lastName);
    }
    
    public AuthorizedPerson(String _firstName, String _lastName, String password) {
        super(_firstName, _lastName);
        _password = password;
    }
}
