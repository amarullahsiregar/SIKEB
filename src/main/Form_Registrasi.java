package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Form_Registrasi extends javax.swing.JFrame {

    byte[] person_image=null;
    public Form_Registrasi() {
        initComponents();
    }

    
    
    private void initComponents() {

        close = new javax.swing.JLabel();
        judul = new javax.swing.JLabel();
        namaform = new javax.swing.JTextField();
        identitasform = new javax.swing.JTextField();
        passwordform = new javax.swing.JTextField();
        namaLabel = new javax.swing.JLabel();
        Daftar = new javax.swing.JButton();
        identitas = new javax.swing.JLabel();
        password = new javax.swing.JLabel();
        login = new javax.swing.JButton();
        kontakform = new javax.swing.JTextField();
        kontakLabel = new javax.swing.JLabel();
        panelFoto = new javax.swing.JPanel();
        juploadid = new javax.swing.JLabel();
        pilih = new javax.swing.JButton();
        tanya = new javax.swing.JLabel();
        bgpanel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(550, 550));
        setMinimumSize(new java.awt.Dimension(550, 550));
        setUndecorated(true);
        getContentPane().setLayout(null);

        close.setForeground(new java.awt.Color(101, 150, 200));
        close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lakban/image/close.png"))); // NOI18N
        close.setText("jLabel4");
        close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        close.setMaximumSize(new java.awt.Dimension(39, 39));
        close.setMinimumSize(new java.awt.Dimension(39, 39));
        close.setPreferredSize(new java.awt.Dimension(39, 39));
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
        });
        getContentPane().add(close);
        close.setBounds(511, 0, 39, 39);

        judul.setFont(new java.awt.Font("Agency FB", 1, 35)); // NOI18N
        judul.setForeground(new java.awt.Color(255, 255, 255));
        judul.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        judul.setLabelFor(bgpanel);
        judul.setText("Form Registrasi");
        getContentPane().add(judul);
        judul.setBounds(180, 30, 200, 60);
        getContentPane().add(namaform);
        namaform.setBounds(120, 110, 410, 30);
        getContentPane().add(identitasform);
        identitasform.setBounds(120, 160, 410, 30);

        passwordform.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordformActionPerformed(evt);
            }
        });
        getContentPane().add(passwordform);
        passwordform.setBounds(120, 210, 410, 30);

        namaLabel.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        namaLabel.setForeground(new java.awt.Color(101, 200, 248));
        namaLabel.setText("Nama Lengkap :");
        getContentPane().add(namaLabel);
        namaLabel.setBounds(11, 113, 100, 30);

        Daftar.setBackground(new java.awt.Color(100, 100, 100));
        Daftar.setFont(new java.awt.Font("Agency FB", 1, 22)); // NOI18N
        Daftar.setForeground(new java.awt.Color(10, 20, 255));
        Daftar.setText("Daftar");
        Daftar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DaftarActionPerformed(evt);
            }
        });
        getContentPane().add(Daftar);
        Daftar.setBounds(390, 350, 80, 50);

        identitas.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        identitas.setForeground(new java.awt.Color(101, 200, 255));
        identitas.setText("No. Identitas     :");
        getContentPane().add(identitas);
        identitas.setBounds(11, 160, 100, 30);

        password.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        password.setForeground(new java.awt.Color(101, 200, 255));
        password.setText("Password       :");
        getContentPane().add(password);
        password.setBounds(10, 210, 100, 30);

        login.setText("Login");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        getContentPane().add(login);
        login.setBounds(393, 500, 80, 23);
        getContentPane().add(kontakform);
        kontakform.setBounds(120, 260, 410, 30);

        kontakLabel.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        kontakLabel.setForeground(new java.awt.Color(101, 200, 255));
        kontakLabel.setText("Kontak            :");
        getContentPane().add(kontakLabel);
        kontakLabel.setBounds(10, 260, 100, 30);
        getContentPane().add(panelFoto);
        panelFoto.setBounds(140, 310, 190, 130);

        juploadid.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        juploadid.setForeground(new java.awt.Color(101, 200, 255));
        juploadid.setText("Upload Foto Identitas");
        getContentPane().add(juploadid);
        juploadid.setBounds(10, 310, 130, 20);

        pilih.setText("Pilih");
        getContentPane().add(pilih);
        pilih.setBounds(140, 450, 73, 23);

        tanya.setForeground(new java.awt.Color(101, 200, 255));
        tanya.setText("sudah punya akun ?");
        getContentPane().add(tanya);
        tanya.setBounds(280, 500, 120, 20);

        bgpanel.setBackground(new java.awt.Color(101, 200, 248));
        bgpanel.setForeground(new java.awt.Color(101, 200, 248));
        bgpanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lakban/image/bg.jpg"))); // NOI18N
        bgpanel.setMaximumSize(new java.awt.Dimension(550, 550));
        bgpanel.setMinimumSize(new java.awt.Dimension(550, 550));
        getContentPane().add(bgpanel);
        bgpanel.setBounds(0, 0, 550, 550);

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
                konek.createStatement().executeUpdate("insert into pengguna values"+"('"+identitasform.getText()+"','"+passwordform.getText()+"','"+namaform.getText()+"','"+kontakform.getText()+"','0')");
                JOptionPane.showMessageDialog(rootPane, "selesai mendaftar ! \n tunggu konfirmasi dari admin ke kontak yang anda cantumkan ");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "Masukkan Nomor Identitas dengan angka !");
            }
            
            //load_table();
            //kosong();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Masalah pada database !");
        }
    }                                      

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {                                      
        // TODO add your handling code here:
        Login_User A = new Login_User();
        A.setVisible(true);
        this.dispose();
    }                                     

    private void passwordformActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

    /**
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
            java.util.logging.Logger.getLogger(Tambah_Barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tambah_Barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tambah_Barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tambah_Barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_Registrasi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton Daftar;
    private javax.swing.JLabel bgpanel;
    private javax.swing.JLabel close;
    private javax.swing.JLabel identitas;
    private javax.swing.JTextField identitasform;
    private javax.swing.JLabel kontakLabel;
    private javax.swing.JLabel tanya;
    private javax.swing.JPanel panelFoto;
    private javax.swing.JLabel judul;
    private javax.swing.JLabel juploadid;
    private javax.swing.JTextField kontakform;
    private javax.swing.JButton login;
    private javax.swing.JLabel namaLabel;
    private javax.swing.JTextField namaform;
    private javax.swing.JLabel password;
    private javax.swing.JTextField passwordform;
    private javax.swing.JButton pilih;
    // End of variables declaration                   

}
