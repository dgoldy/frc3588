/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc3588.RobotBuilder2.sensor;

import edu.wpi.first.wpilibj.AnalogChannel;

/**
 *
 * @author davegoldy
 */
public class MaxbotixUltrasonic
{

    private final double IN_TO_CM_CONVERSION = 2.54;
    private final double CONVERT_TO_INCH = .00976563;
    private boolean fUseUnits;    //Are we using units or just returning voltage?
    private double fMinVoltage;	  //Minimum voltage the ultrasonic sensor can return
    private double fVoltageRange; //The range of the voltages returned by the sensor (maximum - minimum)
    private double fMinDistance;  //Minimum distance the ultrasonic sensor can return in inches
    private double fDistanceRange;//The range of the distances returned by this class in inches (maximum - minimum)
    private final AnalogChannel fAnalogChannel;

    //constructor
    public MaxbotixUltrasonic(int channel)
    {
        fAnalogChannel = new AnalogChannel(1, channel);
        //default values
        fUseUnits = true;
        fMinVoltage = .0;
        fVoltageRange = 5.0 - fMinVoltage;
        fMinDistance = 3.0;
        fDistanceRange = 60.0 - fMinDistance;
    }

    //constructor
    public MaxbotixUltrasonic(int channel, boolean use_units,
            double min_voltage,
            double max_voltage, double min_distance, double max_distance)
    {
        fAnalogChannel = new AnalogChannel(1, channel);
        //only use unit-specific variables if we're using units
        if (use_units)
        {
            fUseUnits = true;
            fMinVoltage = min_voltage;
            fVoltageRange = max_voltage - min_voltage;
            fMinDistance = min_distance;
            fDistanceRange = max_distance - min_distance;
        }
    }

    /*
     * Just get the voltage.
     */
    public double getVoltage()
    {
        return fAnalogChannel.getVoltage();
    }

    /*
     * Just get the average voltage.
     */
    public double getAverageVoltage()
    {
        return fAnalogChannel.getAverageVoltage();
    }

    /* GetRangeInInches
     * Returns the range in inches
     * Returns -1.0 if units are not being used
     * Returns -2.0 if the voltage is below the minimum voltage
     */
    public double getRangeInInches()
    {
        double range;
        //if we're not using units, return -1, a range that will most likely never be returned
        if (!fUseUnits)
        {
            return -1.0;
        }
        range = getAverageVoltage();
        if (range < fMinVoltage)
        {
            return -2.0;
        }
        range = range / CONVERT_TO_INCH;
        return range;
    }
    /* GetRangeInCM
     * Returns the range in centimeters
     * Returns -1.0 if units are not being used
     * Returns -2.0 if the voltage is below the minimum voltage
     */

    public double getRangeInCm()
    {
        double range;
        //if we're not using units, return -1, a range that will most likely never be returned
        if (!fUseUnits)
        {
            return -1.0;
        }
        range = fAnalogChannel.getAverageVoltage();
        if (range < fMinVoltage)
        {
            return -2.0;
        }
        range = getRangeInInches() * IN_TO_CM_CONVERSION;
        return range;
    }
}
