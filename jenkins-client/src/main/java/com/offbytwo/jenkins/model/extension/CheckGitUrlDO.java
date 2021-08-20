package com.offbytwo.jenkins.model.extension;

public class CheckGitUrlDO {

    /**
     * true: success, false: failed
     */
    private boolean status;
    private String message;

    public CheckGitUrlDO(boolean status, String message) {
        this.status = status;
        this.message = message;
    }

    public CheckGitUrlDO() {
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

