package com.emilewashu.scraperbackend;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.web.server.Cookie.SameSite;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

@Component
@CrossOrigin(origins = "http://localhost:3005")

public class Scraper {


    public List<PlayerData> retrieveData() {

        List<PlayerData> data = new ArrayList<>();

        String url = "https://www.bbc.com/sport/football/premier-league/top-scorers";
        
     try {

        Document webpage = Jsoup.connect(url).get();

        // Elements tables = webpage.getElementsByClass("wikitable");
        // Element table = tables.get(5); // Select the 6th table (index 5)
        // Element tbody = table.getElementsByTag("tbody").first();        
        Element table = webpage.select("table.gs-o-table").first();
        Element tbody = table.select("tbody.gel-long-primer").first();
        List<Element> rows = tbody.children();

        for (Element row : rows)
        {
            List<Element> tds = row.getElementsByTag("td");

            if (tds.size() < 3)            
                continue;

            int rank = parseNumber(row.select("td.gs-o-table__cell:nth-of-type(1)").text() );
            String name = row.select(".gs-u-vh").get(0).text();
            String club = row.select(".gs-u-vh").get(1).text();;
            int goals = parseNumber(row.select("td.gs-o-table__cell--right.gs-o-table__cell:nth-of-type(3)").text());
            int games = parseNumber(row.select("td.gs-o-table__cell--right.gs-o-table__cell:nth-of-type(5)").text());
            int gc = parsePercentage(row.select("td.gs-u-display-none.gs-o-table__cell--right.gs-o-table__cell:nth-of-type(9)").text());
            int shots = parsePercentage( row.select("td.gs-u-display-none.gs-o-table__cell--right.gs-o-table__cell:nth-of-type(10)").text() );

            data.add(new PlayerData(rank, name, club, goals, games, gc, shots) );
            
        }

     } 
        catch (Exception e) {
          // TODO: handle exception
        }

       return data;


    }

    private Integer parseNumber(String text) {
        String numberText = text.replace(",", "");

        try {return Integer.parseInt(numberText); } 

        catch (NumberFormatException e) {
            return null;
        }
    }
    private int parsePercentage(String text) {
        // Remove the percentage symbol from the text
        String numberText = text.replace("%", "");
    
        try {
            return Integer.parseInt(numberText);
        } catch (NumberFormatException e) {
            // Handle the exception, such as returning a default value or throwing an exception
            // For example, you can return -1 to indicate an error condition
            return -1;
        }
    }



}

