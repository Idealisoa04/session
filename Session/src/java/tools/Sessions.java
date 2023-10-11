/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import connect.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;

/**
 *
 * @author Idealisoa
 */
public class Sessions {
    String id;
    Timestamp access;
    String data;

    public void insert(Connection co) throws Exception{
        try{
        if(co == null){
            Connect con = new Connect();
            co = con.Etablish_connection();
        }
            String sql = "INSERT INTO sessions(id,data) VALUES (?,?)";
            PreparedStatement stmt = co.prepareStatement(sql);
            stmt.setString(1, this.getId());
            stmt.setString(2, this.getData());
            stmt.executeQuery();
        }catch(Exception e){
            throw e;
        }
    }

    public Sessions get_specific(Connection co) throws Exception{
        if(co == null){
            Connect con = new Connect();
            co = con.Etablish_connection();
        }
        Sessions rep = null;
        try{
            String sql = "SELECT * FROM sessions where id = ? ";
            PreparedStatement stmt = co.prepareStatement(sql);
            stmt.setString(1, this.getId());
            
            ResultSet res = stmt.executeQuery();
            if (res.next()) {
                this.setId(res.getString("id"));
                this.setData(res.getString("data"));
                this.setAccess(res.getTimestamp("access"));
                rep = this;
            }
        }catch(Exception e){
            throw e;
        }
        return rep;
    }
    
    public Sessions verif(Connection co) throws Exception{
        if(co == null){
            Connect con = new Connect();
            co = con.Etablish_connection();
        }
        Sessions rep = null;
        try {
            Sessions sessionTemp = this.get_specific(co);
            if(sessionTemp == null){
                this.insert(co);
                rep = this.get_specific(co);
            }
            rep = sessionTemp;
        }catch(Exception e){
            throw e;
        }
        return rep;
    }
    
    public boolean deconnect(Connection co) throws Exception{
        boolean rep = false;
        if(co == null){
            Connect con = new Connect();
            co = con.Etablish_connection();
        }
        try{
            String sql = "DELETE FROM sessions WHERE id=?";
            PreparedStatement stmt = co.prepareStatement(sql);
            stmt.setString(1, this.getId());
            ResultSet res = stmt.executeQuery();
            rep = res.next();
        }catch(Exception e){
            throw e;
        }finally{
            co.close();
        }
        return rep;
    }
    
    
    
    public Sessions(String id, String data) {
        this.id = id;
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Timestamp getAccess() {
        return access;
    }

    public void setAccess(Timestamp access) {
        this.access = access;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    
}
