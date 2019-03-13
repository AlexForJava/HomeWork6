package com.my.flowers;

import com.gmail.chernii.oleksii.FlowerStore;
import com.my.flowers.entity.Flower;

/**
 * Created by Space on 11.03.2019.
 */
public class ConsoleApplication {
    public static void main(String[] args) {
        FlowerStore flowerStore = new FlowerStore();
        Flower[] flowers1 = flowerStore.sell(2, 4, 5);
        for (Flower f : flowers1) {
            System.out.print(f.getClass().getSimpleName() + "\t");
        }
        System.out.println();
        Flower[] flowers2 = flowerStore.sellSequence(1, 4, 2);
        for (Flower f : flowers2) {
            System.out.print(f.getClass().getSimpleName() + "\t");
        }
        System.out.println();
        System.out.println("Money in the store = " + flowerStore.getMoney());
    }
}
