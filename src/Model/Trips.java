package Model;

public class Trips {


    private String tripId;
    private Routes routeId;
    private Calandar serviceId;
    private String directionId;
    private String tripHeadsign;


    public String getTripId() {
        return tripId;
    }

    public void setTripId(String tripId) {
        this.tripId = tripId;
    }

    public Routes getRouteId() {
        return routeId;
    }

    public void setRouteId(Routes routeId) {
        this.routeId = routeId;
    }

    public Calandar getServiceId() {
        return serviceId;
    }

    public void setServiceId(Calandar serviceId) {
        this.serviceId = serviceId;
    }

    public String getDirectionId() {
        return directionId;
    }

    public void setDirectionId(String directionId) {
        this.directionId = directionId;
    }

    public String getTripHeadsign() {
        return tripHeadsign;
    }

    public void setTripHeadsign(String tripHeadsign) {
        this.tripHeadsign = tripHeadsign;
    }
}
