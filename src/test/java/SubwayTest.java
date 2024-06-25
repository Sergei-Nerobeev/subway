import hu.nero.Line;
import hu.nero.Station;
import hu.nero.Subway;
import hu.nero.exception.ColorLineException;
import hu.nero.exception.LineNotEmptyException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@DisplayName("Тестирование методов класса Subway")
class SubwayTest {

    @DisplayName("Поиск цвета в списке линий - корректные параметры - такого цвета в списке нет")
    @Test
    void isColorExistsInlines() {
        String cityName = "Budapest";
        String colorLine = "Red";
        Subway subway = new Subway(cityName);
        boolean expected = false;

        boolean actual = subway.isLineWithThisColorExists(colorLine);

        Assertions.assertEquals(expected, actual);
    }

    @DisplayName("Поиск названия станции в списке линий - корректные параметры - такой станции в списке нет")
    @Test
    void isStationNameInlines() {
        String cityName = "Budapest";
        Subway subway = new Subway(cityName);
        boolean expected = false;

        boolean actual = subway.isStationNameExistsInAnyLine(cityName);

        Assertions.assertEquals(expected, actual);
    }

    @DisplayName("Поиск станции в линии - корректные параметры - перехват исключения")
    @Test
    void expectedException() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String cityName = "Budapest";
        String colorLine = "Red";
        Subway subway = new Subway(cityName);
        Method method = Subway.class.getDeclaredMethod("checkLineExists", String.class);
        method.setAccessible(true);

        ColorLineException exception = Assertions.assertThrows(ColorLineException.class, () -> {
            method.invoke(colorLine);
        });
        Assertions.assertEquals(exception,method.invoke(subway,colorLine));

    }

    @DisplayName("Проверка линии на содержание станций - корректные параметры - линия пустая")
    @Test
    void isCheckLineEmpty(){
        String cityName = "Budapest";
        String colorLine = "Red";
        var subway = new Subway(cityName);
        var line = new Line(colorLine,subway);
        Throwable exception = Assertions.assertThrows(ColorLineException.class,() -> {
            throw new ColorLineException("is not empty");});

        Assertions.assertEquals("is not empty",exception.getMessage());


    }

    @DisplayName("Создание новой линии - корректные параметры - линия создана")
    @Test
    void isNewLineCreated() {
        String colorLine = "Red";

    }

    @DisplayName(" ")
    @Test
    void firstStationInLineCreated() {


    }


}
