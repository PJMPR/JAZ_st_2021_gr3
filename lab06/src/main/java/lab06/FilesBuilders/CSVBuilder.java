package Lab06.FilesBuilders;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CSVBuilder {
    private String json;

    public CSVBuilder(String json) {
        this.json = json;
    }


    public void buildFile() throws FileNotFoundException {
        File csvFile = new File("src/main/resources/Timetablecsv.csv");
        PrintWriter printWriter = new PrintWriter(csvFile);

        printWriter.println(json);
        printWriter.close();

    }
}
