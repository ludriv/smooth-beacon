package co.ludriv.smoothbeacon.client;

import android.content.Context;
import android.content.Intent;

import org.altbeacon.beacon.Beacon;

import java.util.Collection;

import co.ludriv.smoothbeacon.distance.SBDistanceFilter;
import co.ludriv.smoothbeacon.distance.SBProximity;
import co.ludriv.smoothbeacon.utility.SBBeaconUtility;
import co.ludriv.smoothbeacon.utility.SBDistanceUtility;

/**
 * Created by Ludovic on 31/05/15.
 */
final class SBRangeHandler {

    public static final void handleRangeBeacons(Context context, Collection<Beacon> beacons) {
        for (Beacon beacon : beacons) {
            final String uniqueID = SBBeaconUtility.getUniqueIDForBeacon(beacon);

            SBDistanceFilter filter = SBDistanceFilter.getFilter();
            SBProximity oldProximity = filter.getSmoothProximity(uniqueID);
            filter.put(beacon, SBDistanceUtility.getProximityForBeacon(beacon).getValue());
            SBProximity newProximity = filter.getSmoothProximity(uniqueID);

            if (oldProximity.getValue() != newProximity.getValue()) {
                Intent intent = SBIntent.createOnChangeProximityIntent(beacon, oldProximity, newProximity);
                context.sendBroadcast(intent);
            }
        }
    }

}
