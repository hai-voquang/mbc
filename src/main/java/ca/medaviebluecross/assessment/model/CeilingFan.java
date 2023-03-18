package ca.medaviebluecross.assessment.model;

import ca.medaviebluecross.assessment.utils.CommonUtils;
import org.springframework.stereotype.Component;

/**
 * Simple class to implement the functions of a ceiling fan.
 */
@Component
public class CeilingFan {
    public static final int SPEED_OFF = 0;
    private int speed;
    private Direction direction;

    public CeilingFan() {
        this.speed = 0;
        this.direction = Direction.FORWARD;
    }

    /**
     * Method to change the speed. <br/>
     * There are 3 speed settings, and an “off” (speed 0) setting. <br/>
     * If the cord is pulled on speed 3, the fan returns to the “off” setting. <br/>
     * The ceiling fan should be “off” on December 25th all day.
     */
    public void pullCordToChangeSpeed() {
        if (CommonUtils.isOffDay()) return;

        if (speed == 3) {
            speed = SPEED_OFF;
        } else {
            speed++;
        }
    }

    /**
     * Method to change the direction. <br/>
     * Once the direction has been reversed, it remains reversed as we cycle through the speed settings, until reversed again. <br/>
     * The ceiling fan should be “off” on December 25th all day.
     */
    public void pullCordToChangeDirection() {
        if (CommonUtils.isOffDay()) return;
        this.direction = (this.direction == Direction.REVERSE) ? Direction.FORWARD : Direction.REVERSE;
    }

    public int getSpeed() {
        return speed;
    }

    public Direction getDirection() {
        return direction;
    }

    public boolean isOff() {
        return speed == SPEED_OFF;
    }

    public enum Direction {
        FORWARD, REVERSE
    }
}
