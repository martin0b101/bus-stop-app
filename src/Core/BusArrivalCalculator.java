package Core;

import Model.Bus;
import Model.Calandar;
import java.util.List;

public class BusArrivalCalculator {

    public static void main(String[] args) {
        System.out.print("> ");
        if (args.length < 3){
            System.out.println("Error: not enough arguments!");
            System.exit(1);
        }
        Bus data = new Bus(args[0], args[1], args[2]);
        System.out.println(data.id);
        System.out.println(data.numberOfBuses);
        System.out.println(data.output);
        System.out.println("Current path: "+ System.getProperty("user.dir"));

        GFTSDataReader reader = new GFTSDataReader();
        List<Calandar> array = reader.readCalendarData("./gtfs/calendar.txt");

        array.forEach(customer -> System.out.println(customer.getMonday()));


    }
}
