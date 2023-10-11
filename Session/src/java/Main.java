
import connect.Connect;
import java.sql.Connection;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Idealisoa
 */
public class Main {
    public static void main(String[] args) throws Exception{
        Connect con = new Connect();
        Connection co = con.Etablish_connection();
        System.out.print(co);
    }
}
