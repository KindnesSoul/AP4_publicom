/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        try{
            this.utilisateurListModel=new UtilisateurListModel(7);//modifier avec l'id transmit par les communes
            this.utilisateurView.setUtilisateurListModel(this.utilisateurListModel);
        }catch(Exception ex){
            Logger.getLogger(CommuneControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
       switch (evt.getPropertyName()) {
           case "validateEditDepartement":
       
       }
    }
    
}
