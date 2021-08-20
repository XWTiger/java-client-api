package com.offbytwo.jenkins.model.extension;

import java.util.Date;

public class JobFileDO {

    private String name;

    /**
     * directory or file
     */
    private FileType type;

    private String fileSize;

    private String createTime;

    public JobFileDO(String name, FileType type, String fileSize, String createTime) {
        this.name = name;
        this.type = type;
        this.fileSize = fileSize;
        this.createTime = createTime;
    }

    public JobFileDO() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FileType getType() {
        return type;
    }

    public void setType(FileType type) {
        this.type = type;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}

enum FileType {
    FILE,
    DIRECTORY

}
