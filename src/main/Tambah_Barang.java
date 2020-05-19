package main;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import javax.swing.*;

/**
 *
 * @author Siregar
 */
public class Tambah_Barang extends javax.swing.JFrame {
    
    

// Variables declaration Start
    private JPanel bg_registrasi;
    private JPanel bg_namaB;                     //BG Field
    private JTextField  field_namaB;    //Field
    private JTextArea  field_deskripsi;
    private JButton tombol_tambah;                 //Tombol
    private JLabel  tombol_tutup, label_statusBarang, judul, label_namaB, label_deskripsi;
    private JRadioButton radio_hilang,radio_temuan;
    private ButtonGroup grup_status;
//Variables declaration End
    
    Color bg_color = new Color(255,255,255);
    Color fg_color = new Color(0, 22, 38);
    Color label_color = new Color(101, 200, 255);
    Color field_BG = new Color(115, 135, 155,0);
    Color field_FG = new Color(101, 200, 248);
    
    Font btn_font = new Font("Agency FB", 1, 15);
    Font field_font = new Font("Consolas", 1, 15);
    Font label_font = new Font("Consolas", 0, 14);
    
    GraphicsDevice ScreenDim = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    int screenwidth = ScreenDim.getDisplayMode().getWidth();
    int screenheight = ScreenDim.getDisplayMode().getHeight();
    int squareDimens = screenheight*3/4;
    int panjang_field = 300;
    int field_bound_x = (squareDimens/2)-150;
    int area_bound_x = (squareDimens/2)-(screenheight/4);
    int status_dipilih; 
    String id_pengguna="14117135";

    byte[] person_image=null;
    
    public Tambah_Barang() {
        initComponents();
    }
    
    public Tambah_Barang(String id_pengguna) {
        this.id_pengguna=id_pengguna;
        initComponents();
    }

    
    
    private void initComponents() {

        tombol_tutup = new javax.swing.JLabel();       judul = new javax.swing.JLabel();
        label_namaB = new javax.swing.JLabel();
        label_deskripsi = new javax.swing.JLabel();     label_statusBarang = new javax.swing.JLabel();
        
        field_namaB = new javax.swing.JTextField();
        field_deskripsi = new JTextArea();
        
        radio_hilang = new javax.swing.JRadioButton();  radio_temuan = new javax.swing.JRadioButton();
        grup_status = new ButtonGroup();
        
        tombol_tambah = new javax.swing.JButton();     
        
        bg_namaB = new JPanel();
        bg_registrasi = new JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(550, 550));
        setMinimumSize(new java.awt.Dimension(squareDimens, squareDimens));
        setUndecorated(true);
        getContentPane().setLayout(null);
        
// Tombol Close
        tombol_tutup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/close.png")));
        tombol_tutup.setText("jLabel4");
        tombol_tutup.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        tombol_tutup.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                System.exit(0);
            }
        });
        getContentPane().add(tombol_tutup);
        tombol_tutup.setBounds(getMinimumSize().width-39, 0, 39, 39);
 
//Judul
        judul.setFont(new java.awt.Font("Consolas", 1, 15));
        judul.setForeground(new java.awt.Color(255, 255, 255));
        judul.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        judul.setLabelFor(bg_registrasi);
        judul.setText("Tambah Barang +");
        getContentPane().add(judul);
        judul.setBounds(180, 30, 200, 60);
        
// Field Nama Barang Start
        label_namaB.setFont(label_font);
        label_namaB.setForeground(label_color);
        label_namaB.setText("Nama Barang");
        getContentPane().add(label_namaB);
        label_namaB.setBounds(field_bound_x, 113, panjang_field, 30);                                                 //Tinggi 30
        
        field_namaB.setBackground(field_BG);
        field_namaB.setForeground(field_FG);
        field_namaB.setFont(field_font);
        field_namaB.setBorder(null);
        field_namaB.setBounds(field_bound_x, label_namaB.getBounds().y+20, panjang_field, 30);   //Tinggi 30
        getContentPane().add(field_namaB);
        
        bg_namaB.setBackground(bg_color);
        bg_namaB.setBounds(field_namaB.getBounds().x,field_namaB.getBounds().y+25,panjang_field,1);          //Tinggi 1
        getContentPane().add(bg_namaB);
// Field Nama End

