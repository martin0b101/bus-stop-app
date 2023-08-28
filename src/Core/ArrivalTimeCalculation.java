package Core;

import Model.*;

import java.time.Duration;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

public class ArrivalTimeCalculation {

    private String routeId;
    private int numberofOutput;
    private String outputFormat;
    private List<StopTimes> arrayStopTime;
    private List<Stops> arrayStops;
    private List<Calandar> arrayCalendar;
    private List<Agency> arrayAgency;
    private List<Routes> arrayRoutes;
    private List<Trips> arrayTrips;
    private LocalTime timeNow;

    private final static String SPLIT_DELIMETER = "_";
    private final static String SPLIT_COMMA = ", ";
    private final static String MINUTES = "min";
    private final static String OUTPUT_FORMAT_1 = "absolute";
    private final static String OUTPUT_FORMAT_2 = "relative";
    private final static String PATH_STOP_TIMES = "./gtfs/stop_times.txt";
    private final static String PATH_STOPS = "./gtfs/stops.txt";
    private final static String PATH_CALENDAR = "./gtfs/calendar.txt";
    private final static String PATH_AGENCY = "./gtfs/agency.txt";
    private final static String PATH_ROUTES = "./gtfs/routes.txt";
    private final static String PATH_TRIPS = "./gtfs/trips.txt";

    public ArrivalTimeCalculation(String routeId, int numberofOutput, String output){
        GFTSDataReader reader = new GFTSDataReader();
        this.arrayStopTime = reader.readStopTimeData(PATH_STOP_TIMES);
        this.arrayStops = reader.readStopsData(PATH_STOPS);
        this.arrayCalendar = reader.readCalendarData(PATH_CALENDAR);
        this.arrayAgency = reader.readAgencyData(PATH_AGENCY);
        this.arrayRoutes = reader.readRoutesData(PATH_ROUTES);
        this.arrayTrips = reader.readTripsData(PATH_TRIPS);
        this.routeId = routeId;
        this.numberofOutput = numberofOutput;
        this.outputFormat = output;
        this.timeNow = LocalTime.now();
    }


    private Map getAllArrivalTimeTwoHoursFromNow(){

        LocalTime maxTime = timeNow.plusHours(2);
        Map<LocalTime, String> arrivalTimeAndTripId = new TreeMap<>();

        arrayStopTime.forEach(stoptime -> {
            if (stoptime.getStopId().equals(routeId)){
                if (LocalTime.parse(stoptime.getArrivalTime()).isAfter(timeNow) && LocalTime.parse(stoptime.getArrivalTime()).isBefore(maxTime)){
                    arrivalTimeAndTripId.put(LocalTime.parse(stoptime.getArrivalTime()), stoptime.getTrip());
                }
            }
        });
        return arrivalTimeAndTripId;
    }

    private HashMap getLimitedNumberOfOutput(){

        Map<LocalTime, String> arrivalTimeAndTripId = getAllArrivalTimeTwoHoursFromNow();
        HashMap<String, List<LocalTime>> output = new HashMap<>();

        arrivalTimeAndTripId.entrySet().stream().limit(numberofOutput)
                .map(Map.Entry::getKey)
                .forEach(arrivalTime -> {
                    String routeId = arrivalTimeAndTripId.get(arrivalTime).split(SPLIT_DELIMETER)[2];
                    List<LocalTime> time;
                    if (output.containsKey(routeId)){
                        time = output.get(routeId);
                    }else {
                        time = new LinkedList<>();
                    }
                    time.add(arrivalTime);
                    output.put(routeId, time);
                });
        return output;
    }

    public void outputArrivalTimes(){
        System.out.println("Postajalisce: "+outputNameOfStop());
        HashMap<String, List<LocalTime>> output = getLimitedNumberOfOutput();
        output.forEach((route, listOfArrivalTimes) -> {
            if(outputFormat.equals(OUTPUT_FORMAT_1)) {
                System.out.println(route + ": " + convertToAbsoluteFormat(listOfArrivalTimes));
            }
            else if (outputFormat.equals(OUTPUT_FORMAT_2)){
                System.out.println(route + ": "+convertToRelativeFormat(listOfArrivalTimes));
            }
            else{
                System.out.println("Wrong output format!");
                System.exit(1);
            }
        });
    }

    private String convertToAbsoluteFormat(List<LocalTime> times){
        List<String> timesInStringFormat = times
                .stream()
                .map((obj) -> Objects.toString(obj, null))
                .collect(Collectors.toList());

        return String.join(SPLIT_COMMA, timesInStringFormat);
    }

    private String convertToRelativeFormat(List<LocalTime> times){
        List<String> timesInStrings = times.stream()
                .map(time -> Objects.toString(Duration.between(timeNow, time).toMinutes() + MINUTES, null))
                .collect(Collectors.toList());
        return String.join(", ", timesInStrings);
    }

    private String outputNameOfStop(){
        return arrayStops.
                stream()
                .filter(stops -> stops.getStopId().equals(routeId))
                .map(stops -> stops.getStopName())
                .findFirst().orElse("Error");
    }
}
