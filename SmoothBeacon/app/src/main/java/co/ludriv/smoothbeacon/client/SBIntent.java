package co.ludriv.smoothbeacon.client;

import android.content.Intent;

import org.altbeacon.beacon.Beacon;

import co.ludriv.smoothbeacon.distance.SBProximity;

/**
 * Created by Ludovic on 31/05/15.
 */
public final class SBIntent {

    public static final String BEACON_KEY = "idk.beacon";
    public static final String FROM_PROXIMITY_KEY = "idk.from_proximity";
    public static final String TO_PROXIMITY_KEY = "idk.to_proximity";

    public static final String ON_CHANGE_PROXIMITY_ACTION = "co.ludriv.smoothbeacon.action.change_proximity";

    public static final Intent createOnChangeProximityIntent(Beacon forBeacon, SBProximity from, SBProximity to) {
        Intent intent = new Intent(ON_CHANGE_PROXIMITY_ACTION);
        intent.putExtra(BEACON_KEY, forBeacon);
        intent.putExtra(FROM_PROXIMITY_KEY, from.getValue());
        intent.putExtra(TO_PROXIMITY_KEY, to.getValue());
        return intent;
    }

}
