package br.com.lauratobiasf.rocketcommversao2;

import android.content.Context;

public class LaunchController {

    Context cContext;
    LaunchDAO launchDAO;
    Bluetooth bt;

    public LaunchController(Context c) {

        cContext = c;
        launchDAO = new LaunchDAO(cContext);

        bt = new Bluetooth();

    }

}