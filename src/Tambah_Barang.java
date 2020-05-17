package main;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.*;

/**
 *
 * @author Siregar
 */
public class Tambah_Barang extends javax.swing.JFrame {
    
    

// Variables declaration Start
    private JPanel bg_registrasi, panelFoto;
    private JPanel bg_namaB, bg_passwordB,bg_kontak;                     //BG Field
    private JTextField  field_namaB, field_kontak;    //Field
    private JTextArea  field_deskripsi;
    private JButton tombol_daftar, tombol_pilih_foto;                 //Tombol
    private JLabel tombol_login, tombol_tutup, label_statusBarang, label_kontak, tanya, judul, label_uploas_foto, label_namaB, label_deskripsi;
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

    byte[] person_image=null;
    
    public Tambah_Barang() {
        initComponents();
    }

    
    
    private void initComponents() {

        tombol_tutup = new javax.swing.JLabel();       judul = new javax.swing.JLabel();
        tanya = new javax.swing.JLabel();              label_uploas_foto = new javax.swing.JLabel();
        label_namaB = new javax.swing.JLabel();         label_kontak = new javax.swing.JLabel();
        label_deskripsi = new javax.swing.JLabel();     label_statusBarang = new javax.swing.JLabel();
        
        field_namaB = new javax.swing.JTextField();     field_kontak = new javax.swing.JTextField();
        field_deskripsi = new JTextArea();
        
        radio_hilang = new javax.swing.JRadioButton();  radio_temuan = new javax.swing.JRadioButton();
        grup_status = new ButtonGroup();
        
        tombol_login = new javax.swing.JLabel();
        
        tombol_pilih_foto = new javax.swing.JButton();
        tombol_daftar = new javax.swing.JButton();     
        
        bg_namaB = new JPanel();
        bg_passwordB = new JPanel();                    bg_kontak = new JPanel();
        bg_registrasi = new JPanel();                  panelFoto = new javax.swing.JPanel();

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
                closeMouseClicked(evt);
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

// Field Password Start
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
        
// Field Password End


        label_uploas_foto.setFont(label_font);
        label_uploas_foto.setForeground(label_color);
        label_uploas_foto.setText("Upload Foto Identitas");
        label_uploas_foto.setBounds(field_bound_x, field_deskripsi.getBounds().y+field_deskripsi.getBounds().height, panjang_field, 30);
        getContentPane().add(label_uploas_foto);
        getContentPane().add(panelFoto);
        panelFoto.setBounds(140, 310, 190, 130);

        tanya.setForeground(new java.awt.Color(101, 200, 255));
        tanya.setText("sudah punya akun ?");
        getContentPane().add(tanya);
        tanya.setBounds(280, panelFoto.getBounds().y+120, 120, 20);
        getContentPane().add(panelFoto);
        panelFoto.setBounds(label_uploas_foto.getBounds().x, label_uploas_foto.getBounds().y+35, 160, 120);

        tombol_pilih_foto.setText("Pilih");
        getContentPane().add(tombol_pilih_foto);
        tombol_pilih_foto.setBounds(panelFoto.getBounds().x+162, panelFoto.getBounds().y, 80, 30);

        tombol_daftar.setBackground(new java.awt.Color(100, 100, 100));
        tombol_daftar.setFont(new java.awt.Font("Agency FB", 1, 22));
        tombol_daftar.setForeground(new java.awt.Color(10, 20, 255));
        tombol_daftar.setText("Tambah Barang");
        tombol_daftar.addActionListener(this::DaftarActionPerformed);
        getContentPane().add(tombol_daftar);
        tombol_daftar.setBounds(tombol_pilih_foto.getBounds().x, panelFoto.getBounds().y+90, 80, 30);

        tanya.setForeground(new java.awt.Color(101, 200, 255));
        tanya.setText("sudah punya akun ?");
        getContentPane().add(tanya);
        tanya.setBounds((squareDimens/2)-77, panelFoto.getBounds().y+130, 112, 20);

        tombol_login.setText("Login");
        tombol_login.setFont(field_font);
        tombol_login.setBackground(bg_color);
        tombol_login.setForeground(new Color(0, 100, 172));
        tombol_login.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tombol_login.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tombolLoginOnClick(evt);
            }
        });
        tombol_login.setBounds(tanya.getBounds().x+tanya.getBounds().width+2, tanya.getBounds().y, 40, 23);
        getContentPane().add(tombol_login);
        
// Background 
        bg_registrasi.setBounds(0, 0,getMinimumSize().width, getMinimumSize().height);
        bg_registrasi.setBackground(new Color(0, 22, 50));
        getContentPane().add(bg_registrasi);
// Background 
        pack();
        setLocationRelativeTo(null);
    }                       

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {                                   
        // TODO add your handling code here:
        this.dispose();
    }                                  

    private void DaftarActionPerformed(java.awt.event.ActionEvent evt) {                                       
        try {
            // TODO add your handling code here:
            Connection konek = DriverManager.getConnection("jdbc:mysql://localhost/lakban","root","");
            try {
                konek.createStatement().executeUpdate("insert into pengguna values"+"('"+radio_hilang.getText()+"','"+field_deskripsi.getText()+"','"+field_namaB.getText()+"','"+field_kontak.getText()+"','0')");
                JOptionPane.showMessageDialog(rootPane, "selesai mendaftar ! \n tunggu konfirmasi dari admin ke kontak yang anda cantumkan ");
            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "Masukkan Nomor Identitas dengan angka !");
            }
            
            //load_table();
            //kosong();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Masalah pada database !");
        }
    }                                      

    private void tombolLoginOnClick(java.awt.event.MouseEvent evt) {
        Login_User A = new Login_User();
        A.setVisible(true);
        this.dispose();
        
//        if (radio_hilang.isSelected()) {
//            JOptionPane.showMessageDialog(rootPane, "Barangnya Hilang");
//        }else if (radio_temuan.isSelected()) {
//            JOptionPane.showMessageDialog(rootPane, "Barangnya Temuan");
//        }
    }                                     


    public static void main(String args[]) {
                
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tambah_Barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new Tambah_Barang().setVisible(true);
        });
    }
}
