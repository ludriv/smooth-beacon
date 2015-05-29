package co.ludriv.smoothbeacon.client;

import android.app.Application;
import android.util.Log;

import org.altbeacon.beacon.Beacon;
import org.altbeacon.beacon.BeaconConsumer;
import org.altbeacon.beacon.BeaconManager;
import org.altbeacon.beacon.MonitorNotifier;
import org.altbeacon.beacon.RangeNotifier;
import org.altbeacon.beacon.Region;

import java.util.Collection;

/**
 * Created by Ludovic on 29/05/15.
 */
public class SBApplication extends Application implements BeaconConsumer {

    private static final String TAG = "SBApplication";

    private BeaconManager mBeaconManager;


    @Override
    public void onCreate() {
        super.onCreate();
        mBeaconManager = BeaconManager.getInstanceForApplication(this);
        mBeaconManager.bind(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        mBeaconManager.unbind(this);
    }

    @Override
    public void onBeaconServiceConnect() {
        mBeaconManager.setMonitorNotifier(new MonitorNotifier() {
            @Override
            public void didEnterRegion(Region region) {
                Log.d(TAG, String.format("Did enter in region: %s", region));
            }

            @Override
            public void didExitRegion(Region region) {
                Log.d(TAG, String.format("Did exit from region: %s", region));
            }

            @Override
            public void didDetermineStateForRegion(int i, Region region) {

            }
        });

        mBeaconManager.setRangeNotifier(new RangeNotifier() {
            @Override
            public void didRangeBeaconsInRegion(Collection<Beacon> beacons, Region region) {
                Log.d(TAG, String.format("Did range %d beacons in region: %s", beacons.size(), region));
            }
        });
    }

    protected BeaconManager getBeaconManager() {
        return mBeaconManager;
    }
}
