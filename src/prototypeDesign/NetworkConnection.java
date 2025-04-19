package prototypeDesign;

import java.util.ArrayList;
import java.util.List;

public class NetworkConnection implements Cloneable{

    private String ipAdrees;
    private String bigData;
    private List<String> listData = new ArrayList<>();

    public List<String> getListData() {
        return listData;
    }

    public void setListData(List<String> listData) {
        this.listData = listData;
    }

    public String getIpAdrees() {
        return ipAdrees;
    }

    public void setIpAdrees(String ipAdrees) {
        this.ipAdrees = ipAdrees;
    }

    public void setBigData(String bigData) {
        this.bigData = bigData;
    }

    public String getBigData() {
        return bigData;
    }

    public void loadData() throws InterruptedException {
        this.bigData = "Big Data loading....";

        listData.add("value1");
        listData.add("value2");
        listData.add("value3");
        listData.add("value4");
        Thread.sleep(5000);
    }

    @Override
    public String toString()
    {
        return this.ipAdrees + bigData +" List Data : " + listData;
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        // Deep Copy
        NetworkConnection networkConnection = new NetworkConnection();
        networkConnection.setIpAdrees(this.ipAdrees);
        networkConnection.setBigData(this.bigData);
        for(String data: this.getListData()){
            networkConnection.getListData().add(data);
        }

        // default Shallow copy
//        return super.clone();
        return networkConnection;
    }
}
