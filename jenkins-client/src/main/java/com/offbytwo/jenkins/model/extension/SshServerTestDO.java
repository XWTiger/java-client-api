package com.offbytwo.jenkins.model.extension;

public class SshServerTestDO {
    private Boolean success;
    private String msg;

    public SshServerTestDO() {
    }

    public SshServerTestDO(Boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
