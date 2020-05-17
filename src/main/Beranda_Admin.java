package main;

import daftarBarang.DaftarBarang;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.*;
import javax.swing.*;


public class Beranda_Admin extends javax.swing.JFrame {
    
    private JPanel Background,panel_ListBarang;
    
//    private JLabel tbl_Tutup;
    private JLabel Judul_label;
    private JLabel status_menu;
    private JPanel Tombol_logout, Tombol_Kehilanganku,Tombol_Kutemukan,Tombol_Tambah;
    private JLabel label_logout, label_user, label_Kehilanganku,label_Kutemukan,label_Tambah_Barang,tbl_Tutup;
    public String username="";
    public String id_pengguna="";
    public String query="SELECT * FROM barang INNER JOIN pengguna WHERE barang.id_pengguna = pengguna.id_pengguna order by waktu desc";
    daftarBarang.DaftarBarang daftar;
    
    public Beranda_Admin() {
        initComponents();
    }
    
    public Beranda_Admin(String user) {
        this.username=user;
        initComponents();
    }
    
    
    public Beranda_Admin(String username,String id_prngguna) {
        this.username=username;
        this.id_pengguna=id_prngguna;
        initComponents();
    }
    
    private void initComponents() {

        tbl_Tutup = new JLabel();
        Judul_label = new JLabel();
        status_menu = new JLabel();
        panel_ListBarang = new JPanel();
        Tombol_logout = new JPanel();          label_logout = new JLabel();
        label_user = new JLabel();
        Tombol_Kehilanganku = new JPanel();     label_Kehilanganku = new JLabel();
        Tombol_Kutemukan = new JPanel();        label_Kutemukan = new JLabel();
        Tombol_Tambah = new JPanel();           label_Tambah_Barang = new JLabel();

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
//        setSize(new java.awt.Dimension(1080, 720));
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);


        tbl_Tutup.setIcon(new ImageIcon(getClass().getResource("/image/close.png"))); //tombol tombol_tutup
        tbl_Tutup.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(tbl_Tutup);
        tbl_Tutup.setBounds(1040, 0, 39, 39);
        
        //Judul dan Logo
        Judul_label.setIcon(new ImageIcon(getClass().getResource("/image/logo_kecil.png")));
        Judul_label.setText("Logo Aplikasi");
        getContentPane().add(Judul_label);
        Judul_label.setBounds(20, 0, 105, 128);
        
        label_user.setText(username);
        label_user.setForeground(fg_label);
        label_user.setBounds(290, 0, 105, 28);
        getContentPane().add(label_user);
        
//Panel Daftar
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
//Panel Daftar
        
//        Tombol_beranda.setBackground(bg_tombol);
        Tombol_logout.setBackground(bg_tombol);
        Tombol_logout.setForeground(fg_tombol);
        label_logout.setText("LogOut");
        Tombol_logout.add(label_logout);
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
        status_menu.setText(username);
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
                close1MouseClicked(evt);
            }
        });
        
        Tombol_logout.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
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
        Login_User A = new Login_User();
    }                                  

    private void close1MouseClicked(java.awt.event.MouseEvent evt) {
// TODO add your handling code here:
        Login_User A = new Login_User();
        this.dispose();
    }                                   
    
    private void Tombol_berandaAction() {
        this.username=id_pengguna;
    }
    
    private void Tombol_KehilangankuAction(ActionEvent evt){
        this.query="SELECT * FROM barang JOIN pengguna WHERE barang.id_pengguna = pengguna.id_pengguna AND barang.id_pengguna="+this.username+" order by waktu desc";
    }
    
    private void Tombol_KutemukanAction(ActionEvent evt) {
        System.out.println("Belom Di Isi");
    }
    
    private void Tombol_TambahAction(ActionEvent evt) {
        new Tambah_Barang().setVisible(true);
    }
    //Fungsi Aksi
    

    /*
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Beranda_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        
        /* Membuat dan Menampilkan Form */
        java.awt.EventQueue.invokeLater(new RunnableImpl());
    }   

    private static class RunnableImpl implements Runnable {

        public RunnableImpl() {
        }

        @Override
        public void run() {
            new Beranda_Admin().setVisible(true);
        }
    }
}
