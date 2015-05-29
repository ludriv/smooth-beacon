package co.ludriv.smoothbeacon.distance;

import org.altbeacon.beacon.Beacon;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Ludovic on 29/05/15.
 */
public class SBDistanceFilter {

    private static final int MAX_PROXIMITY_SIZE = 5;

    private HashMap<String, ArrayList<Integer>> mEntries;

    private static SBDistanceFilter instance;

    public static SBDistanceFilter getFilter() {
        if (instance == null) {
            instance = new SBDistanceFilter();
        }
        return instance;
    }

    private SBDistanceFilter() {
        mEntries = new HashMap<>();
    }

    public void put(Beacon beacon, Integer proximityValue) {
        String refId = getKeyForBeacon(beacon);

        if (!mEntries.containsKey(refId)) {
            mEntries.put(refId, new ArrayList<Integer>());
        }
        mEntries.get(refId).add(proximityValue);
        if (mEntries.get(refId).size() > MAX_PROXIMITY_SIZE) {
            mEntries.get(refId).remove(0);
        }
    }

    public SBProximity getSmoothDistance(String refId) {

        float unknownCount = 0, farCount = 0, nearCount = 0, immediateCount = 0;
        float coeff = 1;

        if (mEntries.containsKey(refId)) {
            for (Integer entry : mEntries.get(refId)) {
                if (SBProximity.IMMEDIATE.getValue() == entry) {
                    immediateCount += coeff;
                } else if (SBProximity.NEAR.getValue() == entry) {
                    nearCount += coeff;
                } else if (SBProximity.FAR.getValue() == entry) {
                    farCount += coeff;
                } else {
                    unknownCount += coeff;
                }
                coeff += 0.2f;
            }
        }

        float max = Math.max(Math.max(unknownCount, farCount), Math.max(nearCount, immediateCount));

        if (max == farCount) {
            return SBProximity.FAR;
        } else if (max == nearCount) {
            return SBProximity.NEAR;
        } else if (max == immediateCount) {
            return SBProximity.IMMEDIATE;
        }
        return SBProximity.UNKNOWN;
    }

    private static final String getKeyForBeacon(Beacon beacon) {
        return String.format("%s#%d#%d",
                beacon.getId1().toUuidString(), beacon.getId2().toInt(), beacon.getId3().toInt());
    }
}
