package com.north.pojo;

import lombok.Data;

import java.util.List;
@Data
public class RequestJsonForm {
    private String location;
    private List<DiceTestResult> txns;

}
