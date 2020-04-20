package main;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Beranda_User extends javax.swing.JFrame {
    
    private JPanel jPanel_daftar;
    private JLabel Background,tombol_tutup;
    private JLabel Logo_itera,Judul_label,KB_label,LI_label;
    private JLabel status_menu;
    private JButton Tombol_beranda,Tombol_terbaru,Tombol_Kehilanganku,Tombol_Kutemukan,Tambah_Barang;
    daftarBarang.daftar daftar;
    public String user="Beranda";
   
    String setuser(String users){
        this.user="ganti";
        return user;
    }
    
    public Beranda_User() {
        initComponents();
        
        
    }

    private void initComponents() {

        tombol_tutup = new JLabel();
        Judul_label = new JLabel();
        status_menu = new JLabel();
        LI_label = new JLabel();
        KB_label = new JLabel();
        Logo_itera = new JLabel();
        jPanel_daftar = new JPanel();
        Tombol_beranda = new JButton();
        Tombol_terbaru = new JButton();
        Tombol_Kehilanganku = new JButton();
        Tombol_Kutemukan = new JButton();
        Tambah_Barang = new JButton();
        daftar = new daftarBarang.daftar();
        Background = new JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1080, 720));
        setMaximumSize(getMinimumSize());
        setUndecorated(true);
        setPreferredSize(getMaximumSize());
        setSize(new java.awt.Dimension(1080, 720));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        tombol_tutup.setIcon(new ImageIcon(getClass().getResource("/lakban/image/close.png"))); //tombol tombol_tutup
        tombol_tutup.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        tombol_tutup.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                close1MouseClicked(evt);
            }
        });
        getContentPane().add(tombol_tutup);
        tombol_tutup.setBounds(1040, 0, 39, 39);
        
        //Judul dan Logo
        Judul_label.setIcon(new ImageIcon(getClass().getResource("/lakban/image/lakban_logo_kecil.png")));
        Judul_label.setText("jLabel1");
        getContentPane().add(Judul_label);
        Judul_label.setBounds(20, 0, 105, 128);
        
        LI_label.setForeground(new java.awt.Color(255, 255, 255));
        LI_label.setText("Layanan Informasi");
        getContentPane().add(LI_label);
        LI_label.setBounds(Judul_label.getBounds().x+110, Judul_label.getBounds().y+20, 110, 14);

        KB_label.setForeground(new java.awt.Color(255, 255, 255));
        KB_label.setText("Kehilangan Barang");
        getContentPane().add(KB_label);
        KB_label.setBounds(LI_label.getBounds().x, LI_label.getBounds().y+14, LI_label.getBounds().width, LI_label.getBounds().height);
        
        
        
        //Tombol tombol
        
        Tombol_beranda.setForeground(new Color(0, 0, 255));
        Tombol_beranda.setText("Beranda");
        Tombol_beranda.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Tombol_berandaAction(evt);
        }});
        Tombol_beranda.setBounds(170, 60, 120, 30);
        getContentPane().add(Tombol_beranda);
        
        Tombol_terbaru.setForeground(Tombol_beranda.getForeground());
        Tombol_terbaru.setText("Terbaru");
        Tombol_terbaru.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Tombol_TerbaruAction(evt);
            }
        });
        Tombol_terbaru.setBounds(Tombol_beranda.getBounds().x, Tombol_beranda.getBounds().y+35, Tombol_beranda.getBounds().width,  Tombol_beranda.getBounds().height);
        getContentPane().add(Tombol_terbaru);
        
        Tombol_Kehilanganku.setForeground(Tombol_beranda.getForeground());
        Tombol_Kehilanganku.setText("Kehilanganku");
        Tombol_Kehilanganku.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Tombol_KehilangankuAction(evt);
            }
        });
        Tombol_Kehilanganku.setBounds(Tombol_beranda.getBounds().x, Tombol_terbaru.getBounds().y+35, Tombol_beranda.getBounds().width,  Tombol_beranda.getBounds().height);
        getContentPane().add(Tombol_Kehilanganku);
        
        Tombol_Kutemukan.setForeground(Tombol_beranda.getForeground());
        Tombol_Kutemukan.setText("Kutemukan");
        Tombol_Kutemukan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Tombol_KutemukanAction(evt);
            }
        });
        Tombol_Kutemukan.setBounds(Tombol_beranda.getBounds().x, Tombol_Kehilanganku.getBounds().y+35, Tombol_beranda.getBounds().width,  Tombol_beranda.getBounds().height);
        getContentPane().add(Tombol_Kutemukan);
        
        
        Tambah_Barang.setForeground(Tombol_beranda.getForeground());
        Tambah_Barang.setText("Tambah Barang");
        Tambah_Barang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    Tambah_BarangAction(evt);
                } catch (SQLException ex) {
                    Logger.getLogger(Beranda_User.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        Tambah_Barang.setBounds(Tombol_beranda.getBounds().x, Tombol_Kutemukan.getBounds().y+35, Tombol_beranda.getBounds().width,  Tombol_beranda.getBounds().height);
        getContentPane().add(Tambah_Barang);
        
        
    //Tombol tombol
        
    //Panel Daftar
        javax.swing.GroupLayout Layout_jPanel_Daftar = new javax.swing.GroupLayout(jPanel_daftar);
        jPanel_daftar.setLayout(Layout_jPanel_Daftar);
        Layout_jPanel_Daftar.setHorizontalGroup(Layout_jPanel_Daftar.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(daftar)
        );
        Layout_jPanel_Daftar.setVerticalGroup(Layout_jPanel_Daftar.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(daftar)
        );
        getContentPane().add(jPanel_daftar);
        jPanel_daftar.setBounds(290, 50, 740, 640);
    //Panel Daftar
    
    //Status Menu
        status_menu.setFont(new java.awt.Font("Agency FB", 1, 30));
        status_menu.setForeground(Judul_label.getForeground());
        status_menu.setText(user);
        getContentPane().add(status_menu);
        status_menu.setBounds(jPanel_daftar.getBounds().x,jPanel_daftar.getBounds().y-35,100,Judul_label.getBounds().height);
        
    //Latar Belakang
        Background.setFont(new java.awt.Font("Agency FB", 1, 50)); // NOI18N
        Background.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lakban/image/bg.jpg")));
        getContentPane().add(Background);
        Background.setBounds(0, 0, 1080, 720);
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Beranda_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Beranda_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Beranda_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Beranda_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        
        /* Membuat dan Menampilkan Form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Beranda_User().setVisible(true);
            }
        });
    }   
}
