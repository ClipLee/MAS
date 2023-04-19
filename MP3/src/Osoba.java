public abstract class Osoba {
    String imie, nazwisko, nrTelefonu;

    public Osoba(String imie, String nazwisko, String nrTelefonu) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nrTelefonu = nrTelefonu;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getNrTelefonu() {
        return nrTelefonu;
    }

    public abstract String toString();

    public abstract void napraw(Samochod samochod);
}
