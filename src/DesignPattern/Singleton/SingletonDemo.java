package DesignPattern.Singleton;

/**
 * @author haiboWu
 * @create 2020-06-11 20:07
 */
public class SingletonDemo {
    private volatile SingletonDemo instance;
    private SingletonDemo(){}
    public SingletonDemo getInstance(){
        if(instance==null){
            synchronized(SingletonDemo.class){
                if(instance==null){
                    instance=new SingletonDemo();
                }
            }
        }
        return instance;
    }
}
