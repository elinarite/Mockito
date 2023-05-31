package mockito.task1;

import java.util.HashMap;
import java.util.Map;

//Создайте класс WeatherService, который зависит от класса WeatherAPI.
//        WeatherAPI содержит метод getTemperature(String city), возвращающий текущую температуру в
//        указанном городе. Напишите тест, используя Mockito, чтобы проверить, что метод getTemperature был
//        вызван с правильным городом и обработан правильно.
public class WeatherService {
    private WeatherAPI weatherAPI;

    public WeatherService() {
    }

    public WeatherService(WeatherAPI weatherAPI) {
        this.weatherAPI = weatherAPI;
    }

    public Map<String, Integer> getTemperatureForCities(String[] cities) {
        Map<String, Integer> temperaturMap = new HashMap<>();

        for (String city : cities) {
            int temperature = weatherAPI.getTemperature(city);
            temperaturMap.put(city, temperature);
        }
        return temperaturMap;
    }
}