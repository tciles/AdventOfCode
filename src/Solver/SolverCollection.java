package Solver;

import java.util.ArrayList;
import Solver.Year2024.SolverYear2024Day1;
import Solver.Year2024.SolverYear2024Day2;

public class SolverCollection {
    private ArrayList<ISolver> solvers;

    public SolverCollection() {
        solvers = new ArrayList<ISolver>();
    }

    public void addSolver(ISolver solver) {
        solvers.add(solver);
    }

    public ISolver resolve(int year, int day) throws NullPointerException {
        for (ISolver solver : solvers) {
            if (solver.getYear() == year && solver.getDay() == day) {
                return solver;
            }
        }

        throw new IllegalArgumentException("Solver not found");
    }

    public static SolverCollection create() {
        SolverCollection collection = new SolverCollection();
        collection.addSolver(new SolverYear2024Day1());
        collection.addSolver(new SolverYear2024Day2());

        return collection;
    }
}
