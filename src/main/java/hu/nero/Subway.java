package hu.nero;

import hu.nero.exception.ColorLineException;
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

    public Line createNewLine(String lineColor) {
        if (isLineWithThisColorExists(lineColor)) {
            throw new ColorLineException(lineColor + " already exists!");
        }
        Line line = new Line(lineColor, this);
        lines.add(line);
        return line;
    }

    private boolean isLineWithThisColorExists(String newLineColor) {
        return lines.stream().anyMatch(line -> line.getColor().equals(newLineColor));
    }

    private boolean isStationNameExistsAnyLine(String nameStation) {
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
            throw new ColorLineException(lineColor + " already exists!");
        }
        if (isStationNameExistsAnyLine(nameStation)) {
            throw new StationNameException(nameStation + " already exists!");
        }
        Line line = new Line(lineColor, this);
        if (line.getColor().equals(lineColor)) {
        }
        return new Station(nameStation, line, transitStations, this);
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
