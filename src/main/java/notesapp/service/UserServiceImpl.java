package notesapp.service;

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
    public User createUser(User user) {
        if (findByUsername(user.getUsername()) != null)
            throw new ;

        if (userService.saveUser(user) != null)
            return new ResponseEntity<>(HttpStatus.CREATED);

        user.setId(null);
        return userRepository.insert(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findById(String id)
    {
        return userRepository.findById(id);
    }
}
