package ewidencja.entry;

import ewidencja.activity.Absence;
import ewidencja.activity.Presence;

import java.util.List;

public class Report {
    List<Presence> presences;
    List<Absence> absences;
    int presenceCounter = 1;
    int absenceCounter = 1;

    public Report(){}
    public void generate_report(){}
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
