import hu.nero.Line;
import hu.nero.Station;
import hu.nero.Subway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    void isNewLineCreated() {
        subway.createNewLine(colorActual);
        subway.createNewLine("Blue");
        System.out.println(subway.getLines());
        Assertions.assertEquals(colorActual, colorExpected);
    }

    @Test
    void isLineTheSameColorAlreadyExists() {
        Station result = subway.createFirstStation(colorActual, actualStationName, transferStations);
        System.out.println(result);
        Assertions.assertEquals(colorExpected, colorActual);

    }


}
