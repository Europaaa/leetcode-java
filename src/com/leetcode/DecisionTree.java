package com.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DecisionTree {

    public double calculateEntropy(int[] input) {
        // Count the number of appearance for each value
        Map<Integer, Long> counters = Arrays.stream(input).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // Calculate the entropy for the group
        return -1 * counters.entrySet().stream()
                .map(entry -> {
                    double p = entry.getValue() * 1.0 / input.length;
                    return p * Math.log(p) / Math.log(2);
                }).mapToDouble(a -> a).sum();
    }

    public double calculateMaxInfoGain(List<Double> petal_length, List<String> species) {
        int n = petal_length.size();

        // Get labels for specifies with unique integers
        Map<String, Integer> labelMapping = markLabels(species);

        // Sort the samples by the petal length and mark them with the integer labels
        List<Number[]> samples = IntStream.range(0, n)
                .mapToObj(i -> new Number[]{petal_length.get(i), labelMapping.get(species.get(i))})
                .sorted((o1, o2) -> {
                    double diff = (double) o1[0] - (double) o2[0];
                    if (diff > 0) return 1;
                    return diff == 0 ? 0 : -1;
                })
                .collect(Collectors.toList());

        // Get entropy of the group
        int[] labels = samples.stream().mapToInt(s -> (int) s[1]).toArray();
        double entropyGroup = calculateEntropy(labels);

        // i represents the number of samples in the first split
        double maxInfoGain = 0;
        for (int i = 1; i < samples.size(); i++) {
            int[] split1 = Arrays.stream(labels, 0, i)
                    .toArray();

            int[] split2 = Arrays.stream(labels, i, n)
                    .toArray();

            double infoGain = entropyGroup - calculateEntropy(split1) * i * 1.0 / n - calculateEntropy(split2) * (n - 3) * 1.0 / n;
            if (infoGain > maxInfoGain) {
                maxInfoGain = infoGain;
            }
        }
        return maxInfoGain;
    }

    private Map<String, Integer> markLabels(List<String> labels) {
        List<String> distinctLabels = labels.stream().distinct().collect(Collectors.toList());
        return IntStream.range(0, distinctLabels.size())
                .boxed()
                .collect(Collectors.toMap(i -> distinctLabels.get(i), Function.identity()));
    }
}
