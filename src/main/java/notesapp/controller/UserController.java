package notesapp.controller;

import notesapp.model.User;
import notesapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<>(userService.findAllUsers(), HttpStatus.OK);
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<?> createUser(@RequestBody @Valid User user) throws Exception {
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    @PatchMapping(consumes = "application/json")
    public ResponseEntity<?> updateUser(@RequestBody @Valid User user) throws Exception{
            return new ResponseEntity<>(userService.updateUser(user), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") String id) throws Exception {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getUser(@PathVariable("id") String id) throws Exception {
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

}