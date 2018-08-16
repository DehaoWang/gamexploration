package com.games.app.service;

import com.games.app.model.CityMap;

/**
 * Created by wangdehao on 18/8/13.
 */
public class ViewService implements Runnable {
    private CityMap cityMap;
    public ViewService(CityMap cityMap) {
        this.cityMap = cityMap;
    }

    public void run() {
        try {
            cityMap.view();
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
