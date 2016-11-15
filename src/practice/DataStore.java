/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice;

import java.util.Vector;

/**
 *
 * @author Ryan Schissel
 */
public class DataStore {
    private Vector<ElectricalComponent> componentsList = new Vector<>();

    public Vector<ElectricalComponent> getComponentsList() {
        return componentsList;
    }

    public DataStore() {
        componentsList.addElement(new Resistor("Carbon Composition", 470, "k"));
        componentsList.addElement(new Resistor("Metal Film", 10, "k"));
        componentsList.addElement(new Capacitor("Electrolytic", 1000, "uF"));
        componentsList.addElement(new Diode("Silicon", "1N4007"));
        componentsList.addElement(new Diode("Germanium", "1N34A"));
    }
    
    public String getComponentType(ElectricalComponent e){
        return e.getComponentType();
    }
    public double getComponentValue(Resistor r){
        return r.getValue();
    } 
    public double getComponentValue(Capacitor c){
        return c.getValue();
    }
    public String getComponentCompositionType(Resistor r){
        return r.getCompositionType();
    }
    public String getCompositionType(Capacitor c){
        return c.getCompositionType();
    }
    public String getCompositionType(Diode d){
        return d.getCompositionType();
    }
    public String getComponentNumber(Diode d){
        return d.getComponentNumber();
    }
    public String getUnitOfMeasurement(Resistor r){
        return r.getUnitOfMeasurement();
    }
    public String getUnitOfMeasurement(Capacitor c){
        return c.getUnitOfMeasurement();
    }
}
