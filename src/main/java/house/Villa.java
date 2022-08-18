package house;

public class Villa extends House {

    private Residents[] residents;

    public Villa(Foundation foundation) {
        super(foundation);
    }

    public void setResidents(Residents[] residents) {
        this.residents = residents;
    }
}
