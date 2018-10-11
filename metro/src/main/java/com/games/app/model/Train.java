package com.games.app.model;

import com.games.app.constants.TrainConstants;

import java.util.List;
import java.util.Set;

/**
 * Created by wangdehao on 18/8/16.
 */
public class Train {
    private int capacity = 6;
    private int timePerStep = 500;
    private List<Passenger> passengerList;
//    private List<Site> route;
    private Route route;
    private Set<Character> visitSiteInits;
    private int currPosition;
    private boolean clockwise;

    public Train() {
        this.capacity = TrainConstants.DEF_CAPACITY;
        this.timePerStep = TrainConstants.TIME_PER_STEP;
    }


    public void init() {
        List<Site> sites = route.getSites();
        for (Site site : sites) {
            char type = site.getSiteTypeInitial();
            visitSiteInits.add(type);
        }
    }

    public void move(boolean clockwise, int currPosition){
        if(clockwise) {
            // move to next site from left to right
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
