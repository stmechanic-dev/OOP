package service;

public class Service {

    private final String SPACE_DELIMITER = " ";
    private final String DELIMITER_VALUE = ";";

    private MemRepository memRepository;

    private DataBaseRepository dataBaseRepository;

    public Service(MemRepository memRepository) {
        this.memRepository = memRepository;
    }

    public Service(DataBaseRepository dataBaseRepository) {
        this.dataBaseRepository = dataBaseRepository;
    }

    public void getOnlyName() {
        for (String string : memRepository.findAll()) {
            System.out.println(string.split(SPACE_DELIMITER)[0]);
        }
    }

    public void getOnlyNameFromDataBase() {
        for (String string : dataBaseRepository.findAll()) {
            System.out.println(string.split(DELIMITER_VALUE)[1].split(SPACE_DELIMITER)[0]);
        }
    }
}
