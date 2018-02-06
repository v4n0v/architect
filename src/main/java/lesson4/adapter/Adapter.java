package lesson4.adapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Adapter {
    // данность, набор окружностей, реализуют интерфейс Roundable, имеют радиус
    final static  List<Circle> circles = Arrays.asList(new Circle(1), new Circle(2), new
            Circle(3));
    // другая данность, набор квадратов, просто квадраты и все
    final static List<Square> squares = Arrays.asList(new Square(1), new Square(2), new
            Square(3));
    final static List<Object> circlesAndSquares = new ArrayList<Object>();

    public static void main(String[] args) {
        circlesAndSquares.addAll(circles);
        circlesAndSquares.addAll(squares);
// используем безымянный класс кастомного компаратора
        circlesAndSquares.sort(new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                return Double.compare(
                        asRoundable(o1).getRadius(), asRoundable(o2).getRadius()
                );
            }
            // приведение типа
            private Roundable asRoundable(Object o) {
                if(o instanceof Roundable)
                    return (Roundable)o;
                if(o instanceof Square)
                    return new RoundableSquareAdapter((Square) o);
                throw new InternalError("unexpected type");
            }
        });
        System.out.println(circlesAndSquares);
    }
}
