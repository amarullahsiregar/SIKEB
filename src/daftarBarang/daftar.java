
package daftarBarang;

import java.awt.Color;
import javax.swing.JPanel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import main.koneksidb;
import daftarBarang.listTunggal;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class daftar extends javax.swing.JPanel{
    DefaultTableModel model;
    
    private JPanel body;
    private JScrollPane bodyscroll;
    private JLabel hari[];
    private listTunggal list[];
    private JTable tabel;
    private javax.swing.border.LineBorder garisPinggirDefault;
    
    public daftar(){
        initComponents();
        String []judul={"Nama Barang","penemu","keterangan","Waktu","Status"};
        model = new DefaultTableModel(judul,0);
        tabel.setModel(model);
        ambil_tabel();
    }
    
    
    public void ambil_terbaru() {
        int row = tabel.getRowCount();
        for(int i=0; i<row; i++){
            model.removeRow(0);
        }
        try {
        koneksidb konekdb = new koneksidb();
            ResultSet rs = konekdb.koneksi.createStatement().executeQuery("SELECT nomor,nama_barang,nama_pengguna,keterangan, waktu,status_cari,status_temu FROM barang INNER JOIN pengguna WHERE barang.id_pengguna = pengguna.id_pengguna order by waktu desc");
            while(rs.next()){
                String c,t,s;
                t = rs.getString("status_temu");
                c = rs.getString("status_cari");
                if(t=="1"&&c=="1"){s="sudah dipemilik";}
                else if("1".equals(t)){s="di temukan";}
                else {s="di cari";}
                String data[]={rs.getString("nama_barang"),rs.getString("nama_pengguna"),rs.getString("keterangan"),rs.getString("waktu"),s};
                model.addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(daftar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void ambil_tabel() {
        int row = tabel.getRowCount();
        for(int i=0; i<row; i++){
            model.removeRow(0);
        }
        try {
        koneksidb konekdb = new koneksidb();
            ResultSet rs = konekdb.koneksi.createStatement().executeQuery("SELECT nomor,nama_barang,nama_pengguna,keterangan, waktu,status_cari,status_temu FROM barang INNER JOIN pengguna WHERE barang.id_pengguna = pengguna.id_pengguna ");
            while(rs.next()){
                String c,t,s;
                t = rs.getString("status_temu");
                c = rs.getString("status_cari");
                if(t=="1"&&c=="1"){s="sudah dipemilik";}
                else if("1".equals(t)){s="di temukan";}
                else {s="di cari";}
                String data[]={rs.getString("nama_barang"),rs.getString("nama_pengguna"),rs.getString("keterangan"),rs.getString("waktu"),s};
                model.addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(daftar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    private void initComponents(){
        body = new JPanel();
        bodyscroll = new JScrollPane();
        list = new listTunggal[10];
        tabel = new JTable();
        int iterasi;
        
        //coba
        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        /*for (int i=0;i<list.length;i++){
            list[i] = new listTunggal();
        };*/
        
        garisPinggirDefault = new javax.swing.border.LineBorder(new java.awt.Color(0,51,51), 2, true);
        
        
        
        java.awt.GridLayout bodyLayout;
        bodyLayout = new java.awt.GridLayout();
        bodyLayout.setColumns(1);
        bodyLayout.setRows(10);
        bodyLayout.setHgap(20);
        bodyLayout.setVgap(20);
        body.setLayout(bodyLayout);
        body.setBorder(new javax.swing.border.EmptyBorder(20, 20, 20, 20));
        
        body.add(tabel);
        /*for( iterasi=0; iterasi<70; iterasi++){
            list[iterasi/7].setLabel("");
            list[iterasi/7].setBorder(garisPinggirDefault);      
            body.add(list[iterasi/7]);
        }*/
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
    
    //Tombol Tombol
    private void KlilTabel(java.awt.event.MouseEvent evt) throws SQLException{
        int ke = tabel.getSelectedRow();
        ResultSet rs = koneksidb.koneksi.createStatement().executeQuery("SELECT id_pengguna FROM barang INNER JOIN pengguna WHERE barang.id_pengguna = pengguna.id_pengguna order by nomor asc");
        new detail();
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        daftar daftar = new daftar();
        JLabel teks = new JLabel();
        frame.setPreferredSize(new java.awt.Dimension(1080, 720));
        frame.setMinimumSize(new java.awt.Dimension(1080, 720));
        
        frame.add(daftar);
        frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
}