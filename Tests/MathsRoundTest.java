import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathsRoundTest {

    private MathsRound mr;

    @BeforeEach
    void beforeEach() {
        mr = new MathsRound();
    }

    @Test
    void calc() {
    }

    @Test
    void pairMaker() {
    }

    @Test
    void calculateOperation() {
        Assertions.assertEquals(6, mr.calculateOperation("+", 4, 2));
        Assertions.assertEquals(2, mr.calculateOperation("-", 4, 2));
        Assertions.assertEquals(8, mr.calculateOperation("*", 4, 2));
        Assertions.assertEquals(2, mr.calculateOperation("/", 4, 2));
    }
}