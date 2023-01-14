package ewidencja.activity;

import ewidencja.employee.Employee;

public class Delegation extends Absence{
     private String delegation_type;
     private String name;
     private String goal;
     private String arrival_place;
     private String transport_form;
     private String start_date;
     private String end_date;
     private boolean isConfirmed;

     public Delegation(){}

     @Override
     public void create_absence(Employee employee){
          super.create_absence(employee);
     }

     @Override
     public boolean process_subordinate_absence(){
          return super.process_subordinate_absence();
     }

     @Override
     public void setIsConfirmed(boolean isConfirmed) {
          super.setIsConfirmed(isConfirmed);
     }

     @Override
     public void setStart_date() {
          super.setStart_date();
     }

     @Override
     public void setEnd_date() {
          super.setEnd_date();
     }

     public void setName(String name) {
          this.name = name;
     }

     public void setGoal(String goal) {
          this.goal = goal;
     }

     public void setArrival_place(String arrival_place) {
          this.arrival_place = arrival_place;
     }

     public void setTransport_form(String transport_form) {
          this.transport_form = transport_form;
     }

     @Override
     public void showAbsence() {
          super.showAbsence();
     }
}
