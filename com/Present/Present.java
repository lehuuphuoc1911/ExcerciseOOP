package com.Present;

import java.util.Arrays;

public class Present {
    private Sweet[] sweets;
    private static final int DEFAULT_GIFT_CAPACITY  =10;
    private int lastIndexAdded;

    {
        sweets= new Sweet[DEFAULT_GIFT_CAPACITY ];
    }
    public void addSweet(Sweet sweet) {
		if(sweet == null){
		    return;
        }
        if (sweets.length <= lastIndexAdded) {
            sweets = Arrays.copyOf(sweets, lastIndexAdded+1);
        }
        sweets[lastIndexAdded++] = sweet;

    }

    public double calculateTotalWeight() {
        double sumWeight = 0;
        for (Sweet sweet : sweets) {
            if (sweet != null) {
                sumWeight += sweet.getWeight();
            }
        }
        return sumWeight;
    }

    public Sweet[] filterSweetsBySugarRange(double minSugarWeight,
                                            double maxSugarWeight) {
        int matchSweetsAmount = 0;
        for (Sweet sweet : sweets) {
            if (sweet != null && (sweet.getSugarWeight() >= minSugarWeight
                    && sweet.getSugarWeight() <= maxSugarWeight)) {
                matchSweetsAmount++;
            }
        }

        Sweet[] filteredSweets = new Sweet[matchSweetsAmount];
        int index = 0;
        for (Sweet sweet : sweets) {
            if (sweet != null && (sweet.getSugarWeight() >= minSugarWeight
                    && sweet.getSugarWeight() <= maxSugarWeight)) {
                filteredSweets[index++] = sweet;
            }
        }

        return filteredSweets;
    }

    public Sweet[] getSweets() {
        int nonNullSweetsAmount = 0;
        for (Sweet sweet : sweets) {
            if (sweet != null) {
                nonNullSweetsAmount++;
            }
        }

        Sweet[] nonNullSweets = new Sweet[nonNullSweetsAmount];
        int index = 0;
        for (Sweet sweet : this.sweets) {
            if (sweet != null) {
                nonNullSweets[index++] = sweet;
            }
        }

        return nonNullSweets;
    }
}
