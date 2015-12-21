package SI_DKM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


class koneksi {
private static Connection konek;

public static Connection getkoneksi(){
    // cek apakah koneksi null
    if (konek == null) {
        try {
            String url = "jdbc:mysql://localhost:3306/dkm_perpus";
            String user ="root";
            String password = "";
            
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            konek = DriverManager.getConnection(url, user, password);
                         
        } catch(SQLException t){
            System.out.println("Error Membuat Koneksi");
        }
    }
    return konek;
}

    
}