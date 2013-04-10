package com.mindtosis.utils;

import com.mindtosis.models.appfog.CloudFoundryService;
import com.mindtosis.models.appfog.CloudFoundryServices;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: Hoover
 * Date: 3/24/13
 * Time: 1:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class CloudFoundryServicesParserTest {

    private String json = "{ \"mysql-5.1\" :\n" +
            "  [\n" +
            "      { \"credentials\" :\n" +
            "      { \"host\" : \"test_host\",\n" +
            "        \"hostname\" : \"test_hostname\",\n" +
            "        \"name\" : \"test_name\",\n" +
            "        \"password\" : \"test_password\",\n" +
            "        \"port\" : test_port,\n" +
            "        \"user\" : \"test_user\",\n" +
            "        \"username\" : \"test_username\"\n" +
            "    },\n" +
            "        \"label\" : \"mysql-5.1\",\n" +
            "        \"name\" : \"test_service_name\",\n" +
            "        \"plan\" : \"free\",\n" +
            "        \"tags\" : [ \"mysql\",\n" +
            "            \"mysql-5.1\",\n" +
            "            \"relational\",\n" +
            "            \"mysql-5.1\",\n" +
            "            \"mysql\"\n" +
            "    ]\n" +
            "} ] }";


    @Test
    public void parse() throws Exception{
        CloudFoundryServicesParser classUnderTest = new CloudFoundryServicesParser();
        CloudFoundryServices services = classUnderTest.parse(json);
        CloudFoundryService service = services.getServices().get("mysql-5.1").get(0);
        assertThat(service.getCredentials().getHost(), is("test_host"));
        assertThat(service.getCredentials().getHostname(), is("test_hostname"));
        assertThat(service.getCredentials().getName(), is("test_name"));
        assertThat(service.getCredentials().getPassword(), is("test_password"));
        assertThat(service.getCredentials().getPort(), is("test_port"));
        assertThat(service.getCredentials().getUser(), is("test_user"));
        assertThat(service.getCredentials().getUsername(), is("test_username"));
        assertThat(service.getLabel(), is("mysql-5.1"));
        assertThat(service.getName(), is("test_service_name"));
        assertThat(service.getPlan(), is("free"));
        assertThat(service.getTags()[0], is("mysql"));
        assertThat(service.getTags()[1], is("mysql-5.1"));
        assertThat(service.getTags()[2], is("relational"));
        assertThat(service.getTags()[3], is("mysql-5.1"));
        assertThat(service.getTags()[4], is("mysql"));
    }
}
