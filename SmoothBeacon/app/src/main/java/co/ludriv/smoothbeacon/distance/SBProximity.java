package co.ludriv.smoothbeacon.distance;

/**
 * Created by Ludovic on 29/05/15.
 */
public enum SBProximity {

    /**
     * Distance for range (in meters)
     */
    FAR_DISTANCE(50),
    NEAR_DISTANCE(10),
    IMMEDIATE_DISTANCE(1),

    /**
     * Constant values according to Apple iBeacon system
     */
    FAR(3),
    NEAR(2),
    IMMEDIATE(1),
    UNKNOWN(0);

    private int mValue;

    SBProximity(int value) {
        mValue = value;
    }

    public int getValue() {
        return mValue;
    }

}
