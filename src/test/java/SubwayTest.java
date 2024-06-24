import hu.nero.Line;
import hu.nero.Station;
import hu.nero.Subway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@DisplayName("Тестирование методов класса Subway")
class SubwayTest {

    @DisplayName("Поиск цвета в списке линий - введены корректные параметры - такого цвета в списке нет")
    @Test
    void isColorExistsInlines() {
        String cityName = "Budapest";
        String colorLine = "Red";
        Subway subway = new Subway(cityName);
        boolean expected = false;

        boolean actual = subway.isLineWithThisColorExists(colorLine);

        Assertions.assertEquals(expected, actual);
    }

    @DisplayName("Поиск названия станции в списке линий - введены корректные параметры - такой станции в списке нет")
    @Test
    void isStationNameInlines() {
        String cityName = "Budapest";
        Subway subway = new Subway(cityName);
        boolean expected = false;

        boolean actual = subway.isStationNameExistsInAnyLine(cityName);

        Assertions.assertEquals(expected, actual);
    }

    @DisplayName("Поиск станций в линии - введены корректные параметры - линия пустая")
    @Test
    void isLineEmpty() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String cityName = "Budapest";
        String colorLine = "Red";
        Subway subway = new Subway(cityName);
        var line = new Line(colorLine,subway);

        Method method = Subway.class.getDeclaredMethod("checkLineIsEmpty", Line.class);
        method.setAccessible(true);
        boolean expected = false;

        boolean actual = (boolean) method.invoke(subway,line);

        Assertions.assertEquals(expected, actual);
    }

    @DisplayName("Создание новой линии - введены корректные правильные параметры - линия создана")
    @Test
    void isNewLineCreated() {
        String colorLine = "Red";

    }

    @DisplayName("Создана ли первая станция в линии?")
    @Test
    void firstStationInLineCreated() {


    }


}
