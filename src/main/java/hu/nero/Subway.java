package hu.nero;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;
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

    public void createNewLine(String color) {

        if (lines.stream().anyMatch(line -> line.getColor().equals(color))){
            throw new ColorLineException(color + " is already in");
        }
        lines.add(new Line(color, getSubway()));
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
