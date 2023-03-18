package ca.medaviebluecross.assessment.model;

import ca.medaviebluecross.assessment.utils.CommonUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CeilingFanTest {
    private CeilingFan ceilingFan;

    @BeforeEach
    void setUp() {
        ceilingFan = new CeilingFan();
    }

    @Test
    void pullCordToIncreaseSpeed() {
        try (MockedStatic<CommonUtils> mockedCommonUtils = Mockito.mockStatic(CommonUtils.class)) {
            mockedCommonUtils.when(CommonUtils::isOffDay).thenReturn(false);

            ceilingFan.pullCordToChangeSpeed();
            assertEquals(1, ceilingFan.getSpeed());

            ceilingFan.pullCordToChangeSpeed();
            assertEquals(2, ceilingFan.getSpeed());

            ceilingFan.pullCordToChangeSpeed();
            assertEquals(3, ceilingFan.getSpeed());

            ceilingFan.pullCordToChangeSpeed();
            assertEquals(CeilingFan.SPEED_OFF, ceilingFan.getSpeed());
            assertTrue(ceilingFan.isOff());

            ceilingFan.pullCordToChangeSpeed();
            assertEquals(1, ceilingFan.getSpeed());
        }
    }

    @Test
    void pullCordToReverseDirection() {
        try (MockedStatic<CommonUtils> mockedCommonUtils = Mockito.mockStatic(CommonUtils.class)) {
            mockedCommonUtils.when(CommonUtils::isOffDay).thenReturn(false);
            ceilingFan.pullCordToChangeDirection();
            assertEquals(CeilingFan.Direction.REVERSE, ceilingFan.getDirection());

            ceilingFan.pullCordToChangeSpeed();
            assertEquals(CeilingFan.Direction.REVERSE, ceilingFan.getDirection());

            ceilingFan.pullCordToChangeDirection();
            assertEquals(CeilingFan.Direction.FORWARD, ceilingFan.getDirection());

            ceilingFan.pullCordToChangeDirection();
            assertEquals(CeilingFan.Direction.REVERSE, ceilingFan.getDirection());
        }
    }

    @Test
    void testFanOffOnSpecificDay() {
        try (MockedStatic<CommonUtils> mockedCommonUtils = Mockito.mockStatic(CommonUtils.class)) {
            mockedCommonUtils.when(CommonUtils::isOffDay).thenReturn(true);

            ceilingFan.pullCordToChangeSpeed();
            assertEquals(0, ceilingFan.getSpeed());

            ceilingFan.pullCordToChangeDirection();
            assertEquals(0, ceilingFan.getSpeed());

        }
    }

}