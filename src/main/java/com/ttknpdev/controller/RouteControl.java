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
    Note , render sleeps free service server after 15 minute
*/
@RestController
public class RouteControl {

    private final DateTimeFormatter DATETIME_FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    private Logback logback;

    /**
        my solution for active server
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
        int day , hour;
        String currentTime , message;

        while (condition) {

            try {

                // any rounds will get set of current datetime
                currentTime = getSetOfCurrentDateTime()[0].toString();
                day = (int) getSetOfCurrentDateTime()[1];
                hour = (int) getSetOfCurrentDateTime()[2];

                // Ex, 10-05-2024 16:29:05
                logback.log.debug("currentTime : {}", currentTime);

                // days 11 , 12 , ... , 14
                if (day != 20) {

                    logback.log.debug("day : {}",day);

                    int timeout = 10;

                    // if hour == 7 AM Do ...
                    if (hour == 7) {
                        message = "***********\n" +
                                "*******************************\n" +
                                "*******************************\n" +
                                "*******************************\n" +
                                "*******************************\n" +
                                "**** 7 AM , Time to wake up **\n" +
                                "*******************************\n" +
                                "*******************************\n" +
                                "*******************************\n" +
                                "*******************************";
                        // send message,sticker to line
                        // ***** it closes before timing (18 minutes after request) *** because render sleeps

                        // stop all threads 1 hour
                        // ****** new solution 1 hour
                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 10 minutes sent message,sticker to line (About 7 AM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 20 minutes sent message,sticker to line (About 7 AM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 30 minutes sent message,sticker to line (About 7 AM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 40 minutes sent message,sticker to line (About 7 AM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 50 minutes sent message,sticker to line (About 7 AM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 60 minutes sent message,sticker to line (Almost 8 AM)");
                        // ********

                    }

                    // if hour == 8 AM And < 11 AM Do ...
                    else if (hour >= 8 && hour < 11) {
                        message = "***********\n" +
                                "*******************************\n" +
                                "*******************************\n" +
                                "*******************************\n" +
                                "******* 8 AM - 11 AM *********\n" +
                                "****** Time to practice *******\n" +
                                "*********** Maths ************\n" +
                                "*******************************\n" +
                                "*******************************\n" +
                                "*******************************";

                        // ****** new solution 1 hour
                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 10 minutes sent message,sticker to line (About 8 AM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 20 minutes sent message,sticker to line (About 8 AM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 30 minutes sent message,sticker to line (About 8 AM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 40 minutes sent message,sticker to line (About 8 AM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 50 minutes sent message,sticker to line (About 8 AM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 60 minutes sent message,sticker to line (Almost 9 AM)");
                        // ********

                        // ****** 2 hours
                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 70 minutes sent message,sticker to line (About 9 AM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 80 minutes sent message,sticker to line (About 9 AM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 90 minutes sent message,sticker to line (About 9 AM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 100 minutes sent message,sticker to line (About 9 AM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 110 minutes sent message,sticker to line (About 9 AM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 120 minutes sent message,sticker to line (Almost 10 AM)");
                        // ********

                        // ****** 3 hours
                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 130 minutes sent message,sticker to line (About 10 AM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 140 minutes sent message,sticker to line (About 10 AM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 150 minutes sent message,sticker to line (About 10 AM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 160 minutes sent message,sticker to line (About 10 AM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 170 minutes sent message,sticker to line (About 10 AM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 180 minutes sent message,sticker to line (Almost 11 AM)");
                        // ********

                    }

                    // if hour >= 11 AM And < 13 PM Do ...
                    else if (hour >= 11 && hour < 13) {
                        message = "***********\n" +
                                "*******************************\n" +
                                "*******************************\n" +
                                "*******************************\n" +
                                "******** 11 AM - 13 PM *******\n" +
                                "********** Break time *********\n" +
                                "*******************************\n" +
                                "*******************************\n" +
                                "*******************************\n" +
                                "*******************************";


                        // ****** 1 hour
                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 10 minutes sent message,sticker to line (About 11 AM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 20 minutes sent message,sticker to line (About 11 AM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 30 minutes sent message,sticker to line (About 11 AM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 40 minutes sent message,sticker to line (About 11 AM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 50 minutes sent message,sticker to line (About 11 AM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 60 minutes sent message,sticker to line (Almost 12 AM)");
                        // ********

                        // ****** 2 hour
                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 70 minutes sent message,sticker to line (About 12 AM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 80 minutes sent message,sticker to line (About 12 AM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 90 minutes sent message,sticker to line (About 12 AM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 100 minutes sent message,sticker to line (About 12 AM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 110 minutes sent message,sticker to line (About 12 AM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 120 minutes sent message,sticker to line (Almost 13 AM)");
                        // ********

                    }

                    // if hour == 13 PM Do ...
                    else if (hour == 13) {
                        message = "**********\n" +
                                "*******************************\n" +
                                "*******************************\n" +
                                "*******************************\n" +
                                "******** 13 PM - 14 PM *******\n" +
                                "******* Time to reading *******\n" +
                                "*******************************\n" +
                                "*******************************\n" +
                                "*******************************\n" +
                                "*******************************";

                        // ****** 1 hour
                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 10 minutes sent message,sticker to line (About 13 PM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 20 minutes sent message,sticker to line (About 13 PM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 30 minutes sent message,sticker to line (About 13 PM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 40 minutes sent message,sticker to line (About 13 PM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 50 minutes sent message,sticker to line (About 13 PM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 60 minutes sent message,sticker to line (Almost 14 PM)");
                        // ********

                    }

                    // if hour >= 14 PM And < 18 PM Do ...
                    else if (hour >= 14 && hour < 18) {
                        message = "***********\n" +
                                "*******************************\n" +
                                "*******************************\n" +
                                "*******************************\n" +
                                "******** 14 PM - 18 PM *******\n" +
                                "****** Time to practice *******\n" +
                                "*********** Coding ***********\n" +
                                "*******************************\n" +
                                "*******************************\n" +
                                "*******************************";

                        // ****** 1 hour
                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 10 minutes sent message,sticker to line (About 14 PM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 20 minutes sent message,sticker to line (About 14 PM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 30 minutes sent message,sticker to line (About 14 PM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 40 minutes sent message,sticker to line (About 14 PM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 50 minutes sent message,sticker to line (About 14 PM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 60 minutes sent message,sticker to line (Almost 15 PM)");
                        // ********

                        // ****** 2 hour
                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 70 minutes sent message,sticker to line (About 15 PM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 80 minutes sent message,sticker to line (About 15 PM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 90 minutes sent message,sticker to line (About 15 PM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 100 minutes sent message,sticker to line (About 15 PM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 110 minutes sent message,sticker to line (About 15 PM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 120 minutes sent message,sticker to line (Almost 16 PM)");
                        // ********

                        // ****** 3 hour
                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 130 minutes sent message,sticker to line (About 16 PM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 140 minutes sent message,sticker to line (About 16 PM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 150 minutes sent message,sticker to line (About 16 PM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 160 minutes sent message,sticker to line (About 16 PM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 170 minutes sent message,sticker to line (About 16 PM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 180 minutes sent message,sticker to line (Almost 16 PM)");
                        // ********

                        // ****** 4 hour
                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 190 minutes sent message,sticker to line (About 17 PM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 200 minutes sent message,sticker to line (About 17 PM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 210 minutes sent message,sticker to line (About 17 PM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 220 minutes sent message,sticker to line (About 17 PM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 230 minutes sent message,sticker to line (About 17 PM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 240 minutes sent message,sticker to line (Almost 18 PM)");
                        // ********


                    }

                    // if hour == 18 PM Do ...
                    else if (hour == 18) {
                        message = "***********\n" +
                                "*******************************\n" +
                                "*******************************\n" +
                                "*******************************\n" +
                                "******** 18 PM - 19 PM *******\n" +
                                "********** Break time *********\n" +
                                "*******************************\n" +
                                "*******************************\n" +
                                "*******************************\n" +
                                "*******************************";

                        // ****** new solution 1 hour
                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 10 minutes sent message,sticker to line (About 18 PM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 20 minutes sent message,sticker to line (About 18 PM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 30 minutes sent message,sticker to line (About 18 PM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 40 minutes sent message,sticker to line (About 18 PM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 50 minutes sent message,sticker to line (About 18 PM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 60 minutes sent message,sticker to line (Almost 19 PM)");
                        // ********

                    }

                    // if hour >= 19 PM And < 21 PM Do ...
                    else if (hour >= 19 && hour < 21) {
                        message = "***********\n" +
                                "*******************************\n" +
                                "*******************************\n" +
                                "*******************************\n" +
                                "****** 19 PM - 21 PM *********\n" +
                                "****** Time to practice *******\n" +
                                "************ Maths ***********\n" +
                                "*******************************\n" +
                                "*******************************\n" +
                                "*******************************";

                        // ****** new solution 1 hour
                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 10 minutes sent message,sticker to line (About 19 PM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 20 minutes sent message,sticker to line (About 19 PM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 30 minutes sent message,sticker to line (About 19 PM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 40 minutes sent message,sticker to line (About 19 PM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 50 minutes sent message,sticker to line (About 19 PM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 60 minutes sent message,sticker to line (Almost 20 PM)");
                        // ********

                        // ****** 2 hour
                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 70 minutes sent message,sticker to line (About 20 PM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 80 minutes sent message,sticker to line (About 20 PM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 90 minutes sent message,sticker to line (About 20 PM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 100 minutes sent message,sticker to line (About 20 PM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 110 minutes sent message,sticker to line (About 20 PM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 120 minutes sent message,sticker to line (Almost 21 PM)");
                        // ********

                    }

                    // other case 21 PM - 7 AM *** 10 hours
                    else {
                        message = "***********\n" +
                                "*******************************\n" +
                                "*******************************\n" +
                                "*******************************\n" +
                                "******* 21 PM - 7 AM *********\n" +
                                "********** Break time *********\n" +
                                "*******************************\n" +
                                "*******************************\n" +
                                "*******************************\n" +
                                "*******************************";

                        // ****** 1 hour
                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 10 minutes sent message,sticker to line (About 21 PM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 20 minutes sent message,sticker to line (About 21 PM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 30 minutes sent message,sticker to line (About 21 PM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 40 minutes sent message,sticker to line (About 21 PM");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 50 minutes sent message,sticker to line (About 21 PM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 60 minutes sent message,sticker to line (Almost 22 PM)");
                        // ********

                        // ****** 2 hour
                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 70 minutes sent message,sticker to line (About 22 PM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 80 minutes sent message,sticker to line (About 22 PM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 90 minutes sent message,sticker to line (About 22 PM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 100 minutes sent message,sticker to line (About 22 PM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 110 minutes sent message,sticker to line (About 22 PM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 120 minutes sent message,sticker to line (Almost 23 PM)");
                        // ********

                        // ****** 3 hour
                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 130 minutes sent message,sticker to line (About 23 PM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 140 minutes sent message,sticker to line (About 23 PM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 150 minutes sent message,sticker to line (About 23 PM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 160 minutes sent message,sticker to line (About 23 PM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 170 minutes sent message,sticker to line (About 23 PM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 180 minutes sent message,sticker to line (Almost 24 AM)");
                        // ********

                        // ****** 4 hour
                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 190 minutes sent message,sticker to line (About 00 AM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 200 minutes sent message,sticker to line (About 00 AM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 210 minutes sent message,sticker to line (About 00 AM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 220 minutes sent message,sticker to line (About 00)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 230 minutes sent message,sticker to line (About 00 AM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 240 minutes sent message,sticker to line (Almost 1 AM)");
                        // ********

                        // ****** 5 hour
                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 250 minutes sent message,sticker to line (About 1 AM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 260 minutes sent message,sticker to line (About 1 AM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 270 minutes sent message,sticker to line (About 1 AM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 280 minutes sent message,sticker to line (About 1 AM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 290 minutes sent message,sticker to line (About 1 AM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 300 minutes sent message,sticker to line (Almost 2 AM)");
                        // ********

                        // ****** 6 hour
                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 310 minutes sent message,sticker to line (About 2 AM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 320 minutes sent message,sticker to line (About 2 AM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 330 minutes sent message,sticker to line (About 2 AM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 340 minutes sent message,sticker to line (About 2 AM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 350 minutes sent message,sticker to line (About 2 AM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 360 minutes sent message,sticker to line (Almost 3 AM)");
                        // ********

                        // ****** 7 hour
                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 370 minutes sent message,sticker to line (About 3 AM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 380 minutes sent message,sticker to line (About 3 AM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 390 minutes sent message,sticker to line (About 3 AM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 400 minutes sent message,sticker to line (About 3 AM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 410 minutes sent message,sticker to line (About 3 AM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 420 minutes sent message,sticker to line (Almost 4 AM)");
                        // ********

                        // ****** 8 hour
                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 430 minutes sent message,sticker to line (About 4 AM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 440 minutes sent message,sticker to line (About 4 AM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 450 minutes sent message,sticker to line (About 4 AM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 460 minutes sent message,sticker to line (About 4 AM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 470 minutes sent message,sticker to line (About 4 AM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 480 minutes sent message,sticker to line (Almost 5 AM)");
                        // ********

                        // ****** 9 hour
                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 490 minutes sent message,sticker to line (About 5 AM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 500 minutes sent message,sticker to line (About 5 AM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 510 minutes sent message,sticker to line (About 5 AM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 520 minutes sent message,sticker to line (About 5 AM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 530 minutes sent message,sticker to line (About 5 AM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 540 minutes sent message,sticker to line (Almost 6 AM)");
                        // ********

                        // ****** 10 hour
                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 550 minutes sent message,sticker to line (About 6 AM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 560 minutes sent message,sticker to line (About 6 AM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 570 minutes sent message,sticker to line (About 6 AM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 580 minutes sent message,sticker to line (About 6 AM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 590 minutes sent message,sticker to line (About 6 AM)");

                        TimeUnit.MINUTES.sleep(timeout);
                        requestRenderServiceServer.requestRenderServer();
                        logback.log.debug("after 600 minutes sent message,sticker to line (Almost 7 AM)");
                        // ********

                        // day is gonna changed
                    }

                    /*
                       after sent message ,sticker
                    */
                }

                // day 15 change condition to be false
                else {
                    logback.log.info("day : {} , Application is gonna close",day);
                    condition = false;
                }
                   /*
                       after sent message ,sticker
                       nothing to do ...
                       this round it ends (go to 872)
                   */
            }

            catch (Exception exception) {

                // catch some error
                logback.log.debug("exception : {}",exception);

            }

        } // ended while loop

        return ResponseEntity.ok("ok");

    }





    /**
        have to set ZoneId abs class for Asia , cause in container it does not know time zone
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
