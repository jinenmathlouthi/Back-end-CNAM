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
            //LOG.log(Level.WARNING, "Unable to load destination " + destName + ", already loaded.");
            return false;
        } 
        else {
            destinationMap.put(destName, destProperties);
            //LOG.log(Level.INFO, "Destination " + destName + " properties added/updated.");
            return true;
        }
    }
    public Boolean deleteDestinationByName(String destName) {
        if (destinationMap.containsKey(destName)) {
            destinationMap.remove(destName);
            //LOG.log(Level.WARNING, "destination " + destName + " deleted.");
            return true;
        } 
        else {
            //destinationMap.put(destName, destProperties);
            //LOG.log(Level.INFO, "Destination " + destName + " not exist.");
            return false;
        }
    }

    public Map<String, Properties> getDestinations() {
        return destinationMap;
    }

    @Override

    public void setDestinationDataEventListener(DestinationDataEventListener eventListener) {
    // nothing to do
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
            //LOG.log(Level.WARNING, "Destination "+destination+" properties not found.");
            return null;
        }
    }
}