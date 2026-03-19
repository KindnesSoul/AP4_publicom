/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import view.MainView;

/**
 *
 * @author m.arakelian
 */
public class MainControl {
    
    private MainView mainView;
    private CommuneControl communeControl;
    
    public MainControl(MainView mainView){
        this.mainView = mainView;
        CommuneControl communeControl = new CommuneControl(mainView.getCommuneView());
        UtilisateurControl utilisateurControl = new UtilisateurControl(mainView.getUtilisateurView());
    }
    
}
