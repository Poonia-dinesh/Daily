package prototypeDesign;

public class CheckNetworkConnection {
    public static void main(String[] args) throws InterruptedException, CloneNotSupportedException {
        NetworkConnection networkConnection = new NetworkConnection();
        networkConnection.setIpAdrees("160.50.2.50");
        networkConnection.loadData();

        NetworkConnection netcon2 =(NetworkConnection)networkConnection.clone();
        System.out.println(networkConnection);
        networkConnection.getListData().remove(0);
        System.out.println(networkConnection);
        System.out.println(netcon2);

    }
}
