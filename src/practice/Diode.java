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
public class Diode implements ElectricalComponent{
    private String componentType;
    private String compositionType;
    private String componentNumber;

    public String getCompositionType() {
        return compositionType;
    }

    public void setCompositionType(String compositionType) {
        this.compositionType = compositionType;
    }

    public Diode(String compositionType, String componentNumber) {
        this.compositionType = compositionType;
        this.componentNumber = componentNumber;
        this.setComponentType("Diode");
    }

    public String getComponentNumber() {
        return componentNumber;
    }

    public void setComponentNumber(String componentNumber) {
        this.componentNumber = componentNumber;
    }
    
    public String toString(){
        return componentType;
    }

    @Override
    public String getComponentType() {
        return componentType;
    }

    @Override
    public void setComponentType(String componentType) {
        this.componentType = componentType;
    }

    @Override
    public String getMeasurementData() {
        return componentNumber;
    }
}
