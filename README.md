## 프레임워크(Framework)
### 1. 프레임워크(Framework)
* 프레임워크(Framework)란, 어느 정도 구현되어 있는 틀을 가지고 그 안에서 기능 구현을 할 수 있도록 여러 가지 기능을 제공하는 소프트웨어이다. 
* 프레임워크는 소프트웨어를 구현하는 개발 시간을 줄이고, 반복적으로 해야 하는 공통적인 부분을 최소화할 수 있도록 설계되어 있다. 
* 프레임워크는 일정 수준 이상의 품질을 보장하는 애플리케이션을 개발할 수 있는 환경을 제공한다.
### 2. 라이브러리와 프레임워크, API
#### 2.1. 라이브러리(Library)
* 라이브러리는 소프트웨어를 개발을 필요한 기능들을 재사용하기 편리하도록 미리 만들어 놓은 도구이다.
#### 2.2. 프레임워크(Framework)
* 프레임워크는 애플리케이션의 공통적인 개발 환경을 제공해 주는 소프트웨어이다. 
* 프레임워크 안에 라이브러리가 포함되어 있고 필요에 따라서 개발자가 라이브러리를 추가할 수 있다.
#### 2.3. API(Application Programming Interface)
* 애플리케이션에서 사용할 수 있도록 운영 체제나 서버, 프로그래밍 언어 등이 제공하는 기능을 제어할 수 있게 만든 인터페이스를 뜻한다.
### 3. 프레임워크의 특징
* 개발자가 따라야 하는 가이드를 제공한다.
* 개발할 수 있는 범위가 정해져 있다.
* 개발자를 위한 다양한 도구, 플러그인들을 지원한다.
#### 3.1. 프레임워크의 장점
* 개발 시간을 줄일 수 있다.
* 유지 보수가 쉽고 추상화된 코드 제공을 통해 확장성이 뛰어나다.
* 정형화되어 있어 일정 수준 이상의 품질을 보장받을 수 있다.
#### 3.2. 프레임워크의 단점
* 기본 설계에 대한 이해가 어렵기 때문에 학습 난이도가 높다.
* 기본 설계된 구조에 의해 자유로운 개발에 한계가 있다.
* 사용하지 않는 기능에 대한 라이브러리가 포함될 수 있다. 
### 4. 프레임워크의 종류
#### 4.1. 영속성 프레임워크
* 데이터의 저장, 조회, 변경, 삭제를 다루는 클래스 및 설정 파일들을 제공하는 프레임워크이다.
  * Mybatis
  * Hibernate
#### 4.2. 자바 웹 프레임워크
* Java EE를 통한 웹 애플리케이션 개발에 초점을 맞추어 필요한 요소들을 모듈화하여 제공하는 프레임워크이다.
  * Spring Framework
  * 전자정부표준 (Spring 기반)
  * Struts
#### 4.3. UI 프레임워크
* UI를 보다 쉽게 구현할 수 있는 도구를 제공하는 프레임워크이다.
  * Bootstrap
  * Quasar Framework
#### 4.4. 기능 및 지원 프레임워크
* 특정 기능이나 업무 수행에 도움을 줄 수 있는 기능을 제공하는 프레임워크이다.
  * Log4j
  * JUnit 5
  * ANT, Maven, Gradle
## 아파치 메이븐(Apache Maven)
### 1. 아파치 메이븐(Apache Maven)
* 메이븐(Maven) 이란 자바용 프로젝트 관리 도구로 프로젝트의 빌드 과정을 자동화해주는 프레임워크이다.
* POM(Project Object Model) XML 문서를 통해 해당 프로젝트의 버전 정보 및 빌드, 라이브러리 정보들을 통합하여 관리한다.
### 2. POM(Project Object Model)
* 프로젝트에서 사용하는 자바 버전, 라이브러리, 플러그인 구성을 통합하여 관리할 수 있게 설정 정보를 XML로 문서화한 것을 말한다.
* 메이븐으로 프로젝트를 생성하면 프로젝트 최상위 디렉터리에 pom.xml 파일이 생성된다. (프로젝트에 1개의 파일만 존재)
* pom.xml에서는 주로 프로젝트 정보, 빌드 환경, 의존성 등을 설정한다.
  ```xml
  <project>
    <!-- 프로젝트 정보 설정 -->
    <modelVersion>4.0.0</modelVersion> 
    <groupId>com.ismoon</groupId> 
    <artifactId>spring</artifactId> 
    <name>springProject</name> 
    <version>1.0</version>

    <!-- 의존성 설정 -->
    <dependencies> 
      <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>3.8.1</version>
        <scope>test</scope> 
      </dependency>
    </dependencies>
  </project>
  ```
### 3. 메이븐 설치
* 아파치 메이븐 홈페이지(https://maven.apache.org/) 접속 후 다운로드한다.
* 다운로드 후 압축을 풀고 bin 폴더를 Path 환경 변수에 등록한다.
* "명령 프롬프트" 실행 후 아래의 명령어를 입력하여 메이븐이 정상적으로 설치되었는지 확인한다.
  ```
  > mvn -v
  Apache Maven 3.8.6 (84538c9988a25aec085021c365c560670ad80f63)
  Maven home: D:\develop\apache-maven-3.8.6
  Java version: 11.0.13, vendor: Amazon.com Inc., runtime: C:\Program Files\Amazon Corretto\jdk11.0.13_8
  Default locale: ko_KR, platform encoding: MS949
  OS name: "windows 10", version: "10.0", arch: "amd64", family: "windows"
  ```
## STS(Spring Tool Suite) 설치
  * 스프링 사이트(https://spring.io/tools) 접속 후 STS3(Spring Tool Suite 3)를 다운로드한다.
  * 다운로드된 압축 파일의 압축을 풀고 STS.exe를 실행한다.
* JDK 설정
  * 상단 메뉴 -> Window -> Preferences에서 Compiler 검색 후 Compiler compliance level을 11로 변경한다.
  * 상단 메뉴 -> Window -> Preferences에서 Installed JREs 검색 후 앞에서 설치 한 JDK의 경로에서 JRE를 찾아서 지정한다.
* Encoding 설정
  * 상단 메뉴 -> Window -> Preferences에서 Encoding 검색 후 검색된 항목의 Encoding을 UTF-8로 변경한다.
* Tomcat 설정
  * 상단 메뉴 -> Window -> Preferences -> Server -> Runtime Environment에서 앞에서 다운로드 한 톰캣을 찾아서 등록한다.
  * Servers 뷰에서 Runtime Environment에 등록한 톰캣을 생성하고 톰캣을 실행하여 정상적으로 동작하는지 확인한다.
