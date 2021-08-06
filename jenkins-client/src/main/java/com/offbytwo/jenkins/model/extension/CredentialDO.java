package com.offbytwo.jenkins.model.extension;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CredentialDO {

    private String scope = "GLOBAL";

    private String username;

    private String password;

    @JsonProperty("$redact")
    private String redact = "password";

    private String id;

    private String description;

    @JsonProperty("stapler-class")
    private String staplerClass = "com.cloudbees.plugins.credentials.impl.UsernamePasswordCredentialsImpl";

    @JsonProperty("$class")
    private String classProperty = "com.cloudbees.plugins.credentials.impl.UsernamePasswordCredentialsImpl";


    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRedact() {
        return redact;
    }

    public void setRedact(String redact) {
        this.redact = redact;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStaplerClass() {
        return staplerClass;
    }

    public void setStaplerClass(String staplerClass) {
        this.staplerClass = staplerClass;
    }

    public String getClassProperty() {
        return classProperty;
    }

    public void setClassProperty(String classProperty) {
        this.classProperty = classProperty;
    }
}
