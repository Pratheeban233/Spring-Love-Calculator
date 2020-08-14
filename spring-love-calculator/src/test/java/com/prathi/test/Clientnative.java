package com.prathi.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class Clientnative {

	
	 public static Resource getTestFile() throws IOException {
	        Path testFile = Files.createTempFile("test-file", ".txt");
	        System.out.println("Creating and Uploading Test File: " + testFile);
	        Files.write(testFile, "Hello World !!, This is a test file.".getBytes());
	     //   return new FileSystemResource(new File("D:\\Code_test\\test-file.txt"));
	        System.out.println(new FileSystemResource(new File("D:\\Code_test\\test file.txt")));
	      return new FileSystemResource(testFile);
	    }
	 
	 
	public static void main(String[] args) throws Exception {
		
		RestTemplate rest = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic YXBpa2V5Okg3Wjhsa2o4SGRIejQ2SE5Kc2ZmOTc4ODk3ODc4TktKRE5ra2ZoanNka2Y0RnRoakQ3OA==");
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);
		
		File fileName= new File("D:\\Code_test\\test file.txt");
		MultiValueMap<String, Object> body
		  = new LinkedMultiValueMap<>();
		body.add("file", new FileSystemResource(fileName));
		HttpEntity<MultiValueMap<String, Object>> requestEntity
		 = new HttpEntity<>(body, headers);
		
		
		ResponseEntity<String> responseEntity = rest.exchange("https://d3ao79ffbu8nst.cloudfront.net/cms_api/v1/upload_transactions", 
				HttpMethod.POST, requestEntity, String.class);
		HttpStatus httpStatus = responseEntity.getStatusCode();
		int status = httpStatus.value();
		String response = responseEntity.getBody();
		System.out.println("Response status: " + status);
		System.out.println(response);

	}

}
