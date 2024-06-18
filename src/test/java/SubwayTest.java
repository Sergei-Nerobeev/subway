import hu.nero.Line;
import hu.nero.Station;
import hu.nero.Subway;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

class SubwayTest {

    private Subway subway;
    private Station station;
    private Line line;

    String name = "Медведковская";
    String expectedNameStation = "Медведковская";
    Station previous;
    Station next;
    String transferStation1 = "Пермь-1";
    String transferStation2 = "Тяжмаш";
    String colorActual = "Red";
    String colorExpected = "Red";

    List<Station> stations = new ArrayList<>(); //спросить
    List<Station> exceptedStations = new ArrayList<>();
    List<Station> transferStations = new ArrayList<>();
    List<Station> exceptedTransferStations = new ArrayList<>();

    @BeforeEach
    void setup() {
        Subway subway = new Subway("Budapest");
        Line line = new Line(colorExpected, subway);
    }

    @Test
    void isNewLineCreated() {
        subway.createNewLine(colorActual);
        subway.createNewLine("White");
        Assertions.assertEquals(colorActual, colorExpected);
    }

    @Test
    void createFirstStationLineTest() {

        transferStations.add(station);
        stations.add(station);
        exceptedStations.add(station);
        exceptedTransferStations.add(station);
//        subway.createFirstStationLine(colorActual, name, stations, transferStations);
        Assertions.assertEquals(colorActual, colorExpected);
        Assertions.assertEquals(name, expectedNameStation);
        Assertions.assertEquals(stations, exceptedStations);
        Assertions.assertEquals(transferStations, exceptedStations);
    }


}
