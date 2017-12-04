package com.wubinben.katas.bdd.robot;

/**
 * A concrete observer.
 * User: Ben
 * Date: 13-9-8
 * Time: 下午11:15
 * To change this template use File | Settings | File Templates.
 */
public class Sydney extends CityObserver {

    private static final int UTC_OFFSET = 10;

    private Sydney(DaylightSavingTime dstStatus, TimeSubject timeSubject) {
        super(timeSubject, dstStatus);
    }

    public static Sydney newInstance(DaylightSavingTime dstStatus, TimeSubject timeSubject) {
        return new Sydney(dstStatus, timeSubject);
    }

    @Override
    public void setTimeToTimeSubject(int localHour) {
        super.localHour = localHour;
        super.timeSubject.setHourUtcZero(convertLocalTimeToUtcZeroTime(super.localHour,
                Sydney.UTC_OFFSET, super.dstStatus));
    }

    @Override
    public void updateTimeOfCity(int hourUtcZero) {
        super.localHour = convertUtcZeroTimeToLocalTime(hourUtcZero, Sydney.UTC_OFFSET, super.dstStatus);
    }

    @Override
    public String getLocalHour() {
        return Integer.toString(super.localHour);
    }
}
