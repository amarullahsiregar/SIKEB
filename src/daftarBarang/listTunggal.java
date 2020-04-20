package daftarBarang;


import java.awt.Color;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import main.koneksidb;

public class listTunggal extends javax.swing.JPanel{
    public JLabel labelList;
    
    listTunggal() {
        inisialisasi();
    }
    
    public void inisialisasi(){
        
        labelList = new javax.swing.JLabel();
        labelList.setFont(new java.awt.Font("Arial",1,16));
        labelList.setBorder(new javax.swing.border.EmptyBorder( 10, 10, 10, 10));
        labelList.setText("null");
        
        this.setBackground(Color.WHITE);
        this.setLayout(new java.awt.GridLayout());
        this.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(116,130,153),2,true));
        this.setPreferredSize(new java.awt.Dimension(500,200));
        this.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        this.addMouseListener(new java.awt.event.MouseListener() {
            public void mouseClicked(MouseEvent arg0) {
                try {
                    detail a = new detail();
                } catch (SQLException ex) {
                    Logger.getLogger(listTunggal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void mousePressed(MouseEvent me) {
                setWarnaLatar(new java.awt.Color(100, 100, 100));
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                setWarnaLatar(new java.awt.Color(198, 201, 206));
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                setWarnaLatar(new java.awt.Color(198, 201, 206));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                setWarnaLatar(Color.white);
            }
        });
        this.add(labelList);
    }
    
    
    private void setWarnaLatar(Color warna) {
        this.setBackground(warna);
    }
    
    public java.awt.Color getWarnaLatar(){
        return this.getBackground();
    }
    
    //Set Label
    public void setLabel(String nama_barang) {
        this.labelList.setText(nama_barang);
    }
    private void setLabel(int hasil) {
        this.labelList.setText(Integer.toString(hasil));
    }
    
    public void setNama(String nama){
        
    }
    
    public void load_list() throws SQLException{
        listTunggal list1[];
        koneksidb a = new koneksidb();
        ResultSet b = a.koneksi.createStatement().executeQuery("SELECT nomor,nama_barang,nama_lengkap FROM barang INNER JOIN pengguna WHERE barang.id_pengguna = pengguna.id_pengguna order by nomor desc");
        
    }
    
    public static void main(String[] args) throws SQLException {
        JFrame frame;
        frame = new JFrame();
        
        java.awt.GridLayout layout = new java.awt.GridLayout();
        layout.setColumns(2);
        layout.setRows(20);
        
        layout.setHgap(1);
        frame.setLayout(layout);
        
        
        listTunggal list1[];
        koneksidb a = new koneksidb();
        ResultSet b = a.koneksi.createStatement().executeQuery("SELECT nomor,nama_barang,nama_pengguna FROM barang INNER JOIN pengguna WHERE barang.id_pengguna = pengguna.id_pengguna order by nomor desc");
        
        if(!b.next()){
            new lakban.Login_User().setVisible(true);
        }
        list1 = new listTunggal[10];
        String hasil = b.getString(2);
        
        listTunggal list;
        list = new listTunggal();
        list.setLabel(b.getString(2)+" ditemukan Oleh "+b.getString(3));
       
        while (b.next()){
            list1[1] = new listTunggal();
            list1[1].setLabel(b.getString(2)+" ditemukan Oleh "+b.getString(3));
            frame.add(list1[1]);
        }
        
        frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        frame.add(list);
        frame.setSize(300,500);
        frame.setVisible(true);
    }

}