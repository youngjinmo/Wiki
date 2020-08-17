# Java

- [Java의 특징](#feature)
- [Java의 철학](#philosophy)
- [터미널에서 컴파일하고, 실행하기](#run-compile-without-ide)
- [기본형 타입과 참조형 타입](#java-type)
- [접근제한자](#access-modifier)
- [String 클래스 내장 메서드](#string-methods)
- [클래스 타입 반환하기](#getclass)
- [enum](#enum)
- [Wrapper Class](#wrapper-class)
- [Scanner](#scanner)
- [Date](#date)
- [Calendar](#calendar)
- [Javadoc](#javadoc)
- [Math](#math)
- [length, length(), size()](#length)
- [==과 equals()](#equals)
- [객체 주소값 확인 ( identityHashCode() )](#identityHashCode)
- [시스템 시간 불러오기 for 성능 테스트](#currentTimeMillis)
- [삼항연산자](#ternary)
- [switch문](#switch)
- [for문](#for-loop)
- [for each문](#for-each)
- [Enumeration 인터페이스](#enumeration)
- [Iterator 인터페이스](#iterator)
- [컬렉션 프레임워크](#collection-frameworks)
  - [Set](#collection-set)
  - [List](#collection-list)
  - [Map](#collection-map)
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

## <a name="java-type"></a>기본형 타입과 참조형 타입

### Primitive Type (기본형 타입)

연산에 사용되는 자료형 8가지.

기본형 타입은 non-Object 타입이며, **null 값을 가질 수 없다.**

~~~java
int num = null; // 에러를 발생한다. 기본형 타입은 null을 가질 수 없다.
int num = 0; // 기본형 타입의 초기화는 이렇게 해야한다.
~~~

| Data Type | Size    | Description                                             |
| --------- | ------- | ------------------------------------------------------- |
| byte      | 1 byte  | -128 to 127                                             |
| short     | 2 bytes | -32,768 to 32,767                                       |
| int       | 4 bytes | -2,147,483,648 to 2,147,483,648                         |
| long      | 8 bytes | -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807 |
| float     | 4 bytes | 3.4e−038 to 3.4e+038                                    |
| double    | 8 bytes | 1.7e−308 to 1.7e+308                                    |
| boolean   | 1 byte  | true or false                                           |
| char      | 2 bytes | Must be surrounded by single quotes like 'A'.           |



### Reference Type (참조형 타입)

기본형 타입 8가지를 제외한 나머지 자료형이다. 기본적으로 `java.lang.Object`를 상속받는 객체이다. **<u>참조형 타입의 변수는 null 또는 메모리 주소를 값으로 갖는다.</u>** 연산자 `new` 의 결과가 객체의 주소이다.

참조형 객체로는 클래스형(Class Type), 인터페이스형(Interface Type), 배열형(Array Type)이 존재한다.

<br>

## <a name="access-modifier"></a>접근제한자

접근제한자는 클래스 내에서 멤버의 접근을 제한하는 역할을 수행한다.

<table>
  <tr>
    <th style="width: 20%; text-align: center;">접근제한자 종류</th>
    <th style="text-align: center;">설명</th>
  </tr>
  <tr>
    <td>public</td>
    <td>어떤 클래스든 접근가능</td>
  </tr>
  <tr>
    <td>protected</td>
    <td>상속받은 클래스에서는 접근가능</td>
  </tr>
  <tr>
    <td>default</td>
    <td>같은 패키지에서만 접근가능</td>
  </tr>
  <tr>
    <td>private</td>
    <td>자신을 제외한 모든 클래스의 접근 불가능</td>
  </tr>
</table>

접근 영역순으로 정리하면, 다음과 같다.

**public > protected > default > private**

<br>

## <a name="string-methods"></a>String 클래스 내장 메서드

String 클래스가 내장하고 있는 메서드들에 대해 정리해보았다.

### length()

~~~java
/**
 * 문자열 데이터의 길이를 반환하는 메서드이다.
 * 파라미터는 존재하지 않는다.
 */

String str = "Hello Java";
System.out.println(str.length()); 
// 출력결과 : 10
~~~

### concat()

~~~java
/**
 * 문자열과 문자열을 결합하는 메서드이다.
 * 파라미터에 추가할 String형 데이터가 온다.
 */

String str = "Hello ";
String lang = "Java";
System.out.println(str.concat(lang));
// 출력결과 : Hello Java
~~~

### subString()

~~~java
/**
 * 문자열을 자르는 메서드이다.
 * 파라미터에 어디부터 어디까지 자를지 문자열의 인덱스가 와야한다.
 * 첫번째 파라미터가 시작 인덱스, 두번째 파라미터가 마지막 인덱스이며,
 * 파라미터를 하나만 넣을경우, 입력받은 인덱스부터 마지막까지 문자열을 자른다.
 */

String str = "Hello Java";
String lang = str.subString(6);

System.out.println(lang);
// 출력 결과 : Java
~~~

### indexOf()

~~~java
/**
 * 문자가 위치한 인덱스를 반환하는 메서드이다.
 * 파라미터로 char형 문자를 입력받으며, 해당 문자와 일치하는 문자가 
 * 문자열에 존재할 경우 인덱스를 반환한다. 
 * 만약 2개 이상 문자가 발견될 경우, 가장 먼저 오는 문자의 인덱스를 반환한다.
 * 문자가 존재하지 않는 경우엔 -1을 반환한다.
 */

String str = "Hello Java";
System.out.println(str.indexOf('a'));
// 출력 결과 : 7
~~~

### charAt()

~~~java
/**
 * indexOf()와 반대의 메서드이다.
 * 인덱스에 위치한 문자를 반환하는 메서드이다.
 * 파라미터로는 int형 인덱스를 입력받는다.
 */

String str = "Hello Java";
System.out.println(str.charAt(1));
// 출력 결과 : e
~~~

### isEmpty()

~~~java
/**
 * 해당 문자열이 빈 값인지 확인하는 메서드이다.
 * 문자열의 길이가 0인지 비교하여 boolean값을 반환한다.
 * 파라미터는 없다.
 * 문자열의 길이가 0이면, true
 * 문자열의 길이가 0이 아니면 false
 */

String str = "Hello Java";
System.out.println(str.isEmpty());
// 출력 결과 : false
~~~

### replace()

~~~java
/**
 * 문자열의 일부를 다른 문자열로 바꿔주는 메서드이다.
 * 파라미터로는 2개를 가지며, 첫째 파라미터로 바꿀 문자열,
 * 두번째 파라미터로 새로운 문자열을 입력한다.
 */

String str = "Hello Java";
String newStr = str.replace("Java", "Python");

System.out.println(newStr);
// 출력 결과 : Hello Python
~~~

### toUpperCase()

~~~java
/**
 * 문자열을 대문자로 바꿔주는 메서드이다.
 * 파라미터에 대문자로 바꿔줄 String 데이터를 입력한다.
 */

String str = "hello java";
String strUp = str.toUpperCase();

System.out.println(strUp);
// 출력 결과 : HELLO JAVA
~~~

toUpperCase()는 subString()과 함께 사용하면, String 클래스에는 없는 첫글자만 대문자로 바꾸는 capitalize를 구현할 수 있다.

~~~java
String str = "hello java";
String newStr = str.subString(0, 1).toUpperCase();
// subString으로 첫글자만 가져와서 toUpperCase()를 적용한 코드이다.
~~~

### toLowerCase()

~~~java
/**
 * 문자열로 소문자로 바꿔주는 메서드이다.
 * 파라미터에 소문자로 바꿔줄 String 데이터를 입력한다.
 */

String str = "HELLO JAVA";
String strLo = str.toLowerCase();

System.out.println(strLo);
// 출력 결과 : hello java
~~~

### trim()

~~~java
/**
 * 문자열 앞뒤의 공백을 제거해주는 메서드이다.
 * 파라미터는 없다.
 */

String str = "  Hellooo Java World   ";
String trimStr = str.trim();

System.out.println(trimStr);
// 출력 결과 : Hellooo Java World
~~~

### split()

~~~java
/**
 * 문자열을 잘라서 배열로 반환하는 메서드이다.
 * 파라미터로 자를때 기준이 되는 문자열을 입력받는다.
 */

String str = "Hello Java";
String[] arr = str.split("");

System.out.println(Arrays.toString(arr));
// 출력 결과 : [H, e, l, l, o,  , J, a, v, a]
~~~

### toCharArray()

~~~java
/**
 * split("")과 같은 기능이지만, 반환하는 배열의 타입이 문자열 배열이 아니라
 * 문자형(char[]) 배열이라는 차이가 있다.
 * 파라미터는 없다.
 */

String str = "Hello Java";
char[] cArr = str.toCharArray();

System.out.println(cArr);
// 출력 결과 : Hello Java
~~~

### getBytes()

~~~java
/**
 * byte 배열로 반환하는 메서드이다.
 * 파라미터는 없다.
 */

String str = "Hello Java";
byte[] bytesArr = str.getBytes();

System.out.println(Arrays.toString(bytesArr));
// 출력 결과 : [72, 101, 108, 108, 111, 32, 74, 97, 118, 97]
~~~

여기서 출력되는 byte코드는 [아스키코드 테이블](https://www.ascii-code.com/)을 보면 어떤 문자열을 의미하는지 알 수 있다.

![](https://lh3.googleusercontent.com/y82u1xMYdpei4fNvYZxEiUnbHuR5p8I0D29cSN0hWmN5uRLN7MLdjxyNj08j90655x6GgnD12StW5PKVZoS40f4-OWYGy-eG1qQ2hM0OOc46vw-sK-b4_hZwbO9rGe73U5RpSiEfHrRp7hmKp7QCQku47KwQkXU2Bb5MOB-r3-DRD7t4LlOkVxdL49YnkLGZZAgKiGSsRS-kyisPhgGfdQQTafl782mbM1un6zc-hwYD9HwkZQ1_rADp_7NQNH4aXFq7v_txuFF_PgkaNyeo41SyCZJoxArORrufHDFfwav8sgx4KUgtS1XES41ArL4ry1pDkeXB3-I9dEDI_DfnFFee3EjZDjJqkoVn2xzswlyg3lQNwOUcvTAVhL4XyL3baJk7AgW0SChvJ5wvTjnRVgC3erSDHM8rHCeOUdT8Rln29ic2S474gNGlCcKjBkZQ2OF4wh4iEH6U0U3CpbJA_pE05LCUNubY9x-QVt2nz4HYGDGfEfLJ6Et1UDXcyeRBigjyTBRIBYUH4yUZbLQesE9C3ZSEnI-W4C8BVWiU_3jiGxkFKOy_RQvRb2nQRNXndTSS0mW4B-bfmMB9iJypKpVU10OlLynm-z66U22aL5KsZyRo58d4pBGqdbumVIFSWKbQ2JzHnFx8DT34u4QR9pQyG6kFGitTaaGS6Rc81zet6mFNitL4hYZwfBQbVPJdWDgg9cfPv2dAJ1kk7IUSuVwPj51znMbdHhi-72X7wSYWLrbluRtt9W3M=w870-h240-no)

아스키코드 테이블상 H라는 문자는 10진수 72와 매칭된다. 따라서 문자열 str 변수에서 H의 문자와 매칭되는 바이트 코드는 72라는 걸 알 수 있다.

<br>

## <a name="getclass"></a>클래스 타입 반환하기

객체의 타입을 알아내는 메서드이다. Object 클래스에 내장된 메서드이다.

~~~java
public class DevAndy {
  public static void main(String[] args){
    Car c = new Car();
    
    System.out.println(c.getClass().getName());
  }
}
~~~

![](https://lh3.googleusercontent.com/zT_zQmPslMKvOO0ZVEfQX03DWc6403YtuhPD7nzM3Z7DuhWwlohn1i_1AAhtBRrOk_wknEi_bsB2Ds7hJSkeVewMaJuGEzzNrB5R-EgWVixUI4I_U6nHtd_hwCdSz6y_kLGbUFiL7Vy9GoWkSRhmS843wTIiUy4wDcuwsiQa34w0TRySBOGTxt_WKB6ByBRZgvsjx0hat1ywg4uX81xnSIpf1cRabCRKftlH4qWMDFvEd7l30-GD3d0gN3D-85jshVF1QVElTepBQN6il4n-04I-E0VEQbWHNj0WH9jbCLssjLsHSDjBI5kdJPOi_qyThePctDRr3CYWfB9CFaOGEczhmeiG0_m7RszRBExudsxqfyEtJez7Azx2rKiZQ2SJjEkUvz4vBY0a-3x21vG0r2aTBP95TqfojVwjuRKeUw1MhSXTv8E42aPrLgDdpmnik8q8dZtJMv6bLNvLhPHjyWcb8G2w67ISgBxyHAelfJMygH6Gn7EdFJq2046dTdz2fmH_VDe3oePJwbcqs83-cDnGZypjmYBASY_nJngxHiaBvXJMmIJpBJw8JUxTRJqeacYc-yisotKFElmXelfLvDUI9W2e1Dd-G0wNXRzbIr8QkkWyy7Zx8sw9lDeHIxGnLU-ZEXp-Twk5cLVbXZBLHQKUWgxsTNAOWUycCw2FUrskHtjfjTF8sZl-Jz2nLzSpUT7p8ywGmky1JXxfmmkXzFAFvHGHLIuy5zYZwYOkgXwqkffJ4PpePYhK=w1288-h420-no)

<br>

## <a name="enum"></a>enum

enum은 자바 클래스의 한 종류인데, **서로 연관된 상수들의 집합**이다. Java 1.5 버전부터 추가되었다고 한다.

final 키워드를 사용해서 상수를 선언하는 것과 똑같은 역할이다. 다만 이렇게 연관된 상수들을 하나로 모아둔 점이 특징이다. 

enum은 클래스로 생성할수도 있고, 내부클래스로도 생성할 수 있다.

### enum을 사용하는 목적

- 코드 가독성을 높힌다.
- 객체의 값을 특정 값으로 제한하고 싶을때 사용한다. enum 클래스내에 선언된 타입으로 상수 사용을 제한할 수 있다.



enum 클래스를 활용한 예제 코드이다.

**Developer.java**

~~~java
public class Developer {
   String name;
   int age;
   Main.DevType type;
}
~~~

**Main.java**

~~~java
public class Main {
   public static void main(String[] args) {

      Developer dev = new Developer();

      dev.name = "DevAndy";
      dev.age = 29;
      dev.type = DevType.WEB;

      System.out.println("name : "+dev.name);
      System.out.println("age : "+dev.age);
      System.out.println("type : "+dev.type);
   }

   enum DevType {
      WEB, ANDROID, IOS, SERVER
   }
}
~~~

<img src="https://lh3.googleusercontent.com/x-YHKnMrzNw92Q881oISbxKCZjQmkxYfy2JIbUkYVHA35rfPR8s9vCHgZngzmTzkQOLF3o8GOdQuMHriyBvMFZg-nC5CQoLAeLbJ1vqGTlBd2piMmhUXv-y18xlGti3NXwRluJE4nWZm2dvIT0kgh0kxTzdGSuiz-IO96oSfBoev_CFawtwxBPGl8ZVADsZlXFTTUDH-rTo6tO2eaysypC5AExYTHyut62TFsGiSKk4H2r6JytgNqIIgNFcBXlpjeNtpYJuBjRdycOr4ru840JiaMHWvOAEc0mb8P07Eje5AwBmWYGHAg_rDiNM-uOlsy5ezEtnqlWeRaCB5nS481L0GiBh5VpZPnqFnvkwetpt5UzGXJHZZHFnQg-JYDzGIDksZacFftBojhqZ7PMQcWBYb2DnYdIfPLPf5gziecuRAD52Z8GNxlM-108wd9F52u6cdwGYaRKm_FkbJdpgOTZ8LxnhB7LPztaV8I7o-HoQWKFlCuogG7dqq08RVwQAY5NXAUnrxU6VC6wQe2oLtr_ktrS1ztEyRFHtcv2TJUVH5dkdTcPqBvC0S-wP-lzsY98nYGeW8bqRgpXYeUABUnB38GtKWrVmkROGE4m0PtfhVPjpvAXqHTvDc0_jYEJ1JHYRwKHbFhS8bV2uveKaOp30-KkmdXo0y3W-xcaUW5a8Nh9aPNZdx68E7dSiFt9zqw7eKW0pESynyUenV5bPNwm3zx8udnMDAyoc6xT6bw76jAEoGymRF3vqF=w756-h454-no" style="width: 70%;" />

<br>

## <a name="wrapper-class"></a>Wrapper Class

기본형 데이터타입의 객체화를 가능하게 도와주는 클래스. `java.lang` 패키지 안에 포함되어있다.

- 기본형 타입 예 : `int`
- 객체형 타입 예 : `Integer`

~~~java
int a = 5;
Integer b = new Integere();

int c = b;      // auto-unboxing
Integer d = a;  // auto-boxing
~~~



**오토 박싱 (Auto Boxing)**

기본 타입 데이터를 객체 타입의 데이터로 자동 형변환해주는 기능이다.



**오토 언박싱 (Auto Unboxing)**

오토박싱과 반대로 객체 타입의 데이터를 기본형 타입 데이터로 자동 형변환

오토박싱과 오토언박싱은 자바6부터 도입된 기능이라고 한다.

### References

- [프로그래머스 - [자바 중급] java.lang 패키지/오토박싱](https://youtu.be/Eofo8_xZbfk)

<br>

## <a name="scanner"></a>Scanner

Scanner 클래스는 입력을 받아주는 클래스이다.

### `String` 형을 입력으로 받을 때.

~~~java
String str = new Scanner(System.in).next();

// Scanner 인스턴스를 따로 생성했을 경우,
Scanner sc = new Scanner(system.in);
String str = sc.next();
~~~

### `int` 형을 입력으로 받을 때.

~~~java
int num = new Scanner(System.in).next();

// Scanner 인스턴스를 따로 생성했을 경우,
Scanner sc = new Scanner(system.in);
int num = sc.nextInt();
~~~

### `char` 형을 입력으로 받을 때.

~~~java
Scanner sc = new Scanner(system.in);

String s = sc.next();
char c = s.charAt(0);
~~~

<br>

## <a name="date"></a>Date 객체

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
    
    String serverDate = date.format(day);
    String serverClock = clock.format(day);
    
    System.out.println("서버 실행한 날짜는 "+serverDate);
    System.out.println("서버 실행한 시각은 "+serverClock);
  }
}
```

![](http://www.mediafire.com/convkey/78db/kx7v4ezlus1w9xnzg.jpg)

<br>

## <a name="calendar"></a>Calendar

`Calendar` 객체는 `date` 객체가 갖고있지 않은 지역화를 해결하기 위해 jdk1.1에 추가된 클래스이다. 

~~~java
Calendar cal = Calendar.getInstance();
~~~

`Calendar`에서 날짜 타입을 사용하기 위해서는 `Calendar.get()`을 사용해야 한다.

이를 이용하여 오늘 날짜를 알아내는 방법은 다음과 같다.

~~~java
int year = cal.get(Calendar.YEAR);
int month = cal.get(Calendar.MONTH)+1;
int day = cal.get(Calendar.DAY_OF_MONTH);

String today = year+"년 "+month+"월 "+day+"일";
System.out.println("오늘날짜는 "+today+"입니다.");
~~~

<img src="https://lh3.googleusercontent.com/pw/ACtC-3fGjy3BTpbL7mhKdnmk0UyfmtyAbnP5Uy7Knf2pDFgTDmh0ToAWK8McvEsMNZN6olqFOBGtMDuxbejzGm4S9Pc_dArVwz8aiDIwT1f_cHKjEgZvg4nYmbsYWtaLnSfMNCvOok7rP_dWCuQSd10L7Xt7LQ=w1086-h854-no?authuser=0" style="zoom:50%;" />



연산을 할 수도 있는데, 위에서 가져온 현재 날짜에서 100 일 뒤의 날짜를 연산해보겠다.

~~~java
cal.add(cal.DATE, -100);
int year = cal.get(Calendar.YEAR);
int month = cal.get(Calendar.MONTH)+1;
int day = cal.get(Calendar.DAY_OF_MONTH);

String afterHundred = year+"년 "+month+"월 "+day+"일";
System.out.println("오늘로부터 100일 뒤는 "+afterHundred+"입니다.");
~~~

<img src="https://lh3.googleusercontent.com/pw/ACtC-3fsjQEVHR08buNbvm9Iuy-tnZ8e5XFLwDleRavsrmLrD_3i9X9QmZlnfkk66Oa52S5VCf8v7sh_t3Q_Xtl9dFaG8It-BuM8CeDeavtKk-3gnfV1xSd8ONgQ_mQKA4g106T417kI_3mIedW-SBdq7gi2ug=w1366-h604-no?authuser=0" style="zoom:50%;" />

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
/**
 * 보통 IDE에서 /* 입력하고 엔터만 치면 자동으로 완성이 된다. 
 * 위아래 기호 사이에 이렇게 작성하면 장문의 주석도 작성이 가능하다.
 * 그러나 주석은 장황하지 않게 깔끔하게 쓰도록 하자.
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

- [JAVA - String 객체간 비교](https://devyoungjin.github.io/2019/12/boolean-string/)

<br>

## <a name="identityHashCode"></a>객체 주소값 확인 ( identityHashCode( ) )

앞에서 산술연산자 ==와 `equals()` 함수를 통한 비교를 했는데, 객체 주소값을 직접 눈으로 보고싶다면(?) System 객체에 내장된 `identityHashCode()`를 이용하면 볼 수 있다.

![](https://lh3.googleusercontent.com/bAKOE9kOi5joQsKqOXh7s8ifHQAo0J3S_PzEBnegpxUTson5fVGwTCZ8PRgsw7jBYphPcMTFySDcvwjRAOaFXUhQKCchjS_P7edFuNQSXKB1cprtudSynLI5lvEqvlD8Zyemla3HxAbaQalT5znEK2Q5hpwrrNtL6Pcp4tF40jOjiXI6kUNEaNFvhJQp3_Oz72bATRaocohzkxw70JpX2IwmHMT7mt1YM9_txfYKxtD9KolPut2kGV9G5zrz7TqwrkZCTHkkZ9pMbXOthuxsl8qtFPtHndWNeDN5b3sDkGO6HHuc_YeLwnOn7i_5vhwQ_br8AcuHGxcWiYWEmJ4Ec5hhjoV_kgO1Z46PWG246XAkoIXxmRaye3fD9bXq8Yp_NHk8PoOtouj0h_cZSAJwNP36wB8FSi2XrUjnZXvZtA8xiA2iLXbQjydgWcBdFr5nlUzvmtHK3n2GpL_M3OVQwG_S3Vc7TJjzFIW92vAiIpel1z1hhOjC_u0dNu6aF35XqgOvrEw0-cX4oxMXLaIE_wCqkGRn5GROUH5qJFJBXgdkpGsiagz5xyn4hYlS8H1TNUW_80PY7L4Mr-lqFE5WGLCsQgOSPy-Xo8d2ZEqspBShqmLaYWp4kczl4DA10RCeai9WV06fxbKCuGl1dSEpBe8mAU2EQEW3I19A_3ghAfDUf9-5eA-6gRmiRALjXvdKjNd9otrN5lN-ebriqHEUbgn501YBbpP6fQnfU-GHYS_0fUrKEol4YFxh=w1372-h850-no)

<br>

## <a name="currentTimeMillis"></a>시스템 시간 불러오기 for 성능 테스트

프로그램의 성능을 테스트하는 방법 중 하나가 프로그램의 실행시간을 확인하는 방법이다. 실행시간을 파악하려면, 프로그램이 시작되기 전 시간과 프로그램이 종류한 직후의 시간을 가져와서 둘을 연산`(종료시간-시작시간)`하면 된다.

시간은 시스템에서 불러오는데, System 객체의 내장 메서드를 호출함으로써 시스템의 시간을 불러올 수 있다.

**System.currentTimeMillis( )**

~~~java
public class DevAndy {
   public static void main(String[] args){
      
      long startTime = System.currentTimeMillis();
     
      StringBuffer str = new StringBuffer();
      for(int i = 0; i<10000; i++){
         str.append("*");
      }
      System.out.println(str);
     
      long endTime = System.currentTimeMillis();
      System.out.println("실행시간 : "+(endTime-startTime));
   }
}
~~~

long 타입으로 각각의 변수에 시스템 시간을 대입하고 프로그램이 종료한 직후에 연산처리해서 최종적인 프로그램 실행시간을 파악할 수 있다.

<br>

## <a name="ternary"></a>삼항연산자

if 조건문보다 간단하게 한줄로 작성하는 조건식이다.

~~~java
(AAA) ? "변수 AAA가 true이면" : "변수 AAA가 false이면";
~~~

괄호 안의 boolean 값이 true이면, `?` 뒤의 로직이 실행되고, false이면, `:` 뒤의 로직이 실행되는 형식이다.

<img src="https://lh3.googleusercontent.com/9APBXoOZ24H51qRe9N5vEBbpyR289cOxwQ-9UxyI2pR2ppu_nEXIg68FxP6eipr1_K3IT_a0GD1yz-MLu4a3cPe2-N6vXYk8w129pwSGnXXC70yLbtxJRQvy0nPnze4MqAah_TNifPqMENXFlArPeeiWII9mA9918mm1ww2g-xqiF3PCg2OMuI0-Pz0B3HooPhCoya91f6OJ-jhS8Q2cHET-1MXpa759Vqy9Fbb4O4O92cK8YXb2LNm-jtiJicQJcGq_yG21pjmtgdaJZRVkRhq7zFF97BFx-sVwsaWyvKHrEJytKxKARnuhlvTV11tJIB2JCF_1FyIvFEMXI-IoNZnGCKqPwp1M45vrn0yHyyZ-9EUz4VLVvoxHfu_xMwBfv-TNrNQL1UNK2NrIPh04z7aLkohWyX-xnURLLJi4s7KGSkZfUI-YciVgfWRW6MaMQQdln1L64_reb1yAED4ijWONRjrDm8pZOoidAYiXfbdBolZ8X8ol6GudEGRITLgDbUo5Eq3SECyUMvOIIc5IDtvvIUTRPV3TFPqtWj-XHrcqrZ85T480WPt4aaKZM27q09W7fn_29TwblUOew9nr3wBc2LC6EmcsUBqgl8HGm-5wSjXi2m6ISp8RiWrgZWx6VmcbNqeXctc4cUsZ9aQ2JAtJZRlOLxg48fYggdPqMuK-Bn9CDYynw67IpraeE8cSRN1uPQYKyIfAT0zkeC0C5wwIHFccuqJAXxPpODeHAVNg21zZPseSGkQr=w1060-h480-no" style="width: 80%;" />

<br>

## <a name="swtich"></a>switch문

switch문은 괄호안에 결과가 어떤 값을 갖느냐에 따라 서로 다른 로직을 실행할 수 있는 제어문이다.

~~~java
switch(aaa) {
  case 1:
    // 실행
    break;
  case 2:
    // 실행
    break;
  default:
    // 실행
    break;
}
~~~

aaa가 1을 가질때 특정 로직이 실행되고, break된다. 만약 case 에 break가 작성되어 있지 않으면, 다음 case 문이 자동으로 실행된다. 따라서 복수의 case문(multiple)에 따라 하나의 로직을 실행하고자 한다면 이 때 break을 선별적으로 작성해야 한다.

int형 값 month에 따라서 season값을 선택하는 switch문을 작성해보았다. (출처 : [프로그래머스](https://programmers.co.kr/learn/courses/5))

~~~
month가 12월-2월일 경우 : season = "겨울"
month가 3월-5월일 경우 : season = "봄"
month가 6월-8월일 경우 : season = "여름"
month가 9월-11월일 경우 : season = "가을"
~~~

~~~java
int month = Calendar.getInstance().get(Calendar.MONTH)+1;
String season = "";
switch(month){
  case 12:
  case 1:
  case 2:
    season = "겨울";
    break;
  case 3:
  case 4:
  case 5:
    season = "봄";
    break;
  case 6:
  case 7:
  case 8:
    season = "여름";
    break;
  case 9:
  case 10:
  case 11:
    season = "가을";
    break;
}
~~~

break을 어디에 작성하느냐에 따라 multiple 선택도 가능함을 알 수 있다.

<br>

## <a name="for-loop"></a>for문

while문과 함께 자바에서 사용하는 반복문이다. 

~~~java
for(int i = 0; i < args.length; i++){
   // iterator 변수 i가 돌 때마다 반복될 코드
}
~~~

일반적인 방식의 for문이며, 3가지 조건이 들어간다. iteraotr의 시작 포인트, 반복을 마치는 포인트, 반복조건. 위의 코드는 iterator 변수 i가 0부터 인자(args)의 길이만큼 반복되며, 반복조건은 i++로 선언한 for문이다. 

1부터 10을 더해서 결과를 출력하는 프로그램 코드이다.

~~~java
public class DevAndy {
   public static void main(String[] args){
      int result = 0;
     	
      for(int i=1; i<=10; i++) {
         result += i;
         System.out.println(i+" : "+result);
      }
     
      System.out.println("총합 : "+result);
   }
}
~~~

<img src="https://lh3.googleusercontent.com/pw/ACtC-3djhvWjcLN_Oqhh9Ai-59qqDOB0lfwI-dcbg6IDMVp_kTvOAfXFWd-92RXxt__x2Q8X6W4-2bcNkYPD6Oy44DQTBugEy0ZezLS1KzchaN3-GA5aTeTNFX3HT74Lgh0ubBxeFhHmoGb31X0yoQJj7k073w=w463-h624-no?authuser=0" style="zoom:50%;" />

<br>

## <a name="for-each"></a>for each문

일반적으로 배열을 받는 for문은 아래처럼 작성할 수 있다.

1부터 10까지 들어가있는 크기 10의 int형 배열 nums를 선언했다.
nums와 크기가 똑같은 새로운 int형 배열 newArr을 선언했다.
for문으로 nums에 있는 값에 2를 곱해서 newArr에 값으로 추가했다.
그리고 Arrays 객체의 `toString()`을 사용하여 출력했다.

~~~java
import java.util.Arrays;

public class DevAndy {
   public static void main(String[] args) {
      int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
      
      int[] newArr = new int[nums.length];
	  
      for(int i=0; i<nums.length; i++) {
         newArr[i] = nums[i]*2;
      }
     
      System.out.println(Arrays.toString(newArr));
   }
}
~~~

<img src="https://lh3.googleusercontent.com/pw/ACtC-3fwT2lcpmOz7AI6nZoxHA0je5piINwQA-sbF7966RnJKuXD1oA7t9n7Gz6PnjcMUzOY4mE8eLoh-EduYkGzuJAIYssbP_uSenZwkisRjKZuX3EAn2ZQ4Hih75J7d7tMzWF58ik83xPASCEaG3CQaTAN9w=w784-h262-no?authuser=0" style="zoom:50%;" />

위의 코드처럼 배열을 받아서 다른 배열에 값을 부여할 땐 for each문을 사용해서 아래의 형식의 보다 단순한 조건절을 사용할 수 있다.

~~~java
for(int i : arr){
   // iterator 변수 i가 반복될때마다 작동할 코드
}
~~~

배열 arr의 0번째 element부터 마지막  element까지 자동으로 iterator의 반복구간이 자동으로 설정된다. for each문을 적용해서 코드를 수정해보았다.

~~~java
import java.util.Arrays;

public class DevAndy {
   public static void main(String[] args) {
      int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
      
      int[] newArr = new int[nums.length];
	  
      for(int i : nums) {
         newArr[i] = nums[i]*2;
      }
     
      System.out.println(Arrays.toString(newArr));
   }
}
~~~

결과는 똑같다.

<br>

## <a name="enumeration"></a>Enumeration 인터페이스

[Enumeration](https://docs.oracle.com/javase/7/docs/api/java/util/Enumeration.html) 인터페이스는 Java 8에서 Iterator 인터페이스가 추가되기 전까지 사용하던 것이라고 한다. Enumeration 인터페이스는 배열의 각 element들을 한 순간에 하나씩 처리할 수 있는 메서드를 제공하는 컬렉션이다. 

### Enumeration 인터페이스의 주요 메서드

- **hasMoreElements()** : boolean
  - element가 더 남아있는지 boolean 값을 반환한다.
- **nextElement()** : E
  - 다음 element를 열거형(E)으로 반환한다.

Java 1.2부터 Enumeration을 대체할 수 있는 [Iterator](#iterator) 인터페이스가 추가되었다. [오라클 공식문서](https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html)에서는 아래와 같은 이유로 Enumeration 인터페이스 대신 Iterator 인터페이스를 쓰라고 권하고 있다.

> NOTE : The functionality of this interface is duplicated byu the Iterator interface. In addition, Iterator adds an optional remove operation, and has shorter method names. New implementatinos should consider using iterator in preference to Enumeration.

<br>

## <a name="iterator"></a> Iterator 인터페이스

[Iterator](https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html) 인터페이스는 [컬렉션 프레임워크](#collection-frameworks")에서 사용하는 인터페이스이다. [Enumeration](#enumeration) 인터페이스와 비슷하지만, `remove()`가 존재한다는 점에서 다른 특징이 존재한다.

### Iterator 인터페이스의 주요 메서드

- **hasNext()** : boolean
  - 다음에 처리할 element가 남아있는 boolean 값을 반환한다.
- **next()** : E
  - 다음 element를 열거형(E)로 반환한다.
- **remove()** : void
  - element를 삭제한다.

<br>

## <a name="collection-frameworks"></a>컬렉션 프레임워크

## <a name="collection-set">Set</a>

Set 인터페이스는 Collection 인터페이스를 상속받는 자료구조 인터페이스이다.

~~~java
public interface Set<E> extends Collection<E>
~~~

**중복이 없고, 순서도 없는** 자료구조 인터페이스이다.

Set 인터페이스에서 사용할 수 있는 클래스로는 [HashSet](https://docs.oracle.com/javase/8/docs/api/java/util/HashSet.html)과 [TreeSet](https://docs.oracle.com/javase/8/docs/api/java/util/TreeSet.html)이 있다.

Set은 값을 추가할때 `add()`를 이용하며, 반대로 값을 꺼낼때는(조회) [Iterator](#iterator)라는 인터페이스를 사용해야 한다.

아래 코드는 String 문자열의 `Set`을 만들어서 문자열 데이터를 삽입하고, `Interator`를 사용하여 콘솔에 출력하는 코드이다.

~~~java
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class setExam {
   public static void main(String[] args) {
      Set<String> set = new HashSet<>();
      boolean flag1 = set.add("hello");
      boolean flag2 = set.add("world");
      boolean flag3 = set.add("kami");
      boolean flag4 = set.add("kami");
		
      System.out.println(set.size());
     
      Iterator<String> iter = set.iterator();
     
      while(iter.hasNext()){
         System.out.println(iter.next());
      }
     
     iter.remove();
     System.out.println(set.size());
   }
}
~~~

<img src="https://lh3.googleusercontent.com/pw/ACtC-3eHy7MRRK5cZa58b9LPi3lDnhKflxOZyJNFScfYQd8edrO1nLyqpie-4je8GHrhAqHV-psKp9daZYHCN-6JecvK5rmu-YJybANvMMLw4LNC85MkXDeijMse38MXIN7hdbDBxezYgnkfdNVb-LTHXStmmQ=w646-h392-no?authuser=0" style="zoom:50%;" />

Set은 중복을 허용하지 않기 때문에 set.add("kami")를 두번 했음에도 불구하고, set에는 한번만 들어간걸 확인할 수 있다.

그리고 hello, world, kami 순으로 add하였지만, 출력시엔 그 반대로 kami, world, hello로 출력되는걸로 보아 **Set 인터페이스는 FILO(First In Last Out)의 Stack 형태의 자료구조**로 추정된다.

추가로 컬렉션 프레임워크(Set, List, Map)에서는 `size()` 로 길이를 반환받을 수 있다.

<br>

## <a name="collection-list">List</a>

List도 Set과 마찬가지로 Collection을 상속받는 자료구조 인터페이스이다. 

~~~java
public interface List<E> extends Collection<E>
~~~

List는 Array와 비슷한 자료구조 인터페이스이다. Array와 다른게 있다면, immutable하다는 특징이 있다는 것이다. Array는 선언시 지정한 크기를 벗어날 수 없지만, **List는 필요에 따라 크기가 유연하다**는 특징이 있다.

List에서 자주 사용되는 클래스로는 [ArrayList](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html)와 [LinkedList](https://docs.oracle.com/javase/8/docs/api/java/util/LinkedList.html)가 있다.

Set과 비교하면, Set은 중복을 허용하지 않는 인터페이스였다면, **List는 중복을 허용**하는 인터페이스이다.

List는 `add()`로 값을 추가하고, 값을 꺼낼때는 `get()`을 이용해서 꺼낸다. 

~~~java
import java.util.ArrayList;
import java.util.List;

public class ListExam {
   public static void main(String[] args) {
      List<String> list = new ArrayList<String>();
		
      list.add("devandy");
      list.add("devandy");
      list.add("devandy");
      list.add("hello");
      list.add("world");
		
      System.out.println(list.size());
      for (int i = 0; i < list.size(); i++) {
         System.out.println(list.get(i));
      } 
		
      list.remove(list.size()-1);
     
      System.out.println("\n"+list.size());
      for (int j = 0; j < list.size(); j++) {
         System.out.println(list.get(j));
      }
   }
}
~~~

<img src="https://lh3.googleusercontent.com/pw/ACtC-3fqk7NyYKRgao7IqD22tCFsg_5gFpvGY9VlnWE-uC3Q5VvEd20jDXBfM5hsb9nYwuCs2fQkw0kKMIsMLdDKb8v64I-_33FoT6zpt-b0HVkrP3I-u8_X8cFqof6aDdAIfxXc3U4t-rrLVhU8UeOQg-OGLA=w626-h686-no?authuser=0" style="zoom:50%;" />

<br>

## <a name="collection-map">Map</a>

다른 콜렉션 프레임워크와 달리 key와 value이 한 쌍(`key : value`)으로 저장되는 인터페이스이다. 

기본적으로 Map 인터페이스는 중복을 허용하지 않는다. 그러나 서로 다른 key를 가졌다면, value를 중복될수도 있다. 아래의 상황이 그 예이다.

~~~java
map.put("andy",20);
map.put("bob",30);
map.put("chris",20);
map.put("chris",10); // 컴파일시 문제는 없지만, 값이 추가되지 않음. key는 중복될 수 없다.
~~~

자주 사용하는 클래스는 [HashMap](https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html), [HashTable](https://docs.oracle.com/javase/8/docs/api/java/util/Hashtable.html), [TreeMap](https://docs.oracle.com/javase/8/docs/api/java/util/TreeMap.html)이 있다.

~~~java
public interface Map<K,V>
~~~

토트넘 선수단을 Map 인터페이스를 사용하여 저장하려고 한다. 선수 번호가 key, 선수 이름이 value로 지정했다.

`put()`으로 추가하고, `remove()`로 삭제하고, `get(key)`로 조회했다.

~~~java
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class mapExam {
   public static void main(String[] args) {
      Map<Integer, String> tot = new HashMap<Integer, String>();
     
      tot.put(1, "Hugo Lloris");
      tot.put(3 , "Dnnay Rose");
      tot.put(5 , "Jan Vertonghen");
      tot.put(7 , "Heong-min Song");
      tot.put(10 , "Harray Kane");
      tot.put(27, "Lucas Moura");
     
      tot.remove(10);
     
      Iterator<Integer> keys = tot.keySet().iterator();
      
      while(keys.hasNext()){
         int key = keys.next();
         System.out.println(key+" : "+tot.get(key));
      }
   }
}
~~~

<img src="https://lh3.googleusercontent.com/pw/ACtC-3ehgE6cmFJucOH0_CtOr6o3ZNskwP6sbF9xLElZa_vyLtDen7KOMRb9vUgDGpfHbntuEGiJtMM81mc-6UZqnVz1OF36Teurtv8ClE_zivob5Tnhr31NEg55BwH4vYw3GYxfr1dirskgq_UyIqyC0TMjLg=w609-h414-no?authuser=0" style="zoom:50%;" />

Map에 속한 자료구조 데이터는 Iterator 클래스를 사용해서 모든 element를 꺼낼 수 있다.

<br>

## <a name="lombok"></a>Lombok

자바에서 Model을 만들때, 멤버필드에 대한 Getter/Setter, toString과 멤버필드에 주입하는 생성자를 만드는 코드등 반복적으로 작성하게 되는 코드를 어노테이션으로 줄여주는 라이브러리이다.

Maven/Gradle로 프로젝트를 진행하는 경우, Mvn Repository에서 Dependency를 추가할 수 있다.

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

### <a name="javabean-why-create-interface"></a>왜 java.io.serializable 인터페이스 구현?

[JavaBean의 목적](#rule-and-why)은 여러가지 객체들을 하나의 객체에 담기 위함이라고 했는데, 담아서 무엇을 하려는걸까. 메모리에 존재하는 오브젝트를 네트워크를 통해 전송하거나 파일에 저장하려면 `data stream`(e.g. `byte[]`)으로 이 오브젝트를 변환시켜줘야한다. 이 변환 작업을 Serialization이라고 부른다. JavaBean을 저장하거나 전송하는 일이 많기 때문에, Serializable가 스탠다드에 포함되는것으로 추정.

<br>

### <a name="create-javabean"></a>Bean 생성하는 법

어노테이션을 이용해서 자바 빈을 생성할 수 있다.

자바 빈에 사용되는 어노테이션은 다음과 같다.

```java
@Configuration
@Bean
```



실제로 자바 빈을 생성하는 코드를 보자.

**ApplicationConfg.java**

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



**Player.java**

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



**Main.java**

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