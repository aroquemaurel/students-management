/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managementStudents;

import etablissement.Classroom;
import etablissement.Etablissement;
import gui.MainFrame;
import person.Student;

/**
 *
 * @author aroquemaurel
 */
public class ManagementStudents {
    public static void main(String[] args) {
        Etablissement e = new Etablissement();
        Classroom buff = new Classroom("5e1");
        buff.addStudent(new Student("prenom1", "nom1"), 
                        new Student("prenom2", "nom2"),
                        new Student("prenom3", "nom3"),
                        new Student("prenom4", "nom4"));
        e.addClass(buff);
        buff = new Classroom("3e1");
        e.addClass(buff);
        buff = new Classroom("6e1");
        e.addClass(buff);
        buff = new Classroom("4e1");
        e.addClass(buff);
        buff = new Classroom("5e3");
        e.addClass(buff);
        
        MainFrame f = new MainFrame(e);
        f.launch();
    }
}
