package com.signifyd.load;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.PutObjectRequest;
import java.io.File;



public class Load {


    public void saveToS3(String fileName){

        Regions clientRegion = Regions.US_EAST_1;
        String bucketName = "files-landing";
        String fileObjKeyName = "*** File object key name ***";


        try {
            AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                    .withRegion(clientRegion)
                    .build();

            PutObjectRequest request = new PutObjectRequest(bucketName, fileObjKeyName, new File(fileName));
            s3Client.putObject(request);
        } catch (AmazonServiceException e) {
            e.printStackTrace();
        }


    }




}
