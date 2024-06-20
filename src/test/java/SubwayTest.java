import hu.nero.Line;
import hu.nero.Station;
import hu.nero.Subway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

@DisplayName("Тестирование методов класса Subway")
class SubwayTest {
    private Subway subway;
    private Line line;
    private Station station1;
    private Station station2;
    private List<Station> transferStations;
    String actualStationName = "Медведковская";
    String expectedStationName = "Медведковская";
    String transferStation1 = "Пермь-1";
    String transferStation2 = "Тяжмаш";
    String colorExpected = "Red";
    String colorActual = "Red";

    @BeforeEach
    void setUp() {
        subway = new Subway("Budapest");
        line = new Line(colorActual, subway);
        station1 = new Station(transferStation1, line, transferStations, subway);
        station2 = new Station(actualStationName, line, null, subway);
        transferStations = new ArrayList<>();
    }

    @DisplayName("Создана ли новая линия?")
    @Test
    void isNewLineCreated() {
        subway.createNewLine(colorActual);
        subway.createNewLine("Blue");
        Assertions.assertEquals(colorActual, colorExpected);
    }

    @DisplayName("Создана ли первая станция в линии?")
    @Test
    void firstStationInLineCreated() {
        Station result = subway.createFirstStation(colorActual, actualStationName, transferStations);
        System.out.println(result);
        Assertions.assertEquals(colorExpected, colorActual);

    }


}
