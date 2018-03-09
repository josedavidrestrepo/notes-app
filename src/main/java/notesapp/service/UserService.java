package notesapp.service;

import notesapp.exception.EntityAlreadyExistsException;
import notesapp.exception.EntityNotFoundException;
import notesapp.exception.ValidationException;
import notesapp.model.Note;
import notesapp.model.User;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@Service
public interface UserService {

    List<User> findAllUsers();

    User createUser(User user) throws EntityAlreadyExistsException;

    User updateUser(User user) throws ValidationException, EntityNotFoundException, EntityAlreadyExistsException;

    void deleteUser(String userId) throws ValidationException, EntityNotFoundException;

    User findByUsername(String username) throws EntityNotFoundException;

    User findById(String userId) throws EntityNotFoundException;

    User saveUser(User user);
}
