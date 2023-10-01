package by.bsuir.ratkevich.notepad.note;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Comparator;

public class NoteHandler {

    private ArrayList<Note> notes;

    private String fileName = "notes.txt";

    public NoteHandler () {

        notes = new ArrayList<>();
        readNotesFromFile();
    }

    public ArrayList<Note> getNotes () {

        return notes;
    }

    public void addNote (Note note) {

        notes.add(note);
        writeNoteToFile(note);
    }

    public void readNotesFromFile() {

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

        String topic;
        Date dateOfCreation;
        String email;
        String text;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            String [] buffer;

            while ((line = reader.readLine()) != null) {

                buffer = line.split("\\|");

                topic = buffer[0];
                dateOfCreation = formatter.parse(buffer[1]);
                email = buffer[2];
                text = buffer[3];

                notes.add(new Note (topic, dateOfCreation, email, text));
            }

        } catch (IOException | ParseException e) {

        }
    }

    public void writeNoteToFile (Note note) {

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {

            String date = formatter.format(note.getDateOfCreation());

            writer.write(note.getTopic() + "|" + date+ "|" + note.getEmail() + "|" + note.getText() + "\n");

        } catch (IOException e) {

        }
    }

    public ArrayList<Note> findNotesByTopic (String topic) {

        sortNotes();

        ArrayList<Note> matchedNotes = new ArrayList <> ();

        for (Note note: notes) {

            if (note.getTopic().equals(topic)) {
                matchedNotes.add(note);
            }
        }
        return matchedNotes;
    }

    public ArrayList<Note> findNotesByEmail (String email) {

        sortNotes();

        ArrayList<Note> matchedNotes = new ArrayList <> ();

        for (Note note: notes) {

            if (note.getEmail().equals(email)) {
                matchedNotes.add(note);
            }
        }
        return matchedNotes;
    }

    public ArrayList<Note> findNotesByText (String text) {

        sortNotes();

        ArrayList<Note> matchedNotes = new ArrayList <> ();

        for (Note note: notes) {

            if (note.getText().equals(text)) {
                matchedNotes.add(note);
            }
        }
        return matchedNotes;
    }

    public ArrayList<Note> findNotesByWord (String word) {

        sortNotes ();

        ArrayList<Note> matchedNotes = new ArrayList <> ();

        for (Note note: notes) {

            if (note.getText().contains(word)) {
                matchedNotes.add(note);
            }
        }
        return matchedNotes;
    }


    public void sortNotes () {

        notes.sort(Comparator.comparing (Note :: getTopic));
    }

}
