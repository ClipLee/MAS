import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Faktura {
    private int nrFaktury = 0;
    private static int recordsNo = 0;
    private Calendar dataWystawienia;

    private List<Naprawa> naprawy = new ArrayList<Naprawa>();

    private static List<Faktura> faktury = new ArrayList<>();

    public Faktura(Calendar dataWystawienia){
        nrFaktury = ++recordsNo;
        this.dataWystawienia=dataWystawienia;
        faktury.add(this);
    }

    public void addNaprawa(Naprawa naprawa) {
        if(!naprawy.contains(naprawa)) {
            naprawy.add(naprawa);
            naprawa.setFaktura(this);
        }
    }

    public void removeNaprawa(Naprawa naprawa){
        if(naprawy.contains(naprawa)) {
            naprawy.remove(naprawa);
            naprawa.setFaktura(null);
        }
    }

    public static List<Faktura> getFaktury() {
        return faktury;
    }

    public String getdataWystawieniaString(){
        return String.format("%1$te.%1$tm.%1$tY", this.dataWystawienia);
    }

    public String toString(){
        String ret = "Faktura nr "+nrFaktury+", data wystawienia faktury: "+this.getdataWystawieniaString()+"\n";
        for(Naprawa naprawa: naprawy){
            ret += naprawa.toString()+"\n";
        }
        return ret;
    }


}
