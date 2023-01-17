package ewidencja.entry;

import ewidencja.activity.Absence;
import ewidencja.activity.Presence;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Report implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    List<Presence> presences;
    List<Absence> absences;
    int presenceCounter;
    int absenceCounter;

    public Report(){
        presences = new ArrayList<>();
        absences = new ArrayList<>();
        presenceCounter = 1;
        absenceCounter = 1;
    }
    public void generate_report(){
        for(Presence presenceEntry: presences){

            System.out.println("OBECNOSC");
            System.out.println("Id: " + presenceEntry.getId());
            System.out.println("Dzien: " + presenceEntry.getDay());
            System.out.println("Godzina rozpoczecia: " + presenceEntry.getArrival_time());
            System.out.println("Godzina zakonczenia: " + presenceEntry.getLeave_time());
            System.out.println("\n");
        }
        for(Absence absenceEntry: absences){
            absenceEntry.showAbsence();
            System.out.println("\n");
        }
    }
    public boolean is_download_successful(){return true;}
    public void show_entry_details(int id){}
    public void add_presence(Presence presence){
        presences.add(presence);
        presence.setId(presenceCounter);
        presenceCounter += 1;
    }
    public void add_absence(Absence absence){ //testy
        absences.add(absence);
        absence.setId(absenceCounter);
        absenceCounter += 1;
    }
    public Absence choose_absence(int id){
        for(Absence absenceEntry: absences){
            if(absenceEntry.getId() == id)
                return absenceEntry;
        }
        System.out.println("Podany wniosek nie istnieje w systemie!");
        return null;
    }
    public void deleteAbsence(int id){
        absences.remove(choose_absence(id));
        absenceCounter--;
    }

    public List<Absence> getAbsences() { return absences; }
}
