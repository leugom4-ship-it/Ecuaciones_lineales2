package Ecuaciones_lineales.JACOBI;

public class MetodoJacobi {

    // Calcula el error máximo entre dos vectores
    public static double calcularError(double[] xAnterior, double[] xNuevo) {
        double maxError = 0.0;
        for (int i = 0; i < xAnterior.length; i++) {
            double error = Math.abs(xNuevo[i] - xAnterior[i]);
            if (error > maxError) {
                maxError = error;
            }
        }
        return maxError;
    }

    // Método de Jacobi
    public static double[] jacobi(double[][] A, double[] b,
                                  double[] xInicial, double tol, int maxIter) {
        int n = xInicial.length;
        double[] x = xInicial.clone();
        double[] xAnterior;

        for (int iter = 0; iter < maxIter; iter++) {
            xAnterior = x.clone();

            for (int i = 0; i < n; i++) {
                double suma = b[i];
                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        suma -= A[i][j] * xAnterior[j];
                    }
                }
                x[i] = suma / A[i][i];
            }

            if (calcularError(xAnterior, x) < tol) {
                System.out.println("Jacobi convergió en " + (iter + 1) + " iteraciones");
                return x;
            }
        }
        System.out.println("Jacobi llegó al límite de iteraciones");
        return x;
    }
}