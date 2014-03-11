/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import etablissement.Discipline;
import etablissement.classroom.Classroom;
import etablissement.classroom.Level;
import static gui.MainFrame.etablissement;
import java.util.Iterator;
import java.util.Set;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author aroquemaurel
 */
public class Utils {
    public static void fillDataTreeClass(Set<Classroom> classes, JTree t) {
        DefaultMutableTreeNode racine = new DefaultMutableTreeNode("Root");
        DefaultMutableTreeNode currentNode = null;

        if(etablissement != null) { // Pour corriger un problème de Matisse.
            Iterator it = classes.iterator();
            Level currentLevel = null;
            Classroom currentClass;

            while(it.hasNext()) {
                currentClass = (Classroom)it.next();

                // Si premièré itération, ou nouveau niveau
                if(currentLevel == null || !currentLevel.equals(currentClass.getLevel())) {
                    currentLevel = currentClass.getLevel();
                    currentNode = new DefaultMutableTreeNode(currentLevel.toString());
                    racine.add(currentNode);
                } 

                currentNode.add(new DefaultMutableTreeNode(currentClass.toString()));
            }
        }
        t.setModel(new DefaultTreeModel(racine));
        t.setRootVisible(false);
        expandTree(t);
    }
    
    public static void expandTree(JTree t) {
        for(int i = 0 ; i < t.getRowCount() ; ++i) {
            t.expandRow(i);
        }
    }
    
    public static void fillDataTreeClassWithDiscipline(Set<Classroom> classes, JTree t) {
        DefaultMutableTreeNode racine = new DefaultMutableTreeNode("Root");
        DefaultMutableTreeNode currentNode = null;

        if(etablissement != null) { // Pour corriger un problème de Matisse.
            Iterator it = classes.iterator();
            Classroom currentClassroom = null;

            while(it.hasNext()) {
                currentClassroom = (Classroom)it.next();
                Iterator itDisciplines = currentClassroom.getDisciplines().iterator();
                currentNode = new DefaultMutableTreeNode(currentClassroom.toString());
                racine.add(currentNode);
                
                while(itDisciplines.hasNext()) {
                    currentNode.add(new DefaultMutableTreeNode(itDisciplines.next().toString()));
                }
                // Si premièré itération, ou nouveau niveau
                //if(currentClassroom == null || !currentClassroom.getDisciplines().contains()equals(currentDiscipline.getLevel())) {
//                    currentClassroom = currentDiscipline.getLevel();
  //                  currentNode = new DefaultMutableTreeNode(currentClassroom.toString());
               // } 

            }
        }
        t.setModel(new DefaultTreeModel(racine));
        t.setRootVisible(false);
        expandTree(t);
    }

}
