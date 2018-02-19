package lessons.lesson4.adapter;

public class RoundableSquareAdapter   implements Roundable  {
    private Square square;
    // имплементируем интерфейс круглого вызовом метода объекта адаптируемого класса

    public double getRadius() {
        return square.getSide() * Math.sqrt(2)/2;
    }
    public RoundableSquareAdapter(Square square) {
        this.square = square;
    }
}
