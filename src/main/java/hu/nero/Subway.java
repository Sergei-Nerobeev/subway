package hu.nero;

import hu.nero.exception.ColorLineException;
import hu.nero.exception.StationInException;

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

    public boolean isLineWithThisColorExists(String newLineColor) {
        return lines.stream().anyMatch(line -> line.getColor().equals(newLineColor));
    }

    public Line createNewLine(String lineColor) {
        if (isLineWithThisColorExists(lineColor)) {
            throw new ColorLineException(lineColor + " is already in color Lines!");
        }
        Line line = new Line(lineColor, this);
        lines.add(line);
        return line;
    }

    public Station createFirstStationLine(String lineColor, String nameStation, List<Station> transitStations) {
        if (isLineWithThisColorExists(lineColor)) {
            throw new ColorLineException(lineColor + " is already in Line color");
        }
        if (lines.stream().flatMap(line -> line.getColor()) { //todo
            throw new StationInException(nameStation + " is already in naming stations");
        }
        if (lines.stream().anyMatch(line -> line.getStations().isEmpty())) {
            throw new RuntimeException("Line is empty");
        }
        return lines.add(); //??
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
