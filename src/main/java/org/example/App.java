package org.example;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.util.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//import java.util.ArrayList;


public class App {
    public static File infile;
    public static Scanner input;
    public static String word;
    public static ArrayList<String> terminator;

    public static void main(String[] args) {
        format();
        export();
    }
    public static void format() {
        try {
            infile = new File("input.txt");
            input = new Scanner(infile);
            terminator = new ArrayList<>(Arrays.asList("Projektausschreibungen:", "Schulungen:", "Workshop:", "Sportevents:", "Bewerbungen:", "Anmeldungen:"));
            word = input.next();

            while (input.hasNext()) {
                switch (word) {
                    case "Projektausschreibungen", "Projektausschreibungen:" -> {
                        input.nextLine();
                        Projektausschreibungen(input);
                    }
                    case "Schulungen:" -> {
                        input.nextLine();
                        Schulungen(input);
                    }
                    case "Workshop:" -> {
                        input.nextLine();
                        Workshops(input);
                    }
                    case "Sportevents:" -> {
                        input.nextLine();
                        Sportevents(input);
                    }
                    case "Bewerbungen:" -> {
                        input.nextLine();
                        Bewerbungen(input);
                    }
                    case "Anmeldungen:" -> {
                        input.nextLine();
                        Anmeldungen(input);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void export (){
        Toll Projektausschreibungen = new Toll();
        Toll Schulungen = new Toll();
        Toll Workshops = new Toll();
        Toll Sportevents = new Toll();
        Toll Bewerbungen = new Toll();
        Toll Anmeldungen = new Toll();
        // region paths
        Projektausschreibungen.setPath("Projektausschreibungen.csv");
        Schulungen.setPath("Schulungen.csv");
        Workshops.setPath("Workshops.csv");
        Sportevents.setPath("Sportevents.csv");
        Bewerbungen.setPath("Bewerbungen.csv");
        Anmeldungen.setPath("Anmeldungen.csv");
        // endregion
        try {
            // region Readers
            Projektausschreibungen.setReader(Projektausschreibungen.path);
            Schulungen.setReader(Schulungen.path);
            Workshops.setReader(Workshops.path);
            Sportevents.setReader(Sportevents.path);
            Bewerbungen.setReader(Bewerbungen.path);
            Anmeldungen.setReader(Anmeldungen.path);
            // endregion
            // region Records
            Projektausschreibungen.setRecords();
            Schulungen.setRecords();
            Workshops.setRecords();
            Sportevents.setRecords();
            Bewerbungen.setRecords();
            Anmeldungen.setRecords();
            // endregion
            // region Listen
            ArrayList<Projektausschreibung> projektausschreibungen = new ArrayList<>();
            ArrayList<Schulung> schulungen = new ArrayList<>();
            ArrayList<Workshop> workshops = new ArrayList<>();
            ArrayList<Sportevent> sportevents = new ArrayList<>();
            ArrayList<Bewerbung> bewerbungen = new ArrayList<>();
            ArrayList<Anmeldung> anmeldungen = new ArrayList<>();
            // endregion
            // region Getters
            for (CSVRecord record : Projektausschreibungen.records) {
                Projektausschreibung projektausschreibung = new Projektausschreibung();

                projektausschreibung.setKunde(record.get(0));
                projektausschreibung.setProjektscope(record.get(1));
                projektausschreibung.setUmfang(Integer.parseInt(record.get(2)));
                projektausschreibung.setGesuchtePositionen(record.get(3));
                projektausschreibung.setBewerbungsfrist(record.get(4));

                projektausschreibungen.add(projektausschreibung);
            }
            for (CSVRecord record : Schulungen.records) {
                Schulung schulung = new Schulung();

                schulung.setTitel(record.get(0));
                schulung.setTrainer(record.get(1));
                schulung.setNiveau(record.get(2));
                schulung.setDatum(record.get(3));
                schulung.setZeit(record.get(4));
                schulung.setOrt(record.get(5));

                schulungen.add(schulung);
            }
            for (CSVRecord record : Workshops.records) {
                Workshop workshop = new Workshop();

                workshop.setAnbieter(record.get(0));
                workshop.setThema(record.get(1));
                workshop.setDatum(record.get(2));
                workshop.setZeit(record.get(3));
                workshop.setOrt(record.get(4));

                workshops.add(workshop);
            }
            for (CSVRecord record : Sportevents.records) {
                Sportevent sportevent = new Sportevent();

                sportevent.setTitel(record.get(0));
                sportevent.setMaximaleTeilnehmerzahl(Integer.parseInt(record.get(1)));
                sportevent.setDatum(record.get(2));
                sportevent.setZeit(record.get(3));
                sportevent.setOrt(record.get(4));

                sportevents.add(sportevent);
            }
            for (CSVRecord record : Bewerbungen.records) {
                Bewerbung bewerbung = new Bewerbung();

                bewerbung.setProjekt(Integer.parseInt(record.get(0)));
                bewerbung.setStand(record.get(1));

                bewerbungen.add(bewerbung);
            }
            for (CSVRecord record : Anmeldungen.records) {
                Anmeldung anmeldung = new Anmeldung();

                anmeldung.setEvent(Integer.parseInt(record.get(0)));
                anmeldung.setStand(record.get(1));

                anmeldungen.add(anmeldung);
            }
            // endregion
            // region Statements
            Connection con = dbconnection();

            PreparedStatement projektausschreibungenStatement;
            String projektausschreibungenSQL = "INSERT INTO projektausschreibungen(kunde, projektscope, umfang, gesuchtePositionen, bewerbungsfrist) VALUES (?, ?, ?, ?, ?)";
            projektausschreibungenStatement = con.prepareStatement(projektausschreibungenSQL);

            PreparedStatement schulungenStatement;
            String schulungenSQL = "INSERT INTO schulungen(titel, trainer, niveau, datum, zeit, ort) VALUES (?, ?, ?, ?, ?, ?)";
            schulungenStatement = con.prepareStatement(schulungenSQL);

            PreparedStatement workshopsStatement;
            String workshopsSQL = "INSERT INTO workshops(anbieter, thema, datum, zeit, ort) VALUES (?, ?, ?, ?, ?)";
            workshopsStatement = con.prepareStatement(workshopsSQL);

            PreparedStatement sporteventsStatement;
            String sporteventsSQL = "INSERT INTO sportevents(titel, maximaleTeilnehmerzahl, datum, zeit, ort) VALUES (?, ?, ?, ?, ?)";
            sporteventsStatement = con.prepareStatement(sporteventsSQL);

            PreparedStatement bewerbungenStatement;
            String bewerbungenSQL = "INSERT INTO bewerbungen(projekt, stand) VALUES (?, ?)";
            bewerbungenStatement = con.prepareStatement(bewerbungenSQL);

            PreparedStatement anmeldungenStatement;
            String anmeldungenSQL = "INSERT INTO anmeldungen(event, stand) VALUES (?, ?)";
            anmeldungenStatement = con.prepareStatement(anmeldungenSQL);
            // endregion
            // region Setters
            for (Projektausschreibung record : projektausschreibungen) {
                projektausschreibungenStatement.setString(1, record.getKunde());
                projektausschreibungenStatement.setString(2, record.getProjektscope());
                projektausschreibungenStatement.setInt(3, record.getUmfang());
                projektausschreibungenStatement.setString(4, record.getGesuchtePositionen());
                projektausschreibungenStatement.setString(5, record.getBewerbungsfrist());

                projektausschreibungenStatement.addBatch();
            }
            for (Schulung record : schulungen) {
                schulungenStatement.setString(1, record.getTitel());
                schulungenStatement.setString(2, record.getTrainer());
                schulungenStatement.setString(3, record.getNiveau());
                schulungenStatement.setString(4, record.getDatum());
                schulungenStatement.setString(5, record.getZeit());
                schulungenStatement.setString(6, record.getOrt());

                schulungenStatement.addBatch();
            }
            for (Workshop record : workshops) {
                workshopsStatement.setString(1, record.getAnbieter());
                workshopsStatement.setString(2, record.getThema());
                workshopsStatement.setString(3, record.getDatum());
                workshopsStatement.setString(4, record.getZeit());
                workshopsStatement.setString(5, record.getOrt());

                workshopsStatement.addBatch();
            }
            for (Sportevent record : sportevents) {
                sporteventsStatement.setString(1, record.getTitel());
                sporteventsStatement.setInt(2, record.getMaximaleTeilnehmerzahl());
                sporteventsStatement.setString(3, record.getDatum());
                sporteventsStatement.setString(4, record.getZeit());
                sporteventsStatement.setString(5, record.getOrt());

                sporteventsStatement.addBatch();
            }
            for (Bewerbung record : bewerbungen) {
                bewerbungenStatement.setInt(1, record.getProjekt());
                bewerbungenStatement.setString(2, record.getStand());

                bewerbungenStatement.addBatch();
            }
            for (Anmeldung record : anmeldungen) {
                anmeldungenStatement.setInt(1, record.getEvent());
                anmeldungenStatement.setString(2, record.getStand());

                anmeldungenStatement.addBatch();
            }
            // endregion
            // region execute
            projektausschreibungenStatement.executeBatch();
            schulungenStatement.executeBatch();
            workshopsStatement.executeBatch();
            sporteventsStatement.executeBatch();
            bewerbungenStatement.executeBatch();
            anmeldungenStatement.executeBatch();
            // endregion

            con.commit();
            con.close();
        } catch (SQLException | IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void Projektausschreibungen(Scanner input) {
        //  kunde, projektscope, umfang, gesuchtePositionen, bewerbungsfrist
        ArrayList<String[]> projektausschreibungen = new ArrayList<>();

        String[] values = new String[5];
        Arrays.fill(values, "");

        while (input.hasNext() && !App.terminator.contains(word)) {
            word = input.next();
            switch (word) {
                case "Kunde:" -> values[0] = readUntilChar(input, ',');
                case "Projektscope:" -> values[1] = readUntilChar(input, '.') + ".";
                case "Umfang:" -> {
                    word = input.next();
                    values[2] = word;
                }
                case "Gesuchte" -> {
                    word = input.next();
                    while (word.charAt(word.length() - 1) != '.') {
                        if (word.equals("PL") || word.equals("Pma") || word.equals("und") || word.matches("[0-9]")) {
                            values[3] += word + " ";
                        }
                        word = input.next();
                    }
                    if (word.equals("PL.") || word.equals("Pma.")) {
                        values[3] += word.substring(0, word.length() - 1);
                    }
                    if (values[3].startsWith("PL") || values[3].startsWith("Pma")) {
                        values[3] = "1 " + values[3];
                    }
                }
                case "Bewerbungsfrist:" -> {
                    word = input.next();
                    values[4] = word;

                    projektausschreibungen.add(values.clone());
                    Arrays.fill(values, "");
                }
            }
        }
        print(projektausschreibungen, "Projektausschreibungen");
    }
    public static void Schulungen(Scanner input) {
        //  titel, trainer, niveau, datum, zeit, ort
        ArrayList<String[]> schulungen = new ArrayList<>();
        boolean titel = true;

        String[] values = new String[6];
        Arrays.fill(values, "");
        word = "";

        while (input.hasNext() && !App.terminator.contains(word)) {
            if (titel) {
                String temp = input.next();
                if (App.terminator.contains(temp)){
                    word = temp;
                    break;
                }
                word = " ";
                values[0] = readUntilChar(input, ',');
                values[0] = temp + " " + values[0].substring(0, values[0].length() - 8);
                if (values[0].charAt(values[0].length()-1) == ' ')
                    values[0] = values[0].substring(0, values[0].length() - 1);
                titel = false;
            }
            word = input.next();

            switch (word) {
                case "Trainer:" -> values[1] = readUntilChar(input, ',');
                case "Niveau:" -> {
                    word = input.next();
                    switch (word) {
                        case "Anfänger,", "Fortgeschritten,", "Experte," -> values[2] = word.substring(0, word.length() - 1);
                    }
                }
                case "Datum" -> {
                    word = input.next();
                    word = input.next();
                    word = input.next();
                    values[3] = word;
                }
                case "Datum:" -> {
                    word = input.next();
                    values[3] = word;
                }
                case "Zeit:" -> {
                    word = input.next();
                    values[4] = word;
                }
                case "Ort:" -> {
                    word = input.nextLine();
                    values[5] = word.substring(1);
                    schulungen.add(values.clone());
                    Arrays.fill(values, "");
                    titel = true;
                }
            }
        }
        print(schulungen, "Schulungen");
    }
    public static void Workshops(Scanner input) {
        //  anbieter, thema, datum, zeit, ort
        ArrayList<String[]> workshops = new ArrayList<>();

        String[] values = new String[5];
        Arrays.fill(values, "");
        word = "";

        while (input.hasNext() && !App.terminator.contains(word)) {
            word = input.next();
            switch (word) {
                case "Von" -> values[0] = readUntilChar(input, ',');
                case "Thema:" -> values[1] = readUntilChar(input, ',');
                case "Datum:" -> {
                    word = input.next();
                    values[2] = word;
                }
                case "Zeit:" -> {
                    word = input.next();
                    values[3] = word;
                }
                case "Ort:" -> {
                    word = input.nextLine();
                    values[4] = word.substring(1);
                    workshops.add(values.clone());
                    Arrays.fill(values, "");
                }
            }
        }
        print(workshops, "Workshops");
    }
    public static void Sportevents(Scanner input) {
        //  titel, maximaleTeilnehmerzahl, datum, zeit, ort
        ArrayList<String[]> sportevents = new ArrayList<>();

        String[] values = new String[5];
        Arrays.fill(values, "");
        word = "";

        while (input.hasNext() && !App.terminator.contains(word)) {
            word = input.next();
            switch (word) {
                case "Titel:" -> values[0] = readUntilChar(input, ',');
                case "maximale" -> {
                    word = input.next();
                    word = input.next();
                    values[1] = word.substring(0, word.length() - 1);
                }
                case "Datum:" -> {
                    word = input.next();
                    values[2] = word.substring(0, word.length() - 1);
                }
                case "Zeit:" -> {
                    word = input.next();
                    values[3] = word.substring(0, word.length() - 1);
                }
                case "Ort:" -> {
                    word = input.nextLine();
                    values[4] = word.substring(1);
                    sportevents.add(values.clone());
                    Arrays.fill(values, "");
                }
            }
        }
        print(sportevents, "Sportevents");
    }
    public static void Bewerbungen(Scanner input) {
        //  Projekt, Stand
        ArrayList<String[]> bewerbungen = new ArrayList<>();

        String[] values = new String[2];
        Arrays.fill(values, "");
        word = "";

        while (input.hasNext() && !App.terminator.contains(word)) {
            word = input.next();
            switch (word) {
                case "Projekt:" -> {
                    word = input.next();
                    values[0] = word.substring(0, word.length() - 1);
                }
                case "Stand:" -> {
                    word = input.next();
                    switch (word) {
                        case "Angemerkt.", "Beworben.", "Abgelehnt." -> values[1] = word.substring(0, word.length() - 1);
                    }
                    bewerbungen.add(values.clone());
                    Arrays.fill(values, "");
                }
            }
        }
        print(bewerbungen, "Bewerbungen");
    }
    public static void Anmeldungen(Scanner input) {
        //  Event, Stand
        ArrayList<String[]> anmeldungen = new ArrayList<>();

        String[] values = new String[2];
        Arrays.fill(values, "");
        word = "";

        while (input.hasNext() && !App.terminator.contains(word)) {
            word = input.next();
            switch (word) {
                case "Event:" -> {
                    word = input.next();
                    values[0] = word.substring(0, word.length() - 1);
                }
                case "Stand:" -> {
                    word = input.next();
                    switch (word) {
                        case "Angemeldet." ->
                            values[1] = word.substring(0, word.length() - 1);
                        case "Nicht" -> {
                            word = input.next();
                            values[1] = "Nicht angemeldet";
                        }
                    }
                    anmeldungen.add(values.clone());
                    Arrays.fill(values, "");
                }
            }
        }
        print(anmeldungen, "Anmeldungen");
    }

    public static String readUntilChar(Scanner input, char c) {
        StringBuilder data = new StringBuilder();
        while (word.charAt(word.length() - 1) != c) {
            word = input.next();
            data.append(word).append(" ");
        }
        return data.substring(0, data.length() - 2);
    }
    public static void print(ArrayList<String[]> list, String header) {
        try {
            String fileName = header + ".csv";
            FileWriter writer = new FileWriter(fileName);
            switch (header) {
                case "Projektausschreibungen" -> writer.write("Kunde, Projektscope, Umfang, GesuchtePositionen, Bewerbungsfrist" + "\n");
                case "Schulungen" -> writer.write("Titel, Trainer, Niveau, Datum, Zeit, Ort" + "\n");
                case "Workshops" -> writer.write("Anbieter, Thema, Datum, Zeit, Ort" + "\n");
                case "Sportevents" -> writer.write("Titel, MaximaleTeilnehmerzahl, Datum, Zeit, Ort" + "\n");
                case "Bewerbungen" -> writer.write("Projekt, Stand" + "\n");
                case "Anmeldungen" -> writer.write("Event, Stand" + "\n");
            }
            for (String[] item : list) {
                String csv = Arrays.toString(item);
                writer.write(csv.substring(1, csv.length()-1) + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection dbconnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/juniter_einfuehrung", "root", "");
            System.out.println("connection sucessfull");
            connection.setAutoCommit(false);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
