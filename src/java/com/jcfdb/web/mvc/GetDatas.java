/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcfdb.web.mvc;

import com.jcfdb.entites.GestionnaireJeu;
import com.jcfdb.entites.Partie;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author dbourcet
 */
public class GetDatas extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            String  e = request.getParameter("element");
            PrintWriter out = response.getWriter();
            //GestionnaireJeu gestionnaire = new GestionnaireJeu(request);
            
            switch (e) {
                case "listeJoueurs" :
                    out.print(GestionnaireJeu.getListeJoueursJSON());
                    break;
                case "listeInvitations" :
                    out.print(GestionnaireJeu.getListeInvitationsJSON());
                    break;
                case "grille" :
                    out.print(GestionnaireJeu.getGrilleJSON(request));
                    break;
                case "tour" : // retourne le nom du joueur qui doit jouer
                    out.print(GestionnaireJeu.getTour(request));
                    break;
                case "symbole" : // retourne le symbole du joueur
                    out.println(GestionnaireJeu.getSymbole(request));
                    break;
                case "adversaire" : // retourne le nom du joueur adverse
                    out.println(GestionnaireJeu.getNomAdversaire(request));
                    break;
                case "etatPartie" : // la partie est-elle terminée ?
                    out.println(GestionnaireJeu.getEtatPartie(request));
                    break;
                case "ligne" : // Y a-t-il une ligne complète formée ?
                    out.println(GestionnaireJeu.getLigneComplete(request));
                    break;
                case "vainqueur" : // si vainqueur est null et etatPartie true alors match nul.
                    out.println(GestionnaireJeu.getNomVainqueur(request));
                    break;
                default :
                    out.print("");
            }
            
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
