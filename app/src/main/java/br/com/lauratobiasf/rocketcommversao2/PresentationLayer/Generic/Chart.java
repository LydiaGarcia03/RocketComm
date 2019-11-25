package br.com.lauratobiasf.rocketcommversao2.PresentationLayer.Generic;

import androidx.appcompat.app.AppCompatActivity;
import br.com.lauratobiasf.rocketcommversao2.R;

import android.os.Bundle;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;

public class Chart extends AppCompatActivity /*implements OnChartGestureListener, OnChartValueSelectedListener */{

    private LineChart mChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);


        mChart = (LineChart) findViewById(R.id.line_chart);

//        mChart.setOnChartGestureListener(MainActivity.this);
//        mChart.setOnChartValueSelectedListener(MainActivity.this);

        mChart.setDragEnabled(true);
        mChart.setScaleEnabled(false);

        ArrayList<Entry> yValues = new ArrayList<>();

        yValues.add(new Entry(0, 60f));
        yValues.add(new Entry(1, 50f));
        yValues.add(new Entry(2, 40f));
        yValues.add(new Entry(3, 60f));
        yValues.add(new Entry(4, 30f));
        yValues.add(new Entry(5, 20f));
        yValues.add(new Entry(6, 15f));

        LineDataSet set01 = new LineDataSet(yValues, "Data Set 1");

        set01.setFillAlpha(110);

        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(set01);

        LineData data = new LineData(dataSets);

        mChart.setData(data);

    }

}