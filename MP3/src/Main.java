import Helpers.IKlient;
import Helpers.PracownikType;
import Helpers.SilnikType;

import java.util.Calendar;

public class Main {

    // poprawic overlapping - enumsety zamiast recznego sprawdzania

    // klasa abstrakcyjna: osoba i dziedziczace Klient i Pracownik: metoda wypiszDane
    // overlapping: Mechanik boze byc jednoczesnie testerem jakosci
    // wielodziedziczenie: pracujacy klient
    // wieloaspektowe: samochod > rozdzielamy po typie np. sportowy, miejski i silniku np. Elektryczny, Benzynowy
    // dynamiczne: mechanik moze sie stac kierownikiem zmiany

    public static void main(String[] args) throws Exception {
        Calendar c = Calendar.getInstance();
        c.set(2018, 11, 9);
        Samochod samochodDoNaprawienia = new Miejski("Ford", "Focus", "s1", c, SilnikType.ELEKTRYCZNY, true, 'a');

        // klasa abstrakcyjna z przeslaniana metoda: Osoba > klient, pracownik

        Osoba k1 = new Klient("Jan", "Kowalski", "123 123 123");
        Osoba p1 = new Pracownik("Zbigniew", "Maciejewski", "123 456 789", c, PracownikType.MECHANIK);

        System.out.println("\tAbstract");
        System.out.println(k1);
        System.out.println(p1);

        // przeslanianie metody
        k1.napraw(samochodDoNaprawienia);
        p1.napraw(samochodDoNaprawienia);

        // overlapping: Mechanik moze byc jednoczesnie testerem jakosci
        System.out.println("\tOverlapping");

        Pracownik nullPracownik = null;
        try {
            nullPracownik.becomeTester();
        } catch (Exception e) {
            System.out.println("Część bez całości");
        }
        Pracownik multiPracownik = new Pracownik(
                "Gabriel",
                "Narutowicz",
                "999 999 999",
                c,
                PracownikType.TESTERJAKOSCI_MECHANIK
        );

        System.out.println(multiPracownik);

        // lub przydzielanie tytulu istniejacemu pracownikowi

        Pracownik multiPracownik2 = new Pracownik("Roman", "Dmowski", "321 321 321", c, PracownikType.TESTERJAKOSCI);
        multiPracownik2.becomeMechanik();
        System.out.println(multiPracownik2);

        // wielodziedziczenie: pracownik moze byc klientem
        // implementuje IKlient
        System.out.println("\tWielodziedziczenie");
        Pracownik pracujacyKlient = new PracujacyKlient("Mariusz", "Dźwigała", "111 111 111", c, PracownikType.KIEROWNIK, 15);
        PracujacyKlient pracujacyKlient2 = new PracujacyKlient("Wincenty", "Witos", "111 111 111", c, PracownikType.MECHANIK, 5);
        IKlient pracujacyKlient3 = new PracujacyKlient("Konstanty", "Lubomirski", "111 111 111", c, PracownikType.TESTERJAKOSCI, 10);

        pracujacyKlient2.setRabat(10);
        System.out.println(pracujacyKlient);
        pracujacyKlient.napraw(samochodDoNaprawienia);
        System.out.println(pracujacyKlient2);
        System.out.println(pracujacyKlient3);

        // dziedziczenie wieloaspektowe

        Samochod s1 = new Sportowy("Toyota", "Supra", "s1111", c, SilnikType.BENZYNOWY, 12.1, true, false);
        Samochod s2 = new Miejski("Toyota", "Prius", "s1112", c, SilnikType.ELEKTRYCZNY, true, 'c');
        System.out.println("\tWieloaspektowe");
        System.out.println(s1);
        System.out.println(s2);

        // dynamic: mechanik moze sie stac kierownikiem zmiany
        System.out.println("\tDynamic");

        Pracownik p2 = new Pracownik("Józef", "Piłsudski", "123 456 789", c, PracownikType.MECHANIK);
        Pracownik p3 = new Pracownik("Wojciech", "Korfanty", "123 456 789", c, PracownikType.TESTERJAKOSCI);

        System.out.println("Przed zmiana:");
        System.out.println(p2);
        System.out.println(p3);

         // obsluga dynamic
        p2.stopBeingMechanik();
        p2.becomeTester();
        p3.becomeKierownik();

        System.out.println("Po zmianie:");
        System.out.println(p2);
        System.out.println(p3);

    }
}
