# SQL

- [데이터베이스 개요](#overview)
- [데이터베이스의 장단점](#prosncons)
  - [장점](#pros)
  - [단점](#cons)
- [데이터베이스 관련 용어](#term)
  - [DDL](#ddl)
  - [DML](#dml)
  - [DCL](#dcl)
  - [DBMS](#dbms)
  - [RDBMS](#rdbms)

- [정렬하여 조회하기 (이름순으로 조회시, 동명이면 생일순)](#select-order)
- [데이터 출력 수 결정하기 (LIMIT)](#limit)
- [중복제거 조회 (DISTINCT)](#distinct)
- [연산처리](#sql-math)

<br>

## <a name="overview"></a>데이터베이스 개요

데이터베이스는 여러 사람이 공유하고 사용할 목적으로 통합 관리되는 정보의 집합이다. 복수의 데이터를 조직적으로 통합하고 중복을 없애거나 데이터를 구조화하여 기억시켜 놓은 자료의 집합체이다.

데이터베이스 자체만으로는 아무것도 할 수 없으며, 이를 활용할 수 있도록 돕는 데이터베이스 관리 시스템(DBMS, DataBase Management System)이 필요하다.

>데이터베이스 자체는 화물(데이터)을 저장할 수 있는 창고 그 자체의 역할만 수행하고, 화물을 적재하거나 적재된 화물을 처리할 수  있는 능력은 없다. 이 때문에 DBMS라는 관리자들을 고용하여 화물을 적재하거나 이동시키는 등 여러가지 업무를 수행하도록 하는  것이다. - 나무위키 -



관계형 데이터베이스를 위해 만들어진 언어가 **Structured Query Langue, SQL**이라고 한다. SQL를 통해 데이터를 추가/탐색/수정/삭제 할 수 있다.

<br>

## <a name="prosncons"></a>데이터베이스의 장단점

### 장점<a name="pros"></a>

- 데이터 중복 최소화
- 데이터 공유
- 일관성, 무결성, 보안성 유지
- 최신의 데이터 유지
- 데이터의 표준화 기능
- 데이터의 논리적, 물리적 독립성
- 데이터 저장 공간 절약



### 단점<a name="cons"></a>

- 데이터베이스 전문가 필요
- 비용 부담
- 데이터 백업과 복구가 어렵다 그러나 최근엔 많이 개선됨
- 시스템의 복잡함
- 대용량 디스크로 액세스가 집중되면 과부화 발생

<br>

## <a name="term"></a>데이터베이스 관련 용어

- [DDL](#ddl)
- [DML](#dml)
- [DCL](#dcl)
- [DBMS](#dbms)
- [RDBMS](#rdbms)

<br>

### DDL <a name="ddl"/>

Data Definition Language

데이터를 정의하는 언어이다.

테이블을 생성하거나 삭제 등 **데이터베이스 스키마(Scheme)를 정의또는 관리**하는 언어이다.

- **CREATE** : 정의
- **ALTER** : 수정
- **DROP** : 삭제
- **TRUNCATE** : DROP 후, CREATE

<br>

### DML<a name="dml"/>

Data Manipulation Language

테이블 등의 **데이터를 조작(추가/조회/수정/삭제)**하는 언어이다. 응용 프로그램과 데이터베이스 사이에서 실질적인 데이터 처리를 위해 사용된다.

- **INSERT** : 추가
- **SELECT** : 조회
- **UPDATE** : 수정
- **DELETE** : 삭제

---

연관 포스트 : [Oracle - DML 명령어](https://youngjinmo.github.io/2019/06/oracle-dml/)

<br>

### DCL<a name="dcl"/>

Data Control Language

**<u>데이터를 제어</u>**하는 언어이다.

사용자 권한, 작업의 취소 등 DML과 비교하여 상위 개념(?)의 언어라고 생각한다.

- **COMMIT** : 작업 결과 반영
- **ROLLBACK** : 트랜잭션의 작업을 취소 / 복구(undo)
- **GRANT** : 사용자에게 권한 부여
- **REVOKE** : 권한 취소

<br>

### DBMS<a name="dbms"/>

데이터베이스 그 자체로는 아무것도 할 수 없다. 데이터베이스를 사용하기 위해서는 관리 시스템이 필요하다고 했는데, 그 역할을 하는 소프트웨어를 DBMS라 한다. Oracle, MySQL, MS-SQL등이 여기에 속한다.

- DataBase Management System
- 데이터베이스를 관리하는 소프트웨어
- Oracle, MS-SQL,MySQL 등이 DBMS에 속한다.

<br>

### RDBMS<a name="rdbms"/>

가장 많이 사용되는 데이터베이스 모델. 관계있는 데이터끼리 구조적으로 집합해놓은 데이터여서 관계형 데이터베이스(Relational Database Management System)라고 한다. 간단히 RDBMS라고 한다.

<div align="center">
  <img src="http://www.mediafire.com/convkey/6642/w6yet8v1ozydrmxzg.jpg" width="450px"/>
</div>


| SQL    | RDBMS         | Description                      |
| ------ | ------------- | -------------------------------- |
| Row    | Tuplr, Record | 하나의 항목을 대표하는 데이터    |
| Column | Attribute     | 튜플의 이름 요소                 |
| Table  | Relation      | 같은 속성을 공유하는 튜플의 모임 |

<br>

### <a name="select-order"></a>정렬하여 조회하기 (이름순으로 조회시, 동명이면 생일순)

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

### <a name="limit"></a>데이터 조회 수 결정하기 (LIMIT)

조회하는 데이터의 갯수를 결정할 때 사용하는 쿼리이다.

```SQL
SELECT NAME
FROM ANIMAL_INS
ORDER BY DATATIME ASC
LIMIT 1;
```

날짜(`DATETIME`)순으로 정렬했을 때, 데이터를 하나만 조회하는 쿼리이다. 즉 가장 최신 데이터를 조회한 것이다. `LIMIT`을 활용하면 최대값, 최소값도 구할 수 있다.

<br>

### <a name="distinct"></a>중복제거 조회하기 (DISTINCT)

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