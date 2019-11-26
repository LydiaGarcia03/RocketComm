package br.com.lauratobiasf.rocketcommversao2.PresentationLayer.Launch;

import android.os.Bundle;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import java.util.ArrayList;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import br.com.lauratobiasf.rocketcommversao2.R;

public class Launching extends AppCompatActivity {

    private LineChart mChart;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lauching);

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
