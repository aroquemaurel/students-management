/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managementStudents;

import etablissement.Classroom;
import etablissement.Discipline;
import etablissement.Etablissement;
import gui.MainFrame;
import person.Principal;
import person.Student;
import person.Teacher;

/**
 *
 * @author aroquemaurel
 */
public class ManagementStudents {
    public static void main(String[] args) {
        MainFrame f = new MainFrame(ManagementStudents.fillData());
        f.launch();
    }
    
    public static Etablissement fillData() {
        Etablissement e = new Etablissement();
        Classroom buffClass;
        Teacher t1 = new Teacher("Hoover","Elliott", "password1", new Discipline("Mathématiques"));
        Teacher t2 = new Teacher("Lee","Gail", "password2", new Discipline("Français"));
        Teacher t3 = new Teacher("Mcmillan","Victor", "password3", new Discipline("Anglais"));
        Teacher t4 = new Teacher("Velasquez","Armando", "password4", new Discipline("Français"));
        Teacher t5 = new Teacher("Winters","Galena", "password5", new Discipline("Histoire"));
        
        e.addAuthorizedPerson(t1, t2, t3, t4, t5);
        e.setPrincipal(new Principal("Wright", "Hedy", "password"));
        
        buffClass = new Classroom("5e1");
        buffClass.addStudent(new Student("Skinner","Harriet"),
                        new Student("Winters","Vincent"),
                        new Student("Mcbride","Macon"),
                        new Student("Calhoun","Charissa"));
        buffClass.addTeacher(t3, t4);
        buffClass.setHeadTeacher(t3);
        e.addClass(buffClass);
        
        buffClass = new Classroom("3e1");
        buffClass.addStudent(new Student("Gamble","Haley"),
                        new Student("Mercado","Galena"),
                        new Student("Hartman","Moana"),
                        new Student("Graham","Coby"));
        buffClass.addTeacher(t1,t2,t3);
        buffClass.setHeadTeacher(t2);
        e.addClass(buffClass);
        
        buffClass = new Classroom("6e1");
        buffClass.addStudent(new Student("Chaney","Reuben"),
                        new Student("Wright","Hayes"),
                        new Student("Nash","Tobias"),
                        new Student("Phelps","Isabelle"));
        buffClass.addTeacher(t2);
        buffClass.setHeadTeacher(t2);
        e.addClass(buffClass);
        
        buffClass = new Classroom("4e1");
        buffClass.addStudent(new Student("Meyers","Phelan"),
                    	new Student("Horn","Madaline"),
                        new Student("Bright","Naida"),
                        new Student("Smith","Jenette"));
        buffClass.addTeacher(t1, t5);
        buffClass.setHeadTeacher(t1);
        e.addClass(buffClass);
        
        buffClass = new Classroom("5e3");
        buffClass.addStudent(new Student("Burris","Hedy"),
        new Student("Curtis","Jared"),
	new Student("Wallace","Barrett"));
        buffClass.addTeacher(t4,t5);
        buffClass.setHeadTeacher(t4);
        e.addClass(buffClass);
        
        return e;
    }
}
