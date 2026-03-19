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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author m.arakelian
 */
public class CommuneDao {
    
    private Connection connexion;

    public CommuneDao() throws Exception {
        this.connexion = Connexion.getConnection();
    }

    public List<Commune> getAll() {

        List<Commune> liste = new ArrayList<>();

        try {

            String query = "SELECT * FROM departement";
            PreparedStatement ps = connexion.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Commune Com = new Commune(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getInt("codePostal"),
                        rs.getString("description")
                );
                liste.add(Com);

            }
        } catch (SQLException ex) {
            Logger.getLogger(CommuneDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return liste;
    }
    
}
