package com.alfabank.currence_project.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@ComponentScan
@Component
public class Gif {

    @Value("${gif.today}")
    private String upQuotes;

    @Value("${gif.yesterday}")
    private String lowQuotes;

    public String getUpQuotes() {
        return upQuotes;
    }

    public void setUpQuotes(String upQuotes) {
        this.upQuotes = upQuotes;
    }

    public String getLowQuotes() {
        return lowQuotes;
    }

    public void setLowQuotes(String lowQuotes) {
        this.lowQuotes = lowQuotes;
    }
}


