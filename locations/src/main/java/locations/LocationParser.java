package locations;

public class LocationParser {

    public Location parse(String text) {
        text = text.trim();
        validateText(text);
        return getLocation(text);
    }

    private Location getLocation(String text) {
        String[] data = text.split(",");
        try {
            return new Location(data[0], Double.parseDouble(data[1]), Double.parseDouble(data[2]));
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("Invalid numeric value in text: " + text + ". " + nfe.getMessage(), nfe);
        }
    }

    private void validateText(String text) {
        if (text == null || text.length() < 5 || text.split(",").length < 3) {
            throw new IllegalArgumentException("Cannot parse text: " + text);
        }
    }
}
