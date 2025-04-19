package adapterDesign;

public class CheckAdapterDesignPattern {
    public static void main(String[] args){

//        InphoneChargeSystem iphone = new InphoneChargeSystem(new IphoneCharger() {
//            @Override
//            public void chargePhone() {
//                System.out.println("Iphone charging.....");
//            }
//        });
        IphoneCharger iphoneCharger = new Converter(new AndroidChargerImpl());

        InphoneChargeSystem inphone = new InphoneChargeSystem(iphoneCharger);

        inphone.chargeIphone();
    }
}
