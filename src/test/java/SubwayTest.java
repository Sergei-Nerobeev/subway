import hu.nero.Line;
import hu.nero.Subway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SubwayTest {

    Subway subway = new Subway("");
    String colorActual = "Red";
    String colorExpected = "Red";
    Line line = new Line(colorExpected,subway);




    @Test
    void createNewLineTest() {

        subway.createNewLine(colorActual);
        Assertions.assertEquals(colorActual,colorExpected);
    }

}
