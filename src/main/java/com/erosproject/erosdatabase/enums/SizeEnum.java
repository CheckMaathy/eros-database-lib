package com.erosproject.erosdatabase.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Arrays;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum SizeEnum {

    S("Small"),
    M("Medium"),
    L("Large"),
    XG("Extra Large"),
    ND("Not Defined");

    private String name;

    public static SizeEnum sizeDefinition(String name) {
        return Arrays.stream(SizeEnum.values()).filter(size -> size.name().equals(name)).findFirst().orElse(SizeEnum.ND);
    }
}
