package notesapp.service;

import notesapp.model.Note;
import notesapp.model.User;
import notesapp.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NoteServiceImpl /*implements NoteService*/ {

    /*private final UserService userService;
    private final NoteRepository noteRepository;

    @Autowired
    public NoteServiceImpl(UserService userService, NoteRepository noteRepository) {
        this.userService = userService;
        this.noteRepository = noteRepository;
    }

    @Override
    public List<Note> getNotesByUser(String userId) {
        User user = userService.findById(userId);
        return this.noteRepository.findByUser(user);
    }

    @Override
    public Note saveNote(String userId, Note note) {
        User user = this.userService.findById(userId);

        note.setId(null);
        note.setUser(user);
        note.setDate(new Date());

        return this.noteRepository.save(note);
    }

    @Override
    public Note findById(String id) {
        return noteRepository.findById(id);
    }

    @Override
    public Note updateNote(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public void deleteNote(Note note) {
        noteRepository.delete(note);
    }*/
}
