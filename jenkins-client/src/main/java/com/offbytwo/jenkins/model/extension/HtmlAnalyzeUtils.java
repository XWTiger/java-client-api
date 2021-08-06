package com.offbytwo.jenkins.model.extension;

import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class HtmlAnalyzeUtils {

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
}
