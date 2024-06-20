package hu.nero;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private String color;
    private List<Station> stations;
    private Subway subway;

    public Line(String color, Subway subway) {
        this.color = color;
        this.subway = subway;
        this.stations = new ArrayList<>();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Subway getSubway() {
        return subway;
    }

    public void setSubway(Subway subway) {
        this.subway = subway;
    }

    public List<Station> getStations() {
        return stations;
    }

    @Override
    public String toString() {
        return "Line{" +
                "color='" + color + '\'' +
                ", stations=" + stations +
                ", subway=" + subway +
                '}';
    }
}
