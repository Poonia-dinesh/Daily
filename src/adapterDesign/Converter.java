package adapterDesign;

public class Converter implements IphoneCharger{

    private AndroidCharger androidCharger;
    public Converter(AndroidCharger androidCharger){
        this.androidCharger = androidCharger;
    }

    @Override
    public void chargePhone() {
        androidCharger.chargeAndroid();
        System.out.println("Iphone charging with android charger");

    }
}
