package lld.designpatterns.behavioral.observerdesignpattern.pullmodel;

public class CurrentConditionDisplay implements WeatherObserver{
    private final WeatherObservable weatherStation;
    public CurrentConditionDisplay(WeatherObservable weatherStation){
        this.weatherStation=weatherStation;
        weatherStation.addObserver(this);
    }
    @Override
    public void update() {
        // Custom update data function for CurrentConditionDisplay
    }

}
