package notesapp.service;

import notesapp.exception.EntityAlreadyExistsException;
import notesapp.exception.EntityNotFoundException;
import notesapp.exception.ValidationException;
import notesapp.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<User> findAllUsers();

    User createUser(User user) throws EntityAlreadyExistsException;

    User updateUser(User user) throws ValidationException, EntityNotFoundException, EntityAlreadyExistsException;

    void deleteUser(User user) throws ValidationException, EntityNotFoundException;

    User findByUsername(String username) throws EntityNotFoundException;
}
