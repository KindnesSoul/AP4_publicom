/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;

/**
 *
 * @author m.arakelian
 */

public class CommuneListModel extends AbstractListModel {
    
    private List<Commune> communes = new ArrayList<Commune>();
    private CommuneDao ComDao;

    public CommuneListModel() throws Exception {
        this.ComDao = new CommuneDao();
        this.refresh();
    }
    @Override
    public int getSize() {
        return this.communes.size();
    }

    @Override
    public Commune getElementAt(int index) {
        return this.communes.get(index);
    }

    private void refresh() {
        this.communes = ComDao.getAll();
        this.fireContentsChanged(null, 0, 0);
    }

    public void save(int i, String nom, int codePostal, String description) {
        
        Commune commune = new Commune(i, nom, codePostal, description);
        if (i == 0) {
            ComDao.insert(commune);
        } else {
            ComDao.update(commune);
        }
    }
    
}
