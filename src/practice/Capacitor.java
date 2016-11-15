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
public class Capacitor implements ElectricalComponent{
    private String componentType;
    private String compositionType;
    private double value;
    private String unitOfMeasurement;

    public Capacitor(String compositionType, double value, String unitOfMeasurement) {
        this.compositionType = compositionType;
        this.value = value;
        this.unitOfMeasurement = unitOfMeasurement;
        this.setComponentType("Capacitor");
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
