package com.offbytwo.jenkins;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import org.apache.commons.collections.CollectionUtils;
import org.dom4j.DocumentException;
import org.dom4j.io.DOMReader;
import org.dom4j.io.SAXReader;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.FormElement;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Test {


    public static String getStringStream(String sInputString){
        if (sInputString != null && !sInputString.trim().equals("")){
            try{
                File file = new File("D:\\曙光\\jenkins\\credential.html");
                BufferedReader reader = null;
                StringBuffer sbf = new StringBuffer();
                try {
                    reader = new BufferedReader(new FileReader(file));
                    String tempStr;
                    while ((tempStr = reader.readLine()) != null) {
                        sbf.append(tempStr);
                    }
                    reader.close();
                    return sbf.toString();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return sbf.toString();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return null;
    }


    public static void main(String[] args) {



        Document document = Jsoup.parse(getStringStream("ss"));
        Elements elements = document.getElementsByClass("sortable pane bigtable");
        //useful table
        Element element = elements.first();
        Elements trs = element.getElementsByTag("tr");
        trs.stream().forEach(tr -> {
            Elements tds = tr.getElementsByTag("td");
            if (Objects.nonNull(tds) && tds.size() > 0) {
                System.out.println("=====================");
                System.out.println(tds.get(1).text());
                System.out.println(tds.get(2).text());
                System.out.println(tds.get(3).text());
                System.out.println(tds.get(4).text());
                System.out.println("=====================");
                System.out.println("");
            }
        });

    }
}
