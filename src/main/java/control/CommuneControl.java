/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.CommuneListModel;
import view.CommuneView;


/**
 *
 * @author m.arakelian
 */
public class CommuneControl implements PropertyChangeListener {
    
    CommuneView communeview;
    CommuneListModel communeListModel;
    
    
    public CommuneControl(CommuneView communeview) {
        this.communeview = communeview;
        this.communeview.addPropertyChangeListener(this);
        
        try {
            this.communeListModel = new CommuneListModel();
            this.communeview.setCommuneListModel(this.communeListModel);
        } catch (Exception ex) {
            Logger.getLogger(CommuneControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void propertyChange(PropertyChangeEvent evt){
        switch(evt.getPropertyName()){
            case "validModifUser":
                break;
            case "validNouveauUser":
                String nom = this.communeview.getNom();
                int codePostal = this.communeview.getCodePostal();
                String description = this.communeview.getDescription();
                this.communeListModel.save(0, nom, codePostal, description);
                break;
        }
    }
}
