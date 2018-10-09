package com.games.app;

import com.games.app.model.CityMap;
import com.games.app.service.GeneratorService;
import com.games.app.service.ViewService;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello World: metro!");

        CityMap cityMap = new CityMap(9, 1);

        GeneratorService generatorService = new GeneratorService(cityMap);
        Thread gsThread = new Thread(generatorService);
        gsThread.start();

        while (true){
            cityMap.view();
            cityMap.dashboard();
            Thread.sleep(300);
        }
    }
}
