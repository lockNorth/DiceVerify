package com.north.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class DataRedBlueSicboDice {
    private String GameType;
    private Date TrainingDate;
    private Integer RoundID;
    private Integer Dice1;
    private Integer Dice2;
    private String DiceName;

    public DataRedBlueSicboDice(DiceTestResult diceTestResult) {
        GameType = diceTestResult.getGameType();
        TrainingDate = diceTestResult.getTrainingDate();
        RoundID = diceTestResult.getRoundID();
        Dice1 = diceTestResult.getDice1();
        Dice2 = diceTestResult.getDice2();
        DiceName = diceTestResult.getDiceName();
    }
}
