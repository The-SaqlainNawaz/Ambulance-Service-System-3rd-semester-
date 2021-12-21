/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AmbulanceServiceSystem;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Proud To Be Muslims
 */
public class ASI_GUI extends javax.swing.JFrame {

    private ASI asi = ASI.getInst();
    private JPanel panels[] = new JPanel[7];
    //private JLabel[] jLabel_Array={getJ_1(),getJ_2(),getJ_3(),getJ_4(),getJ_5(),getJ_6(),getJ_7(),getJ_8(),getJ_9(),getJ_10()};
    private int[] park_availbale={0,0,0,0,0,0,0,0,0,0};

    public JLabel getJ_1() {
        return j_1;
    }

    public JLabel getJ_10() {
        return j_10;
    }

    public JLabel getJ_2() {
        return j_2;
    }

    public JLabel getJ_3() {
        return j_3;
    }

    public JLabel getJ_4() {
        return j_4;
    }

    public JLabel getJ_5() {
        return j_5;
    }

    public JLabel getJ_6() {
        return j_6;
    }

    public JLabel getJ_7() {
        return j_7;
    }

    public JLabel getJ_8() {
        return j_8;
    }

    public JLabel getJ_9() {
        return j_9;
    }
    
    public int labelo(String l,int i)
    {
        int re=-1;
        for(int j=0;j<10;j++)
        {
            if(Integer.parseInt(l)==i)
            {
                re=i;
                System.out.println("re :"+re);
                System.out.println("Label text :"+l);
                break;
            }
        }
        return re;
        
    }
    

    public JButton getjButton2() {
        return jButton2;
    }

    public JButton getjButton3() {
        return jButton3;
    }

     public JButton getjButton8() {
        return jButton8;
    }
    public JButton getupdate() {
        return update;
    }

    public JButton getupdate1() {
        return update1;
    }
    public JButton getjButton4() {
        return jButton4;
    }
    public JTable getjTable() {
        return jTable7;
    }
    /**
     * Creates new form MainLayout
     */
    public ASI_GUI() throws IOException, FileNotFoundException, ClassNotFoundException {
        initComponents();
        jPanel3.setVisible(false);
        Minimize.setVisible(true);
        fillarr(); 
        Load_Parking_Availabet();
        selectedPanel(Dashboard);
        asi.Show_Table_Queue_EMTs(jTable1);
        asi.Show_Table_EMTs(jTable2);
        asi.Show_Table_Queue_Drivers(jTable6);
        asi.Show_Table_Drivers(jTable7);
        asi.Show_Table_Ambulances(jTable3);
        asi.Show_Table_Equipmet(jTable4);
       
       
    }

    public void fillarr() {
        panels[0] = Dashboard;
        panels[1] = Main_EMTs_Panel;
        panels[2] = Main_Ambulance_Panel;
        panels[3] = Main_Emergency_Panel;
        panels[4] = Main_Parking_Panel;
        panels[5] = Main_Driver_Panel;
        panels[6] = Account_ASI_Main;
    }

//    public JTable stafftable()
//    {
//      return
//    }
    
    public void Set_All_Amb_icon()
    {  
        System.out.println(park_availbale[0]);
            if(park_availbale[0]==1)
            {
                set_Park_Icon(j_1);
            }
            if(park_availbale[1]==1)
            {
                set_Park_Icon(j_2);
            }
            if(park_availbale[2]==1)
            {
                set_Park_Icon(j_3);
            }
            if(park_availbale[3]==1)
            {
                set_Park_Icon(j_4);
            }
            if(park_availbale[4]==1)
            {
                set_Park_Icon(j_5);
            }
            if(park_availbale[5]==1)
            {
                set_Park_Icon(j_6);
            }
            if(park_availbale[6]==1)
            {
                set_Park_Icon(j_7);
            }
            if(park_availbale[7]==1)
            {
                set_Park_Icon(j_8);
            }
            if(park_availbale[8]==1)
            {
                
                set_Park_Icon(j_9);
            }
            if(park_availbale[9]==1)
            {
                set_Park_Icon(j_10);
            }
    }
    
