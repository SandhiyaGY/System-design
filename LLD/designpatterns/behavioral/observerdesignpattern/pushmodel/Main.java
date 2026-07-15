package lld.designpatterns.behavioral.observerdesignpattern.pushmodel;

public class Main {
    public static void main(String[] args) {
        WeatherStation weatherStation=new WeatherStation();
        CurrentConditionDisplay currentConditionDisplay=new CurrentConditionDisplay();
        ForeCastDisplay foreCastDisplay=new ForeCastDisplay();
        weatherStation.addObserver(currentConditionDisplay);
        weatherStation.addObserver(foreCastDisplay);
        weatherStation.removeObserver(foreCastDisplay);
        weatherStation.setWetherReadings(20091,230);
    }
}
