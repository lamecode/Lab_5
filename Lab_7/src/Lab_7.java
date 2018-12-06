/* 17. 	Заданий цілочисельний масив A(n). Побудувати масив В, кожний елемент якого обчислюється як
        bі = аmax - аі,де аmax - максимальний елемент масиву А. Обчислити  .
        Всі кратні 7 елементи масиву А збільшити на величину d.
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lab_7 {
    public static void main(String[] args) {
        Scanner Lab_7 = new Scanner(System.in);
        List<Integer> An = new ArrayList<>();
        List<Integer> Bn = new ArrayList<>();
        System.out.println("Введіть розмірність масиву:");
        int n1 = Lab_7.nextInt();
        int d =0;
        int bn;
        for (int k = 1; k<=n1; k++) {
            int n = (int) (Math.random()*100);
            An.add(n);
        }
        int amax = An.get(0);
        for (int i = 1; i < An.size(); i++) {
            if (An.get(i) > amax) {
                amax = An.get(i);
            }
        }
        for (int s = 0; s<n1; s++) {
            bn = amax - An.get(s);
            Bn.add(bn);
        }
        for ( int e = 0; e<n1; e++) {
            d += Math.pow(An.get(e),2) - Math.pow(Bn.get(e),2);
        }
        for (int c = 0; c<n1; c++){
            if (An.get(c)%7 == 0) {
                int n11 = An.get(c) + d;
                An.set(c, n11);
            }
        }
        System.out.println("Масив An:" + "\n" + An);
        System.out.print("Максимальне значення масиву Аn - " + amax + "\n");
        System.out.println("Масив Вn:");
        System.out.println(Bn);
        System.out.println("Значення d:");
        System.out.println(d);
    }
}
