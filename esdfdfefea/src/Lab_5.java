/*17. 	Ввести натуральні числа m та  n. Як результат вивести усі натуральні числа,
що менші за  m, сума цифр яких дорівнює  n.
 */
import java.util.Scanner;
public class Lab_5 {
    public static void main(String[] args) {
        Scanner Lab_5 = new Scanner(System.in);
        System.out.println("Введіть m:");
        double m = Lab_5.nextDouble();
        System.out.println("Введіть n:");
        int n = Lab_5.nextInt();
        for (int k = 1; k < m; k++) {
            double sum = 0;
            int e = k;
            while (e >= 1) {
                sum += e % 10;
                e /= 10;
            } if (sum == n) {
                System.out.println(k);
            }
        }
    }
}