package main;

import daftarBarang.DaftarBarang;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.*;
import javax.swing.*;


public class Beranda_Admin extends javax.swing.JFrame {
    
    private JLabel Judul_label, status_menu;
    private JLabel label_detail, label_username, label_Kehilanganku,label_Kutemukan,label_Tambah_Barang,tbl_Tutup;
    private JPanel Tombol_logout, Tombol_Kehilanganku,Tombol_Kutemukan,Tombol_Tambah,panel_ListBarang;
    private JPanel Background;
    
    
    public String nama_pengguna="";
    public String id_pengguna="0";
    public String query="SELECT * FROM barang INNER JOIN pengguna WHERE barang.id_pengguna = pengguna.id_pengguna order by waktu desc";
    daftarBarang.DaftarBarang daftar;
    
    public Beranda_Admin() {
        initComponents();
    }
    
    public Beranda_Admin(String user) {
        this.nama_pengguna=user;
        initComponents();
    }
    
    
    public Beranda_Admin(String user,String id_prngguna) {
        this.nama_pengguna=user;
        this.id_pengguna=id_prngguna;
        initComponents();
    }
    
    private void initComponents() {

        tbl_Tutup = new JLabel();
        Judul_label = new JLabel();
        status_menu = new JLabel();
        Tombol_logout = new JPanel();          label_detail = new JLabel();
        label_username = new JLabel();
        
        Tombol_Kehilanganku = new JPanel();     label_Kehilanganku = new JLabel();
        Tombol_Kutemukan = new JPanel();        label_Kutemukan = new JLabel();
        Tombol_Tambah = new JPanel();           label_Tambah_Barang = new JLabel();

        panel_ListBarang = new JPanel();
        Background = new JPanel();
        
        GraphicsDevice ScreenDim = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int screenwidth = ScreenDim.getDisplayMode().getWidth();
        int screenheight = ScreenDim.getDisplayMode().getHeight();
        int lebar_tombol = 290;
        int tinggi_tombol = 44;
        Color bg_tombol = new Color(0, 74, 128);
        Color fg_tombol = new Color(0, 0, 255);
        Color fg_label = new Color(255, 255, 255);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(screenwidth/10*8, screenwidth/2));
        setMaximumSize(getMinimumSize());
        setUndecorated(true);
        setBackground(Color.yellow);
        setPreferredSize(getMaximumSize());
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);
        
        tbl_Tutup.setIcon(new ImageIcon(getClass().getResource("/image/close.png")));
        tbl_Tutup.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(tbl_Tutup);
        tbl_Tutup.setBounds(1040, 0, 39, 39);
        
//Judul dan Logo
        Judul_label.setIcon(new ImageIcon(getClass().getResource("/image/logo_kecil.png")));
        Judul_label.setText("Logo Aplikasi");
        getContentPane().add(Judul_label);
        Judul_label.setBounds(20, 0, 105, 128);
        
        label_username.setText("Admin : "+nama_pengguna);
        label_username.setForeground(fg_label);
        label_username.setBounds(290, 0, 105, 28);
        getContentPane().add(label_username);
        
        
//Panel Daftar Barang
        daftar = new DaftarBarang(query);
        javax.swing.GroupLayout Layout_jPanel_Daftar = new javax.swing.GroupLayout(panel_ListBarang);
        panel_ListBarang.setLayout(Layout_jPanel_Daftar);
        Layout_jPanel_Daftar.setHorizontalGroup(Layout_jPanel_Daftar.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(daftar)
        );
        Layout_jPanel_Daftar.setVerticalGroup(Layout_jPanel_Daftar.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(daftar)
        );
        getContentPane().add(panel_ListBarang);
        panel_ListBarang.setBounds(290, 50, 740, screenwidth/12*5);
        
        
