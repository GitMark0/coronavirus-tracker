package com.example.demo.services;

import com.example.demo.models.LocationStats;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class CoronavirusDatabaseService {
    private static String DATA_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";
    private List<LocationStats> locationStatsList = new ArrayList<>();

    @PostConstruct
    @Scheduled(cron = "* * 1 * * *")
    public void scrapeDatabase() throws IOException, InterruptedException {
        List<LocationStats> locationStatsListTemp = new ArrayList<>();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(DATA_URL)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(new StringReader(response.body()));
        for (CSVRecord record : csvParser) {
            String country = record.get("Country/Region");
            String province = record.get("Province/State");
            String latestCases = record.get(record.size() - 1);
            String casesDayBefore = record.get(record.size() - 2);
            Integer casesGrowth = Integer.parseInt(latestCases) - Integer.parseInt(casesDayBefore);
            LocationStats locationStats = new LocationStats(country, province, Integer.parseInt(latestCases), casesGrowth);
            locationStatsListTemp.add(locationStats);
        }

        locationStatsList.forEach(System.out::println);
        this.locationStatsList = locationStatsListTemp;
    }

    public List<LocationStats> getLocationStatsList() {
        return locationStatsList;
    }
}
