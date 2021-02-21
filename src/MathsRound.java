import java.util.ArrayList;

public class MathsRound {

    private ArrayList<String> operations;

    public MathsRound() {

        operations = new ArrayList<>();
        operations.add("+");
        operations.add("-");
        operations.add("*");
        operations.add("/");
    }

    public String calc(ArrayList<Integer> numbers, int target) {

        return recursiveFunc(numbers, target);
    }

    public String recursiveFunc(ArrayList<Integer> numbers, int target) {

        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i+1; j < numbers.size(); j++) {
                if (i != j) {
                    for (int k = 0; k < 4; k++) {
                        String str = splitTree(this.operations.get(k), numbers, i, j, target);

                        if (str != null) {
                            return str;
                        }
                    }
                }
            }
        }
        return null;
    }


    private String splitTree(String operation, ArrayList<Integer> numbers, int indexOne, int indexTwo, int target) {

        String str = "(" + numbers.get(indexOne) + " " + operation + " " + numbers.get(indexTwo) + ")";

        int res = calculateOperation(operation, numbers.get(indexOne), numbers.get(indexTwo));
        if (res == 0) {
            return null;
        } else if (res == target) {
            return str + " = " + res;
        } else {
            ArrayList<Integer> someNumbers = new ArrayList<>();

            someNumbers.add(res);

            for (int l = 0; l < numbers.size(); l++) {
                if (indexOne != l && indexTwo != l) {
                    someNumbers.add(numbers.get(l));
                }
            }

            String recStr = recursiveFunc(someNumbers, target);

            if(recStr != null) {
                return str + " = " + res + "\n " + recStr;
            }

            return null;
        }
    }


    /**
     * Temporary to try each operation in a compact way
     * @param first first number
     * @param second second number
     * @return list of results from each operation
     */
    private ArrayList<Integer> testEachOperation(int first, int second) {
        ArrayList<Integer> result = new ArrayList<>();

        result.add(calculateOperation("+", first, second));
        result.add(calculateOperation("-", first, second));
        result.add(calculateOperation("*", first, second));
        result.add(calculateOperation("/", first, second));

        result.add(calculateOperation("-", second, first));
        result.add(calculateOperation("/", second, first));

        return result;
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
                if (result < 0) {
                    result = 0;
                }
                break;
            case "*":
                result = first * second;
                break;
            case "/":
                if((first % second) == 0) {
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