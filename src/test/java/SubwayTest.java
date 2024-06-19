import hu.nero.Line;
import hu.nero.Station;
import hu.nero.Subway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class SubwayTest {

    String name = "Медведковская";
    String expectedNameStation = "Медведковская";
    Station previous;
    Station next;
    String transferStation1 = "Пермь-1";
    String transferStation2 = "Тяжмаш";
    String colorActual = "Red";
    String colorExpected = "Red";
    Subway subway = new Subway("Budapest");
    Line line = new Line(colorActual, subway);
    List<Station> stations = new ArrayList<>(); //спросить
    List<Station> exceptedStations = new ArrayList<>();
    List<Station> transferStations = new ArrayList<>();
    List<Station> exceptedTransferStations = new ArrayList<>();
    Station station1 = new Station(transferStation1, line, transferStations, subway);
    Station station2 = new Station(name, line, null, subway);


    @Test
    void isNewLineCreated() {
        subway.createNewLine(colorActual);
        subway.createNewLine("Blue");
        Assertions.assertEquals(colorActual, colorExpected);
    }

    @Test
    void createFirstStationLineTest() {
        transferStations.add(station1);
        exceptedTransferStations.add(station1);
        subway.createFirstStationInLine(colorActual, name, transferStations);
        Assertions.assertEquals(colorActual, colorExpected);
        Assertions.assertEquals(name, expectedNameStation);
        Assertions.assertEquals(transferStations, exceptedTransferStations);
    }


}
