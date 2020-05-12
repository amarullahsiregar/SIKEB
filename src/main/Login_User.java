package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;

/*
 * @author Siregar
 */

public class Login_User  extends javax.swing.JFrame {
    
    // Variables declaration - do not modify                     
    private javax.swing.JButton tombolDaftar;
    private JLabel tombolTutup,tombolRegistrasi;
    private JLabel logo,usernameBg,passwordBg,usernamelabel,passwordlabel;
    private javax.swing.JButton registrasi;
    private javax.swing.JPasswordField passwordForm;
    private javax.swing.JTextField usernameForm;
    private JButton tombolLogin;
    private javax.swing.JPanel bg;
    BasicButtonUI tombolContoh;
    
    
    // End of variables declaration
    
    
    //Color Style
    Color bg_color = new Color(255, 255, 255);
    Color fg_color = new Color(0, 22, 38);
    Font btn_font = new Font("Agency FB", 1, 15);
    Font label_font = new Font("Consolas", 1, 15);
    GraphicsDevice ScreenDim = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    int screenwidth = ScreenDim.getDisplayMode().getWidth();
    int screenheight = ScreenDim.getDisplayMode().getHeight();
    
    int squareDimens = ScreenDim.getDisplayMode().getHeight()*2/3;
    public static Connection koneksi;
    
    
    
    public Login_User() {
        initComponents();        
    }

