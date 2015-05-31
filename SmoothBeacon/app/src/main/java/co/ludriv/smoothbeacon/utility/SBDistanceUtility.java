package co.ludriv.smoothbeacon.utility;

import org.altbeacon.beacon.Beacon;

import co.ludriv.smoothbeacon.distance.SBProximity;

/**
 * Created by Ludovic on 31/05/15.
 */
public final class SBDistanceUtility {

    public static final SBProximity getProximityForBeacon(Beacon beacon) {
        double distance = beacon.getDistance();
        if (distance <= SBProximity.IMMEDIATE_DISTANCE.getValue()) {
            return SBProximity.IMMEDIATE;
        } else if (distance <= SBProximity.NEAR_DISTANCE.getValue()) {
            return SBProximity.NEAR;
        } else if (distance <= SBProximity.FAR_DISTANCE.getValue()) {
            return SBProximity.FAR;
        }
        return SBProximity.UNKNOWN;
    }

}
