package notesapp.service;

import notesapp.model.Note;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NoteService {

    List<Note> getNotesByUser(String userId);

    Note saveNote(String userId, Note note);

    Note findById(String id);

    Note updateNote(Note note);

    void deleteNote(Note note);

}
