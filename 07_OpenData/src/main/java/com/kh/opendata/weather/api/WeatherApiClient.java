package com.kh.opendata.weather.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.Spring;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class WeatherApiClient {
	private final RestTemplate restTemplate;
	private String baseURL = "http://apis.data.go.kr/1360000/TourStnInfoService1/";
	private String serviceKey = "CiKzCJPsFO5AOL%2BobIeo3HUm9tV6eaY8ipr9dE%2FYuY4U%2FExjLsLK%2BvMmEVnGlbUGlj8VaLJw6IAfgbjEsG8e6w%3D%3D";
	
	public String apiTourStnVilageV1(String pageNo, String courseId) {
		URL url = null;
		BufferedReader reader = null;
		String currentDate = null;
		StringBuilder urlBuilder = null;
		StringBuilder responseTextBuilder = null;
		HttpURLConnection connection = null;
		
		try {
			urlBuilder = new StringBuilder(baseURL + "getTourStnVilageFcst1");
			currentDate = LocalDate.now()
	//				.format(DateTimeFormatter.BASIC_ISO_DATE);//현재 년월일 정보
					.format(DateTimeFormatter.ofPattern("yyyyMMdd"));//현재 년월일 정보
			
			urlBuilder.append("?ServiceKey=").append(serviceKey);
			urlBuilder.append("&pageNo=").append(pageNo);
			urlBuilder.append("&numOfRows=").append("10");
			urlBuilder.append("&dataType=").append("JSON");
			urlBuilder.append("&CURRENT_DATE=").append(currentDate);
			urlBuilder.append("&HOUR=").append("0");
			urlBuilder.append("&COURSE_ID=").append(courseId);
			
			log.info("Request URL : {}",urlBuilder.toString());
			
			url = new URL(urlBuilder.toString());
			connection = (HttpURLConnection) url.openConnection();
			
			connection.setRequestMethod("GET");
			
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			responseTextBuilder = new StringBuilder();
			String line;
			
			while ((line = reader.readLine()) != null) {
				responseTextBuilder.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
				connection.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return responseTextBuilder.toString();
	}
	
	public String apiTourStnVilageV2(String pageNo, String courseId) throws RestClientException, URISyntaxException {
		String currentDate = null;
		StringBuilder urlBuilder = null;
		
		urlBuilder = new StringBuilder(baseURL + "getTourStnVilageFcst1");
		currentDate = LocalDate.now()
//				.format(DateTimeFormatter.BASIC_ISO_DATE);//현재 년월일 정보
				.format(DateTimeFormatter.ofPattern("yyyyMMdd"));//현재 년월일 정보
		
		urlBuilder.append("?ServiceKey=").append(serviceKey);
		urlBuilder.append("&pageNo=").append(pageNo);
		urlBuilder.append("&numOfRows=").append("10");
		urlBuilder.append("&dataType=").append("JSON");
		urlBuilder.append("&CURRENT_DATE=").append(currentDate);
		urlBuilder.append("&HOUR=").append("0");
		urlBuilder.append("&COURSE_ID=").append(courseId);
		
		log.info("Request URL : {}",urlBuilder.toString());
		
		
		return restTemplate.getForObject(new URI(urlBuilder.toString()), String.class);
	}
	
//	public String apiCityTour(String pageNo, String cityAreaId) throws RestClientException, URISyntaxException {
	public WeatherResponse apiCityTour(String pageNo, String cityAreaId) throws RestClientException, URISyntaxException {
		String currentDate = null;
		StringBuilder urlBuilder = null;
		
		urlBuilder = new StringBuilder(baseURL + "getCityTourClmIdx1");
		currentDate = LocalDate.now().minusDays(2) //오늘 날짜에서 2일을 뺀다.
				.format(DateTimeFormatter.BASIC_ISO_DATE);
		
		urlBuilder.append("?ServiceKey=").append(serviceKey);
		urlBuilder.append("&pageNo=").append(pageNo);
		urlBuilder.append("&numOfRows=").append("5");
		urlBuilder.append("&dataType=").append("JSON");
		urlBuilder.append("&CURRENT_DATE=").append(currentDate);
		urlBuilder.append("&DAY=").append("4");
		urlBuilder.append("&CITY_AREA_ID=").append(cityAreaId);
		
		log.info("Request URL : {}",urlBuilder.toString());
		
//		return restTemplate.getForObject(new URI(urlBuilder.toString()), String.class);
		return restTemplate.getForObject(new URI(urlBuilder.toString()), WeatherResponse.class);
	}
}
