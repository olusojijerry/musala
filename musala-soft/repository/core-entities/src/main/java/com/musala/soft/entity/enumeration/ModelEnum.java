package com.musala.soft.entity.enumeration;

import java.util.ArrayList;
import java.util.List;

public enum ModelEnum {
    Lightweight("Lightweight"),
    Middleweight("Middleweight"),
    Cruiserweight("Cruiserweight"),
    Heavyweight("Heavyweight");

    private final String title;
    ModelEnum(String title) {
        this.title = title;
    }

    public List<String> getValues(){
        List<String> values = new ArrayList<>();

        for(ModelEnum p : ModelEnum.values()){
            values.add(p.title);
        }
        return values;
    }

    public String getValue(ModelEnum modelEnum){
        return modelEnum.title;
    }

    public static ModelEnum getEnumFromString(String text){
        for(ModelEnum t : ModelEnum.values()){
            if (t.title.equalsIgnoreCase(text)){
                return t;
            }
        }
        throw new IllegalArgumentException("No constant with text " + text + " found");
    }
}
