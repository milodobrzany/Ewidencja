package ewidencja.activity;

import ewidencja.ObjectIO;
import ewidencja.employee.Employee;

import java.io.Serial;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public abstract class Absence implements iAbsence, Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    protected String absenceType;
    protected boolean isConfirmed;

    protected String start_date;
    protected String end_date;
    private int id;

    protected Absence(){}
    public void setIsConfirmed(boolean isConfirmed){
        this.isConfirmed = isConfirmed;
    }

    public boolean getIsConfirmed() { return isConfirmed; }
    public void setStart_date(){
        boolean formatOK = true;
        String start;
        do{
            Scanner scan = new Scanner(System.in);
            System.out.println("Podaj dzien rozpoczecia: ");
            start = scan.nextLine();
            Date date = null;
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                date = sdf.parse(start);
                if (!start.equals(sdf.format(date))) {
                    date = null;
                }
            } catch (ParseException ex) {
            }
            if (date == null){
                formatOK = false;
                System.out.println("Format wprowadzonych danych jest niepoprawny!");
            }
            else{
                formatOK = true;
            }
        }while(!formatOK);

        this.start_date = start;
    }
    public void setEnd_date(){
        boolean formatOK = true;
        String end;
        do{
            Scanner scan = new Scanner(System.in);
            System.out.println("Podaj dzien zakonczenia: ");
            end = scan.nextLine();
            Date dateA = null;
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                dateA = sdf.parse(end);
                if (!end.equals(sdf.format(dateA))) {
                    dateA = null;
                }
            } catch (ParseException ex) {
            }
            if (dateA == null){
                formatOK = false;
                System.out.println("Format wprowadzonych danych jest niepoprawny!");
            }
            else{
                formatOK = true;
            }
        }while(!formatOK);

        this.end_date = end;
    }

    public String getStart_date() {
        return start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void create_absence(Employee employee){
        isConfirmed = false;
        employee.getReport().add_absence(this);
        ObjectIO objectIO = new ObjectIO();
        objectIO.WriteObjectToFile(employee, employee.getName(), employee.getSurname());
        System.out.println("Dodano Absencje!\n");
    }
    public boolean process_subordinate_absence(){return true;}
    public void setId(int id){
        this.id = id;
    }
    public void showAbsence(){
        System.out.println("URLOP ");
        System.out.println("Id: " + id);
        System.out.println("Zatwierdzony przez pracodawce: " + isConfirmed);
        System.out.println("Dzien rozpoczecia: " + start_date);
        System.out.println("Dzien zakonczenia: " + end_date);
    }
    public long left_vacation_days(String start, String end){
        SimpleDateFormat sdf
                = new SimpleDateFormat(
                "yyyy-MM-dd");
        try {

            Date d1 = sdf.parse(start);
            Date d2 = sdf.parse(end);

            long difference_In_Time
                    = d2.getTime() - d1.getTime();

            long difference_In_Days
                    = (difference_In_Time / (1000 * 60 * 60 * 24));

            return difference_In_Days;
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        return 1000000;
    }
    public int getId(){
        return id;
    }
}
