import Helpers.IKlient;
import Helpers.PracownikType;

import java.util.Calendar;

public class PracujacyKlient extends Pracownik implements IKlient {

    private int rabat;

    public PracujacyKlient(String imie, String nazwisko, String nrTelefonu, Calendar dataZatrudnienia, PracownikType type) {
        super(imie, nazwisko, nrTelefonu, dataZatrudnienia, type);
    }

    public PracujacyKlient(String imie, String nazwisko, String nrTelefonu, Calendar dataZatrudnienia, PracownikType type, int rabat) {
        super(imie, nazwisko, nrTelefonu, dataZatrudnienia, type);
        this.rabat=rabat;
    }

    @Override
    public String getRabat(){
        if(rabat==0){
            return "brak";
        } else{
            return Integer.toString(this.rabat)+"%";
        }
    }

    @Override
    public void setRabat(int rabat) {
        this.rabat=rabat;
    }

    @Override
    public String toString(){
        return "Pracujący klient: "+getImie()+" "+getNazwisko()+" - "+getNrTelefonu()+", data zatrudnienia: "+getDataZatrudnienia()+", rabat: "+getRabat();
    };
}
