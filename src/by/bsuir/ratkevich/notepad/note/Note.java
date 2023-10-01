package by.bsuir.ratkevich.notepad.note;

import java.util.Date;

public class Note {

    private String topic;

    private Date dateOfCreation;

    private String email;

    private String text;

    public Note (String topic, Date dateOfCreation, String email, String text) {

        this.topic = topic;
        this.dateOfCreation = dateOfCreation;
        this.email = email;
        this.text = text;
    }

    public void setTopic (String topic ){

        this.topic = topic;
    }

    public void setDate (Date dateOfCreation) {

        this.dateOfCreation = dateOfCreation;
    }

    public void setEmail (String email) {

        this.email = email;
    }

    public void setText (String text) {

        this.text = text;
    }

    public String getTopic () {

        return topic;
    }

    public Date getDateOfCreation () {

        return dateOfCreation;
    }

    public String getEmail () {

        return email;
    }

    public String getText () {

        return text;
    }

    @Override
    public boolean equals (Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Note note = (Note) o;

        return note.getTopic().equals(topic)
                && note.getDateOfCreation().equals(dateOfCreation)
                && note.getEmail().equals(email)
                && note.getText().equals(text);
    }

    @Override
    public int hashCode () {

        return 13*17*topic.hashCode()*text.hashCode();
    }

    @Override
    public String toString() {

        return topic+", "+dateOfCreation+", "+ text+ "\n";
    }
}
