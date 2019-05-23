package org.fasttrackit.InGara;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class TrainGO implements Serializable {
    private String range;
    private int number;

    TrainGO(String range,int number){
        this.range=range;
        this.number=number;
    }

    @Override
    public String toString() {
        return "TrainGO{" +
                "range='" + range + '\'' +
                ", number=" + number +
                '}';
    }
}
