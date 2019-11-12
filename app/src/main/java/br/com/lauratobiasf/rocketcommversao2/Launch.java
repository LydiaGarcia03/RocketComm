package br.com.lauratobiasf.rocketcommversao2;

public class Launch {

    int id;
    int fk_rocket_id;
    String launch_datetime;
    float launch_site_lat;
    float launch_site_lon;
    String motor_type;
    String recover_system;
    boolean altimeter;

    public Launch(int id, int fk_rocket_id, String launch_datetime, float launch_site_lat, float launch_site_lon, String motor_type, String recover_system, boolean altimeter) {
        this.id = id;
        this.fk_rocket_id = fk_rocket_id;
        this.launch_datetime = launch_datetime;
        this.launch_site_lat = launch_site_lat;
        this.launch_site_lon = launch_site_lon;
        this.motor_type = motor_type;
        this.recover_system = recover_system;
        this.altimeter = altimeter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFk_rocket_id() {
        return fk_rocket_id;
    }

    public void setFk_rocket_id(int fk_rocket_id) {
        this.fk_rocket_id = fk_rocket_id;
    }

    public String getLaunch_datetime() {
        return launch_datetime;
    }

    public void setLaunch_datetime(String launch_datetime) {
        this.launch_datetime = launch_datetime;
    }

    public float getLaunch_site_lat() {
        return launch_site_lat;
    }

    public void setLaunch_site_lat(float launch_site_lat) {
        this.launch_site_lat = launch_site_lat;
    }

    public float getLaunch_site_lon() {
        return launch_site_lon;
    }

    public void setLaunch_site_lon(float launch_site_lon) {
        this.launch_site_lon = launch_site_lon;
    }

    public String getMotor_type() {
        return motor_type;
    }

    public void setMotor_type(String motor_type) {
        this.motor_type = motor_type;
    }

    public String getRecover_system() {
        return recover_system;
    }

    public void setRecover_system(String recover_system) {
        this.recover_system = recover_system;
    }

    public boolean isAltimeter() {
        return altimeter;
    }

    public void setAltimeter(boolean altimeter) {
        this.altimeter = altimeter;
    }
}