//        Tombol_beranda.setBackground(bg_tombol);
        Tombol_logout.setBackground(bg_tombol);
        Tombol_logout.setForeground(fg_tombol);
        label_detail.setText("Logout");
        Tombol_logout.add(label_detail);
        Tombol_logout.setBorder(BorderFactory.createLineBorder(new Color(0, 22, 38)));
        Tombol_logout.setBounds(0, Judul_label.getBounds().y+Judul_label.getBounds().height, lebar_tombol, tinggi_tombol);
        getContentPane().add(Tombol_logout);
        
        Tombol_Kehilanganku.setBackground(bg_tombol);
        Tombol_Kehilanganku.setForeground(fg_tombol);
        label_Kehilanganku.setText("Kehilanganku");
        Tombol_Kehilanganku.add(label_Kehilanganku);
        Tombol_Kehilanganku.setBorder(BorderFactory.createLineBorder(new Color(0, 22, 38)));
        Tombol_Kehilanganku.setBounds(Tombol_logout.getBounds().x, Tombol_logout.getBounds().y+tinggi_tombol, lebar_tombol, tinggi_tombol);
//        getContentPane().add(Tombol_Kehilanganku);
        
        Tombol_Kutemukan.setBackground(bg_tombol);
        Tombol_Kutemukan.setForeground(fg_tombol);
        Tombol_Kutemukan.setForeground(fg_tombol);
        label_Kutemukan.setText("Kutemukan");
        Tombol_Kutemukan.add(label_Kutemukan);
        Tombol_Kutemukan.setBorder(BorderFactory.createLineBorder(new Color(0, 22, 38)));
        Tombol_Kutemukan.setBounds(Tombol_logout.getBounds().x, Tombol_Kehilanganku.getBounds().y+tinggi_tombol, lebar_tombol, tinggi_tombol);
//        getContentPane().add(Tombol_Kutemukan);
        
        Tombol_Tambah.setBackground(bg_tombol);
        Tombol_Tambah.setForeground(fg_tombol);
        Tombol_Tambah.setForeground(fg_tombol);
        label_Tambah_Barang.setText("Tambah Barang");
        Tombol_Tambah.add(label_Tambah_Barang);
        Tombol_Tambah.setBorder(BorderFactory.createLineBorder(new Color(0, 22, 38)));
        Tombol_Tambah.setBounds(Tombol_logout.getBounds().x, Tombol_Kutemukan.getBounds().y+tinggi_tombol, lebar_tombol, tinggi_tombol);
        getContentPane().add(Tombol_Tambah);
//Tombol tombol End
        
//Status Menu Start
        status_menu.setFont(new java.awt.Font("Agency FB", 1, 30));
        status_menu.setForeground(Judul_label.getForeground());
        status_menu.setText(nama_pengguna);
        getContentPane().add(status_menu);
        status_menu.setBounds(panel_ListBarang.getBounds().x,panel_ListBarang.getBounds().y-35,100,Judul_label.getBounds().height);
//Status Menu End

//Latar Belakang
        Background.setFont(new java.awt.Font("Agency FB", 1, 50));
        Background.setBackground(new Color(0, 22, 38));
        getContentPane().add(Background);
        Background.setBounds(0, 0, screenwidth, screenheight);
//Latar Belakang

//Mouse Listener
        tbl_Tutup.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                Login A = new Login();
                dispose();
            }
        });
        
        Tombol_logout.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                new Login().setVisible(true);
                dispose();
            }            
        });

        Tombol_Kehilanganku.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                Tombol_berandaAction();
            }            
        });

        Tombol_Kutemukan.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                System.out.println("Belom Di Isi");
            }            
        });
        
        Tombol_Tambah.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                new Tambah_Barang(id_pengguna).setVisible(true);
            }            
        });
//Mouse Listener

        pack();
        setLocationRelativeTo(null);
    }
    
//Fungsi Aksi
    
    private void formWindowClosing(java.awt.event.WindowEvent evt) {
// TODO add your handling code here:
        Login A = new Login();
    }
    
    
    private void Tombol_berandaAction() {
        this.nama_pengguna=id_pengguna;
    }
}
