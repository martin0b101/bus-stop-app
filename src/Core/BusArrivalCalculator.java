package Core;

import Model.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class BusArrivalCalculator {

    public static void main(String[] args) {
        System.out.print("> ");
        if (args.length < 3){
            System.out.println("Error: not enough arguments!");
            System.exit(1);
        }
        Bus data = new Bus(args[0], args[1], args[2]);
        System.out.println(data.id); // stop_id
        System.out.println(data.numberOfBuses);  // max number of buses on this stops
        System.out.println(data.output); // output format
        System.out.println("Current path: "+ System.getProperty("user.dir"));

        GFTSDataReader reader = new GFTSDataReader();
        List<Calandar> arrayCalendar = reader.readCalendarData("./gtfs/calendar.txt");
        List<Agency> arrayAgency = reader.readAgencyData("./gtfs/agency.txt");
        List<Routes> arrayRoutes = reader.readRoutesData("./gtfs/routes.txt");
        List<Stops> arrayStops = reader.readStopsData("./gtfs/stops.txt");
        List<StopTimes> arrayStopTime = reader.readStopTimeData("./gtfs/stop_times.txt");
        List<Trips> arrayTrips = reader.readTripsData("./gtfs/trips.txt");

        LocalTime timeNow = LocalTime.now();

        int hourNow = timeNow.getHour();
        int minute = timeNow.getMinute();

        int endHourNow = hourNow + 2;

        // check if stop id exist

        //

        List<LocalTime> arrivalTime = new ArrayList<>();

        arrayStopTime.forEach(stoptime -> {
            if (stoptime.getStopId().equals(data.id)){
                if (Integer.parseInt(stoptime.getArrivalTime().split(":")[0]) >= hourNow && Integer.parseInt(stoptime.getArrivalTime().split(":")[0]) <= endHourNow){
                    arrivalTime.add(LocalTime.parse(stoptime.getArrivalTime()));
                }
            }
        });
        // TODO: sort by time and output with bus name
        arrivalTime.forEach(time -> System.out.println(time.toString()));


    }
}
