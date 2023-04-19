import Helpers.IKlient;

public class Klient extends Osoba {

    int rabat;

    public Klient(String imie, String nazwisko, String nrTelefonu) {
        super(imie, nazwisko, nrTelefonu);
    }
    public Klient(String imie, String nazwisko, String nrTelefonu, int rabat) {
        super(imie, nazwisko, nrTelefonu);
        this.rabat=rabat;
    }

    public String getRabat(){
        if(rabat==0){
            return "brak";
        } else{
            return Integer.toString(this.rabat)+"%";
        }
    }

    public void setRabat(int rabat) {
        this.rabat = rabat;
    }

    @Override
    public void napraw(Samochod samochod) {
        if(samochod.CzyUszkodzony()) {
            System.out.println("Oddaj samochód do warsztatu");
        }else{
            System.out.println("Nie ma potrzeby naprawiać tego samochodu");
        }
    }

    @Override
    public String toString(){
        return "Klient: "+getImie()+" "+getNazwisko()+" - "+getNrTelefonu()+", rabat: "+getRabat();
    }




}
