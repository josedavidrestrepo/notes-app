package notesapp.controller;

import notesapp.model.User;
import notesapp.service.UserService;
import notesapp.util.CustomErrorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT, headers = "Accept=application/json")
    public ResponseEntity<?> updateUser(@RequestBody User user) {

        if (user.getId() == null || user.getId().isEmpty())
            return new ResponseEntity<>(new CustomErrorType("id is required"), HttpStatus.BAD_REQUEST);

        if (user.getUsername() == null || user.getUsername().isEmpty())
            return new ResponseEntity<>(new CustomErrorType("username is required"), HttpStatus.BAD_REQUEST);

        if (userService.findById(user.getId()) == null)
            return new ResponseEntity<>(new CustomErrorType("The user was not found in the DB"), HttpStatus.NOT_FOUND);

        if (userService.findByUsername(user.getUsername()) != null)
            return new ResponseEntity<>(new CustomErrorType("The username is already taken"), HttpStatus.BAD_REQUEST);

        if (userService.updateUser(user) != null)
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(new CustomErrorType("An exception occurred"), HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @RequestMapping(method = RequestMethod.DELETE, headers = "Accept=application/json")
    public ResponseEntity<?> deleteUser(@RequestBody User user) {
        if (user.getId() == null || user.getId().isEmpty())
            return new ResponseEntity<>(new CustomErrorType("id is required"), HttpStatus.BAD_REQUEST);

        if (userService.findById(user.getId()) == null)
            return new ResponseEntity<>(new CustomErrorType("The user was not found in the DB"), HttpStatus.NOT_FOUND);

        userService.deleteUser(user);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public ResponseEntity<?> getUserByUsername(@PathVariable("username") String username) {

        User user = userService.findByUsername(username);

        if (user == null) {
            return new ResponseEntity<>(new CustomErrorType("User with username " + username + " not found"), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}