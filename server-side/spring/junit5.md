# JUnit 5

평소 유튜브에서 구독중인 박재성님으로부터 TDD(Test Driven Development)에 대한 중요성을 많이 들었고, 항상 관심은 있었지만 실행을 하지 못하고 있었다. 그러다가 이동욱님이 집필하신 스프링부트와 AWS로 혼자 구현하는 웹 서비스를 읽으면서 TDD를 제대로 배우고, 경험해야겠다는 생각이 들었다. 

책에선 시작부터 test 코드를 작성해가며, 나처럼 테스트 코드 작성에 익숙하지 않은 사람들을 익숙하게 하기 위해 모든 코드에 대한 테스트 코드를 작성하셨다. 그러나 동욱님이 작성하신 시점과 내가 책을 읽는 시점의 차이 때문에 발생하는 것인지 몰라도 에러가 발생해서 라이브러리를 못불러오는 경우가 시작부터 발생했고, 안그래도 낯선 테스트가 더 낯설어질것 같아서 인프런에서 백기선님 강의를 구입해서 공부를 시작하게 되었다.

자바 기반의 테스트 프레임워크 JUnit을 직접 다루고 실습하면서, 향후 다른 사람들에게 설명할 수 있는 정도로 이해하는 것이 목표이다.

최근에 스프링부트가 2.2버전을 릴리즈하면서, JUnit의 버전도 JUnit 4에서 JUnit 5로 버전 업하였다.

[JUnit 5 User Guid](https://junit.org/junit5/docs/current/user-guide/)

## ToC

- [JUnit 5의 구성](#components)
- [테스트 실행하기](#run-test)
- [기본어노테이션](#annotaions)
- [테스트 코드 이름 설정하기](#generate-name)

<br>

## <a name="components"></a>JUnit 5의 구성

### JUnit 5 = JUnit Platform + Jupiter + Vintage

- **JUnit Platform**
  - JUnit으로 작성된 테스트 코드를 실행해주는 런처를 제공.
  - TestEngine API 제공.
- **Jupiter**
  - TestEngine API 구현체로써 JUnit 5를 제공
- **Vintage**
  - JUnit 4와 3을 지원하는 TestEngine 구현체



### JUnit 4와 JUnit 5의 차이

JUnit4는 하나의 JAR 파일이었으나 JUnit 5은 그 자체로 하나의 플랫폼으로 작동한다. 그리고 그 플랫폼위에서 Jupiter, Vintage라는 모듈이 동작한다고 한다.

![](https://lh5.googleusercontent.com/oxqRtaoWkIvnN5TUMUYhNl5Cc8DlAxtJpcB1XqHTU8LNTOZPf45lL0P4tcxAtS5fWsdYx4-z0R4ldckzPr7ahVkmgmOls2-K_KFGDnK4xaIcmhUmWfExjT5bMfdxD3BadT9mz-VD)

<br>

### Spring Boot 2.2 부터 JUnit 5 기본 적용

Spring Boot 2.2 부터는 spring-boot-start-test를 통해 JUnit5가 기본제공된다. 프로젝트 생성후, Dependencies를 확인해보면, JUnit 5의 모듈이 주입된 것을 확인할 수 있다.

![](https://lh3.googleusercontent.com/pw/ACtC-3cIzB6hRQbz-tCbTvp7C57A8CvbGcFiMKGgB_tjtrJHtgsvb6L1xjejGgmD-LMLH98Ons74mrSIgeiQM4N8lIgE7ue-kSp6qC4foePHDcRDvKB6Oh7xK0_5DUkhxc6ELzVDiCOthyKInWBFb44wFdzS9w=w1442-h1109-no?authuser=0)

만약 스프링부트로 시작한게 아니거나 JUnit 5에 대한 의존성을 수동적으로 주입하고자 한다면, 아래의 의존성을 주입하면 Jupiter를 사용할 수 있다.

~~~
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-engine</artifactId>
    <version>5.6.2</version>
    <scope>test</scope>
</dependency>
~~~

<br>

## <a name="run-test"></a>테스트 실행하기

의미없는 클래스 하나를 작성하고, 해당 클래스에 마우스 커서를 올려두고, 우클릭을 하면 아래와 같이 테스트 클래스를 생성할 수 있다.

![](https://lh3.googleusercontent.com/pw/ACtC-3efJk4qADiopPkU6voVLZX3lacfFesHpfWyzSzTHTK820-F0si9Xmt-m4KSIAp920COrXuD9PJ6-n71Emz4yc_9odXLiVyAgt7d6vDu_uulnFphPblvu-IyEe4ppaZUVLGNxp1S6Y4no3C4jm4KyxlaEw=w1442-h1189-no?authuser=0)

또는 단축키를 이용하여 빠르게 테스트를 생성할 수도 있다.

Intelli J, 맥(MacOS)환경에서는 Command + Shift + T를 입력하면 된다.

![](https://lh3.googleusercontent.com/pw/ACtC-3dE5LXghicQ0INo-qKGP9UAvJL5LUXsVfQsPqEvx9hEIkK8ZPut27YhzrLSQMuiOLho6iCfO40lMosPKsqgybbG11luBKV_5nfDEXq_XWXnnYRXA8CPhFShY9pym7MqrbSomBPkaTdMuaXGrnZrR26bvg=w1137-h721-no?authuser=0)

그럼 이렇게 테스트 클래스 이름을 설정하는 창이 뜨는데, 일반적으로 클래스 이름 뒤에 Test를 붙여서 테스트 클래스를 만든다.

<img src="https://lh3.googleusercontent.com/pw/ACtC-3coc4LG_iImBLtqeCPtDnncq8O4CbtZuigrYx67oKKrOCr_uKUjnXQNPlH-El7DNX-CPkgKpiEnOdA61FRGuww1kknEGwR3tjoYzWoH78MsBYhcIx34tWJne50q6tKqkhh_DscspebCakOi5k5fgbuIlA=w1103-h919-no?authuser=0" style="zoom:50%;" />

<br>

## <a name="annotations"></a>JUnit 5의 기본 어노테이션

- @Test
  - **해당 메서드가 테스트**임을 알리는 어노테이션

- @BeforeAll
  - 테스트의 **시작** 코드

- @AfterAll
  - 테스트의 **마지막** 코드

- @BeforeEach
  - **<u>각각의 테스트(method)가 실행되기 전</u>** 실행하는 코드

- @AfterEach
  - **<u>각각의 테스트(method)가 실행된 후</u>** 실행하는 코드

- @Disabled
  - 테스트 코드중 <u>**테스트로 실행하고 싶지 않은**</u> 메서드에 추가하는 어노테이션.

<br>

## DisplayNameGeneration



