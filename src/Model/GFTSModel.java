package Model;

import java.util.List;

public class GFTSModel {

    private List<Calandar> caledarData;
    private List<Routes> routesData;
    private List<Trips> modelData;
    private List<Stops> stopsData;
    private List<StopTimes> stopTimeData;

    public List<Calandar> getCaledarData() {
        return caledarData;
    }

    public void setCaledarData(List<Calandar> caledarData) {
        this.caledarData = caledarData;
    }

    public List<Routes> getRoutesData() {
        return routesData;
    }

    public void setRoutesData(List<Routes> routesData) {
        this.routesData = routesData;
    }

    public List<Trips> getModelData() {
        return modelData;
    }

    public void setModelData(List<Trips> modelData) {
        this.modelData = modelData;
    }

    public List<Stops> getStopsData() {
        return stopsData;
    }

    public void setStopsData(List<Stops> stopsData) {
        this.stopsData = stopsData;
    }

    public List<StopTimes> getStopTimeData() {
        return stopTimeData;
    }

    public void setStopTimeData(List<StopTimes> stopTimeData) {
        this.stopTimeData = stopTimeData;
    }
}
