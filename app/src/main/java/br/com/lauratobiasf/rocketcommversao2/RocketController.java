package br.com.lauratobiasf.rocketcommversao2;

import android.content.Context;

import java.util.ArrayList;

public class RocketController {

    Context cContext;
    RocketDAO rocketDAO;

    public RocketController(Context c) {

        cContext = c;
        rocketDAO = new RocketDAO(cContext);

    }

    public ArrayList<Rocket> getRockets(){
        return rocketDAO.getRockets();
    }
}