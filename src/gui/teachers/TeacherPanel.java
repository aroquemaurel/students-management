/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.teachers;

import etablissement.Discipline;
import etablissement.classroom.Classroom;
import etablissement.person.Teacher;
import gui.MainFrame;
import static gui.MainFrame.currentPerson;
import static gui.MainFrame.etablissement;
import gui.Utils;
import gui.data.editors.SpinnerEditor;
import gui.data.models.StudentsTableModel;
import gui.data.renderer.ClassTreeRenderer;
import gui.data.renderer.TeacherTableRenderer;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author aroquemaurel
 */
public class TeacherPanel extends javax.swing.JPanel {

    /**
     * Creates new form TeacherPanel
     */
    public TeacherPanel() {
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
        treeClass = new javax.swing.JTree();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        treeClass.setCellRenderer(new ClassTreeRenderer());
        treeClass.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                treeClassValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(treeClass);

        add(jScrollPane1, java.awt.BorderLayout.WEST);

        jTable1.setModel(new StudentsTableModel()
        );
        jTable1.setCellSelectionEnabled(true);
        jScrollPane2.setViewportView(jTable1);
        jTable1.setDefaultRenderer(Object.class, new TeacherTableRenderer());

        add(jScrollPane2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void treeClassValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_treeClassValueChanged
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) treeClass.getLastSelectedPathComponent();
        if (node == null) {   //Nothing is selected.  
            return;
        }
        Object nodeInfo;

        StudentsTableModel model = ((StudentsTableModel)(jTable1.getModel()));
        if (node.isLeaf()) {
            nodeInfo = ((DefaultMutableTreeNode)(node.getParent())).getUserObject();
            model.setCurrentDiscipline(new Discipline((String)(node.getUserObject())));
        } else {
            nodeInfo = node.getUserObject();
            model.setCurrentDiscipline(null);
        }

        Classroom c = MainFrame.etablissement.getClass(new Classroom((String)nodeInfo));
        model.setStudents(c.getStudents());
        model.setIsHeadTeach(c.getHeadTeacher().equals(MainFrame.currentPerson));
        for(int i = 3 ; i < model.getColumnCount() ; ++i) {
            jTable1.getColumnModel().getColumn(i).setCellEditor(new SpinnerEditor());
        }
    }//GEN-LAST:event_treeClassValueChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private static javax.swing.JTree treeClass;
    // End of variables declaration//GEN-END:variables

    public static void fillTree() {
        if(MainFrame.etablissement != null && currentPerson != null && currentPerson instanceof Teacher) {
            Utils.fillDataTreeClassWithDiscipline(((Teacher)(currentPerson)).getClass(etablissement), treeClass);
            ((ClassTreeRenderer)(treeClass.getCellRenderer())).setTeacher((Teacher) currentPerson);
        }
    }
}
