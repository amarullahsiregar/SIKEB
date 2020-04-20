package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

/*
 * @author Siregar
 */

public class Login_User  extends javax.swing.JFrame {
    
    // Variables declaration - do not modify                     
    private javax.swing.JButton adminButton;
    private JLabel logo,tutupButton,usernameBg,passwordBg,usernamelabel,passwordlabel;
    private javax.swing.JButton registrasi;
    private javax.swing.JPasswordField passwordForm;
    private javax.swing.JTextField usernameForm;
    private JButton loginButton;
    private javax.swing.JPanel bg;
    String idPengguna;
    // End of variables declaration
    
    public Login_User() {
        initComponents();
    }

    private void initComponents() {
        
        tutupButton = new javax.swing.JLabel();
        adminButton = new JButton();
        loginButton = new JButton();
        registrasi = new JButton();
        logo = new JLabel();
        usernamelabel = new javax.swing.JLabel();
        passwordlabel = new javax.swing.JLabel();
        usernameForm = new javax.swing.JTextField();
        passwordForm = new javax.swing.JPasswordField();
        usernameBg = new javax.swing.JLabel();
        passwordBg = new javax.swing.JLabel();
        bg = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(550, 450));
        setSize(new java.awt.Dimension(550, 450));
        getContentPane().setLayout(null);
        
        adminButton.setFont(new java.awt.Font("Agency FB", 1, 15));
        adminButton.setText("Admin");
        adminButton.setBackground(new Color(255, 255, 255));
        adminButton.setForeground(new Color(0, 22, 38));
        adminButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        adminButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminbuttonActionPerformed(evt);
            }
        });
        getContentPane().add(adminButton);
        adminButton.setBounds(450, 410, 90, 30);
        
        loginButton.setFont(new java.awt.Font("Agency FB", 1, 15));
        loginButton.setText("Login");
        loginButton.setBackground(new Color(255, 255, 255));
        loginButton.setForeground(new Color(0, 22, 38));
        loginButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        getContentPane().add(loginButton);
        loginButton.setBounds(230, 320, 90, 30);

        registrasi.setIcon(new ImageIcon(getClass().getResource("/lakban/image/daftar.png"))); // NOI18N
        registrasi.setOpaque(false);
        registrasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                daftarActionPerformed(evt);
            }
        });
        getContentPane().add(registrasi);
        registrasi.setBounds(20, 400, 112, 40);
        
        logo.setIcon(new ImageIcon(getClass().getResource("/lakban/image/lakban_logo.png")));
        logo.setOpaque(false);
        getContentPane().add(logo);
        logo.setBounds(180,40,194,91);
        
        usernamelabel.setFont(new Font("Letter Gothic Std", 1, 20));
        usernamelabel.setForeground(new Color(0, 100, 172));
        usernamelabel.setText("Id pengguna");
        usernamelabel.setBounds(210, 120, 150, 35);
        getContentPane().add(usernamelabel);
        
        passwordlabel.setFont(usernamelabel.getFont());
        passwordlabel.setForeground(usernamelabel.getForeground());
        passwordlabel.setText("password");
        passwordlabel.setBounds( usernamelabel.getBounds().x+20, 220, usernamelabel.getBounds().width, usernamelabel.getBounds().height);
        getContentPane().add(passwordlabel);
        
        usernameForm.setBackground(new Color(115, 135, 155));
        usernameForm.setFont(new Font("Agency FB", 1, 20)); // NOI18N
        usernameForm.setBorder(null);
        usernameForm.setCaretColor(new java.awt.Color(255, 255, 255));
        usernameForm.setOpaque(false);
        usernameForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtUsernameActionPerformed(evt);
            }
        });
        usernameForm.setBounds(130, 158, 280, 30);
        getContentPane().add(usernameForm);
        
        usernameBg.setIcon(new ImageIcon(getClass().getResource("/lakban/image/loginform.png")));
        getContentPane().add(usernameBg);
        usernameBg.setBounds(115,150,322,47);
        
        passwordForm.setBackground(usernameForm.getBackground());
        passwordForm.setFont(usernameForm.getFont());
        passwordForm.setBorder(null);
        passwordForm.setOpaque(false);
        passwordForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordActionPerformed(evt);
            }
        });
        getContentPane().add(passwordForm);
        passwordForm.setBounds(usernameForm.getBounds().x, usernameForm.getBounds().y+100, usernameForm.getBounds().width, usernameForm.getBounds().height);
        
        passwordBg.setIcon(usernameBg.getIcon());
        getContentPane().add(passwordBg);
        passwordBg.setBounds(115,250,322,47);
        
        tutupButton.setIcon(new ImageIcon(getClass().getResource("/lakban/image/close.png")));
        tutupButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tutupButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
        });
        getContentPane().add(tutupButton);
        tutupButton.setBounds(510, 0, 39, 39);
        
        bg.setBackground(new Color(0, 22, 38));
        bg.setBounds(0, 0, 550, 450);
        getContentPane().add(bg);


        pack();
        setLocationRelativeTo(null);
    }

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {
        this.dispose();
    }                                  


    private void jTxtUsernameActionPerformed(java.awt.event.ActionEvent evt) {
    }                                            

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {                                      
        try {           
            koneksidb konek1 = new koneksidb();
            koneksidb konekuser = new koneksidb();
    //        Connection konek = DriverManager.getConnection("jdbc:mysql://localhost/lakban","root","");
    //        Connection konekuser = DriverManager.getConnection("jdbc:mysql://localhost/lakban","root","");
            ResultSet benar = konek1.koneksi.createStatement().executeQuery("select * from pengguna where id_pengguna='"+usernameForm.getText()+"'and password='"+String.valueOf(passwordForm.getText())+"' and aktif=1 ");
            ResultSet usrbnr = konekuser.koneksi.createStatement().executeQuery("select * from pengguna where id_pengguna='"+usernameForm.getText()+"'");
            if(benar.next()){
                idPengguna = usernameForm.getText();
                passwordForm.setText(null);
                usernameForm.setText(null);
                Beranda_User masuk;
                masuk = new Beranda_User();
                masuk.setuser(idPengguna);
                masuk.setVisible(true);
                this.dispose();
            }else{
                if(usrbnr.next()){
                    JOptionPane.showMessageDialog(null, "Periksa kembali password anda !","Login gagal !",JOptionPane.ERROR_MESSAGE);
                    
                }else{
                JOptionPane.showMessageDialog(rootPane, "Masukkan Username dan Password yang benar ! ");
                    
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login_User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }                                     

    private void adminbuttonActionPerformed(java.awt.event.ActionEvent evt) {
        Login_Admin B = new Login_Admin();
            B.setVisible(true);
            this.dispose();
    }                                           

    private void jPasswordActionPerformed(java.awt.event.ActionEvent evt) {
    }                                         

    private void daftarActionPerformed(java.awt.event.ActionEvent evt) {
        new Form_Registrasi().setVisible(true);
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        // Display form
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login_User().setVisible(true);
            }
        });
    }

}
