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
public class Resistor implements ElectricalComponent{
    private String compositionType;
    private double value;
    private String unitOfMeasurement;
    private String componentType;

    public Resistor(String compositionType, double value, String unitOfMeasurement) {
        this.setCompositionType(compositionType);
        this.setUnitOfMeasurement(unitOfMeasurement);
        this.setValue(value);
        this.setComponentType("Resistor");
    }

    public String getCompositionType() {
        return compositionType;
    }

    public void setCompositionType(String compositionType) {
        this.compositionType = compositionType;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getUnitOfMeasurement() {
        return unitOfMeasurement;
    }

    public void setUnitOfMeasurement(String unitOfMeasurement) {
        this.unitOfMeasurement = unitOfMeasurement;
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
       return String.valueOf(value);
    }
}
