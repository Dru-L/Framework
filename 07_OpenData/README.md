## 스프링 부트(Spring Boot)
### 1. 스프링 부트(Spring Boot)
* 스프링은 장점이 많은 개발도구이지만 설정이 매우 복잡하다는 단점이 있다.
* 스프링 부트는 스프링 프레임워크를 더 쉽고 빠르게 이용할 수 있도록 만들어주는 도구이다.
  * 빠르게 스프링 프로젝트를 설정할 수 있다.
  * 스타터를 사용해 간편하게 의존성을 사용할 수 있다.
  * 웹 애플리케이션 서버(WAS)를 내장하고 있어서 따로 설치하지 않아도 독립적으로 실행할 수 있다.
* 스프링과 스프링 부트의 차이
  * 스프링은 애플리케이션을 개발할 때 필요한 환경을 수동으로 구성해야 한다.
  * 스프링 부트는 필요한 환경을 자동으로 구성하기 때문에 수동으로 개발 환경을 구성할 필요가 없다.
  * 스프링 부트는 WAS를 내장하고 있어서 jar 파일만 만들면 별도의 WAS 설정을 하지 않아도 애플리케이션을 실행할 수 있다.
  <table>
    <tr>
        <th>스프링</th>
        <th>스프링 부트</th>
    </tr>
    <tr>
        <td>개발자가 수동으로 설정</td>
        <td>자동 구성</td>
    </tr>
    <tr>
        <td>일부 파일을 XML로 직접 생성하고 관리</td>
        <td>XML을 사용하지 않음</td>
    </tr>
    <tr>
        <td>인메모리 데이터베이스를 지원하지 않음</td>
        <td>인메모리 데이터베이스 자동 설정 지원</td>
    </tr>
    <tr>
        <td>WAS를 별도로 설정</td>
        <td>WAS를 내장하고 있어서 설정이 필요 없다.</td>
    </tr>
  </table>
### 2. 스프링 부트 스타터
* 스프링 부트 스타터는 의존성이 모여있는 그룹이다.
* 스타터를 사용하면 필요한 기능을 간편하게 설정할 수 있다.
* 스타터는 `spring-boot-starter-{작업유형}`으로 작성한다.
  * spring-boot-starter-web
    * Spring MVC를 사용해서 웹 서비스를 개발할 때 필요한 의존성 모음
  * spring-boot-starter-test
    * 스프링 애플리케이션을 테스트하기 위해 필요한 의존성 모음
  * spring-boot-starter-validation
    * 유효성 검사를 위해 필요한 의존성 모음
  * spring-boot-starter-actuator
    * 모니터링을 위해 애플리케이션에서 제공하는 다양한 정보를 제공하기 쉽게하는 의존성 모음
  * spring-boot-starter-jpa
    * ORM을 사용하기 위한 인터페이스의 모음인 JPA를 더 쉽게 사용하기 위한 의존성 모음

### 3. 스프링 부트 코드 이해하기
#### @SpringBootApplication
* 스프링 부트 사용에 필요한 기본 설정을 한다.
  * @SpringBootConfiguration
    * 스프링 부트 관련 설정을 나타내는 어노테이션이다.
    * @Configuration을 상속해서 만든 어노테이션이다.
  * @EnableAutoConfiguration
    * 스프링 부트 자동 구성을 활성화하는 어노테이션이다.
    * 스프링 부트 애플리케이션이 실행될 때 스프링 부트의 메타 파일(spring.factories)을 읽고 정의된 설정들을 자동으로 구성하는 역할을 한다. 
    * spring.factories안에 자동 구성해야하는  목록을 가지고 있다.
  * @ComponentScan
    * 사용자가 등록한 빈을 읽고 등록하는 어노테이션이다.
* SpringApplication.run()는 애플리케이션을 실행한다.
  * 첫 번째 매개값은 스프링 부트 애플리케이션의 메인 클래스로 사용할 클래스를 지정한다.
  * 두 번째 매개값은 커맨드 라인의 인수들을 전달한다.
## 공공데이터(Open Data)
### 1. 공공데이터란?
* 공공 데이터란 정부 또는 공공 기관이 수집하거나 만들어 내는 모든 자료나 정보를 말한다.
### 2. Open API란?
* 오픈 API란 누구나 사용할 수 있도록 공개된 API를 말한다.
* 데이터를 표준화하고 프로그래밍해 외부 소프트웨어 개발자나 사용자들과 공유하는 프로그램이다.
### 3. 공공데이터 포털이란?
* 공공기관이 생성 또는 취득하여 관리하고 있는 공공데이터를 한곳에서 제공하는 통합 창구이다.
* 파일, 오픈 API, 시각화 등 다양한 방식으로 공공데이터를 제공한다.
