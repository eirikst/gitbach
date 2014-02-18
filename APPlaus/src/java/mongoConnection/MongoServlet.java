package mongoConnection;

import com.mongodb.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author eirikstadheim
 */
@WebServlet(name = "MongoConnection", urlPatterns = {"/MongoConnection"})
public class MongoServlet extends HttpServlet {
    private MongoClient mongo;
    private DB db;

    
    @Override
    public void init() throws ServletException {
        try {
            mongo = new MongoClient( "localhost" , 27017 );
        }
        catch(java.net.UnknownHostException e) {
            //log
        }
        db = mongo.getDB("applaus");
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
        
        response.setContentType("text/html");
        try (PrintWriter out = response.getWriter()) {
            
            if(request.getParameter("action").equals("getActiveContests")) {
                out.println(ContestManager.getActiveContests(db));
            }
            if(request.getParameter("action").equals("getInactiveContests")) {
                int skip = 0;
                try {
                    skip = Integer.parseInt(request.getParameter("skip"));
                }
                catch(NumberFormatException e) {
                    // feilhåndtering
                }
                out.println(ContestManager.getInactiveContests(db, skip));
            }
        }
    }

    public void insert() {
        
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
