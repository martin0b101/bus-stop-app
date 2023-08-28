package Core;

import Model.*;

import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class BusArrivalCalculator {

    public static void main(String[] args) {
        if (args.length < 3){
            System.out.println("Error: not enough arguments!");
            System.exit(1);
        }
        Bus data = new Bus(args[0], args[1], args[2]);





        ArrivalTimeManager calculate = new ArrivalTimeManager(data.id, data.numberOfBuses, data.output);
        calculate.outputArrivalTimes();

    }
}
