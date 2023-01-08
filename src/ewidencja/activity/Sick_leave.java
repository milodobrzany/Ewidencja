package ewidencja.activity;

public class Sick_leave {
    private boolean isConfirmed;
    private String start_date;
    private String end_date;

    public Sick_leave(){}
    public void create_absence(){}

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public void setIsConfirmed(boolean isConfirmed) {}

    public boolean process_subordinate_absence(){return true;}

}
