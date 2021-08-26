package com.offbytwo.jenkins;

import com.offbytwo.jenkins.model.JobWithDetails;
import com.offbytwo.jenkins.model.extension.CheckGitUrlDO;
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
import java.net.URI;
import java.net.URISyntaxException;
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


        try {
            JenkinsServer jenkinsServer = new JenkinsServer(new URI("http://172.22.1.7:8889", "admin", "Jenkins@12345"));

            JobWithDetails job = jenkinsServer.getJob("test222-6fee4dfc");

            //CheckGitUrlDO checkGitUrlDO = jenkinsServer.checkGitUrl("https://172.22.5.3/full-stack-cloud/sugoncloud-cci.git", "8fe84b27-d0a1-4572-be11-7381c307c325", "blank");
            String result = jenkinsServer.checkSshServer("tiggerrr-ddssss", "172.22.1.9", "root", "22", "/root", "admin1234@sugon");
            System.out.println("===========>" + result);
            //System.out.println(checkGitUrlDO.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
