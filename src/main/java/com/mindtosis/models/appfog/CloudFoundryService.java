package com.mindtosis.models.appfog;

/**
 * Created with IntelliJ IDEA.
 * User: Hoover
 * Date: 3/24/13
 * Time: 3:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class CloudFoundryService {

    private Credentials credentials;
    private String label;
    private String name;
    private String plan;
    private String[] tags;

    public Credentials getCredentials() {
        return credentials;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }
}
