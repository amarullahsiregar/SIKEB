
package daftarBarang;

import javax.swing.*;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JPanel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public final class DaftarBarang extends javax.swing.JPanel{
    DefaultTableModel model;
    Connection koneksi;
    
    private JPanel body;
    private JScrollPane bodyscroll;
    private JTable tabel;
    
    String [] judul ={"Nama Barang","penemu","keterangan","Waktu","Status"};
    Object [][] ListBarang;
    String [] ListId;
    int panjangList,iterasi_list=0;
    String url ="jdbc:mysql://localhost/sikeb";
    String user="root";
    String pass="";
    String query="SELECT * FROM barang INNER JOIN pengguna WHERE barang.id_pengguna = pengguna.id_pengguna order by waktu desc";
    public static Connection koneksiDaftar;
    ResultSet ResultSetDaftar;
    
    public DaftarBarang(){
        cari_panjangList();
        ListBarang = new Object[panjangList][5];
        ListId = new String[panjangList];
        isiMatriksList();
        initComponents();
    }
    
    public DaftarBarang(String query){
        this.query=query;
        cari_panjangList();
        ListBarang = new Object[panjangList][5];
        ListId = new String[panjangList];
        isiMatriksList();
        initComponents();
    }
    
    public void cari_panjangList(){
        try {
            koneksi = DriverManager.getConnection("jdbc:mysql://localhost/sikeb","root","");
            
            
            ResultSet banyakData = koneksi.createStatement().executeQuery("SELECT COUNT(nomor) FROM barang");
            if (banyakData.next()) {
                panjangList = banyakData.getInt("COUNT(nomor)");
            }else{
                judul[0]="Koneksi Gagal";
            }
            
        } catch (SQLException ex) {
            System.out.println("Gagal Koneksi");
//            System.out.println(ex.getMessage());
//            Logger.getLogger(DaftarBarang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void isiMatriksList() {
        
        try {koneksi = DriverManager.getConnection("jdbc:mysql://localhost/sikeb","root","");
            ResultSet rs = koneksi.createStatement().executeQuery(query);
            
            while(rs.next()){
                iterasi_list++;
                String StatusBarang =rs.getString("status_barang");
                if("0".equals(StatusBarang)){
                    StatusBarang ="Temuan";
                }else{
                    StatusBarang ="Hilang";
                }
                    ListId[iterasi_list-1]=rs.getString("nomor");
                    ListBarang[iterasi_list-1][0]=rs.getString("nama_barang");
                    ListBarang[iterasi_list-1][1]=rs.getString("nama_pengguna");
                    ListBarang[iterasi_list-1][2]=rs.getString("keterangan");
                    ListBarang[iterasi_list-1][3]=rs.getString("waktu");
                    ListBarang[iterasi_list-1][4]=StatusBarang;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaftarBarang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void ListDipilih() {
        
        try {koneksi = DriverManager.getConnection("jdbc:mysql://localhost/sikeb","root","");
            ResultSet rs = koneksi.createStatement().executeQuery(query);
            
            while(rs.next()){
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaftarBarang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    private void initComponents(){
        body = new JPanel();
        bodyscroll = new JScrollPane();
        tabel = new JTable();
        
        tabel.setModel(new javax.swing.table.DefaultTableModel(
            ListBarang,
                judul
        ));
        tabel.addMouseListener(new java.awt.event.MouseAdapter() {
    @Override
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        int row = tabel.rowAtPoint(evt.getPoint());
        int col = tabel.columnAtPoint(evt.getPoint());
        if (row >= 0 && col >= 0) {
            new DetailBarang(ListId[row]).setVisible(true);
        }
    }
});
        java.awt.GridLayout bodyLayout;
        bodyLayout = new java.awt.GridLayout();
        bodyLayout.setColumns(1);
        bodyLayout.setRows(10);
        bodyLayout.setHgap(20);
        bodyLayout.setVgap(20);
        body.setLayout(bodyLayout);
        body.setBorder(new javax.swing.border.EmptyBorder(20, 20, 20, 20));
        
        body.add(tabel);
        bodyscroll.setViewportView(tabel);
        this.setBackground(Color.gray);
        javax.swing.GroupLayout masterlayout = new javax.swing.GroupLayout(this);
        this.setLayout(masterlayout);
        masterlayout.setHorizontalGroup(
            masterlayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bodyscroll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGap(18,18,18)
        );
        masterlayout.setVerticalGroup(
            masterlayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(masterlayout.createSequentialGroup()
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bodyscroll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
            ));
        
        
    }
}