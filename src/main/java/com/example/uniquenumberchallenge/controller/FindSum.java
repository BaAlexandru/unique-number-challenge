package com.example.uniquenumberchallenge.controller;

import java.util.*;

public class FindSum {

    public int findSumOfTwo(List<Integer> inputNumbers, int sumOfTwoTarget) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < inputNumbers.size(); i++) {
            int complement = sumOfTwoTarget - inputNumbers.get(i);
            if (numMap.containsKey(complement)) {
                return numMap.get(complement) * inputNumbers.get(i);
            } else {
                numMap.put(inputNumbers.get(i), i);
            }
        }
        return 0;
    }

    public int findSumOfThree(List<Integer> inputNumbers, int sumOfThreeTarget) {
//        List<Integer[]> result = new ArrayList<>();
        for (int i = 0; i < inputNumbers.size(); i++) {
            int sumOfTwoTarget = sumOfThreeTarget - inputNumbers.get(i);
            Set<Integer> existingNumbers = new HashSet<>();
            for (int j = i + 1; j < inputNumbers.size(); j++) {
                if (existingNumbers.contains(sumOfTwoTarget - inputNumbers.get(j))) {
                    return inputNumbers.get(i) * inputNumbers.get(j) * (sumOfTwoTarget - inputNumbers.get(j));
                } else {
                    existingNumbers.add(inputNumbers.get(j));
                }
            }
        }
        return 0;
    }
}
