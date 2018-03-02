package notesapp.repository;

import notesapp.model.Note;
import notesapp.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface NoteRepository extends MongoRepository<Note, String> {

    Note findById(String id);
    List<Note> findByUser(User user);
}
