package notesapp.model;

import java.util.Date;

public class Note {

    private String id;
    private String text;
    private Date date;

    public Note() {
        super();
    }

    public Note(User user, String text, Date date) {
        this.text = text;
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
