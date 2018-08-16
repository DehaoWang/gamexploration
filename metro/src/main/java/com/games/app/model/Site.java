package com.games.app.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by wangdehao on 18/8/13.
 */
public class Site {


    private SiteType siteType;
    private Set<Passenger> passengerSet = new HashSet<Passenger>();
    private int x;
    private int y;
    private boolean occupied = false;

    public Site(int x, int y, SiteType siteType) {
        this.x = x;
        this.y = y;
        this.siteType = siteType;
    }

    public Site() {
        siteType = new SiteType();
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
}
