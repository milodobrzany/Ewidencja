package ewidencja.employee;

public class Schedule {
    private boolean status = false;
    private int left_vacation_days;
    private float overall_work_time;
    WeekDay week_days;

    public Schedule(){

    }

    public void show_schedule(){}
    private boolean is_download_successful(){return true;}
    public void create_schedule(){}
    public WeekDay getWeek_days(){return week_days;}
    public int getLeft_vacation_days(){return left_vacation_days;}
}
