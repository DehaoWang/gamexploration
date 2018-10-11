package com.games.app.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangdehao on 18/10/9.
 */
public class Route {
    private int routeId;
    private boolean cycled = false;
    private List<Site> sites = new ArrayList<Site>();
    private List<Train> trains = new ArrayList<Train>();

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public boolean isCycled() {
        return cycled;
    }

    public void setCycled(boolean cycled) {
        this.cycled = cycled;
    }

    public List<Site> getSites() {
        return sites;
    }

    public void setSites(List<Site> sites) {
        this.sites = sites;
    }

    public void addSite(Site site) {
        sites.add(site);
    }

    public void addTrain(Train train, Site site0, boolean b) {
        trains.add(train);
    }
}
