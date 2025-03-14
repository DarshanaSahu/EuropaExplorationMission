package com.maxhome.com.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Direction {

    L("Left"),
    R("Right"),
    M("Forward");

    private String movement;
}
