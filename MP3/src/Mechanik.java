import Helpers.PartWithoutTheWholeException;

public class Mechanik {

    Pracownik pracownik;

    public Mechanik(Pracownik pracownik) {
        if(pracownik == null)
            throw new PartWithoutTheWholeException();
        this.pracownik = pracownik;
    }

}
