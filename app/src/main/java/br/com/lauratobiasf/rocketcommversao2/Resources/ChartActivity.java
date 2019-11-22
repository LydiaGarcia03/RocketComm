package br.com.lauratobiasf.rocketcommversao2.Resources;

import androidx.appcompat.app.AppCompatActivity;
import br.com.lauratobiasf.rocketcommversao2.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class ChartActivity extends AppCompatActivity {

    WebView webView;
    int num1, num2, num3, num4, num5;

    Spinner spCharts;
    List<String> listCharts;
    List<String> listHtml;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);

        Intent intent = getIntent();
        num1 = intent.getIntExtra("NUM1", 0);
        num2 = intent.getIntExtra("NUM2", 0);
        num3 = intent.getIntExtra("NUM3", 0);
        num4 = intent.getIntExtra("NUM4", 0);
        num5 = intent.getIntExtra("NUM5", 0);

        spCharts = (Spinner) findViewById(R.id.spcharts);

        listCharts = new ArrayList<String>();
        listCharts.add("Pie Chart");
        listCharts.add("Pie Chart 3D");
        listCharts.add("Scatter Chart");
        listCharts.add("Column Chart");
        listCharts.add("Bar Chart");
        listCharts.add("Histogram");
        listCharts.add("Line Chart");
        listCharts.add("Area Chart");

        listHtml = new ArrayList<>();
        listHtml.add("file:///android_asset/pie_chart.html");
        listHtml.add("file:///android_asset/pie_chart_3d.html");
        listHtml.add("file:///android_asset/scatter_chart.html");
        listHtml.add("file:///android_asset/column_chart.html");
        listHtml.add("file:///android_asset/bar_chart.html");
        listHtml.add("file:///android_asset/histogram.html");
        listHtml.add("file:///android_asset/line_chart.html");
        listHtml.add("file:///android_asset/area_chart.html");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, listCharts);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCharts.setAdapter(dataAdapter);
        spCharts.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                String chartHtml = listHtml.get(parent.getSelectedItemPosition());
                webView.loadUrl(chartHtml);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub

            }});

        webView = (WebView)findViewById(R.id.web);
        webView.addJavascriptInterface(new WebAppInterface(), "Android");

        webView.getSettings().setJavaScriptEnabled(true);

    }

    public class WebAppInterface {

        @JavascriptInterface
        public int getNum1() {
            return num1;
        }

        @JavascriptInterface
        public int getNum2() {
            return num2;
        }

        @JavascriptInterface
        public int getNum3() {
            return num3;
        }

        @JavascriptInterface
        public int getNum4() {
            return num4;
        }

        @JavascriptInterface
        public int getNum5() {
            return num5;
        }
    }
}

