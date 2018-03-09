package notesapp.service;

import notesapp.exception.EntityNotFoundException;
import notesapp.model.Note;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NoteService {

    List<Note> getNotesByUser(String userName) throws EntityNotFoundException;

    Note addNote(String userName, Note note) throws EntityNotFoundException;

    Note updateNote(String userName, Note note) throws EntityNotFoundException;

    void deleteNote(String userName, String noteId) throws EntityNotFoundException;

    Note getNoteByUser(String userName, String noteId) throws EntityNotFoundException;



}
