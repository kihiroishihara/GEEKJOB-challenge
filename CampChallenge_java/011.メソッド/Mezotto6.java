
package org.Mezotto.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class Mezotto6 extends HttpServlet{

    private static String[] test(String ID){   
 
        String data2[] = new String[3];
        data2[0] = "0000";
        data2[1] = "2000/3/3";
        data2[2] = "大阪";
        String data3[] = new String[3];
        data3[0] = "0001";
        data3[1] = "2000/4/4";
        data3[2] = "京都";
        String data4[] = new String[1];
        data3[0] = "該当するデータはありません。";
  
        if (ID.equals(data2[0])){
            return data2;
        }
        
        if (ID.equals(data3[0])){
            return data3;
        }
  
        return data4;
    }
  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String [] data1 = {"0000","2000/2/2","東京"};
            out.print(data1[1]);
            out.print(data1[2]);
  
            String data[];
            data = test(data1[0]);
            out.print(data[1]);
            out.print(data[2]);
  
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
