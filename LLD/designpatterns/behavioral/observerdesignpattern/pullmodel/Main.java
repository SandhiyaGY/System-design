package lld.designpatterns.behavioral.observerdesignpattern.pullmodel;

public class Main {
    WeatherStation weatherStation = new WeatherStation();
    CurrentConditionDisplay currentConditionDisplay=new CurrentConditionDisplay(weatherStation);
}
