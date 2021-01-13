package kata5p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Kata5P1 {
    
    
    public static void main(String[] args){
        connection();
        SelectApp app = new SelectApp();
        app.selectAll();
    }
    
    
    private static void connection(){
        Connection con = null;
        try{
            String url = "jdbc:sqlite:KATA5.db";
            con = DriverManager.getConnection(url);
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }finally{
            try{
                if (con != null){
                    con.close();
                }
            }catch (SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
    
}