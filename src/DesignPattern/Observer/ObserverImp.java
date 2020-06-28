package DesignPattern.Observer;

/**
 * @author haiboWu
 * @create 2020-06-11 19:37
 */
public class ObserverImp implements Observer{

    public ObserverImp (WeatherData data){
        data.addObserver(this);
    }
    @Override
    public void update(float temperature) {
        System.out.println("the current temperature is "+temperature);
    }
}
