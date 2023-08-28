package Model;

public class Bus {

    public String id;
    public int numberOfBuses;
    public String output;

    public Bus(String id, String numberOfBuses, String output){
        this.id = id;
        this.numberOfBuses = Integer.parseInt(numberOfBuses);
        this.output = output;
    }
}
