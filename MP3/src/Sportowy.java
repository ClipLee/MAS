import Helpers.SilnikType;

import java.util.Calendar;

public class Sportowy extends Samochod{
    private boolean czyKabriolet;

    public Sportowy(String marka, String model, String nrSeryjny, Calendar rokProdukcji, boolean czyUszkodzony, boolean czyKabriolet) {
        super(marka, model, nrSeryjny, rokProdukcji, czyUszkodzony);
        this.czyKabriolet=czyKabriolet;
    }
    public Sportowy(String marka, String model, String nrSeryjny, Calendar rokProdukcji, SilnikType silnikType, boolean czyUszkodzony, boolean czyKabriolet) {
        super(marka, model, nrSeryjny, rokProdukcji, silnikType, czyUszkodzony);
        this.czyKabriolet=czyKabriolet;
    }
    public Sportowy(String marka, String model, String nrSeryjny, Calendar rokProdukcji, SilnikType silnikType, Double spalanie, boolean czyUszkodzony, boolean czyKabriolet) {
        super(marka, model, nrSeryjny, rokProdukcji, silnikType, spalanie, czyUszkodzony);
        this.czyKabriolet=czyKabriolet;
    }

    public String getCzyKabriolet(){
        if(czyKabriolet){
            return "Tak";
        }
        return "Nie";
    }

    @Override
    public String toString(){
        return "Samochód Sportowy: "+getMarka()+" "+getModel()+", nr: "+getNrSeryjny()+", rok produkcji: "+getRokProdukcji()+", silnik: "+getSilnikType()+", kabriolet: "+getCzyKabriolet()+", spalanie: "+getSpalanie();
    }
}
