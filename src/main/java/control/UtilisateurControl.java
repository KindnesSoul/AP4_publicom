/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Utilisateur;
import model.UtilisateurListModel;
import view.UtilisateurView;

/**
 *
 * @author m.arakelian
 */
public class UtilisateurControl implements PropertyChangeListener {
    UtilisateurView utilisateurView;
    UtilisateurListModel utilisateurListModel;
    
    public UtilisateurControl(UtilisateurView utilisateurView) {
        this.utilisateurView=utilisateurView;
        this.utilisateurView.addPropertyChangeListener(this);
        refreshUtilisateurView();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Utilisateur user;
       switch (evt.getPropertyName()) {
           case "ModificationUtilisateur":   
               user=getUtilisateur();
               this.utilisateurView.accesSetEditPanel(user.getPrenom(),user.getNom(),user.getIdentifiant(), user.getMotdepasse());
               break;
            
           case "ConfirmModificationUtilisateur":
               user=getUtilisateur();
               this.utilisateurListModel.updateUtilisateur(user.getId(),user.getIdUtilisateurCommune(),this.utilisateurView.accessGetNomUtilisateur(),this.utilisateurView.accessGetPrenomUtilisateur(),this.utilisateurView.accessGetLoginUtilisateur(), this.utilisateurView.accessGetPasswordUtilisateur());
               refreshUtilisateurView();
       }
    }
    public Utilisateur getUtilisateur(){
        int index=this.utilisateurView.getUtilisateurIndex();
        return this.utilisateurListModel.getElementAt(index);
    }
    public void refreshUtilisateurView() {
        try{
            this.utilisateurListModel=new UtilisateurListModel(7);//modifier avec l'id transmit par les communes
            this.utilisateurView.setUtilisateurListModel(this.utilisateurListModel);
        }catch(Exception ex){
            Logger.getLogger(CommuneControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
