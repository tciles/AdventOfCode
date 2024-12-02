package Solver;

import java.util.List;

public class Solver implements ISolver {
    private int year;

    private int day;

    public Solver() {
        year = -1;
        day = -1;
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
    public String getFileName()
    {
        return "";
    }

    @Override
    public void run(List<String> lines) {
        System.out.println("Solver with errors");
    }
}
