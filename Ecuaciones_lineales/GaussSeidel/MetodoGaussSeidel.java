package Ecuaciones_lineales.GaussSeidel;

import static Ecuaciones_lineales.JACOBI.MetodoJacobi.calcularError;

public class MetodoGaussSeidel {

    public static double[] gaussSeidel(double[][] A, double[] b,
                                       double[] xInicial, double tol, int maxIter) {
        int n = xInicial.length;
        double[] x = xInicial.clone();

        for (int iter = 0; iter < maxIter; iter++) {
            double[] xAnterior = x.clone();

            for (int i = 0; i < n; i++) {
                double suma = b[i];

                // Usamos los valores ya calculados (j < i)
                for (int j = 0; j < i; j++) {
                    suma -= A[i][j] * x[j];
                }
                // Usamos los valores de la iteración anterior (j > i)
                for (int j = i + 1; j < n; j++) {
                    suma -= A[i][j] * xAnterior[j];
                }

                x[i] = suma / A[i][i];
            }

            if (calcularError(xAnterior, x) < tol) {
                System.out.println("Gauss-Seidel convergió en " + (iter + 1) + " iteraciones");
                return x;
            }
        }
        System.out.println("Gauss-Seidel llegó al límite de iteraciones");
        return x;
    }
}