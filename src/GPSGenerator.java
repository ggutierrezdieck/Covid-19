import java.util.ArrayList;
import java.util.Random;
/*
Generate a specific number of random locations based on a given center
*/

public class GPSGenerator {
    private ArrayList<String> coordinates = new ArrayList<>();

    //Constructor
    public GPSGenerator(int noCoordinates, GPSCoordinate coordinate, int radius){
        //Generating coordinates
        for (int i = 0; i <= noCoordinates; i++) {
                double longitude = coordinate.getLongitude();
                double latitude = coordinate.getLatitude();
                Random random = new Random();

                // Convert radius from meters to degrees
                double radiusInDegrees = radius / 111000f;

                double u = random.nextDouble();
                double v = random.nextDouble();
                double w = radiusInDegrees * Math.sqrt(u);
                double t = 2 * Math.PI * v;
                double x = w * Math.cos(t);
                double y = w * Math.sin(t);

                // Adjust the x-coordinate for the shrinking of the east-west distances
                double new_x = x / Math.cos(Math.toRadians(latitude));

                double foundLongitude = new_x + longitude;
                double foundLatitude = y + latitude;
                //System.out.println("Longitude: " + foundLongitude + "  Latitude: " + foundLatitude);
                this.coordinates.add(foundLatitude + "," + foundLongitude);
            }

    }

    public ArrayList<String> getCoordinates() {
        return coordinates;
    }
}
