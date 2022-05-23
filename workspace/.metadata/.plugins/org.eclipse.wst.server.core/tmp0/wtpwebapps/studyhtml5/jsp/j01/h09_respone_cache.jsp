<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//http 1.1에서 지원하는 헤더: 웹브라우저가 응답결과를 캐시하지 않음
response.setHeader("Cache-Control", "no-cache");

//웹브라우저가 응답결과를 캐시하지 않음(앞/뒤로 가기 no-cache)
response.setHeader("Cache-Control","no-store");

//http 1.0에서 지원하는 헤더: 웹 브라우저가 응답결과를 캐시하지 않음
response.setHeader("Pragma","no-cache");

//http 1.0에서 현재시간 이전으로 캐시하지 않음
response.setHeader("Expires","1L");
%>