public class CzescZamienna {

    String nrSeryjny, nazwa;
    private Model model;

    public CzescZamienna(String nrSeryjny, String nazwa){
        this.nazwa=nazwa;
        this.nrSeryjny=nrSeryjny;
    }

    public String getNrSeryjny() {
        return nrSeryjny;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setModel(Model model) {
        if(this.model == model) return;
        if(this.model != null) {
            this.model.removeCzescZamienna(this);
        }
        this.model = model;
        if(model != null) {
            model.addCzescZamienna(this);
        }
    }

    public String toString(){
        return "Część zamienna:\tnr seryjny: "+nrSeryjny+", nazwa: "+nazwa;
    }
}
