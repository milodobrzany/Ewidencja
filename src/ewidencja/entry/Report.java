package ewidencja.entry;

import ewidencja.activity.Absence;
import ewidencja.activity.Presence;

import java.util.List;

public class Report {
    List<Entry> entries;

    public Report(){}
    public void generate_report(){}
    public boolean is_download_successful(){return true;}
    public void show_entry_details(int id){}
    public void add_presence(Presence presence){}
    public void add_absence(Absence absence){}
}
