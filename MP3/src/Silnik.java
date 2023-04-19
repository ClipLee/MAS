public abstract class Silnik {
    Double spalanie;

    public Silnik(){}
    public Silnik(Double spalanie) {
        this.spalanie = spalanie;
    }

    public abstract Double getSpalanie();
}
