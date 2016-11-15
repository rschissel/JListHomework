/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice;

/**
 *
 * @author Ryan Schissel
 */
public interface ElectricalComponent {
   
    public abstract String getComponentType();

    public abstract void setComponentType(String componentType); 
   
    public abstract String getMeasurementData();
}
