# JPA

Hibernate를 알기 앞서 JPA와 ORM에 대해 정리하려고 한다.

<b>JPA(Java Persistent API)</b>는 자바 진영의 ORM 기술 표준 명세라고 한다.

<b>ORM(Object Relational Mapping)</b>은 객체 관계형 매핑을 돕는데, 객체를 DB 테이블이 되도록 매핑시켜주는 것을 의미한다.

객체는 객체대로 설계를 하고, 관계형 데이터베이스는 DB대로 설계하면 ORM 프레임워크가 중간에서 매핑하는 구조이다.

<a name="structure-of-jpa"></a><img src="http://www.mediafire.com/convkey/76fe/4uc9nqw8rls40b7zg.jpg" />

Java 애플리케이션에서 DB를 통신하려면 JDBC API를 사용해야하는데, JPA가 중간에 개입하는 구조이다. JPA는 Java 애플리케이션의 DAO 영역에서 전달받은 객체를 분석해서 SQL을 생성하고, JDBC API를 사용해서 쿼리를 DB에 전송하는 역할을 한다.

*객체를 자바 컬렉션에 저장하듯이 DB에 객체를 저장할수는 없을까?*

JPA 탄생 이전까지는 데이터 중심의 모델링을 우선시 했다고 한다. 객체지향의 특징보다는 단순히 데이터의 전달 목적으로 객체(VO, DTO)를 사용했다고 한다. 그러나 이는 심각한 비효율을 발생시켰다. 객체에 데이터를 추가할 때 반복적인 CRUD 작업을 해야했기 때문이다.  **ORM은 SQL 쿼리 대신 코드로 데이터를 조작함으로써 개발자 입장에서 생산성을 높힐 수 있는 도구**이다.

예를들면, `SELECT * FROM users;` 라는 SQL 쿼리를 `users.findAll()` 로 대체할 수 있는 것이다. 이렇게 하면 중복을 제거할 수 있으며, 객체지향의 장점을 살려 데이터를 제어할 수 있다.

- [Hibernate](#hibernate)

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