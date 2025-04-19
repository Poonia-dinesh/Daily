package adapterDesign;

public class InphoneChargeSystem {
    private IphoneCharger iphoneCharger;

    public InphoneChargeSystem(IphoneCharger iphoneCharger){
        this.iphoneCharger = iphoneCharger;
    }
    public void chargeIphone(){
        iphoneCharger.chargePhone();

    }
}
