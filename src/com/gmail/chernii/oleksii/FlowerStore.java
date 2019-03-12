package com.gmail.chernii.oleksii;

import com.gmail.chernii.oleksii.flowers.Chamomile;
import com.gmail.chernii.oleksii.flowers.Flower;
import com.gmail.chernii.oleksii.flowers.Rose;
import com.gmail.chernii.oleksii.flowers.Tulip;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Space on 11.03.2019.
 */
public class FlowerStore {
    private int money = 0;

    public int getMoney() {
        return money;
    }

    public Flower[] sell(int numRoses, int numChamomile, int numTulip) {
        int length = numRoses + numChamomile + numTulip;
        Flower[] flowers = new Flower[length];
        for (int i = 0; i < length; i++) {
            if (i < numRoses) {
                flowers[i] = new Rose();
                money += Rose.PRICE;
            }
            if (i >= numRoses && i < numRoses + numChamomile) {
                flowers[i] = new Chamomile();
                money += Chamomile.PRICE;
            }
            if (i >= numRoses + numChamomile) {
                flowers[i] = new Tulip();
                money += Tulip.PRICE;
            }
        }
        return flowers;
    }

    public Flower[] sellSequence(int numRoses, int numChamomile, int numTulip) {
        int max = max(numRoses, numChamomile, numTulip);
        int[] nums = {numRoses, numChamomile, numTulip};
        int length = numRoses + numChamomile + numTulip;
        List<Flower> flowers = fillList(max * 3, nums);

        return flowers.toArray(new Flower[length]);
    }

    private int max(int numRoses, int numChamomile, int numTulip) {
        int length = Math.max(numChamomile, numTulip);
        length = Math.max(length, numRoses);
        return length;
    }

    private List<Flower> fillList(int length, int[] nums) {
        List<Flower> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (i % 3 == 0 && nums[0] > 0) {
                list.add(new Rose());
                money += Rose.PRICE;
                nums[0]--;
            }
            if (i % 3 == 1 && nums[1] > 0) {
                list.add(new Chamomile());
                money += Chamomile.PRICE;
                nums[1]--;
            }
            if (i % 3 == 2 && nums[2] > 0) {
                list.add(new Tulip());
                money += Tulip.PRICE;
                nums[2]--;
            }
        }
        return list;
    }
}
