package lld.designpatterns.behavioral.observerdesignpattern.pullmodel;

public interface WeatherObservable {
    void addObserver(WeatherObserver observer);
    void removeObserver(WeatherObserver observer);
    void notifyObservers();
    void setWetherReadings(float temperature,float humidity);   
}
