package system;

import framework.FilterTemplate;
import framework.MeasurementContext;
import util.ConversionUtil;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author Weinan Qiu
 * @since 1.0.0
 */
public class TimeConvertingFilter extends FilterTemplate {

    private String dateFormat = "yyyy:dd:hh:mm:ss";

    public TimeConvertingFilter(String filterId, MeasurementContext context) {
        super(context, filterId);
    }

    @Override
    protected byte[] doTransform(int id, byte[] measurement) {
        if (id != MeasurementContext.ID_TIME)
            return measurement;

        long time = ConversionUtil.convertToLong(measurement);
        String formattedTime = new SimpleDateFormat(dateFormat).format(new Date(time));

        return Arrays.copyOf(formattedTime.getBytes(), 16);
    }

    public String getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }
}