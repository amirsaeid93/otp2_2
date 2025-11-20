
import org.example.CodeAnalysis;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CodeAnalysisTest {

    @Test
    void testAdd() {
        assertEquals(5, CodeAnalysis.addValues(2, 3));
    }

    @Test
    void testSubtract() {
        assertEquals(1, CodeAnalysis.subtractValues(3, 2));
    }

    @Test
    void testMultiply() {
        assertEquals(6, CodeAnalysis.multiplyValues(2, 3));
    }

    @Test
    void testDivide() {
        assertEquals(2, CodeAnalysis.divideValues(6, 3));
    }
}

