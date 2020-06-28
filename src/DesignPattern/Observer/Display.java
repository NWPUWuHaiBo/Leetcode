package DesignPattern.Observer;

/**
 * @author haiboWu
 * @create 2020-06-11 19:46
 */
public class Display {
    public static void main(String[] args) {
        WeatherData data=new WeatherData();
        Observer observer=new ObserverImp(data);
        data.setTemperature(1.6f);
        data.setTemperature(2.6f);
    }
}
