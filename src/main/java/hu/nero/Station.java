package hu.nero;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.Duration;

public class Station {
    private static final Logger log = LogManager.getLogger(Station.class);
    private String nameStation;
    private String previousStation;
    private String nextStation;
    private Duration transitTime;
    private Line line;
    private String transferStation;
    private Subway subway;

    public Station(String nameStation, String previousStation, String nextStation, Duration transitTime,
                   Line line, String transferStation, Subway subway) {
        this.nameStation = nameStation;
        this.previousStation = previousStation;
        this.nextStation = nextStation;
        this.transitTime = transitTime;
        this.line = line;
        this.transferStation = transferStation;
        this.subway = subway;
    }

    public String getNameStation() {
        return nameStation;
    }

    public void setNameStation(String nameStation) {
        this.nameStation = nameStation;
    }

    public String getPreviousStation() {
        return previousStation;
    }

    public void setPreviousStation(String previousStation) {
        this.previousStation = previousStation;
    }

    public String getNextStation() {
        return nextStation;
    }

    public void setNextStation(String nextStation) {
        this.nextStation = nextStation;
    }

    public Duration getTransitTime() {
        return transitTime;
    }

    public void setTransitTime(Duration transitTime) {
        this.transitTime = transitTime;
    }

    public Line getLine() {
        return line;
    }

    public void setLine(Line line) {
        this.line = line;
    }

    public String getTransferStation() {
        return transferStation;
    }

    public void setTransferStation(String transferStation) {
        this.transferStation = transferStation;
    }

    public Subway getSubway() {
        return subway;
    }

    public void setSubway(Subway subway) {
        this.subway = subway;
    }
}
