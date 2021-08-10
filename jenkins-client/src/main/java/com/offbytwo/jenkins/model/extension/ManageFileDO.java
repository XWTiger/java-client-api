package com.offbytwo.jenkins.model.extension;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ManageFileDO {
    @JsonProperty("stapler-class")
    private String staplerClass = "org.jenkinsci.plugins.configfiles.maven.GlobalMavenSettingsConfig";
    private String id;
    private String providerId = "org.jenkinsci.plugins.configfiles.maven.GlobalMavenSettingsConfig";
    private String name;
    private String comment;
    private boolean isReplaceAll = true;
    private String content;

    public String getStaplerClass() {
        return staplerClass;
    }

    public void setStaplerClass(String staplerClass) {
        this.staplerClass = staplerClass;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isReplaceAll() {
        return isReplaceAll;
    }

    public void setReplaceAll(boolean replaceAll) {
        isReplaceAll = replaceAll;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
