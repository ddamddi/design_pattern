# Design Patterns 2019 Term Project

## Project Objectives: JSoup 기능 확장 및 설계 개선 (Analysis & Extension)
- Java에서 DOM을 사용하여 HTML과 XML을 효과적으로 다룰 수 있는 오픈소스 프로젝트인 Jsoup에 대해 설계패턴을 적용하여 기능 확장과 설계 개선 활동을 수행한다.
- 수업 시간에 다룬 설계패턴 및 객체지향 설계 개념을 적극적으로 활용하며, 그 결과를 문서화해야 한다.
- 기존 Jsoup이 지원하던 기능은 그대로 동작해야 한다.
- 확장된 기능과 설계 개선을 효과적으로 테스트한다. 

## Team members
 - 20144320 김경현
 - 20144367 이동현
 - 20146110 문태현
 - 20145842 최필립

## Schedules
11/13 ~ 11/20 : JSoup 조사 및 분석  
11/20 ~ 11/27 : 기능 확장 및 설계 개선  
11/27 ~ 12/6  : 테스팅  
~ 12/6 : 제출마감  

### 11/19(Tue)
JSoup 조사 및 분석

* example 분석
 ```java
 Document doc = Jsoup.connect("http://en.wikipedia.org/").get();
log(doc.title());
Elements newsHeadlines = doc.select("#mp-itn b a");
for (Element headline : newsHeadlines) {
  log("%s\n\t%s", 
    headline.attr("title"), headline.absUrl("href"));
}
 ```
   1) Jsoup.connect(String url) 메소드를 통해 res, req 생성
   2) get() 메소드를 통해서 html을 받아서 parsing하고 리턴
   3) TreeBuilder 클래스를 상속하는 클래스 HtmlTreeBuilder, XmlTreeBuilder 가 strategy pattern 을 가지고 있음을 확인.
   4) doc.select("#mp-itn b a")를 통해 #mp-itn b a 태그를 가지고 있는 element 리턴
   5) Elements newsHeadlines의 각 element headline의 attribute인 title과 href 출력함을 확인.


### 11/22(금)
1) JSoup 조사 및 분석_(2)
Strategy 패턴 및 Factory Method 패턴 발견 및 문서화
2) 주제 선정 : Jsoup 을 활용한 키워드 기반 이미지 크롤러 기능 확장

### 11/29(금)
1) Jsoup 조사 및 분석_(3)
Visitor 패턴 발견 및 문서화
2) 확장 기능 구현에 적용할 패턴 선정 및 문서화

### 12/3(화)
1) Exception Handling
2) 확장 기능 구현 및 Testing 진행
3) 진행 내용 문서화

### 12/6(금)
1) Exception Handling
2) Testing 진행 및 문서화
3) 전체 Code refactoring 및 문서화 마무리

## References
https://jsoup.org/  
https://github.com/jhy/jsoup/
