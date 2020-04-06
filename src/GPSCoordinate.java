import java.util.ArrayList;

/*
Class to create a GPS coordinate object.
Object is formed by a latitude and a longitude.
 */
public class GPSCoordinate {

//    public String latitude;
//    public String longitude;
    private ArrayList<Double> gpsCoordinate = new ArrayList<>();

    public GPSCoordinate(double latitude, double  longitude){
//        this.latitude = latitude;
//        this.longitude = longitude;
        gpsCoordinate.add(latitude);
        gpsCoordinate.add(longitude);
    }

    @Override
    public String toString() {
        return this.getLatitude() + ", " + this.getLongitude();
    }

    public ArrayList<Double> getCoordinate(){
        return gpsCoordinate;
    }
    public double getLatitude(){
        return gpsCoordinate.get(0);
    }
    public double getLongitude(){
        return gpsCoordinate.get(1);
    }

    public void setGpsCoordinate(double latitude, double longitude){
        gpsCoordinate.set(0,latitude);
        gpsCoordinate.set(1,longitude);
    }
}
