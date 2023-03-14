package com.north.pojo;


import lombok.Data;

import java.util.Date;
@Data
public class DataSicbo {
    private String GameType;
    private Date TrainingDate;
    private Integer RoundID;
    private Integer Dice1;
    private Integer Dice2;
    private Integer Dice3;
    private String DiceName ;
    public DataSicbo(DiceTestResult diceTestResult) {
        GameType = diceTestResult.getGameType();
        TrainingDate = diceTestResult.getTrainingDate();
        RoundID = diceTestResult.getRoundID();
        Dice1 = diceTestResult.getDice1();
        Dice2 = diceTestResult.getDice2();
        Dice3 = diceTestResult.getDice3();
        DiceName = diceTestResult.getDiceName();
    }

}
