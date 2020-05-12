package main;

import java.awt.Color;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Beranda_Admin extends javax.swing.JFrame {
    
    private JPanel Background,panel_ListBarang;
    private JLabel tbl_Tutup;
    private JLabel Judul_label;
    private JLabel status_menu;
    private JButton Tombol_beranda,Tombol_terbaru,Tombol_Kehilanganku,Tombol_Kutemukan,Tambah_Barang;
    daftarBarang.daftar daftar;
    public String user="Beranda";
   
    String setuser(String users){
        this.user="ganti";
        return user;
    }
    
    public Beranda_Admin() {
        initComponents();
        
        
    }

    private void initComponents() {

        tbl_Tutup = new JLabel();
        Judul_label = new JLabel();
        status_menu = new JLabel();
        panel_ListBarang = new JPanel();
        Tombol_beranda = new JButton();
        Tombol_terbaru = new JButton();
        Tombol_Kehilanganku = new JButton();
        Tombol_Kutemukan = new JButton();
        Tambah_Barang = new JButton();
        daftar = new daftarBarang.daftar();
        Background = new JPanel();
        GraphicsDevice ScreenDim = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int screenwidth = ScreenDim.getDisplayMode().getWidth();
        int screenheight = ScreenDim.getDisplayMode().getHeight();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1080, 720));
        setMaximumSize(getMinimumSize());
        //setUndecorated(true);
        setBackground(Color.yellow);
        setPreferredSize(getMaximumSize());
        setSize(new java.awt.Dimension(1080, 720));
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

/*
        tbl_Tutup.setIcon(new ImageIcon(getClass().getResource("/image/close.png"))); //tombol tombol_tutup
        tbl_Tutup.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        tbl_Tutup.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                close1MouseClicked(evt);
            }
        });
        getContentPane().add(tbl_Tutup);
        tbl_Tutup.setBounds(1040, 0, 39, 39);                   */
        
        //Judul dan Logo
        Judul_label.setIcon(new ImageIcon(getClass().getResource("/image/lakban_aplikasi_kecil.png")));
        Judul_label.setText("jLabel1");
        getContentPane().add(Judul_label);
        Judul_label.setBounds(20, 0, 105, 128);
        
    //Panel Daftar
        javax.swing.GroupLayout Layout_jPanel_Daftar = new javax.swing.GroupLayout(panel_ListBarang);
        panel_ListBarang.setLayout(Layout_jPanel_Daftar);
        Layout_jPanel_Daftar.setHorizontalGroup(Layout_jPanel_Daftar.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(daftar)
        );
        Layout_jPanel_Daftar.setVerticalGroup(Layout_jPanel_Daftar.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(daftar)
        );
        getContentPane().add(panel_ListBarang);
        panel_ListBarang.setBounds(290, 50, 740, 640);
    //Panel Daftar
    
        //Tombol tombol
        Tombol_beranda.setForeground(new Color(0, 0, 255));
        Tombol_beranda.setText("Beranda");
        Tombol_beranda.addActionListener(this::Tombol_berandaAction);
        Tombol_beranda.setBounds(170, panel_ListBarang.getBounds().y, 120, 30);
        getContentPane().add(Tombol_beranda);
        
        
        Tombol_terbaru.setForeground(Tombol_beranda.getForeground());
        Tombol_terbaru.setText("Terbaru");
        Tombol_terbaru.addActionListener(new ActionListenerImpl());
        Tombol_terbaru.setBounds(Tombol_beranda.getBounds().x, Tombol_beranda.getBounds().y+35, Tombol_beranda.getBounds().width,  Tombol_beranda.getBounds().height);
        getContentPane().add(Tombol_terbaru);
        
        Tombol_Kehilanganku.setForeground(Tombol_beranda.getForeground());
        Tombol_Kehilanganku.setText("Kehilanganku");
        Tombol_Kehilanganku.addActionListener(this::Tombol_KehilangankuAction);
        Tombol_Kehilanganku.setBounds(Tombol_beranda.getBounds().x, Tombol_terbaru.getBounds().y+35, Tombol_beranda.getBounds().width,  Tombol_beranda.getBounds().height);
        getContentPane().add(Tombol_Kehilanganku);
        
        Tombol_Kutemukan.setForeground(Tombol_beranda.getForeground());
        Tombol_Kutemukan.setText("Kutemukan");
        Tombol_Kutemukan.addActionListener(this::Tombol_KutemukanAction);
        Tombol_Kutemukan.setBounds(Tombol_beranda.getBounds().x, Tombol_Kehilanganku.getBounds().y+35, Tombol_beranda.getBounds().width,  Tombol_beranda.getBounds().height);
        getContentPane().add(Tombol_Kutemukan);
        
        Tambah_Barang.setForeground(Tombol_beranda.getForeground());
        Tambah_Barang.setText("Tambah Barang");
        Tambah_Barang.addActionListener((ActionEvent evt) -> {
            try {
                Tambah_BarangAction(evt);
            } catch (SQLException ex) {
                Logger.getLogger(Beranda_Admin.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        Tambah_Barang.setBounds(Tombol_beranda.getBounds().x, Tombol_Kutemukan.getBounds().y+35, Tombol_beranda.getBounds().width,  Tombol_beranda.getBounds().height);
        getContentPane().add(Tambah_Barang);
        
    //Tombol tombol
        
    //Status Menu
        status_menu.setFont(new java.awt.Font("Agency FB", 1, 30));
        status_menu.setForeground(Judul_label.getForeground());
        status_menu.setText(user);
        getContentPane().add(status_menu);
        status_menu.setBounds(panel_ListBarang.getBounds().x,panel_ListBarang.getBounds().y-35,100,Judul_label.getBounds().height);
        
    //Latar Belakang
        Background.setFont(new java.awt.Font("Agency FB", 1, 50)); // NOI18N
        
        Background.setBackground(new Color(0, 22, 38));
        getContentPane().add(Background);
        Background.setBounds(0, 0, screenwidth, screenheight);
    //Latar Belakang
        
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
        this.dispose();
    }                                   
    
    private void Tombol_berandaAction(java.awt.event.ActionEvent evt) {                                      
        this.daftar.ambil_tabel();
        this.status_menu.setText("Beranda");
    }
    private void Tombol_TerbaruAction(java.awt.event.ActionEvent evt) {                                      
        this.daftar.ambil_terbaru();
        this.status_menu.setText("Terbaru !");
    }
    
    private void Tambah_BarangAction(ActionEvent evt) throws SQLException {
        new Tambah_Barang();
    }
    private void Tombol_KehilangankuAction(ActionEvent evt){
        // TODO add your handling code here:
    
    }
    
    private void Tombol_KutemukanAction(ActionEvent evt) {
        this.dispose();
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

    private class ActionListenerImpl implements ActionListener {

        public ActionListenerImpl() {
        }

        @Override
        public void actionPerformed(ActionEvent evt) {
            Tombol_TerbaruAction(evt);
        }
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
