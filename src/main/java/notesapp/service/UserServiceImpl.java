package notesapp.service;

import notesapp.exception.EntityAlreadyExistsException;
import notesapp.exception.EntityNotFoundException;
import notesapp.exception.ValidationException;
import notesapp.model.Note;
import notesapp.model.User;
import notesapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user) throws EntityAlreadyExistsException {
        if (userRepository.findByUsername(user.getUsername()) != null)
            throw new EntityAlreadyExistsException("The username is already taken");
        user.setId(null);
        return userRepository.insert(user);
    }

    @Override
    public User updateUser(User user) throws ValidationException, EntityNotFoundException, EntityAlreadyExistsException {
        if (user.getId() == null || user.getId().isEmpty())
            throw new ValidationException("id is required");
        if (userRepository.findById(user.getId()) == null)
            throw new EntityNotFoundException("The user was not found in the DB");
        if (userRepository.findByUsername(user.getUsername()) != null)
            throw new EntityAlreadyExistsException("The username is already taken");
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(String userId) throws ValidationException, EntityNotFoundException {
        if (userId == null || userId.isEmpty())
            throw new ValidationException("id is required");
        User user = userRepository.findById(userId);
        if (user == null)
            throw new EntityNotFoundException("The user was not found in the DB");
        userRepository.delete(user);
    }

    @Override
    public User findByUsername(String username) throws EntityNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null)
            throw new EntityNotFoundException("User with username " + username + " was not found");
        return user;
    }

    @Override
    public User findById(String userId) throws EntityNotFoundException {
        User user = userRepository.findById(userId);
        if (user == null)
            throw new EntityNotFoundException("User with id " + userId + " was not found");
        return user;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }


}
