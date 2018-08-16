package com.games.app.util;

import com.games.app.model.SiteType;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangdehao on 18/8/13.
 */


public class SiteTypeUtil {

    private static Map<Integer, SiteType> int2SiteType = new HashMap<Integer, SiteType>();

    static {
        int2SiteType.put(0, new SiteType("Square"));
        int2SiteType.put(1, new SiteType("Circle"));
        int2SiteType.put(2, new SiteType("Triangle"));
    }

    public static SiteType getType(int t) {
        return int2SiteType.get(t);
    }

    public static int getSiteTypeSize() {
        return int2SiteType.size();
    }
}
