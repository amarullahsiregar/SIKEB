package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Form_Registrasi extends javax.swing.JFrame {
    
    

// Variables declaration Start
    private javax.swing.JPanel bg_registrasi, panelFoto;
    private javax.swing.JPanel bg_no_induk, bg_nama, bg_password,bg_kontak;                     //BG Field
    private javax.swing.JTextField field_no_induk, field_nama, field_password, field_kontak;    //Field
    private javax.swing.JButton tombol_daftar, tombol_pilih_foto;                 //Tombol
    private javax.swing.JLabel tombol_login, tombol_close, label_nomor_induk, label_kontak, tanya, judul, label_uploas_foto, label_nama, label_password;
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
    int squareDimens = ScreenDim.getDisplayMode().getHeight()*3/4;
    int panjang_field = 300;
    int field_bound_x = (squareDimens/2)-150;

    byte[] person_image=null;
    public Form_Registrasi() {
        initComponents();
    }

    
    
    private void initComponents() {

        tombol_close = new javax.swing.JLabel();       judul = new javax.swing.JLabel();
        tanya = new javax.swing.JLabel();              label_uploas_foto = new javax.swing.JLabel();
        label_nama = new javax.swing.JLabel();         label_kontak = new javax.swing.JLabel();
        label_password = new javax.swing.JLabel();     label_nomor_induk = new javax.swing.JLabel();
        
        field_nama = new javax.swing.JTextField();     field_kontak = new javax.swing.JTextField();
        field_no_induk = new javax.swing.JTextField(); field_password = new javax.swing.JTextField();
        
        tombol_login = new javax.swing.JLabel();
        
        tombol_pilih_foto = new javax.swing.JButton();
        tombol_daftar = new javax.swing.JButton();     
        
        bg_nama = new JPanel();                        bg_no_induk = new JPanel();
        bg_password = new JPanel();                    bg_kontak = new JPanel();
        bg_registrasi = new JPanel();                  panelFoto = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(550, 550));
        setMinimumSize(new java.awt.Dimension(squareDimens, squareDimens));
        setUndecorated(true);
        getContentPane().setLayout(null);
        
// Tombol Close
        tombol_close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/close.png")));
        tombol_close.setText("jLabel4");
        tombol_close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tombol_close.setMaximumSize(new java.awt.Dimension(39, 39));
        tombol_close.setMinimumSize(new java.awt.Dimension(39, 39));
        tombol_close.setPreferredSize(new java.awt.Dimension(39, 39));
        tombol_close.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
        });
        getContentPane().add(tombol_close);
        tombol_close.setBounds(getMinimumSize().width-39, 0, 39, 39);
 
//Judul
        judul.setFont(new java.awt.Font("Consolas", 1, 15));
        judul.setForeground(new java.awt.Color(255, 255, 255));
        judul.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        judul.setLabelFor(bg_registrasi);
        judul.setText("Buat Akun Baru");
        getContentPane().add(judul);
        judul.setBounds(180, 30, 200, 60);
        
// Field Nama Start
        label_nama.setFont(label_font);
        label_nama.setForeground(label_color);
        label_nama.setText("Nama Lengkap");
        getContentPane().add(label_nama);
        label_nama.setBounds(field_bound_x, 113, panjang_field, 30);                                                 //Tinggi 30
        
        field_nama.setBackground(field_BG);
        field_nama.setForeground(field_FG);
        field_nama.setFont(field_font);
        field_nama.setBorder(null);
        field_nama.setBounds(field_bound_x, label_nama.getBounds().y+20, panjang_field, 30);   //Tinggi 30
        getContentPane().add(field_nama);
        
        bg_nama.setBackground(bg_color);
        bg_nama.setBounds(field_nama.getBounds().x,field_nama.getBounds().y+25,panjang_field,1);          //Tinggi 1
        getContentPane().add(bg_nama);
// Field Nama End

// Field Nomor Induk Start
        label_nomor_induk.setFont(label_font);
        label_nomor_induk.setForeground(label_color);
        label_nomor_induk.setText("Nomor Induk ");
        getContentPane().add(label_nomor_induk);
        label_nomor_induk.setBounds(field_bound_x, label_nama.getBounds().y+61, panjang_field, 30);

        field_no_induk.setBackground(field_BG);
        field_no_induk.setForeground(field_FG);
        field_no_induk.setFont(field_font);
        field_no_induk.setBorder(null);
        field_no_induk.setBounds(field_bound_x, label_nomor_induk.getBounds().y+20, panjang_field, 30); //Tinggi 30
        getContentPane().add(field_no_induk);
        
        bg_no_induk.setBackground(bg_color);
        bg_no_induk.setBounds(field_bound_x,field_no_induk.getBounds().y+25,field_no_induk.getBounds().width,1);
        getContentPane().add(bg_no_induk);
// Field Nomor Induk End

// Field Password Start
        label_password.setFont(label_font);
        label_password.setForeground(label_color);
        label_password.setText("Password");
        getContentPane().add(label_password);
        label_password.setBounds(field_bound_x, label_nomor_induk.getBounds().y+61, panjang_field, 30);

        field_password.setBackground(field_BG);
        field_password.setForeground(field_FG);
        field_password.setFont(field_font);
        field_password.setBorder(null);
        field_password.setBounds(field_bound_x, label_password.getBounds().y+20, panjang_field, 30);
        getContentPane().add(field_password);
        
        bg_password.setBackground(bg_color);
        bg_password.setBounds(field_bound_x,field_password.getBounds().y+25,field_password.getBounds().width,1);
        getContentPane().add(bg_password);
// Field Password End

// Field Kontak Start
        label_kontak.setFont(label_font);
        label_kontak.setForeground(label_color);
        label_kontak.setText("Kontak");
        label_kontak.setBounds(field_bound_x, label_password.getBounds().y+61, panjang_field, 30);
        getContentPane().add(label_kontak);
        
        field_kontak.setBackground(field_BG);
        field_kontak.setForeground(field_FG);
        field_kontak.setFont(field_font);
        field_kontak.setBorder(null);
        field_kontak.setBounds(field_bound_x, label_kontak.getBounds().y+20, panjang_field, 30);
        getContentPane().add(field_kontak);
        
        bg_kontak.setBackground(bg_color);
        bg_kontak.setBounds(field_bound_x,field_kontak.getBounds().y+25,field_kontak.getBounds().width,1);
        getContentPane().add(bg_kontak);
// Field Kontak End


        label_uploas_foto.setFont(label_font);
        label_uploas_foto.setForeground(label_color);
        label_uploas_foto.setText("Upload Foto Identitas");
        label_uploas_foto.setBounds(field_bound_x, label_kontak.getBounds().y+61, panjang_field, 30);
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
        tombol_daftar.setText("Daftar");
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
                konek.createStatement().executeUpdate("insert into pengguna values"+"('"+field_no_induk.getText()+"','"+field_password.getText()+"','"+field_nama.getText()+"','"+field_kontak.getText()+"','0')");
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
        // TODO add your handling code here:
        Login_User A = new Login_User();
        A.setVisible(true);
        this.dispose();
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
            new Form_Registrasi().setVisible(true);
        });
    }
}
