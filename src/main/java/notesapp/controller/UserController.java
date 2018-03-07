package notesapp.controller;

import notesapp.model.Note;
import notesapp.model.User;
import notesapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers(Principal principal) {
        return new ResponseEntity<>(userService.findAllUsers(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody @Valid User user) throws Exception {
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody @Valid User user) throws Exception{
            return new ResponseEntity<>(userService.updateUser(user), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteUser(@RequestBody @Valid User user) throws Exception {
        userService.deleteUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/{username}")
    public ResponseEntity<?> getUserByUsername(@PathVariable("username") String username) throws Exception {
        return new ResponseEntity<>(userService.findByUsername(username), HttpStatus.OK);
    }

    //Notes
    @GetMapping(value = "/{id}/notes")
    public ResponseEntity getNotesByUser(@PathVariable("id") String userId) throws Exception {
        return new ResponseEntity<>(userService.getNotesByUser(userId), HttpStatus.OK);
    }

    @GetMapping(value = "/{userId}/notes/{noteId}")
    public ResponseEntity<?> getNoteByUser(@PathVariable("userId") String userId,
                                           @PathVariable("noteId") int noteId) throws Exception {
        return new ResponseEntity<>(userService.getNoteByUser(userId, noteId), HttpStatus.OK);
    }

    @PostMapping(value = "/{id}/notes", consumes = "application/json")
    public ResponseEntity addNote(@PathVariable("id") String userId, @RequestBody @Valid Note note) throws Exception {
        return new ResponseEntity<>(userService.addNote(userId, note) ,HttpStatus.CREATED);
    }



    /*
    @PutMapping(value = "/notes",headers = "Accept=application/json")
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