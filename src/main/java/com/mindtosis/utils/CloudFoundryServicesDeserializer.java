package com.mindtosis.utils;

import com.google.gson.*;
import com.mindtosis.models.appfog.CloudFoundryService;
import com.mindtosis.models.appfog.CloudFoundryServices;

import java.lang.reflect.Type;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: Hoover
 * Date: 3/24/13
 * Time: 2:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class CloudFoundryServicesDeserializer implements JsonDeserializer<CloudFoundryServices> {

    public static final String mysql51name = "mysql-5.1";

    @Override
    public CloudFoundryServices deserialize(final JsonElement json,
                                                final Type typeOfT,
                                                final JsonDeserializationContext context) throws JsonParseException {
        CloudFoundryServices cloudFoundryServices = new CloudFoundryServices();

        JsonObject jsonObject = json.getAsJsonObject();
        JsonArray servicesArray = jsonObject.get(mysql51name).getAsJsonArray();
        Gson gson = new GsonBuilder().create();

        Iterator<JsonElement> servicesIterator = servicesArray.iterator();
        while(servicesIterator.hasNext()){
            CloudFoundryService service = gson.fromJson(servicesIterator.next(), CloudFoundryService.class);
            cloudFoundryServices.add(mysql51name, service);
        }

        return cloudFoundryServices;
    }
}
