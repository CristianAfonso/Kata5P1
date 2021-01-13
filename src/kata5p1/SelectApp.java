
package kata5p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;


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
    //Insertamos datos en nuestra tabla:
    public void insert(int id, String email) throws SQLException{
        String sql ="INSERT INTO eMAIL(mail) VALUES(?)";
        try (Connection con = this.connect();
                PreparedStatement pstmt = con.prepareStatement(sql)){
                pstmt.setString(1,email);
                pstmt.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
