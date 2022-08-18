package house;

public class Mansion extends House {

    private Residents[] residents;

    public Mansion(Foundation foundation) {
        super(foundation);
    }

    public void setResidents(Residents[] residents) {
        this.residents = residents;
    }
}
