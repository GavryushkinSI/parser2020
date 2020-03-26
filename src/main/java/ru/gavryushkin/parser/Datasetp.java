package ru.gavryushkin.parser;

import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import ru.gavryushkin.parser.model.Point;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Datasetp {
    public static CategoryDataset createDataset1() {

        DefaultCategoryDataset dataset;

        final String series1 = "TS_1";
        int[] x = ParserApplication.x_toint;
        int y = 0;
        dataset = new DefaultCategoryDataset();
        for (int i = -1; i < x.length - 1; i++) {
            if (i == -1) {
                dataset.addValue(0, series1, String.valueOf(x[0]));
            } else {
                y += x[i] + x[i + 1];
                dataset.addValue(y, series1, String.valueOf(x[i + 1]));
            }
        }
        return dataset;
    }

    public static List<Point> getList() {
        List<Point> list = new ArrayList<>();
        BufferedReader rd = null;
        String[] x1 = null;
        try {
            rd = new BufferedReader(new FileReader("data.txt"));
            x1 = rd.readLine().split(" ");
            rd.close();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int[] x_toint = Stream.of(x1).mapToInt(Integer::parseInt).toArray();
        int[] x = x_toint;
        int y = 0;
        for (int i = -1; i < x.length - 1; i++) {
            Point point = new Point();
            if (i == -1) {
                point.setY(0);
                point.setX(0);
            } else {
                y += x[i] + x[i + 1];
                point.setX(i+1);
                point.setY(y);
            }
            list.add(point);
        }
        return list;
    }
}
