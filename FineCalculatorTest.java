import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class FineCalculatorTest {

    @Test
    public void testNoFine() {
        FineCalculator calc = new FineCalculator();
        int days = 0;
        double expected = 0;
        double actual = calc.calculate(days);
        assertEquals(expected, actual, 0.01);
    }

    @Test
    public void testNormalFine() {
        FineCalculator calc = new FineCalculator();
        int days = 5;
        double expected = 25000;
        double actual = calc.calculate(days);
        assertEquals(expected, actual, 0.01);
    }

    @Test
    public void testHeavyFine() {
        FineCalculator calc = new FineCalculator();
        int days = 11;
        double expected = 66000;
        double actual = calc.calculate(days);
        assertEquals(expected, actual, 0.01);
    }
}
// Test case bổ sung 1: Đúng mốc 10 ngày (không cộng 20%) -> 10 * 5000 = 50000
    @Test
    public void testExactTenDaysFine() {
        // 1. Arrange
        FineCalculator calc = new FineCalculator();
        int days = 10;
        double expected = 50000;

        // 2. Act
        double actual = calc.calculate(days);

        // 3. Assert
        assertEquals(expected, actual, 0.01);
    }

    // Test case bổ sung 2: Số ngày quá hạn là số âm (trả sách trước hạn) -> 0đ
    @Test
    public void testNegativeDaysFine() {
        // 1. Arrange
        FineCalculator calc = new FineCalculator();
        int days = -2;
        double expected = 0;

        // 2. Act
        double actual = calc.calculate(days);

        // 3. Assert
        assertEquals(expected, actual, 0.01);
    }
