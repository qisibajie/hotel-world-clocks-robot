package com.wubinben.katas.bdd.robot;


/**
 * A concrete observer.
 * User: Ben
 * Date: 13-9-8
 * Time: 下午10:56
 * To change this template use File | Settings | File Templates.
 */
public class Beijing extends CityObserver {
    private static final BenLogger LOGGER = BenLogger.getLogger(BenLogger.LEVEL_OFF);
    private static final int UTC_OFFSET = 8;

    private Beijing(DaylightSavingTime dstStatus, TimeSubject timeSubject) {
        super(timeSubject, dstStatus);
    }

    public static Beijing newInstance(DaylightSavingTime dstStatus, TimeSubject timeSubject) {
        return new Beijing(dstStatus, timeSubject);
    }

    @Override
    public void setTimeToTimeSubject(int localHour) {
        LOGGER.info("in Beijing.setTimeToTimeSubject().");
        LOGGER.info("localHour: " + localHour);
        super.localHour = localHour;
        super.timeSubject.setHourUtcZero(convertLocalTimeToUtcZeroTime(super.localHour,
                Beijing.UTC_OFFSET, super.dstStatus));
    }

    @Override
    public void updateTimeOfCity(int hourUtcZero) {
        LOGGER.info("in Beijing.updateTimeOfCity()");
        LOGGER.info("hourUtcZero: " + hourUtcZero);
        super.localHour = convertUtcZeroTimeToLocalTime(hourUtcZero, Beijing.UTC_OFFSET, super.dstStatus);
    }

    @Override
    public String getLocalHour() {
        LOGGER.info("in Beijing.getLocalHour().");
        LOGGER.info("this.localHour: " + super.localHour);
        return Integer.toString(super.localHour);
    }

}
