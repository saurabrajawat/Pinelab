package helper;


import java.util.Map;
import java.util.Map.Entry;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

import stepdefinition.ServiceHook;

public class APIHelper {

	
	public static Response executePost(String url, String body, Map<String, String> headers, Map<String,String> paraMeters) {
		Response resp = null;

		RequestSpecification request = RestAssured.given().body(body);
		
	    if(paraMeters != null && headers.size() > 0 ) {
	    	for (Entry<String, String> entry : headers.entrySet()) {
				String key = entry.getKey();
				String value = entry.getValue();
				request = request.header(key, value);
			}
	    }
		
		 if(paraMeters != null && paraMeters.size() > 0 ) {
		    	for (Entry<String, String> entry : paraMeters.entrySet()) {
					String key = entry.getKey();
					String value = entry.getValue();
					request = request.queryParam(key, value);
				}
		    }
		 resp = request.post(url);
		 System.out.println("Response :"+resp.prettyPrint());
		return resp;
		
	}
	
	
	public static Response executeGet(String url, Map<String, String> headers, Map<String,String> paraMeters) {
		Response resp = null;

		RequestSpecification request = RestAssured.given();
		
	    if (headers != null && headers.size() > 0 ) {
	    	for (Entry<String, String> entry : headers.entrySet()) {
				String key = entry.getKey();
				String value = entry.getValue();
				request = request.header(key, value);
			}
	    }
		
		 if( paraMeters != null && paraMeters.size() > 0 ) {
		    	for (Entry<String, String> entry : paraMeters.entrySet()) {
					String key = entry.getKey();
					String value = entry.getValue();
					request = request.queryParam(key, value);
				}
		    }
		 
		 resp = request.get(url);
		 System.out.println("Response :"+resp.prettyPrint());
		return resp;
		
	}
}

