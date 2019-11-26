package br.com.lauratobiasf.rocketcommversao2.DataObjectLayer;

public class Launch {

    int id;
    String rocket_name;
    String total_time_launch;
    String launch_datetime;
    String motor_type;
    String recover_system;
    int altimeter;

    public Launch(int id, String rocket_name, String total_time_launch, String launch_datetime, String motor_type, String recover_system, int altimeter) {
        this.id = id;
        this.rocket_name = rocket_name;
        this.total_time_launch = total_time_launch;
        this.launch_datetime = launch_datetime;
        this.motor_type = motor_type;
        this.recover_system = recover_system;
        this.altimeter = altimeter;
    }

    public Launch(String rocket_name, String total_time_launch, String launch_datetime, String motor_type, String recover_system, int altimeter) {
        this.rocket_name = rocket_name;
        this.total_time_launch = total_time_launch;
        this.launch_datetime = launch_datetime;
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

    public String getRocket_name() { return rocket_name; }

    public void setRocket_name(String rocket_name) { this.rocket_name = rocket_name; }

    public String getTotal_time_launch() { return total_time_launch; }

    public void setTotal_time_launch(String total_time_launch) { this.total_time_launch = total_time_launch; }

    public String getLaunch_datetime() {
        return launch_datetime;
    }

    public void setLaunch_datetime(String launch_datetime) { this.launch_datetime = launch_datetime; }

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

    public int isAltimeter() {
        return altimeter;
    }

    public void setAltimeter(int altimeter) {
        this.altimeter = altimeter;
    }

}

