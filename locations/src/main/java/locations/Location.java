package locations;

public class Location {

    private String name;
    private double latitude;
    private double longitude;


    public Location(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public boolean isOnEquator() {
        return latitude == 0;
    }

    public boolean isOnPrimeMeridian() {
        return longitude == 0;
    }

    public double distanceFrom(Location location) {
        final int R = 6371; // Radius of the earth
        final double elevation1 = 0; //Height of this.
        final double elevation2 = 0; //Height of location.

        double latDistance = Math.toRadians(location.latitude - this.latitude);
        double lonDistance = Math.toRadians(location.longitude - this.longitude);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(this.latitude)) * Math.cos(Math.toRadians(location.latitude))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c;

        double height = elevation1 - elevation2;

        distance = Math.pow(distance, 2) + Math.pow(height, 2);

        return Math.sqrt(distance);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
