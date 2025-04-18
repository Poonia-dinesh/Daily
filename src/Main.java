import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        System.out.println("Hello world!");
        System.out.println(SingletonDesignPattern.getObj().hashCode());
        System.out.println(SingletonDesignPattern.getObj().hashCode());
        Constructor<SingletonDesignPattern> cost = SingletonDesignPattern.class.getDeclaredConstructor();
        cost.setAccessible(true);
        SingletonDesignPattern obj2 = cost.newInstance();
        System.out.println(obj2.hashCode());
    }
}