// Field Status Barang Start
        label_statusBarang.setFont(label_font);
        label_statusBarang.setForeground(label_color);
        label_statusBarang.setText("Status Barang");
        getContentPane().add(label_statusBarang);
        label_statusBarang.setBounds(field_bound_x, label_namaB.getBounds().y+61, panjang_field, 30);

        radio_hilang.setBackground(field_BG);
        radio_hilang.setForeground(field_FG);
        radio_hilang.setFont(field_font);
        radio_hilang.setText("Hilang");
        radio_hilang.setBorder(null);
        radio_hilang.setBounds(field_bound_x, label_statusBarang.getBounds().y+20, panjang_field/2, 30); //Tinggi 30
        getContentPane().add(radio_hilang);

        radio_temuan.setBackground(field_BG);
        radio_temuan.setForeground(field_FG);
        radio_temuan.setFont(field_font);
        radio_temuan.setText("Temuan");
        radio_temuan.setBorder(null);
        radio_temuan.setBounds(field_bound_x+(panjang_field/2), label_statusBarang.getBounds().y+20, panjang_field/2, 30); //Tinggi 30
        getContentPane().add(radio_temuan);
        
        grup_status.add(radio_hilang);
        grup_status.add(radio_temuan);
        getContentPane().setVisible(true);
        
        
// Field Status Barang End

// Field Deskripsi
        label_deskripsi.setFont(label_font);
        label_deskripsi.setForeground(label_color);
        label_deskripsi.setText("Deskripsi");
        getContentPane().add(label_deskripsi);
        label_deskripsi.setBounds(field_bound_x, label_statusBarang.getBounds().y+50, panjang_field, 30);

        field_deskripsi.setBackground(field_BG);
        field_deskripsi.setForeground(field_FG);
        field_deskripsi.setFont(field_font);
        field_deskripsi.setLineWrap(true);
        field_deskripsi.setWrapStyleWord(true);
        field_deskripsi.setRows(5);
        field_deskripsi.setBorder(BorderFactory.createLineBorder(Color.white));
        field_deskripsi.setBounds(area_bound_x, label_deskripsi.getBounds().y+30, screenheight/2, 100);
        getContentPane().add(field_deskripsi);
// Field Deskripsi

        tombol_tambah.setBackground(new java.awt.Color(100, 100, 100));
        tombol_tambah.setFont(label_font);
        tombol_tambah.setForeground(new java.awt.Color(10, 20, 255));
        tombol_tambah.setText("Tambah Barang");
        tombol_tambah.addActionListener(this::DaftarActionPerformed);
        getContentPane().add(tombol_tambah);
        tombol_tambah.setBounds(label_namaB.getBounds().x, 400, label_namaB.getBounds().width, 30);
        
// Background 
        bg_registrasi.setBounds(0, 0,getMinimumSize().width, getMinimumSize().height);
        bg_registrasi.setBackground(new Color(0, 22, 50));
        getContentPane().add(bg_registrasi);
// Background 
        pack();
        setLocationRelativeTo(null);
    }                       

    private void apaYangDipilih() {
        Enumeration<AbstractButton> allRadioButton=grup_status.getElements();
        while(allRadioButton.hasMoreElements())  
        {  
           JRadioButton radio_dipilih=(JRadioButton)allRadioButton.nextElement();  
           if(radio_dipilih.isSelected())  
           {
               if("Temuan".equals(radio_dipilih.getText())){
                this.status_dipilih=0;
               }else{
                this.status_dipilih=1;
               }
               
           }  
        }
    }

    private void DaftarActionPerformed(java.awt.event.ActionEvent evt) {
        apaYangDipilih();
        try {
            
            Connection konek = DriverManager.getConnection("jdbc:mysql://localhost/sikeb","root","");
            ResultSet jlh = konek.createStatement().executeQuery("SELECT COUNT(nomor) FROM barang");
            try {
                int jumlah = 0;
                if (jlh.next()) {
                    jumlah=jlh.getInt("COUNT(nomor)");
                    jumlah++;
                }
                konek.createStatement().executeUpdate("insert into barang values("+jumlah+",'"+field_namaB.getText()+"',"+id_pengguna+", NOW(),"+status_dipilih+",'"+field_deskripsi.getText()+"')");
                JOptionPane.showMessageDialog(rootPane, "Barang Telah Ditambahkan ! \n ");
                this.dispose();
            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "Terjadi Kesalahan \n"+e.getMessage() );
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Masalah pada database !");
        }
    }                                      

}
