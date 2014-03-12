/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package etablissement.classroom;

/**
 *
 * @author aroquemaurel
 */
public class Note {
    private float _note;
    private String _comment;

    public Note() {
        
    }
    public Note(float _note, String _comment) {
        this._note = _note;
        this._comment = _comment;
    }

    public float getNote() {
        return _note;
    }

    public void setNote(float _note) {
        this._note = _note;
    }

    public String getComment() {
        return _comment;
    }

    public void setComment(String _comment) {
        this._comment = _comment;
    }
    
}
