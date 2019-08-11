package com.dev.ams.utils;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class AWSUtils {

    private static Map<String, String> getAccessKeys() {
        Map<String, String> accessKeyMap = new HashMap<>();
        try (InputStream input = new FileInputStream(System.getProperty("user.home") + "/aws.properties")) {

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            accessKeyMap.put("accessId", prop.getProperty("aws_access_key_id"));
            accessKeyMap.put("accessSecret", prop.getProperty("aws_secret_access_key"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return accessKeyMap;
    }

    public static AmazonS3 getAmazonS3Client() {
        Map<String, String> accessKeyMap = getAccessKeys();
        AWSCredentials credentials = new BasicAWSCredentials(
                accessKeyMap.get("accessId"),
                accessKeyMap.get("accessSecret")
        );
        return AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(Regions.US_EAST_1)
                .build();
    }
}
