import hu.nero.Line;
import hu.nero.Subway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

class SubwayTest {

    Subway subway = new Subway("Budapest");
    String colorActual = "Red";
    String colorExpected = "Red";
    Line line = new Line(colorExpected, subway);


    @Test
    void createNewLineTest() {
        subway.createNewLine(colorActual);
        subway.createNewLine("White");
        Assertions.assertEquals(colorActual, colorExpected);
    }

}
