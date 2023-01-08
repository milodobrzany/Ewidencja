package ewidencja.activity;

public class Leave {
    private boolean isConfirmed;
    private String start_date;
    private String end_date;

    public Leave(){}
    public void create_absence(){}

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    private boolean left_vacation_days(int days_left){return true;}
    public boolean process_subordinate_absence(){return true;}

}
