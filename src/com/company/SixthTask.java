package com.company;

import com.company.backpacktask.Backpack;
import com.company.backpacktask.Item;

import java.util.ArrayList;
import java.util.List;

public class SixthTask {
    private Backpack backpack;

    public SixthTask(Double maxWeight) {
        backpack = new Backpack(maxWeight);
    }

    private double calculateWeight(List<Item> items) {
        double sumWeight = 0;
        for (Item item :
                items) {
            sumWeight += item.getWeight();
        }

        return sumWeight;
    }

    private double calculatePrice(List<Item> items) {
        double sumPrice = 0;

        for (Item item : items) {
            sumPrice += item.getPrice();
        }

        return sumPrice;
    }

    private void checkSet(List<Item> items) {
        if (backpack.getBestItems() == null || ((calculateWeight(items) <= backpack.getMaxWeight() && calculatePrice(items) > backpack.getMaxPrice()))) {
            backpack.setBestItems(items);
            backpack.setMaxPrice(calculatePrice(items));
        }
    }

    public void MakeAllSets(List<Item> items) {
        if (items.size() > 0)
            checkSet(items);

        for (int i = 0; i < items.size(); i++) {
            List<Item> newSet = new ArrayList<>(items);

            newSet.remove(i);

            MakeAllSets(newSet);
        }
    }

    public List<Item> GetBestSet() {
        return backpack.getBestItems();
    }
}