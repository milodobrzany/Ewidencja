package ewidencja.activity;

import ewidencja.employee.Employee;

import java.io.Serial;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Leave extends Absence implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    public Leave(){}

    @Override
    public void create_absence(Employee employee){
        super.create_absence(employee);
    }

    @Override
    public void setStart_date() {
        super.setStart_date();
    }

    @Override
    public void setEnd_date() {
        super.setEnd_date();
    }

    public long left_vacation_days(String start, String end){
        return super.left_vacation_days(start, end);
    }

    @Override
    public boolean process_subordinate_absence(){
        return super.process_subordinate_absence();
    }

    @Override
    public void showAbsence() {
        super.showAbsence();
    }
}
