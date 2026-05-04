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
    //int idCommune;

    public UtilisateurControl(UtilisateurView utilisateurView/*,int idCommune*/) {
        this.utilisateurView = utilisateurView;
        this.utilisateurView.addPropertyChangeListener(this);
        this.utilisateurListModel= new UtilisateurListModel();
        this.utilisateurView.setUtilisateurListModel(this.utilisateurListModel);

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Utilisateur user;
        switch (evt.getPropertyName()) {
            case "AffichageModificationUtilisateur":
                user = getUtilisateur();
                
                    this.utilisateurView.accesSetEditPanel(user.getPrenom(), user.getNom(), user.getIdentifiant(), user.getMotdepasse());
                
                break;
            case "AjoutUtilisateur":
                if(this.utilisateurView.testParameterUtilisateur()){
                    this.utilisateurListModel.addUtilisateur(this.utilisateurListModel.getSelectedCommuneId(), this.utilisateurView.accessGetNomUtilisateur(), this.utilisateurView.accessGetPrenomUtilisateur(), this.utilisateurView.accessGetLoginUtilisateur(), this.utilisateurView.accessGetPasswordUtilisateur());
                    this.utilisateurListModel.refresh();
                }
                break;

            case "ConfirmModificationUtilisateur":
                user = getUtilisateur();
                if(this.utilisateurView.testParameterUtilisateur()){
                    this.utilisateurListModel.updateUtilisateur(user.getId(), user.getIdUtilisateurCommune(), this.utilisateurView.accessGetNomUtilisateur(), this.utilisateurView.accessGetPrenomUtilisateur(), this.utilisateurView.accessGetLoginUtilisateur(), this.utilisateurView.accessGetPasswordUtilisateur());
                    this.utilisateurListModel.refresh();
                }
                break;
            case "suppressionUtilisateur":
                user = getUtilisateur();
                this.utilisateurListModel.deleteUtilisateur(user.getId());
                this.utilisateurListModel.refresh();
                break;
        }
    }

    public Utilisateur getUtilisateur() {
        int index = this.utilisateurView.getUtilisateurIndex();
        return this.utilisateurListModel.getElementAt(index);
    }

    public void refreshUtilisateurListModel(int idCommune,String nomCommune) {
        try {
            System.out.println("idCommune :" + idCommune);
            this.utilisateurListModel.setSelectedCommuneId(idCommune);
            this.utilisateurListModel.refresh();
            this.utilisateurView.updateTitreListe(nomCommune);
            //System.out.println("ListeModel :" + this.utilisateurListModel);
            
            

        } catch (Exception ex) {
            Logger.getLogger(UtilisateurControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
