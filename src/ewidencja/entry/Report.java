package ewidencja.entry;

import ewidencja.activity.Absence;
import ewidencja.activity.Presence;

import java.io.Serializable;
import java.util.List;

public class Report implements Serializable {
    private static final long serialVersionUID = 1L;
    List<Presence> presences;
    List<Absence> absences;
    int presenceCounter;
    int absenceCounter;

    public Report(){
        presenceCounter = 591324;
        absenceCounter = 1;
    }
    public void generate_report(){System.out.println(presenceCounter);}
    public boolean is_download_successful(){return true;}
    public void show_entry_details(int id){}
    public void add_presence(Presence presence){
        presences.add(presence);
        presence.setId(presenceCounter);
        presenceCounter += 1;
    }
    public void add_absence(Absence absence){
        absences.add(absence);
        absence.setId(absenceCounter);
        absenceCounter += 1;
    }
}
