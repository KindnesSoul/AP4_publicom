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
    
    
    public MainControl(MainView mainView){
        this.mainView = mainView;
        new CommuneControl(this.mainView.getCommuneView());
        new UtilisateurControl(mainView.getUtilisateurView());
    }
    
    
    
}
