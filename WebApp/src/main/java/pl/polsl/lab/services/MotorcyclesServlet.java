package pl.polsl.lab.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pl.polsl.lab.exception.MyException;
import pl.polsl.lab.model.HistoryList;
import pl.polsl.lab.model.Motorcycles;
import pl.polsl.lab.model.MotorcyclesList;


/**
 * Motorcycles servlet
 * @author Marcin Bloch
 * @version 1.4.0
 */
@WebServlet(name = "MotorcyclesServlet", urlPatterns = {"/motorcycles"})
public class MotorcyclesServlet extends HttpServlet {

    /**
     * List of motorcycles
     */
    private MotorcyclesList motorcyclesList;
    
    /**
     * List of search history
     */
    private HistoryList historyList;
    
    /**
     * Initialization of servlet
     */
    @Override
    public void init(){
        motorcyclesList = new MotorcyclesList();
        try {
            motorcyclesList.loadData();
        } catch (Exception ex) {
            Logger.getLogger(MotorcyclesServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        historyList = new HistoryList();
    }
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
      
        String motorcyclesComboBox = request.getParameter("motorcyclesComboBox");
        String searchedText = request.getParameter("searchedText");
        
        if(!"".equals(searchedText)){
            historyList.addToHistoryList(searchedText);
        }
        request.getSession().setAttribute("list", historyList);
        String historyCount = Integer.toString(historyList.getHistoryList().size());
        Cookie cookie = new Cookie("historyCookie", historyCount);
        response.addCookie(cookie);
        
        
        int count=1;
        PrintWriter out = response.getWriter();
        try {
            motorcyclesList.getSearchedMotorcycledList(motorcyclesComboBox, searchedText);
        } catch (MyException ex) {
            out.println("</br>");
            out.println("<p>");
            out.println(ex.getMessage());
            out.println("</p>");
        }
        for(Motorcycles motorcycle : motorcyclesList.getMotorcyclesList()){
            out.println("<tr>");
            out.println("<td>");
            out.println(count);
            out.println("</td>");
            out.println("<td>");
            out.println(motorcycle.getParameters().getCategory());
            out.println("</td>");
            out.println("<td>");
            out.println(motorcycle.getParameters().getBrand());
            out.println("</td>");
            out.println("<td>");
            out.println(motorcycle.getParameters().getModel());
            out.println("</td>");
            out.println("<td>");
            out.println(motorcycle.getParameters().getProductionYear());
            out.println("</td>");
            out.println("<td>");
            out.println(motorcycle.getPerformance().getEngineCapacity());
            out.println("</td>");
            out.println("<td>");
            out.println(motorcycle.getPerformance().getHorsePower());
            out.println("</td>");
            out.println("<td>");
            out.println(motorcycle.getPerformance().getMaxSpeed());
            out.println("</td>");
            out.println("</tr>");
            count++;
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
