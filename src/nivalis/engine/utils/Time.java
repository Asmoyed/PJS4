package nivalis.engine.utils;

/**
 * @author Esilff
 */
public class Time {

    public static double timer = 0.0;

    /**
     * Return the system time in seconds, is necessary to make calculations for animations and more.
     * @return time in seconds.
     */

    public static double getTime() {
        return (double)System.nanoTime() / 1000000000;
    }
    public static double timer() {
        timer += getTime();
        return timer;
    }
}
