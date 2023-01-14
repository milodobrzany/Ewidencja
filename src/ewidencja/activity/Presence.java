package ewidencja.activity;

import ewidencja.ObjectIO;
import ewidencja.employee.Employee;

import java.io.Serial;
import java.io.Serializable;
import java.util.Scanner;

public class Presence implements iPresence, Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private boolean presence;
    private boolean presenceFinished;
    private String day;
    private String arrival_time;
    private String leave_time;
    private int id;

    public Presence(){
        presence = false;
        presenceFinished = false;
    }

    @Override
    public void create_presence(Employee employee){
        ObjectIO objectIO = new ObjectIO();
        if(check_if_present()){
            setLeave_time();
            objectIO.WriteObjectToFile(employee, employee.getName(), employee.getSurname());
            presenceFinished = true;
        } else {

            setDay();
            setArrival_time();
            presence = true;
            employee.getReport().add_presence(this);
            objectIO.WriteObjectToFile(employee, employee.getName(), employee.getSurname());
            System.out.println("Dodano obecnosc!\n");
        }
    }


    private boolean check_if_present(){
        return presence;
    }

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

    public void update_presence(){

    }

    public String getArrival_time() {
        return arrival_time;
    }

    public String getLeave_time() {
        return leave_time;
    }

    public String getDay() {
        return day;
    }
    public int getId() {
        return id;
    }

    public boolean getPresence() {
        return presence;
    }

    public boolean getPresenceFinished() {
        return presenceFinished;
    }
    public void create_subordinate_presence(){

    }

}
