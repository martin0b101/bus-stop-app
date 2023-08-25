package Core;

import Common.Utils;
import Model.Calandar;

import java.util.ArrayList;
import java.util.List;

public class GFTSDataReader {

    private final String SEPERATOR = ",";

    public List<Calandar> readCalendarData(String path){

        // returns List of strings
        // service_id,monday,tuesday,wednesday,thursday,friday,saturday,sunday,start_date,end_date
        List<Calandar> calendarData = new ArrayList<>();
        List<String> calendarDateList = Utils.readFile(path);
        calendarDateList.remove(0);
        calendarDateList.forEach(row -> {
            Calandar calendar = new Calandar();
            String[] data = row.split(SEPERATOR);
            calendar.setServiceId(data[0]);
            calendar.setMonday(Integer.parseInt(data[1]));
            calendar.setTuesday(Integer.parseInt(data[2]));
            calendar.setWednesday(Integer.parseInt(data[3]));
            calendar.setThursday(Integer.parseInt(data[4]));
            calendar.setFirday(Integer.parseInt(data[5]));
            calendar.setSaturday(Integer.parseInt(data[6]));
            calendar.setSunday(Integer.parseInt(data[7]));
            calendar.setStartDate(data[8]);
            calendar.setEndDate(data[9]);
            calendarData.add(calendar);
        });

        return calendarData;
    }

    public void readAgencyData(String path){

    }

    public void readRoutesData(String path){

    }

    public void readStopsData(String path){

    }

    public void StopTimeData(String path){

    }

    public void TripsData(String path){

    }

}
