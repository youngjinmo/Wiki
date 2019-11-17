# Spring Boot

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

## Spring Boot auto-configuration

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