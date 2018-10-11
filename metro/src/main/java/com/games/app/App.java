package com.games.app;

import com.games.app.constants.TrainConstants;
import com.games.app.model.*;
import com.games.app.service.GeneratorService;
import com.games.app.service.ViewService;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello World: metro!");

        CityMap cityMap = new CityMap(9, 1);

        boolean man = true;

        if (man) {
            // Mode Manual
            Site site0 = new Site(3, 5, "Square");
            Site site1 = new Site(4, 7, "Triangle");
            Site site2 = new Site(6, 2, "Circle");

            cityMap.createSiteMan(site0);
            cityMap.createSiteMan(site1);
            cityMap.createSiteMan(site2);

            cityMap.addPassengerToSite(new Passenger(new SiteType("T")), 0);
            cityMap.addPassengerToSite(new Passenger(new SiteType("C")), 0);
            cityMap.addPassengerToSite(new Passenger(new SiteType("C")), 0);

            Route route = new Route();
            route.addSite(site0);
            route.addSite(site1);
            route.addSite(site2);
            Train train = new Train();
            route.addTrain(train, site0, true);
//            train.start();

        } else {
            // Mode Auto
            GeneratorService generatorService = new GeneratorService(cityMap);
            Thread gsThread = new Thread(generatorService);
            gsThread.start();

        }


        while (true) {
            cityMap.view();
            cityMap.dashboard();
            Thread.sleep(300);
        }
    }
}
