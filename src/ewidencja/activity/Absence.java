package ewidencja.activity;

public class Absence {
    protected boolean isConfirmed;
    protected String start_date;
    protected String end_date;
    private int id;

    protected Absence(){}
    protected void setIsConfirmed(boolean isConfirmed){}
    protected void setStart_date(String start_date){}
    protected void setEnd_date(String end_date){}
    public void create_absence(){}
    public boolean process_subordinate_absence(){return true;}
    public void setId(int id){
        this.id = id;
    }
}
