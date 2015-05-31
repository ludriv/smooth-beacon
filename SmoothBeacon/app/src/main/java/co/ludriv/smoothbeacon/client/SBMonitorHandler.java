package co.ludriv.smoothbeacon.client;

import android.content.Context;
import android.content.Intent;

import org.altbeacon.beacon.Region;

/**
 * Created by Ludovic on 31/05/15.
 */
final class SBMonitorHandler {

    public static final void handleEnterInRegion(Context context, Region region) {
        Intent intent = SBIntent.createOnEnterRegionIntent(region);
        context.sendBroadcast(intent);
    }

    public static final void handleExitRegion(Context context, Region region) {
        Intent intent = SBIntent.createOnExitRegionIntent(region);
        context.sendBroadcast(intent);
    }
}
