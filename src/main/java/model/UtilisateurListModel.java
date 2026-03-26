/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import javax.swing.AbstractListModel;

/**
 *
 * @author j.bonnafe
 */
public class UtilisateurListModel extends AbstractListModel{
    private ArrayList<Utilisateur> listeUtilisateur= new ArrayList<Utilisateur>();
    private UtilisateurDAO utilisateurDAO;
    
    public UtilisateurListModel (int idCommune){
        this.utilisateurDAO=new UtilisateurDAO();
        this.refresh(idCommune);
    } 
    
    private void refresh(int idCommune){
        this.listeUtilisateur=this.utilisateurDAO.getAllUtilisateur(idCommune);
    }

    @Override
    public int getSize() {
        return listeUtilisateur.size();
    }

    @Override
    public Object getElementAt(int index) {
        return listeUtilisateur.get(index);
    }
}
