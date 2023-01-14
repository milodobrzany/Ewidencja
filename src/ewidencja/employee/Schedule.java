package ewidencja.employee;

import java.io.Serial;
import java.io.Serializable;

public class Schedule implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private boolean status = false;
    private int left_vacation_days;
    private float overall_work_time;
    WeekDay week_days;

    public Schedule(){
        left_vacation_days = 26;
    }

    public void show_schedule(){

    }
    private boolean is_download_successful(){
        return true;
    }
    public void create_schedule(){

    }
    public WeekDay getWeek_days(){
        return week_days;
    }
    public int getLeft_vacation_days(){
        return left_vacation_days;
    }
}
