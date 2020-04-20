package main;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;


public class koneksidb {
    public static Connection koneksi;

    public koneksidb() throws SQLException {
        getConnection();
        
    }
    
    public static Connection getConnection()throws SQLException {
        if (koneksi == null) {
            new Driver() {
                @Override
                public Connection connect(String string, Properties prprts) throws SQLException {
                    throw new UnsupportedOperationException("Not supported yet.");
                }

                @Override
                public boolean acceptsURL(String string) throws SQLException {
                    throw new UnsupportedOperationException("Not supported yet.");
                }

                @Override
                public DriverPropertyInfo[] getPropertyInfo(String string, Properties prprts) throws SQLException {
                    throw new UnsupportedOperationException("Not supported yet.");
                }

                @Override
                public int getMajorVersion() {
                    throw new UnsupportedOperationException("Not supported yet.");
                }

                @Override
                public int getMinorVersion() {
                    throw new UnsupportedOperationException("Not supported yet.");
                }

                @Override
                public boolean jdbcCompliant() {
                    throw new UnsupportedOperationException("Not supported yet.");
                }

                @Override
                public Logger getParentLogger() throws SQLFeatureNotSupportedException {
                    throw new UnsupportedOperationException("Not supported yet.");
                }
            };
            try {
                koneksi = DriverManager.getConnection("jdbc:mysql://localhost/lakban","root","");
            } catch (Exception e) {
                System.out.println("gagal Koneksi");
            }

        }
        return koneksi;
    }
    
    public static void main(String[] args) throws SQLException {
        koneksi=null;
        new koneksidb();
        getConnection();
        
    }
}
