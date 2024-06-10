package CNAM.example.CNAM.BACKEND.Services;

import com.sap.conn.jco.ext.DestinationDataEventListener;

import com.sap.conn.jco.ext.DestinationDataProvider;

import java.util.HashMap;

import java.util.Map;

import java.util.Properties;



import java.util.logging.Logger;

public class MyJcoDestinationProvider implements DestinationDataProvider {

    private HashMap<String, Properties> destinationMap = new HashMap();

    private static final Logger LOG = Logger.getLogger(MyJcoDestinationProvider.class.getName());

    private static MyJcoDestinationProvider instance = null;

    public static MyJcoDestinationProvider getInstance() {

        if (instance == null) {
            instance = new MyJcoDestinationProvider();
        }

        return instance;
    }

    public MyJcoDestinationProvider() {

        if (instance == null) {
            instance = this;
        }

    }

    public Boolean addDestinationByName(String destName, Properties destProperties) {
        if (destinationMap.containsKey(destName)) {
            return false;
        } 
        else {
            destinationMap.put(destName, destProperties);
            return true;
        }
    }
    public Boolean deleteDestinationByName(String destName) {
        if (destinationMap.containsKey(destName)) {
            destinationMap.remove(destName);
            return true;
        } 
        else {
          
            return false;
        }
    }

    public Map<String, Properties> getDestinations() {
        return destinationMap;
    }

    @Override

    public void setDestinationDataEventListener(DestinationDataEventListener eventListener) {
    }

    @Override

    public boolean supportsEvents() {
        return false;
    }

    @Override

    public Properties getDestinationProperties(String destination) {

        Properties props = new Properties();
        if (destinationMap.containsKey(destination)) {
            props = destinationMap.get(destination);
            return props;
        } 
        else {
            return null;
        }
    }
}