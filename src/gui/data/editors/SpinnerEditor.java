/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.data.editors;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.util.EventObject;
import javax.swing.DefaultCellEditor;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author aroquemaurel
 */
public class SpinnerEditor extends DefaultCellEditor {
    JSpinner spinner;
    JSpinner.DefaultEditor editor;
    JTextField textField;
    boolean valueSet;

    // Initializes the spinner.
    public SpinnerEditor() {
        super(new JTextField());
        spinner = new JSpinner(new SpinnerNumberModel(0, 0.0, 20.0, 0.5));
        
        editor = ((JSpinner.DefaultEditor)spinner.getEditor());
        textField = editor.getTextField();
    }

    // Prepares the spinner component and returns it.
    @Override
    public Component getTableCellEditorComponent(
        JTable table, Object value, boolean isSelected, int row, int column
    ) {
        if ( !valueSet ) {
            spinner.setValue(value);
        }
        return spinner;
    }

    @Override
    public boolean isCellEditable( EventObject eo ) {
        if ( eo instanceof KeyEvent ) {
            KeyEvent ke = (KeyEvent)eo;
            textField.setText(String.valueOf(ke.getKeyChar()));
            valueSet = true;
        } else {
            valueSet = false;
        }
        return true;
    }

    // Returns the spinners current value.
    @Override
    public Object getCellEditorValue() {
        return spinner.getValue();
    }

    @Override
    public boolean stopCellEditing() {
        try {
            editor.commitEdit();
            spinner.commitEdit();
        } catch ( java.text.ParseException e ) {
            JOptionPane.showMessageDialog(null,
                "Invalid value, discarding.");
        }
        return super.stopCellEditing();
    }
}

