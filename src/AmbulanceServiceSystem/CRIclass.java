/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AmbulanceServiceSystem;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author zhass
 */
public class CRIclass {
    private static CRIclass inst = null;
    private String Name = "Zain Hassan";
    private String ID_Card = "3840306751147";
    private String Contact_Number = "03360634874";
    private String gender="Male";
    private String special_ID="admin";
    private String pass="admin";

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPass() {
        return pass;
    }

    private Linked_List<CTWOs> ctwo_List = new Linked_List<>();

    public void setCtwo_List(Linked_List<CTWOs> ctwo_List) {
        this.ctwo_List = ctwo_List;
    }

    public void setQueue_ctwo(Queue_For_Jobs<CTWOs> Queue_ctwo) {
        this.Queue_ctwo = Queue_ctwo;
    }

    public Linked_List<CTWOs> getCtwo_List() {
        return ctwo_List;
    }

    public Queue_For_Jobs<CTWOs> getQueue_ctwo() {
        return Queue_ctwo;
    }
    private Queue_For_Jobs<CTWOs> Queue_ctwo = new Queue_For_Jobs<>();

private CRIclass() {

    }

public static CRIclass getInst() {
        if (inst != null) {
            return inst;
        } else {
            inst = new CRIclass();
            return inst;
        }
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

    public static void setInst(CRIclass inst) {
        CRIclass.inst = inst;
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

public void Show_Table_Queue_CTWOs(JTable table) {
        DefaultTableModel model = new DefaultTableModel();
        Object[] coloumns = {"Name", "ID Card", "Apply For", "Shift", "Contact Number", "Special ID"};
        model.setColumnIdentifiers(coloumns);
        table.setModel(model);
        DefaultTableModel model1 = (DefaultTableModel) table.getModel();
        if (Queue_ctwo.peek() != null) {
            if (Queue_ctwo.peek().getClass().equals(CTWOs.class)) {
                Object obj = Queue_ctwo.peek();
                CTWOs ctwos = (CTWOs) obj;
                Object[] arr = new Object[6];
                arr[0] = ctwos.Name;
                arr[1] = ctwos.ID_Card;
                arr[2] = "CTWO";
                arr[3] = ctwos.getShift();
                arr[4] = ctwos.Contact_Number;
                arr[5] = ctwos.special_ID;
                model.addRow(arr);
            }

        }
    }

public void Show_Table_CTWOs(JTable table) {
        DefaultTableModel model = new DefaultTableModel();
        Object[] coloumns = {"Name", "ID Card", "Gender", "Shift", "Contact Number", "Special ID"};
        model.setColumnIdentifiers(coloumns);
        table.setModel(model);
        DefaultTableModel model1 = (DefaultTableModel) table.getModel();
        if(ctwo_List.getSize()==0)
        {
            
        }
        else{
        Node<CTWOs> cts = ctwo_List.getHead();
        for (; cts != null;) { 
            CTWOs ctws  = cts.getItem();
            
            Object[] arr = new Object[6];
            arr[0] = ctws.Name;
            arr[1] = ctws.ID_Card;
            arr[2] = ctws.gender;
            arr[3] = ctws.getShift();
            arr[4] = ctws.Contact_Number;
            arr[5] = ctws.special_ID;
            cts = cts.getNext();
            model.addRow(arr);
        }

    }
    }

}