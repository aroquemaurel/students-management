/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main_managementStudents;

import etablissement.classroom.Classroom;
import etablissement.Discipline;
import etablissement.Etablissement;
import gui.MainFrame;
import etablissement.person.Principal;
import etablissement.person.Student;
import etablissement.person.Teacher;

/**
 *
 * @author aroquemaurel
 */
public class Main_ManagementStudents {
    public static void main(String[] args) {
        MainFrame f = new MainFrame(Main_ManagementStudents.fillData());
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
        Teacher t6 = new Teacher("Teach","prof", "456", new Discipline("Histoire"));
        Discipline d1 = new Discipline("Histoire");
        Discipline d2 = new Discipline("Anglais");
        Discipline d3 = new Discipline("Physique");
        Discipline d4 = new Discipline("Géographie");
        Discipline d5 = new Discipline("Maths");
        Discipline d6 = new Discipline("SVT");
        
        e.addAuthorizedPerson(t1, t2, t3, t4, t5, t6);
        e.setPrincipal(new Principal("Wright", "princ", "123"));
        
        buffClass = new Classroom("5e1");
        buffClass.addStudent(new Student("Skinner","Harriet"),
                        new Student("Winters","Vincent"),
                        new Student("Mcbride","Macon"),
                        new Student("Calhoun","Charissa"));
        buffClass.addDiscipline(d1, d2);
        buffClass.addTeacher(t3, t4, t6);
        buffClass.setHeadTeacher(t3);
        e.addClass(buffClass);
        
        buffClass = new Classroom("3e1");
        buffClass.addStudent(new Student("Gamble","Haley"),
                        new Student("Mercado","Galena"),
                        new Student("Hartman","Moana"),
                        new Student("Graham","Coby"));
        buffClass.addTeacher(t1,t2,t3, t6);
        buffClass.addDiscipline(d2, d3);
        buffClass.setHeadTeacher(t2);
        e.addClass(buffClass);
        
        buffClass = new Classroom("6e1");
        buffClass.addStudent(new Student("Chaney","Reuben"),
                        new Student("Wright","Hayes"),
                        new Student("Nash","Tobias"),
                        new Student("Phelps","Isabelle"));
        buffClass.addTeacher(t2, t6);
        buffClass.addDiscipline(d1, d2, d2, d3);
        buffClass.setHeadTeacher(t6);
        e.addClass(buffClass);
        
        buffClass = new Classroom("4e1");
        buffClass.addStudent(new Student("Meyers","Phelan"),
                    	new Student("Horn","Madaline"),
                        new Student("Bright","Naida"),
                        new Student("Smith","Jenette"));
        buffClass.addTeacher(t1, t5);
        buffClass.addDiscipline(d1, d3, d2);
        buffClass.setHeadTeacher(t1);
        e.addClass(buffClass);
        
        buffClass = new Classroom("5e2");
        buffClass.addStudent(new Student("Burris","Hedy"),
        new Student("Curtis","Jared"),
	new Student("Wallace","Barrett"));
        buffClass.addTeacher(t4,t5, t6);
        buffClass.setHeadTeacher(t4);
        buffClass.addDiscipline(d1, d3, d2, d4, d5);

        e.addClass(buffClass);
        
        return e;
    }
}
