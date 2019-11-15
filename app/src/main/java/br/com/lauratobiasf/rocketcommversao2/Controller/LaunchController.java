package br.com.lauratobiasf.rocketcommversao2.Controller;

import android.content.Context;
import br.com.lauratobiasf.rocketcommversao2.Bluetooth.Bluetooth;
import br.com.lauratobiasf.rocketcommversao2.DataAccessLayer.LaunchDAO;

public class LaunchController {

    Context cContext;
    LaunchDAO launchDAO;
    Bluetooth bt;

    public LaunchController(Context c) {

        cContext = c;
        launchDAO = new LaunchDAO();

        bt = new Bluetooth();

    }

}