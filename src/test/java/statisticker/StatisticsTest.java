package statisticker;

import static org.junit.Assert.*;
import jdk.nashorn.internal.AssertsEnabled;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import org.junit.Test;

public class StatisticsTest 
{
    @Test
    public void reportsAverageMinMaxx()
    {
        Float[] numbers = {1.5f, 8.9f, 3.2f, 4.5f};
        List<____> numberList = Arrays.asList(numbers);

        Stats s = Statistics.getStatistics(numberList);

        float epsilon = 0.001f;
        assertEquals(s.getAverage(), 4.525f, epsilon);
        assertEquals(s.getMin(), 1.5f, epsilon);
       assertEquals(s.getMax(), 8.9f, epsilon);
    }
    @Test
    public void reportsNaNForEmptyInput()
    {
        List<Float> emptyList = new ArrayList<Float>();

        Stats s = Statistics.getStatistics(emptyList);
        float epsilon = 0.001f;
        assertEquals(s.getAverage(), Float.NaN, epsilon);
        assertEquals(s.getMax(), Float.NaN, epsilon);
        assertEquals(s.getMin(), Float.NaN, epsilon);

    }
    @Test
    public void reportsAlertsIfMaxIsMoreThanThreshold()
    {
        EmailAlert emailAlerter = new EmailAlert();
        LEDAlert ledAlerter = new LEDAlert();
        float maxThreshold = 10.2f;
        StatsChecker checker = new StatsChecker(maxThreshold, emailAlerter , ledAlerter);

        Float[] numbers = {11.5f, 6.9f, 7.5f, 6.6f};
        List<Float> numberList = Arrays.asList(numbers);
        checker.checkAndAlert(numberList);
        
        assertTrue(emailAlerter.emailSent);
        assertTrue(ledAlerter.ledGlows);
    }
}
