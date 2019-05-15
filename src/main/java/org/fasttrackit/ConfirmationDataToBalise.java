package org.fasttrackit;

import java.io.Serializable;

public class ConfirmationDataToBalise implements Serializable {
    private String confirmationData;

    ConfirmationDataToBalise(String confirmationData){
        this.confirmationData=confirmationData;
    }

    public String toString(){
        return confirmationData;
    }
}
