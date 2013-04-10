package com.mindtosis.models.appfog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Hoover
 * Date: 3/24/13
 * Time: 1:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class CloudFoundryServices {

    private Map<String, List<CloudFoundryService>> services = new HashMap<String, List<CloudFoundryService>>();

    public Map<String, List<CloudFoundryService>> getServices() {
        return services;
    }

    public void setServices(Map<String, List<CloudFoundryService>> services) {
        this.services = services;
    }

    public void add(String name, CloudFoundryService service){
        if(services.get(name)==null){
            services.put(name, new ArrayList<CloudFoundryService>());
        }

        services.get(name).add(service);
    }
}
