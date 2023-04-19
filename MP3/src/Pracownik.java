import Helpers.PracownikType;

import java.util.Calendar;
import java.util.EnumSet;

public class Pracownik extends Osoba {

    private Calendar dataZatrudnienia;

    private Mechanik mechanik;
    private KierownikZmiany kierownikZmiany;
    private TesterJakosci testerJakosci;

    public Pracownik(String imie, String nazwisko, String nrTelefonu, Calendar dataZatrudnienia) {
        super(imie, nazwisko, nrTelefonu);
        this.dataZatrudnienia = dataZatrudnienia;
    }

    public Pracownik(String imie, String nazwisko, String nrTelefonu, Calendar dataZatrudnienia, PracownikType type) {
        super(imie, nazwisko, nrTelefonu);
        this.dataZatrudnienia=dataZatrudnienia;
        try {
            setPracownikType(type);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String getDataZatrudnienia(){
        if (dataZatrudnienia==null){
            return "brak";
        } else{
            return String.format("%1$te.%1$tm.%1$tY", this.dataZatrudnienia);
        }
    }

    // przeslanianie metod

    @Override
    public void napraw(Samochod samochod) {
        samochod.napraw();
    }


    // obsluga dziedziczenia dynamicznego i overlapping

    public void setPracownikType(PracownikType type) throws Exception {
        if(type == PracownikType.MECHANIK){
            this.mechanik = new Mechanik(this);
            this.kierownikZmiany = null;
            this.testerJakosci = null;
        } else if(type == PracownikType.KIEROWNIK){
            this.kierownikZmiany = new KierownikZmiany(this);
            this.mechanik = null;
            this.testerJakosci = null;
        } else if(type == PracownikType.TESTERJAKOSCI){
            this.testerJakosci = new TesterJakosci(this);
            this.mechanik = null;
            this.kierownikZmiany = null;
        } else if(type == PracownikType.TESTERJAKOSCI_MECHANIK){ // overlapping
            this.mechanik = new Mechanik(this);
            this.testerJakosci = new TesterJakosci(this);
            this.kierownikZmiany = null;
        } else{
            this.mechanik = null;
            this.kierownikZmiany = null;
            this.testerJakosci = null;
        }
    }

    public void becomeKierownik(){
        if(!isKierownik())
            this.kierownikZmiany = new KierownikZmiany(this);
    }
    public void stopBeingKierownik(){
        if(isKierownik())
            this.kierownikZmiany = null;
    }
    public void becomeMechanik(){
        if(!isMechanik())
            this.mechanik = new Mechanik(this);
    }
    public void stopBeingMechanik(){
        if(isMechanik())
            this.mechanik = null;
    }
    public void becomeTester() throws Exception {
        if(!isKierownik())
            this.testerJakosci = new TesterJakosci(this);
    }
    public void stopBeingTester(){
        if(isKierownik())
            this.testerJakosci = null;
    }

    public boolean isKierownik(){
        if(this.kierownikZmiany == null)
            return false;
        return true;
    }

    public boolean isMechanik(){
        if(this.mechanik == null)
            return false;
        return true;
    }

    public boolean isTester(){
        if(this.testerJakosci == null)
            return false;
        return true;
    }

    public String getPersonType(){
        return (isMechanik() ? "Mechanik, " : "") +
                (isKierownik() ? "Kierownik Zmiany, " : "") +
                (isTester() ? "Tester " : "") +
                ((!isMechanik() && !isKierownik() && !isTester()) ? "brak" : "");
    }

    @Override
    public String toString(){
        return "Pracownik: "+getImie()+" "+getNazwisko()+" - "+getNrTelefonu()+", data zatrudnienia: " + getDataZatrudnienia()+", tytuł: "+getPersonType();
    }




}
