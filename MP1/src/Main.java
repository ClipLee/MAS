
import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class Main {

    static File file = new File("./src/data/extent.data");

    public static void main(String[] args) {

        if (!file.exists()) {
            new Pracownik("Jan", "Kowalski", new Date(1999, 2, 23));
            new Pracownik("Adam", "Malysz", new Date(2011, 9, 3), "7 312 000");
            new Pracownik("John", "Snow", new Date(2023, 4, 17));
            new Pracownik("Jerzy", "Trener", new Date(1998, 2, 19), "999 998 997");

            new Kierownik("Kuba", "Kangur", new Date(2010, 10, 3), "854 123 054");
            new Kierownik("Volodymyr", "Zelenski", new Date(1996, 3, 15), "382 566 333");

        } else {
            // odczyt z pliku
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));

                Pracownik.odczytajEkstensje(objectInputStream);

                objectInputStream.close();

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        // wyswietlanie calej ekstensji
        Pracownik.pokazEkstensje();

        System.out.println("\nPensja brutto pracownika: " + Pracownik.pensja);
        System.out.println("Wyliczenie pensji netto pracownika: " + Pracownik.getByIndex(0).getPensjaNetto());

        System.out.println("Premia dla " + Pracownik.getByIndex(1).imie + " " + Pracownik.getByIndex(1).nazwisko + ": "
                + Pracownik.getByIndex(1).premia);
        Pracownik.getByIndex(0).premia = 100;
        System.out.println(
                "Premia dla " + Pracownik.getByIndex(0).imie + " " + Pracownik.getByIndex(0).nazwisko + ": "
                        + Pracownik.getByIndex(0).premia);

        // przyznanie uprawnien pracownikowi
        Uprawnienia u1 = new Uprawnienia(1, "Koparka");
        Uprawnienia u2 = new Uprawnienia(2, "Odbior zamowienia");
        ArrayList<Uprawnienia> uprawnienia = new ArrayList<>();
        uprawnienia.add(u1);
        uprawnienia.add(u2);
        Pracownik.getByIndex(0).uprawnienia = uprawnienia;
        System.out.println(
                "\nUprawnieniadla dla: " + Pracownik.getByIndex(0).imie + " " + Pracownik.getByIndex(0).nazwisko
                        + "\n" + Pracownik.getByIndex(0).uprawnienia);

        // zapisywanie do pliku
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            Pracownik.zapiszEkstensje(objectOutputStream);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
