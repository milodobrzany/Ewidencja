package ewidencja.activity;


import ewidencja.employee.Employee;

public class Presence {
    private boolean presence;
    private String day;
    private String arrival_time;
    private String leave_time;
    private int id;

    public Presence(){
        presence = false;
    }

    public void create_presence(Employee employee){
        if(check_if_present()){
            setLeave_time();
        } else {
            setDay();
            setArrival_time();
            presence = true;
            employee.getReport().add_presence(this);
        }
    }


    private boolean check_if_present(){return presence;}

    public void setArrival_time() {
        this.arrival_time = java.time.LocalTime.now().toString();
    }

    public void setArrival_time(String arrival_time) {
        this.arrival_time = arrival_time;
    }

    public void setLeave_time() {
        this.leave_time = java.time.LocalTime.now().toString();
    }

    public void setLeave_time(String leave_time) {
        this.leave_time = leave_time;
    }

    public void setDay() {
        this.day = java.time.LocalDate.now().toString();
    }

    public void setId(int id){
        this.id = id;
    }
    public void setDay(String day) {
        this.day = day;
    }

    public void update_presence(){}

    public String getArrival_time() {
        return arrival_time;
    }

    public String getLeave_time() {
        return leave_time;
    }

    public String getDay() {
        return day;
    }

    public boolean getPresence() {return presence;}
    public void create_subordinate_presence(){}

}
