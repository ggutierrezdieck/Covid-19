import jdk.nashorn.internal.objects.annotations.Constructor;

import java.util.Random;

/*
Class to simulate, very roughly, some movement on GPS location
 */
public class MovementSimulator {
    double speed;
    double interval;

    public MovementSimulator(double speed, double interval){
        this.speed = speed;
        this.interval = interval;
    }
    public GPSCoordinate move(GPSCoordinate position0) {
        GPSCoordinate newGPS = new GPSCoordinate(position0.getLatitude(),position0.getLongitude());
        double latitude0 = newGPS.getLatitude();
        double longitude0 = newGPS.getLongitude();
        double displacement = speed / interval;
        Random random = new Random();

        // Convert displacement from meters to degrees
        double displacementInDegrees = displacement / 111000f;

        double u = random.nextDouble();
        double v = random.nextDouble();
        double w = displacementInDegrees * Math.sqrt(u);
        double t = 2 * Math.PI * v;
        double x = w * Math.cos(t);
        double y = w * Math.sin(t);

        // Adjust the x-coordinate for the shrinking of the east-west distances
        double new_x = x / Math.cos(Math.toRadians(latitude0));

        double newLongitude = new_x + longitude0;
        double newLatitude = y + latitude0;

        newGPS.setGpsCoordinate(newLatitude,newLongitude);

        return newGPS;
    }
}
