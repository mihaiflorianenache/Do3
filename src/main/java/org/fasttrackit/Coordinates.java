package org.fasttrackit;

import java.io.Serializable;

public class Coordinates implements Serializable {

    private double travelledDistance;
    private int numberLine;

    public Coordinates(double travelledDistance,int numberLine)
    {
        this.travelledDistance=travelledDistance;
        this.numberLine=numberLine;
    }

    public String toString()
    {
        return "travelled distance is "+travelledDistance+" and number line is "+numberLine;
    }
}
