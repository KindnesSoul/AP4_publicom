/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Commune;
import model.CommuneListModel;
import view.CommuneView;
import view.MainView;

/**
 *
 * @author m.arakelian
 */
public class CommuneControl implements PropertyChangeListener {

    CommuneView communeview;
    CommuneListModel communeListModel;

    public CommuneControl(CommuneView communeView) {

        this.communeview = communeView;
        this.communeview.addPropertyChangeListener(this);

        try {
            this.communeListModel = new CommuneListModel();
            this.communeview.setCommuneListModel(this.communeListModel);
        } catch (Exception ex) {
            Logger.getLogger(CommuneControl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {
            case "validModifCommune":
                Commune selected = (Commune) evt.getNewValue();  
                if (selected != null) {
                    String nom = this.communeview.getNom();
                    int codePostal = this.communeview.getCodePostal();
                    String description = this.communeview.getDescription();
                    this.communeListModel.save(selected.getId(), nom, codePostal, description);
                    refreshCommuneView();
                }
                break;
            case "validNouvelleCommune":
                String nom = this.communeview.getNom();
                int codePostal = this.communeview.getCodePostal();
                String description = this.communeview.getDescription();
                this.communeListModel.save(0, nom, codePostal, description);
                refreshCommuneView();
                break;
            case "deleteSelectedCommune":
                int index = this.communeview.getSelectedCommuneId();
                Commune commune = this.communeListModel.getElementAt(index);
                int id = commune.getId();
                this.communeListModel.suppr(id);
                refreshCommuneView();
                break;
        }

    }

    public void refreshCommuneView() {
        try {
            this.communeListModel = new CommuneListModel();
            this.communeview.setCommuneListModel(this.communeListModel);
        } catch (Exception ex) {
            Logger.getLogger(CommuneControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
