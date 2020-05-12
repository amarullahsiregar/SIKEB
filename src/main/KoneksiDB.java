package main;

import java.sql.*;


public class KoneksiDB {

    public String makan="Makan";
    public static Connection koneksi;
    public static Statement statement;
    public static void main(String args[]){
    String username = "10293847";
    String password = "admin";
        try {
            String url ="jdbc:mysql://localhost/sikeb";
            String user="root";
            String pass="";
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Makan");
            
            koneksi =DriverManager.getConnection(url,user,pass);
            ResultSet hasil = koneksi.createStatement().executeQuery("select * from pengguna where id_pengguna='"+username+"'and password='"+password+"' and status_aktif=2");
            if (hasil.next()) {
                System.out.println("Bisa");
            }else{
                System.out.println("Gagal");
            }
        } catch (Exception e) {
            System.err.println("koneksi gagal karena " +e.getMessage());
        }
    }
    
}
