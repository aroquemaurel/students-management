/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package etablissement;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author aroquemaurel
 */
public class Etablissement {
    Set<Classroom> _classes;
    Set<AuthorizedPerson> _authorizedPersons;
    
    public Etablissement() {
        _classes = new TreeSet<>();
        _authorizedPersons = new TreeSet<>();
    }
    
    public void addClass(Classroom c) {
        _classes.add(c);
    }
    
    public void addAuthorizedPerson(AuthorizedPerson p) {
        _authorizedPersons.add(p);
    }

    public Set<Classroom> getClasses() {
        return _classes;
    }
    
    public Classroom getClass(Classroom c) {
        Iterator it = _classes.iterator();
        Classroom ret = null;
        
        while(it.hasNext() && !c.equals(ret)) {
            ret = (Classroom)it.next();
        }
        
        return ret;
    }
}
