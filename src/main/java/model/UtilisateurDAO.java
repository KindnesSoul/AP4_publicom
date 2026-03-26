/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author j.bonnafe
 */
public class UtilisateurDAO {
   private Connection connexion;
   public UtilisateurDAO(){
       this.connexion=Connexion.getConnection();
   }

    public ArrayList<Utilisateur> getAllUtilisateur() {
        String SQL =("select * from utilisateur");
        ArrayList<Utilisateur> listeUtilisateur = new ArrayList<Utilisateur>();
        try (PreparedStatement preparedStatement = connexion.prepareStatement(SQL)) {
             ResultSet res = preparedStatement.executeQuery();
             while(res.next()){
                int id =res.getInt("id");
                int idUtilisateurCommune =res.getInt("id_utilisateurcommune");
                String prenom=res.getString("prenom");
                String nom=res.getString("nom");
                String identifiant=res.getString("identifiant");
                String motdepasse=res.getString("motdepasse");
                listeUtilisateur.add(new Utilisateur(id,idUtilisateurCommune,prenom,nom,identifiant,motdepasse));
             }
            
        }catch (SQLException ex){
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return(listeUtilisateur);
    }
   
}
