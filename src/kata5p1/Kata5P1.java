package kata5p1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Kata5P1 {
    
    
    public static void main(String[] args) throws IOException, SQLException{
        String fileName = "email.txt";
        List<String> mailList = MailListReader.read(fileName);
        connection();
        SelectApp app = new SelectApp();
        app.selectAll();
        createNewTable();
        for(int i = 0; i < mailList.size(); i++){
            
            app.insert(i, mailList.get(i));
            System.out.println(mailList.get(i));
        }
        
    }
    
    public static void connection(){
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
    
    //Crear una tabla en la BD para la v3:
    public static void createNewTable(){
        String url  =    "jdbc:sqlite:KATA5.db";
        String sql  =    "CREATE TABLE IF NOT EXISTS eMAIL (\n"
                        + " id integer PRIMARY KEY AUTOINCREMENT, \n"
                        + " mail text NOT NULL);";
        try (Connection con = DriverManager.getConnection(url);
                Statement stmt = con.createStatement()){
            stmt.execute(sql);
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        } 
        
                
    }
    
}