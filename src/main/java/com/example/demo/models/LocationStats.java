package com.example.demo.models;

public class LocationStats {
    private String province;
    private String country;
    private int latestTotalCases;
    private int growth;

    public LocationStats(String province, String country, int latestTotalCases, int growth) {
        this.province = province;
        this.country = country;
        this.latestTotalCases = latestTotalCases;
        this.growth = growth;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getLatestTotalCases() {
        return latestTotalCases;
    }

    public void setLatestTotalCases(int latestTotalCases) {
        this.latestTotalCases = latestTotalCases;
    }

    public int getGrowth() {
        return growth;
    }
    @Override
    public String toString() {
        return "LocationStats{" +
                "province='" + province + '\'' +
                ", country='" + country + '\'' +
                ", latestTotalCases=" + latestTotalCases +
                '}';
    }


}
