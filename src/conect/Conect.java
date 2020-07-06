/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conect;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Admin
 */
public class Conect {

    /**C
     * @param args the command line arguments
     */
    Connection conn;
    String hosting="jdbc:sqlserver://localhost\\ADMINPC\\SQLEXPRESS:1433;databaseName=DungNA_ShopFPT";
    String username="sa";
    String password="thang3012";
    private void KetNoi() throws ClassNotFoundException, SQLException{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        conn = DriverManager.getConnection(hosting,username,password);
    }
    private void taiDuLieu() throws SQLException{
        String SQL="select *from dbo.chucvu";
        Statement stt=conn.createStatement();
        ResultSet rs= stt.executeQuery(SQL);
        while(rs.next()){
            int id= rs.getInt("IdChucVu");
            String MaChucVu =rs.getString("MaChucVu");
            String TenChucVu=rs.getString("TenChucVu");
            System.out.println("chào "+id+"- "+MaChucVu+"- "+TenChucVu);
        }
    }
    public static void main(String[] args) throws ClassNotFoundException {
        // TODO code application logic here
        Conect main =new Conect();
        try {
            main.KetNoi();
            System.out.println("ket noi thanh cong");
            main.taiDuLieu();
            System.out.println("tai len thanh cong");
        } 
         catch (SQLException ex) {
            System.out.println("ket noi that bai 2");
            Logger.getLogger(Conect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
