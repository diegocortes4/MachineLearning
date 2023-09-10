import org.apache.commons.math3.analysis.function.Constant;
import org.apache.commons.math3.analysis.function.HarmonicOscillator;
import org.apache.commons.math3.analysis.function.Log;
import org.apache.commons.math3.analysis.function.Sigmoid;
import org.apache.commons.math3.analysis.function.Sqrt;
import org.apache.commons.math3.analysis.function.Tan;

public class MachineLearningExample {

    public static void main(String[] args) {
        // Sample input data
        double[] x = {1.0, 2.0, 3.0, 4.0, 5.0};
        double[] y = {2.0, 4.0, 6.0, 8.0, 10.0};

        // Perform linear regression
        double[] coefficients = performLinearRegression(x, y);

        // Print the linear regression result
        System.out.println("Linear Regression Equation: y = " + coefficients[0] + "x + " + coefficients[1]);
    }

    // Perform linear regression using the least squares method
    public static double[] performLinearRegression(double[] x, double[] y) {
        int n = x.length;

        // Calculate the sums needed for the slope and intercept formulas
        double sumX = 0;
        double sumY = 0;
        double sumXY = 0;
        double sumX2 = 0;

        for (int i = 0; i < n; i++) {
            sumX += x[i];
            sumY += y[i];
            sumXY += x[i] * y[i];
            sumX2 += x[i] * x[i];
        }

        // Calculate the slope (m) and intercept (b)
        double slope = (n * sumXY - sumX * sumY) / (n * sumX2 - sumX * sumX);
        double intercept = (sumY - slope * sumX) / n;

        double[] coefficients = {slope, intercept};
        return coefficients;
    }
}
