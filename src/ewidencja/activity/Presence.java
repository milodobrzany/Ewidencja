package ewidencja.activity;

public class Presence {
    private boolean presence;
    private String day;
    private String arrival_time;
    private String leave_time;

    public Presence(){}
    public void create_presence(){}
    private boolean check_if_present(){return true;}

    public void setArrival_time(String arrival_time) {
        this.arrival_time = arrival_time;
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
