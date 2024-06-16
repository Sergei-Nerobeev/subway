package hu.nero;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Subway {

    private static final Logger log = LogManager.getLogger(Subway.class);
    private String cityName;
    private Set<Line> lines;
    private Subway subway;

    public Subway(String cityName) {
        this.cityName = cityName;
        this.lines = new HashSet<>();

    }

    public void createNewLine(String lineColor) {

        if (lines.stream().anyMatch(line -> line.getColor().equals(lineColor))) {
            throw new ColorLineException(lineColor + " is already in");
        }
        lines.add(new Line(lineColor, getSubway()));
    }

    public void createFirstStationLine(String lineColor, String nameStation, List<Station> transitStations,
                                       List<Station> transferStations) {
        if (lines.stream().anyMatch(line -> line.getColor().equals(lineColor))) {
            throw new ColorLineException(lineColor + " is already in Line color");
        }
        if (lines.stream().anyMatch(line -> line.getStations().equals(nameStation))) { //спросить
            throw new StationInException(nameStation + " is already in naming stations");
        }
        if (lines.stream().anyMatch(line -> line.getStations().isEmpty())) {
            throw new RuntimeException("Line is empty");
        }
    }

    public void createLastStation(String lineColor, String newNameStation, Duration durationFromPrevStation,
                                  List<Station> transferStations) {
    //TODO спросить
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Set<Line> getLines() {
        return lines;
    }

    public void setLines(Set<Line> lines) {
        this.lines = lines;
    }

    public Subway getSubway() {
        return subway;
    }

    public void setSubway(Subway subway) {
        this.subway = subway;
    }

}
