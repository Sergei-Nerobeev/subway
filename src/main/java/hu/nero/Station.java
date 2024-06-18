package hu.nero;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Station {
    private static final Logger log = LogManager.getLogger(Station.class);
    private final String name;
    private Station previous;
    private Station next;
    private Duration transitTimeInMinutesAndSeconds;
    private final Line line;
    private final List<Station> transferStations;
    private final Subway subway;

    public Station(String name,
                   Station previous,
                   Station next,
                   Duration transitTimeInMinutesAndSeconds,
                   Line line,
                   Subway subway) {
        this.name = name;
        this.previous = previous;
        this.next = next;
        this.transitTimeInMinutesAndSeconds = transitTimeInMinutesAndSeconds;
        this.line = line;
        this.transferStations = new ArrayList<>();
        this.subway = subway;
    }

    public Station(String name,
                   Line line,
                   List<Station> transferStations,
                   Subway subway) {
            this(name,
                null,
                null,
                null,
                line,
                subway);
    }

    public String getName() {
        return name;
    }

    public Station getPrevious() {
        return previous;
    }

    public void setPrevious(Station previous) {
        this.previous = previous;
    }

    public Station getNext() {
        return next;
    }

    public void setNext(Station next) {
        this.next = next;
    }

    public Duration getTransitTimeInMinutesAndSeconds() {
        return transitTimeInMinutesAndSeconds;
    }

    public void setTransitTimeInMinutesAndSeconds(Duration transitTimeInMinutesAndSeconds) {
        this.transitTimeInMinutesAndSeconds = transitTimeInMinutesAndSeconds;
    }

    public List<Station> getTransferStations() {
        return transferStations;
    }

    public Line getLine() {
        return line;
    }

    public Subway getSubway() {
        return subway;
    }

}
