package hu.nero;

import hu.nero.exception.ColorLineException;
import hu.nero.exception.StationNameException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Subway {
    private String cityName;
    private final Set<Line> lines;

    public Subway(String cityName) {
        this.cityName = cityName;
        this.lines = new HashSet<>();
    }

    public Line createNewLine(String newLineColor) {
        if (isLineWithThisColorExists(newLineColor)) {
            throw new ColorLineException(newLineColor + " already exists!");
        }
        Line line = new Line(newLineColor, this);
        lines.add(line);
        return line;
    }

    private boolean isLineWithThisColorExists(String newLineColor) {
        return lines.stream().anyMatch(line -> line.getColor().equals(newLineColor));
    }

    private boolean isStationNameExistsInAnyLine(String nameStation) {
        for (Line line : lines) {
            for (Station station : line.getStations()) {
                if (station.getName().equals(nameStation)) {
                    return true;
                }
            }
        }
        return false;
    }

    public Station createFirstStation(String lineColor,
                                      String stationName,
                                      List<Station> transferStations) {
        if (isLineWithThisColorExists(lineColor)) {
            throw new ColorLineException(lineColor + " color Line already exists!");
        }
        if (isStationNameExistsInAnyLine(stationName)) {
            throw new StationNameException(stationName + " station already exists!");
        }
        Line line = new Line(lineColor, this);
        return new Station(stationName, line, transferStations, this);
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

    @Override
    public String toString() {
        return cityName + " " + lines;
    }
}
