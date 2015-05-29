package co.ludriv.smoothbeacon.provider;

/**
 * Created by Ludovic on 29/05/15.
 */
public class SmartBeaconProvider implements BeaconProvider {

    /**
     * Proximity UUID for beacons provided by SmartBeacon company.
     * For more information:
     * @see https://github.com/smartbeacon/smartbeacon-base-ios-sdk
     * @see http://www.smartbeacon.eu
     *
     * @return SmartBeacon proximity UUID
     */
    @Override
    public String getProximityUuid() {
        return "85FC11DD-4CCA-4B27-AFB3-876854BB5C3B";
    }

}
