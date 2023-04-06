import java.util.Calendar;

public class Main {

    // zwykla: jedna faktura - wiele napraw
    // z atrybutem: pracownik - naprawa - atrybutem bedzie data przydzielenia do naprawy i ew data oddzielenia od naprawy
    // kwalifikowana:  czesc zamienna - model - szukanie czesci zamiennej w modelu po nazwie tej czesci,
    // kompozycja: marka - model - model nie moze istniec bez marki

    //z atrybutem klasa laczaca musi miec 1-1 a klasy zewnetrzne posiadac listy
    //kwalifikowana musi szukac po kluczu a nie po wartosci - poprawione
    //kompozycja obsluzyc nulla w klasach

    public static void main(String[] args) {

        // przykladowe dane
        Calendar c = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        Calendar c3 = Calendar.getInstance();
        c.set(2018, 11, 9);
        c2.set(2018, 11, 13);
        c3.set(2018, 11, 16);

        //faktury
        Faktura f1 = new Faktura(c);
        Faktura f2 = new Faktura(c2);
        Faktura f3 = new Faktura(c3);

        //naprawy
        Naprawa n1 = new Naprawa(c);
        Naprawa n2 = new Naprawa();
        Naprawa n3 = new Naprawa();

        //pracownicy
        c.set(Calendar.YEAR, 2012);
        Pracownik p1 = new Pracownik("Jan", "Kowalski", c);
        c.set(Calendar.MONTH, 3);
        c.set(Calendar.DAY_OF_MONTH, 3);
        Pracownik p2 = new Pracownik("Kamil", "Woźniak", c);
        c.set(Calendar.MONTH, 6);
        c.set(Calendar.DAY_OF_MONTH, 28);
        Pracownik p3 = new Pracownik("Stefan", "Żarko", c);

        //marki
        c.set(Calendar.YEAR, 2016);
        Marka mr1 = new Marka("Ford");
        Marka mr2 = null;
        Marka mr3 = new Marka("Honda");

        //modele
            Model m1 = new Model("s1", mr1, "Escort", c);
            Model m2 = null;
            Model m3 = new Model("s3", mr1, "Fiesta", c);
            Model m4 = new Model("s4", mr1, "Focus", c);
            Model m5 = new Model("s5", mr3, "s2000", c);


        // asocjacja zwykla: * napraw - 1 faktura

        System.out.println("\tDziałania na asocjacji zwykłej");

        // wiele napraw do jednej faktury
        n1.setFaktura(f1);
        n2.setFaktura(f1);
        n3.setFaktura(f2);

        // proba przydzielenia jednej naprawy wielu fakturom
        n3.setFaktura(f2);
        n3.setFaktura(f3);

       for(Faktura faktura: Faktura.getFaktury()){
           System.out.println(faktura);
       }

        // asocjacja z atrybutem: 1 naprawa - * pracownikow

        System.out.println("\tDziałania na asocjacji z atrybutem");

        Pracownik[] arr1 = {p1, p2};
        Pracownik[] arr2 = {p3};

        PracownikNaprawa pn1 = new PracownikNaprawa(c, arr1, n1);
        PracownikNaprawa pn2 = new PracownikNaprawa(c2, arr2, n2);

        System.out.println(pn1);
        System.out.println(pn2);

        // asocjacja kwalifikowana: 1 model - wiele czesci zamiennych

        System.out.println("\tDziałania na asocjacji kwalifikowanej");

        CzescZamienna cz1 = new CzescZamienna("s111", "Tłumik");
        CzescZamienna cz2 = new CzescZamienna("s112", "Panewka");
        CzescZamienna cz3 = new CzescZamienna("s113", "Lusterko boczne");

        m1.addCzescZamienna(cz1);
        m1.addCzescZamienna(cz2);

        try {
            System.out.println(m1.getCzescZamienna("Panewka"));
            System.out.println(m1.getCzescZamienna("Turbo"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // kompozycja: 1 marka - * modeli

        System.out.println("\n\tDzialania na kompozycji");

        try{
            System.out.println("Próba dodania modelu bez marki");
            m2 = new Model("s2", mr2, "Escort", c); //Kompozycja - czesc nie istnieje bez calosci
        } catch(Exception e){
            System.out.println("Error - kompozycja - model musi miec swoja marke");
        }

        // usuwanie marki - czesc tez zostanie usunieta
            System.out.println("\nUsuwanie marki - całości");
            System.out.println("przed usunieciem marki - cala ekstencja modeli");
            for(Model model: Model.getModele()){
                System.out.println(model.toString());
            }
            Marka.removeMarka(mr1);
            System.out.println("po usunieciu marki - cala ekstencja modeli");
            for(Model model: Model.getModele()){
                System.out.println(model.toString());
            }



    }
}
