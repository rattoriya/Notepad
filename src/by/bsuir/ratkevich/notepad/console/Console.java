package by.bsuir.ratkevich.notepad.console;

import by.bsuir.ratkevich.notepad.note.Note;
import by.bsuir.ratkevich.notepad.note.NoteHandler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Console {

    private NoteHandler noteHandler = new NoteHandler();

    public void consoleSearch () {

        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);

        menu();

        while (true) {

            int choice;

            System.out.println ("Enter your choice");

            while (!scanner.hasNextInt()) {

                System.out.println("Incorrect input! Try again");
                scanner.next();
            }
            choice = scanner.nextInt();

            scanner.nextLine();

            switch (choice) {

                case 1 :

                    if (!noteHandler.getNotes().isEmpty()) {

                        printNotes(noteHandler.getNotes());
                    }
                    else {

                        System.out.println ("The list is Empty");
                    }

                    break;

                case 2:

                    String topic;
                    String inputDateOfCreation;
                    Date dateOfCreation;
                    String email;
                    String text;

                    System.out.println ("Enter notes topic:");

                    while (!scanner.hasNextLine()) {
                        System.out.println("Incorrect input! Try again");
                        scanner.next();
                    }
                    topic = scanner.nextLine();

                    dateOfCreation = new Date();

                    System.out.println ("Enter notes email:");

                    while (!scanner.hasNextLine()) {
                        System.out.println("Incorrect input! Try again");
                        scanner.next();
                    }
                    email = scanner.nextLine();

                    System.out.println ("Enter notes text:");

                    while (!scanner.hasNextLine()) {
                        System.out.println("Incorrect input! Try again");
                        scanner.next();
                    }
                    text = scanner.nextLine();

                    noteHandler.addNote (new Note (topic, dateOfCreation, email, text));

                    System.out.println ("The note was successfully added to the list");


                    break;

                case 3:

                    System.out.println ("Enter notes topic:");

                    while (!scanner.hasNextLine()) {
                        System.out.println("Incorrect input! Try again");
                        scanner.next();
                    }
                    topic = scanner.nextLine();

                    printNotes (noteHandler.findNotesByTopic(topic));

                    break;

                case 4:

                    System.out.println ("Enter notes email:");

                    while (!scanner.hasNextLine()) {
                        System.out.println("Incorrect input! Try again");
                        scanner.next();
                    }
                    email = scanner.nextLine();

                    printNotes (noteHandler.findNotesByEmail(email));

                    break;

                case 5:

                    System.out.println ("Enter notes text:");

                    while (!scanner.hasNextLine()) {
                        System.out.println("Incorrect input! Try again");
                        scanner.next();
                    }
                    text = scanner.nextLine();

                    printNotes (noteHandler.findNotesByText(text));

                    break;

                case 6:

                    String word;

                    System.out.println ("Enter notes word:");

                    while (!scanner.hasNextLine()) {
                        System.out.println("Incorrect input! Try again");
                        scanner.next();
                    }
                    word = scanner.nextLine();

                    printNotes (noteHandler.findNotesByWord (word));

                    break;

                case 7:  return;
            }

        }

    }

    public void menu () {

        System.out.println("**********Search***********");
        System.out.println("1 - display notes\n" +
                "2 - add note\n" +
                "3 - find notes by topic\n" +
                "4 - find notes by email\n" +
                "5 - find notes by text\n" +
                "6 - find note by word\n" +
                "7 - to quit from notepad");
    }

    public void printNotes (ArrayList<Note> notes) {

        for (Note note: notes) {

            System.out.println(note.toString());
        }
    }
}
