package notesapp.service;

import notesapp.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<User> findAllUsers();

    User createUser(User user);

    User updateUser(User user);

    void deleteUser(User user);

    User findByUsername(String username);

    User findById(String id);
}
