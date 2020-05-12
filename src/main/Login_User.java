package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import lakban.Login_Admin;

/*
 * @author Siregar
 */

public class Login_User  extends javax.swing.JFrame {
    
    // Variables declaration - do not modify                     
    private JLabel tombolDaftar;
    private JLabel tombolTutup,tombolRegistrasi;
    private JLabel logo,usernamelabel,passwordlabel;
    private javax.swing.JButton registrasi;
    private javax.swing.JPasswordField passwordForm;
    private javax.swing.JTextField usernameForm;
    private JButton tombolLogin;
    private JPanel bg,usernameBg,passwordBg;
    
    
    // End of variables declaration
    
    
    //Color Style
    Color bg_color = new Color(255,255,255);
    Color fg_color = new Color(0, 22, 38);
    Font btn_font = new Font("Agency FB", 1, 15);
    Font label_font = new Font("Century Gothic", 0, 15);
    GraphicsDevice ScreenDim = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    int screenwidth = ScreenDim.getDisplayMode().getWidth();
    int screenheight = ScreenDim.getDisplayMode().getHeight();
    
    int squareDimens = ScreenDim.getDisplayMode().getHeight()*2/3;
    public static Connection koneksiLogin;
    
    
    
    public Login_User() {
        initComponents();        
    }

    private void initComponents() {
        
        tombolTutup = new JLabel();
        tombolRegistrasi = new JLabel();
        tombolDaftar = new JLabel();
        tombolLogin = new JButton();
        registrasi = new JButton();
        usernamelabel = new JLabel();
        passwordlabel = new JLabel();
        usernameBg = new JPanel();
        passwordBg = new JPanel();
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
        
//Username Field Start

        usernamelabel.setFont(label_font);
        usernamelabel.setForeground(new Color(0, 100, 172));
        usernamelabel.setText("Nomor Induk Pengguna");
        usernamelabel.setBounds((squareDimens/2)-160, (squareDimens/2)-91, 200, 35);
        getContentPane().add(usernamelabel);
        
        usernameForm.setBackground(new Color(115, 135, 155,0));
        usernameForm.setFont(new Font("Agency FB", 1, 20)); 
        usernameForm.setBorder(null);
        usernameForm.setCaretColor(new java.awt.Color(255, 255, 255));
        usernameForm.setOpaque(false);
        usernameForm.addActionListener(this::jTxtUsernameActionPerformed);
        usernameForm.setBounds(squareDimens/2-140, usernamelabel.getBounds().y+32, 280, 30);
        getContentPane().add(usernameForm);
        
        usernameBg.setBackground(bg_color);
        usernameBg.setBounds(squareDimens/2-160,usernameForm.getBounds().y+32,320,1); //ukuran berdasarkan form username, X -15 dan Y-8
        getContentPane().add(usernameBg);
        
//Username Field End
        
        passwordlabel = new JLabel("<html><div style='text-align: center;'>" + "password" + "</div></html>");
        passwordlabel.setFont(label_font);
        passwordlabel.setForeground(usernamelabel.getForeground());
        passwordlabel.setText("Password");
        passwordlabel.setBounds(usernamelabel.getBounds().x, usernamelabel.getBounds().y+100,100, usernamelabel.getBounds().height);
        getContentPane().add(passwordlabel);
        
        passwordForm.setBackground(usernameForm.getBackground());
        passwordForm.setFont(usernameForm.getFont());
        passwordForm.setBorder(null);
        passwordForm.setOpaque(false);
        passwordForm.addActionListener(this::jPasswordActionPerformed);
        getContentPane().add(passwordForm);
        passwordForm.setBounds(usernameForm.getBounds().x, passwordlabel.getBounds().y+32, 280,30);
        
        passwordBg.setBackground(bg_color);
        passwordBg.setBounds(squareDimens/2-160,passwordForm.getBounds().y+32,320,1); //ukuran berdasarkan username, Y + 100
        getContentPane().add(passwordBg);
        
        tombolLogin.setFont(new java.awt.Font("Agency FB", 1, 15));
        tombolLogin.setText("Login");
        tombolLogin.setBackground(bg_color);
        tombolLogin.setForeground(fg_color);
        tombolLogin.setOpaque(false);
        tombolLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tombolLogin.addActionListener(this::loginButtonOnClick);
        tombolLogin.setBounds((squareDimens/2)-(passwordBg.getBounds().width/2),  passwordBg.getBounds().y+50, passwordBg.getBounds().width, 30);
        getContentPane().add(tombolLogin);
        
        tombolDaftar.setFont(btn_font);
        tombolDaftar.setText("Daftar Akun");
        tombolDaftar.setBackground(bg_color);
        tombolDaftar.setForeground(new Color(0, 100, 172));
        tombolDaftar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tombolDaftar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tombolDaftarOnClick(evt);
            }
        });
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
            
            System.out.println("Login Database");
            
            koneksiLogin = DriverManager.getConnection(url,user,pass);
            ResultSet userMasuk_RS  = koneksiLogin.createStatement().executeQuery("select * from pengguna where id_pengguna='"+usernameForm.getText()+"'and password='"+passwordForm.getText()+"' ");
            
            if (userMasuk_RS.next()) {
                if("0".equals(userMasuk_RS.getString("status_user"))){
                    System.out.println("user Yang Masuk adalah User yang Belum di verifikasi");
                }if("1".equals(userMasuk_RS.getString("status_user"))){
                    System.out.println("user Yang Masuk adalah : "+userMasuk_RS.getString("nama_pengguna"));
                    new Beranda_User().setVisible(true);
                    this.dispose();
                }else{
                    System.out.println("user Yang Masuk adalah : "+userMasuk_RS.getString("nama_pengguna"));
                    new Beranda_Admin().setVisible(true);
                    this.dispose();
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("koneksi gagal karena " +e.getMessage());
        }
    }

    private void jPasswordActionPerformed(java.awt.event.ActionEvent evt) {
    }                                         

    private void tombolDaftarOnClick(MouseEvent evt) {
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
        java.awt.EventQueue.invokeLater(() -> {
            new Login_User().setVisible(true);
        });
    }

}
