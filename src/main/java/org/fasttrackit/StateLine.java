package org.fasttrackit;

import java.io.Serializable;

public class StateLine implements Serializable {
    private String lineState;

    StateLine(String lineState){
        this.lineState=lineState;
    }

    public String toString(){
        return lineState;
    }
}
