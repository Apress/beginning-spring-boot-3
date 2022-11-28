/**
 *
 */
package com.apress.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;

/**
 * @author Siva
 *
 */
@SpringBootApplication
public class SpringbootTwitter4jDemoApplication implements CommandLineRunner {

    private final Twitter twitter;

    public SpringbootTwitter4jDemoApplication(Twitter twitter) {
        this.twitter = twitter;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringbootTwitter4jDemoApplication.class, args);
    }

    @Override
    public void run(String... arg0) throws Exception {
        ResponseList<Status> homeTimeline = twitter.getHomeTimeline();
        for (Status status : homeTimeline) {
            System.err.println(status.getText());
        }
    }

}
