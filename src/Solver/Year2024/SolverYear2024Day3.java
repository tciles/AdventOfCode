package Solver.Year2024;

import Solver.Solver;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SolverYear2024Day3 extends Solver {
    public SolverYear2024Day3() {
        year = 2024;
        day = 3;
    }

    @Override
    public void run(List<String> lines) {
        String line = String.join("", lines);
        System.out.println("Answer 1 : " + answerOne(line));

        StringBuilder buffer = new StringBuilder();
        StringBuilder buffer2 = new StringBuilder();
        StringBuilder str = new StringBuilder();

        line = "do()" + line;
        //line = "do()xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))";

        int i;
        boolean add = false;

        for (i = 0; i < line.length(); i++) {
            buffer.append(line.charAt(i));

            if (buffer.indexOf("don't()") > -1) {
                str.append(buffer2);
                buffer.setLength(0);
                buffer2.setLength(0);
                add = false;
            }

            if (buffer.indexOf("do()") > -1) {
                buffer.setLength(0);
                add = true;
            }

            if (add) {
                buffer2.append(line.charAt(i));
            }
        }

        str.append(buffer2);

        System.out.println("Answer 2 : " + answerOne(str.toString()));
    }

    private int answerOne(String line) {
        Pattern pattern = Pattern.compile("mul\\((?<left>\\d+),(?<right>\\d+)\\)");
        Matcher matcher = pattern.matcher(line);

        int total = 0;

        while (matcher.find()) {
            int[] parts = Arrays.stream(line.substring(matcher.start(), matcher.end())
                            .replace("mul(", "")
                            .replace(")", "")
                            .split(","))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            total += parts[0] * parts[1];
        }

        return total;
    }
}
