import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    //3
    public void testCalculationFuncMethod() {

        double x1 = 4.0;
        double expectedY1 = Math.sin(x1) * Math.log(x1);

        double x2 = 3.4;
        double expectedY2 = Math.pow(Math.cos(x2), 2);

        double x3 = 3.0;
        double expectedY3 = Math.pow(Math.cos(x3), 2);

        assertEquals(expectedY1, Main.calculateY(x1), 0.0001);
        assertEquals(expectedY2, Main.calculateY(x2), 0.0001);
        assertEquals(expectedY3, Main.calculateY(x3), 0.0001);
    }

    @Test
    //4
    public void testCalculateStepCount() {
        assertEquals(601, Main.calculateStepCount(2.0, 5.0, 0.005));
        assertEquals(1, Main.calculateStepCount(2.0, 2.0, 0.005));
        assertEquals(2, Main.calculateStepCount(2.0, 2.005, 0.005));

        try {
            Main.calculateStepCount(5.0, 2.0, 0.005);
        } catch (IllegalArgumentException e) {
            assertEquals("Некоректні вхідні дані", e.getMessage());
        }

        try {
            Main.calculateStepCount(2.0, 5.0, -0.005);
        } catch (IllegalArgumentException e) {
            assertEquals("Некоректні вхідні дані", e.getMessage());
        }
    }
    @Test
    //5
    public void testCalculateYArray() {
        double[] expectedYArray = {
                Math.pow(Math.cos(3.395), 2),
                Math.pow(Math.cos(3.4), 2),
                Math.sin(3.405) * Math.log(3.405)
        };
        double[] yArray = Main.calculateYArray(3.395, 3.405, 0.005);
        assertArrayEquals(expectedYArray, yArray, 0.0001);
    }

    @Test
    //5
    public void testCalculateXArray() {
        double[] expectedXArray = {2.0, 2.005, 2.010, 2.015, 2.020, 2.025};
        double[] xArray = Main.calculateXArray(2.0, 2.025, 0.005);
        assertArrayEquals(expectedXArray, xArray, 0.0001);
    }

    @Test
    //6
    public void testFindIndexOfMax() {
        double[] array = {2.0, 2.005, 2.010, 2.015, 2.020};
        int maxIndex = Main.findIndexOfMax(array);
        assertEquals(4, maxIndex);
    }

    @Test
    //6
    public void testFindIndexOfMin() {
        double[] array = {2.0, 2.005, 2.010, 2.015, 2.020};
        int minIndex = Main.findIndexOfMin(array);
        assertEquals(0, minIndex);
    }

    @Test
    //6
    public void testCalculateSum() {
        double[] array = {2.0, 2.005, 2.010, 2.015, 2.020};
        double sum = Main.calculateSum(array);
        assertEquals(10.050, sum, 0.0001);
    }

    @Test
    //6
    public void testCalculateAverage() {
        double[] array = {2.0, 2.005, 2.010, 2.015, 2.020};
        double average = Main.calculateAverage(array);
        assertEquals(2.010, average, 0.0001);
    }
}
