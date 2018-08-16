package com.games.app.service;

import com.games.app.model.CityMap;
import com.games.app.model.Site;
import com.games.app.model.SiteType;
import com.games.app.util.SiteTypeUtil;

import java.util.Random;

/**
 * Created by wangdehao on 18/8/13.
 */
public class GeneratorService implements Runnable{

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
        Site site = new Site(x, y, siteType);

        cityMap.createSite(x, y, site);
    }

    public void generatePassenger() {

    }

    public void run() {
        try {
            while (true) {
                generateSite();
                Thread.sleep(3000);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
