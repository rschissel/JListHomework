/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice;

import java.util.Vector;
import javax.swing.DefaultListModel;

/**
 *
 * @author Ryan Schissel
 */
public class ComponentListModel extends DefaultListModel{
private DataStore ds = new DataStore();
    public ComponentListModel() {
        for (ElectricalComponent e : ds.getComponentsList()){
            addElement(e.getComponentType());
        }
        
    }
    
}