    private void initComponents() {
        
        tombolTutup = new JLabel();
        tombolRegistrasi = new JLabel();
        tombolDaftar = new JButton();
        tombolLogin = new JButton();
        registrasi = new JButton();
        usernamelabel = new JLabel();
        passwordlabel = new JLabel();
        usernameBg = new JLabel();
        passwordBg = new JLabel();
        logo = new JLabel();
        usernameForm = new javax.swing.JTextField();
        passwordForm = new javax.swing.JPasswordField();
        bg = new javax.swing.JPanel();
        

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(new java.awt.Dimension(squareDimens, squareDimens));
        setPreferredSize(new java.awt.Dimension(getSize().width, getSize().height));
        getContentPane().setLayout(null);
        
        
        
        logo.setIcon(new ImageIcon(getClass().getResource("/image/logo_aplikasi.png")));
        logo.setOpaque(false);
        getContentPane().add(logo);
        logo.setBounds((squareDimens/2)-97,squareDimens/7,194,91);
        
        usernamelabel.setFont(label_font);
        usernamelabel.setForeground(new Color(0, 100, 172));
        usernamelabel.setText("Id pengguna");
        usernamelabel.setBounds((squareDimens/2)-44, (squareDimens/2)-91, 88, 35);
        getContentPane().add(usernamelabel);
        
        usernameForm.setBackground(new Color(115, 135, 155));
        usernameForm.setFont(new Font("Agency FB", 1, 20)); 
        usernameForm.setBorder(null);
        usernameForm.setCaretColor(new java.awt.Color(255, 255, 255));
        usernameForm.setOpaque(false);
        usernameForm.addActionListener(this::jTxtUsernameActionPerformed);
        usernameForm.setBounds(squareDimens/2-140, usernamelabel.getBounds().y+32, 280, 30);
        getContentPane().add(usernameForm);
        
        usernameBg.setIcon(new ImageIcon(getClass().getResource("/image/loginform.png")));
        getContentPane().add(usernameBg);
        usernameBg.setBounds(squareDimens/2-160,usernameForm.getBounds().y-2,320,34); //ukuran berdasarkan form username, X -15 dan Y-8
        
        passwordlabel = new JLabel("<html><div style='text-align: center;'>" + "password" + "</div></html>");
        passwordlabel.setFont(label_font);
        passwordlabel.setForeground(usernamelabel.getForeground());
        passwordlabel.setText("password");
        passwordlabel.setBounds((squareDimens/2)-32, usernamelabel.getBounds().y+100,64, usernamelabel.getBounds().height);
        getContentPane().add(passwordlabel);
        
        passwordForm.setBackground(usernameForm.getBackground());
        passwordForm.setFont(usernameForm.getFont());
        passwordForm.setBorder(null);
        passwordForm.setOpaque(false);
        passwordForm.addActionListener(this::jPasswordActionPerformed);
        getContentPane().add(passwordForm);
        passwordForm.setBounds(usernameForm.getBounds().x, passwordlabel.getBounds().y+32, 280,30);
        
        passwordBg.setIcon(usernameBg.getIcon());
        getContentPane().add(passwordBg);
        passwordBg.setBounds(squareDimens/2-160,passwordForm.getBounds().y-2,320,34); //ukuran berdasarkan username, Y + 100
        
        tombolLogin.setFont(new java.awt.Font("Agency FB", 1, 15));
        tombolLogin.setText("Login");
        tombolLogin.setBackground(bg_color);
        tombolLogin.setForeground(fg_color);
        tombolLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tombolLogin.addActionListener(this::loginButtonOnClick);
        getContentPane().add(tombolLogin);
        tombolLogin.setBounds((squareDimens/2)-(passwordBg.getBounds().y/2),  passwordForm.getBounds().y+50, passwordBg.getBounds().width, 30);
        
        tombolDaftar.setFont(btn_font);
        tombolDaftar.setText("Daftar");
        tombolDaftar.setBackground(bg_color);
        tombolDaftar.setForeground(fg_color);
        tombolDaftar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tombolDaftar.addActionListener(this::tombolDaftarOnClick);
        getContentPane().add(tombolDaftar);
        tombolDaftar.setBounds(15, squareDimens-45, 90, 30);
        
        
        tombolTutup.setIcon(new ImageIcon(getClass().getResource("/image/close.png")));
        tombolTutup.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tombolTutup.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
        });
        getContentPane().add(tombolTutup);
        tombolTutup.setBounds(squareDimens-40, 1, 39, 39);
        
        bg.setBackground(new Color(0, 22, 38));
        bg.setBounds(0, 0, squareDimens, squareDimens);
        getContentPane().add(bg);


        pack();
        setLocationRelativeTo(null);
    }

    private void closeMouseClicked(MouseEvent evt) {
        this.dispose();
    }                                  


    private void jTxtUsernameActionPerformed(ActionEvent evt) {
    }                                            

    private void loginButtonOnClick(ActionEvent evt) {
        try {
            String url ="jdbc:mysql://localhost/sikeb";
            String user="root";
            String pass="";
            Class.forName("com.mysql.jdbc.Driver");
            
            koneksi =DriverManager.getConnection(url,user,pass);
            ResultSet hasilUser = koneksi.createStatement().executeQuery("select * from pengguna where id_pengguna='"+usernameForm.getText()+"'and password='"+passwordForm.getText()+"' and status_aktif=1");
            ResultSet hasilAdmin = koneksi.createStatement().executeQuery("select * from pengguna where id_pengguna='"+usernameForm.getText()+"'and password='"+passwordForm.getText()+"' and status_aktif=2");
            if (hasilAdmin.next()) {
                usernamelabel.setText(hasilAdmin.getString("id_pengguna"));
                passwordlabel.setText(hasilAdmin.getString("password"));
                System.out.println("Admin Masuk");
                new Login_User().setVisible(true);
            }else if(hasilUser.next()){
                usernamelabel.setText(hasilAdmin.getString("id_pengguna"));
                passwordlabel.setText(hasilAdmin.getString("password"));
            System.out.println("User Masuk");
            }
        } catch (ClassNotFoundException | SQLException e) {
                usernamelabel.setText("Gagal Karena : "+e.getMessage());
        }
    }

    private void jPasswordActionPerformed(java.awt.event.ActionEvent evt) {
    }                                         

    private void tombolDaftarOnClick(java.awt.event.ActionEvent evt) {
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
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
