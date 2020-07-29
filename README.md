#Corona virus tracker web app
Made with Spring Boot framework.
This application was taken from Java Brains course https://www.youtube.com/watch?v=8hjNG9GZGnQ.

#Summation
This app parses data from CSV file at https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv".
For CSV parsing in Java, CSVParser was used from "commons.apache.org".
Application shows number of cases from yesterday and number of all cases from the beginning of pandemic.

#Example of usage

```
* cd "project_directory"
* ./mvnw spring-boot:run
* curl localhost:8080 (in a separate terminal window)
```
