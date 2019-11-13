package br.com.lauratobiasf.rocketcommversao2.Controller;

import android.content.Context;
import java.util.ArrayList;
import br.com.lauratobiasf.rocketcommversao2.Model.Rocket;
import br.com.lauratobiasf.rocketcommversao2.RocketDAO;

public class RocketController {

    Context cContext;
    RocketDAO rocketDAO;

    public RocketController(Context c) {

        cContext = c;
        rocketDAO = new RocketDAO();

    }

    public ArrayList<Rocket> getRockets(){
        return rocketDAO.getRockets();
    }
}