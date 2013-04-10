package com.mindtosis.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mindtosis.models.appfog.CloudFoundryServices;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: Hoover
 * Date: 3/21/13
 * Time: 8:11 PM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class CloudFoundryServicesParser {

    public CloudFoundryServices parse(String dbJson){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(CloudFoundryServices.class, new CloudFoundryServicesDeserializer());
        Gson gson = gsonBuilder.create();

        return gson.fromJson(dbJson, CloudFoundryServices.class);
    }
}
