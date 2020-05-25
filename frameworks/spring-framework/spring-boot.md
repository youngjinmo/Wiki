# Spring Boot

- [SpringBoot 특징](#feature)
- [Spring Boot auto-configuration](#config)
- [에러페이지 핸들링](#error)
- [@GetMapping 어노테이션으로 다중맵핑하기](#get-mapping-multi)
- [h2 데이터베이스 마이그레이션](#h2-databse)
- [DB 에러발생 무시하고 프로젝트 실행하기](#datasource-autocofig)
- [Gradle 버전확인하는 법](#gradlew-version)
- [프로젝트에서 Gradle 버전 올리기](#upgrade-gradle)
- [Unit Test](#unit-test)

<br>

## <a name="feature"></a>Spring Boot 특징

![](https://miro.medium.com/max/1904/1*4ZPi1b_ca54pUE9xRB-IFQ.jpeg)

스프링을 보다 간편하게 사용할 수 있는 프레임워크이다.

기존의 스프링 프레임워크는 안정성과 성능, DI(의존성 주입) 등의 장점이 있었던 반면, 개발 환경 설정이 복잡하고 어렵다는 단점이 있었다. 스프링부트는 환경 설정을 최소화하고, 개발자가 비즈니스 로직에 집중할 수 있도록 도와 생산성을 향상시키는 프레임 워크이다.

[김지현](https://github.com/ihoneymon)님이 번역해주신 [스프링부트 설명서](https://gist.github.com/ihoneymon/8a905e1dd8393b6b9298)에 의하면, 스프링부트는 다음과 같은 특징을 갖고 있다. 김지현님이 정리해주신 문서는 [스프링부트 공식문서](https://spring.io/projects/spring-boot)를 기반으로 한다.

- **Crete stand-alone Spring application.**
  단독실행(stand-alone)가능한 스프링 애플리케이션을 실행한다.
- **Embed Tomcat, Jetty or Undertow directly (no need to deploy WAR files)**
  내장형 톰캣, Jetty 혹은 Undertow를 내장한다. (WAR파일로 배포할 필요가 없음.)
- **Provide opinionated 'starter' component to simplify your build configuration**
  기본 설정되어 있는 'starter' 컴포넌트들을 쉽게 추가할 수 있다.
- **Automatically configure Spring whenever possible.**
  항상 자동으로 설정(configure)해준다.
- **Provide production-ready features such as metrics, health checks and externalized configuration.**
  상용화에 필요한 통계, 상태 점검 및 외부설정을 제공한다.
- **Absoluely no code generation and no requirement for XMl configuration.**
  설정을 위한 XML 코드를 생성하거나 요구하지 않는다.

<br>

이와 함께 책 <처음 배우는 스프링 부트2>에서 정리한 것도 함께 작성해둔다.

- Embeded Tomcat, Jetty, Undertow를 사용하여 독립실행이 가능한 스프링 애플리케이션 개발
- 통합 스타터를 제공하여 Maven/Gradle 구성 간소화
- 스타터를 통한 자동화된 스프링 설정 제공
- 번거로운 XML 설정을 요구하지 않음
- JAR을 사용하여 자바 옵션만으로도 배포 가능
- 애플리케이션의 모니터링과 관리를 위한 스프링 액츄에이터(Spring Actuator)제공

<br>

## <a name="config"></a>Spring Boot auto-configuration

자동환경설정은 스프링부트의 가장 큰 장점이자 매우 중요한 역할을 수행한다. 약 Web, H2, JDBC 등 100여개의 자동 설정을  제공하며 새로 추가되는 라이브러리(jar)은 스프링부트 자동 설정 의존성에 따라 설정이 자동 적용된다.

스프링부트의 자동환경설정은 `@EnableAutoConfiguration` 또는 `@SpringBootApplication` 중 하나를 사용함으로써 할 수 있다.

[Spring-Boot Application](https://github.com/spring-projects/spring-boot/blob/master/spring-boot-project/spring-boot-autoconfigure/src/main/java/org/springframework/boot/autoconfigure/SpringBootApplication.java) 코드는 다음으로 구성되어 있다.

```java
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(excludeFilters = { 
   @Filter(type = FilterType.CUSTOM, classes = TypeExcludeFilter.class),
   @Filter(type = FilterType.CUSTOM, classes = AutoConfigurationExcludeFilter.class) })
public @interface SpringBootApplication {
   ...
}
```

- `@SpringBootConfiguration`
  - 스프링부트의 설정을 나타내는 어노테이션. 스프링 프레임워크의 `@Configuration`을 대체하며 **스프링부트 전용**이다.
- `@EnableAutoConfiguration`
  - 자동 설정의 핵심 어노테이션. **클래스 경로에 지정된 내용을 기반으로 자동 설정을 수행**. 특별한 설정값을 추가하지 않으면 기본값으로 작동한다.
- `@ComponentScan`
  - 특정 패키지 경로를 기반으로 `@Configuration`**에서 사용할** `@Component` **설정 클래스를 찾는다.** `@ComponenetScan`의 basePackages 프로퍼티값에 별도의 경로를 설정하지 않으면 `@ComponentScan`이 위치한 패키지가 루트 경로(Base Package)로 설정. 

<br>

`@SpringBootApplication` 어노테이션은 위 3가지 어노테이션의 조합이다.

<br>

## <a name="error"></a>에러페이지 핸들링 (a.k.a 404 페이지 커스터마이징)

솔직히 이걸 현재의 수준으로 작성해도 될지 자신없으나.. 일단 **"기록"**에 의미를 두며 남겨본다. 혹시나 다른 분들이 이 부분을 보시게된다면, 그냥 건너띄시거나 구글에서 다른 글을 자세히 읽어보시길 꼭 권한다.

현재 진행중인 프로젝트에서 `resource/static/` 에 `/error` 라는 디렉토리를 만들고 여기에 404.html 파일과 500.html파일을 넣었다. 

![](https://www.mediafire.com/convkey/941e/5d7kwvr34i90pwuzg.jpg)

그럼 이것만으로도 HTTP 상태코드에 맞춰서 페이지를 띄어준다. 

이 때 서버에서 에러 메세지를 정확히 보고싶다면, 프로젝트의 `/main/java/` 디렉토리 아래에 `error/` 패키지를 생성하고, `ErrorController.java` 와 같은 이름의 컨트롤러를 생성해준다.

`ErrorController.java`

```java
package devandy.til.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorHandler {
   @GetMapping("/error")
   public String errorpage(){
      throw new IllegalStateException("Error");
   }
}
```

위의 코드를 입력하면 사용자가 에러를 만났을때, 에러 메세지를 콘솔로 출력받을 수 있다.

추가적인 학습/설명이 필요하다면 이 링크[(갱그리-Spring Boot 에러페이지 Customizing)](https://brunch.co.kr/@ourlove/70)를 통해 꼭 해보길 바란다.

<br>

## <a name="get-mapping-multi"></a>@GetMapping 어노테이션으로 다중맵핑하기

파라미터안에 `value = { , }` 형식으로 작성하면 `@GetMapping` 어노테이션으로 다중맵핑이 가능하다.

웹 애플리케이션의 메인 페이지로 이동하는 3개의 키워드를 모두 index.html로 넘기고 싶어서 작성한 코드이다.

~~~java
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class homeController {
   @GetMapping(value = {"/", "/index", "/main"})
   public String index(){
      return "index";
   }
}
~~~

<br>

## <a name="h2-databse"></a>h2 데이터베이스 마이그레이션

h2데이터 베이스란 **컴퓨터에 내장된 램(RAM)메모리에 의지하는 데이터베이스**를 말한다. 테스트 또는 지금의 나처럼 실습을 위해서는 간편하고 빠르기 때문에 좋은 옵션이 될 수 있다.

다만, 램에 데이터를 저장하다보니 웹서버를 재부팅하면 기존의 데이터가 사라진다는 단점이 있다. 따라서 이 때엔 테스트에 필요한 데이터를 미리 sql로 작성해두고 웹서버 재부팅시마다 데이터를 인위적으로 주입하여 테스트 해볼 수 있다.

스프링부트 프로젝트에서 h2 데이터 베이스를 사용하는 방법은 다음과 같다.



### 의존성 설정

**Maven**

~~~xml
<dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-jdbc</artifactId>
</dependency>
<dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
   <groupId>com.h2database</groupId>
   <artifactId>h2</artifactId>
</dependency>
~~~

**Gradle**

~~~gradle
// https://mvnrepository.com/artifact/com.h2database/h2
testCompile group: 'com.h2database', name: 'h2', version: '1.4.200'
~~~



### application.yml 설정

~~~yml
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

spring.datasource.url=jdbc:h2:mem:devandy;
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
~~~



이제 데이터베이스가 사용가능하며, `localhost:8080/h2-console` 에서 대시보드를 이용할 수도 있다.

![](https://lh3.googleusercontent.com/VD97biPg5fcx8KwvetWuiwQ9Atr81zPmhwlMntynUvyK7ICh1Qq8Pk34_9Wa6_YgJAd_hDRDvEy14LYYVALxi-E0_Jrv7wBChRywueHMVyuJfOj2fRlIT2H6vxhLv30jklpyrOXDCmMoy6dWncPF0rC3CSvE4_pfkbi4qIWBScKBl_Y69eNoJv-JZAGgxd1RcA-rbk63cEfPFEgrCl3b8_v0_VCV3vTEbIgwV_huEb-7BGIbvZxAtdcaNTkv1LsJaquRis_vkPjkfzsu2LzgPXGfcBTNg8KWqtvNMtq1b3fcrU49tmzX_oIvKYU9IXeA011fG6oI6hsEmpY4BNW91Sn10Q0vgXRtxgsRV1DWySyJD_jW0_aFURz__PqEc5Xn3WVAERTso52Autvn07ejtg21fr84d3lk3qTaKozgbEJgwBJDflpvrV64ODEmjeXquMTQ9FwTsi2-NFSjrazPlak4LNHPXsCP69SdEUZ5STE8JKD99fiD9a96UYeml-EyHyvDzNz6MnRnXmkLjgrnd4Zj7sV8qUad990r6EQNp9JVtY4mGIL-zCXMhvC2SVLO-PEyirrUZ7DEnL5UbnvpHWLfUluFSdk09BupqW9H_Vt35slM0iOKbliBTsxo7MCSzAjVTEP3kXaNkqUiLTLZUpSP79ZA6GBCcUaUiqslpvfdLxMIZoFqOY2sITcDRSKZpTURnKtXbjo5aEURXdaxBDNinAr1oy7rzywUkf1_IjaN3dLKoQ=w509-h402-no)

![](https://lh3.googleusercontent.com/7g4emF9IGksv-m0sPpFAR3zI979_RKRss2Ebksu4bCBxCAZ-XOVqS62PyLWFyX4qXQ8VnP7iFhlu2xfqW0XU4AL63SG9uoYtsWY68bUm4P1AqC-0A2nX0JQZnqD5JkwwCcR9yx1fY2QSDeYvnTPJDxf9QntTAX95xGi1iIsdYIKDd9Eg9zkgaRguWEnpksmoUuJTj4FIgeOQjveE1f1YuVRLRgSwOSBU-WMVhvmd6O0KuVFpNra3i934fhG3gUa8RohlhHSdXlKzaleHwZYYnJEHI1m601NBY_h2LQinHkCmx_wNIzSReWKJHHW_wNmTlRBS1WlG1NvUgvUTy8AEbaeMThJmQm3QUbLHxmFK8B3E-XcG-NLRYjyvVppUcMn3_hngSfPcDvzjRT1bkSZ3fWv6k_3o5vyXd5b1amWmAxVS_rZJ_RGZOh6iaLPLarDaD4NQ55D8w-8mjXm7I7ZDJQh3Ta2qWfOlQb0ta0mB2yzvuC3JjoLWsf4V6o9lv07q6kO7IJ2yTNC6YPz3UGJlLHgIbUomuvJsflbuNSOJPIO58WSThBLRUdQQRTuQnKhbXa6_grfdFmQVqrB87rs11LkZVIpSCGELnf5U5kDZUHa643w1HIbPcMKX1x75OThFKUOr-amtqFBPA48mpzsodaW79YqNXSoTHuJvDAEgelED-wKxoXScnGoBWIYWlPbPmJkJtvnnkOe2qwt7duRGAa8SXjA2cNOTZ46IduCRpd76B4pokA=w864-h778-no)

<br>

## <a name="datasource-autocofig"></a>DB 에러발생 무시하고 프로젝트 실행하기

스프링부트 프로젝트의 main클래스에 어노테이션을 추가한다.

~~~java
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication
public class DevAndy {
   public static void main(String[] args) {
      SpringApplication.run(ToDoApplication.class, args);
   }
}
~~~

이렇게 하면, Datasource가 없어도, 즉 DB 연결을 필요로 하는 프로젝트인데, DB가 연결되지 않은 경우에도 프로젝트를 실행할 수 있다.

<br>

## <a name="gradlew-version"></a>Gradle 버전확인하는 법

Gradle 프로젝트 디렉토리 내에서 아래의 명령어를 입력하면 Gradle의 버전 및 개발환경을 콘솔에 출력한다.

~~~bash
$ ./gradlew --version
~~~

![](https://lh3.googleusercontent.com/pw/ACtC-3fwbH6tqvImZYqrGcBw-Hm6XnkHU5m7jalTIKoOHZXESRTolKdFRghMai1EQoYZSuyTP6QPKIa8U2yGi6HhGpL4xnWcjxrGp9XyWZBMPNEZ6qa7rKwE-SsjK1hiCxCQ6hnn_RNuEkAnQxdGyzgmWST5FQ=w585-h492-no?authuser=0)

위의 방법은 프로젝트에 적용된 gradle 버전을 확인하는 방법이고, 운영체제에 있는 gradle 버전을 확인하는 방법은 다음과 같다.

~~~bash
$ gradle -v
~~~

<br>

## <a name="upgrade-gradle"></a>프로젝트에서 gradle 버전 올리기

프로젝트 디렉토리에 [gradle] - [wrapper] 하위에 gradle-wrapper.properties 라는 파일이 있다. 여기서 원하는 버전으로 변경후 gradle을 refresh하면 새로운 버전의 gradle로 변경된다.

![](https://lh3.googleusercontent.com/pw/ACtC-3fRfZOwWUHdp5aDKfKZ_MgHKTCJGquZKIluhn6Fj99a40mk8cIkJUAPW2fT_DKE2py-GxZNjU-15SQ-raWuMM1JivslcDRdmueMiNw6Lp1wHIyErafahHQAXPTAarUTRMo3WiyAgxCGlvgtW9GWX5cOqQ=w1440-h480-no?authuser=0)

<br>

## <a name="unit-test"></a>Unit Test

Unit Test의 FIRST 원칙

- Fast 테스트 코드를 실행하는 일은 오래걸리면 안된다.
- Independent 독립적으로 실행되어야 한다.
- Repeatable 반복가능해야한다.
- Self Validating 메뉴얼 없이 테스트 코드만 실행해도 성공/실패 여부를 알 수 있어야 한다.
- Timely 바로 사용 가능해야 한다.

출처 : https://brunch.co.kr/@springboot/207

<br>