package Model;

public class StopTimes {

    private Trips trip;
    private String stopSequence;
    private Stops stopId;
    private String arrivalTime;
    private String departureTime;

    public Trips getTrip() {
        return trip;
    }

    public void setTrip(Trips trip) {
        this.trip = trip;
    }

    public String getStopSequence() {
        return stopSequence;
    }

    public void setStopSequence(String stopSequence) {
        this.stopSequence = stopSequence;
    }

    public Stops getStopId() {
        return stopId;
    }

    public void setStopId(Stops stopId) {
        this.stopId = stopId;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }
}
