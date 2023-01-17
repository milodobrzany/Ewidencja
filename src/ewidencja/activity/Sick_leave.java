package ewidencja.activity;

import ewidencja.employee.Employee;

public class Sick_leave extends Absence{
    public Sick_leave(){}

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

    @Override
    public void setIsConfirmed(boolean isConfirmed) {
        super.setIsConfirmed(isConfirmed);
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
