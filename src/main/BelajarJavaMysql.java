package main;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

// bisa juga diimpor sekaligus seperti ini:
// import java.sql.*


public class BelajarJavaMysql {
    
    // Menyiapkan paramter JDBC untuk koneksi ke datbase
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/perpustakaan";
    static final String USER = "root";
    static final String PASS = "";

    // Menyiapkan objek yang diperlukan untuk mengelola database
    static Connection conn;
    static Statement stmt;
    static ResultSet resultSet;

    public static void main(String[] args) {
        
        // Melakukan koneksi ke database
        // harus dibungkus dalam blok try/catch
        try {
            // register driver yang akan dipakai
            Class.forName(JDBC_DRIVER);
            
            // buat koneksi ke database
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            // buat objek statement
            stmt = conn.createStatement();
            
            // buat query ke database
            String sql = "SELECT * FROM buku";
            
            // eksekusi query dan simpan hasilnya di obj ResultSet
            resultSet = stmt.executeQuery(sql);
            
            // tampilkan hasil query
            while(resultSet.next()){
                System.out.println("ID Buku: " + resultSet.getInt("id_buku"));
                System.out.println("Judul: " + resultSet.getString("judul"));
                System.out.println("Pengarang: " + resultSet.getString("pengarang"));
            }
            
            stmt.close();
            conn.close();
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("gagal");
        }

    }
    
}