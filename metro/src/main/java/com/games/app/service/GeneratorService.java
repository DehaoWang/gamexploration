package com.games.app.service;

import com.games.app.constants.TrainConstants;
import com.games.app.model.*;
import com.games.app.util.SiteTypeUtil;

import java.util.Random;

/**
 * Created by wangdehao on 18/8/13.
 */
public class GeneratorService implements Runnable {
    private int siteId = 0;

    private CityMap cityMap;

    public GeneratorService(CityMap cityMap) {
        this.cityMap = cityMap;
    }

    public void generateSite() {
        Random random = new Random();
        int x = random.nextInt(cityMap.getLen());
        int y = random.nextInt(cityMap.getLen());

        int s = SiteTypeUtil.getSiteTypeSize();
        int t = random.nextInt(s);
        SiteType siteType = SiteTypeUtil.getType(t);

        Site site = new Site(x, y, siteType, siteId);
        siteId++;

        cityMap.createSite(x, y, site);
    }

    public void generatePassenger() {
        Passenger passenger = new Passenger();
        // assign to a site
        Random random = new Random();
        int toSiteId = random.nextInt(siteId + 1);
        cityMap.addPassengerToSite(passenger, siteId);
    }

    public void generateTrain() {
        Train train = new Train(TrainConstants.DEF_CAPACITY);

    }

    public void run() {
        try {
            while (true) {
                generateSite();
                Thread.sleep(10000);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
