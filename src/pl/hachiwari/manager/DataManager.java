package pl.hachiwari.manager;

import pl.hachiwari.TimeRange;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class DataManager {

    private final String pathFile;
    private final List<TimeRange> timeRanges = new LinkedList<>();

    public DataManager(String pathFile) {
        this.pathFile = pathFile;
        initData();
    }

    public List<TimeRange> getData() {
        return timeRanges;
    }

    private void initData() {
        String currentLine;
        StringTokenizer tokenizer;
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(pathFile));

            while((currentLine = bufferedReader.readLine()) != null) {
                tokenizer = new StringTokenizer(currentLine, " ");

                while(tokenizer.hasMoreTokens()) {
                    double timeStart = Double.parseDouble(tokenizer.nextToken());
                    double timeEnd = Double.parseDouble(tokenizer.nextToken());

                    timeRanges.add(new TimeRange(timeStart, timeEnd));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null)
                    bufferedReader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
