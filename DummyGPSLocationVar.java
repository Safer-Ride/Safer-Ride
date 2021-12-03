
public class DummyGPSLocationVar {
    private double lat;

    private double longitude;

    public DummyGPSLocationVar(double newLat, double newLong) {
        lat = newLat;
        longitude = newLong;
    }

    public double getLat() {
        return lat;
    }

    public double getLong() {
        return longitude;
    }

    public void setLat(double newLat) {
        lat = newLat;
    }

    public void setLong(double newLong) {
        longitude = newLong;
    }

    //Generates Costs:
    //Time bound:
    public int distanceFrom(DummyGPSLocationVar driverLocation) {
        int sec = API.getMinDuration(lat, longitude, driverLocation.getLat(), driverLocation.getLong());
        return sec;
    }
}
