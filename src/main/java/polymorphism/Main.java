package polymorphism;

public class Main {

    public static void main(String[] args) {
        Car[] cars = {
                new Toyota("Atmosphere 2.4"),
                new Mazda("Hibrid 1.2"),
                new KIA("Atmosphere 1.6")
        };

        for (Car car : cars) {
            System.out.println(car.getEngine());
        }
    }
}
