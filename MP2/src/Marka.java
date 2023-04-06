import java.util.ArrayList;
import java.util.List;

public class Marka {
    // kompozycja - model nie istnieje bez marki
    String nazwa;
    private List<Model> modele = new ArrayList<>(); // kompozycja licznosc *

    private static List<Marka> marki = new ArrayList<>(); // ekstensja

    public Marka(String nazwa){
        this.nazwa=nazwa;
        marki.add(this);
    }

    // obsluga kompozycji
    public List<Model> getModels(){
        return this.modele;
    }

    public void addModel(Model model) {
        if(!modele.contains(model)) {
            modele.add(model);
            model.setMarka(this);
        }

    }

    public boolean removeModel(Model model){
        if(model != null && hasModel(model)){
            try {
                Model.removeModel(model);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.modele.remove(model);
            return true;
        }
        return false;
    }

    public boolean hasModel(Model model){
        return this.modele.contains(model);
    }

    public String getNazwa() {
        return nazwa;
    }

    public static boolean removeMarka(Marka marka) {
        if(!marki.contains(marka))
            return false;
        List<Model> modeleKopia = new ArrayList<Model>();
        for(Model model : marka.getModels()){
            modeleKopia.add(model);
        }
        for(Model model : modeleKopia){
            marka.removeModel(model);
        }
        return marki.remove(marka);
    }

    public static List<Marka> getMarki() {
        return marki;
    }

    @Override
    public String toString() {
        String ret = "Marka:\t "+nazwa+"\n";
        for(Model model: modele){
            ret += model+"\n";
        }
        return ret;
    }
}