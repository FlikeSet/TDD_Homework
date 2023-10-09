public class Main {
    //task3
    public static double calculateY(double x) {
        if (x > 3.4) {
            return Math.sin(x) * Math.log(x);
        } else {
            return Math.pow(Math.cos(x), 2);
        }
    }
    //task4
    public static int calculateStepCount(double start, double end, double step) {
        if (start > end || step <= 0) {
            throw new IllegalArgumentException("Некоректні вхідні дані");
        }

        return (int) Math.ceil((end - start) / step) + 1;
    }
    //task5
    public static double[] calculateYArray(double start, double end, double step) {
        int stepCount = calculateStepCount(start, end, step);
        double[] yArray = new double[stepCount];
        for (int i = 0; i < stepCount; i++) {
            double x = start + i * step;
            yArray[i] = calculateY(x);
        }
        return yArray;
    }
    //task5
    public static double[] calculateXArray(double start, double end, double step) {
        int stepCount = calculateStepCount(start, end, step);
        double[] xArray = new double[stepCount];
        for (int i = 0; i < stepCount; i++) {
            xArray[i] = start + i * step;
        }
        return xArray;
    }


    //task6
    public static int findIndexOfMax(double[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Масив пустий");
        }
        int maxIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    //task6
    public static int findIndexOfMin(double[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Масив пустий");
        }
        int minIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }
    //task6
    public static double calculateSum(double[] array) {
        double sum = 0;
        for (double value : array) {
            sum += value;
        }
        return sum;
    }
    //task6
    public static double calculateAverage(double[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Масив пустий");
        }
        double sum = calculateSum(array);
        return sum / array.length;
    }
    //task7
    public static void printMaxAndMinValues(double[] yArray, double[] xArray) {
        int indexOfMax = findIndexOfMax(yArray);
        int indexOfMin = findIndexOfMin(yArray);

        double maxX = xArray[indexOfMax];
        double maxY = yArray[indexOfMax];
        double minX = xArray[indexOfMin];
        double minY = yArray[indexOfMin];

        System.out.printf("Найбільший елемент масиву y знаходиться за x = %.3f , y = %.3f%n", maxX, maxY);
        System.out.printf("Найменший елемент масиву y знаходиться за x = %.3f, y = %.3f%n ", minX, minY);
    }
    //task8
    public static void main(String[] args) {
        double start = 2.0;
        double end = 5.0;
        double step = 0.005;

        double[] xArray = calculateXArray(start, end, step);
        double[] yArray = calculateYArray(start, end, step);

        System.out.println("Масиви значень x та y для 5 перших елементів:");
        int n = Math.min(5, xArray.length);
        for (int i = 0; i < n; i++) {
            System.out.printf("x[%d] = %.3f, y[%d] = %.3f%n", i, xArray[i], i, yArray[i]);
        }

        System.out.println("Тестові номери для х:");
        System.out.printf("x[%d] = %.3f, y[%d] = %.3f%n", 0, xArray[0], 0, yArray[0]);
        System.out.printf("x[%d] = %.3f, y[%d] = %.3f%n", 280, xArray[280], 280, yArray[280]);
        System.out.printf("x[%d] = %.3f, y[%d] = %.3f%n", 600, xArray[600], 600, yArray[600]);

        printMaxAndMinValues(yArray, xArray);

        double sumOfY = calculateSum(yArray);
        double averageOfY = calculateAverage(yArray);

        System.out.printf("Сума елементів масиву y: %.3f%n", sumOfY);
        System.out.printf("Середнє арифметичне елементів масиву y: %.3f%n", averageOfY);
    }
}
