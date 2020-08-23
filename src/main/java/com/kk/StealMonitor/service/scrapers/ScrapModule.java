package com.kk.StealMonitor.service.scrapers;
import java.io.IOException;

import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

@Service
public class ScrapModule {

    public String getStringByClass(Element el, String className, int index) throws IOException {
        String str;
        str = el.getElementsByClass(className).get(index).text();
        return str;
    }

    public String getLinkFromAHref(Element el, int index) throws IOException {
        String relHref;
        Element link = el.select("a").get(index);
        relHref = link.attr("href");
        return relHref;
    }

    public String getStringImageByClass(Element el, String className, int index) throws IOException {
        Element imgElement = el.getElementsByClass(className).get(index);
        String imgString = imgElement.absUrl("src");
        return imgString;
    }

    public String getImageStringByTag(Element el, int index) throws IOException {
        String str;
        Element image = el.getElementsByTag("img").get(index);
        str = image.absUrl("src");
        return str;
    }

    public String addTwoNumbersInString(String n, String m) {
        int i = Integer.parseInt(n);
        int j = Integer.parseInt(m);
        int k = i+j;
        String sum= ""+k;
        return sum;
    }

    public String substringNum(String text, int startIndex, int endIndex) throws IOException {
        return text.substring(startIndex, endIndex);
    }

}