/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.principal;

import gui.MainFrame;
import gui.models.TeachersTableModel;
import gui.principal.classrooms.ClassPanel;

/**
 *
 * @author aroquemaurel
 */
public class PrincipalPanel extends javax.swing.JPanel {
    
    /**
     * Creates new form PrincipalFrame
     */
    public PrincipalPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        treeClasses = new javax.swing.JTree();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        classPanel1 = new gui.principal.classrooms.ClassPanel();
        teachersPanel1 = new gui.principal.teachers.TeachersPanel();

        jScrollPane1.setViewportView(treeClasses);

        setLayout(new java.awt.BorderLayout());

        jTabbedPane1.addTab("Classes", classPanel1);
        jTabbedPane1.addTab("Professeurs", teachersPanel1);

        add(jTabbedPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    public ClassPanel getClassPanel1() {
        return classPanel1;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private gui.principal.classrooms.ClassPanel classPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private gui.principal.teachers.TeachersPanel teachersPanel1;
    private javax.swing.JTree treeClasses;
    // End of variables declaration//GEN-END:variables
}
