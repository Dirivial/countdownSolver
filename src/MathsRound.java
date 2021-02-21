import java.util.ArrayList;

public class MathsRound {


    public MathsRound() {}

    public boolean calc(ArrayList<Integer> numbers, int target) {

        ArrayList<IntegerPair> pairs = pairMaker(numbers);
        for (IntegerPair pair : pairs) {
            System.out.println(pair.toString());
        }


        return false;
    }
    
    public ArrayList<IntegerPair> pairMaker(ArrayList<Integer> numbers) {
        ArrayList<IntegerPair> pairs = new ArrayList<>(); 
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i+1; j < numbers.size(); j++) {
                pairs.add(new IntegerPair(numbers.get(i), numbers.get(j)));
            }
        }
        return pairs;
    }


    /**
     * Calculate a mathematical operation
     * @param operation operation to use
     * @param first first number
     * @param second second number
     * @return result of calculation
     */
    public int calculateOperation(String operation, int first, int second) {
        int result;
        switch (operation) {
            case "+":
                result = first + second;
                break;
            case "-":
                result = first - second;
                break;
            case "*":
                result = first * second;
                break;
            case "/":
                if(first % second == 0) {
                    result = first / second;
                } else {
                    result = 0;
                }
                break;
            default:
                result = 0;
        }
        return result;
    }

}