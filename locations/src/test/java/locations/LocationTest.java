package locations;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class LocationTest {

    LocationParser parser;

    @BeforeEach
    void init() {
        parser = new LocationParser();
    }

    @Test
    @DisplayName("Test parse string to create new location.")
    void testParse() {
        String budapest = "Budapest,47.497912,19.040235";
        assertEquals("Budapest", parser.parse(budapest).getName());
        assertEquals(47.497912, parser.parse(budapest).getLatitude());
    }

    @Test
    @DisplayName("Test is on equator")
    void testIsOnEquator() {
        String budapest = "Budapest,47.497912,19.040235";
        String quito = "Quito,0.000000,-78.45584";
        Location budapestHu = parser.parse(budapest);
        Location quitoEc = parser.parse(quito);
        assertFalse(budapestHu.isOnEquator());
        assertTrue(quitoEc.isOnEquator());
    }

    @Test
    void test_is_on_prime_meridian() {
        String budapest = "Budapest,47.497912,19.040235";
        String greenwich = "Greenwich, 51.476837,0.000000";
        Location budapestHu = parser.parse(budapest);
        Location greenwichUk = parser.parse(greenwich);
        assertFalse(budapestHu.isOnPrimeMeridian());
        assertTrue(greenwichUk.isOnPrimeMeridian());
    }

    @Test
    @DisplayName("Test that the parser creates different instances")
    void testParserCreatesDifferentInstances() {
        String budapest = "Budapest,47.497912,19.040235";
        assertNotSame(parser.parse(budapest), parser.parse(budapest));
    }

    @Test
    @DisplayName("Test the distance of Budapest and Debrecen")
    void testDistanceFrom() {
        String budapest = "Budapest,47.497912,19.040235";
        String debrecen = "Debrecen,47.52997,21.63916";
        assertEquals(195.2, parser.parse(budapest).distanceFrom(parser.parse(debrecen)), 0.1);
    }

    @Test
    @DisplayName("Test the distance of Budapest from itself is 0")
    void testSelfDistanceFrom() {
        String budapest = "Budapest,47.497912,19.040235";
        assertEquals(0, parser.parse(budapest).distanceFrom(parser.parse(budapest)));
    }

    @Test
    @DisplayName("Test parser with all the attributes of location")
    void testParserWithAllAttributesOfLocation() {
        String budapest = "Budapest,47.497912,19.040235";
        Location budapestHu = parser.parse(budapest);

        assertAll(
                () -> assertEquals("Budapest", budapestHu.getName()),
                () -> assertEquals(47.497912, budapestHu.getLatitude()),
                () -> assertEquals(19.040235, budapestHu.getLongitude())
        );
    }
}