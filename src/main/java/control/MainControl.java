/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JOptionPane;
import view.MainView;

/**
 *
 * @author m.arakelian
 */
public class MainControl implements PropertyChangeListener {
    
    private MainView mainView;
    private CommuneControl communeControl;
    private UtilisateurControl utilisateurControl;
    
    
    public MainControl(MainView mainView){
        this.mainView = mainView;
        this.mainView.addPropertyChangeListener(this);
        
        // je m'abonne aux notifs de CommuneView
        this.mainView.getCommuneView().addPropertyChangeListener(this);
        
        this.communeControl = new CommuneControl(this.mainView.getCommuneView());
        this.utilisateurControl = new UtilisateurControl(this.mainView.getUtilisateurView());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {
            case "....":
                JOptionPane.showMessageDialog(null, "Notif recue !!!");
                break;
        }        
    }
    
    
    
}
