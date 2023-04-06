import java.util.*;

public class Naprawa {
    private int id = 0;
    private static int recordsNo = 0;
    private Calendar dataNaprawy;
    private Faktura faktura;
    private PracownikNaprawa pracownikNaprawa;
    private Model model;

    private static List<Naprawa> naprawy = new ArrayList<>(); // ekstensja
    private Map<String, Model> modele = new HashMap<>(); // asocjacja kwalifikowana


    public Naprawa (){
        id = ++recordsNo;
        naprawy.add(this);
    }
    public Naprawa(Calendar dataNaprawy){
        id = ++recordsNo;
        this.dataNaprawy=dataNaprawy;
        naprawy.add(this);
    }

    public void setDataNaprawy(Calendar dataNaprawy){
        this.dataNaprawy=dataNaprawy;
    }

    public void setFaktura(Faktura faktura) {
        if(this.faktura == faktura) return;
        if(this.faktura != null) {
            this.faktura.removeNaprawa(this);
        }
        this.faktura = faktura;
        if(faktura != null) {
            faktura.addNaprawa(this);
        }
    }

    public String getdataNaprawyString(){
        if(dataNaprawy==null) {
            return "brak";
        } else{
            return String.format("%1$te.%1$tm.%1$tY", this.dataNaprawy);
        }
    }

    public String toString(){
        return "Naprawa:\tid: "+id+", data naprawy: "+this.getdataNaprawyString();
    }

}
