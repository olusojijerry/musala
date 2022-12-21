package com.musala.soft.entity.enumeration;

import java.util.ArrayList;
import java.util.List;

public enum StatusEnum {
    IDLE("IDLE"),
    LOADING("LOADING"),
    LOADED("LOADED"),
    DELIVERING("DELIVERING"),
    DELIVERED("DELIVERED"),
    RETURNING("RETURNING");

    private final String title;
    StatusEnum(String title) {
        this.title = title;
    }

    public List<String> getValues(){
        List<String> values = new ArrayList<>();

        for(StatusEnum p : StatusEnum.values()){
            values.add(p.title);
        }
        return values;
    }

    public String getValue(StatusEnum statusEnum){
        return statusEnum.title;
    }

    public static StatusEnum getEnumFromString(String text){
        for(StatusEnum t : StatusEnum.values()){
            if (t.title.equalsIgnoreCase(text)){
                return t;
            }
        }
        throw new IllegalArgumentException("No constant with text " + text + " found");
    }
}
