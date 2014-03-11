/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package etablissement;

import java.util.Objects;

/**
 *
 * @author aroquemaurel
 */
public class Discipline implements Comparable<Discipline> {
    private String _name;

    public Discipline(String _name) {
        this._name = _name;
    }

    public String getName() {
        return _name;
    }

    public void setName(String _name) {
        this._name = _name;
    }
    
    @Override
    public String toString() {
        return _name;
    }

    @Override
    public int compareTo(Discipline t) {
        return _name.compareTo(t.getName());
    }
    
        
    @Override
    public boolean equals(Object o) {
        return o instanceof Discipline && _name.equals(((Discipline)o).getName());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this._name);
        return hash;
    }

}
