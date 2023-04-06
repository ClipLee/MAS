import java.util.*;

public class Model {
    String nazwa, nrSeryjny;
    Calendar dataProdukcji;
    Marka marka; // kompozycja licznosc 1

    private Map<String, CzescZamienna> czesciZamienne = new HashMap<>(); // asocjacja kwalifikowana

    private static List<Model> modele = new ArrayList<>(); // ekstensja

    public Model(String nrSeryjny, Marka marka, String nazwa, Calendar dataProdukcji){
        this.nrSeryjny=nrSeryjny;
        this.marka=marka;
        this.nazwa=nazwa;
        this.dataProdukcji=dataProdukcji;
        setMarka(marka);
        modele.add(this);
    }

    public static boolean removeModel(Model model) throws Exception{
        if(model == null || !modele.contains(model))
            return false;
        if(model.getMarka().hasModel(model)){
            modele.remove(model);
            model.getMarka().removeModel(model);
            return true;
        }
        return false;
    }

    public Marka getMarka(){
        return this.marka;
    }

    //Obs�uga kompozycji

    public void setMarka(Marka marka){
        this.marka = marka;
        marka.addModel(this);
    }

    public static List<Model> getModele() {
        return modele;
    }

    // obsluga asocjacji kwalifikowanej

    public void addCzescZamienna(CzescZamienna cz) {
        if(!czesciZamienne.containsKey(cz)) {
            czesciZamienne.put(cz.nazwa, cz);
            cz.setModel(this);
        }
    }

    public void removeCzescZamienna(CzescZamienna cz) {
        if(czesciZamienne.containsValue(cz)) {
            czesciZamienne.remove(cz.nazwa);
            cz.setModel(null);
        }
    }

    public CzescZamienna getCzescZamienna(String name) throws Exception{
        if(!czesciZamienne.containsKey(name)) {
            throw new Exception("Nie znaleziono części zamiennej: " + name);
        }
        return czesciZamienne.get(name);
    }


    public String getDataProdukcjiString(){
        return String.format("%1$tY", this.dataProdukcji);
    }



    public String toString(){
        return "Model:\tnr seryjny: "+nrSeryjny+", marka: "+marka.getNazwa()+", nazwa: "+nazwa+", data produkcji: "+getDataProdukcjiString();
    }

}
