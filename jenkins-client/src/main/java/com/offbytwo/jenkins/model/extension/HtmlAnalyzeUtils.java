package com.offbytwo.jenkins.model.extension;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;


/**
 * analyze html to obj
 */
public class HtmlAnalyzeUtils {
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    public static List<CredentialVO> parseCredentialHtml(String html) {
        if (StringUtils.isEmpty(html)) {
            return Collections.EMPTY_LIST;
        }
        List<CredentialVO> list = new ArrayList<>();
        Document document = Jsoup.parse(html);
        Elements elements = document.getElementsByClass("sortable pane bigtable");
        //useful table
        Element element = elements.first();
        Elements trs = element.getElementsByTag("tr");
        if (trs.size() <= 0) {
            return list;
        }
        //get td tag content
        trs.stream().forEach(tr -> {
            Elements tds = tr.getElementsByTag("td");
            if (Objects.nonNull(tds) && tds.size() > 0) {
                CredentialVO credential = new CredentialVO();
                credential.setId(tds.get(1).text());
                credential.setName(tds.get(2).text());
                credential.setKind(tds.get(3).text());
                credential.setDescription(tds.get(4).text());
                list.add(credential);
            }
        });
        return list;
    }

    public static CheckGitUrlDO parseHtmlToDo(String html) {
        Document document = Jsoup.parse(html);
        CheckGitUrlDO checkGitUrlDO = new CheckGitUrlDO();
        Elements elements = document.getElementsByClass("error");
        if (elements.size() <= 0) {
            checkGitUrlDO.setStatus(true);
        } else {
            checkGitUrlDO.setStatus(false);
            checkGitUrlDO.setMessage(elements.first().text());
        }
        return checkGitUrlDO;
    }

    public static List<JobFileDO> parseHtmlToJobFileDO(String html) {
        List<JobFileDO> list = new ArrayList<>();
        Document document = Jsoup.parse(html);
        Elements elements = document.getElementsByClass("fileList");
        //find the filelist table
        Element element = elements.first();
        //find all trs
        Elements trs = element.getElementsByTag("tr");
        if (CollectionUtils.isNotEmpty(trs)) {
            trs.stream().forEach(tr -> {
                Elements tdEles = tr.getElementsByTag("td");
                Elements imgEle = tdEles.get(0).getElementsByTag("img");
                //check img tag
                if (imgEle.size() > 0) {
                    Set<String> classNameList = imgEle.first().classNames();
                    if (classNameList.contains("icon-folder")) {
                        // directory
                        JobFileDO jobFileDO = new JobFileDO();
                        jobFileDO.setType(FileType.DIRECTORY);
                        jobFileDO.setName(tdEles.get(1).text());
                        list.add(jobFileDO);
                    }
                    if (classNameList.contains("icon-text")) {
                        // file
                        JobFileDO jobFileDO = new JobFileDO();
                        jobFileDO.setType(FileType.FILE);
                        jobFileDO.setName(tdEles.get(1).text());
                        jobFileDO.setCreateTime(tdEles.get(2).text());
                        jobFileDO.setFileSize(tdEles.get(3).text());
                        list.add(jobFileDO);
                    }
                }
            });
        }
        return list;
    }

    public static  SshServerTestDO parseTestConnectionSsh(String html) {
        Document document = Jsoup.parse(html);
        SshServerTestDO sshServerTestDO = new SshServerTestDO();
        Elements elements = document.getElementsByClass("ok");
        if (elements.size() > 0) {
            sshServerTestDO.setSuccess(true);
        } else {
            sshServerTestDO.setSuccess(false);
            System.out.println("test connection failed: " + html);
            Elements elementsError = document.getElementsByClass("error");
            if (elementsError.size() > 0) {
                sshServerTestDO.setMsg(elementsError.get(0).getElementsByTag("pre").text());
            }
        }
        return sshServerTestDO;
    }
}
