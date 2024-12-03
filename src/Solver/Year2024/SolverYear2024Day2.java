package Solver.Year2024;

import Solver.Solver;

import java.util.Arrays;
import java.util.List;

public class SolverYear2024Day2 extends Solver {
    private enum DIRECTION {
        ASC,
        DESC
    }

    public SolverYear2024Day2() {
        year = 2024;
        day = 2;
    }

    @Override
    public void run(List<String> lines) {
        int totalSafe = 0;
        int totalUnsafe = 0;

        for (String line : lines) {
            int[] nums = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();

            boolean safe = answerOne(nums);

            if (safe) {
                totalSafe++;

                continue;
            }

            safe = answerTwo(nums);

            if (safe) {
                totalSafe++;

                continue;
            }

            totalUnsafe++;
        }

        System.out.println("SAFE " + totalSafe);
        System.out.println("UNSAFE " + totalUnsafe);

    }

    private boolean answerOne(int[] nums) {
        boolean safe = true;

        DIRECTION direction = nums[1] > nums[0] ? DIRECTION.ASC : DIRECTION.DESC;

        int i;
        for (i = 0; i < nums.length; i++) {
            try {
                if (direction == DIRECTION.ASC && nums[i] > nums[i + 1]) {
                    safe = false;
                    break;
                }

                if (direction == DIRECTION.DESC && nums[i] < nums[i + 1]) {
                    safe = false;
                    break;
                }

                int delta = Math.abs(nums[i] - nums[i + 1]);

                if (delta < 1 || delta > 3) {
                    safe = false;
                    break;
                }
            } catch (ArrayIndexOutOfBoundsException _) {
            }
        }

        return safe;
    }

    private boolean answerTwo(int[] nums) {
        boolean safe = false;

        int excludedIndex;
        for (excludedIndex = 0; excludedIndex < nums.length; excludedIndex++) {
            int[] n = arr(nums, excludedIndex);

            if (answerOne(n)) {
                safe = true;
                break;
            }
        }

        return safe;
    }

    private int[] arr(int[] nums, int excludedIndex) {
        int[] result = new int[nums.length - 1];

        int i;
        int k = 0;
        for (i = 0; i < nums.length; i++) {
            if (i == excludedIndex) {
                continue;
            }

            result[k] = nums[i];
            k++;
        }

        return result;
    }
}
