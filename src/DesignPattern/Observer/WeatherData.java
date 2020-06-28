package DesignPattern.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author haiboWu
 * @create 2020-06-11 19:33
 */
public class WeatherData  implements Subject{
    private List<Observer> list;
    private float temperature;
    public WeatherData(){
        list=new ArrayList<>();
    }

    public void setTemperature(float temperature){
        this.temperature=temperature;
        notifyObserver();
    }

    @Override
    public void addObserver(Observer o) {
            list.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        list.remove(o);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : list) {
            observer.update(temperature);
        }
    }
}
