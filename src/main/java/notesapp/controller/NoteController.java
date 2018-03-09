package notesapp.controller;

import notesapp.exception.EntityNotFoundException;
import notesapp.model.Note;
import notesapp.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequestMapping(value = "/notes")
public class NoteController {


    private final NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping
    public ResponseEntity getNotes(Principal principal) throws Exception {
        return new ResponseEntity<>(noteService.getNotesByUser(principal.getName()), HttpStatus.OK);
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity addNote(Principal principal, @RequestBody @Valid Note note) throws EntityNotFoundException {
        return new ResponseEntity<>(noteService.addNote(principal.getName(), note), HttpStatus.CREATED);
    }

    @PatchMapping(consumes = "application/json")
    public ResponseEntity modifyNote(Principal principal, @RequestBody @Valid Note note) throws EntityNotFoundException{
        return new ResponseEntity<>(noteService.updateNote(principal.getName(), note), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteNote(Principal principal, @PathVariable("id") String id) throws EntityNotFoundException{
        noteService.deleteNote(principal.getName(), id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getNoteById(Principal principal, @PathVariable("id") String id) throws EntityNotFoundException {
        return new ResponseEntity<>(noteService.getNoteByUser(principal.getName(), id), HttpStatus.OK);
    }

}
