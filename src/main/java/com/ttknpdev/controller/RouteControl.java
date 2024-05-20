package com.ttknpdev.controller;

import com.ttknpdev.logging.Logback;
import com.ttknpdev.resttemplate.RequestRenderServiceServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

/**
 * Note , render sleeps free service server after 15 minute
 */
@RestController
public class RouteControl {

    private final DateTimeFormatter DATETIME_FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    private Logback logback;

    /**
     * my solution for active server
     */
    private RequestRenderServiceServer requestRenderServiceServer;

    public RouteControl() {
        logback = new Logback(RouteControl.class);
        requestRenderServiceServer = new RequestRenderServiceServer();
    }

    @GetMapping(value = "/server")
    public ResponseEntity<String> testServer() {
        return ResponseEntity.ok("ok");
    }

    @GetMapping(value = "/initial-reminder")
    private ResponseEntity<String> initial() {

        logback.log.info("user requested /initial-reminder");
        // for using while loop
        boolean condition = true;
        /*
          var in Java ช่วยให้นักพัฒนาสามารถประกาศตัวแปรในเครื่องได้โดยไม่ต้องระบุประเภทข้อมูล เช่น int, long, String หรือ char
        */
        // prepare variables
        int day, hour;
        int timeout = 10;

        String currentTime, message;

        while (condition) {

            try {

                // any rounds will get set of current datetime
                currentTime = getSetOfCurrentDateTime()[0].toString();
                day = (int) getSetOfCurrentDateTime()[1];
                hour = (int) getSetOfCurrentDateTime()[2];

                // Ex, 10-05-2024 16:29:05
                logback.log.debug("currentTime : {}", currentTime);

                // days 11 , 12 , ... , 14
                if (day != 31) {
                    logback.log.debug("day : {}", day);
                    TimeUnit.MINUTES.sleep(timeout);
                    requestRenderServiceServer.requestRenderServer();
                    logback.log.debug("after 10 minutes sent message,sticker to line (About 7 AM)");
                }

                // day 15 change condition to be false
                else {
                    logback.log.info("day : {} , Application is gonna close", day);
                    condition = false;
                }
            } catch (Exception exception) {

                // catch some error
                logback.log.debug("exception : {}", exception);
            }

        } // ended while loop

        return ResponseEntity.ok("ok");

    }


    /**
     * have to set ZoneId abs class for Asia , cause in container it does not know time zone
     */
    private Object[] getSetOfCurrentDateTime() {
        ZoneId zoneId = ZoneId.of("Asia/Jakarta");
        ZonedDateTime currentTime = ZonedDateTime.now(zoneId);
        return new Object[]{
                DATETIME_FORMAT.format(currentTime),
                currentTime.getDayOfMonth(),
                currentTime.getHour(),
                currentTime.getMinute()
        };
    }

}
