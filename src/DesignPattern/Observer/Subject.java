package DesignPattern.Observer;



/**
 * @author haiboWu
 * @create 2020-06-11 19:30
 */
public interface Subject {
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObserver();
}
