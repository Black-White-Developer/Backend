package com.github.cokothon.common.s3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.github.cokothon.common.property.AwsProperty;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class S3Config {

	private final AwsProperty awsProperty;

	@Bean
	public AWSCredentialsProvider awsCredentials() {
		AWSCredentials awsCredentials = new BasicAWSCredentials(awsProperty.getCredential().getAccessKey(), awsProperty.getCredential().getSecretKey());
		return new AWSStaticCredentialsProvider(awsCredentials);
	}

	@Bean
	public AmazonS3Client amazonS3Client() {
		return (AmazonS3Client) AmazonS3ClientBuilder.standard()
													 .withRegion(awsProperty.getRegion())
													 .withCredentials(awsCredentials())
													 .build();
	}
}