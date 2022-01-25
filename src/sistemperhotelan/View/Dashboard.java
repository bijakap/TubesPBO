/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemperhotelan.View;
import sistemperhotelan.model.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;

/**
 *
 * @author bijak
 */
public class Dashboard extends javax.swing.JFrame {
    static final String DB_URL = "jdbc:mysql://localhost/tubespbo";
    static final String DB_USER = "root";
    static final String DB_PASS = "";
    static Connection conn;
    static Statement stmt;
    static ResultSet rs;
    List<Kamar> listKamar = new ArrayList<>();
    //0* = Kosong, 1* = Booked
    //*1 = Standar, 2 = Superior, 3 = Deluxe
    //Contoh 13 = array kamar untuk Booked tipe Deluxe
    List<Kamar> listKamarTipe01 = new ArrayList<>();
    List<Kamar> listKamarTipe02 = new ArrayList<>();
    List<Kamar> listKamarTipe03 = new ArrayList<>();
    List<Kamar> listKamarTipe11 = new ArrayList<>();
    List<Kamar> listKamarTipe12 = new ArrayList<>();
    List<Kamar> listKamarTipe13 = new ArrayList<>();
    Karyawan worker;
    Kamar PilihanKamar;
    /**
     * Creates new form UI
     */
    public Dashboard() {
        initComponents();
        InitKamar();
        this.Booking.setEnabled(false);
    }
    
