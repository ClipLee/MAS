import java.util.ArrayList;
import java.util.Calendar;

class Pracownik {

    int id = 0;
    private static int recordsNo = 0;
    String imie, nazwisko, nrTelefonu;
    static int pensja = 4000;
    Calendar dataZatrudnienia, dataZwolnienia;

    private static ArrayList<Pracownik> pracownicy = new ArrayList<>(); // ekstensja

    PracownikNaprawa pracownikNaprawa;

    public Pracownik(String imie, String nazwisko, Calendar dataZatrudnienia){
        id = ++recordsNo;
        this.imie=imie;
        this.nazwisko=nazwisko;
        this.dataZatrudnienia=dataZatrudnienia;
        pracownicy.add(this);
    }

    public void setNaprawa(PracownikNaprawa pracownikNaprawa) {
        if(this.pracownikNaprawa == pracownikNaprawa) return;
        if(this.pracownikNaprawa != null) {
            this.pracownikNaprawa.removePracownik(this);
        }
        this.pracownikNaprawa = pracownikNaprawa;
        if(pracownikNaprawa != null) {
            pracownikNaprawa.addPracownik(this);
        }
    }

    public String getdataZatrudnieniaString(){
        return String.format("%1$te.%1$tm.%1$tY", this.dataZatrudnienia);
    }


    @Override
    public String toString(){
        return "Pracownik:\t" + id+ ": " + imie + " " + nazwisko + " - data zatrudnienia: " + this.getdataZatrudnieniaString() + ", nr telefonu: " + nrTelefonu + ", pensja: " + pensja;
    }

}
