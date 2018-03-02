package notesapp.controller;

import notesapp.model.Note;
import notesapp.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NoteController {

    /*private final NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @RequestMapping(value = "/users/{id}/notes", method = RequestMethod.GET)
    public ResponseEntity getNotesByUser(@PathVariable("id") String userId) {
        List<Note> notes = noteService.getNotesByUser(userId);

        if (notes.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(notes, HttpStatus.OK);
    }

    @RequestMapping(value = "/users/{id}/notes", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity getNoteByUser(@PathVariable("id") String userId, @RequestBody Note note) {

        if (note.getText() == null || note.getText().isEmpty())
            return new ResponseEntity<>(new CustomErrorType("Note text is required"), HttpStatus.BAD_REQUEST);

        if (noteService.saveNote(userId, note) != null)
            return new ResponseEntity<>(HttpStatus.CREATED);
        else
            return new ResponseEntity<>(new CustomErrorType("An exception occurred"), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(value = "notes/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getNote(@PathVariable("id") String id) {

        Note note = noteService.findById(id);

        if (note == null) {
            return new ResponseEntity<>(new CustomErrorType("Note with id " + id + " not found"), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(note, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, headers = "Accept=application/json")
    public ResponseEntity<?> updateNote(@RequestBody Note note) {

        if (note.getId() == null || note.getId().isEmpty())
            return new ResponseEntity<>(new CustomErrorType("id is required"), HttpStatus.BAD_REQUEST);

        if (noteService.findById(note.getId()) == null)
            return new ResponseEntity<>(new CustomErrorType("The note was not found in the DB"), HttpStatus.NOT_FOUND);

        if (noteService.updateNote(note) != null)
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(new CustomErrorType("An exception occurred"), HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @RequestMapping(method = RequestMethod.DELETE, headers = "Accept=application/json")
    public ResponseEntity<?> deleteNote(@RequestBody Note note) {
        if (note.getId() == null || note.getId().isEmpty())
            return new ResponseEntity<>(new CustomErrorType("id is required"), HttpStatus.BAD_REQUEST);

        if (noteService.findById(note.getId()) == null)
            return new ResponseEntity<>(new CustomErrorType("The note was not found in the DB"), HttpStatus.NOT_FOUND);

        noteService.deleteNote(note);

        return new ResponseEntity<>(HttpStatus.OK);
    }*/

}
