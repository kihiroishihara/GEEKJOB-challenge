
package org.Mezotto.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class Mezotto8 extends HttpServlet{

    private static String[] test(String ID){   
 
        String [][] data ={
            {"0000","2000/2/2","東京"},
            {"0001","2000/3/3",null},
            {"0002","2000/4/4","京都"}
        };
 
       int limit=2;
       for(int i=0;i<=2;i++){
            if(i<limit){
                if(ID.equals(data[i][0])){
                    return data[i];
                }
            }     
        }
        return null;  
    }
  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String data[];
            
            data = test("0001");
            for(int i=0; i< 3; i++){
                if (data[i] == null) {
                    continue;
                }    
                out.println(data[i]);
            }
            
            data = test("0000");
            for(int i=0; i< 3; i++){
                if (data[i] == null) {
                    continue;
                }    
                out.println(data[i]);
            }
            
            data = test("0002");
            for(int i=0; i< 3; i++){
                if (data[i] == null) {
                    continue;
                }    
                out.println(data[i]);
            }
          
         
            


           
  
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
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
