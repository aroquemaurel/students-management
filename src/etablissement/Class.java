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
public class Class implements Comparable<Class> {
    private Level _level;
    private int _number;
    
    public Class(final Level l, final int num) {
        _level = l;
        _number = num;
    }

    public Level getLevel() {
        return _level;
    }

    public int getNumber() {
        return _number;
    }
    
    @Override
    public String toString() {
        return _level.getLevel()+"e"+_number;
    }
    
    @Override
    public int compareTo(Class t) {
        int ret;

        if(_level.equals(t.getLevel())) {
            ret = _number-t.getNumber();
        } else {
            ret = t.getLevel().compareTo(_level);
        }
        
        return ret;
    }
    
    /**
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Class)) {
            return false;
        }
        
        return _level.equals(((Class)o).getLevel()) && 
                _number == ((Class)o).getNumber();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this._level);
        hash = 29 * hash + this._number;
        return hash;
    }
}
