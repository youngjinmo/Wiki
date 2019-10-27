# TIL

![HitCount](http://hits.dwyl.io/youngjinmo/youngjinmo/TIL.svg)

*Today I learned.*

오늘 제가 배운 내용을 정리하는 공간입니다.

<Br>

## ToC

- [Programming Language](#language)
  - [Java](#)
    - [IDE없이 컴파일하고, 실행하기](#run-compile-without-ide)
    - [Wrapper Class](#wrapper-class)
    - [Date](#java-date)
    - [Javadoc](#javadoc)
  - [SQL](#sql)
    - [AND 조건 조회](#order-and)
    - [LIMIT](#limit)
    - [DISTINCT](#distinct)
    - [연산처리](#sql-math)
- [Web Development](#web)
  - [HTTP](#http)
    - [GET/POST](#get-n-post)
  - [Template Engines](#template-engines)
    - [Mustache](#mustache)
  - [JPA](#jpa)
    - [Hibernate](#hibernate)
- [Git](#git)
  - [Fork](#git-fork)
  - [PR](#git-pull-request)
- [DevOps](#devops)
- [Linux](#linux)
  - [명령어](#linux-commands)
    - [find](#linux-find)
    - [Symbolic Link](#linux-symboliclink)
    - [grep](#linux-grep)
  - [Vi Editor](#linux-vi)
    - [입력 명령어](#vi-input)
    - [이동 명령어](#vi-move)
    - [파일 상태 명령어](#vi-filestatus)
- [MacOS](#osx)
  - [Homebrew](#homebrew)
  - [tree 패키지](#osx-package-tree)

<br>

# <a name="java"></a> Java

<img src="https://cdn.vox-cdn.com/thumbor/FDD76YJZJFPyNUfT3ZBHcnMA0Ec=/43x0:593x367/1200x800/filters:focal(43x0:593x367)/cdn.vox-cdn.com/uploads/chorus_image/image/48667835/dbgxt2rvpd26udoyzcqn.0.0.jpg" width="400" />

## <a name="run-compile-without-ide"></a>IDE없이 컴파일 하고, 실행하기

운영체제에 jdk를 설치했고, 환경변수 설정까지 마쳤다면 IDE없이도 자바 파일을 컴파일해서 클래스 파일을 생성할 수 있다. 물론 실행까지도 할 수 있다. 

**1. 자바 파일 생성(코딩)**

![](http://www.mediafire.com/convkey/b82c/qze1hsgyvs1863gzg.jpg)



**2. `javac` 이용해서 컴파일**

![](http://www.mediafire.com/convkey/b82c/qze1hsgyvs1863gzg.jpg)



**3. 실행**

![](http://www.mediafire.com/convkey/2006/qriceyec0qlbmtfzg.jpg)

실행할 땐 `java JavaYahac` 처럼 파일 포맷없이 클래스 파일명으로 명령을 한다. 그럼 현재 디렉토리에서 이름이 일치하는 클래스를 찾아서 실행한다. 

실행 순서는 `main()`를 먼저 수행하고, `main()`에서 호출하는 메서드들을 수행하는 순서로 수행된다.

<br>

## <a name="wrapper-class"></a>Wrapper Class

기본형 데이터타입의 객체화를 가능하게 도와주는 클래스. `java.lang` 패키지 안에 포함되어있다.

- 기본형 타입 : `int`
- 객체형 타입 : `Integer`



Wrapper Class는 다음과 같은 기능을 수행한다.

<img src="http://www.mediafire.com/convkey/e0bf/3kqk5j823suxigbzg.jpg" />

**오토 박싱 (Auto Boxing)**

기본 타입 데이터를 객체 타입의 데이터로 자동 형변환해주는 기능

**오토 언박싱 (Auto Unboxing)**

오토박싱과 반대로 객체 타입의 데이터를 기본형 타입 데이터로 자동 형변환



### References

- [프로그래머스 - [자바 중급] java.lang 패키지/오토박싱](https://youtu.be/Eofo8_xZbfk)

<br>

## <a name="java-date"></a>Date 객체

날짜를 출력하는 객체이다.

기본 객체 사용법은 다음과 같다.

```java
import java.util.Date;

class date_tutorial {
  public static void main(String[] args){
    Date date = new Date();
    System.out.println(date);
  }
}
```

이렇게 `Date` 객체를 그대로 사용할 경우 출력결과는 다음과 같다.

<img src="http://www.mediafire.com/convkey/ff9e/ltldv7wa674l88lzg.jpg" />

포맷을 내가 커스터마이징 하고자 할 경우 `SimpleDateFormat` 객체를 사용하면 된다.

```java
import java.util.Date;
import java.text.SimpleDateFormat;

class date_tutorial {
  public static void main(String[] args){
    Date day = new Date();
    SimpleDateFormat date = 
      new SimpleDateFormat("yyyy년 MM월 dd일");
    SimpleDateFormat clock = 
      new SimpleDateFormat("a hh시 mm분 ss초");
    
    System.out.println("서버 실행한 날짜는 "+date.format(day));
    System.out.println("서버 실행한 시각은 "+clock.format(day));
  }
}
```

![](http://www.mediafire.com/convkey/78db/kx7v4ezlus1w9xnzg.jpg)

<br>

## <a name="javadoc"></a>Javadoc

주석은 프로그램에 반영되는 코드가 아니다. 코드를 설명하는 문구이다.

내가 작성한 코드일지라도 며칠 지나서 코드를 다시보면, *'진정 내가 짠 코드란 말인가?'* 하는게 사실이다. 작성자 본인도 그런데, 함께 프로젝트를 할때 다른 동료들은 오죽할까. 

적절하게 코드를 설명하는 주석을 남기는 것이 좋다.

자바에서 주석을 남기는 방법은 두 가지가 있다.

**1. 한 줄 짜리 주석**

```java
// 이게 한 줄 짜리 주석이다.
```

**2. 두 줄 이상의 주석**

```java
/*
보통 IDE에서 /* 입력하고 엔터만 치면 자동으로 완성이 된다. 
위아래 기호 사이에 이렇게 작성하면 장문의 주석도 작성이 가능하다.
그러나 주석은 장황하지 않게 깔끔하게 쓰도록 하자.
\*
```

그리고 주석의 역할을 하면서 주석만 따로 뽑아서 문서로 만들어주는 **Javadoc**이라는게 있다.

**3. javadoc**

```java
/**
 * @author DevAndy
 * @return 매핑된 URI에 해당하는 문서를 반환
*/
@GetMapping("/login")
public String login(){
   return login;
}
```

Javadoc에서 자주 사용하는 구문은 다음과 같다고 한다.

- `@author`

  - 말 그대로 저자를 의미한다. 코드를 작성한 개발자의 이름을 작성하면 된다.

- `{@link}`

  - 다른 메서드/클래스를 연결할 때 사용하며, 다른 키워드와 사용할 때 유용하다고 한다.

- `@deprecated`

  - 오래되서 사용하지 않는 클래스와 인터페이스에 사용하며 `{@link}`와 사용하면 유용하다.

  - ```java
    /**
     * @deprecated 대신 {@link #new()} 사용한다.
     */
    @Deprecated
    public void old(){
      ..
    }
    ```

- `@see`

  - 클래스 이름을 연결할 때 사용한다.

    - ```java
      /**
       * @see com.lecturesearch.lecture.user.SocialType
       */
      ```

  - `@see #method`

    - ```java
      /**
       * @deprecated 대신 {@link #new()} 사용한다.
       * @see #new 에서 새로운 기능을 추가했다.
       */
      @Deprecated
      public void old(){
        ..
      }
      ```

  - `외부 URL링크`

    - ```java
      /**
       * @see <a href="https://github.com/youngjinmo/til">TIL</a>
       */
      ```

- `@since`

  - 클래스나 메서드의 작성 시점을 알려주는 키워드. 
  - API일 경우, API사용자가 어느 버전의 라이브러리에서 지원하는 기능인지를 알 수 있음.

- `@param`

  - Parameter의 이름과 용도를 알려주는 키워드.

- `@return`

  - 반환되는 데이터와 데이터 타입을 기술

- `@throws`

  - exception-class를 기술

- `{@code}`

  - 예제 코드를 첨부할 경우 사용하는 키워드.

  - HTML의 `<pre>` 키워드와 함께 사용해야 한다.

  - ```java
    /**
     * 클래스 설명
     * <pre>
     * {@code
     * Car car = new Car();
     * }
     * </pre>
     */
    ```

    

그래서 이걸 문서로 만드려면 터미널에서 클래스 파일이 디렉토리로 이동후 아래의 명령어를 입력해야한다.

```bash
javadoc -d docs [file.java]
```

그런데 아직 이 문서를 보는 방법을 모르겠다.. 궁금한데 내일 찾아보고 정리해야겠다..

<br>

# <a name="sql"></a>SQL

### <a name="order-and"></a>AND 조건으로 조회할 때

이름(`NAME`) 순으로 조회할 때, 이름이 같을 경우, 생일(`BIRTH_DATE`)이 빠른 순으로 조회할 때 사용하는 쿼리이다.

```SQL
SELECT
  NAME, BIRTH_DATE
FROM
  ANIMAL_INS
ORDER BY
  NAME ASC,
  DATETIME DESC; 
```

위의 이미지처럼 작성하면 `ORDER BY` 에서 먼저 작성한 이름순(`ASC`)으로 정렬되고, 이름이 같을 경우 날짜(`DATETIME`)를 역순으로 정렬해서 조회하는 쿼리이다.

<br>

### <a name="limit"></a>LIMIT

조회하는 데이터의 갯수를 결정할 때 사용하는 쿼리이다.

```SQL
SELECT NAME
FROM ANIMAL_INS
ORDER BY DATATIME ASC
LIMIT 1;
```

날짜(`DATETIME`)순으로 정렬했을 때, 데이터를 하나만 조회하는 쿼리이다. 즉 가장 최신 데이터를 조회한 것이다. `LIMIT`을 활용하면 최대값, 최소값도 구할 수 있다.

<br>

### <a name="distinct"></a>DISTINCT

조회 조건에서 중복을 제거하고 조회할 때 사용하는 쿼리이다.

```sql
SELECT DISTINCT NAME
FROM ANIMAL_INS;
```

`DISTINCT` 는 `SELECT` 에서 사용하는 쿼리이다. 중복을 제거해서 조회하고 싶은 컬럼 앞에 `DISTINCT` 를 붙이면 해당 컬럼은 중복이 제거되어 조회된다.

<br>

### <a name="sql-math"></a>연산 처리

현재까지 내가 알고있는 SQL에서 연산하는 방법은 세가지이다.

1) 컬럼을 연산해서 새로운 컬럼으로 조회하기

```sql
SELECT DATA1 * DATA2 AS NEW_DATA
FROM ANIMAL_INS
ORDER BY DATETIME ASC;
```

`DATA1`과 `DATA2`를 각각 곱해서 `NEW_DATA` 라는 새로운 컬럼명으로 조회하는 쿼리이다.



2) 조회되는 데이터의 수 조회

```sql
SELECT COUNT(NAME)
FROM ANIMAL_INS
ORDER BY DATETIME ASC;
```

`NAME` 컬럼의 데이터 수를 조회하는 쿼리이다.



3) 데이터 합계 구하기

```sql
SELECT SUM(WEIGHT)
FROM ANIMAL_INS;
```



4) 데이터 평균 조회하기

```sql
SELECT AVG(AGE)
FROM ANIMAL_INS;
```

<br>

# <a name="web"></a>Web Development

<br>

# <a name="http"></a>HTTP

HTTP는 클라이언트와 서버간의 통신을 위한 프로토콜이다. HyperText Transfer Protocol의 약자이다.

클라이언트와 서버가 request-response할 수 있도록 역할을 수행하는 프로토콜이다.

<br>

## GET/POST

GET은 전달하는 데이터를 url 주소에 붙여서 전달하는 HTTP 메서드이다. 반면에 POST는 url 주소에 붙이지 않고 전달할 수 있는 HTTP 메서드이다.

일반적으로 게시판의 id값을 통해 게시글 상세보기 할 때엔 url뒤에 ?을 붙여서 게시글 id값을 GET 메서드로 서버에 전달한다. 반면 사용자의 아이디나 비밀번호와 같은 민간한 정보는 POST 메서드로 서버에 전달한다.

Outsider님이 블로그에 정리하신 <a href="https://blog.outsider.ne.kr/312" target="_blank">글</a>을 보면, GET과 POST의 차이를 다음과 같이 설명한다.

> **GET은 가져오는 것**이고, **POST는 (서버)수행하는 것**입니다.
>
> GET은 Select적인 성향을 가지고 있으며, POST는 서버의 값이나 상태를 바꾸기 위해서 사용한다.

w3school에서도 GET 메서드에 대해 *"GET is used to request data from a specified resource"* 라고 설명한다. POST 메서드에 대해선 *"POST is used to send data to a server to create/update a resource"* 정리했다. Outsider님의 정리와 정확히 일치한다.



w3scool에서는 다음처럼 GET/POST를 비교하였다.

| HTTP Methods | requests                                                     |
| ------------ | ------------------------------------------------------------ |
| GET          | GET 메서드의 요청은 캐싱될 수 있다.<br />GET 메서드의 요청은 브라우저 히스토리에 기록된다.<br />민감한 데이터를 다룰땐 이용해서는 안된다.<br />GET 메서드의 요청은 길이 제한을 받는다. 긴 데이터는 GET 메서드로 요청할 수 없다. |
| POST         | POST 메서드의 요청은 캐싱되지 않는다.<br />또한 브라우저 히스토리에도 기록되지 않는다.<br />POST 메서드의 요청은 GET 메서드 요청과 달리 길이에 제한을 받지 않는다. |

<br>**References**

- [Outsider - GET과 POST의 차이](https://blog.outsider.ne.kr/312)
- [w3school - HTTP Request Methods](https://www.w3schools.com/tags/ref_httpmethods.asp)

<br>

# <a name="template-engines"></a>Template Engines

[템플릿 엔진](https://en.wikipedia.org/wiki/Web_template_system)이란, 데이터 모델에 따른 문서를 합성하여 웹 문서를 만들어주는 소프트웨어라고 한다. 

템플릿 엔진은 목적에 따라 다양한 템플릿 엔진을 사용할 수 있다. `include` 코드를 이용하여 html의 중복 코드를 제외하고 싶을 때에는 Apache Tiles와 같은 레이아웃 템플릿 엔진을 사용할 수 있다.

또 View에서 데이터를 출력하고 싶을 때는 Thymeleaf, JSP 같은 텍스트 템플릿 엔진을 쓸 수 있다. 

위 두 템플릿은 서로 베타적이지 않고, 동시에 사용이 가능하다.

<br>

**Reference**

- [gmlwjd9405 - [Template Engine] 템플릿엔진이란](https://gmlwjd9405.github.io/2018/12/21/template-engine.html)

<br>

## <a name="mustache"></a>Mustache

JSP도 있고, Spring Boot에서는 Thymeleaf를 미는것도 같은데 왜 Mustache를 알아야 할까.

우선 JSP는 오래된 기술이다. 오래되었다는 이유만으로 배척할 필요는 없으나 향후 지원이 안될 가능성이 높기 때문에 실무에서 가장 많이 쓰이고 있거나 앞으로 많이 쓰일 소프트웨어를 배울 필요가 있다고 생각했다.

Thymeleaf는 잘 모르지만, 느리다는 성능 상의 이슈가 있는 편이다.

**Mustache는 템플릿 엔진중 가장 많은 언어를 지원한다.** [위키](https://en.wikipedia.org/wiki/Web_template_system#Server-side_systems)를 열어보면, C++, 커피스크립트, Go, Java, .NET, PHP, Pyhton중 내가 아는 프로그래밍언어는 거의 다 지원되는듯하다.

또 Mustache는 [심플한 문법](https://mustache.github.io/mustache.5.html)을 갖고 있다고 한다. 이 부분은 직접 경험해야 알 수 있을 것 같다.

일단 대략적으로 이정도만 알고 있는데, 향후 써보면서 계속 업데이트 해보겠다.

<br>

**Reference**

- [Baeldung - Spring Boot Mustache](https://www.baeldung.com/spring-boot-mustache)

<br>

# <a name="jpa"></a>JPA

Hibernate를 알기 앞서 JPA와 ORM에 대해 정리하려고 한다.

<b>JPA(Java Persistent API)</b>는 자바 진영의 ORM 기술 표준 명세라고 한다.

<b>ORM(Object Relational Mapping)</b>은 객체 관계형 매핑을 돕는데, 객체를 DB 테이블이 되도록 매핑시켜주는 것을 의미한다.

객체는 객체대로 설계를 하고, 관계형 데이터베이스는 DB대로 설계하면 ORM 프레임워크가 중간에서 매핑하는 구조이다.

<a name="structure-of-jpa"></a><img src="http://www.mediafire.com/convkey/76fe/4uc9nqw8rls40b7zg.jpg" />

Java 애플리케이션에서 DB를 통신하려면 JDBC API를 사용해야하는데, JPA가 중간에 개입하는 구조이다. JPA는 Java 애플리케이션의 DAO 영역에서 전달받은 객체를 분석해서 SQL을 생성하고, JDBC API를 사용해서 쿼리를 DB에 전송하는 역할을 한다.

*객체를 자바 컬렉션에 저장하듯이 DB에 객체를 저장할수는 없을까?*

JPA 탄생 이전까지는 데이터 중심의 모델링을 우선시 했다고 한다. 객체지향의 특징보다는 단순히 데이터의 전달 목적으로 객체(VO, DTO)를 사용했다고 한다. 그러나 이는 심각한 비효율을 발생시켰다. 객체에 데이터를 추가할 때 반복적인 CRUD 작업을 해야했기 때문이다.  **ORM은 SQL 쿼리 대신 코드로 데이터를 조작함으로써 개발자 입장에서 생산성을 높힐 수 있는 도구**이다.

예를들면, `SELECT * FROM users;` 라는 SQL 쿼리를 `users.findAll()` 로 대체할 수 있는 것이다. 이렇게 하면 중복을 제거할 수 있으며, 객체지향의 장점을 살려 데이터를 제어할 수 있다.

<br>

**Reference**

- [김영한 - JPA 소개](https://youtu.be/U2s2JhzPZf4)

<br>

## <a name="hibernate"></a>Hibernate

EJB(Entity Java Beans)이 있었는데, 이게 너무 불편하고 성능이 떨어지는 단점이 있었다. 그런데 이를 답답해 여긴 어느 한 개발자가 이를 대체할 수 있는 Hibernate를 개발해서 오픈소스로 공개했다. 이후 자바 진영에서 새로운 표준을 개정하면서 Hibernate 개발자를 모셔가서 [JPA](#jpa)가 개발되었다고 한다.

Hibernate는 JPA를 구현한 프레임워크이다. 국내에선 Hibernate보다 [MyBatis](https://sjh836.tistory.com/127)를 더 많이 사용하고 있으나 한국, 일본, 중국을 제외한 전 세계에서 Hibernate를 더 많이 사용한다고 한다.

### <br>**Hibernate의 장점**

- **생산성**
  - SQL 쿼리를 직접 사용하지 않고, 객체를 사용할 수 있으므로 생산성이 높아진다.
- **유지보수 용이**
  - MyBatis에서는 DB 테이블의 컬럼이 변경되면, 데이터를 제어하는 DAO에서 개발자가 일일히 전부 수정해야했지만, JPA는 그런 일을 개발자 대신 처리해준다.
- **DB 벤더(MySQL, Oracle..)에 종속되지 않음**
  - JPA는 어느 벤더에 종속되는 형태가 아니므로 유연하게 DBMS를 바꿀 수 있다.

<br>**Hinernate의 단점**

- **성능 이슈**
  - 직접 SQL을 작성하지 않고 객체로 쿼리를 수행하는 것은 [JPA](#structure-of-jpa)의 구조에서도 알 수 있듯이 중간에 과정을 하나 더 거치는 작업을 수행하기 때문에 아무래도 성능에 영향을 미치는 것 같다.
    ORM 초기엔 성능 이슈가 많았지만, 이후 계속 발전하여 지금은 나아졌지만 여전히 직접 SQL 쿼리를 작성하는 것보다는 성능 이슈가 존재할 수 있다고 한다.
  - 국내 시장이 Hibernate와 같은 JPA 대신 MyBatis를 많이 쓰는 이유도 성능 때문일 수 있다고 한다. 국내 시장의 특성상 금융/SI가 많은데 이들 영역에서는 성능이 떨어지고, 세밀한 제어가 어려운 JPA대신 SQL 쿼리를 직접 작성하는 것으로 보인다.
- **세밀한 제어의 어려움**
  - 객체(메서드 호출)로 DB를 제어하는 것이기 때문에 세밀한 부분의 제어가 힘들다고 한다. 
  - 쿼리가 복잡해질수록 JPA를 통한 쿼리제어의 세밀함은 떨어질 수 있다.
- **높은 러닝커브**
  - SQL 쿼리를 직접 작성하는 MyBatis 대비 JPA는 SQL 외 추가로 학습을 해야하기 때문에 러닝커브가 높다고 한다. 

<br>

**Reference**

- [victolee93 - [Spring JPA] ORM과 JPA 그리고 Hibernate](https://victorydntmd.tistory.com/195)

<br>

# <a name="git"></a>Git



<br>

## <a name="git-fork"></a>Fork

Fork는 다른 사람의 저장소를 내 저장소를 가져오는 기능이다. 정확히는 내가 Fork한 시점까지의 버전/커밋만 가져올 수 있다. 이후에 원래의 저장소, Upstream 저장소에 변경사항이 발생해도 내 저장소에 자동으로 반영되지는 않는다. 이 때엔 수동으로 Upstream 저장소의 변경사항을 동기화(`fetch`)하고 변경사항을 가져와야 한다. 자세한 방법은 [여기](https://youngjinmo.github.io/2019/09/git-sync-forked-repo/)를 참고바란다.

### 1. Fork할 저장소에서 Fork버튼을 클릭해서 가져온다.

![](http://www.mediafire.com/convkey/a78d/ozcxdz0mxotz4eozg.jpg)

### 2. Fork 저장소 확인

![](http://www.mediafire.com/convkey/bfca/349f4f3e0xz9iu3zg.jpg)

![](http://www.mediafire.com/convkey/68dc/3wsmvml6eq37oqezg.jpg)

### Clone과 Fork의 차이

Git 호스팅 서비스(Github, Gitlab)는 원격 저장소이다. 이런 원격 저장소에서 내 컴퓨터로 즉 로컬로 가져오는게 Clone이고, 원격저장소 내에서 내 이름의 저장소로 가져오는 행위는 Fork이다. 이 부분을 헷갈리지 않을 필요가 있다.

<br>

## <a name="git-pull-request"></a>PR

깃헙에서 PR이라는 단어를 자주봤을 것이다. PR은 Pull Request의 약어이다. 말 그대로 내가 작성한 커밋을 Pull 해달라고 요청하는 것이다. PR이 사용되는 경우는 아래의 경우에 해당된다.

프로젝트에 사용하는 공용 저장소를 [Fork](#git-fork)해서 자신의 저장소로 가져왔다. 여기에서 기능을 추가해서 커밋을 했는데 이게 프로젝트에 반영되려면 원격 저장소(Upstream)에 PR를 하는 것이다.

오픈소스에 기여(Contribution)하는 방법도 이와 같다. 오픈소스를 사용하다가 버그가 발견되었을 때, 해당 버그를 해결하기 위해 Fork한 저장소에서 버그를 해결한 코드를 작성후, PR을 하고, 원작자가 이를 받아들여서 오픈소스에 반영되면 내 이름이 컨트리뷰터에 오르게 된다.

PR하는 방법을 살펴보자.

### 1. 내 저장소에서 PR 요청

Github에 접속하면 Pull Request가 활성화되어있는 걸 확인할 수 있다. 

그 왼쪽의 메세지를 읽어보면, *'이 브랜치에 10개의 커밋이 [Upstream Owner:branch]를 바라보고 있다'*고 알려주고 있다. 이는 Upstream에 PR을 보낼 수 있는 10개의 커밋이 있다는 이야기이다.

![](http://www.mediafire.com/convkey/6ce7/3swf98prpdu4fu7zg.jpg)

### 2. Upstream 저장소의 브랜치와 내 저장소의 브랜치를 맞추고 PR

Upstream 저장소의 어떤 브랜치에 내 커밋을 병합(merge)할 것인지, 또 내가 보낼 커밋은 어떤 브랜치의 커밋인지를 맞춘뒤 Create pull request 버튼을 클릭하면 Merge 커밋메세지를 작성할 수 있다. Upstream의 오너가 이를 수용해서 merge하면 내가 작성한 커밋이 한꺼번에 Upstream의 브랜치에 반영된다.

![](http://www.mediafire.com/convkey/6bc0/1vj19nj4yncrlq3zg.jpg)

<br>

# <a name="devops"></a>DevOps



<br>

## <a name="aws"></a>AWS

### 우분투 EC2 인스턴스에 jdk 설치하기

- `sudo apt install default-jdk`

  - 구버전 설치할 경우, [Oracle Java Archive](https://www.oracle.com/technetwork/java/archive-139210.html)에서 버전을 찾아서 설치.

- `ssh -i [aws-public-key].pem ubuntu@[ip-port@aws]`

  - AWS 서버를 실행할 때마다 ip주소가 바뀐다. 바뀐 ip주소를 입력해야 정상적으로 AWS 웹서버에 접속할 수 있다.

    

<br>

# <a name="linux"></a>Linux

리눅스는 <a href="https://github.com/torvalds" target="_blank">리누스 토발스</a>가 개발한 컴퓨터 운영체제(OS)이다. <a href="https://github.com/torvalds/linux" target="_blank">오픈소스 운영체제</a>이며, 다중 사용자, 다중 작업(멀티태스킹), 다중 스레드를 지원하는 네트워크 운영체제라고 한다.

리눅스를 운영체제라고 했지만, 정확히는 운영체제라기보다 리눅스 커널이라고 하는게 맞다. 그러나 통상적으로 리눅스 커널과 우분투, 페도라와 같은 운영체제들도 리눅스라고 칭하고 있다.

리눅스의 역사나 배경에 대해서도 차후 더 알아보고 정리해야 할 것 같다.

<br>

## <a name="command-of-linux"></a>명령어

### <a name="linux-find"></a>find

**리눅스에서 파일이나 디렉토리를 검색**할 때 사용하는 명령어이다.

경로 Desktop/test 에서 용량 3mb 미만의 파일을 콘솔에 출력할 때 다음과 같이 명령한다.

`$ find Desktop/test -size -3M -type f`

경로 Desktop/test 에서 용량 10mb이상의 디렉토리를 `ls -l` 형태로 출력할 때 다음과 같이 명령한다.

`$ find Desktop/test -size +10M -type d -exec ls -l {} \;`

<br>

### <a name="linux-symboliclink"></a>심볼릭 링크 생성/사용하기

심볼릭 링크는 디렉토리 또는 파일에 더 빠르게 접근하기 위한 별명을 설정하는 일과 같다. `디렉토리 --심볼릭링크`

`ln -s [target] [symbolic_link_name]`

<img src="http://www.mediafire.com/convkey/1fa6/at0glqvdxyrry4czg.jpg" width="700" />

<br>

### <a name="linux-grep"></a>grep

유닉스를 위해 만들어진 텍스트 검색 기능의 명령어이다. <i>**g**rep | **r**egular **e**xpression | **p**rint</i>의 약자라고 한다.

`grep [pattern] [file]` 포맷으로 입력하면 [file]에서 [pattern]이 어디있는지를 알려준다.

![](http://www.mediafire.com/convkey/0dc1/t7dwrw36pfdc0l2zg.jpg)



`grep`은 옵셥으로 검색할 수도 있다.

[lorem-ipsum](https://www.lipsum.com/)에서 텍스트를 가져와서 lorem-ipsum.txt라는 파일을 만들었다. 여기서 **There**를 검색하면 다음과 같이 출력된다.

![](http://www.mediafire.com/convkey/c3d8/9azmf260ppue6huzg.jpg)

그런데 자세히 보면 대문자가 없을뿐 중간에 there가 쓰인 다른 문장도 찾을 수 있다. 이럴 때 `-i` 옵션을 사용해서 검색하면, 대소문자를 구분하지 않고 검색결과를 출력해준다.

![](http://www.mediafire.com/convkey/fff7/75me6ct6gtfe6odzg.jpg)

`grep` 의 옵션은 다음과 같다.

옵션은 중복해서 사용할 수 있다. 대소문자를 구별하지 않으면, 패턴이 일치하는 라인의 수를 출력하고 싶다면, `grep -ic "PATTERN" FILE` 형식으로 검색하면 된다.

| option | description                             | example                    |
| ------ | --------------------------------------- | -------------------------- |
| -i     | 비교시 대소문자를 구별 안함             | `grep -i "PATTERN" FILE `  |
| -c     | 패턴이 일치하는 라인의 수를 출력        | `grep -c "PATTERN" FILE`   |
| -v     | 지정한 패턴과 일치하지 않는 라인만 출력 | `grep -v "PATTERN" FILE`   |
| -n     | 행의 번호를 함께 출력                   | `grep -n "PATTERN" FILE`   |
| -w     | 패턴이 전체 단어와 일치하는 행만 출력   | `grep -w "PATTERN" FILE`   |
| -m     | 최대 검색 결과 갯수 제한                | `grep -m 1 "PATTERN" FILE` |



**References**

- [개발자를 위한 레시피 - 리눅스 grep 명령어 사용법](https://recipes4dev.tistory.com/157)

<br>

## <a name="linux-vi"></a>Vi Editor

### <a name="vi-input"></a>입력 명령어

| 입력키 | 작업                                                |
| ------ | --------------------------------------------------- |
| i      | 커서의 **<u>현재 위치</u>**에서 **입력** 시작       |
| a      | 현재 커서보다 **<u>한 칸 뒤</u>**에서 **입력**시작  |
| A      | 현재 커서 위치의 **<u>줄의 끝</u>**에서 **입력** 시 |
| o      | 현재 커서의 **<u>다음줄</u>**에서부터 **입력시작**  |
| u      | 직전 작업 되돌리기(undo)                            |
| U      | 전체 변경사항 되돌리기                              |
| ESC    | 입력모드 종료                                       |
| dd     | 커서가 가리키는 **<u>한 줄</u>** **삭제**           |
| 3dd    | 커서가 가리키는 줄부터 **<u>3줄</u>** **삭제**      |
| dw     | 커서가 가리키는 **<u>단어 하나</u>** **삭제**       |
| 4dw    | 커서가 가리키는 **<u>단어 4개</u>** **삭제**        |
| D      | 현재 커서로부터 **<u>뒤의 컨텐츠</u>** **삭제**     |
| x      | 한 문자형(char) **<u>삭제</u>**                     |
| r      | 한 문자형(char) **<u>변경</u>**                     |
| yw     | 커서가 가리키는 **<u>한 단어</u>** **복사**         |
| y$     | 커서가 가리키는 **<u>줄의 끝까지</u>** **복사**     |
| yy     | 커서가 가리키는 **<u>줄 전체</u>** **복사**         |
| yj     | 커서가 가리키는 **<u>줄과 다음 줄</u>** 복사        |
| yk     | 커서가 가리키는 **<u>줄과 앞의 줄</u>** **복사**    |
| p      | 붙여넣기 (paste)                                    |



### <a name="vi-move"></a>이동 명령어

| 입력키 | 작업 |
| ------ | ---- |
| k      | ↑    |
| j      | ↓    |
| h      | ←    |
| l      | →    |



### <a name="vi-filestatus"></a>파일 상태 변경 명령어

| 입력키 | 작업              |
| ------ | ----------------- |
| :w     | 파일 저장         |
| :q     | 종료하기          |
| :wq    | 저장하고 종료하기 |



**References**

- [VI Text Edito with Commonds: Linux/Unix Tutorial](https://www.guru99.com/the-vi-editor.html)

<br>

# <a name="osx"></a>MacOS

현재 사용중인 컴퓨터의 운영체제가 MacOS인데, 처음 개발을 공부할 때 개발도 물론이거니와 이 맥이라는 환경에 개발자로서 적응해야하는 시간도 필요했다. 그래서 공부하면서 알게 된 것들을 정리해 남겨보겠다.

## <a name="homebrew"></a>Homebrew

<img src="http://www.mediafire.com/convkey/011a/ug38gl0hjk0f0s1zg.jpg" width="500" />

[Homebrew](https://brew.sh/index_ko)는 맥OS 또는 리눅스에서 기본으로 제공하지 않는 패키지를 설치/제거할 수 있는 패키지 관리자다. 리눅스의 `apt-get` 과 비슷한 역할을 한다.

보통 맥에서 필요한 패키지를 설치할 때 자주이용하는 서비스니 맥을 사용하는 개발자라면 익혀두면 좋다.

### Homebrew 설치

터미널을 열고 아래 명령어를 붙여넣기하고 입력하면 homebrew가 설치된다. 엄청 간단하다.

`/usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"`



### 패키지 설치

설치하고 싶은 패키지가 있다면, 먼저 패키지가 있는지 알아둬야 한다.

`brew search [package-name]`

있다면 `search` 대신 `install`로 바꾸어서 패키지를 설치하면 된다.

`brew install [package-name]`



### homebrew 업데이트

기본적으로 패키지를 설치하기 전에 homebrew가 자동으로 업데이트를 진행하지만, 일단 알아두자.

`brew update`

<br>

## <a name="osx-package-tree"></a>Tree 패키지

터미널에서 디렉토리를 계층적으로 분리해서 볼 수 있는 패키지다.

깃헙에서 사용할 수 있는 익스텐션인 [Octotree](https://www.octotree.io/)와 비슷하다.



### 패키지 설치

[homebrew](#homebrew)를 이용해서 설치할 수 있다. 

`brew install tree`

### 패키지로 디렉토리 한 눈에 보기

현재 디렉토리를 터미널에서 계층적으로 구분해서 편하게 보려면 `tree .` 을 입력하면 된다.

<img src="http://www.mediafire.com/convkey/0813/u5n9x04o217pgqezg.jpg" width="500" />

<br>

<br>