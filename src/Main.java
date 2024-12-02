import Solver.ISolver;
import Solver.SolverCollection;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private final static int YEAR = 2024;
    private final static int DAY = 2;

    public static void main(String[] args) {
        Main app = new Main();
        SolverCollection collection = SolverCollection.create();

        try {
            ISolver solver = collection.resolve(YEAR, DAY);
            File file = app.getFileFromResource(solver.getFileName());

            System.out.println(file);

            solver.run(getLines(file));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private File getFileFromResource(String fileName) throws URISyntaxException {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(fileName);

        if (null == resource) {
            throw new IllegalArgumentException("file not found! " + fileName);
        }

        return new File(resource.toURI());
    }

    private static List<String> getLines(File file) {
        List<String> lines = new ArrayList<String>();

        try {
            lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }
}