import hu.nero.Line;
import hu.nero.Station;
import hu.nero.Subway;
import hu.nero.exception.ColorLineException;
import hu.nero.exception.LineNotEmptyException;
import org.junit.jupiter.api.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@DisplayName("Тестирование методов класса Subway")
class SubwayTest {

    @DisplayName("isLineWithThisColorExists - correct data - Line color doesn't exist!")
    @Test
    void isColorExistsInlines() {
        String cityName = "Budapest";
        String colorLine = "Red";
        Subway subway = new Subway(cityName);

        boolean actual = subway.isLineWithThisColorExists(colorLine);

        Assertions.assertFalse(actual);
    }

    @DisplayName("isLineWithThisColorExists - not correct data - Line color doesn't exist!")
    @Test
    void isColorExistsInlines_notCorrect() {
        String cityName = "Budapest";
        String colorLine = "Red";
        Subway subway = new Subway(cityName);

        boolean actual = subway.isLineWithThisColorExists(colorLine);

        Assertions.assertTrue(actual);
    }

    @DisplayName("isStationNameExistsInAnyLine - correct data - station already exists!")
    @Test
    void isStationNameInlines() {
        String cityName = "Budapest";
        Subway subway = new Subway(cityName);

        boolean actual = subway.isStationNameExistsInAnyLine(cityName);

        Assertions.assertFalse(actual);
    }

    @DisplayName("isStationNameExistsInAnyLine - not correct data - station already exists!")
    @Test
    void isStationNameInlines_notCorrect() {
        String cityName = "Budapest";
        Subway subway = new Subway(cityName);

        boolean actual = subway.isStationNameExistsInAnyLine(cityName);

        Assertions.assertTrue(actual);
    }

    @DisplayName("checkLineIsEmpty - correct data - LineNotEmptyException")
    @Test
    void checkLineIsEmptyTest() throws NoSuchMethodException {

        Method checkLineIsEmptyMethod = Subway.class.getDeclaredMethod("checkLineIsEmpty", Line.class);
        checkLineIsEmptyMethod.setAccessible(true);
        Assertions.assertThrows(LineNotEmptyException.class, () -> {
            throw new LineNotEmptyException(" is not empty!");
        });
    }

    @DisplayName("checkLineIsEmpty - not correct data - LineNotEmptyException")
    @Test
    void checkLineIsEmptyTest_notCorrect() throws NoSuchMethodException {
        Line line = null;
        Method checkLineIsEmptyMethod = Subway.class.getDeclaredMethod("checkLineIsEmpty", Line.class);
        checkLineIsEmptyMethod.setAccessible(true);
        Assertions.assertThrows(LineNotEmptyException.class, () -> {
            checkLineIsEmptyMethod.invoke(Subway.class,line);
        });
    }
    @DisplayName("createNewLine - correct data - new line created")
    @Test
    void createNewLineTest() {
        var colorLine = "Red";
        var cityName = "Budapest";
        Subway subway = new Subway(cityName);

        Line line = subway.createNewLine(colorLine);

        Assertions.assertNotNull(line);
        Assertions.assertEquals(colorLine, line.getColor());
    }

    @DisplayName("createNewLine - not correct data - new line not created")
    @Test
    void createNewLineTest_notCorrect() {
        var colorLine = "Red";
        var wrongColorLine = "Blue";
        var cityName = "Budapest";
        Subway subway = new Subway(cityName);

        Line line = subway.createNewLine(colorLine);

        Assertions.assertNotNull(line);
        Assertions.assertEquals(wrongColorLine, line.getColor());
    }

    @DisplayName("createFirstStation - correct data - first station created")
    @Test
    void createFirstStationTest() {
        var colorLine = "White";
        var nameStation = "Октогон";
        var cityName = "Budapest";
        Subway subway = new Subway(cityName);
        Line line = subway.createNewLine(colorLine);
        List<Station> transferStations = List.of();

        Station actlStation = new Station(nameStation, line, transferStations, subway);
        Station exptStation = subway.createFirstStation(colorLine, nameStation, transferStations);

        Assertions.assertEquals(exptStation, actlStation);
    }

    @DisplayName("createFirstStation - not correct data - first station not created")
    @Test
    void createFirstStationTest_notCorrect() {
        var colorLine = "White";
        var wrongColorLine = "Blue";
        var nameStation = "Октогон";
        var cityName = "Budapest";
        Subway subway = new Subway(cityName);
        Line line = subway.createNewLine(colorLine);
        List<Station> transferStations = List.of();

        Station actlStation = new Station(nameStation, line, transferStations, subway);
        Station exptStation = subway.createFirstStation(wrongColorLine, nameStation, transferStations);

        Assertions.assertEquals(exptStation, actlStation);
    }

}
