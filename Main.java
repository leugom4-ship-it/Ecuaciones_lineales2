
import Ecuaciones_lineales.JACOBI.MetodoJacobi;
import Ecuaciones_lineales.GaussSeidel.MetodoGaussSeidel;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        // Sistema de ecuaciones:
        // 5x +  y + z = 7
        // x + 4y + z = 6
        // x + 2y + 5z = 8

        double[][] A = {
                {5, 1, 1},
                {1, 4, 1},
                {1, 2, 5}
        };
        double[] b = {7, 6, 8};
        double[] x0 = {0, 0, 0};
        double tolerancia = 0.0001;
        int maxIteraciones = 100;

        System.out.println("==========================================");
        System.out.println("SISTEMA DE ECUACIONES LINEALES");
        System.out.println("5x +  y + z = 7");
        System.out.println("x + 4y + z = 6");
        System.out.println("x + 2y + 5z = 8");
        System.out.println("Vector inicial: [0, 0, 0]");
        System.out.println("Tolerancia: " + tolerancia);
        System.out.println("==========================================\n");
    }
}
