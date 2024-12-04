package Solver.Year2024;

import Solver.Solver;

import java.util.List;

public class SolverYear2024Day4 extends Solver {
    public SolverYear2024Day4() {
        year = 2024;
        day = 4;
    }

    @Override
    public void run(List<String> lines) {
        System.out.println("Matrix : " + lines.size() + "x" + lines.getFirst().length());

        int rowsLength = lines.size();
        int columnsLength = lines.getFirst().length();

        String[][] matrix = new String[rowsLength][columnsLength];

        int i = 0;
        for (String line : lines) {
            matrix[i] = line.split("");
            i++;
        }

        System.out.println("Answer 1 : " + answerOne(matrix));
        System.out.println("Answer 2 : " + answerTwo(matrix));
    }

    private int answerOne(String[][] matrix) {
        int rowsLength = matrix.length;
        int columnsLength = matrix[0].length;

        int total = 0;
        int y;
        int x;

        for (y = 0; y < rowsLength; y++) {
            for (x = 0; x < columnsLength; x++) {
                String[] words = new String[]{"", "", "", "", "", "", "", ""};

                // top
                if ((y - 3) >= 0) {
                    words[0] = matrix[y][x] + matrix[y - 1][x] + matrix[y - 2][x] + matrix[y - 3][x];
                }

                // bottom
                if ((y + 3) < rowsLength) {
                    words[1] = matrix[y][x] + matrix[y + 1][x] + matrix[y + 2][x] + matrix[y + 3][x];
                }

                // left
                if ((x - 3) >= 0) {
                    words[2] = matrix[y][x] + matrix[y][x - 1] + matrix[y][x - 2] + matrix[y][x - 3];
                }

                // right
                if ((x + 3) < columnsLength) {
                    words[3] = matrix[y][x] + matrix[y][x + 1] + matrix[y][x + 2] + matrix[y][x + 3];
                }

                // top left
                if ((y - 3) >= 0 && (x - 3) >= 0) {
                    words[4] = matrix[y][x] + matrix[y - 1][x - 1] + matrix[y - 2][x - 2] + matrix[y - 3][x - 3];
                }

                // top right
                if ((y - 3) >= 0 && (x + 3) < columnsLength) {
                    words[5] = matrix[y][x] + matrix[y - 1][x + 1] + matrix[y - 2][x + 2] + matrix[y - 3][x + 3];
                }

                // bottom right
                if ((y + 3) < rowsLength && (x + 3) < columnsLength) {
                    words[6] = matrix[y][x] + matrix[y + 1][x + 1] + matrix[y + 2][x + 2] + matrix[y + 3][x + 3];
                }

                // bottom left
                if ((y + 3) < rowsLength && (x - 3) >= 0) {
                    words[7] = matrix[y][x] + matrix[y + 1][x - 1] + matrix[y + 2][x - 2] + matrix[y + 3][x - 3];
                }

                for (String word : words) {
                    if (word.equals("XMAS")) {
                        total++;
                    }
                }
            }
        }

        return total;
    }

    private int answerTwo(String[][] matrix) {
        int rowsLength = matrix.length;
        int columnsLength = matrix[0].length;

        int total = 0;
        int y;
        int x;

        for (y = 0; y < rowsLength; y++) {
            for (x = 0; x < columnsLength; x++) {
                if (!matrix[y][x].equals("A")) {
                    continue;
                }

                String[] words = new String[]{"", ""};

                if (y - 1 >= 0 && x - 1 >= 0 && y + 1 < rowsLength && x + 1 < columnsLength) {
                    words[0] = matrix[y - 1][x - 1] + matrix[y][x] + matrix[y + 1][x + 1];
                    words[1] = matrix[y + 1][x - 1] + matrix[y][x] + matrix[y - 1][x + 1];
                }

                if (
                        (words[0].equals("MAS") || words[0].equals("SAM")) &&
                        (words[1].equals("MAS") || words[1].equals("SAM"))
                ) {
                    total++;
                }
            }
        }

        return total;
    }
}