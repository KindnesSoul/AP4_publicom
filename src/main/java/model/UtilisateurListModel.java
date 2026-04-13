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
    public void updateUtilisateur(int id,int idUtilisateurCommune,String nom,String prenom,String login ,String password){
        this.utilisateurDAO.updateUtilisateur(id,idUtilisateurCommune,nom,prenom,login,password);
    }
    
     public void deleteUtilisateur(int id) {
        this.utilisateurDAO.deleteUserAt(id);
    }
     

    @Override
    public int getSize() {
        return listeUtilisateur.size();
    }

    @Override
    public Utilisateur getElementAt(int index) {
        return listeUtilisateur.get(index);
    }

   
}
