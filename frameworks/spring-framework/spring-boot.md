# Spring Boot

- [SpringBoot 특징](#feature)
- [Spring Boot auto-configuration](#config)
- [에러페이지 핸들링](#error)

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

<br>