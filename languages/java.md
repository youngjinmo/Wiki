# Java

- [Java의 특징](#feature)
- [Java의 철학](#philosophy)
- [IDE없이 컴파일하고, 실행하기](#run-compile-without-ide)
- [Wrapper Class](#wrapper-class)
- [Date](#java-date)
- [Javadoc](#javadoc)
- [Math](#math)
- [length, length(), size()](#length)
- [==과 equals()](#equals)
- [문자열 변환 함수](#touppercase)
- [Lombok](#lombok)
- [JavaBean](#javabean)
  - [JavaBean 규칙은 무엇이며, 왜?](#rule-and-why)
  - [Bean 생성하는 법](#create-javabean)

<br>

## <a name="feature"></a>Java의 특징

<img src="http://www.mediafire.com/convkey/af35/opivqpoyrlo8n5gzg.jpg" width="500" />

- Java는 'Java의 아버지'로 불리우는 <a href="https://www.linkedin.com/in/jamesgosling/" target="_blank">James Gosling</a>가 1995년, Sun Microsystems.Inc,(이하 Sun)에서 다른 연구원들과 함께 개발한 프로그래밍 언어이다. 1995년에 Java 1.0을 발표했다. 
- 2009년 Oracle이 Sun을 56억불에 Oracle에 <a href="https://www.cbsnews.com/news/oracle-buys-sun-microsystems-for-74b/" target="_blank">인수</a>하면서 모든 권리가 Oracle로 이전되었다.
- Java는 [**객체지향언어**(Object Oriented Language)](#oop)<sup>`1`</sup>이다.
- Java가 등정하기 이전의 객체지향언어인 C++ 문법을 기본으로 개발되었다.
- Java가 다른 언어와 다른 가장 큰 특징은  [**JVM**](#jvm)<sup>`2`</sup> 위에서 작동되기 때문에 [**플랫폼 독립적**](#os-independent)<sup>`3`</sup> 이라는 점이다. HW에 맞게 완전하게 컴파일된 상태가 아니라 실행 시에 해석(Interpreter)되기 때문에 속도가 느리다는 단점을 가지고 있었다. 그러나 최근엔 JIT 컴파일러와 최적화된 기술로 인해 속도의 격차가 크게 줄었다.
- Java는 C/C++와 달리 **메모리를 자동으로 관리**해준다. **Garbage Collector**(이하 GC)가 사용하지 않는 메모리를 자동으로 정리해준다.

<br>

## <a name="philosophy"></a>Java의 철학

- [객체 지향 방법론](#oop)<sup>`1`</sup>을 사용해야 한다.
- 프로그램(바이트 코드)가 여러 운영체제에서 실행될 수 있어야 한다. ([플랫폼 독립성](#os-independent)<sup>`3`</sup>)
- 컴퓨터 네트워크 접근 기능이 기본으로 탑재되어 있어야 한다.
- 원격 코드를 안전하게 실행할 수 있어야 한다.
- 다른 객체 지향 언어들의 좋은 부분만 가지고 와서 사용하기 편해야 한다.

<br>

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

## <a name="math"></a>Math

수학 연산 기능을 갖고있는 클래스이다. `Math` 클래스가 갖고있는 함수 목록이다.

- <a href="https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html#abs-int-" target="_blank">abs(double num)</a>

  - `abs` 함수는 모든 숫자 데이터타입을 지원한다. (int, long, float, double)
  - 절대값을 구하는 함수

- <a href="https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html#ceil-double-" target="_blank">ceil(double num)</a>

  - 반올림 함수

- <a href="https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html#floor-double-" target="_blank">floor(double num)</a>

  - 내림 함수

- <a href="https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html#round-double-" target="_blank">round(double num)</a>

  - 올림 함수

- <a href="https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html#max-double-double-" target="_blank">max(double num1, double num2)</a>

  - 두 수중 큰 수 구하는 함수

- <a href="https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html#min-double-double-" target="_blank"> min(double num1, double num2)</a>

  - 두 수중 작은 수 구하는 함수

- <a href="https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html#pow-double-double-" target="_blank">pow(double num1, double num2)</a>

  - num1의 num2 제곱.

  - ```java
    public static main(String[] args){
      int num1 = 5;
      System.out.println(Math.pow(num1, 2));
    }
    // 25.0 출력
    ```

- <a href="https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html#random--" target="_blank">random()</a>

  - 1부터 10까지 수중 랜덤 수 출력하는 함수

<br>

## <a name="length"></a>length, length(), size()

Java에서 길이를 반환하는 메서드 또는 프로퍼티는 `length`, `length()`, `size()`가 있다. 이들은 데이터타입에 맞게 사용해줘야 한다. 필요한 데이터타입은 다음과 같다.

| 함수       | 사용가능한 데이터타입                  |
| ---------- | -------------------------------------- |
| `length`   | 배열                                   |
| `length()` | 문자열                                 |
| `size()`   | 컬렉션 프레임워크 타입 (ArrayList, ..) |

더 자세히 알아보고자 한다면, 블로그를 참고할 것.

- [DevAndy - length, length() 그리고 size()의 차이](https://youngjinmo.github.io/2019/12/java-length-size/)

<br>

##<a name="equals"></a>==과 equals()

문자열을 비교할 때 사용하는 방법이 두가지가 있다. `==` 와 `equals()` 가 있는데, 이 둘은 어떤 차이가 있을까.

|            |                                                     |
| ---------- | --------------------------------------------------- |
| `==`       | 비교하는 대상 객체들의 **주소값(reference)**을 비교 |
| `equals()` | 비교하는 대상 객체들의 **값(value)**를 비교         |

더 자세히 알아보고자 한다면, 블로그를 참고할 것.

- [DevAndy - 문자열 비교, ==과 equals()의 차이](https://youngjinmo.github.io/2019/12/java-equals/)

<br>

##<a name="touppercase"></a>문자열 변환 함수

입력받은 문자열중 같은 문자가 몇번 나오는지를 파악하는 [문제](https://www.acmicpc.net/problem/1152)를 풀다가 자주 사용하는 문자열 변환 함수를 정리해보았다.

위 문제에서 사용한 문자열 메서드는 `toUpperCase()` 이다. 문자열 전체를 대문자로 변환하는 메서드이다.

| methods         | doing                            |
| --------------- | -------------------------------- |
| `toUpperCase()` | 문자열 전체를 대문자로 변환한다. |
| `toLowerCase()` | 문자열 전체를 소문자로 변환한다. |
| `trim()`        | 문자열 앞 뒤의 공백을 제거한다.  |

문자열 메서드끼리는 중복 사용도 가능하다.

![](http://www.mediafire.com/convkey/d469/mxdlxuexldnhqzmzg.jpg)

<br>

## <a name="lombok"></a>Lombok

자바에서 Model을 만들때, 멤버필드에 대한 Getter/Setter, toString과 멤버필드에 주입하는 생성자를 만드는 코드등 반복적으로 작성하게 되는 코드를 어노테이션으로 줄여주는 라이브러리이다.

Maven/Gradle로 프로젝트를 진행하는 경우, MVNrepository에서 Dependency를 추가할 수 있다.

**Lombok 적용 전**

```java
package devandy.domain;

public class User {
   private Integer id;
   private String email;
   private String password;

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }
}
```

<br>

**Lombok 적용 후**

```java
package hello.domain;

import lombok.Data;

@Data
public class User {
   private Integer id;
   private String email;
   private String password;
}
```

<br>

## <a name="javabean"></a>JavaBean

프로젝트 코딩을 하다가 이런 에러 메세지가 인텔리J에 출력되어 알아보았다. 

```
Could not autowire. No beans of 'Principal' type found.
```

그 동안 모르면서 그냥 무턱대고 사용하고 있었는데, 이 기회에 제대로 알아야 할 것 같아 삐멜님 블로그에 들어가서 자바 빈을 설명한 [포스트](https://imasoftwareengineer.tistory.com/101)를 참고하여 옮겨적었다. 원래는 삐멜님의 포스트를 읽고 이해한 것을 바탕으로 정리하려고 했는데, 다 알아둬야 할 것 같아 그대로 옮겨적게되었다.. 그러다보니 길어져서 JavaBean 내용만을 정리한 ToC를 만들었다.

**ToC**

- [JavaBean 규칙은 무엇이며, 왜?](#javabean-rule)
- [JavaBean 예제코드 (출처:삐멜님 블로그)](#javabean-examplecode)
- [왜 접근제한자 private에 getter/setter 메서드?](#how-to-use-javabean)
- [왜 no-argument 생성자 사용?](#javabean-why-create-no-argument)
- [왜 java.io.serializable 인터페이스 구현?](#javabean-why-create-interface)
- [Bean 생성하는 법](#create-javabean)

<br>

---

### <a name="javabean-rule"></a>JavaBean 규칙은 무엇이며, 왜?

자바 빈은 데이터를 표현하는 것을 목적으로 하는 자바 클래스이다.

자바 빈은 아래의 규칙을 따른다.

- 모든 필드가 `private` 이며, `getter`/`setter` 메서드를 통해서만 접근이 가능
- Argument가 없는(no-argument) 생성자가 존재
- `java.io.Serializable` 인터페이스를 구현



### 왜?

자바 빈의 목적은 여러가지 서로다른 객체들을 하나의 객체(Bean)에 담기 위함이다. JavaBean의 규칙을 소프트웨어 프로토콜이라고 생각하면된다.

<br>

### <a name="javabean-examplecode"></a>JavaBean 예제 코드

[출처: 삐멜의 소프트웨어 엔지니어](https://imasoftwareengineer.tistory.com/101)

```java
import java.io.Serializable;

public class SomeBean implements Serialzable {
   private String beanName;
   private int beanValue;
  
   public SomeBean(){
      // no-argument constructor
   }
  
   public String getBeanName(){
      return beanName;
   }
  
   public void setBeanName(String beanName){
      this.beanName
   }
  
   public void setBeanValue(int beanValue){
      this.beanValue = beanValue;
   }
}
```

<br>

### <a name="how-to-use-javabean"></a>왜 접근제한자 private에 getter/setter 메서드?

JavaBeans는 `private` 필드와 `getter`/`setter` 를 지키는데, 이런 규칙을 지키는 클래스를 POJO(Plain Old Java Object)라고 부른다. `private` 필드와 `getter`/`setter` 메서드를 사용하는 이유는 **Encapsulation**을 위함이라고 한다.

<br>

### <a name="javabean-why-create-no-argument"></a>왜 no-argument 생성자 사용?

위 [예제코드](#example-code)를 기반으로 생각해보자. 다른 곳에서 `SomeBean` 객체를 프로그램 내에서 생성하고자 한다면, 어떻게 될까?

Argument가 몇개인지, 어떤 필드에 맵핑되는지를 찾아야한다. 그러나 Argument가 없는 생성자를 만들어두면 오브젝트를 런타임(Runtime)에 생성해주는 프로그램은 오브젝트 생성 -> getter/setter를 이용해 값 설정으로 단순하게 목적을 달성 할 수 있다.

<br>

### <a name="javabean-why-create-interface"></a>왜 ava.io.serializable 인터페이스 구현?

[JavaBean의 목적](#rule-and-why)은 여러가지 객체들을 하나의 객체에 담기 위함이라고 했는데, 담아서 무엇을 하려는걸까. 메모리에 존재하는 오브젝트를 네트워크를 통해 전송하거나 파일에 저장하려면 `data stream`(e.g. `byte[]`)으로 이 오브젝트를 변환시켜줘야한다. 이 변환 작업을 Serialization이라고 부른다. JavaBean을 저장하거나 전송하는 일이 많기 때문에, Serializable가 스탠다드에 포함되는것으로 추정.

<br>

###<a name="create-javabean"></a>Bean 생성하는 법

어노테이션을 이용해서 자바 빈을 생성할 수 있다.

자바 빈에 사용되는 어노테이션은 다음과 같다.

```java
@Configuration
@Bean
```



실제로 자바 빈을 생성하는 코드를 보자.

`ApplicationConfg.java`

```java
@Configuration
public class ApplicationConfig {
  
  // 생성자 메서드를 이용한 Bean 생성
  @Bean
  public Player player01(){
    Player player = new Player("Rooney", 10);
    return player;
  }
  
  // setter 메서드를 이용한 Bean 생성
  @Bean
  public Player player02(){
    Player player = new Player();
    player.setName("Ji-sung");
    player.setNumber(13);
    return player;
  }
}
```



`Player.java`

```java
public class Player {
  private String name;
  private int age;
  
  // 생성자 Constructor
  public Player(){
    
  }
  
  public Player(String name, int number){
    this.name = name;
    this.number = number;
  }
  
  // getter/setter 메서드
  public String getName(){
    return name;
  }
  public void setName(String name){
    this.name = name;
  }
  public int getAge(){
    return age;
  }
  public void setAge(int age){
    this.age = age;
  }
  
  @Override
  public String toString(){
    return "Player [name="+name+", age="+age+"]";
  }
}
```



`Main.java`

```java
public class Main {
  public static void Main(String[] args){
    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicaionConfig.class);
    
    Player player01 = ctx.getBean("player01", Player.class);
    System.out.println(player01.toString());
    
    Player player02 = ctx.getBean("player02", PLayer.class);
    System.out.println(player02.toString());
  }
}
```



<br>