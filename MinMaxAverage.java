/*
 * Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Random;

public class MinMaxAverage {

    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            int num = random.nextInt(100);
            array.add(num);
            count += num;
        }
        System.out.println("Cписок чисел:\n" + array);
        Collections.sort(array);

        System.out.println("Минимальное число: " + array.get(0));
        System.out.println("Максимальное число: " + array.get(9));
        System.out.println("Среднее всего списка: " + count / 10);
    }

}