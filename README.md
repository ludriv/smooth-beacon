# Smooth Beacon for Android
Simple beacon observer for Android



All you need is:
- copy/paste classes presents in co.ludriv.smoothbeacon packages (files in demo package is not required)
- create your own Application class, make sure that extends SBApplication (don't forget to type this class name into AndroidManifest.xml file)
- add one or more regions in Application class:

```java
// SmartBeacon is a iBeacon french company, like RadiusNetwork and more.
// For more information about SmartBeacon, go to http://smartbeacon.eu

SmartBeaconProvider provider = new SmartBeaconProvider();

Region region = new Region("myRegion", Identifier.parse(provider.getProximityUuid()), null, null);

try {
  getBeaconManager().startMonitoringBeaconsInRegion(region);
  getBeaconManager().startRangingBeaconsInRegion(region);
} catch (RemoteException e) {
  Log.e(TAG, "An error occus on start monitor/range region!");
}
```

- set and register observer:

```java
private BroadcastReceiver mReceiver = new BroadcastReceiver() {
  @Override
  public void onReceive(Context context, Intent intent) {
    String action = intent.getAction();
    if (SBIntent.ON_ENTER_REGION_ACTION.equals(action)) {
      // on enter region!
    } else if (SBIntent.ON_EXIT_REGION_ACTION.equals(action)) {
      // on exit region!
    } else if (SBIntent.ON_CHANGE_PROXIMITY_ACTION.equals(action)) {
      // on change proximity!
    }
  }
};

registerReceiver(mReceiver, SBIntent.getSBIntentFilter());
// make sure you unregisterReceiver too
```

That's all!
