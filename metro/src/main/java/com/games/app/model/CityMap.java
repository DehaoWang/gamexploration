package com.games.app.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by wangdehao on 18/8/13.
 */
// composited by Site
public class CityMap {

    private static final int WIDTH_PARAM = 3;
    private static final int HEIGHT_PARAM = 1;
    private Site[][] sites;
    private int len;
    private final String BLANK = " ";
    private int zoom = 1;
    private Set<Integer> siteTypeSet;

    public CityMap(int len, int zoom) {
        this.len = len;
        this.zoom = zoom;
        init();
    }

    private void init() {
        sites = new Site[len][len];
        siteTypeSet = new HashSet<Integer>();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                sites[i][j] = new Site();
            }
        }
    }

    public void view() {
        System.out.println("The CityMap");
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                String zoomBlank = "";
                for (int k = 0; k < zoom + WIDTH_PARAM; k++) {
                    zoomBlank += BLANK;
                }
                System.out.print(sites[i][j].getSiteTypeInitial() + zoomBlank);
            }
            for (int l = 0; l < zoom + HEIGHT_PARAM; l++) {
                System.out.println();
            }
        }
    }

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public int getZoom() {
        return zoom;
    }

    public void setZoom(int zoom) {
        this.zoom = zoom;
    }

    public void createSite(int x, int y, Site site) {
        sites[x][y]
        sites[x][y] = site;
    }
}
