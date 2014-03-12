/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package etablissement.person;

import etablissement.Discipline;
import etablissement.classroom.Note;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author aroquemaurel
 */
public class Student extends Person {
    private Map<Discipline, Note> _notes;
    private String _comment;
    public Student(String firstname, String lastname) {
        super(firstname, lastname);
        _notes = new HashMap<>();
    }

    public Map<Discipline, Note> getNotes() {
        return _notes;
    }
    
    public void initializeNotes(Set<Discipline> disciplines) {
        for(Discipline d : disciplines) {
            _notes.put(d, new Note());
        }
    }

    public String getComment() {
        return _comment;
    }

    public void setComment(String _comment) {
        this._comment = _comment;
    }
    
    
}
