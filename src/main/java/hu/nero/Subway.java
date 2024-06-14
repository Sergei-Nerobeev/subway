package hu.nero;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;
import java.util.Set;

public class Subway {

    private static final Logger log = LogManager.getLogger(Subway.class);
    private String name;
    private Set<Line> lines;
    private Subway subway;

    public Subway(String name) {
        this.name = name;
        this.lines = new HashSet<>();

    }

    public void createNewLine(String color) {

        if (lines.stream().anyMatch(line -> !Boolean.parseBoolean(color))) {
            lines.add(new Line(color, getSubway()));
            log.debug("OK");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
