import Helpers.SilnikType;

import java.util.Calendar;

public class Samochod {
    private String marka, model, nrSeryjny;
    private Calendar rokProdukcji;
    private SilnikType silnikType;
    private Silnik silnik;
    private boolean czyUszkodzony;
    private Double spalanie;

    public Samochod(String marka, String model, String nrSeryjny, Calendar rokProdukcji, boolean czyUszkodzony){
        this.marka=marka;
        this.model=model;
        this.nrSeryjny=nrSeryjny;
        this.rokProdukcji=rokProdukcji;
        this.czyUszkodzony=czyUszkodzony;
    }
    public Samochod(String marka, String model, String nrSeryjny, Calendar rokProdukcji, SilnikType silnikType, boolean czyUszkodzony){
        this.marka=marka;
        this.model=model;
        this.nrSeryjny=nrSeryjny;
        this.rokProdukcji=rokProdukcji;
        this.silnikType=silnikType;
        this.czyUszkodzony=czyUszkodzony;
        switch(silnikType){
            case BENZYNOWY:
                this.silnik = new Benzynowy(spalanie);
                break;
            case ELEKTRYCZNY:
                this.silnik = new Elektryczny();
                break;
            case NONE:
                this.silnik = null;
        }
    }
    public Samochod(String marka, String model, String nrSeryjny, Calendar rokProdukcji, SilnikType silnikType, Double spalanie, boolean czyUszkodzony){
        this.marka=marka;
        this.model=model;
        this.nrSeryjny=nrSeryjny;
        this.rokProdukcji=rokProdukcji;
        this.silnikType=silnikType;
        this.czyUszkodzony=czyUszkodzony;
        this.spalanie=spalanie;
        switch(silnikType){
            case BENZYNOWY:
                this.silnik = new Benzynowy(spalanie);
                break;
            case ELEKTRYCZNY:
                this.silnik = new Elektryczny();
                break;
            case NONE:
                this.silnik = null;
        }
    }

    public String getMarka() {
        return marka;
    }

    public String getModel() {
        return model;
    }

    public String getNrSeryjny() {
        return nrSeryjny;
    }

    public String getRokProdukcji(){
        if (rokProdukcji==null){
            return "brak";
        } else{
            return String.format("%1$tY", this.rokProdukcji);
        }
    }

    public void napraw(){
        if(czyUszkodzony){
            this.czyUszkodzony=false;
            System.out.println("Naprawiono");
        }else {
            System.out.println("Samochód już naprawiony");
        }
    }

    public SilnikType getSilnikType() {
        return silnikType;
    }

    public boolean CzyUszkodzony() {
        return czyUszkodzony;
    }

    public String getSpalanie(){
        if(this.spalanie==null){
            return "brak";
        } else {
            return String.valueOf(this.spalanie);
        }
    }

    public String toString(){
        return "Samochód: "+getMarka()+" "+getModel()+", nr: "+getNrSeryjny()+", rok produkcji: "+getRokProdukcji()+", silnik: "+getSilnikType();
    }


}
