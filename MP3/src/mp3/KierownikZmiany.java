package mp3;

import mp3.Helpers.PartWithoutTheWholeException;

public class KierownikZmiany {

    private static int premiaDodatkowa = 400;
    private Pracownik pracownik;

    public KierownikZmiany(Pracownik pracownik) {
        if (pracownik == null)
            throw new PartWithoutTheWholeException();
        this.pracownik = pracownik;
    }

}
