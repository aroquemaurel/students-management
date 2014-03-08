/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package etablissement;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import person.Principal;
import person.Teacher;

/**
 *
 * @author aroquemaurel
 */
public class Etablissement {
    Set<Classroom> _classes;
    Set<Teacher> _teachers;
    Principal _principal;
    
    public Etablissement() {
        _classes = new TreeSet<>();
        _teachers = new TreeSet<>();
    }
    
    public void addClass(Classroom c) {
        _classes.add(c);
    }
    
    public void addAuthorizedPerson(Teacher... pPersons) {
        _teachers.addAll(Arrays.asList(pPersons));
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

    public int getNbClassLevel(final Level l) {
        Iterator it = _classes.iterator();
        boolean found = false;
        boolean currentLevel = false;
        Classroom c;
        int ret = 1;
        
        while(it.hasNext() && !found) {
            c = (Classroom) it.next();
            
            if(currentLevel) {
                ++ret;
                found = !(l.equals(c.getLevel()));
            }
            currentLevel = l.equals(c.getLevel());
        }
    if(!it.hasNext()) {
        ++ret;
    }
        return ret;
    }
    
    public Set<Teacher> getTeachers() {
        return _teachers;
    }

    public Principal getPrincipal() {
        return _principal;
    }

    public void setPrincipal(Principal _principal) {
        this._principal = _principal;
    }
    
    
}
