import javax.swing.*;
import java.util.ArrayList;

public class main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MathsRound mathsRound = new MathsRound();

            ArrayList<Integer> ints = new ArrayList<Integer>();
            ints.add(1);
            ints.add(2);
            ints.add(3);
            ints.add(4);
            ints.add(5);
            ints.add(6);

            mathsRound.calc(ints, 100);
        });
    }
}
