package de.dailab.jiactng.sema2.planning.util;

import de.dailab.jiactng.owlsdescription.ServiceDescription;

/**
 * Created by borchert on 16.04.2015.
 * An action representation for planners
 */
public class RatedServiceDescription {
    //We treat serviceDescriptions as actions

    protected ServiceDescription sd = null;
    protected double useFullness = 0.0d;
    protected double executabilety = 0.0d;

    public RatedServiceDescription(ServiceDescription sd) {
        this.sd = sd;
    }

    public ServiceDescription getSd() {
        return sd;
    }

    public void setSd(ServiceDescription sd) {
        this.sd = sd;
    }

    public double getUseFullness() {
        return useFullness;
    }

    public void setUseFullness(double useFullness) {
        this.useFullness = useFullness;
    }

    public double getExecutabelity() {
        return executabilety;
    }

    public void setExecutabelity(double executabelity) {
        this.executabilety = executabelity;
    }

    @Override
    public int hashCode() {
        return sd.hashCode();
    }

    public double getHeuristic(){
        return (useFullness + executabilety)/2;
    }
}
