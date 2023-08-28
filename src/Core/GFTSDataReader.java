package Core;
import Common.Utils;
import Model.*;
import java.util.ArrayList;
import java.util.List;

public class GFTSDataReader {

    private static final String SEPERATOR = ",";

    public List<Calandar> readCalendarData(String path){

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

    public List<Agency> readAgencyData(String path){

        // agency_id,agency_name,agency_url,agency_timezone,agency_lang,agency_phone,agency_fare_url

        List<Agency> agencyList = new ArrayList<>();
        List<String> agencyData = Utils.readFile(path);
        agencyData.remove(0);
        agencyData.forEach(row -> {
            Agency agency = new Agency();
            String[] data = row.split(SEPERATOR);
            agency.setAgencyId(data[0]);
            agency.setAgencyName(data[1]);
            agency.setAgencyUrl(data[2]);
            agency.setAgencyTimeZone(data[3]);
            agency.setAgencyLang(data[4]);
            agency.setAgencyPhone(data[5]);
            agency.setAgencyFareUrl("");
            agencyList.add(agency);
        });
        return agencyList;
    }

    public List<Routes> readRoutesData(String path){
        //    0        1           2                3             4          5         6         7             8
        // route_id,agency_id,route_short_name,route_long_name,route_desc,route_type,route_url,route_color,route_text_color
        List<Routes> routesList = new ArrayList<>();
        List<String> routesReadData = Utils.readFile(path);
        routesReadData.remove(0);
        routesReadData.forEach(row -> {
            Routes routes = new Routes();
            String[] data = row.split(SEPERATOR);
            routes.setRouteId(data[0]);
            routes.setRouteShortName(data[2]);
            routes.setRouteLongName(data[3]);
            routes.setRouteType(data[5]);
            routesList.add(routes);
        });
        return routesList;
    }

    public List<Stops> readStopsData(String path){
        //    0       1         2         3         4         5       6        7        8             9              10             11
        // stop_id,stop_code,stop_name,stop_desc,stop_lat,stop_lon,zone_id,stop_url,location_type,parent_station,stop_timezone,wheelchair_boarding

        List<Stops> stopsList = new ArrayList<>();
        List<String> stopsReadData = Utils.readFile(path);
        stopsReadData.remove(0);
        stopsReadData.forEach(row -> {
            Stops stops = new Stops();
            String[] data = row.split(SEPERATOR);
            stops.setStopId(data[0]);
            stops.setStopName(data[2]);
            stops.setStopLat(data[4]);
            stops.setStopLot(data[5]);
            stopsList.add(stops);
        });

        return stopsList;
    }

    public List<StopTimes> readStopTimeData(String path){
        //   0        1            2               3       4
        // trip_id,arrival_time,departure_time,stop_id,stop_sequence,stop_headsign,pickup_type,drop_off_type,shape_dist_traveled,timepoint
        List<StopTimes> stopTimesList = new ArrayList<>();
        List<String> stopTimesReadData = Utils.readFile(path);
        stopTimesReadData.remove(0);
        stopTimesReadData.forEach(row -> {
            StopTimes stopTimes = new StopTimes();
            String[] data = row.split(SEPERATOR);
            stopTimes.setTrip(data[0]);
            stopTimes.setArrivalTime(data[1]);
            stopTimes.setDepartureTime(data[2]);
            stopTimes.setStopId(data[3]);
            stopTimes.setStopSequence(data[4]);
            stopTimesList.add(stopTimes);
         });
        return stopTimesList;
    }

    public List<Trips> readTripsData(String path){
        //  0         1           2        3              4               5          6        7           8
        // route_id,service_id,trip_id,trip_headsign,trip_short_name,direction_id,block_id,shape_id,wheelchair_accessible,
        //   9            10        11                 12
        // bikes_allowed,duty,duty_sequence_number,run_sequence_number
        List<Trips> tripsList = new ArrayList<>();
        List<String> tripsReadData = Utils.readFile(path);
        tripsReadData.remove(0);
        tripsReadData.forEach(row -> {
            Trips trips = new Trips();
            String[] data = row.split(SEPERATOR);
            trips.setRouteId(data[0]);
            trips.setServiceId(data[1]);
            trips.setTripId(data[2]);
            trips.setTripHeadsign(data[3]);
            trips.setDirectionId(data[5]);
            tripsList.add(trips);
        });

        return tripsList;
    }

}
