import hu.nero.Line;
import hu.nero.Station;
import hu.nero.Subway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

class SubwayTest {

    String nameStation = "Медведковская";
    String expectedNameStation = "Медведковская";
    String previousStation = "Спортивная";
    String nextStation = "Молодежная";
    String transferStation1 = "Пермь-1";
    String transferStation2 = "Тяжмаш";
    Subway subway = new Subway("Budapest");
    String colorActual = "Red";
    String colorExpected = "Red";
    Line line = new Line(colorExpected, subway);
    Station station = new Station(nameStation, previousStation, nextStation,
            Duration.ofMinutes(2), line, transferStation1, subway);
    List<Station> stations = new ArrayList<>();
    List<Station> exceptedStations = new ArrayList<>();
    List<Station> transferStations = new ArrayList<>();
    List<Station> exceptedTransferStations = new ArrayList<>();

    @Test
    void createNewLineTest() {

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
        subway.createFirstStationLine(colorActual, nameStation, stations, transferStations);
        Assertions.assertEquals(colorActual, colorExpected);
        Assertions.assertEquals(nameStation, expectedNameStation);
        Assertions.assertEquals(stations, exceptedStations);
        Assertions.assertEquals(transferStations, exceptedStations);
    }

}
