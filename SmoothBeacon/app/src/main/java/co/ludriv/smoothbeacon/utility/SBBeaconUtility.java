package co.ludriv.smoothbeacon.utility;

import org.altbeacon.beacon.Beacon;

/**
 * Created by Ludovic on 31/05/15.
 */
public final class SBBeaconUtility {

    public static final String getUniqueIDForBeacon(Beacon beacon) {
        return String.format("%s#%d#%d",
                beacon.getId1().toUuidString(), beacon.getId2().toInt(), beacon.getId3().toInt());
    }

}
