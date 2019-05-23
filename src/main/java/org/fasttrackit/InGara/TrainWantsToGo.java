package org.fasttrackit.InGara;

import java.io.Serializable;

public class TrainWantsToGo implements Serializable {
    private String canTrainGO;

    TrainWantsToGo(String canTrainGO){
        this.canTrainGO=canTrainGO;
    }

    @Override
    public String toString() {
        return "TrainWantsToGo{" +
                "canTrainGO='" + canTrainGO + '\'' +
                '}';
    }
}
