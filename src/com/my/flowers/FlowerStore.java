package com.my.flowers;

import com.my.flowers.entity.Chamomile;
import com.my.flowers.entity.Flower;
import com.my.flowers.entity.Rose;
import com.my.flowers.entity.Tulip;

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
        int length = numRoses + numChamomile + numTulip;
        Flower[] flowers = new Flower[length];
        int index = 0;
        while (numRoses > 0 || numChamomile > 0 || numTulip > 0) {
            if (numRoses > 0) {
                Rose rose = new Rose(100);
                flowers[index++] = rose;
                numRoses--;
                money += rose.getPrice();
            }
            if (numChamomile > 0) {
                Chamomile chamomile = new Chamomile(70);
                flowers[index++] = chamomile;
                numChamomile--;
                money += chamomile.getPrice();
            }
            if (numTulip > 0) {
                Tulip tulip = new Tulip(45);
                flowers[index++] = tulip;
                numTulip--;
                money += tulip.getPrice();
            }
        }
        return flowers;

    }


}
