/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package etablissement;

import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author aroquemaurel
 */
public class Etablissement {
    Set<Class> _classes;
    Set<AuthorizedPerson> _authorizedPersons;
    
    public Etablissement() {
        _classes = new TreeSet<>();
        _authorizedPersons = new TreeSet<>();
    }
}
