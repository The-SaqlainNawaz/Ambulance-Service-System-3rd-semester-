/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AmbulanceServiceSystem;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Hassan Nawaz
 */
public class Ambulanmce_Service_System {

    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
       new splashscreen.SplashScreen(null, true).setVisible(true);
          ASI asi=ASI.getInst();
          asi.Load_EMT();
          asi.Load_Drivers();
          asi.Load_Queuies_EMTs();
          asi.Load_Queuies_Drivers();
          asi.Load_Ambulances();
          asi.Load_Equipment();
//        EMTs as=new EMTs("adaaaaa",0, 0, "dasd", "SAQii", "asdasd", "asdasd", "asdas", "adasdas", 0);
//        EMTs p=new EMTs("adaaaaa",0, 0, "dasd", "Sherii", "asdasd", "asdasd", "asdas", "adasdas", 0);
//        
//        Stack<EMTs> s=new Stack<>();
//        s.push(as);
//        s.push(p);
//        Node<EMTs> head=s.getTop();
//        for(;head!=null;)
//        {
//            System.out.println(head.getItem().Name);
//            head=head.getNext();
//        }
//        EMTs n=s.pop();
//        System.out.println(n.Name);
//        //asi.getQueue_Job().enqueue(as);
//        Object ov=asi.getQueue_Job().peek();
//        System.out.println(ov.getClass());
//        if(ov.getClass()==EMTs.class)
//        {
//        EMTs mm=(EMTs)ov;
//        System.out.println(mm.Name);
//        }
        //System.out.println(ov.Name);
//        Detail_Form f = new Detail_Form();
//        f.setVisible(true);
//        f.show();
//         Login form=new Login();
//         form.setVisible(true);

        // System.out.println(asi.Hash_Function("Saqii"));
//        Linked_List<EMTs> list = new Linked_List<>();
//        EMTs ll = new EMTs(0, 0, "sdf", "Sherii", "sdafasd", "dfsd", "sdf", "aaaaaaaaaaaaaa", 0);
//        list.insertFirst(ll);
//        EMTs fg = list.findNodeAt(0);
//        System.out.println(fg.Name);

    }

}
