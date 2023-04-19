
public class TesterJakosci {

    Pracownik pracownik;

    public TesterJakosci(Pracownik pracownik) throws Exception{
        if(pracownik == null)
            throw new Exception("Część nie może istnieć bez całości");
        this.pracownik = pracownik;
    }

}
