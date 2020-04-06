import java.awt.*;
import java.io.IOException;
import java.net.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        //Declaring Variables
        double latitude0 = 20.626830;
        double longitude0 = -103.461251;
        int contactedPeople = 5;
        GPSGenerator contactsLatLong;
        ArrayList<String> peopleLocation;
        StringBuilder url = new StringBuilder("https://www.google.com/maps/dir");

        //Generating coordinate object
        GPSCoordinate gps1 = new GPSCoordinate(latitude0, longitude0);
        System.out.println(gps1);

        //Moving coordinate object
        MovementSimulator movement = new MovementSimulator(5, 1);
        gps1 = movement.move(gps1);
        System.out.println(gps1);

        //Generating a list of location surrounding coordinate object
        contactsLatLong = new GPSGenerator(contactedPeople, gps1, 200);
        peopleLocation = contactsLatLong.getCoordinates();

        //Creating URL to dispslay in google maps
        for (int i = 0 ; i < peopleLocation.size() ; i ++) {
            if ( i == peopleLocation.size() - 1) {
                url.append("//@").append(peopleLocation.get(i)).append("z");
            } else {
                url.append("/").append(peopleLocation.get(i));
            }
        }

        //Opening url in browser
        try {
            Desktop.getDesktop().browse(new URI(url.toString()));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}