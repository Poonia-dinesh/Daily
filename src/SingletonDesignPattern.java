public class SingletonDesignPattern {

    // Lazily
    // ++ volatile - reordering by the JVM or CPU
    private static SingletonDesignPattern obj;

    // Eager
    // private static  SingletonDesignPattern obj = new SingletonDesignPattern();

    private SingletonDesignPattern()
    {
        if(obj != null){
            throw new RuntimeException("Heyyyy don't try to break me");
        }
    }

    public static SingletonDesignPattern getObj()
    {
        if(obj == null) {
            synchronized (SingletonDesignPattern.class) {
                if(obj == null)  obj = new SingletonDesignPattern();
            }
        }
        return obj;
    }


    // Reflection -> Throw Exception from constructor, ENUM
    //Cloning -> Override clone method and return same obj
    // Deserialize -> implement readResolve method
}
