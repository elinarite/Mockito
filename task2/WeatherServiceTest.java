package mockito.task2;
//Создайте класс WeatherService, который зависит от класса WeatherAPI.
//        WeatherAPI содержит метод getTemperature(String city), возвращающий текущую температуру в
//        указанном городе. Напишите тест, используя Mockito, чтобы проверить, что метод getTemperature был
//        вызван с правильным городом и обработан правильно.

import mockito.task1.WeatherAPI;
import mockito.task1.WeatherService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Map;

import static org.mockito.Mockito.times;

class WeatherServiceTest {
    WeatherAPI weatherAPI = Mockito.mock(WeatherAPI.class);
    WeatherService weatherService = new WeatherService(weatherAPI);

    @Test
    void getTemperatureForCities() {

        String[] cities = {"Riga", "Berlin", "Kiev"};
        int rigaTemperature = 10;
        int berlinTemperature = 15;
        int kievTemperature = 10;
        Mockito.when(weatherAPI.getTemperature("Riga")).thenReturn(rigaTemperature);
        Mockito.when(weatherAPI.getTemperature("Berlin")).thenReturn(berlinTemperature);
        Mockito.when(weatherAPI.getTemperature("Kiev")).thenReturn(kievTemperature);

        Map<String, Integer> temperaturMap = weatherService.getTemperatureForCities(cities);

        Assertions.assertEquals(rigaTemperature, temperaturMap.get("Riga"));
        Assertions.assertEquals(berlinTemperature, temperaturMap.get("Berlin"));
        Assertions.assertEquals(kievTemperature, temperaturMap.get("Kiev"));
        Mockito.verify(weatherAPI, times(3)).getTemperature(Mockito.anyString());
    }
}