    public void InitKamar(){
        listKamar.clear();
        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            stmt = conn.createStatement();
            String sql = "SELECT * FROM kamar";
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                listKamar.add(new Kamar(rs.getString("tipe"), rs.getInt("nomor"),rs.getString("lantai"),rs.getString("status")));
            }
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.setList();
    }
    
    public void setList(){
        //Buat Yang Belum Ke Booking
        DefaultListModel p1 = new DefaultListModel();
        DefaultListModel p2 = new DefaultListModel();
        DefaultListModel p3 = new DefaultListModel();
        //Buat Yang Sudah Ke Booking
        DefaultListModel p4 = new DefaultListModel();
        DefaultListModel p5 = new DefaultListModel();
        DefaultListModel p6 = new DefaultListModel();
        for (int i = 0; i < listKamar.size(); i++) {
//            System.out.print(listKamar.get(i).getTipe().equals("Standar"));
            if ( listKamar.get(i).getTipe().equals("Standar") && listKamar.get(i).getStatus().equals("Kosong") ){
                p1.addElement(listKamar.get(i).getLantai()+"- No"+listKamar.get(i).getNomor());
                listKamarTipe01.add(listKamar.get(i));
            } else if ( listKamar.get(i).getTipe().equals("Superior") && listKamar.get(i).getStatus().equals("Kosong") ){
                p2.addElement(listKamar.get(i).getLantai()+"- No"+listKamar.get(i).getNomor());
                listKamarTipe02.add(listKamar.get(i));
            } else if ( listKamar.get(i).getTipe().equals("Deluxe") && listKamar.get(i).getStatus().equals("Kosong") ){
                p3.addElement(listKamar.get(i).getLantai()+"- No"+listKamar.get(i).getNomor());
                listKamarTipe03.add(listKamar.get(i));
            } else if ( listKamar.get(i).getTipe().equals("Standar") && listKamar.get(i).getStatus().equals("Booked") ){
                p4.addElement(listKamar.get(i).getLantai()+"- No"+listKamar.get(i).getNomor());
                listKamarTipe11.add(listKamar.get(i));
            } else if ( listKamar.get(i).getTipe().equals("Superior") && listKamar.get(i).getStatus().equals("Booked") ){
                p5.addElement(listKamar.get(i).getLantai()+"- No"+listKamar.get(i).getNomor());
                listKamarTipe12.add(listKamar.get(i));
            } else {
                p6.addElement(listKamar.get(i).getLantai()+"- No"+listKamar.get(i).getNomor());
                listKamarTipe13.add(listKamar.get(i));
            }
        }
        this.ListStandar.setModel(p1);
        this.ListSuperior.setModel(p2);
        this.ListDeluxe.setModel(p3);
        this.ListStandar1.setModel(p4);
        this.ListSuperior1.setModel(p5);
        this.ListDeluxe1.setModel(p6);
    }
    
    public void setLabelTamu(String NoKamar){
        String id_tamu = "";
        String pass = "";
        String nama = "";
        String contact = "";
        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            stmt = conn.createStatement();
            String sql = "SELECT * FROM `user` WHERE nomor = '"+NoKamar+"';";
            rs = stmt.executeQuery(sql);
            while(rs.next()){
//                System.out.print(rs.getString("id_tamu")+" "+rs.getString("password"));
                id_tamu = rs.getString("id_tamu");
                pass = rs.getString("password");
            }
            stmt.close();
            stmt = conn.createStatement();
            sql = "SELECT * FROM `tamu` WHERE id_tamu = '"+id_tamu+"';";
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                nama = rs.getString("nama");
                contact =  rs.getString("nomor_hp");
//                System.out.print(rs.getString("nama")+" "+rs.getString("nomor_hp"));
            }
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.IDTamu.setText(id_tamu);
        this.NamaTamu.setText(nama);
        this.Kontak.setText(contact);
        this.Password.setText(pass);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        TabDaftarKamar = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        Tipe01 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListStandar = new javax.swing.JList<>();
        Tipe02 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ListSuperior = new javax.swing.JList<>();
        Tipe03 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        ListDeluxe = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Status = new javax.swing.JLabel();
        Tipe = new javax.swing.JLabel();
        Lantai = new javax.swing.JLabel();
        NoKamar = new javax.swing.JLabel();
        Booking = new javax.swing.JButton();
        TabBooking = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        Tipe11 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        ListStandar1 = new javax.swing.JList<>();
        Tipe12 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        ListSuperior1 = new javax.swing.JList<>();
        Tipe4 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        ListDeluxe1 = new javax.swing.JList<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        NoKamar1 = new javax.swing.JLabel();
        Lantai1 = new javax.swing.JLabel();
        Tipe1 = new javax.swing.JLabel();
        Status1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        NamaTamu = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        IDTamu = new javax.swing.JLabel();
        Password = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        Jlabelan = new javax.swing.JLabel();
        Kontak = new javax.swing.JLabel();
        HaloAdmin1 = new javax.swing.JLabel();
        HaloAdmin2 = new javax.swing.JLabel();
        Keluar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        TabDaftarKamar.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTabbedPane2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTabbedPane2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane2MouseClicked(evt);
            }
        });

        ListStandar.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        ListStandar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListStandarMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ListStandar);

        javax.swing.GroupLayout Tipe01Layout = new javax.swing.GroupLayout(Tipe01);
        Tipe01.setLayout(Tipe01Layout);
        Tipe01Layout.setHorizontalGroup(
            Tipe01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tipe01Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        Tipe01Layout.setVerticalGroup(
            Tipe01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tipe01Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Standar", Tipe01);

        ListSuperior.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        ListSuperior.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListSuperiorMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(ListSuperior);

        javax.swing.GroupLayout Tipe02Layout = new javax.swing.GroupLayout(Tipe02);
        Tipe02.setLayout(Tipe02Layout);
        Tipe02Layout.setHorizontalGroup(
            Tipe02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tipe02Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Tipe02Layout.setVerticalGroup(
            Tipe02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tipe02Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Superior", Tipe02);

        ListDeluxe.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        ListDeluxe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListDeluxeMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(ListDeluxe);

        javax.swing.GroupLayout Tipe03Layout = new javax.swing.GroupLayout(Tipe03);
        Tipe03.setLayout(Tipe03Layout);
        Tipe03Layout.setHorizontalGroup(
            Tipe03Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tipe03Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Tipe03Layout.setVerticalGroup(
            Tipe03Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tipe03Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Deluxe", Tipe03);

        jLabel1.setText("No Kamar  :");

        jLabel2.setText("Lantai       :");

        jLabel3.setText("Tipe         :");

        jLabel4.setText("Status      :");

        Status.setText("Null");

        Tipe.setText("Null");

        Lantai.setText("Null");

        NoKamar.setText("Null");

        Booking.setText("Book Kamar");
        Booking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BookingActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TabDaftarKamarLayout = new javax.swing.GroupLayout(TabDaftarKamar);
        TabDaftarKamar.setLayout(TabDaftarKamarLayout);
        TabDaftarKamarLayout.setHorizontalGroup(
            TabDaftarKamarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TabDaftarKamarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TabDaftarKamarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TabDaftarKamarLayout.createSequentialGroup()
                        .addGroup(TabDaftarKamarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(TabDaftarKamarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Lantai)
                            .addComponent(NoKamar)
                            .addComponent(Tipe)
                            .addComponent(Status)))
                    .addComponent(Booking))
                .addContainerGap())
        );
        TabDaftarKamarLayout.setVerticalGroup(
            TabDaftarKamarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TabDaftarKamarLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(TabDaftarKamarLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(TabDaftarKamarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(NoKamar))
                .addGap(18, 18, 18)
                .addGroup(TabDaftarKamarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Lantai))
                .addGap(18, 18, 18)
                .addGroup(TabDaftarKamarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Tipe))
                .addGap(18, 18, 18)
                .addGroup(TabDaftarKamarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(Status))
                .addGap(18, 18, 18)
                .addComponent(Booking)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Daftar Kamar", TabDaftarKamar);

        TabBooking.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTabbedPane3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        ListStandar1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        ListStandar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListStandar1MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(ListStandar1);

        javax.swing.GroupLayout Tipe11Layout = new javax.swing.GroupLayout(Tipe11);
        Tipe11.setLayout(Tipe11Layout);
        Tipe11Layout.setHorizontalGroup(
            Tipe11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tipe11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Tipe11Layout.setVerticalGroup(
            Tipe11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tipe11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane3.addTab("Standar", Tipe11);

        ListSuperior1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        ListSuperior1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListSuperior1MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(ListSuperior1);

        javax.swing.GroupLayout Tipe12Layout = new javax.swing.GroupLayout(Tipe12);
        Tipe12.setLayout(Tipe12Layout);
        Tipe12Layout.setHorizontalGroup(
            Tipe12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tipe12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Tipe12Layout.setVerticalGroup(
            Tipe12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tipe12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane3.addTab("Superior", Tipe12);

        ListDeluxe1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        ListDeluxe1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListDeluxe1MouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(ListDeluxe1);

        javax.swing.GroupLayout Tipe4Layout = new javax.swing.GroupLayout(Tipe4);
        Tipe4.setLayout(Tipe4Layout);
        Tipe4Layout.setHorizontalGroup(
            Tipe4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tipe4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Tipe4Layout.setVerticalGroup(
            Tipe4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tipe4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane3.addTab("Deluxe", Tipe4);

        jLabel5.setText("No Kamar :");

        jLabel6.setText("Lantai      :");

        jLabel7.setText("Tipe         :");

        jLabel8.setText("Status      :");

        NoKamar1.setText("Null");

        Lantai1.setText("Null");

        Tipe1.setText("Null");

        Status1.setText("Null");

        jLabel9.setText("Nama       :");

        NamaTamu.setText("Null");

        jLabel10.setText("ID Tamu   :");

        IDTamu.setText("Null");

        Password.setText("Null");

        jLabel11.setText("Password  :");

        Jlabelan.setText("Contact     :");

        Kontak.setText("Null");

        javax.swing.GroupLayout TabBookingLayout = new javax.swing.GroupLayout(TabBooking);
        TabBooking.setLayout(TabBookingLayout);
        TabBookingLayout.setHorizontalGroup(
            TabBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TabBookingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(TabBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TabBookingLayout.createSequentialGroup()
                        .addGroup(TabBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(20, 20, 20)
                        .addGroup(TabBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NoKamar1, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                            .addComponent(Lantai1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Tipe1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Status1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(NamaTamu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(IDTamu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(TabBookingLayout.createSequentialGroup()
                        .addComponent(Jlabelan)
                        .addGap(18, 18, 18)
                        .addComponent(Kontak, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(TabBookingLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(Password, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        TabBookingLayout.setVerticalGroup(
            TabBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TabBookingLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(TabBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, TabBookingLayout.createSequentialGroup()
                        .addGroup(TabBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(NoKamar1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(TabBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(Lantai1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(TabBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Tipe1)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(TabBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(Status1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(TabBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(NamaTamu))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(TabBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(IDTamu))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(TabBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(Password))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(TabBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Jlabelan)
                            .addComponent(Kontak)))
                    .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Booking Saat Ini", TabBooking);

        HaloAdmin1.setText("<html><h3>Halo, </h3></html>");

        HaloAdmin2.setText("<html><h3>ID_Karyawan-Posisi </h3></html>");

        Keluar.setText("Logout");
        Keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KeluarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTabbedPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(HaloAdmin1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(HaloAdmin2)))
                .addGap(13, 13, 13)
                .addComponent(Keluar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(HaloAdmin1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(HaloAdmin2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Keluar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BookingActionPerformed
        // TODO add your handling code here:
        Dashboard_Book a = new Dashboard_Book(PilihanKamar);
        a.setKeteranganKamar();
        a.setTitle("Hotel Ghoib");
        a.setVisible(true);
    }//GEN-LAST:event_BookingActionPerformed

    private void ListStandarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListStandarMouseClicked
        // TODO add your handling code here:
        if(listKamarTipe01.size() > 0){
            this.NoKamar.setText(String.valueOf(listKamarTipe01.get(this.ListStandar.getAnchorSelectionIndex()).getNomor()));
            this.Lantai.setText(listKamarTipe01.get(this.ListStandar.getAnchorSelectionIndex()).getLantai());
            this.Tipe.setText(listKamarTipe01.get(this.ListStandar.getAnchorSelectionIndex()).getTipe());
            this.Status.setText(listKamarTipe01.get(this.ListStandar.getAnchorSelectionIndex()).getStatus());
            this.Booking.setEnabled(true);
            PilihanKamar = listKamarTipe01.get(this.ListStandar.getAnchorSelectionIndex());
        }
    }//GEN-LAST:event_ListStandarMouseClicked

    private void ListSuperiorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListSuperiorMouseClicked
        // TODO add your handling code here:
        if(listKamarTipe02.size() > 0){
            this.NoKamar.setText(String.valueOf(listKamarTipe02.get(this.ListSuperior.getAnchorSelectionIndex()).getNomor()));
            this.Lantai.setText(listKamarTipe02.get(this.ListSuperior.getAnchorSelectionIndex()).getLantai());
            this.Tipe.setText(listKamarTipe02.get(this.ListSuperior.getAnchorSelectionIndex()).getTipe());
            this.Status.setText(listKamarTipe02.get(this.ListSuperior.getAnchorSelectionIndex()).getStatus());
            this.Booking.setEnabled(true);
            PilihanKamar = listKamarTipe02.get(this.ListSuperior.getAnchorSelectionIndex());
        }
    }//GEN-LAST:event_ListSuperiorMouseClicked

    private void ListDeluxeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListDeluxeMouseClicked
        // TODO add your handling code here:
        if(listKamarTipe03.size() > 0){
            this.NoKamar.setText(String.valueOf(listKamarTipe03.get(this.ListDeluxe.getAnchorSelectionIndex()).getNomor()));
            this.Lantai.setText(listKamarTipe03.get(this.ListDeluxe.getAnchorSelectionIndex()).getLantai());
            this.Tipe.setText(listKamarTipe03.get(this.ListDeluxe.getAnchorSelectionIndex()).getTipe());
            this.Status.setText(listKamarTipe03.get(this.ListDeluxe.getAnchorSelectionIndex()).getStatus());
            this.Booking.setEnabled(true);
            PilihanKamar = listKamarTipe03.get(this.ListDeluxe.getAnchorSelectionIndex());
        }
    }//GEN-LAST:event_ListDeluxeMouseClicked

    private void ListStandar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListStandar1MouseClicked
        // TODO add your handling code here:
        if(listKamarTipe11.size() > 0){
            this.NoKamar1.setText(String.valueOf(listKamarTipe11.get(this.ListStandar1.getAnchorSelectionIndex()).getNomor()));
            this.Lantai1.setText(listKamarTipe11.get(this.ListStandar1.getAnchorSelectionIndex()).getLantai());
            this.Tipe1.setText(listKamarTipe11.get(this.ListStandar1.getAnchorSelectionIndex()).getTipe());
            this.Status1.setText(listKamarTipe11.get(this.ListStandar1.getAnchorSelectionIndex()).getStatus());
            setLabelTamu(String.valueOf(listKamarTipe11.get(this.ListStandar1.getAnchorSelectionIndex()).getNomor()));
        }
        
    }//GEN-LAST:event_ListStandar1MouseClicked

    private void ListSuperior1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListSuperior1MouseClicked
        // TODO add your handling code here: 
        if(listKamarTipe12.size() > 0){
            this.NoKamar1.setText(String.valueOf(listKamarTipe12.get(this.ListSuperior1.getAnchorSelectionIndex()).getNomor()));
            this.Lantai1.setText(listKamarTipe12.get(this.ListSuperior1.getAnchorSelectionIndex()).getLantai());
            this.Tipe1.setText(listKamarTipe12.get(this.ListSuperior1.getAnchorSelectionIndex()).getTipe());
            this.Status1.setText(listKamarTipe12.get(this.ListSuperior1.getAnchorSelectionIndex()).getStatus());
            setLabelTamu(String.valueOf(listKamarTipe12.get(this.ListSuperior1.getAnchorSelectionIndex()).getNomor()));
        }
        
    }//GEN-LAST:event_ListSuperior1MouseClicked

    private void ListDeluxe1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListDeluxe1MouseClicked
        // TODO add your handling code here:
        if (listKamarTipe13.size() > 0){
            this.NoKamar1.setText(String.valueOf(listKamarTipe13.get(this.ListDeluxe1.getAnchorSelectionIndex()).getNomor()));
            this.Lantai1.setText(listKamarTipe13.get(this.ListDeluxe1.getAnchorSelectionIndex()).getLantai());
            this.Tipe1.setText(listKamarTipe13.get(this.ListDeluxe1.getAnchorSelectionIndex()).getTipe());
            this.Status1.setText(listKamarTipe13.get(this.ListDeluxe1.getAnchorSelectionIndex()).getStatus());
            setLabelTamu(String.valueOf(listKamarTipe13.get(this.ListDeluxe1.getAnchorSelectionIndex()).getNomor()));
        }
    }//GEN-LAST:event_ListDeluxe1MouseClicked

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        // TODO add your handling code here:
        System.out.print("refresh");
        this.InitKamar();
        System.out.print("... done");
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void jTabbedPane2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane2MouseClicked
        // TODO add your handling code here:
        System.out.print("refresh");
        this.InitKamar();
        System.out.print("... done");
    }//GEN-LAST:event_jTabbedPane2MouseClicked

    private void KeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KeluarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        this.dispose();
        MasukAdmin a = new MasukAdmin();
        a.setVisible(true);
        a.setTitle("Hotel Ghoib");
    }//GEN-LAST:event_KeluarActionPerformed

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
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Booking;
    public javax.swing.JLabel HaloAdmin1;
    public javax.swing.JLabel HaloAdmin2;
    private javax.swing.JLabel IDTamu;
    private javax.swing.JLabel Jlabelan;
    private javax.swing.JButton Keluar;
    private javax.swing.JLabel Kontak;
    private javax.swing.JLabel Lantai;
    private javax.swing.JLabel Lantai1;
    private javax.swing.JList<String> ListDeluxe;
    private javax.swing.JList<String> ListDeluxe1;
    private javax.swing.JList<String> ListStandar;
    private javax.swing.JList<String> ListStandar1;
    private javax.swing.JList<String> ListSuperior;
    private javax.swing.JList<String> ListSuperior1;
    private javax.swing.JLabel NamaTamu;
    private javax.swing.JLabel NoKamar;
    private javax.swing.JLabel NoKamar1;
    private javax.swing.JLabel Password;
    private javax.swing.JLabel Status;
    private javax.swing.JLabel Status1;
    private javax.swing.JPanel TabBooking;
    private javax.swing.JPanel TabDaftarKamar;
    private javax.swing.JLabel Tipe;
    private javax.swing.JPanel Tipe01;
    private javax.swing.JPanel Tipe02;
    private javax.swing.JPanel Tipe03;
    private javax.swing.JLabel Tipe1;
    private javax.swing.JPanel Tipe11;
    private javax.swing.JPanel Tipe12;
    private javax.swing.JPanel Tipe4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    // End of variables declaration//GEN-END:variables
}
