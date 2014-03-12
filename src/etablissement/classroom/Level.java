/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package etablissement.classroom;

/**
 *
 * @author aroquemaurel
 */
public class Level implements Comparable<Level> {
    private final int _level;
    
    public Level(final int level) {
        _level = level;
    }

    public Level(final String level) {
        _level = stringToInt(level);
    }
    
    public int getLevel() {
        return _level;
    }
    
    @Override
    public String toString() {
        String[] levels = {"Troisième", "Quatrième", "Cinquième", "Sixième"};
        
        return levels[_level-3];
    }

    @Override
    public int compareTo(Level t) {
        return _level - t.getLevel();
    }
    
    /**
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        return (o instanceof Level) && _level == ((Level)o).getLevel();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + this._level;
        return hash;
    }
    
    private int stringToInt(String s) {
        int ret = 0;
        switch(s) {
            case "Troisième":
                ret = 3;
                break;
            case "Quatrième":
                ret = 4;
                break;
            case "Cinquième":
                ret = 5;
                break;
            case "Sixième":
                ret = 6;
                break;
        }
        return ret;
    }
}
