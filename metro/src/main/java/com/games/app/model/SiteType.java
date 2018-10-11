package com.games.app.model;

/**
 * Created by wangdehao on 18/8/13.
 */
public class SiteType {

    private final String DEF_SHAPE = "+";
    private final char DEF_INITIAL = '+';
    private String type;
    private char initial;

    public SiteType(String type) {
        this.type = type;
        initial = type.charAt(0);
    }

    @Override
    public String toString() {
        return "SiteType{" +
                "type='" + type + '\'' +
                '}';
    }

    public SiteType() {
        type = DEF_SHAPE;
        initial = DEF_INITIAL;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public char getInitial() {
        return initial;
    }

    public void setInitial(char initial) {
        this.initial = initial;
    }
}
