
package atm;
import java.sql.*;
public class Conn {
    Connection c;
    Statement s;
    public Conn(){
        try{
            //Class.forName(com.mysql.cj.jdbc.Driver);
            c=DriverManager.getConnection("jdbc:mysql:///Atm","root","12345678sg");
            s=c.createStatement();
                    
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
}
