package com.games.app.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by wangdehao on 18/8/13.
 */
public class Site {
    private int siteId;
    private SiteType siteType;
    private Set<Passenger> passengerSet = new HashSet<Passenger>();
    private int x;
    private int y;
    private boolean occupied = false;
    private Map<Character, Integer> type2Num = new HashMap<Character, Integer>();

    public Site(int x, int y, SiteType siteType, int siteId) {
        this.x = x;
        this.y = y;
        this.siteType = siteType;
        this.siteId = siteId;
    }

    public Site() {
        siteType = new SiteType();
    }

    public Site(int x, int y, SiteType siteType) {
        this.x = x;
        this.y = y;
        this.siteType = siteType;
    }

    public Site(int x, int y, String type) {
        this.x = x;
        this.y = y;
        this.siteType = new SiteType(type);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Map<Character, Integer> getType2Num() {
        return type2Num;
    }

    public void setType2Num(Map<Character, Integer> type2Num) {
        this.type2Num = type2Num;
    }

    public char getSiteTypeInitial() {
        return siteType.getInitial();
    }

    public SiteType getSiteType() {
        return siteType;
    }

    public void setSiteType(SiteType siteType) {
        this.siteType = siteType;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public int getSiteId() {
        return siteId;
    }

    public void setSiteId(int siteId) {
        this.siteId = siteId;
    }

    public Set<Passenger> getPassengerSet() {
        return passengerSet;
    }

    public void setPassengerSet(Set<Passenger> passengerSet) {
        this.passengerSet = passengerSet;
    }

    public void addPassenger(Passenger passenger) {
        passengerSet.add(passenger);
    }

    public String getSiteInfo() {
        clear();
        calculate();
        String basic = String.format("SiteId: %d, SiteType: %s, PassengerNum: %d", siteId, siteType, passengerSet.size());
        if (type2Num.size() > 0) {
            String distribution = ", Distribution: ";
            for (Character type : type2Num.keySet()) {
                distribution += type + "-" + type2Num.get(type) + ", ";
            }
            basic += distribution;
        }
        return basic;
    }

    public void calculate() {
        for (Passenger passenger : passengerSet) {
            char type = passenger.getSiteType().getInitial();
            Integer num = type2Num.get(type);
            if (num == null) {
                type2Num.put(type, 1);
            } else {
                type2Num.put(type, num + 1);
            }
        }
    }

    public void clear() {
        for (Character type : type2Num.keySet()) {
            type2Num.put(type, 0);
        }
    }
}
