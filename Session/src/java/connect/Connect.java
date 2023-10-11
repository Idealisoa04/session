/*
 * To change this license header, choose License Headers in Project Properties..
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Idealisoa
 */
public class Connect {
    String host = "localhost";
    String port = "5432";
    String user = "postgres";
    String mdp = "Mdpprom15";
    String dbname = "test";

    public Connect(){
        
    }
         
    public Connection Etablish_connection() throws Exception{
        Connection conn =  null;
        try{
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://"+this.getHost()+":"+this.getPort()+"/"+this.getDbname();
            conn = DriverManager.getConnection(url,this.getUser(),this.getMdp());
        }catch(Exception e){
            throw e;
        }
        return conn;  
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getDbname() {
        return dbname;
    }

    public void setDbname(String dbname) {
        this.dbname = dbname;
    }
     
}
