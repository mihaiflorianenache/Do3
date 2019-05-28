package org.fasttrackit.InGara2;

import java.io.Serializable;

class TrainWantsToGo implements Serializable {
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
