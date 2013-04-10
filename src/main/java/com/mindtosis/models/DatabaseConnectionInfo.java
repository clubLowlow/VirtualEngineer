package com.mindtosis.models;

import com.mindtosis.models.appfog.CloudFoundryServices;
import com.mindtosis.models.appfog.Credentials;
import com.mindtosis.utils.CloudFoundryServicesParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: Hoover
 * Date: 3/24/13
 * Time: 3:32 PM
 * To change this template use File | Settings | File Templates.
 */

@Component
public class DatabaseConnectionInfo {

    public static final String mysql51name = "mysql-5.1";

    private boolean initialized = false;

    @Autowired
    private CloudFoundryServicesParser cloudFoundryServicesParser;

    private CloudFoundryServices cloudFoundryServices;

    private void initialize(){
        if(!initialized){
            initialized = true;
            cloudFoundryServices = cloudFoundryServicesParser.parse(System.getenv("VCAP_SERVICES"));
        }
    }

    public String getDriverClassName(){
        return "com.mysql.jdbc.Driver";
    }

    public String getUrl(){
        return getCredentials().getHost();
    }

    public String getUsername(){
        return getCredentials().getUsername();
    }

    public String getPassword(){
        return getCredentials().getPassword();
    }

    private Credentials getCredentials(){
        return getCloudFoundryServices().getServices().get(mysql51name).get(0).getCredentials();
    }

    public CloudFoundryServices getCloudFoundryServices() {
        initialize();
        return cloudFoundryServices;
    }

    public void setCloudFoundryServices(CloudFoundryServices cloudFoundryServices) {
        this.cloudFoundryServices = cloudFoundryServices;
    }
}
