package ewidencja;

import ewidencja.employee.Employee;

import java.io.*;
import java.util.List;

public class ObjectIO {
    private static final String filepath= System.getProperty("user.dir") + "\\employees\\";
    File directoryPath = new File(filepath);
    File filesList[] = directoryPath.listFiles();

    public void WriteObjectToFile(Object serObj, String name, String surname) {

        try {

            FileOutputStream fileOut = new FileOutputStream(filepath + name + "_" + surname + ".dat");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(serObj);
            objectOut.close();
            //System.out.println("The Object  was succesfully written to a file");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Object ReadObjectFromFile(String name, String surname) {

        try {

            FileInputStream fileIn = new FileInputStream(filepath + name + "_" + surname + ".dat");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            Object obj = objectIn.readObject();

            //System.out.println("The Object has been read from the file");
            objectIn.close();
            return obj;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    private Object ReadObjectFromFile(File fileEntry) {

        try {

            FileInputStream fileIn = new FileInputStream(fileEntry);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            Object obj = objectIn.readObject();

            //System.out.println("The Object has been read from the file");
            objectIn.close();
            return obj;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void listFilesForFolder(List<Employee> employees) {
        for (File fileEntry : get_filesList()) {
            Employee employee = (Employee) this.ReadObjectFromFile(fileEntry);
            employees.add(employee);
        }
    }

    public File[] get_filesList() { return filesList; }
}
