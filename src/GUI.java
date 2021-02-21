import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GUI extends JFrame {


    private MathWorker mathWorker;
    private JTextArea result;

    public GUI() {
        this.mathWorker = new MathWorker(this);


        this.setTitle("Countdown Solver");
        this.setLayout(new BorderLayout());
        initialize();

        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(300, 300));
        this.pack();
        this.setVisible(true);
    }


    public void showResult(String result) {
        this.result.setText(result);
    }


    private void initialize() {
        JButton button = new JButton("New calculation");
        button.addActionListener(ae -> this.askForInput());

        this.result = new JTextArea("");
        this.result.setEditable(false);
        this.add(result, BorderLayout.CENTER);
        this.add(button, BorderLayout.NORTH);

        askForInput();
    }

    private void askForInput() {

        JPanel numbersPanel = new JPanel();
        JPanel fullPanel = new JPanel();
        numbersPanel.setLayout(new GridLayout(2, 3, 5, 5));
        fullPanel.setLayout(new BorderLayout());
        fullPanel.add(numbersPanel, BorderLayout.CENTER);

        JTextField one = new JTextField(5);
        JTextField two = new JTextField(5);
        JTextField three = new JTextField(5);
        JTextField four = new JTextField(5);
        JTextField five = new JTextField(5);
        JTextField six = new JTextField(5);

        numbersPanel.add(one);
        numbersPanel.add(two);
        numbersPanel.add(three);
        numbersPanel.add(four);
        numbersPanel.add(five);
        numbersPanel.add(six);

        JTextField target = new JTextField(10);
        fullPanel.add(new JLabel("Target:"), BorderLayout.NORTH);
        fullPanel.add(target, BorderLayout.NORTH);

        int result = JOptionPane.showConfirmDialog(null, fullPanel,
                "Please Enter Target and Numbers", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            ArrayList<Integer> numbers = new ArrayList<>();
            numbers.add(Integer.parseInt(one.getText()));
            numbers.add(Integer.parseInt(two.getText()));
            numbers.add(Integer.parseInt(three.getText()));
            numbers.add(Integer.parseInt(four.getText()));
            numbers.add(Integer.parseInt(five.getText()));
            numbers.add(Integer.parseInt(six.getText()));

            this.mathWorker.setNumbers(numbers, Integer.parseInt(target.getText()));
            this.mathWorker.run();
            this.mathWorker = new MathWorker(this);
        }
    }


    /**
     * Send an error message to the user
     * @param message message to the user
     */
    public void sendErrorMessage(String message) {
        JFrame f = new JFrame();
        JOptionPane.showMessageDialog(f, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
