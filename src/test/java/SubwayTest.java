import hu.nero.Line;
import hu.nero.Station;
import hu.nero.Subway;
import hu.nero.exception.ColorLineException;
import hu.nero.exception.LineNotEmptyException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@DisplayName("Тестирование методов класса Subway")
class SubwayTest {

    @DisplayName("isLineWithThisColorExists - корректные параметры - такого цвета в списке нет")
    @Test
    void isColorExistsInlines() {
        String cityName = "Budapest";
        String colorLine = "Red";
        Subway subway = new Subway(cityName);

        boolean actual = subway.isLineWithThisColorExists(colorLine);

        Assertions.assertFalse(actual);
    }

    @DisplayName("isStationNameExistsInAnyLine - корректные параметры - такой станции в списке нет")
    @Test
    void isStationNameInlines() {
        String cityName = "Budapest";
        Subway subway = new Subway(cityName);

        boolean actual = subway.isStationNameExistsInAnyLine(cityName);

        Assertions.assertFalse(actual);
    }

    @DisplayName("checkLineIsEmpty - корректные параметры - выброс исключения")
    @Test
    void checkLineIsEmptyTest() throws NoSuchMethodException {

        Method checkLineIsEmptyMethod = Subway.class.getDeclaredMethod("checkLineIsEmpty", Line.class);
        checkLineIsEmptyMethod.setAccessible(true);
        Assertions.assertThrows(LineNotEmptyException.class, () -> {
            throw new LineNotEmptyException(" is not empty!");
        });
    }

    @DisplayName("createNewLine - correct data - new line created")
    @Test
    void createNewLineTest() {
        String colorLine = "Red";
        var cityName = "Budapest";
        Subway subway = new Subway(cityName);
        subway.createNewLine(colorLine);


    }
    @DisplayName("createFirstStation - correct data - first station created")
    @Test
    void createFirstStationTest() {
        var lineColor = "White";
        var nameStation = "Октогон";
        var cityName = "Budapest";
        Subway subway = new Subway(cityName);
        Line line = new Line(lineColor, subway);
        List<Station> transferStations = List.of();
        Station actlStation = new Station(nameStation, line,transferStations,subway);

        Station exptStation = subway.createFirstStation(lineColor,nameStation,transferStations);

        Assertions.assertEquals(exptStation,actlStation);

    }



}
