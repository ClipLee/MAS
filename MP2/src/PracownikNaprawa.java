import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class PracownikNaprawa {

    Calendar dataRozpoczęcia;
    Calendar dataZakonczenia;

    // asocjacja z atrybutem: wiele pracowników - jedna naprawa
    // atrybut - dataRozpoczecia
    private List<Pracownik> pracownicy = new ArrayList<>();
    private Naprawa naprawa;

    public PracownikNaprawa(Calendar dataRozpoczęcia, Pracownik[] pracownik, Naprawa naprawa){
        this.dataRozpoczęcia=dataRozpoczęcia;
        this.naprawa=naprawa;
        for(int i=0; i<pracownik.length; i++){
            pracownicy.add(pracownik[i]);
        }
    }
    public void setDataZakonczenia(Calendar dataZakonczenia){
        this.dataZakonczenia=dataZakonczenia;
    }

    public void addPracownik(Pracownik pracownik){
        if(!pracownicy.contains(pracownik)) {
            pracownicy.add(pracownik);
            pracownik.setNaprawa(this);
        }
    }
    public void removePracownik(Pracownik pracownik){
        if(pracownicy.contains(pracownik)) {
            pracownicy.remove(pracownik);
            pracownik.setNaprawa(null);
        }
    }
    public void setNaprawa(Naprawa naprawa){
        this.naprawa=naprawa;
    }

    public List<Pracownik> getPracownicy(){
        return pracownicy;
    }

    public String getdataRozpoczeciaString(){
        return String.format("%1$te.%1$tm.%1$tY", this.dataRozpoczęcia);
    }

    public String toString(){
        String ret = "Pracownicy przy naprawie rozpoczętej: "+this.getdataRozpoczeciaString()+"\n"+naprawa.toString()+"\n";
        for(Pracownik pracownik: this.getPracownicy()){
            ret += pracownik + "\n";
        }
        return ret;
    }


}
