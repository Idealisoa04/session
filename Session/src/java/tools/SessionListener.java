/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import connect.Connect;
import java.sql.Connection;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * @author Idealisoa
 */
public class SessionListener implements HttpSessionListener,HttpSessionAttributeListener{

    @Override
    public void sessionCreated(HttpSessionEvent se){
        String id = se.getSession().getId();
        String data = "Hello kitty";
        Sessions session = new Sessions(id,data);
        try{
            Connect con = new Connect();
            Connection co = con.Etablish_connection();
            session.insert(co);
        }catch(Exception e){
            System.out.print(e.getMessage());
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        String id = event.getSession().getId();
        System.out.print(id + "add");
        String data = "Hello kitty";
        Sessions session = new Sessions(id,data);
        try{
            Connect con = new Connect();
            Connection co = con.Etablish_connection();
            session.insert(co);
        }catch(Exception e){
            System.out.print(e.getMessage());
        }//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
