package Solver.Year2024;

import java.util.*;

import Solver.ISolver;

public class SolverYear2024Day1 implements ISolver {
    private final int year;

    private final int day;

    public SolverYear2024Day1() {
        year = 2024;
        day = 1;
    }

    @Override
    public int getYear() {
        return year;
    }

    @Override
    public int getDay() {
        return day;
    }

    @Override
    public String getFileName() {
        return year + "_" + day + "_input.txt";
    }

    @Override
    public void run(List<String> lines) {
        Integer[] left = new Integer[lines.size()];
        Integer[] right = new Integer[lines.size()];

        int i = 0;
        for (String line : lines) {
            String[] parts = line.split(" {3}");

            left[i] = Integer.parseInt(parts[0]);
            right[i] = Integer.parseInt(parts[1]);

            i++;
        }

        Arrays.sort(left, Collections.reverseOrder());
        Arrays.sort(right, Collections.reverseOrder());

        int total = 0;
        for (i = 0; i < lines.size(); i++) {
            total += Math.abs(left[i] - right[i]);
        }
        System.out.println("TOTAL " + total);

        total = 0;
        for (i = 0; i < lines.size(); i++) {
            int rightOperand = freq(right, left[i]); // Collections.frequency(right, left[i]);
            total += Math.abs(left[i] * rightOperand);
        }
        System.out.println("TOTAL " + total);
    }

    private int freq(Integer[] values, Integer value) {
        int res = 0;

        for (Integer v : values) {
            if (Objects.equals(value, v)) {
                res++;
            }
        }

        return res;
    }
}
