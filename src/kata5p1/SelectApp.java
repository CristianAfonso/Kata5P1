
package kata5p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class SelectApp {

    private Connection connect(){
        Connection con = null;
        try{
            String url = "jdbc:sqlite:KATA5.db";
            con = DriverManager.getConnection(url);
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return con;
    }
    //Nos muestra por consola todos los registros de la tabla PEOPLE:
    public void selectAll(){
        String sql = "SELECT * FROM PEOPLE";
        try(Connection con  = this.connect();
            Statement stmt  = con.createStatement();
            ResultSet rs    = stmt.executeQuery(sql)){
        
            while(rs.next()){
                System.out.println(rs.getInt("id") + "\t" +
                                   rs.getString("Name") + "\t" +
                                   rs.getString("Apellidos") + "\t" +
                                   rs.getString("Departamento") + "\t");
            }
        }catch (SQLException e){
        
                System.out.println(e.getMessage());
        
        }  
        
    }
}
