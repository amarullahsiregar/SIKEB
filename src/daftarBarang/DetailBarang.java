package daftarBarang;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class DetailBarang extends javax.swing.JFrame{
    
    Connection koneksi;

// Variables declaration Start
    private JPanel bg_registrasi;
    private JPanel bgNamaBarang,bgStatusBarang,bgKontakBarang;
    private JTextArea  field_deskripsi;
    private JLabel  tombol_tutup, labelStatusBarang, labelKontakBarang,  judul, label_deskripsi, labelNamaBarang;
    
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
    
    
    String url ="jdbc:mysql://localhost/sikeb";
    String user="root";
    String pass="";
    String idBarang, namaBarang, statusBarang, deskripsiBarang, kontakBarang;
    
    public DetailBarang(String idBarang) {
        this.idBarang=idBarang;
        ambilData();
        initComponents();
    }
    
    private void ambilData() {
        
        try {koneksi = DriverManager.getConnection("jdbc:mysql://localhost/sikeb","root","");
            ResultSet rs = koneksi.createStatement().executeQuery("SELECT * FROM barang INNER JOIN pengguna WHERE barang.id_pengguna = pengguna.id_pengguna and nomor="+idBarang+" order by waktu desc");
            while(rs.next()){
                namaBarang=rs.getString("nama_barang");
                if("0".equals(rs.getString("status_barang"))){
                    statusBarang ="Temuan";
                }else{
                    statusBarang ="Hilang";
                }
                deskripsiBarang=rs.getString("keterangan");
                kontakBarang=rs.getString("kontak");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaftarBarang.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private void initComponents() {

        tombol_tutup = new javax.swing.JLabel();       judul = new javax.swing.JLabel();
        label_deskripsi = new javax.swing.JLabel();     labelStatusBarang = new javax.swing.JLabel();
        
        labelKontakBarang = new javax.swing.JLabel();
        labelNamaBarang = new javax.swing.JLabel();
        field_deskripsi = new JTextArea();
        
        bgNamaBarang = new JPanel();
        bgKontakBarang = new JPanel();
        bgStatusBarang = new JPanel();
        bg_registrasi = new JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(550, 550));
        setMinimumSize(new java.awt.Dimension(squareDimens, squareDimens));
        setUndecorated(true);
        getContentPane().setLayout(null);
        this.addFocusListener( new FocusListener() {
            
            //This
            private boolean gained = false;
                @Override
            public void focusGained( FocusEvent e ) {
                gained = true;
            }

                @Override
            public void focusLost( FocusEvent e ) {
                if ( gained ){
                    dispose();
                }
            }
        } );
        
// Tombol Close
        tombol_tutup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/close.png")));
        tombol_tutup.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        tombol_tutup.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dispose();
            }
        });
        getContentPane().add(tombol_tutup);
        tombol_tutup.setBounds(getMinimumSize().width-39, 0, 39, 39);
 
//Judul
        judul.setFont(new java.awt.Font("Consolas", 1, 25));
        judul.setForeground(new java.awt.Color(255, 255, 255));
        judul.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        judul.setLabelFor(bg_registrasi);
        judul.setText("Detail Barang");
        getContentPane().add(judul);
        judul.setBounds(180, 30, 200, 60);
        
// Field Nama Barang Start
        labelNamaBarang.setBackground(field_BG);
        labelNamaBarang.setForeground(field_FG);
        labelNamaBarang.setText("Nama Barang : "+namaBarang);
        labelNamaBarang.setFont(field_font);
        labelNamaBarang.setBorder(null);
        labelNamaBarang.setBounds(field_bound_x, 133, panjang_field, 30);   //Tinggi 30
        getContentPane().add(labelNamaBarang);
        
        bgNamaBarang.setBackground(bg_color);
        bgNamaBarang.setBounds(labelNamaBarang.getBounds().x,labelNamaBarang.getBounds().y+25,panjang_field,1);          //Tinggi 1
        getContentPane().add(bgNamaBarang);
// Field Nama End

// Field Status Barang Start
        labelStatusBarang.setForeground(label_color);
        labelStatusBarang.setText("Status Barang : "+statusBarang);
        labelStatusBarang.setFont(field_font);
        getContentPane().add(labelStatusBarang);
        labelStatusBarang.setBounds(field_bound_x, 113+61, panjang_field, 30);
        
        bgStatusBarang.setBackground(bg_color);
        bgStatusBarang.setBounds(labelStatusBarang.getBounds().x,labelStatusBarang.getBounds().y+25,panjang_field,1);          //Tinggi 1
        getContentPane().add(bgStatusBarang);
// Field Status Barang End

// Field Deskripsi
        label_deskripsi.setFont(label_font);
        label_deskripsi.setForeground(label_color);
        label_deskripsi.setText("Deskripsi");
        getContentPane().add(label_deskripsi);
        label_deskripsi.setBounds(field_bound_x, labelStatusBarang.getBounds().y+50, panjang_field, 30);

        field_deskripsi.setBackground(field_BG);
        field_deskripsi.setForeground(field_FG);
        field_deskripsi.setFont(field_font);
        field_deskripsi.setLineWrap(true);
        field_deskripsi.setText(deskripsiBarang);
        field_deskripsi.setWrapStyleWord(true);
        field_deskripsi.setRows(5);
        field_deskripsi.setBorder(BorderFactory.createLineBorder(Color.white));
        field_deskripsi.setBounds(area_bound_x, label_deskripsi.getBounds().y+30, screenheight/2, 100);
        getContentPane().add(field_deskripsi);
// Field Deskripsi
        
// Field Status Barang Start
        labelKontakBarang.setForeground(label_color);
        labelKontakBarang.setText("Kontak : "+kontakBarang);
        labelKontakBarang.setFont(field_font);
        getContentPane().add(labelKontakBarang);
        labelKontakBarang.setBounds(area_bound_x, field_deskripsi.getBounds().y+120, screenheight/2, 30);
        
        bgKontakBarang.setBackground(bg_color);
        bgKontakBarang.setBounds(labelKontakBarang.getBounds().x,labelKontakBarang.getBounds().y+25,screenheight/2,1);          //Tinggi 1
        getContentPane().add(bgKontakBarang);
// Field Status Barang End

// Background 
        bg_registrasi.setBounds(0, 0,getMinimumSize().width, getMinimumSize().height);
        bg_registrasi.setBackground(new Color(0, 22, 50));
        getContentPane().add(bg_registrasi);
        
// Background 
        pack();
        setLocationRelativeTo(null);
    }
}