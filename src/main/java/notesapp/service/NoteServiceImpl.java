package notesapp.service;

import notesapp.exception.EntityNotFoundException;
import notesapp.model.Note;
import notesapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    private final UserService userService;

    @Autowired
    public NoteServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<Note> getNotesByUser(String userName) throws EntityNotFoundException {
        return userService.findByUsername(userName).getNotes();
    }

    @Override
    public Note addNote(String userName, Note note) throws EntityNotFoundException {
        User user = userService.findByUsername(userName);
        user.addNote(note);
        userService.saveUser(user);
        return note;
    }

    @Override
    public Note updateNote(String userName, Note note) throws EntityNotFoundException {
        User user = userService.findByUsername(userName);

        int i = 0;
        for (Note n : user.getNotes()) {
            if (n.getId().equals(note.getId())) {
                user.getNotes().set(i, note);
                userService.saveUser(user);
                return note;
            }
            i++;
        }
        throw new EntityNotFoundException("Note with id " + note.getId() + " was not found");
    }

    @Override
    public void deleteNote(String userName, String noteId) throws EntityNotFoundException {
        User user = userService.findByUsername(userName);

        if (!user.getNotes().removeIf(n -> n.getId().equals(noteId)))
            throw new EntityNotFoundException("Note with id " + noteId + " was not found");

        userService.saveUser(user);
    }

    @Override
    public Note getNoteByUser(String userName, String noteId) throws EntityNotFoundException {
        User user = userService.findByUsername(userName);

        for (Note n : user.getNotes()) {
            if (n.getId().equals(noteId))
                return n;
        }
        throw new EntityNotFoundException("Note with id " + noteId + " was not found");
    }
}
