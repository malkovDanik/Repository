/**
 * Copyright (c) 2008, 2012 Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 */

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Tooltip;
import javafx.stage.Stage;

public class LineChartSample extends Application {

    private void init(Stage primaryStage) {
        Group root = new Group();
        primaryStage.setScene(new Scene(root));
        NumberAxis xAxis = new NumberAxis("Values for X-Axis", 0, 3, 1);
        NumberAxis yAxis = new NumberAxis("Values for Y-Axis", 0, 3, 1);
        ObservableList<XYChart.Series<Double,Double>> lineChartData = FXCollections.observableArrayList(
            new LineChart.Series<>("Series 1", FXCollections.observableArrayList(
                new XYChart.Data<>(0.0, 1.0),
                new XYChart.Data<>(1.2, 1.4),
                new XYChart.Data<>(2.2, 1.9),
                new XYChart.Data<>(2.7, 2.3),
                new XYChart.Data<>(2.9, 0.5)
            )),
            new LineChart.Series<>("Series 2", FXCollections.observableArrayList(
                new XYChart.Data<>(0.0, 1.6),
                new XYChart.Data<>(0.8, 0.4),
                new XYChart.Data<>(1.4, 2.9),
                new XYChart.Data<>(2.1, 1.3),
                new XYChart.Data<>(2.6, 0.9)
            ))
        );
        LineChart chart = new LineChart(xAxis, yAxis, lineChartData);
        ObservableList<XYChart.Data> dataList = ((XYChart.Series) chart.getData().get(0)).getData();
        dataList.forEach(data -> {
            Node node = data.getNode();
            Tooltip tooltip = new Tooltip('(' + data.getXValue().toString() + ';' + data.getYValue().toString() + ')');
            Tooltip.install(node, tooltip);

        });
        chart.getStylesheets().add(getClass().getResource("linechart.css").toExternalForm());
        chart.setTitle("GOGO");
        root.getChildren().add(chart);
    }

    @Override public void start(Stage primaryStage) throws Exception {
        init(primaryStage);
        primaryStage.show();
    }
    public static void main(String[] args) { launch(args); }
}