    public void save_int_array() throws FileNotFoundException, IOException
    {
         ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Parking Array"));
        out.writeObject(park_availbale);
        out.close();
    }
     public void Load_Parking_Availabet() throws FileNotFoundException, IOException, ClassNotFoundException
    {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("Parking Array"));
        int[]a = (int[])in.readObject();
        this.park_availbale=a;
    }
    
    public void set_Park_Icon(JLabel l){
       File f = new File("..\\Ambulance Service System\\src\\Icon\\" + "icons8-ambulance-25.png");
        try {
            BufferedImage img = null;
            System.out.println("exception1");
            img = ImageIO.read(new File(f.getAbsolutePath()));
            System.out.println("exception2");
            Image img1 = img.getScaledInstance(l.getWidth(), l.getHeight(), Image.SCALE_SMOOTH);
            System.out.println("exception3");
            ImageIcon format = new ImageIcon(img1);
            System.out.println("exception4");
            l.setIcon(format);
            System.out.println("exception5");
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    public void selectedPanel(JPanel panel) {
        for (JPanel panel1 : panels) {
            panel1.setVisible(false);
        }
        panel.setVisible(true);
    }

    public void changecolor(JButton hover, Color rand) {
        hover.setBackground(rand);
    }

    public void changecolor(JPanel hover, Color rand) {
        hover.setBackground(rand);
    }
    
    public void delet_euip(String name,int row)
    {
       Ambulances obj=null;    
       obj=asi.getAmbulance_List().findNodeAt(row); 
       Equipment equip=null;
        Node<Equipment> n=obj.getAmb_Equip().getHead();
        Node<Equipment>preivious=null;
           for(;n!=null;)
           {
               preivious=n;
               if(n.getItem().getName().equals(name))
               {
                   obj.getAmb_Equip().deleteNthNode(preivious.getItem());
               }
               n=n.getNext();
           }        
    }
    public boolean comb0_is_selected(String name,int row)
    {
       Ambulances obj=null;    
       obj=asi.getAmbulance_List().findNodeAt(row); 
       Equipment equip=null;
        boolean flag=false;
        Node<Equipment> n=obj.getAmb_Equip().getHead();
           for(;n!=null;)
           {
               if(n.getItem().getName().equals(name))
               {
                   flag=true;
               }
               n=n.getNext();
           }
           
           return flag;
        
    }

    ///Functions................................................................
    public void add_Equipment()
    {
      String name=jComboBox2.getSelectedItem().toString();
      int amount=Integer.parseInt(name_apply4.getText());
      String use=name_apply5.getText();
      Equipment obj=new Equipment(name, amount, use);
      Equipment check=asi.Searc_Equip(name);
      if(check==null){
      if(asi.getEquip_List().getSize()==0)
      {
          asi.getEquip_List().insertFirst(obj);
      }
      else{
          asi.getEquip_List().insertNode(obj);
      }
      }
      else
      {
          check.setAmount(check.getAmount()+ amount);
          if(asi.getEquip_List().getSize()==0)
      {
          asi.getEquip_List().insertFirst(obj);
      }
      else{
          asi.getEquip_List().insertNth(obj);
      }
      }
      
     // JOptionPane.showMessageDialog(null,obj.getName());
    }
    
   public void add_Ambulnaces()
   {
       String name=name_apply2.getText();
       String number=name_apply7.getText();
       String type = jComboBox1.getSelectedItem().toString();
        int index_label=-1;
       Ambulances amb=new Ambulances(name, type, number);
       for(int i=0;i<10;i++)
                {
                   
                    if(park_availbale[i]==0)
                    {
                        // System.out.println("SetParking");
                        park_availbale[i]=1;
                        
                        
                        
                        index_label=labelo(j_1.getText(),i);
                        
                        if(index_label!=-1)
                        {
                        amb.setJlable(index_label);
                        set_Park_Icon(j_1);
                        }
                        
                        index_label=labelo(j_2.getText(),i);
                        
                       
                        if(index_label!=-1)
                        {
                             amb.setJlable(index_label);
                              set_Park_Icon(j_2);
                        
                        }
                        index_label=labelo(j_3.getText(),i);
                        if(index_label!=-1)
                        {
                             amb.setJlable(index_label);
                              set_Park_Icon(j_3);
                        
                        }
                        index_label=labelo(j_4.getText(),i);
                        if(index_label!=-1)
                        {
                             amb.setJlable(index_label);
                              set_Park_Icon(j_4);
                        
                        }
                        index_label=labelo(j_5.getText(),i);
                        if(index_label!=-1)
                        {
                             amb.setJlable(index_label);
                              set_Park_Icon(j_5);
                        
                        }
                        index_label=labelo(j_6.getText(),i);
                        if(index_label!=-1)
                        {
                             amb.setJlable(index_label);
                              set_Park_Icon(j_6);
                        
                        }
                        index_label=labelo(j_7.getText(),i);
                        if(index_label!=-1)
                        {
                             amb.setJlable(index_label);
                              set_Park_Icon(j_7);
                        
                        }
                        index_label=labelo(j_8.getText(),i);
                        if(index_label!=-1)
                        {
                             amb.setJlable(index_label);
                              set_Park_Icon(j_8);
                      
                        }
                        index_label=labelo(j_9.getText(),i);
                        if(index_label!=-1)
                        {
                        amb.setJlable(index_label);
                         set_Park_Icon(j_9);
                       
                        }
                        index_label=labelo(j_10.getText(),i);
                        if(index_label!=-1)
                        {
                        amb.setJlable(index_label);
                         set_Park_Icon(j_10);
                        
                        }
                        break;
                    }
                }
      
       Equipment obj=null;
       if(jCheckBox5.isSelected())
       {         
           obj=asi.Searc_Equip(jCheckBox5.getText());
          
           if(obj!=null)
           {
               obj.setAmount(obj.getAmount()-1);
               if(obj.getAmount()<=0)
               {
                    asi.getEquip_List().deleteNthNode(obj);
               }
               else
               {
                    asi.getEquip_List().insertNth(obj);
               }
              
               amb.getAmb_Equip().insertNode(obj);
           }
           
           else
           {
               
                JOptionPane.showMessageDialog(null, jCheckBox5.getText()+" is Missing From Inventory");
           }
       }
       if(jCheckBox6.isSelected())
       {
           obj=asi.Searc_Equip(jCheckBox6.getText());         
           if(obj!=null)
           {
               obj.setAmount(obj.getAmount()-1);
               if(obj.getAmount()<=0)
               {
                    asi.getEquip_List().deleteNthNode(obj);
               }
               else
               {
                    asi.getEquip_List().insertNth(obj);
               }
               amb.getAmb_Equip().insertNode(obj);
           }
           else
           {
                JOptionPane.showMessageDialog(null, jCheckBox6.getText()+" is Missing From Inventory");
           }
       }
       if(jCheckBox7.isSelected())
       {
            obj=asi.Searc_Equip(jCheckBox7.getText());
           if(obj!=null)
           {
               obj.setAmount(obj.getAmount()-1);
               if(obj.getAmount()<=0)
               {
                    asi.getEquip_List().deleteNthNode(obj);
               }
               else
               {
                    asi.getEquip_List().insertNth(obj);
               }
               amb.getAmb_Equip().insertNode(obj);
           }
           else
           {
                JOptionPane.showMessageDialog(null, jCheckBox7.getText()+" is Missing From Inventory");
           }
       }
       if(jCheckBox2.isSelected())
       {
           obj=asi.Searc_Equip(jCheckBox2.getText());
           if(obj!=null)
           {
               obj.setAmount(obj.getAmount()-1);
               if(obj.getAmount()<=0)
               {
                    asi.getEquip_List().deleteNthNode(obj);
               }
               else
               {
                    asi.getEquip_List().insertNth(obj);
               }
               amb.getAmb_Equip().insertNode(obj);
           }
           else
           {
                JOptionPane.showMessageDialog(null, jCheckBox2.getText()+" is Missing From Inventory");
           }
       }
       
       asi.getAmbulance_List().insertFirst(amb);
   }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Dashboard = new javax.swing.JPanel();
        EMTs_Button_Dashboard = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        Ambulances_Button_Dashboard = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        Drivers_Button_Dashboard = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        Emergencies_Button_Dashboard = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        Parking = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        Park_1 = new javax.swing.JPanel();
        Park_2 = new javax.swing.JPanel();
        Park_3 = new javax.swing.JPanel();
        Park_4 = new javax.swing.JPanel();
        Park_5 = new javax.swing.JPanel();
        Park_6 = new javax.swing.JPanel();
        Park_7 = new javax.swing.JPanel();
        Park_8 = new javax.swing.JPanel();
        Park_9 = new javax.swing.JPanel();
        Park_10 = new javax.swing.JPanel();
        about = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        Main_EMTs_Panel = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        Hire_EMTs = new javax.swing.JPanel();
        Decline = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        All_Emit_Detail = new javax.swing.JPanel();
        Apply_Button1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        update = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel32 = new javax.swing.JLabel();
        name_apply = new javax.swing.JTextField();
        Account_ASI_Main = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        upadte_Profile = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel53 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        Main_Ambulance_Panel = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        name_apply2 = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        name_apply6 = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        EDIT_Ambulance = new javax.swing.JButton();
        add_ambulance1 = new javax.swing.JButton();
        jLabel58 = new javax.swing.JLabel();
        name_apply7 = new javax.swing.JTextField();
        Apply_Button3 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        Edit_Equipment = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel42 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        name_apply4 = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        name_apply5 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        add_ambulance2 = new javax.swing.JButton();
        jLabel59 = new javax.swing.JLabel();
        name_apply8 = new javax.swing.JTextField();
        Apply_Button = new javax.swing.JButton();
        Main_Emergency_Panel = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        name_apply9 = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel61 = new javax.swing.JLabel();
        EDIT_Ambulance1 = new javax.swing.JButton();
        Main_Parking_Panel = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        j_1 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        j_2 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        j_3 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        j_4 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        j_9 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        j_8 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        j_7 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        j_6 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        j_5 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        j_10 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        Main_Driver_Panel = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        Hire_Driver = new javax.swing.JPanel();
        Decline1 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        All_Driver = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        update1 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        jLabel33 = new javax.swing.JLabel();
        name_apply1 = new javax.swing.JTextField();
        Apply_Button2 = new javax.swing.JButton();
        Side_Menu_Main = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        database = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        login = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        logout = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        Dashboarbbutton = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        searchbutton = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        accountbutton = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        set1 = new javax.swing.JLabel();
        set2 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        Minimize = new javax.swing.JPanel();
        exit2 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        mxmize2 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        minimize2 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Application");
        setBackground(new java.awt.Color(26, 100, 162));
        setForeground(java.awt.Color.darkGray);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Dashboard.setBackground(new java.awt.Color(26, 100, 162));
        Dashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DashboardMouseClicked(evt);
            }
        });
        Dashboard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        EMTs_Button_Dashboard.setBackground(new java.awt.Color(255, 255, 255));
        EMTs_Button_Dashboard.setForeground(new java.awt.Color(156, 156, 156));
        EMTs_Button_Dashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EMTs_Button_DashboardMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                EMTs_Button_DashboardMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                EMTs_Button_DashboardMouseExited(evt);
            }
        });
        EMTs_Button_Dashboard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-technician-50.png"))); // NOI18N
        jLabel11.setToolTipText("");
        EMTs_Button_Dashboard.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 60, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText("EMTs");
        EMTs_Button_Dashboard.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 60, 50));

        Dashboard.add(EMTs_Button_Dashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 170, 190));

        Ambulances_Button_Dashboard.setBackground(new java.awt.Color(255, 255, 255));
        Ambulances_Button_Dashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Ambulances_Button_DashboardMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Ambulances_Button_DashboardMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Ambulances_Button_DashboardMouseExited(evt);
            }
        });
        Ambulances_Button_Dashboard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-ambulance-50.png"))); // NOI18N
        Ambulances_Button_Dashboard.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, -1, 60));

        jLabel47.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel47.setText("Ambulances");
        Ambulances_Button_Dashboard.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, 50));

        Dashboard.add(Ambulances_Button_Dashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 170, 190));

        Drivers_Button_Dashboard.setBackground(new java.awt.Color(255, 255, 255));
        Drivers_Button_Dashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Drivers_Button_DashboardMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Drivers_Button_DashboardMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Drivers_Button_DashboardMouseExited(evt);
            }
        });
        Drivers_Button_Dashboard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-driver-50.png"))); // NOI18N
        Drivers_Button_Dashboard.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, -1, -1));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        Drivers_Button_Dashboard.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, -20, -1, 10));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setText("Drivers");
        Drivers_Button_Dashboard.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, -1, 20));

        Dashboard.add(Drivers_Button_Dashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, 170, 190));

        Emergencies_Button_Dashboard.setBackground(new java.awt.Color(255, 255, 255));
        Emergencies_Button_Dashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Emergencies_Button_DashboardMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Emergencies_Button_DashboardMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Emergencies_Button_DashboardMouseExited(evt);
            }
        });
        Emergencies_Button_Dashboard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-medical-file-50.png"))); // NOI18N
        Emergencies_Button_Dashboard.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, -1, -1));

        jLabel46.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel46.setText("Emergrncies");
        Emergencies_Button_Dashboard.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, 20));

        jLabel49.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel49.setText("Emergrncies");
        Emergencies_Button_Dashboard.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, 20));

        Dashboard.add(Emergencies_Button_Dashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 170, 190));

        Parking.setBackground(new java.awt.Color(255, 255, 255));
        Parking.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ParkingMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ParkingMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ParkingMouseExited(evt);
            }
        });
        Parking.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-parking-50.png"))); // NOI18N
        Parking.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 60, 60));

        jLabel48.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel48.setText("Parking");
        Parking.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 60, 20));

        Park_1.setBackground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout Park_1Layout = new javax.swing.GroupLayout(Park_1);
        Park_1.setLayout(Park_1Layout);
        Park_1Layout.setHorizontalGroup(
            Park_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        Park_1Layout.setVerticalGroup(
            Park_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        Parking.add(Park_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 20, 20));

        Park_2.setBackground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout Park_2Layout = new javax.swing.GroupLayout(Park_2);
        Park_2.setLayout(Park_2Layout);
        Park_2Layout.setHorizontalGroup(
            Park_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        Park_2Layout.setVerticalGroup(
            Park_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        Parking.add(Park_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        javax.swing.GroupLayout Park_3Layout = new javax.swing.GroupLayout(Park_3);
        Park_3.setLayout(Park_3Layout);
        Park_3Layout.setHorizontalGroup(
            Park_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        Park_3Layout.setVerticalGroup(
            Park_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        Parking.add(Park_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, -1, -1));

        javax.swing.GroupLayout Park_4Layout = new javax.swing.GroupLayout(Park_4);
        Park_4.setLayout(Park_4Layout);
        Park_4Layout.setHorizontalGroup(
            Park_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        Park_4Layout.setVerticalGroup(
            Park_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        Parking.add(Park_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, -1, -1));

        javax.swing.GroupLayout Park_5Layout = new javax.swing.GroupLayout(Park_5);
        Park_5.setLayout(Park_5Layout);
        Park_5Layout.setHorizontalGroup(
            Park_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        Park_5Layout.setVerticalGroup(
            Park_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        Parking.add(Park_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, -1, -1));

        javax.swing.GroupLayout Park_6Layout = new javax.swing.GroupLayout(Park_6);
        Park_6.setLayout(Park_6Layout);
        Park_6Layout.setHorizontalGroup(
            Park_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        Park_6Layout.setVerticalGroup(
            Park_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        Parking.add(Park_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        javax.swing.GroupLayout Park_7Layout = new javax.swing.GroupLayout(Park_7);
        Park_7.setLayout(Park_7Layout);
        Park_7Layout.setHorizontalGroup(
            Park_7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        Park_7Layout.setVerticalGroup(
            Park_7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        Parking.add(Park_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        javax.swing.GroupLayout Park_8Layout = new javax.swing.GroupLayout(Park_8);
        Park_8.setLayout(Park_8Layout);
        Park_8Layout.setHorizontalGroup(
            Park_8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        Park_8Layout.setVerticalGroup(
            Park_8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        Parking.add(Park_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, -1, -1));

        Park_9.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout Park_9Layout = new javax.swing.GroupLayout(Park_9);
        Park_9.setLayout(Park_9Layout);
        Park_9Layout.setHorizontalGroup(
            Park_9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        Park_9Layout.setVerticalGroup(
            Park_9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        Parking.add(Park_9, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, -1, -1));

        javax.swing.GroupLayout Park_10Layout = new javax.swing.GroupLayout(Park_10);
        Park_10.setLayout(Park_10Layout);
        Park_10Layout.setHorizontalGroup(
            Park_10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        Park_10Layout.setVerticalGroup(
            Park_10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        Parking.add(Park_10, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, -1, -1));

        Dashboard.add(Parking, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 290, 170, 190));

        about.setBackground(new java.awt.Color(255, 255, 255));
        about.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                aboutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                aboutMouseExited(evt);
            }
        });

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-data-analysis-50.png"))); // NOI18N

        jLabel50.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel50.setText("Data Analysis");

        javax.swing.GroupLayout aboutLayout = new javax.swing.GroupLayout(about);
        about.setLayout(aboutLayout);
        aboutLayout.setHorizontalGroup(
            aboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aboutLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(aboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, aboutLayout.createSequentialGroup()
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        aboutLayout.setVerticalGroup(
            aboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aboutLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabel23)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        Dashboard.add(about, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 290, 170, 190));

        getContentPane().add(Dashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 720, 510));

        Main_EMTs_Panel.setBackground(new java.awt.Color(26, 100, 162));
        Main_EMTs_Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setBackground(new java.awt.Color(26, 100, 162));
        jTabbedPane1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jTabbedPane1.setAlignmentX(0.0F);
        jTabbedPane1.setAlignmentY(0.0F);
        jTabbedPane1.setAutoscrolls(true);
        jTabbedPane1.setOpaque(true);

        Hire_EMTs.setBackground(new java.awt.Color(26, 100, 162));
        Hire_EMTs.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        Hire_EMTs.setAutoscrolls(true);
        Hire_EMTs.setFocusCycleRoot(true);
        Hire_EMTs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Hire_EMTsMouseClicked(evt);
            }
        });
        Hire_EMTs.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Decline.setBackground(new java.awt.Color(102, 102, 255));
        Decline.setForeground(new java.awt.Color(255, 255, 255));
        Decline.setText("Decline");
        Decline.setBorder(null);
        Decline.setFocusPainted(false);
        Decline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeclineActionPerformed(evt);
            }
        });
        Hire_EMTs.add(Decline, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, 100, 30));

        jButton5.setBackground(new java.awt.Color(102, 102, 255));
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Hire");
        jButton5.setBorder(null);
        jButton5.setFocusPainted(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        Hire_EMTs.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 100, 30));

        jButton2.setBackground(new java.awt.Color(102, 102, 255));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Detail");
        jButton2.setBorder(null);
        jButton2.setFocusPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        Hire_EMTs.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 100, 30));

        jTable1.setBackground(new java.awt.Color(26, 100, 162));
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setAlignmentX(0.0F);
        jTable1.setAlignmentY(0.0F);
        jScrollPane1.setViewportView(jTable1);

        Hire_EMTs.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 710, -1));

        jTabbedPane1.addTab("Hire EMTs", new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-hire-30.png")), Hire_EMTs); // NOI18N

        All_Emit_Detail.setBackground(new java.awt.Color(26, 100, 162));
        All_Emit_Detail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                All_Emit_DetailMouseClicked(evt);
            }
        });
        All_Emit_Detail.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Apply_Button1.setBackground(new java.awt.Color(102, 102, 255));
        Apply_Button1.setForeground(new java.awt.Color(255, 255, 255));
        Apply_Button1.setText("Refesh");
        Apply_Button1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Apply_Button1.setBorderPainted(false);
        Apply_Button1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Apply_Button1.setFocusPainted(false);
        Apply_Button1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Apply_Button1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Apply_Button1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Apply_Button1MouseExited(evt);
            }
        });
        Apply_Button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Apply_Button1ActionPerformed(evt);
            }
        });
        All_Emit_Detail.add(Apply_Button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, 80, 30));

        jButton3.setBackground(new java.awt.Color(102, 102, 255));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Detail");
        jButton3.setBorder(null);
        jButton3.setFocusPainted(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        All_Emit_Detail.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 100, 30));

        update.setBackground(new java.awt.Color(102, 102, 255));
        update.setForeground(new java.awt.Color(255, 255, 255));
        update.setText("Change Shift");
        update.setBorder(null);
        update.setFocusPainted(false);
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        All_Emit_Detail.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 100, 30));

        jButton7.setBackground(new java.awt.Color(102, 102, 255));
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Suspend");
        jButton7.setBorder(null);
        jButton7.setFocusPainted(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        All_Emit_Detail.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, 100, 30));

        jTable2.setBackground(new java.awt.Color(26, 100, 162));
        jTable2.setForeground(new java.awt.Color(255, 255, 255));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable2.setAlignmentX(0.0F);
        jTable2.setAlignmentY(0.0F);
        jScrollPane2.setViewportView(jTable2);

        All_Emit_Detail.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 710, 410));

        jLabel32.setBackground(new java.awt.Color(102, 102, 255));
        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Search");
        All_Emit_Detail.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 20, -1, 20));

        name_apply.setBackground(new java.awt.Color(26, 100, 162));
        name_apply.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        name_apply.setForeground(new java.awt.Color(255, 255, 255));
        name_apply.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        name_apply.setSelectionEnd(50);
        name_apply.setSelectionStart(12);
        name_apply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                name_applyActionPerformed(evt);
            }
        });
        All_Emit_Detail.add(name_apply, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, 160, -1));

        jTabbedPane1.addTab("All EMTs", new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-technician-30.png")), All_Emit_Detail); // NOI18N

        Main_EMTs_Panel.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 510));

        getContentPane().add(Main_EMTs_Panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 720, 510));

        Account_ASI_Main.setBackground(new java.awt.Color(26, 100, 162));
        Account_ASI_Main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Account Details");
        Account_ASI_Main.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, 125, 25));

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Full Name:");
        Account_ASI_Main.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));

        jTextField5.setBackground(new java.awt.Color(26, 100, 162));
        jTextField5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextField5.setForeground(new java.awt.Color(255, 255, 255));
        jTextField5.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jTextField5.setSelectionEnd(50);
        jTextField5.setSelectionStart(12);
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        Account_ASI_Main.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 215, -1));

        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("ID_Card:");
        Account_ASI_Main.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        jTextField6.setBackground(new java.awt.Color(26, 100, 162));
        jTextField6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextField6.setForeground(new java.awt.Color(255, 255, 255));
        jTextField6.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jTextField6.setSelectionEnd(50);
        jTextField6.setSelectionStart(12);
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        Account_ASI_Main.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 215, -1));

        jLabel22.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Contact No:");
        Account_ASI_Main.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, -1, -1));

        jTextField7.setBackground(new java.awt.Color(26, 100, 162));
        jTextField7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextField7.setForeground(new java.awt.Color(255, 255, 255));
        jTextField7.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jTextField7.setSelectionEnd(50);
        jTextField7.setSelectionStart(12);
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        Account_ASI_Main.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 215, -1));

        jLabel51.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setText("Gender:");
        Account_ASI_Main.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, -1, -1));

        jTextField8.setBackground(new java.awt.Color(26, 100, 162));
        jTextField8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextField8.setForeground(new java.awt.Color(255, 255, 255));
        jTextField8.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jTextField8.setSelectionEnd(50);
        jTextField8.setSelectionStart(12);
        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });
        Account_ASI_Main.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 215, -1));

        jLabel52.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setText("Picture:");
        Account_ASI_Main.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, -1, -1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 167, Short.MAX_VALUE)
        );

        Account_ASI_Main.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 80, 240, -1));

        upadte_Profile.setBackground(new java.awt.Color(51, 51, 255));
        upadte_Profile.setForeground(new java.awt.Color(255, 255, 255));
        upadte_Profile.setText("Upade");
        upadte_Profile.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        upadte_Profile.setBorderPainted(false);
        upadte_Profile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        upadte_Profile.setFocusPainted(false);
        upadte_Profile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                upadte_ProfileMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                upadte_ProfileMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                upadte_ProfileMouseExited(evt);
            }
        });
        upadte_Profile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upadte_ProfileActionPerformed(evt);
            }
        });
        Account_ASI_Main.add(upadte_Profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 420, 90, 30));

        jButton1.setBackground(new java.awt.Color(43, 43, 43));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Change");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.setBorderPainted(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusPainted(false);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        Account_ASI_Main.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 270, 90, 30));

        jLabel53.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setText("Special ID:");
        Account_ASI_Main.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, -1, -1));

        jTextField9.setBackground(new java.awt.Color(26, 100, 162));
        jTextField9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextField9.setForeground(new java.awt.Color(255, 255, 255));
        jTextField9.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jTextField9.setSelectionEnd(50);
        jTextField9.setSelectionStart(12);
        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });
        Account_ASI_Main.add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 210, -1));

        jLabel54.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setText("Password:");
        Account_ASI_Main.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 350, -1, -1));

        jTextField10.setBackground(new java.awt.Color(26, 100, 162));
        jTextField10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextField10.setForeground(new java.awt.Color(255, 255, 255));
        jTextField10.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jTextField10.setSelectionEnd(50);
        jTextField10.setSelectionStart(12);
        jTextField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField10ActionPerformed(evt);
            }
        });
        Account_ASI_Main.add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 370, 198, -1));

        getContentPane().add(Account_ASI_Main, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 720, 510));

        Main_Ambulance_Panel.setBackground(new java.awt.Color(26, 100, 162));
        Main_Ambulance_Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane2.setBackground(new java.awt.Color(26, 100, 162));
        jTabbedPane2.setOpaque(true);

        jPanel1.setBackground(new java.awt.Color(26, 100, 162));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel40.setBackground(new java.awt.Color(102, 102, 255));
        jLabel40.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("Seacrh");
        jPanel1.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, -1, 20));

        jLabel41.setBackground(new java.awt.Color(102, 102, 255));
        jLabel41.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("Ambulance Details");
        jPanel1.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, 20));

        name_apply2.setBackground(new java.awt.Color(26, 100, 162));
        name_apply2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        name_apply2.setForeground(new java.awt.Color(255, 255, 255));
        name_apply2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        name_apply2.setSelectionEnd(50);
        name_apply2.setSelectionStart(12);
        name_apply2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                name_apply2ActionPerformed(evt);
            }
        });
        jPanel1.add(name_apply2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 220, -1));

        jLabel43.setBackground(new java.awt.Color(102, 102, 255));
        jLabel43.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("Ambulance Type");
        jPanel1.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, 20));

        jLabel44.setBackground(new java.awt.Color(102, 102, 255));
        jLabel44.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("Ambulance Number");
        jPanel1.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, 20));

        name_apply6.setBackground(new java.awt.Color(26, 100, 162));
        name_apply6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        name_apply6.setForeground(new java.awt.Color(255, 255, 255));
        name_apply6.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        name_apply6.setSelectionEnd(50);
        name_apply6.setSelectionStart(12);
        name_apply6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                name_apply6ActionPerformed(evt);
            }
        });
        jPanel1.add(name_apply6, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, 180, -1));

        jLabel45.setBackground(new java.awt.Color(102, 102, 255));
        jLabel45.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("Equipments");
        jPanel1.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, 20));

        jComboBox1.setBackground(new java.awt.Color(26, 100, 162));
        jComboBox1.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Car", "Van" }));
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 220, -1));

        jCheckBox2.setBackground(new java.awt.Color(26, 100, 162));
        jCheckBox2.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox2.setText("Blood Pressure Cuff");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, -1, -1));

        jCheckBox5.setBackground(new java.awt.Color(26, 100, 162));
        jCheckBox5.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox5.setText("Oxygen Cylinder 680");
        jCheckBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox5ActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBox5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));

        jCheckBox6.setBackground(new java.awt.Color(26, 100, 162));
        jCheckBox6.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox6.setText("Stethoscope");
        jCheckBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox6ActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBox6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        jCheckBox7.setBackground(new java.awt.Color(26, 100, 162));
        jCheckBox7.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox7.setText("Gurney");
        jCheckBox7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox7ActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBox7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, -1, -1));

        jTable3.setBackground(new java.awt.Color(26, 100, 162));
        jTable3.setForeground(new java.awt.Color(255, 255, 255));
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable3.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable3MousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(jTable3);
        if (jTable3.getColumnModel().getColumnCount() > 0) {
            jTable3.getColumnModel().getColumn(0).setResizable(false);
        }

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(262, 37, 450, 420));

        EDIT_Ambulance.setBackground(new java.awt.Color(51, 51, 255));
        EDIT_Ambulance.setForeground(new java.awt.Color(255, 255, 255));
        EDIT_Ambulance.setText("EDIT");
        EDIT_Ambulance.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        EDIT_Ambulance.setBorderPainted(false);
        EDIT_Ambulance.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        EDIT_Ambulance.setFocusPainted(false);
        EDIT_Ambulance.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EDIT_AmbulanceMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                EDIT_AmbulanceMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                EDIT_AmbulanceMouseExited(evt);
            }
        });
        EDIT_Ambulance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EDIT_AmbulanceActionPerformed(evt);
            }
        });
        jPanel1.add(EDIT_Ambulance, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 400, 80, 30));

        add_ambulance1.setBackground(new java.awt.Color(51, 51, 255));
        add_ambulance1.setForeground(new java.awt.Color(255, 255, 255));
        add_ambulance1.setText("ADD");
        add_ambulance1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add_ambulance1.setBorderPainted(false);
        add_ambulance1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add_ambulance1.setFocusPainted(false);
        add_ambulance1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                add_ambulance1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                add_ambulance1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                add_ambulance1MouseExited(evt);
            }
        });
        add_ambulance1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_ambulance1ActionPerformed(evt);
            }
        });
        jPanel1.add(add_ambulance1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 80, 30));

        jLabel58.setBackground(new java.awt.Color(102, 102, 255));
        jLabel58.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(255, 255, 255));
        jLabel58.setText("Ambulance Model");
        jPanel1.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, 20));

        name_apply7.setBackground(new java.awt.Color(26, 100, 162));
        name_apply7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        name_apply7.setForeground(new java.awt.Color(255, 255, 255));
        name_apply7.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        name_apply7.setSelectionEnd(50);
        name_apply7.setSelectionStart(12);
        name_apply7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                name_apply7ActionPerformed(evt);
            }
        });
        jPanel1.add(name_apply7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 220, -1));

        Apply_Button3.setBackground(new java.awt.Color(51, 51, 255));
        Apply_Button3.setForeground(new java.awt.Color(255, 255, 255));
        Apply_Button3.setText("Delete");
        Apply_Button3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Apply_Button3.setBorderPainted(false);
        Apply_Button3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Apply_Button3.setFocusPainted(false);
        Apply_Button3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Apply_Button3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Apply_Button3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Apply_Button3MouseExited(evt);
            }
        });
        Apply_Button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Apply_Button3ActionPerformed(evt);
            }
        });
        jPanel1.add(Apply_Button3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 400, 80, 30));

        jTabbedPane2.addTab("Manage Ambulances", new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-ambulance-30.png")), jPanel1); // NOI18N

        jPanel5.setBackground(new java.awt.Color(26, 100, 162));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel55.setBackground(new java.awt.Color(102, 102, 255));
        jLabel55.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setText("Equipments");
        jPanel5.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, 20));

        Edit_Equipment.setBackground(new java.awt.Color(51, 51, 255));
        Edit_Equipment.setForeground(new java.awt.Color(255, 255, 255));
        Edit_Equipment.setText("EDIT");
        Edit_Equipment.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Edit_Equipment.setBorderPainted(false);
        Edit_Equipment.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Edit_Equipment.setFocusPainted(false);
        Edit_Equipment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Edit_EquipmentMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Edit_EquipmentMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Edit_EquipmentMouseExited(evt);
            }
        });
        Edit_Equipment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Edit_EquipmentActionPerformed(evt);
            }
        });
        jPanel5.add(Edit_Equipment, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 80, 30));

        jTable4.setBackground(new java.awt.Color(26, 100, 162));
        jTable4.setForeground(new java.awt.Color(255, 255, 255));
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable4.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jScrollPane4.setViewportView(jTable4);
        if (jTable4.getColumnModel().getColumnCount() > 0) {
            jTable4.getColumnModel().getColumn(0).setResizable(false);
        }

        jPanel5.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(262, 37, 450, 420));

        jLabel42.setBackground(new java.awt.Color(102, 102, 255));
        jLabel42.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("Equipment Name");
        jPanel5.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, 20));

        jLabel56.setBackground(new java.awt.Color(102, 102, 255));
        jLabel56.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(255, 255, 255));
        jLabel56.setText("Equipment Amount");
        jPanel5.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, 20));

        name_apply4.setBackground(new java.awt.Color(26, 100, 162));
        name_apply4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        name_apply4.setForeground(new java.awt.Color(255, 255, 255));
        name_apply4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        name_apply4.setSelectionEnd(50);
        name_apply4.setSelectionStart(12);
        name_apply4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                name_apply4ActionPerformed(evt);
            }
        });
        jPanel5.add(name_apply4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 220, -1));

        jLabel57.setBackground(new java.awt.Color(102, 102, 255));
        jLabel57.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(255, 255, 255));
        jLabel57.setText("Use for");
        jPanel5.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, 20));

        name_apply5.setBackground(new java.awt.Color(26, 100, 162));
        name_apply5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        name_apply5.setForeground(new java.awt.Color(255, 255, 255));
        name_apply5.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        name_apply5.setSelectionEnd(50);
        name_apply5.setSelectionStart(12);
        name_apply5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                name_apply5ActionPerformed(evt);
            }
        });
        jPanel5.add(name_apply5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 220, -1));

        jComboBox2.setBackground(new java.awt.Color(26, 100, 162));
        jComboBox2.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Oxygen Cylinder 680", "Stethoscope", "Gurney", "Blood Pressure Cuff" }));
        jPanel5.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 220, 20));

        add_ambulance2.setBackground(new java.awt.Color(51, 51, 255));
        add_ambulance2.setForeground(new java.awt.Color(255, 255, 255));
        add_ambulance2.setText("ADD");
        add_ambulance2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add_ambulance2.setBorderPainted(false);
        add_ambulance2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add_ambulance2.setFocusPainted(false);
        add_ambulance2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                add_ambulance2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                add_ambulance2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                add_ambulance2MouseExited(evt);
            }
        });
        add_ambulance2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_ambulance2ActionPerformed(evt);
            }
        });
        jPanel5.add(add_ambulance2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 80, 30));

        jLabel59.setBackground(new java.awt.Color(102, 102, 255));
        jLabel59.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(255, 255, 255));
        jLabel59.setText("Seacrh");
        jPanel5.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, -1, 20));

        name_apply8.setBackground(new java.awt.Color(26, 100, 162));
        name_apply8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        name_apply8.setForeground(new java.awt.Color(255, 255, 255));
        name_apply8.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        name_apply8.setSelectionEnd(50);
        name_apply8.setSelectionStart(12);
        name_apply8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                name_apply8ActionPerformed(evt);
            }
        });
        jPanel5.add(name_apply8, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 180, -1));

        Apply_Button.setBackground(new java.awt.Color(51, 51, 255));
        Apply_Button.setForeground(new java.awt.Color(255, 255, 255));
        Apply_Button.setText("Refesh");
        Apply_Button.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Apply_Button.setBorderPainted(false);
        Apply_Button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Apply_Button.setFocusPainted(false);
        Apply_Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Apply_ButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Apply_ButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Apply_ButtonMouseExited(evt);
            }
        });
        Apply_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Apply_ButtonActionPerformed(evt);
            }
        });
        jPanel5.add(Apply_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, 80, 30));

        jTabbedPane2.addTab("Manage Equipment", new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-equipment-30.png")), jPanel5); // NOI18N

        Main_Ambulance_Panel.add(jTabbedPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 510));

        getContentPane().add(Main_Ambulance_Panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 720, 510));

        Main_Emergency_Panel.setBackground(new java.awt.Color(26, 100, 162));
        Main_Emergency_Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable5.setBackground(new java.awt.Color(26, 100, 162));
        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Emergency Code", "Patient Name", "Location", "Hospital Dispatch ", "EMergency Type"
            }
        ));
        jScrollPane5.setViewportView(jTable5);

        Main_Emergency_Panel.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 720, 450));

        name_apply9.setBackground(new java.awt.Color(26, 100, 162));
        name_apply9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        name_apply9.setForeground(new java.awt.Color(255, 255, 255));
        name_apply9.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        name_apply9.setSelectionEnd(50);
        name_apply9.setSelectionStart(12);
        name_apply9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                name_apply9ActionPerformed(evt);
            }
        });
        Main_Emergency_Panel.add(name_apply9, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, 130, -1));

        jLabel60.setBackground(new java.awt.Color(102, 102, 255));
        jLabel60.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(255, 255, 255));
        jLabel60.setText("Filter");
        Main_Emergency_Panel.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, 40, 20));

        jComboBox3.setBackground(new java.awt.Color(26, 100, 162));
        jComboBox3.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Emergency Code", "Patient", "Date" }));
        Main_Emergency_Panel.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 20, 110, -1));

        jLabel61.setBackground(new java.awt.Color(102, 102, 255));
        jLabel61.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(255, 255, 255));
        jLabel61.setText("Seacrh");
        Main_Emergency_Panel.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, 40, 20));

        EDIT_Ambulance1.setBackground(new java.awt.Color(51, 51, 255));
        EDIT_Ambulance1.setForeground(new java.awt.Color(255, 255, 255));
        EDIT_Ambulance1.setText("Detail");
        EDIT_Ambulance1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        EDIT_Ambulance1.setBorderPainted(false);
        EDIT_Ambulance1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        EDIT_Ambulance1.setFocusPainted(false);
        EDIT_Ambulance1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EDIT_Ambulance1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                EDIT_Ambulance1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                EDIT_Ambulance1MouseExited(evt);
            }
        });
        EDIT_Ambulance1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EDIT_Ambulance1ActionPerformed(evt);
            }
        });
        Main_Emergency_Panel.add(EDIT_Ambulance1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 80, 30));

        getContentPane().add(Main_Emergency_Panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 720, 510));

        Main_Parking_Panel.setBackground(new java.awt.Color(26, 100, 162));
        Main_Parking_Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        Main_Parking_Panel.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 30, 30));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        j_1.setText("0");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(j_1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(j_1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        Main_Parking_Panel.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        j_2.setText("1");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(j_2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(j_2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        Main_Parking_Panel.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, -1, -1));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        j_3.setText("2");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(j_3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(j_3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        Main_Parking_Panel.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, -1, -1));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        j_4.setText("3");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(j_4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(j_4, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        Main_Parking_Panel.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 150, -1, -1));

        j_9.setText("8");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(j_9, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(j_9, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        Main_Parking_Panel.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 310, -1, -1));

        j_8.setText("7");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(j_8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(j_8, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        Main_Parking_Panel.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 310, -1, -1));

        j_7.setText("6");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(j_7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(j_7, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        Main_Parking_Panel.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 310, -1, -1));

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));

        j_6.setText("5");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(j_6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(j_6, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        Main_Parking_Panel.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));

        j_5.setText("4");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(j_5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(j_5, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        Main_Parking_Panel.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 150, -1, -1));

        j_10.setText("9");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(j_10, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(j_10, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        Main_Parking_Panel.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 310, -1, -1));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("e.g. There are 10 Maximum Ambulance in Our Ambulance Service System");
        Main_Parking_Panel.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, -1, -1));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Free");
        Main_Parking_Panel.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, -1, -1));

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Occupied");
        Main_Parking_Panel.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-ambulance-25.png"))); // NOI18N
        Main_Parking_Panel.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, 30));

        getContentPane().add(Main_Parking_Panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 720, 510));

        Main_Driver_Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane3.setBackground(new java.awt.Color(26, 100, 162));
        jTabbedPane3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jTabbedPane3.setAlignmentX(0.0F);
        jTabbedPane3.setAlignmentY(0.0F);
        jTabbedPane3.setAutoscrolls(true);
        jTabbedPane3.setOpaque(true);

        Hire_Driver.setBackground(new java.awt.Color(26, 100, 162));
        Hire_Driver.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        Hire_Driver.setAutoscrolls(true);
        Hire_Driver.setFocusCycleRoot(true);
        Hire_Driver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Hire_DriverMouseClicked(evt);
            }
        });
        Hire_Driver.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Decline1.setBackground(new java.awt.Color(102, 102, 255));
        Decline1.setForeground(new java.awt.Color(255, 255, 255));
        Decline1.setText("Decline");
        Decline1.setBorder(null);
        Decline1.setFocusPainted(false);
        Decline1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Decline1ActionPerformed(evt);
            }
        });
        Hire_Driver.add(Decline1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, 100, 30));

        jButton6.setBackground(new java.awt.Color(102, 102, 255));
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Hire");
        jButton6.setBorder(null);
        jButton6.setFocusPainted(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        Hire_Driver.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 100, 30));

        jButton4.setBackground(new java.awt.Color(102, 102, 255));
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Detail");
        jButton4.setBorder(null);
        jButton4.setFocusPainted(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        Hire_Driver.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 100, 30));

        jTable6.setBackground(new java.awt.Color(26, 100, 162));
        jTable6.setForeground(new java.awt.Color(255, 255, 255));
        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable6.setAlignmentX(0.0F);
        jTable6.setAlignmentY(0.0F);
        jScrollPane6.setViewportView(jTable6);

        Hire_Driver.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 710, -1));

        jTabbedPane3.addTab("Hire Driver", new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-hire-30.png")), Hire_Driver); // NOI18N

        All_Driver.setBackground(new java.awt.Color(26, 100, 162));
        All_Driver.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton8.setBackground(new java.awt.Color(102, 102, 255));
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Detail");
        jButton8.setBorder(null);
        jButton8.setFocusPainted(false);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        All_Driver.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 100, 30));

        update1.setBackground(new java.awt.Color(102, 102, 255));
        update1.setForeground(new java.awt.Color(255, 255, 255));
        update1.setText("Change_Shift");
        update1.setBorder(null);
        update1.setFocusPainted(false);
        update1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update1ActionPerformed(evt);
            }
        });
        All_Driver.add(update1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 100, 30));

        jButton9.setBackground(new java.awt.Color(102, 102, 255));
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("Suspend");
        jButton9.setBorder(null);
        jButton9.setFocusPainted(false);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        All_Driver.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 100, 30));

        jTable7.setBackground(new java.awt.Color(26, 100, 162));
        jTable7.setForeground(new java.awt.Color(255, 255, 255));
        jTable7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable7.setAlignmentX(0.0F);
        jTable7.setAlignmentY(0.0F);
        jScrollPane7.setViewportView(jTable7);

        All_Driver.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 57, 710, 410));

        jLabel33.setBackground(new java.awt.Color(102, 102, 255));
        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Search");
        All_Driver.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 20, -1, 20));

        name_apply1.setBackground(new java.awt.Color(26, 100, 162));
        name_apply1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        name_apply1.setForeground(new java.awt.Color(255, 255, 255));
        name_apply1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        name_apply1.setSelectionEnd(50);
        name_apply1.setSelectionStart(12);
        name_apply1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                name_apply1ActionPerformed(evt);
            }
        });
        All_Driver.add(name_apply1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, 160, -1));

        Apply_Button2.setBackground(new java.awt.Color(102, 102, 255));
        Apply_Button2.setForeground(new java.awt.Color(255, 255, 255));
        Apply_Button2.setText("Refesh");
        Apply_Button2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Apply_Button2.setBorderPainted(false);
        Apply_Button2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Apply_Button2.setFocusPainted(false);
        Apply_Button2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Apply_Button2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Apply_Button2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Apply_Button2MouseExited(evt);
            }
        });
        Apply_Button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Apply_Button2ActionPerformed(evt);
            }
        });
        All_Driver.add(Apply_Button2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 80, 30));

        jTabbedPane3.addTab("All Drivers", new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-driver-30.png")), All_Driver); // NOI18N

        Main_Driver_Panel.add(jTabbedPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 510));

        getContentPane().add(Main_Driver_Panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 720, 510));

        Side_Menu_Main.setBackground(new java.awt.Color(49, 95, 240));
        Side_Menu_Main.setAutoscrolls(true);
        Side_Menu_Main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(228, 228, 228));
        jPanel3.setPreferredSize(new java.awt.Dimension(84, 13));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
        });
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        database.setBackground(new java.awt.Color(228, 228, 228));
        database.setPreferredSize(new java.awt.Dimension(151, 47));
        database.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                databaseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                databaseMouseExited(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(51, 51, 51));
        jLabel9.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-help-25.png"))); // NOI18N

        jLabel29.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(51, 51, 51));
        jLabel29.setText("Help !");

        javax.swing.GroupLayout databaseLayout = new javax.swing.GroupLayout(database);
        database.setLayout(databaseLayout);
        databaseLayout.setHorizontalGroup(
            databaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(databaseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        databaseLayout.setVerticalGroup(
            databaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanel3.add(database, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, -1, 50));

        login.setBackground(new java.awt.Color(228, 228, 228));
        database.setPreferredSize(new java.awt.Dimension(151, 47));
        login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginMouseExited(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(51, 51, 51));
        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 1, 10)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/user_30px.png"))); // NOI18N

        jLabel28.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(51, 51, 51));
        jLabel28.setText("Export The Report");

        javax.swing.GroupLayout loginLayout = new javax.swing.GroupLayout(login);
        login.setLayout(loginLayout);
        loginLayout.setHorizontalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        loginLayout.setVerticalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel3.add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, 50));

        logout.setBackground(new java.awt.Color(228, 228, 228));
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logoutMouseExited(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(51, 51, 51));
        jLabel10.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/exit_30px.png"))); // NOI18N

        jLabel30.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(51, 51, 51));
        jLabel30.setText("Logout");

        javax.swing.GroupLayout logoutLayout = new javax.swing.GroupLayout(logout);
        logout.setLayout(logoutLayout);
        logoutLayout.setHorizontalGroup(
            logoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logoutLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        logoutLayout.setVerticalGroup(
            logoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel3.add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 160, 40));

        Side_Menu_Main.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 150, 160));

        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/in_app_messaging_25px.png"))); // NOI18N
        jLabel7.setText("Exit");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jLabel7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabel7KeyPressed(evt);
            }
        });
        Side_Menu_Main.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 500, 60, 30));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel24.setText("System");
        Side_Menu_Main.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 50, 20));

        Dashboarbbutton.setBackground(new java.awt.Color(49, 95, 240));
        Dashboarbbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DashboarbbuttonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DashboarbbuttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DashboarbbuttonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DashboarbbuttonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                DashboarbbuttonMouseReleased(evt);
            }
        });
        Dashboarbbutton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/home_30px.png"))); // NOI18N
        jLabel5.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        Dashboarbbutton.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 140, 40));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Dashboard");
        Dashboarbbutton.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, 30));

        Side_Menu_Main.add(Dashboarbbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 160, 50));

        searchbutton.setBackground(new java.awt.Color(49, 95, 240));
        searchbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                searchbuttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                searchbuttonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                searchbuttonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                searchbuttonMouseReleased(evt);
            }
        });
        searchbutton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search_35px.png"))); // NOI18N
        searchbutton.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 50, -1));

        jLabel3.setBackground(new java.awt.Color(204, 204, 204));
        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Saerch");
        searchbutton.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 80, 40));

        Side_Menu_Main.add(searchbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 160, 50));

        accountbutton.setBackground(new java.awt.Color(49, 95, 240));
        accountbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accountbuttonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                accountbuttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                accountbuttonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                accountbuttonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                accountbuttonMouseReleased(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/account_30px.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Account");

        javax.swing.GroupLayout accountbuttonLayout = new javax.swing.GroupLayout(accountbutton);
        accountbutton.setLayout(accountbuttonLayout);
        accountbuttonLayout.setHorizontalGroup(
            accountbuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accountbuttonLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addContainerGap(48, Short.MAX_VALUE))
        );
        accountbuttonLayout.setVerticalGroup(
            accountbuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accountbuttonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(accountbuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        Side_Menu_Main.add(accountbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 160, 50));

        set1.setForeground(new java.awt.Color(204, 204, 204));
        set1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/settings_25px.png"))); // NOI18N
        set1.setText("Setting");
        set1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                set1MouseClicked(evt);
            }
        });
        Side_Menu_Main.add(set1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, 70, 30));

        set2.setForeground(new java.awt.Color(204, 204, 204));
        set2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/settings_25px.png"))); // NOI18N
        set2.setText("Setting");
        set2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                set2MouseClicked(evt);
            }
        });
        Side_Menu_Main.add(set2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, 70, 30));

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel38.setText("Ambulance Service");
        Side_Menu_Main.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 110, 20));

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-ambulance-25.png"))); // NOI18N
        Side_Menu_Main.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, 30));

        getContentPane().add(Side_Menu_Main, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 540));

        Minimize.setBackground(new java.awt.Color(49, 95, 240));
        Minimize.setForeground(new java.awt.Color(52, 152, 219));
        Minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MinimizejPanel11MouseEntered(evt);
            }
        });

        exit2.setBackground(new java.awt.Color(52, 152, 219));
        exit2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exit2exitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exit2exitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exit2exitMouseExited(evt);
            }
        });
        exit2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("X");
        exit2.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 5, 30, 20));

        mxmize2.setBackground(new java.awt.Color(52, 152, 219));
        mxmize2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mxmize2mxmizeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mxmize2mxmizeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mxmize2mxmizeMouseExited(evt);
            }
        });
        mxmize2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("=");
        mxmize2.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, -1));

        minimize2.setBackground(new java.awt.Color(52, 152, 219));
        minimize2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimize2minimizeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                minimize2minimizeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                minimize2minimizeMouseExited(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("-");
        jLabel36.setToolTipText("-");

        javax.swing.GroupLayout minimize2Layout = new javax.swing.GroupLayout(minimize2);
        minimize2.setLayout(minimize2Layout);
        minimize2Layout.setHorizontalGroup(
            minimize2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(minimize2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                .addContainerGap())
        );
        minimize2Layout.setVerticalGroup(
            minimize2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(minimize2Layout.createSequentialGroup()
                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel12.setBackground(new java.awt.Color(156, 156, 156));
        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Dashboard");

        javax.swing.GroupLayout MinimizeLayout = new javax.swing.GroupLayout(Minimize);
        Minimize.setLayout(MinimizeLayout);
        MinimizeLayout.setHorizontalGroup(
            MinimizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MinimizeLayout.createSequentialGroup()
                .addGap(259, 259, 259)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 267, Short.MAX_VALUE)
                .addComponent(minimize2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mxmize2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(exit2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        MinimizeLayout.setVerticalGroup(
            MinimizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(minimize2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MinimizeLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel12))
            .addGroup(MinimizeLayout.createSequentialGroup()
                .addGroup(MinimizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mxmize2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exit2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(Minimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 720, 30));

        setSize(new java.awt.Dimension(874, 541));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void EMTs_Button_DashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EMTs_Button_DashboardMouseClicked

        selectedPanel(Main_EMTs_Panel);
    }//GEN-LAST:event_EMTs_Button_DashboardMouseClicked

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        // TODO add your handling code here:
        jPanel3.setVisible(false);
    }//GEN-LAST:event_jPanel3MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel7KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel7KeyPressed

    private void set1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_set1MouseClicked
        // TODO add your handling code here:
        jPanel3.setEnabled(true);
        jPanel3.setVisible(true);
        set2.setEnabled(true);
        set2.setVisible(true);
        set1.setEnabled(false);
        set1.setVisible(false);
    }//GEN-LAST:event_set1MouseClicked

    private void set2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_set2MouseClicked
        // TODO add your handling code here:
        jPanel3.setEnabled(false);
        jPanel3.setVisible(false);
        set1.setEnabled(true);
        set1.setVisible(true);
        set2.setEnabled(false);
        set2.setVisible(false);
    }//GEN-LAST:event_set2MouseClicked

    private void EMTs_Button_DashboardMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EMTs_Button_DashboardMouseEntered
        changecolor(EMTs_Button_Dashboard, new Color(46, 144, 232));
    }//GEN-LAST:event_EMTs_Button_DashboardMouseEntered

    private void EMTs_Button_DashboardMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EMTs_Button_DashboardMouseExited
        changecolor(EMTs_Button_Dashboard, new Color(255, 255, 255));
    }//GEN-LAST:event_EMTs_Button_DashboardMouseExited

    private void Ambulances_Button_DashboardMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Ambulances_Button_DashboardMouseEntered
        changecolor(Ambulances_Button_Dashboard, new Color(46, 144, 232));
    }//GEN-LAST:event_Ambulances_Button_DashboardMouseEntered

    private void Ambulances_Button_DashboardMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Ambulances_Button_DashboardMouseExited
        changecolor(Ambulances_Button_Dashboard, new Color(255, 255, 255));
    }//GEN-LAST:event_Ambulances_Button_DashboardMouseExited

    private void Drivers_Button_DashboardMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Drivers_Button_DashboardMouseEntered
        changecolor(Drivers_Button_Dashboard, new Color(46, 144, 232));
    }//GEN-LAST:event_Drivers_Button_DashboardMouseEntered

    private void Drivers_Button_DashboardMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Drivers_Button_DashboardMouseExited
        changecolor(Drivers_Button_Dashboard, new Color(255, 255, 255));
    }//GEN-LAST:event_Drivers_Button_DashboardMouseExited

    private void Emergencies_Button_DashboardMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Emergencies_Button_DashboardMouseEntered
        changecolor(Emergencies_Button_Dashboard, new Color(46, 144, 232));
    }//GEN-LAST:event_Emergencies_Button_DashboardMouseEntered

    private void Emergencies_Button_DashboardMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Emergencies_Button_DashboardMouseExited
        changecolor(Emergencies_Button_Dashboard, new Color(255, 255, 255));
    }//GEN-LAST:event_Emergencies_Button_DashboardMouseExited

    private void ParkingMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ParkingMouseEntered
        changecolor(Parking, new Color(46, 144, 232));
    }//GEN-LAST:event_ParkingMouseEntered

    private void ParkingMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ParkingMouseExited
        changecolor(Parking, new Color(255, 255, 255));
    }//GEN-LAST:event_ParkingMouseExited

    private void aboutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutMouseEntered
        changecolor(about, new Color(46, 144, 232));
    }//GEN-LAST:event_aboutMouseEntered

    private void aboutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutMouseExited
        changecolor(about, new Color(255, 255, 255));
    }//GEN-LAST:event_aboutMouseExited

    private void DashboarbbuttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboarbbuttonMouseEntered
        changecolor(Dashboarbbutton, new Color(69, 73, 74));
    }//GEN-LAST:event_DashboarbbuttonMouseEntered

    private void DashboarbbuttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboarbbuttonMouseExited
        changecolor(Dashboarbbutton, new Color(49, 95, 240));
    }//GEN-LAST:event_DashboarbbuttonMouseExited

    private void searchbuttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchbuttonMouseEntered
        changecolor(searchbutton, new Color(69, 73, 74));
    }//GEN-LAST:event_searchbuttonMouseEntered

    private void searchbuttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchbuttonMouseExited
        changecolor(searchbutton, new Color(49, 95, 240));
    }//GEN-LAST:event_searchbuttonMouseExited

    private void accountbuttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountbuttonMouseEntered
        changecolor(accountbutton, new Color(69, 73, 74));
    }//GEN-LAST:event_accountbuttonMouseEntered

    private void accountbuttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountbuttonMouseExited
        changecolor(accountbutton, new Color(49, 95, 240));
    }//GEN-LAST:event_accountbuttonMouseExited

    private void loginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginMouseEntered
        changecolor(login, new Color(69, 73, 74));
    }//GEN-LAST:event_loginMouseEntered

    private void loginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginMouseExited
        changecolor(login, new Color(228, 228, 228));
    }//GEN-LAST:event_loginMouseExited

    private void databaseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_databaseMouseEntered
        changecolor(database, new Color(69, 73, 74));
    }//GEN-LAST:event_databaseMouseEntered

    private void databaseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_databaseMouseExited
        changecolor(database, new Color(228, 228, 228));
    }//GEN-LAST:event_databaseMouseExited

    private void logoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseEntered
        changecolor(logout, new Color(69, 73, 74));
    }//GEN-LAST:event_logoutMouseEntered

    private void logoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseExited
        changecolor(logout, new Color(228, 228, 228));
    }//GEN-LAST:event_logoutMouseExited

    private void exit2exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit2exitMouseClicked

        try {
            save_int_array();
            
        } catch (IOException ex) {
            Logger.getLogger(ASI_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
         try {
            asi.save_Drivers();
            
        } catch (IOException ex) {
            Logger.getLogger(ASI_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
                try {
            asi.save_EMTs();
            
        } catch (IOException ex) {
            Logger.getLogger(ASI_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
         try {
            asi.save_Equipment();
            
        } catch (IOException ex) {
            Logger.getLogger(ASI_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            asi.save_Qeuies_EMTs();
            
        } catch (IOException ex) {
            Logger.getLogger(ASI_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
         try {
            asi.save_Qeuies_Drivers();
        } catch (IOException ex) {
            Logger.getLogger(ASI_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
          try {
             asi.save_Ambulances();
        } catch (IOException ex) {
            Logger.getLogger(ASI_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
        System.exit(0);
    }//GEN-LAST:event_exit2exitMouseClicked

    private void exit2exitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit2exitMouseEntered
        changecolor(exit2, new Color(69, 73, 74));
    }//GEN-LAST:event_exit2exitMouseEntered

    private void exit2exitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit2exitMouseExited
        changecolor(exit2, new Color(52, 152, 219));
    }//GEN-LAST:event_exit2exitMouseExited

    private void mxmize2mxmizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mxmize2mxmizeMouseClicked

        //   if (this.getExtendedState() != ASI_GUI.MAXIMIZED_BOTH) {
        //       this.setExtendedState(ASI_GUI.MAXIMIZED_BOTH);
        //   } else {
        //      this.setExtendedState(ASI_GUI.NORMAL);
        //  }
    }//GEN-LAST:event_mxmize2mxmizeMouseClicked

    private void mxmize2mxmizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mxmize2mxmizeMouseEntered
        changecolor(mxmize2, new Color(69, 73, 74));
    }//GEN-LAST:event_mxmize2mxmizeMouseEntered

    private void mxmize2mxmizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mxmize2mxmizeMouseExited
        changecolor(mxmize2, new Color(52, 152, 219));
    }//GEN-LAST:event_mxmize2mxmizeMouseExited

    private void minimize2minimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimize2minimizeMouseClicked
        // TODO add your handling code here:
        if (this.getExtendedState() != ASI_GUI.ICONIFIED) {
            this.setExtendedState(ASI_GUI.ICONIFIED);
        } else {
            this.setExtendedState(ASI_GUI.NORMAL);
        }
    }//GEN-LAST:event_minimize2minimizeMouseClicked

    private void minimize2minimizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimize2minimizeMouseEntered
        changecolor(minimize2, new Color(69, 73, 74));
    }//GEN-LAST:event_minimize2minimizeMouseEntered

    private void minimize2minimizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimize2minimizeMouseExited
        changecolor(minimize2, new Color(52, 152, 219));
    }//GEN-LAST:event_minimize2minimizeMouseExited

    private void MinimizejPanel11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinimizejPanel11MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_MinimizejPanel11MouseEntered

    private void DashboarbbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboarbbuttonMouseClicked
        asi.Show_Table_Equipmet(jTable4);
        selectedPanel(Dashboard);
        jLabel12.setText("Dashboard");

    }//GEN-LAST:event_DashboarbbuttonMouseClicked

    private void Ambulances_Button_DashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Ambulances_Button_DashboardMouseClicked
        Set_All_Amb_icon();
        selectedPanel(Main_Ambulance_Panel);
         
    }//GEN-LAST:event_Ambulances_Button_DashboardMouseClicked

    private void DashboarbbuttonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboarbbuttonMouseReleased
        changecolor(Dashboarbbutton, new Color(69, 73, 74));
    }//GEN-LAST:event_DashboarbbuttonMouseReleased

    private void DashboarbbuttonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboarbbuttonMousePressed
        changecolor(Dashboarbbutton, new Color(234, 172, 84));
    }//GEN-LAST:event_DashboarbbuttonMousePressed

    private void searchbuttonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchbuttonMousePressed
        changecolor(searchbutton, new Color(234, 172, 84));
    }//GEN-LAST:event_searchbuttonMousePressed

    private void accountbuttonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountbuttonMousePressed
        changecolor(accountbutton, new Color(234, 172, 84));
    }//GEN-LAST:event_accountbuttonMousePressed

    private void searchbuttonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchbuttonMouseReleased
        changecolor(searchbutton, new Color(69, 73, 74));
    }//GEN-LAST:event_searchbuttonMouseReleased

    private void accountbuttonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountbuttonMouseReleased
        changecolor(accountbutton, new Color(69, 73, 74));
    }//GEN-LAST:event_accountbuttonMouseReleased

    private void DashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMouseClicked

    }//GEN-LAST:event_DashboardMouseClicked

    private void Drivers_Button_DashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Drivers_Button_DashboardMouseClicked

        selectedPanel(Main_Driver_Panel);
    }//GEN-LAST:event_Drivers_Button_DashboardMouseClicked

    private void Emergencies_Button_DashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Emergencies_Button_DashboardMouseClicked
        selectedPanel(Main_Emergency_Panel);
    }//GEN-LAST:event_Emergencies_Button_DashboardMouseClicked

    private void ParkingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ParkingMouseClicked
        Set_All_Amb_icon();
        selectedPanel(Main_Parking_Panel);
        
    }//GEN-LAST:event_ParkingMouseClicked

    private void loginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginMouseClicked

    }//GEN-LAST:event_loginMouseClicked

    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseClicked
        try {
            asi.save_Qeuies_EMTs();
        } catch (IOException ex) {
            Logger.getLogger(ASI_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setVisible(false);
        new Login().setVisible(true);
    }//GEN-LAST:event_logoutMouseClicked

    private void accountbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountbuttonMouseClicked
        selectedPanel(Account_ASI_Main);
        jLabel12.setText("Account");
        jTextField5.setText(asi.getName());
        jTextField6.setText(asi.getID_Card());
        jTextField7.setText(asi.getContact_Number());
        jTextField8.setText(asi.getGender());
        jTextField9.setText(asi.getSpecial_ID());
        jTextField10.setText(asi.getPass());
    }//GEN-LAST:event_accountbuttonMouseClicked

    private void jTextField10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10ActionPerformed

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File("user.dir"));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("All Type", "jpg", "png", "jpeg", "gif");
        file.addChoosableFileFilter(filter);
        file.showSaveDialog(null);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        changecolor(jButton1, new Color(43, 43, 43));
    }//GEN-LAST:event_jButton1MouseExited

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        changecolor(jButton1, new Color(255, 51, 153));
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked

    }//GEN-LAST:event_jButton1MouseClicked

    private void upadte_ProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upadte_ProfileActionPerformed
        asi.setName(jTextField5.getText());
        asi.setID_Card(jTextField6.getText());
        asi.setContact_Number(jTextField7.getText());
        asi.setGender(jTextField8.getText());
        asi.setSpecial_ID(jTextField9.getText());
        asi.setPass(jTextField10.getText());
        JOptionPane.showMessageDialog(null, "Changes saved");
    }//GEN-LAST:event_upadte_ProfileActionPerformed

    private void upadte_ProfileMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_upadte_ProfileMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_upadte_ProfileMouseExited

    private void upadte_ProfileMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_upadte_ProfileMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_upadte_ProfileMouseEntered

    private void upadte_ProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_upadte_ProfileMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_upadte_ProfileMouseClicked

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void name_applyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_name_applyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_name_applyActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed

        int l = jTable2.getSelectedRowCount();
        if (l > 0) {
            int row = jTable2.getSelectedRow();
            EMTs obj = asi.getEmt_List().findNodeAt(row);
            try {
                new Detail_Form(obj, update, row).setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(ASI_GUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ASI_GUI.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_updateActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        int l = jTable2.getSelectedRowCount();
        if (l > 0) {
            int row = jTable2.getSelectedRow();
            EMTs obj = asi.getEmt_List().findNodeAt(row);
            try {
                new Detail_Form(obj, jButton3, row).setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(ASI_GUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ASI_GUI.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

        int l = jTable2.getSelectedRowCount();
        if (l > 0) {
            int row = jTable2.getSelectedRow();
            EMTs obj = asi.getEmt_List().findNodeAt(row);
            asi.getEmt_List().deleteNthNode(obj);
            asi.Show_Table_EMTs(jTable2);

        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void Hire_EMTsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Hire_EMTsMouseClicked

    }//GEN-LAST:event_Hire_EMTsMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (asi.getQueue_EMTs().peek() != null) {
            EMTs emt = asi.getQueue_EMTs().dequeue();
            if (asi.getEmt_List().getSize() == 0) {
                asi.getEmt_List().insertFirst(emt);

                asi.Show_Table_EMTs(jTable2);
            } else {
                asi.getEmt_List().insertNode(emt);
                asi.Show_Table_EMTs(jTable2);
            }

            JOptionPane.showMessageDialog(null, "EMTs Emloyee Hired ");
            asi.Show_Table_Queue_EMTs(jTable1);

        } else {
            JOptionPane.showMessageDialog(null, "No Applicant Left");
        }
        try {
            asi.save_EMTs();
        } catch (IOException ex) {
            Logger.getLogger(ASI_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void DeclineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeclineActionPerformed
        if (asi.getQueue_EMTs().peek() != null) {
            asi.getQueue_EMTs().dequeue();
            asi.Show_Table_Queue_EMTs(jTable1);
        } else {
            JOptionPane.showMessageDialog(null, "No Applicant Left");
        }
    }//GEN-LAST:event_DeclineActionPerformed

    private void name_apply2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_name_apply2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_name_apply2ActionPerformed

    private void name_apply6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_name_apply6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_name_apply6ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jCheckBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox5ActionPerformed

    private void jCheckBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox6ActionPerformed

    private void jCheckBox7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox7ActionPerformed

    private void EDIT_AmbulanceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EDIT_AmbulanceMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_EDIT_AmbulanceMouseClicked

    private void EDIT_AmbulanceMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EDIT_AmbulanceMouseEntered
        changecolor(EDIT_Ambulance, new Color(43, 43, 43));
    }//GEN-LAST:event_EDIT_AmbulanceMouseEntered

    private void EDIT_AmbulanceMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EDIT_AmbulanceMouseExited
        changecolor(EDIT_Ambulance, new Color(51, 51, 255));
    }//GEN-LAST:event_EDIT_AmbulanceMouseExited

    private void EDIT_AmbulanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EDIT_AmbulanceActionPerformed
       String name=name_apply2.getText();
       String number=name_apply7.getText();
       String type = jComboBox1.getSelectedItem().toString();
       Ambulances amb=null;
       int row=0;
       int l = jTable3.getSelectedRowCount();
        if (l > 0) {
            row = jTable3.getSelectedRow();
            amb=asi.getAmbulance_List().findNodeAt(row);
        }
       Equipment obj=null;
        if(comb0_is_selected(jCheckBox5.getText(), row))
       {
       if(jCheckBox5.isSelected())
       {         
            
       }
       else{
           delet_euip(jCheckBox5.getText(), row);
       }
       }
        else{
            if(jCheckBox5.isSelected())
       {
           obj=asi.Searc_Equip(jCheckBox5.getText());         
           if(obj!=null)
           {
               obj.setAmount(obj.getAmount()-1);
               if(obj.getAmount()<=0)
               {
                    asi.getEquip_List().deleteNthNode(obj);
               }
               else
               {
                    asi.getEquip_List().insertNth(obj);
               }
               amb.getAmb_Equip().insertNode(obj);
           }
           else
           {
                JOptionPane.showMessageDialog(null, jCheckBox5.getText()+" is Missing From Inventory");
           }
       }
        } 
        
       if(comb0_is_selected(jCheckBox5.getText(), row))
       {
       if(jCheckBox6.isSelected())
       {         
            
       }
       else{
           delet_euip(jCheckBox6.getText(), row);
       }
       }
       else{
           if(jCheckBox6.isSelected())
       {
           obj=asi.Searc_Equip(jCheckBox6.getText());         
           if(obj!=null)
           {
               obj.setAmount(obj.getAmount()-1);
               if(obj.getAmount()<=0)
               {
                    asi.getEquip_List().deleteNthNode(obj);
               }
               else
               {
                    asi.getEquip_List().insertNth(obj);
               }
               amb.getAmb_Equip().insertNode(obj);
           }
           else
           {
                JOptionPane.showMessageDialog(null, jCheckBox6.getText()+" is Missing From Inventory");
           }
       } 
       }
       if(comb0_is_selected(jCheckBox7.getText(), row))
       {
       if(jCheckBox7.isSelected())
       {         
            
       }
       else{
           delet_euip(jCheckBox7.getText(), row);
       }
       }
       else{
       if(jCheckBox7.isSelected())
       {
            obj=asi.Searc_Equip(jCheckBox7.getText());
           if(obj!=null)
           {
               obj.setAmount(obj.getAmount()-1);
               if(obj.getAmount()<=0)
               {
                    asi.getEquip_List().deleteNthNode(obj);
               }
               else
               {
                    asi.getEquip_List().insertNth(obj);
               }
               amb.getAmb_Equip().insertNode(obj);
           }
           else
           {
                JOptionPane.showMessageDialog(null, jCheckBox7.getText()+" is Missing From Inventory");
           }
       }
       }
       if(comb0_is_selected(jCheckBox2.getText(), row))
       {
       if(jCheckBox2.isSelected())
       {         
            
       }
       else{
           delet_euip(jCheckBox2.getText(), row);
       }
       }
       else{
       if(jCheckBox2.isSelected())
       {
           obj=asi.Searc_Equip(jCheckBox2.getText());
           if(obj!=null)
           {
               obj.setAmount(obj.getAmount()-1);
               if(obj.getAmount()<=0)
               {
                    asi.getEquip_List().deleteNthNode(obj);
               }
               else
               {
                    asi.getEquip_List().insertNth(obj);
               }
               amb.getAmb_Equip().insertNode(obj);
           }
           else
           {
                JOptionPane.showMessageDialog(null, jCheckBox2.getText()+" is Missing From Inventory");
           }
       }
       }
       amb.setModel(name);
       amb.setNumber(number);
       amb.setType(type);
     asi.getAmbulance_List().replaceNode(amb,row);
        asi.Show_Table_Ambulances(jTable3);
       

    }//GEN-LAST:event_EDIT_AmbulanceActionPerformed

    private void Edit_EquipmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Edit_EquipmentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Edit_EquipmentActionPerformed

    private void Edit_EquipmentMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Edit_EquipmentMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_Edit_EquipmentMouseExited

    private void Edit_EquipmentMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Edit_EquipmentMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_Edit_EquipmentMouseEntered

    private void Edit_EquipmentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Edit_EquipmentMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Edit_EquipmentMouseClicked

    private void name_apply4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_name_apply4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_name_apply4ActionPerformed

    private void name_apply5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_name_apply5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_name_apply5ActionPerformed

    private void add_ambulance2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_ambulance2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_add_ambulance2MouseClicked

    private void add_ambulance2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_ambulance2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_add_ambulance2MouseEntered

    private void add_ambulance2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_ambulance2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_add_ambulance2MouseExited

    private void add_ambulance2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_ambulance2ActionPerformed
     add_Equipment();
     JOptionPane.showMessageDialog(null, "Equipment Added");
     asi.Show_Table_Equipmet(jTable4);
    }//GEN-LAST:event_add_ambulance2ActionPerformed

    private void add_ambulance1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_ambulance1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_add_ambulance1MouseClicked

    private void add_ambulance1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_ambulance1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_add_ambulance1MouseEntered

    private void add_ambulance1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_ambulance1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_add_ambulance1MouseExited

    private void add_ambulance1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_ambulance1ActionPerformed
          add_Ambulnaces();
          JOptionPane.showMessageDialog(null, "Ambulance Added");
          asi.Show_Table_Ambulances(jTable3);
       
    }//GEN-LAST:event_add_ambulance1ActionPerformed

    private void name_apply7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_name_apply7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_name_apply7ActionPerformed

    private void name_apply8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_name_apply8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_name_apply8ActionPerformed

    private void name_apply9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_name_apply9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_name_apply9ActionPerformed

    private void EDIT_Ambulance1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EDIT_Ambulance1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_EDIT_Ambulance1MouseClicked

    private void EDIT_Ambulance1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EDIT_Ambulance1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_EDIT_Ambulance1MouseEntered

    private void EDIT_Ambulance1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EDIT_Ambulance1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_EDIT_Ambulance1MouseExited

    private void EDIT_Ambulance1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EDIT_Ambulance1ActionPerformed
        new Emergency_Detail().setVisible(true);
    }//GEN-LAST:event_EDIT_Ambulance1ActionPerformed

    private void Decline1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Decline1ActionPerformed
       if (asi.getQueue_Drivers().peek() != null) {
            asi.getQueue_Drivers().dequeue();
            asi.Show_Table_Queue_Drivers(jTable6);
        } else {
            JOptionPane.showMessageDialog(null, "No Applicant Left");
        }
    }//GEN-LAST:event_Decline1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
       if (asi.getQueue_Drivers().peek() != null) {
            Drivers emt = asi.getQueue_Drivers().dequeue();
            if (asi.getDrivers_List().getSize() == 0) {
                asi.getDrivers_List().insertFirst(emt);

                asi.Show_Table_Drivers(jTable7);
            } else {
                asi.getDrivers_List().insertNode(emt);
                asi.Show_Table_Drivers(jTable7);
            }

            JOptionPane.showMessageDialog(null, "Emloyee Hired ");
            asi.Show_Table_Queue_Drivers(jTable6);

        } else {
            JOptionPane.showMessageDialog(null, "No Applicant Left");
        }
        try {
            asi.save_Drivers();
        } catch (IOException ex) {
            Logger.getLogger(ASI_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void Hire_DriverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Hire_DriverMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Hire_DriverMouseClicked

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
      int l = jTable7.getSelectedRowCount();
        if (l > 0) {
            int row = jTable7.getSelectedRow();
            Drivers obj = asi.getDrivers_List().findNodeAt(row);
          try {
              new Detail_Form(obj, jButton8, row).setVisible(true);
          } catch (IOException ex) {
              Logger.getLogger(ASI_GUI.class.getName()).log(Level.SEVERE, null, ex);
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(ASI_GUI.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void update1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update1ActionPerformed
        int l = jTable7.getSelectedRowCount();
        if (l > 0) {
            int row = jTable7.getSelectedRow();
            Drivers obj = asi.getDrivers_List().findNodeAt(row);
            try {
                new Detail_Form(obj, update1, row).setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(ASI_GUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ASI_GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_update1ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
       int l = jTable7.getSelectedRowCount();
        if (l > 0) {
            int row = jTable7.getSelectedRow();
            Drivers obj = asi.getDrivers_List().findNodeAt(row);
            asi.getDrivers_List().deleteNthNode(obj);
            asi.Show_Table_Drivers(jTable7);

        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void name_apply1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_name_apply1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_name_apply1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (asi.getQueue_Drivers().peek() != null) {
            try {
                new Detail_Form(asi.getQueue_Drivers().peek(), jButton4, 0).setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(ASI_GUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ASI_GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No Applicant Left");
        }


    }//GEN-LAST:event_jButton2ActionPerformed

    private void All_Emit_DetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_All_Emit_DetailMouseClicked
        asi.Show_Table_EMTs(jTable2);
    }//GEN-LAST:event_All_Emit_DetailMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
      if (asi.getQueue_Drivers().peek() != null) {
          try {
              new Detail_Form(asi.getQueue_Drivers().peek(), jButton4, 0).setVisible(true);
          } catch (IOException ex) {
              Logger.getLogger(ASI_GUI.class.getName()).log(Level.SEVERE, null, ex);
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(ASI_GUI.class.getName()).log(Level.SEVERE, null, ex);
          }
        } else {
            JOptionPane.showMessageDialog(null, "No Applicant Left");
        }        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void Apply_ButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Apply_ButtonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Apply_ButtonMouseClicked

    private void Apply_ButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Apply_ButtonMouseEntered
        changecolor(Apply_Button, new Color(43, 43, 43));
    }//GEN-LAST:event_Apply_ButtonMouseEntered

    private void Apply_ButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Apply_ButtonMouseExited
        changecolor(Apply_Button, new Color(51, 51, 255));
    }//GEN-LAST:event_Apply_ButtonMouseExited

    private void Apply_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Apply_ButtonActionPerformed
      asi.Show_Table_Equipmet(jTable4);

    }//GEN-LAST:event_Apply_ButtonActionPerformed

    private void Apply_Button1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Apply_Button1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Apply_Button1MouseClicked

    private void Apply_Button1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Apply_Button1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_Apply_Button1MouseEntered

    private void Apply_Button1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Apply_Button1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_Apply_Button1MouseExited

    private void Apply_Button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Apply_Button1ActionPerformed
        asi.Show_Table_EMTs(jTable2);
    }//GEN-LAST:event_Apply_Button1ActionPerformed

    private void Apply_Button2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Apply_Button2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Apply_Button2MouseClicked

    private void Apply_Button2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Apply_Button2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_Apply_Button2MouseEntered

    private void Apply_Button2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Apply_Button2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_Apply_Button2MouseExited

    private void Apply_Button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Apply_Button2ActionPerformed
       asi.Show_Table_Drivers(jTable7);
    }//GEN-LAST:event_Apply_Button2ActionPerformed

    private void jTable3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MousePressed
       int l = jTable3.getSelectedRowCount();
        if (l > 0) {
            int row = jTable3.getSelectedRow();

            String model = (String) jTable3.getValueAt(jTable3.getSelectedRow(), 0);
            String number = (String) jTable3.getValueAt(jTable3.getSelectedRow(), 1);
            String type = (String) jTable3.getValueAt(jTable3.getSelectedRow(), 2);
            String equip = (String) jTable3.getValueAt(jTable3.getSelectedRow(), 3);
            String[]list=equip.split(",");
            name_apply2.setText(model);
            name_apply7.setText(number);
            jComboBox1.setSelectedItem(type);
            jCheckBox5.setSelected(false);
            jCheckBox6.setSelected(false);
            jCheckBox7.setSelected(false);
             jCheckBox2.setSelected(false);
            for(int i=0;i<list.length;i++)
            {
                if(list[i].equals(jCheckBox5.getText()))
                {
                    jCheckBox5.setSelected(true);
                }
                else if(list[i].equals(jCheckBox6.getText()))
                {
                    jCheckBox6.setSelected(true);
                }
                 else if(list[i].equals(jCheckBox7.getText()))
                {
                    jCheckBox7.setSelected(true);
                }
                 else if(list[i].equals(jCheckBox2.getText()))
                {
                    jCheckBox2.setSelected(true);
                }
            }
            
        }
    }//GEN-LAST:event_jTable3MousePressed

    private void Apply_Button3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Apply_Button3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Apply_Button3MouseClicked

    private void Apply_Button3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Apply_Button3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_Apply_Button3MouseEntered

    private void Apply_Button3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Apply_Button3MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_Apply_Button3MouseExited

    private void Apply_Button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Apply_Button3ActionPerformed
int l = jTable3.getSelectedRowCount();
        if (l > 0) {
            int row = jTable3.getSelectedRow();
            Ambulances obj=asi.getAmbulance_List().findNodeAt(row);
            asi.getAmbulance_List().deleteNthNode(obj);
            park_availbale[row]=0;
        }    
        asi.Show_Table_Ambulances(jTable3);
         Set_All_Amb_icon();
    }//GEN-LAST:event_Apply_Button3ActionPerformed

    public void changecolor(JLabel hover, Color rand) {
        hover.setBackground(rand);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ASI_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ASI_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ASI_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ASI_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ASI_GUI().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(ASI_GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ASI_GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Account_ASI_Main;
    private javax.swing.JPanel All_Driver;
    private javax.swing.JPanel All_Emit_Detail;
    private javax.swing.JPanel Ambulances_Button_Dashboard;
    private javax.swing.JButton Apply_Button;
    private javax.swing.JButton Apply_Button1;
    private javax.swing.JButton Apply_Button2;
    private javax.swing.JButton Apply_Button3;
    private javax.swing.JPanel Dashboarbbutton;
    private javax.swing.JPanel Dashboard;
    private javax.swing.JButton Decline;
    private javax.swing.JButton Decline1;
    private javax.swing.JPanel Drivers_Button_Dashboard;
    private javax.swing.JButton EDIT_Ambulance;
    private javax.swing.JButton EDIT_Ambulance1;
    private javax.swing.JPanel EMTs_Button_Dashboard;
    private javax.swing.JButton Edit_Equipment;
    private javax.swing.JPanel Emergencies_Button_Dashboard;
    private javax.swing.JPanel Hire_Driver;
    private javax.swing.JPanel Hire_EMTs;
    private javax.swing.JPanel Main_Ambulance_Panel;
    private javax.swing.JPanel Main_Driver_Panel;
    private javax.swing.JPanel Main_EMTs_Panel;
    private javax.swing.JPanel Main_Emergency_Panel;
    private javax.swing.JPanel Main_Parking_Panel;
    private javax.swing.JPanel Minimize;
    private javax.swing.JPanel Park_1;
    private javax.swing.JPanel Park_10;
    private javax.swing.JPanel Park_2;
    private javax.swing.JPanel Park_3;
    private javax.swing.JPanel Park_4;
    private javax.swing.JPanel Park_5;
    private javax.swing.JPanel Park_6;
    private javax.swing.JPanel Park_7;
    private javax.swing.JPanel Park_8;
    private javax.swing.JPanel Park_9;
    private javax.swing.JPanel Parking;
    private javax.swing.JPanel Side_Menu_Main;
    private javax.swing.JPanel about;
    private javax.swing.JPanel accountbutton;
    private javax.swing.JButton add_ambulance1;
    private javax.swing.JButton add_ambulance2;
    private javax.swing.JPanel database;
    private javax.swing.JPanel exit2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTable jTable7;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JLabel j_1;
    private javax.swing.JLabel j_10;
    private javax.swing.JLabel j_2;
    private javax.swing.JLabel j_3;
    private javax.swing.JLabel j_4;
    private javax.swing.JLabel j_5;
    private javax.swing.JLabel j_6;
    private javax.swing.JLabel j_7;
    private javax.swing.JLabel j_8;
    private javax.swing.JLabel j_9;
    private javax.swing.JPanel login;
    private javax.swing.JPanel logout;
    private javax.swing.JPanel minimize2;
    private javax.swing.JPanel mxmize2;
    private javax.swing.JTextField name_apply;
    private javax.swing.JTextField name_apply1;
    private javax.swing.JTextField name_apply2;
    private javax.swing.JTextField name_apply4;
    private javax.swing.JTextField name_apply5;
    private javax.swing.JTextField name_apply6;
    private javax.swing.JTextField name_apply7;
    private javax.swing.JTextField name_apply8;
    private javax.swing.JTextField name_apply9;
    private javax.swing.JPanel searchbutton;
    private javax.swing.JLabel set1;
    private javax.swing.JLabel set2;
    private javax.swing.JButton upadte_Profile;
    private javax.swing.JButton update;
    private javax.swing.JButton update1;
    // End of variables declaration//GEN-END:variables
}
