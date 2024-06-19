package hu.nero;

import hu.nero.exception.ColorLineException;
import hu.nero.exception.LineNotEmptyException;
import hu.nero.exception.StationNameException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Subway {
    private String cityName;
    private Set<Line> lines;

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

    public Station createFirstStationInLine(String lineColor,
                                            String nameStation,
                                            List<Station> transitStations) {
        if (isLineWithThisColorExists(lineColor)) {
            System.out.println(lineColor + " Line already exists!");
        }
        if (isStationNameExistsInAnyLine(nameStation)) {
            throw new StationNameException(nameStation + " already exists!");
        }
        Line line = new Line(lineColor, this);
        if (line.getStations().isEmpty()) {
            return new Station(nameStation, line, transitStations, this);
        }
        throw new LineNotEmptyException("Line is not empty!");
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

}
