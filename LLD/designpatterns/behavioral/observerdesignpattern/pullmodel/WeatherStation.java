package lld.designpatterns.behavioral.observerdesignpattern.pullmodel;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements WeatherObservable{
    List<WeatherObserver> observers;
    private float temperature;
    private float humidity;
    WeatherStation(){
        observers=new ArrayList<>();
    }
    @Override
    public void addObserver(WeatherObserver observer) {
       observers.add(observer);
    }

    @Override
    public void removeObserver(WeatherObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(WeatherObserver observer:observers){
            observer.update();
        }
    }

    @Override
    public void setWetherReadings(float temperature, float humidity) {
        this.temperature=temperature;
        this.humidity=humidity;
        notifyObservers();
    }

}
