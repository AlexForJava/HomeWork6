package com.gmail.chernii.oleksii;

import com.my.flowers.entity.Chamomile;
import com.my.flowers.entity.Flower;
import com.my.flowers.entity.Rose;
import com.my.flowers.entity.Tulip;

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
                Rose rose = new Rose(100);
                flowers[i] = rose;
                money += rose.getPrice();
            }
            if (i >= numRoses && i < numRoses + numChamomile) {
                Chamomile chamomile = new Chamomile(70);
                flowers[i] = chamomile;
                money += chamomile.getPrice();
            }
            if (i >= numRoses + numChamomile) {
                Tulip tulip = new Tulip(45);
                flowers[i] = tulip;
                money += tulip.getPrice();
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
                Rose rose = new Rose(100);
                list.add(rose);
                money += rose.getPrice();
                nums[0]--;
            }
            if (i % 3 == 1 && nums[1] > 0) {
                Chamomile chamomile = new Chamomile(70);
                list.add(chamomile);
                money += chamomile.getPrice();
                nums[1]--;
            }
            if (i % 3 == 2 && nums[2] > 0) {
                Tulip tulip = new Tulip(45);
                list.add(tulip);
                money += tulip.getPrice();
                nums[2]--;
            }
        }
        return list;
    }
}
