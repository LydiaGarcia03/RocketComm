package br.com.lauratobiasf.rocketcommversao2;

import android.content.Context;

import java.util.ArrayList;

import br.com.lauratobiasf.rocketcommversao2.Model.Rocket;

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