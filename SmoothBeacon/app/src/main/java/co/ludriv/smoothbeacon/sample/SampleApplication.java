package co.ludriv.smoothbeacon.sample;

import android.os.RemoteException;
import android.util.Log;

import org.altbeacon.beacon.Identifier;
import org.altbeacon.beacon.Region;

import co.ludriv.smoothbeacon.client.SBApplication;
import co.ludriv.smoothbeacon.provider.SmartBeaconProvider;

/**
 * Created by Ludovic on 29/05/15.
 */
public class SampleApplication extends SBApplication {

    private static final String TAG = "SampleApplication";

    /**
     * Sample region identifier
     */
    private static final String REGION_ID = "co.ludriv.smoothbeacon.sample.region";


    @Override
    public void onCreate() {
        super.onCreate();

        SmartBeaconProvider provider = new SmartBeaconProvider();

        /**
         * Region represented by all SmartBeacon's beacons
         */
        Region region = new Region(REGION_ID, Identifier.parse(provider.getProximityUuid()), null, null);

        try {
            getBeaconManager().startMonitoringBeaconsInRegion(region);
            getBeaconManager().startRangingBeaconsInRegion(region);
        } catch (RemoteException e) {
            Log.e(TAG, "An error occus on start monitor/range region!");
        }
    }

}
