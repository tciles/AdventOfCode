package Solver;

import java.util.List;

public interface ISolver {
    public int getYear();

    public int getDay();

    public String getFileName();

    public void run(List<String> lines);
}
