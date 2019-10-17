# TIL

*Today's I learned.*

오늘 제가 배운 내용을 정리하는 공간입니다.

<Br>

## ToC

- [Language](#language)
  - [Java](#)
- [Backend](#backend)
  - [Template Engines](#template-engines)
    - [Mustache](#mustache)
  - [JPA](#jpa)
    - [Hibernate](#hibernate)
- [Git](#git)
- [DevOps](#devops)
- [Others](#others)

<br>

<a name="java"></a>

<img src="https://cdn.vox-cdn.com/thumbor/FDD76YJZJFPyNUfT3ZBHcnMA0Ec=/43x0:593x367/1200x800/filters:focal(43x0:593x367)/cdn.vox-cdn.com/uploads/chorus_image/image/48667835/dbgxt2rvpd26udoyzcqn.0.0.jpg" width="400" />

## Wrapper Class

기본형 데이터타입의 객체화를 가능하게 도와주는 클래스. `java.lang` 패키지 안에 포함되어있다.

- 기본형 타입 : `int`
- 객체형 타입 : `Integer`



Wrapper Class는 다음과 같은 기능을 수행한다.

<img src="http://www.mediafire.com/convkey/f9f7/mifo8skczv2pdhpzg.jpg" style="zoom:50%;" />

**오토 박싱 (Auto Boxing)**

기본 타입 데이터를 객체 타입의 데이터로 자동 형변환해주는 기능

**오토 언박싱 (Auto Unboxing)**

오토박싱과 반대로 객체 타입의 데이터를 기본형 타입 데이터로 자동 형변환



### References

- [프로그래머스 - [자바 중급] java.lang 패키지/오토박싱](https://youtu.be/Eofo8_xZbfk)

<br>

## <a name="mustache"></a>Mustache

[템플릿 엔진](https://en.wikipedia.org/wiki/Web_template_system)이란, 데이터 모델에 따른 문서를 합성하여 웹 문서를 만들어주는 소프트웨어라고 한다.

JSP도 있고, Spring Boot에서는 Thymeleaf를 미는것도 같은데 왜 Mustache를 알아야 할까.

우선 JSP는 오래된 기술이다. 오래되었다는 이유만으로 배척할 필요는 없으나 향후 지원이 안될 가능성이 높기 때문에 실무에서 가장 많이 쓰이고 있거나 앞으로 많이 쓰일 소프트웨어를 배울 필요가 있다고 생각했다.

Thymeleaf는 잘 모르지만, 느리다는 성능 상의 이슈가 있는 편이다.

**Mustache는 템플릿 엔진중 가장 많은 언어를 지원한다.** [위키](https://en.wikipedia.org/wiki/Web_template_system#Server-side_systems)를 열어보면, C++, 커피스크립트, Go, 자바, .NET, PHP, Pyhton중 내가 아는 프로그래밍언어는 거의 다 지원되는듯하다.

또 Mustache는 [심플한 문법](https://mustache.github.io/mustache.5.html)을 갖고 있다고 한다. 이 부분은 직접 경험해야 알 수 있을 것 같다.

일단 대략적으로 이정도만 알고 있는데, 향후 써보면서 계속 업데이트 해보겠다.

<br>

## <a name="jpa"></a>JPA

Hibernate를 알기 앞서 JPA와 ORM에 대해 정리하려고 한다.

**JPA(Java Persistent API)**는 자바 진영의 ORM 기술 표준 명세라고 한다.

**ORM(Object Relational Mapping)**은 객체 관계형 매핑을 돕는데, 객체를 DB 테이블이 되도록 매핑시켜주는 것을 의미한다.

객체는 객체대로 설계를 하고, 관계형 데이터베이스는 DB대로 설계하면 ORM 프레임워크가 중간에서 매핑하는 구조이다.

<a name="structure-of-jpa"></a><img src="http://www.mediafire.com/convkey/de04/v69h3y5lvm18jqtzg.jpg" style="zoom:60%;" />

Java 애플리케이션에서 DB를 통신하려면 JDBC API를 사용해야하는데, JPA가 중간에 개입하는 구조이다. JPA는 Java 애플리케이션의 DAO 영역에서 전달받은 객체를 분석해서 SQL을 생성하고, JDBC API를 사용해서 쿼리를 DB에 전송하는 역할을 한다.

*객체를 자바 컬렉션에 저장하듯이 DB에 객체를 저장할수는 없을까?*

JPA 탄생 이전까지는 데이터 중심의 모델링을 우선시 했다고 한다. 객체지향의 특징보다는 단순히 데이터의 전달 목적으로 객체(VO, DTO)를 사용했다고 한다. 그러나 이는 심각한 비효율을 발생시켰다. 객체에 데이터를 추가할 때 반복적인 CRUD 작업을 해야했기 때문이다.  **ORM은 SQL 쿼리 대신 코드로 데이터를 조작함으로써 개발자 입장에서 생산성을 높힐 수 있는 도구**이다.

예를들면, `SELECT * FROM users;` 라는 SQL 쿼리를 `users.findAll()` 로 대체할 수 있는 것이다. 이렇게 하면 중복을 제거할 수 있으며, 객체지향의 장점을 살려 데이터를 제어할 수 있다.

<br>

**References**

- [김영한 - JPA 소개](https://youtu.be/U2s2JhzPZf4)

<br>

## <a name="hibernate"></a>Hibernate

EJB(Entity Java Beans)이 있었는데, 이게 너무 불편하고 성능이 떨어지는 단점이 있었다. 그런데 이를 답답해 여긴 어느 한 개발자가 이를 대체할 수 있는 Hibernate를 개발해서 오픈소스로 공개했다. 이후 자바 진영에서 새로운 표준을 개정하면서 Hibernate 개발자를 모셔가서 [JPA](#jpa)가 개발되었다고 한다.

Hibernate는 JPA를 구현한 프레임워크이다. 국내에선 Hibernate보다 [MyBatis](https://sjh836.tistory.com/127)를 더 많이 사용하고 있으나 한국, 일본, 중국을 제외한 전 세계에서 Hibernate를 더 많이 사용한다고 한다.

<br>**Hibernate의 장점**

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

**References**

- [victolee93 - [Spring JPA] ORM과 JPA 그리고 Hibernate](https://victorydntmd.tistory.com/195)

<br>