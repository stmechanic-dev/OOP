package point;

public class PointService {
    /**
     * Метод вычисляет расстояние между двумя точками в думерном пространстве
     * @param firstPoint - первый объект типа Point точка с координатами
     * @param secondPoint - второй объект типа Point точка с координатами
     * @return возвращает расстояние между двумя точками в думерном пространстве в формате double
     */
    public double distance(Point firstPoint, Point secondPoint) {

        int firstCalculate = findSquareOfDifference(secondPoint.getxCoordinate(), firstPoint.getxCoordinate()) +
                             findSquareOfDifference(secondPoint.getyCoordinate(), firstPoint.getyCoordinate());


        return Math.sqrt(firstCalculate);
    }

    /**
     * Вспомогательный метод для обределения квадрата разности двух чисел
     * @param firstNumber - первое число
     * @param secondNumber - второе число
     * @return возвращет квадрат разности двух чисел
     */
    public int findSquareOfDifference(int firstNumber, int secondNumber) {
        int difference = firstNumber - secondNumber;

        return difference * difference;
    }
}
