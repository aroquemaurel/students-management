/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managementStudents;

import etablissement.Etablissement;
import etablissement.Level;
import gui.MainFrame;
import java.util.Iterator;

/**
 *
 * @author aroquemaurel
 */
public class ManagementStudents {
    public static void main(String[] args) {
        Etablissement e = new Etablissement();
        e.addClass(new etablissement.Class(new Level(5), 1));
        e.addClass(new etablissement.Class(new Level(3), 1));
        e.addClass(new etablissement.Class(new Level(6), 1));
        e.addClass(new etablissement.Class(new Level(4), 1));
        e.addClass(new etablissement.Class(new Level(5), 3));
        
        MainFrame f = new MainFrame(e);
        f.launch();
    }
}
