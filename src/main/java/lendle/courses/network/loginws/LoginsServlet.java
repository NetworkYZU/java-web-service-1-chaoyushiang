/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lendle.courses.network.loginws;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lendle
 */
@WebServlet(name = "LoginsServlet", urlPatterns = {"/logins"})
public class LoginsServlet extends HttpServlet {
    static{
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginsServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    private void service1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/plain;charset=UTF-8");
        try (PrintWriter out=response.getWriter(); Connection conn=DriverManager.getConnection("jdbc:derby://localhost:1527/sample", "app", "app")) {
            //select from login
            //output in id:password style
            
            //////////////////////////////
        }catch(Exception e){
            throw new ServletException(e);
        }
    }
    
    private void service2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("application/json;charset=UTF-8");
        try (PrintWriter out=response.getWriter(); Connection conn=DriverManager.getConnection("jdbc:derby://localhost:1527/sample", "app", "app")) {
            //re-implement service1, this time
            //responde in json format
            
            //////////////////////////////
        }catch(Exception e){
            throw new ServletException(e);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        service1(request, response);
        response.setContentType("application/json;charset=utf-8");
        try (PrintWriter out=response.getWriter(); Connection conn=DriverManager.getConnection("jdbc:derby://localhost:1527/sample", "app", "app")) {
            Statement stmt =conn.createStatement();
            ResultSet rs=stmt.executeQuery("select * from LOGIN");
            List ret=new ArrayList();
            while(rs.next()){
                Map map=new HashMap();
                map.put("id", rs.getString("id1"));
                map.put("password", rs.getString("passward1"));
                ret.add(map);
            }
            Gson gson=new Gson();
            out.print(gson.toJson(ret));
        }catch(Exception e){
            throw new ServletException(e);
        }
    }

}
