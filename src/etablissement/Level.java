/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package etablissement;

/**
 *
 * @author aroquemaurel
 */
public class Level {
    private int _level;
    
    public Level(final int level) {
        _level = level;
    }
    
    @Override
    public String toString() {
        String[] levels = {"Troisième", "Quatrième", "Cinquième", "Sixième"};
        
        return levels[_level-3];
    }
}
