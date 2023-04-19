import Helpers.SilnikType;

import java.util.Calendar;

public class Miejski extends Samochod{
    private char klasaPojazdu;

    public Miejski(String marka, String model, String nrSeryjny, Calendar rokProdukcji, boolean czyUszkodzony, char klasaPojazdu) {
        super(marka, model, nrSeryjny, rokProdukcji, czyUszkodzony);
        this.klasaPojazdu=klasaPojazdu;
    }

    public Miejski(String marka, String model, String nrSeryjny, Calendar rokProdukcji, SilnikType silnikType, boolean czyUszkodzony, char klasaPojazdu) {
        super(marka, model, nrSeryjny, rokProdukcji, silnikType,  czyUszkodzony);
        this.klasaPojazdu=klasaPojazdu;
    }
    public Miejski(String marka, String model, String nrSeryjny, Calendar rokProdukcji, SilnikType silnikType, Double spalanie, boolean czyUszkodzony, char klasaPojazdu) {
        super(marka, model, nrSeryjny, rokProdukcji, silnikType, spalanie,  czyUszkodzony);
        this.klasaPojazdu=klasaPojazdu;
    }

    public char getKlasaPojazdu() {
        return klasaPojazdu;
    }

    @Override
    public String toString(){
        return "Samochód Miejski: "+getMarka()+" "+getModel()+", nr: "+getNrSeryjny()+", rok produkcji: "+getRokProdukcji()+", silnik: "+getSilnikType()+", klasa pojazdu: "+getKlasaPojazdu()+", spalanie: "+getSpalanie();
    }

}
