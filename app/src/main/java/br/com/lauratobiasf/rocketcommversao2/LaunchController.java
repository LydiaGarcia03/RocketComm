package br.com.lauratobiasf.rocketcommversao2;

import android.content.Context;

public class LaunchController {

    Context cContext;
    LaunchDAO launchDAO;

    public LaunchController(Context c) {

        cContext = c;
        launchDAO = new LaunchDAO(cContext);

    }

}