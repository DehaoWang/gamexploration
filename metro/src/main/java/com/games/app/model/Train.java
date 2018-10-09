package com.games.app.model;

import java.util.List;
import java.util.Set;

/**
 * Created by wangdehao on 18/8/16.
 */
public class Train {
    private int capacity = 0;
    private List<Passenger> passengerList;
    private List<Site> route;
    private Set<Character> visitSiteInits;

    public Train(int capacity) {
        this.capacity = capacity;
    }

    public void init() {
        for (Site site : route) {
            char type = site.getSiteTypeInitial();
            visitSiteInits.add(type);
        }
    }

    public void passengersGetOff(Site site) {
        char type = site.getSiteTypeInitial();
        for (Passenger passenger : passengerList) {
            if (passenger.getSiteType().getInitial() == type) {
                // get off
            }
        }
    }

    public void passengersGetOn(Site site) {
        Set<Passenger> passengers = site.getPassengerSet();
        for (Passenger passenger : passengers) {
            char type = passenger.getSiteType().getInitial();
            if (visitSiteInits.contains(type)) {
                // get on
            }
        }
    }
}
