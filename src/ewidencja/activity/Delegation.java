package ewidencja.activity;

public class Delegation {
     private String delegation_type;
     private String name;
     private String goal;
     private String arrival_place;
     private String transport_form;
     private String start_date;
     private String end_date;
     private boolean isConfirmed;

     public Delegation(){}
     public void create_absence(){}
     public boolean process_subordinate_absence(){return true;}

     public void setIsConfirmed(boolean isConfirmed) {}

     public void setStart_date(String start_date) {
          this.start_date = start_date;
     }

     public void setEnd_date(String end_date) {
          this.end_date = end_date;
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

     public void show_delegation(){}
}
