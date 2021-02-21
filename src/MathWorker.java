import javax.swing.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

public class MathWorker extends SwingWorker<String, Void> {

    private MathsRound mathsRound;
    private ArrayList<Integer> numbers;
    private Integer target;
    private GUI gui;

    public MathWorker(GUI gui) {
        this.mathsRound = new MathsRound();
        this.gui = gui;
    }

    public void setNumbers(ArrayList<Integer> numbers, Integer target) {
        this.numbers = numbers;
        this.target = target;
    }

    @Override
    protected String doInBackground() {

        String result = this.mathsRound.calc(this.numbers, this.target);

        return Objects.requireNonNullElse(result, "No path found");
    }

    @Override
    protected void done() {
        try {
            String str = get();

            this.gui.showResult(Objects.requireNonNullElse(str, "No path was found :("));
        } catch (InterruptedException | ExecutionException e) {
            this.gui.sendErrorMessage("Error");
        }
    }
}
