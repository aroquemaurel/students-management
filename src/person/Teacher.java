/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package person;

import etablissement.AuthorizedPerson;

/**
 *
 * @author aroquemaurel
 */
public class Teacher extends AuthorizedPerson {

    public Teacher(String _firstName, String _lastName, String password) {
        super(_firstName, _lastName, password);
    }
    
}
