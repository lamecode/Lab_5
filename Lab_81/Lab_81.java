import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 17. 	Побудувати квадратну матрицю з елементами 1, 2, ..., n, розміщеними по спіралі,
починаючи з лівого верхнього кута. Знайти мінімальне значення кутових елементів отриманої матриці.
Качан, ІП-81
 */
public class Lab_81 {

    private static int d;
    private static int n;

    public static void main(String[] args) {
        try {
            n = Integer.parseInt(args[0]);
            if (n > 0) {
                double dim = Math.sqrt(n);
                if (!isSquareMatrix(dim)) {
                    throw new IllegalArgumentException("It is not a square matrix!");
                }
                d = (int) dim;
                printSimpleMatrix();
                ArrayList<ArrayList<Integer>> spiralMatrix = getSpiralMatrix();
                System.out.println(getMinAngleElement(spiralMatrix));
            } else {
                throw new IllegalArgumentException("Please, type an argument greater than 0");
            }
        } catch (NumberFormatException nfe) {
            System.out.println("Please, type an integer number");
        }
    }

    private static ArrayList<ArrayList<Integer>> getSpiralMatrix() {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>(d);
        for (int i = 0; i < d; i++) {
            ArrayList<Integer> row = new ArrayList<>(d);
            for (int j = 0; j < d; j++) {
                row.add(0);
            }
            matrix.add(row);
        }
        int k = 1, c1 = 0, c2 = d - 1, r1 = 0, r2 = d - 1;

        System.out.println("Lets print matrix in the spiral way");
        while (k <= d * d) {
            for (int i = c1; i <= c2; i++) {
                matrix.get(r1).set(i, k++);
            }

            for (int j = r1 + 1; j <= r2; j++) {
                matrix.get(j).set(c2, k++);
            }

            for (int i = c2 - 1; i >= c1; i--) {
                matrix.get(r2).set(i, k++);
            }

            for (int j = r2 - 1; j >= r1 + 1; j--) {
                matrix.get(j).set(c1, k++);
            }
            c1++;
            c2--;
            r1++;
            r2--;
        }

        for (int i = 0; i < d; i++) {
            for (int j = 0; j < d; j++) {
                System.out.print(matrix.get(i).get(j) + " ");
            }
            System.out.println();
        }
        return matrix;
    }

    private static void printSimpleMatrix() {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        System.out.println("Lets print matrix in the simple way");
        ArrayList<Integer> row = new ArrayList<>();
        int s = -4;
        for (int i = 1; i <= d; i++) {
            s = s + 4;
            matrix.add(row);
            for (int j = 1; j <= d; j++) {
                row.add(j+s);
                System.out.print((j+s) + " ");
            }
            System.out.println();
        }
    }

    private static int getMinAngleElement(ArrayList<ArrayList<Integer>> matrix) {
        System.out.println("Lets get the min angle element of the spiral matrix");
        List<Integer> angleElements = new ArrayList();
        angleElements.add(matrix.get(0).get(0));
        angleElements.add(matrix.get(0).get(d - 1));
        angleElements.add(matrix.get(d - 1).get(0));
        angleElements.add(matrix.get(d - 1).get(d - 1));
        return Collections.min(angleElements);
    }

    private static boolean isSquareMatrix(double dim) {
        return dim % 1 == 0;
    }
}

