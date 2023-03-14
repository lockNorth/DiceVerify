package com.north.pojo;

import lombok.Data;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Data
public class DiceTestResult {
    private String GameType;
    private Date TrainingDate;
    private Integer RoundID;
    private Integer Dice1;
    private Integer Dice2;
    private Integer Dice3;
    private Integer Dice4;
    private Integer Dice5;
    private Integer Dice6;
    private String DiceName;

    public void setTrainingDate(String trainingDate) {
        try {
            TrainingDate = new java.util.Date(new SimpleDateFormat("yyyy-MM-dd").parse(trainingDate.replace('_', '-')).getTime());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }




}
