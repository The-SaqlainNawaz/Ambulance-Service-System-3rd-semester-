/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AmbulanceServiceSystem;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javafx.scene.AmbientLight;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hassan Nawaz
 */
public class ASI {

    private static ASI inst = null;
    private int i=0;
    private String Name = "Saqlain Nawaz";
    private String ID_Card = "3840155482223";
    private String Contact_Number = "03454877942";
    private String gender = "Male";
    private String special_ID = "admin";
    private String pass = "admin";
    private Linked_List<EMTs> emt_List = new Linked_List<>();
    private Linked_List<Drivers> drivers_List = new Linked_List<>();
    private Queue_For_Jobs<EMTs> Queue_EMTs = new Queue_For_Jobs<>();
    private Queue_For_Jobs<Drivers> Queue_Drivers = new Queue_For_Jobs<>();
    private Linked_List<Ambulances> ambulance_List = new Linked_List<>();
    private Linked_List<Equipment> equip_List = new Linked_List<>();
    

    public int getI() {
        return i;
    }

    
    public String getPass() {
        return pass;
    }

    public Linked_List<Ambulances> getAmbulance_List() {
        return ambulance_List;
    }

    public Linked_List<Equipment> getEquip_List() {
        return equip_List;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setAmbulance_List(Linked_List<Ambulances> ambulance_List) {
        this.ambulance_List = ambulance_List;
    }

    public void setEquip_List(Linked_List<Equipment> equip_List) {
        this.equip_List = equip_List;
    }

    public Linked_List<EMTs> getEmt_List() {
        return emt_List;
    }

    public Linked_List<Drivers> getDrivers_List() {
        return drivers_List;
    }

    //private byte picture=WhatsApp Image 2021-12-07 at 3.52.36 PM;
    //constructor private........
    private ASI() {

    }

    public void setEmt_List(Linked_List<EMTs> emt_List) {
        this.emt_List = emt_List;
    }

    public void setDrivers_List(Linked_List<Drivers> drivers_List) {
        this.drivers_List = drivers_List;
    }

    public void setQueue_EMTs(Queue_For_Jobs<EMTs> Queue_EMTs) {
        this.Queue_EMTs = Queue_EMTs;
    }

    public void setQueue_Drivers(Queue_For_Jobs<Drivers> Queue_Drivers) {
        this.Queue_Drivers = Queue_Drivers;
    }

    public Queue_For_Jobs<EMTs> getQueue_EMTs() {
        return Queue_EMTs;
    }

    public Queue_For_Jobs<Drivers> getQueue_Drivers() {
        return Queue_Drivers;
    }

    //getter for inst............
    public static ASI getInst() {
        if (inst != null) {
            return inst;
        } else {
            inst = new ASI();
            return inst;
        }
    }

    public static long Hash_Function(String name) {
        int digit = 31;
        int mantisa = (int) (1e9 + 9);
        long power_of_digit = 1;
        long hash_val = 0;
        for (int i = 0; i < name.length(); i++) {
            hash_val = (hash_val + (name.charAt(i)
                    - 'a' + 1) * power_of_digit) % mantisa;
            power_of_digit = (power_of_digit * digit) % mantisa;
        }
        return hash_val;
    }

    public static void setInst(ASI inst) {
        ASI.inst = inst;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setID_Card(String ID_Card) {
        this.ID_Card = ID_Card;
    }

    public void setContact_Number(String Contact_Number) {
        this.Contact_Number = Contact_Number;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setSpecial_ID(String special_ID) {
        this.special_ID = special_ID;
    }

    public String getName() {
        return Name;
    }

    public String getID_Card() {
        return ID_Card;
    }

    public String getContact_Number() {
        return Contact_Number;
    }

    public String getGender() {
        return gender;
    }

    public String getSpecial_ID() {
        return special_ID;
    }

    //Table Functions........................................
    public void Show_Table_Queue_EMTs(JTable table) {
        DefaultTableModel model = new DefaultTableModel();
        Object[] coloumns = {"Name", "ID Card", "Apply For", "Shift", "Contact Number", "Special ID"};
        model.setColumnIdentifiers(coloumns);
        table.setModel(model);
        DefaultTableModel model1 = (DefaultTableModel) table.getModel();
        if (Queue_EMTs.peek() != null) {
            if (Queue_EMTs.peek().getClass().equals(EMTs.class)) {
                Object obj = Queue_EMTs.peek();
                EMTs emt = (EMTs) obj;
                Object[] arr = new Object[6];
                arr[0] = emt.Name;
                arr[1] = emt.ID_Card;
                arr[2] = "EMT";
                arr[3] = emt.getShift();
                arr[4] = emt.Contact_Number;
                arr[5] = emt.special_ID;
                model.addRow(arr);
            }

        }
    }

    public void Show_Table_Queue_Drivers(JTable table) {
        DefaultTableModel model = new DefaultTableModel();
        Object[] coloumns = {"Name", "ID Card", "Apply For", "Shift", "Contact Number", "Special ID"};
        model.setColumnIdentifiers(coloumns);
        table.setModel(model);
        DefaultTableModel model1 = (DefaultTableModel) table.getModel();
        if (Queue_Drivers.peek() != null) {

            if (Queue_Drivers.peek().getClass().equals(Drivers.class)) {
                Object obj = Queue_Drivers.peek();
                Drivers emt = (Drivers) obj;
                Object[] arr = new Object[6];
                arr[0] = emt.Name;
                arr[1] = emt.ID_Card;
                arr[2] = "Drivers";
                arr[3] = emt.getShift();
                arr[4] = emt.Contact_Number;
                arr[5] = emt.special_ID;
                model.addRow(arr);
            }

        }
    }

    public void Show_Table_EMTs(JTable table) {

        DefaultTableModel model = new DefaultTableModel();
        Object[] coloumns = {"Name", "ID Card", "Gender", "Shift", "Contact Number", "Special ID"};
        model.setColumnIdentifiers(coloumns);
        table.setModel(model);
        DefaultTableModel model1 = (DefaultTableModel) table.getModel();
        if (emt_List.getSize() == 0) {

        } else {
            Node<EMTs> emti = emt_List.getHead();
            for (; emti != null;) {
                EMTs emt = emti.getItem();

                Object[] arr = new Object[6];
                arr[0] = emt.Name;
                arr[1] = emt.ID_Card;
                arr[2] = emt.gender;
                arr[3] = emt.getShift();
                arr[4] = emt.Contact_Number;
                arr[5] = emt.special_ID;
                emti = emti.getNext();
                model.addRow(arr);
            }
        }
    }

    public void Show_Table_Drivers(JTable table) {
        DefaultTableModel model = new DefaultTableModel();
        Object[] coloumns = {"Name", "ID Card", "Gender", "Shift", "Contact Number", "Special ID"};
        model.setColumnIdentifiers(coloumns);
        table.setModel(model);
        DefaultTableModel model1 = (DefaultTableModel) table.getModel();
        if (drivers_List.getSize() == 0) {

        } else {
            Node<Drivers> emti = drivers_List.getHead();
            for (; emti != null;) {
                Drivers emt = emti.getItem();

                Object[] arr = new Object[6];
                arr[0] = emt.Name;
                arr[1] = emt.ID_Card;
                arr[2] = emt.gender;
                arr[3] = emt.getShift();
                arr[4] = emt.Contact_Number;
                arr[5] = emt.special_ID;
                emti = emti.getNext();
                model.addRow(arr);
            }

        }
    }

    public void Show_Table_Ambulances(JTable table) {
        DefaultTableModel model = new DefaultTableModel();
        Object[] coloumns = {"Model", "Plate Number", "Type", "Equipments"};
        model.setColumnIdentifiers(coloumns);
        table.setModel(model);
        DefaultTableModel model1 = (DefaultTableModel) table.getModel();
        if (ambulance_List.getSize() == 0) {

        } else {
            Node<Ambulances> emti = ambulance_List.getHead();
            for (; emti != null;) {
                Ambulances emt = emti.getItem();

                Object[] arr = new Object[4];
                arr[0] = emt.getModel();
                arr[1] = emt.getNumber();
                arr[2] = emt.getType();
                arr[3] = "";

                if (emt.getAmb_Equip().getSize() > 0) {
                    Node<Equipment> equp = emt.getAmb_Equip().getHead();
                    for (; equp != null;) {
                        Equipment f = equp.getItem();
                        arr[3] = arr[3] + f.getName() + ",";
                        equp = equp.getNext();
                    }
                }
                emti = emti.getNext();
                model.addRow(arr);
            }

        }
    }

    public void Show_Table_Equipmet(JTable table) {
        DefaultTableModel model = new DefaultTableModel();
        Object[] coloumns = {"Name", "Amount", "Used For"};
        model.setColumnIdentifiers(coloumns);
        table.setModel(model);
        DefaultTableModel model1 = (DefaultTableModel) table.getModel();
        if (equip_List.getSize() == 0) {

        } else {
            Node<Equipment> emti = equip_List.getHead();
            for (; emti != null;) {
                Equipment emt = emti.getItem();

                Object[] arr = new Object[3];
                arr[0] = emt.getName();
                arr[1] = emt.getAmount();
                arr[2] = emt.getUsed_for();
                emti = emti.getNext();
                model.addRow(arr);
            }

        }
    }

    public Equipment Searc_Equip(String name) {
        Node<Equipment> equip = equip_List.getHead();
        i=0;
        for (; equip != null;) {
            if (equip.getItem().getName().equals(name)) {
                return equip.getItem();
            }
            equip = equip.getNext();
            i++;
        }
        return null;
    }

    public void save_EMTs() throws IOException {
        try {
            FileWriter wright = new FileWriter("EMTs.txt");
            String out = "";
            Node<EMTs> emt = emt_List.getHead();
            for (; emt != null;) {
                out = out + emt.getItem().Name + ",";
                out = out + emt.getItem().Contact_Number + ",";
                out = out + emt.getItem().ID_Card + ",";
                out = out + emt.getItem().gender + ",";
                out = out + emt.getItem().getShift() + ",";
                out = out + emt.getItem().getPass() + ",";
                out = out + emt.getItem().special_ID + "\n";
                emt = emt.getNext();
            }
            wright.write(out);
            wright.flush();
            wright.close();
        } catch (Exception ex) {

        }
    }

    public void Load_EMT() {
        try {
            FileReader read = new FileReader("EMTs.txt");
            BufferedReader readbuff = new BufferedReader(read);
            String input = "-1";

            while (input != "") {

                input = readbuff.readLine();
                String[] split = input.split(",");
                EMTs eMTs = new EMTs(split[5], 0, 0, split[4], split[0], split[2], split[1], "", split[3], Long.parseLong(split[6]));
                if (emt_List.getSize() == 0) {
                    emt_List.insertFirst(eMTs);
                } else {
                    emt_List.insertNode(eMTs);
                }
               

            }
        } catch (Exception ex) {

        }

    }

    public void save_Drivers() throws IOException {
        try {
            FileWriter wright = new FileWriter("Drivers.txt");
            String out = "";
            Node<Drivers> emt = drivers_List.getHead();
            for (; emt != null;) {
                out = out + emt.getItem().Name + ",";
                out = out + emt.getItem().Contact_Number + ",";
                out = out + emt.getItem().ID_Card + ",";
                out = out + emt.getItem().gender + ",";
                out = out + emt.getItem().getShift() + ",";
                out = out + emt.getItem().getPass() + ",";
                out = out + emt.getItem().special_ID + "\n";
                emt = emt.getNext();
            }
            wright.write(out);
            wright.flush();
            wright.close();
        } catch (Exception ex) {

        }
    }

    public void Load_Drivers() {
        try {
            FileReader read = new FileReader("Drivers.txt");
            BufferedReader readbuff = new BufferedReader(read);
            String input = "-1";

            while (input != "") {

                input = readbuff.readLine();
                String[] split = input.split(",");
                Drivers eMTs = new Drivers(split[5], 0, split[4], split[0], split[2], split[1], "", split[3], Long.parseLong(split[6]));
                if (drivers_List.getSize() == 0) {
                    drivers_List.insertFirst(eMTs);
                } else {
                    drivers_List.insertNode(eMTs);
                }

            }
        } catch (Exception ex) {

        }

    }
    
    public void save_Qeuies_EMTs() throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("save_Qeuies_EMTs"));
        out.writeObject(Queue_EMTs);
        out.close();

    }
    
    public void Load_Queuies_EMTs() throws FileNotFoundException, IOException, ClassNotFoundException
    {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("save_Qeuies_EMTs"));
        Queue_For_Jobs<EMTs> emt = (Queue_For_Jobs<EMTs>)in.readObject();
        this.Queue_EMTs=emt;
    }
    
      public void save_Qeuies_Drivers() throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("save_Qeuies_Drivers"));
        out.writeObject(Queue_Drivers);
        out.close();

    }
    
    public void Load_Queuies_Drivers() throws FileNotFoundException, IOException, ClassNotFoundException
    {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("save_Qeuies_Drivers"));
        Queue_For_Jobs<Drivers> emt = (Queue_For_Jobs<Drivers>)in.readObject();
        this.Queue_Drivers=emt;
    }
    
     public void save_Ambulances() throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Ambulances"));
        out.writeObject(ambulance_List);
        out.close();

    }
    
    public void Load_Ambulances() throws FileNotFoundException, IOException, ClassNotFoundException
    {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("Ambulances"));
        Linked_List<Ambulances> emt = (Linked_List<Ambulances>)in.readObject();
        this.ambulance_List=emt;
    }
    
        public void save_Equipment() throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Equipments"));
        out.writeObject(equip_List);
        out.close();

    }
    
    public void Load_Equipment() throws FileNotFoundException, IOException, ClassNotFoundException
    {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("Equipments"));
        Linked_List<Equipment> emt = (Linked_List<Equipment>)in.readObject();
        this.equip_List=emt;
    }
    
    
}
