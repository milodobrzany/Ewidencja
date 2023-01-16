package ewidencja.activity;

import ewidencja.ObjectIO;
import ewidencja.employee.Employee;

import java.io.Serial;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
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
            try {
                setLeave_time();
            } catch (ParseException e) {
                e.printStackTrace();
            }
            objectIO.WriteObjectToFile(employee, employee.getName(), employee.getSurname());
            presenceFinished = true;
            System.out.println("Zaktualizowano obecnosc!\n");
        } else {

            setDay();
            try {
                setArrival_time();
            } catch (ParseException e) {
                e.printStackTrace();
            }
            presence = true;
            employee.getReport().add_presence(this);
            objectIO.WriteObjectToFile(employee, employee.getName(), employee.getSurname());
            System.out.println("Dodano obecnosc!\n");
        }
    }


    private boolean check_if_present(){
        return presence;
    }

    public void setArrival_time() throws ParseException {
        this.arrival_time = java.time.LocalTime.now().toString();
    }

    public void setLeave_time() throws ParseException {
        this.leave_time = java.time.LocalTime.now().toString();
    }

    public void managerSetTime(){/////////////////////////////
        Scanner scan = new Scanner(System.in);
        String input;

        boolean formatOK = true;
        do{
            System.out.println("Podaj dzien: ");
            input = scan.nextLine();
            Date dateA = null;
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                dateA = sdf.parse(input);
                if (!input.equals(sdf.format(dateA))) {
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
                this.day = input;
            }
        }while(!formatOK);

        do{
            System.out.println("Podaj godzine rozpoczecia: ");
            input = scan.nextLine();
            Date dateA = null;
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("kk:mm");
                dateA = sdf.parse(input);
                if (!input.equals(sdf.format(dateA))) {
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
                this.arrival_time = input;
            }
        }while(!formatOK);

        do{
            System.out.println("Podaj godzine zakonczenia: ");
            input = scan.nextLine();
            Date dateA = null;
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("kk:mm");
                dateA = sdf.parse(input);
                if (!input.equals(sdf.format(dateA))) {
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
                this.leave_time = input;
            }
        }while(!formatOK);

    }

    public void setDay() {
        this.day = java.time.LocalDate.now().toString();
    }

    public void setId(int id){
        this.id = id;
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
    public void create_subordinate_presence(Employee employee){
        ObjectIO objectIO = new ObjectIO();
        managerSetTime();
        employee.getReport().add_presence(this);
        objectIO.WriteObjectToFile(employee, employee.getName(), employee.getSurname());
        presence = true;
        presenceFinished = true;
    }

}
