# Oracle RDBMS

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
- [오라클 버전 확인하기](#v-version)
- [오라클 DB 계정 생성하고 전환하기](#create-account)
- [오라클 DB 계정 삭제하기](#drop-account)
- [현재 계정 조회하기](#select-current-user)
- [오라클 계정, 시스템권한, 롤 확인하기](#dba_users-grant-role)
   - [ 오라클 계정, 시스템권한, 롤 확인하기](#select-dba-users)
   - [계정에 부여된 시스템 권한 확인](#select-dba-sys-privs)
   - [계정에 부여된 롤 확인](#select-dba-role-privs)
- [오라클 포트 확인하기](#dbms-xdb-gethttpport)
- [오라클 포트 변경하기](#dbms-xdb-sethttpport)
- [테이블 생성하기](#create-table)
- [테이블 삭제하기](#drop-table)
- [테이블은 남기고 데이터만 삭제하기](#truncate-table)
- [테이블 컬럼명 변경하기](#alter-table-rename)
- [테이블 컬럼 타입 변경하기](#alter-table-modify)
- [DESC](#desc)
- [오라클에서 전체 테이블 조회하기](#show-all-tables)
- [SELECT](#select)
- [SELECT *](#select-all)
- [WHERE](#where)
- [ORDER BY (중복시 2번째 조건으로 정렬)](#select-order)
- [ROWNUM](#rownum)
- [DISTINCT](#distinct)
- [연산처리](#operation)
- [숫자 함수]()
  - [abs](#abs)
  - [floor](#floor)
  - [round](#round)
  - [trunc](#trunc)
  - [mod](#mod)
- [문자열 함수]()
  - [lower](#lower)
  - [upper](#upper)
  - [initcap](#initcap)
  - [concat](#concat)
  - [length](#length)
  - [substr](#substr)
  - [instr](#instr)
  - [lpad, rpad](#lpad-rpad)
  - [trim](#trim)
  - [replace](#replace)
- [NUL - NVL](#null-nvl)
- [IS NULL](#is-null)
- [WHERE - BETWEEN](#where-between)
- [WHERE - IN](#where-in)
- [DECODE](#decode)
- [CASE](#case)
- [GROUP BY](#group-by)
- [HAVING](#having)
- [OVER](#over)
- [RANK](#rank)
- [JOIN](#join)
  - [Self Join](#self-join)
  - [Outer Join](#outer-join)
- [서브쿼리](#subquery)
  - [IN](#in)
  - [ALL](#all)
  - [ANY, SOME](#any-some)
- [SET](#set)
  - [UNION](#union)
  - [UNION ALL](#union-all)
  - [INTERSECT](#intersect)
  - [MINUS](#minus)
- [INSERT](#insert)
- [DBMS_XPLAN.DISPLAY_CURSOR](#dbms-xplan-display-cursor)

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

테이블 등의 **데이터를 조작(추가/조회/수정/삭제)** 하는 언어이다. 응용 프로그램과 데이터베이스 사이에서 실질적인 데이터 처리를 위해 사용된다.

- **INSERT** : 추가
- **SELECT** : 조회
- **UPDATE** : 수정
- **DELETE** : 삭제

---

연관 포스트 : [Oracle - DML 명령어](https://youngjinmo.github.io/2019/06/oracle-dml/)

<br>

### DCL<a name="dcl"/>

Data Control Language

**데이터를 제어**하는 언어이다.

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
| Row    | Tuple, Record | 하나의 항목을 대표하는 데이터    |
| Column | Attribute     | 튜플의 이름 요소                 |
| Table  | Relation      | 같은 속성을 공유하는 튜플의 모임 |

<br>

## <a name="v-version"></a>오라클 버전 확인하기

~~~bash
SELECT *
FROM v$version
~~~

![](https://user-images.githubusercontent.com/33862991/95680590-cbebb200-0c15-11eb-81ec-a459ee92d352.png)

<br>

## <a name="create-account"></a> 오라클 DB 계정 생성하고 전환하기

오라클 데이터베이스에서 계정을 추가하는 방법이다.

~~~sql
CREATE user 'ACCOUNT' identifiedby 'PASSWORD';
~~~

이제 생성한 계정으로 전환해보겠다.

~~~sql
GRANT connect, resource, dba to 'ACCOUNT';
~~~

실행결과이다.

![](https://lh3.googleusercontent.com/m6cIY2lMLwQVBB6hnIDVxA4Z61EyWMGmPrEa45rIaMZZp50jnnyjTT2EEQJw_tv9DSh95bSyF7whYKPDI7cWCdiiwidGePalVPMIkzvmtXKD_QMU4pPz52U9ZOhKZvkEfmj-9cO0GbQ7kbv0INVYbk9dBGqdD3cyHd7wLBVdOPrrjzXKiJK8LJEfdPyGkrxggOaUw50Ckc1wi43uF2cFybZR25bijC3Z4KinR6tzXc01OC5Yd3hgpEL0_g4HUH8YHa51zDyP5aTGcRTfcLtmS0LyWe6rdxeOgI8WL2zqQBJOyI0ln0vEVU_FgOptS7HKathN2cElVpj5X54zFgqOtd0LqdLRGU7thACfrWDDu1LzR9XJaJ0BomEnDvKAaj1YmCUF-ss-BCYKfhZY_HN9E7TkyIloVBx1JAsNIIqDkMPnksdhIAreXVYNCTpUSbDGDjG0HB1xL34t73BjEuR2hy2ahzCT2oVb36oMIeyQ4ErDrHWwAk4hqah8CZTfBY1Zj4fzQ4-ix56jSku7zcdecBL3eMYDFjFCAtv4zLTkTG5-m0mhxmFJKJ9ICLhvyvbwu1nA_O56jsDrHPxYrAqFtDaWjJ6qdih_opZekOd_UoqkYQNXOQ9yH39tKD29r7n777VGrOlADLgWw9yPTXiEAGhcFSEsTLoeimYgNy6XODoWrrocCvS9u6vkczkm-ljCo5DCifBj1wIzFrKg0PJ61R0F3qWrRzmA-xPP8-4OhLsn6o7eFw=w1218-h338-no)

<br>

## <a name="drop-account"></a>오라클 DB 계정 삭제하기

~~~sql
DROP user 'ACCOUNT' cascade;
~~~

실행결과이다.

![](https://lh3.googleusercontent.com/ay0bsQUMdwRwN1g6scMjQ1dVQSYQnjpNA4bF-eWxYUlSEsvblrBdogKs4Kwv3__wRuDpPiPSnsTdAK5Hr3bb6aq56BY_YhdICgeYRwo87N5OmgWUWgZbL4GzXgsoPJiv6X86JpXnxm-5Dwoa84vRIe8RwPEOgactU_tMJVlkyT6cwlf6DbgzWsIBeMALJaWXLjTvaXcYF143eYTiCtvbSwdg6izBDTd_26OWdEAo_u_DJ2CWr7Nu4v5RL3IFW5kzrDpJlxOxhC5Bda0kA8fSi27HyHn-CXwhRaHhT8YgA52MALwT-jOb40Z2bmv0WvDS4-beU2KDn8uSoVnmBWTG3JxVpAj_JK_LIYHUnXzPZ6em6FPSxUB3MHM6oc-E2JbedNqcY56CS1A4C_4sVP_FTbfoQOWL3yBnLIovh41iaEQkaFCXmKjzmo4G5Tx7wVNuWetPi5Bf0T5G55WPBRDpiNGKp6vz_kRUbtBPRiZ9KJw0ziaFM-kyrkav_loLMNpqYWo1rIeiuyYnFWJWyWUMIYX8EKz5-8ohdj2tBxWuykjJedAGkal_fuqbwH_1H-iiVJfqwhRH2wi3MTxqKjMd0Z6iz7voeR0PuNMAVdS3uIHzhd5FMv4ATGNISU7Y4hHwqRAA0nmCmPlLXo0M46-OR5d0LrpOIAywP6GaBZITuyes5gckrp3TY02KCgPpUlJPj2ATrcf9EAuiHubfdoTGY0aRCiL3wT5ex5gvlnPKIF-RrD9JFg=w888-h200-no)

## <a name="select-current-user"></a> 현재 계정 조회하기

현재 접속한 계정을 조회하는 쿼리이다.

~~~sql
SELECT user
FROM   dual;
~~~

<br>

## <a name="dba_users-grant-role"></a>오라클 계정, 시스템권한, 롤 확인하기

<a name="select-dba-users"></a>**현재 DB내 계정 목록 조회**

~~~sql
SELECT *
FROM DBA_USERS;
~~~

![](https://user-images.githubusercontent.com/33862991/93837915-e5f33e00-fcc2-11ea-9d25-c379ccbd2f6e.PNG)

~~~sql
SELECT *
FROM ALL_USERS;
~~~

![](https://user-images.githubusercontent.com/33862991/93837918-e7246b00-fcc2-11ea-97ca-d900659733f9.PNG)

<a name="select-dba-sys-privs"></a>**계정에 부여된 시스템 권한 확인**

~~~sql
SELECT * 
FROM DBA_SYS_PRIVS
WHERE GRANTEE = 'ACCOUNT'  -- SYSTEM
~~~

![](https://user-images.githubusercontent.com/33862991/93837921-e7bd0180-fcc2-11ea-96e0-5060edc162cf.PNG)

<a name="select-dba-role-privs"></a>**계정에 부여된 롤 확인**

~~~sql
SELECT * 
FROM DBA_ROLE_PRIVS
WHERE GRANTEE = 'ACCOUNT'  -- DBA
~~~

![](https://user-images.githubusercontent.com/33862991/93837926-eab7f200-fcc2-11ea-9cab-13c01a67c2ad.PNG)

<br>

## <a name="dbms-xdb-gethttpport"></a>오라클 포트 확인하기

오라클 DB가 연결된 포트번호를 조회하는 쿼리이다.

~~~sql
SELECT dbms_xdb.gethttpport() 
FROM dual;
~~~

<br>

## <a name="dbms-xdb-sethttpport"></a>오라클 포트 변경하기

~~~sql
EXEC dbms_xdb.sethttpport(1521);
~~~

![](https://user-images.githubusercontent.com/33862991/95942290-c365c800-0e1d-11eb-9ed8-00b4a6d54ac2.PNG)

<br>

## <a name="create-table"></a>테이블 생성하기

`position`, `name`, `back_number`, `registration_date` 컬럼을 갖는 테이블 `players`을 생성하겠다. back_number를 제외한 모든 컬럼에 `not null` 조건을 추가하여 반드시 기입하도록 하였고, 모든 데이터가 가변성을 위해 `char()` 대신 `varchar()` 를 데이터타입으로 주었다.

~~~sql
CREATE TABLE ManchesterUnited(
   position varchar(20) not null,
   name varchar(30) not null,
   back_number varchar(10),
   registration_date date default sysdate not null
);
~~~

실행 결과이다.

![](https://lh3.googleusercontent.com/Itsw3wVOD-0SO8wKzQWzjsZY0zvslsxkXjcnFKBVzMD5G07G3bdfaSNWtw3PpJIgldBirOLA6Bovj21ORoB5p4nB8y5TYxltAkdyz-QyGDCWxMor7jhQZ6_rPQwWYOGCcgpP5tCoyBzmbxFJycEbDAkmfTsuA0XfqsJx9GVfk5fHffwgIP8c7cvCP8ycN-vjrvteHi9sD3w6-1GueSnGTdUIUlek366X8axiXNG7Hvkyfbwq8EkAkfBibiSfLlbSF-gM7HDrYXJiaXQXj1cFQ76yXEB0ApfBK2jbg-xj-NBy1-D1ebjJj-OiwuDMWJJAbnl2A-wcn3TcNDlwzfxQpCuLUWGr-l_7PRfHGF_YixaJ6_ck7EIFbcGalq3JyWpuv-i8YOFoSojUGJ5ox-ozC9psJlO7tNTh7ZIaFmV1FKjoUf2s3iwGlus0JaphfhZi7yeWxedWBvvPIfrmjb5H38xowdQyh6G6sbtbG8E5n8T438TPF7QbCrwJmOFznUJxoIuq9KsfL8J04WLgBepuvlZpWkc8xTCrWgiiFlwdLW3YadJ4m55GOhS3dXix9Rh0P5tAMnVv8lB86Giq_qgKAbQjA9jzvwQVeSvTgAn2O_gdxP9Ksyg4U8QilKDyGcfSWt7ICz4DK66098mvoexpQp0ax_AJBVO9doXBwg3eK4tazNFbVfid3xZZ34QPeGilEdzXf5ue6_OQzscA92VVU6QJG8_OQ0JVNb44Oyp3mkPQcxdm5A=w540-h365-no)

<br>

## <a name="drop-table"></a>테이블 삭제하기

테이블을 삭제하는 쿼리이다.

~~~sql
DROP TABLE [table_name];
~~~

<br>

## <a name="truncate-table"></a>테이블은 남기고 데이터만 삭제하기

~~~sql
TRUNCATE TABLE [table_name];
~~~

테이블은 남긴채, 테이블내 row만 삭제하는 쿼리이다.

![](https://wikidocs.net/images/page/4019/1.PNG)

<br>

## <a name="alter-table-rename"></a> 테이블 컬럼명 변경하기

~~~sql
ALTER TABLE [table-name] RENAME COLUMN [old-column-name] TO [new-column-name]
~~~

아래는 예제 쿼리이다.

~~~sql
ALTER TABLE emp RENAME COLUMN job TO position;
~~~

![](https://user-images.githubusercontent.com/33862991/95005369-7bcb8900-0632-11eb-807a-568f374054a5.PNG)

![](https://user-images.githubusercontent.com/33862991/95005370-7cfcb600-0632-11eb-9855-1b0077f6505c.PNG)

<br>

## <a name="alter-table-modify"></a> 테이블 컬럼 타입 변경하기

~~~sql
ALTER TABLE [table-name] MODIFY [column-name] [column-datatype]
~~~

단 주의해야 할 점은, 데이터 타입을 변경하고자 하는 컬럼에 데이터가 들어가 있으면 쿼리가 작동하지 않는다.

![](https://user-images.githubusercontent.com/33862991/95005372-7ec67980-0632-11eb-9e80-079a8e995021.PNG)

<br>

## <a name="desc"></a>DESC

테이블에 대한 스키마를 확인하는 쿼리이다.

~~~sql
DESC table_name;
~~~

<br>

## <a name="show-all-tables"></a> 오라클에서 전체 테이블 조회하기

~~~sql
SELECT
   table_name, owner
FROM
   all_tables
WHERE
   owner='ACCOUNT'
ORDER BY
   owner, table_name;
~~~

`SCOTT` 계정 내 테이블을 조회한 결과이다.

![](https://lh3.googleusercontent.com/sl8bqkhkiHb20UhRuQJkvnXLnZQ--a1NMhb__fl4JJazAY7KA4Ey-2z5zW8_0a8LA0fsxDwffviyNBtecjS-GU0m9qxWTm3Jr7PoHwmDKB3D29P3jXRDZt600LM9PfjBBgbZQVtEho0qQA27s93kQzKUQSwXR6cWFduxTbw1WAVBs_ElqzXdHXOwchckxPNmXczBI9qqhwzdvyNspXYBaYcMXbczMxrA7usQXi_0L6h_p7KQGrL2AwD9NAkAQyHcqG0AXWMbpcLll_eNWi4uuvSYqvia-hv6Xw-29Ql_u0gJrR0T7N2X1GdghKA6c9ei411SiX-JhFTh3y0fJWA4Jx3FYEP7sg10GIKwvUHfnXXhn17avmlv7He2NJN1xeGUgnh37SpCtJVtRhuJFaM8KtwPkso_hgpWBhvntsYiIpsTS_ZcLYClJmy9v1IHLrAq5ntVPpGNrKqQnZeWRHbQ31aZFccfOitQb89NzL6I0Vig6fpz3eJmhF2bXGr50mieigbVPQDhO2p82BxOD_GVqMLZT6MDVnnD-SvAuippfy4aI5mNQ2oVD2D2MqHYRDhpp6h96WppP15g_7P5gG6O99fG7GkjOUNvg69s5DIZ1ScAByAAYwIpiQgKQuqt_g7nsCyjZhbIoe6mIAB7cm15DdcR52URBtKqoe0hopuGqgHq76UoPKC7iXrvKkeTj0mzr6vytDI9NC0bODOkd7jASA_ahtu7jFMVHKnA48vbTXjJ-4eJWw=w1266-h1012-no)

<BR>

계정 상관없이 DB내 모든 테이블 조회는 아래 쿼리로 조회할 수 있다.

~~~sql
SELECT *
FROM USER_TABLES;
~~~

![](https://user-images.githubusercontent.com/33862991/93837928-eab7f200-fcc2-11ea-9f53-db3566596a41.PNG)

<br>

## <a name="select"></a>SELECT

`dept` 테이블내에 `dname`, `loc` 컬럼만 조회하고자 하는 쿼리이다.

~~~sql
SELECT dname, loc
FROM   dept;
~~~

실행 결과이다.

![](https://lh3.googleusercontent.com/BepKMO6crNSJ1DblqY_QMdN_WbXsBZ6gxcn33YkkGVqRLtROW6XpcDoUMra8WSMYgHJy_X7o8AZurVjw5Ahpf2kj6Tepdeh5mXwLTSXE4lU2zS3O369ddqwsAzhD9vg8pxHNoUlXpwNNh9SaHO3b2e2KQ2V4ql2DnCJb_XlD5KWCBJDMRu3_blI230CZ5F52bMQUzBoHP7KGmD4wk88u9PMtR1a1G2H9OFEyQcOK_PUGs1kxV1g56SnIIZqmWZcgcv5gsO6K-B8qfAhnlpIZWFIiRS-HGxFpxvUvvKN__fTKPQkAGMzO5MNA6gPqhJbneNyoPgenFb-w4tRj3SnhyUjDPRl576iGRO4fLM4O_ZZ8JmS3KJ1pk5v2XfoXsCNFrUHPuD-DPmgdHnOzjJpsi5uDq3K-gWKk1E1mL4AV_9msg917fEXQ2-yqCx1Kx3mtBGpGcWZghp39lgNlhZ_3XS9MouMEs1jQy25ztD1tTSafAjkfiFhcWjB8SWxQq6nzudpGoHPgZbaQDSJ03fi3V2tPieEm8kaO4A1CMjuIUscAebR3bwcQcMp0KhRQMpZ8ACnDUyb1hIOoa8Cd4eyOcTVI6dxgZY58oHZTMt--IhsgHLsJm6-7rbcxHl-6pCjsS1HX3as5Su5_nDhAkYiD7aXFTd8693sWIjzjStprFtR43-yvqyRuwPsmyJ3W-3a1ytDtIiiV8YsZHaJo5WAjIUeoZNSRB33FS4iK58eX0yPGkCk5pA=w878-h596-no)

<br>

## <a name="select-all"></a>SELECT *

테이블의 모든 컬럼을 조회하는 쿼리이다.

~~~sql
SELECT *
FROM dept;
~~~

실행결과이다.

![](https://lh3.googleusercontent.com/O-Xad05myu5pRNQ-La3nOgF5UkK5iMRspt4JO9szKtgOgsPPkDcIHCR_ZC6TohJkrFT1Gw0bYb36YRwlPvKfR9kILMVvcmXUbcnRh-L4hG70hZu3iDdibPzuHx0DS9Vl30OKY9Um5Xv8_Io5moiVJNwoDmUAUJZbQxXRoImQ86p9Ka5b409m1UCngDZNm7QS1f7osPh-U5QzkyudKotGapHNwTwv-ETse2fp1erL_rjpuLyD1GhrV_iP3uAb9Ztq7F2HQBAQK27ijBJixiihX-b5kf1I7hPTuY9CxzvkyT_xorRT-FBaatbUeAZKaaJtTBkJgruStuB26cfyq6NCHv57-c31RgegaawH0MHhLCLdEwQCQlDj_H7gffqM7WMgw6mDqYteif42HoP68SQlZ_r9ANBvVyew0H9q6hn4YLl5uHlDF-xpAtBx3m2BmieOvu5pqqb6gL_lVsJxdxR48tABknXO-nI5RveDG3JeQI3BE2sv8O1OD8YFW32OC4sxbG-kIMmNBCtG6AMtSEJmyW9SrQX3G1AV_D01_JxrN2wcN4Z3RqTzzbtC-J3zyptX5jKMhrT3DGeSQxxTBdk9mn3wTobTs8OCDytVjtE5skeNRYKkozw12UTRulOtIArn2F242rtl8NgWwSPzxWlUlLjkZsiDfEl5IUYw_UMII6vm8Te3RtCO0sGIIizVlHkbWiqjCOJrNYCnj0hmMZaBCO6bX6D3WUKTGbuv9ANabxH74DACuA=w910-h576-no)

<br>

## <a name="where"></a>WHERE

`deptno` 컬럼이 30 이상인 데이터만 조회하는 쿼리이다.

~~~sql
SELECT dname, loc
FROM   dept
WHERE  deptno >= 30;
~~~

실행 결과이다.

![](https://lh3.googleusercontent.com/0mB4qMo6AFSQipylQvtcUfX35gERBcss2GJfSASab3Oz3r8s4TtCdnZSMHD4O5wOBSdKY9Q1qJY3o5T11jt3a9Y6I9k-GSZbcUKSooffcgdx_Wvc3K5KcxZ0pt_MojIpLHyt_U8gKFtIeGa42dzH7yKhTEFcpPSvlohSsFqh7ZJqIMpBbbz8ULHy0gAJPiei7yAQz58T90js9favZ6a3eWECefP5Q5b1-oUGZ_liiU0StG7Icx2KxtU10b0SbdZw25wNkf4UrpuZRQHQztZGaotlbR6KU0g-vTnaBysBI0-7xEC_2UoQL_4F7LmHQiY676MSCMzvtMG208qsimGS9kTr5FQM9RLrWrggxju5OMaJDIaBizRNvgAJabrPDkBLemSgbJvTT-s4utrXEnEVnA5u5Zomg3zbLDPvckeTGdZVLZl45fANn8SrTnZBFrf9hdC7eikWo9dz8oJrzHsnhNHufuMDeek9BW9AqLBQZIXcucZ9e_utvLZf-KrftYoOO39AUmX_f6Fh35UBtfZY9Sbxsqqyxot0WpJ07RJXsjlsyVeJjYXFZhqrLILVOsguiojl4S7H-JCQbnEJ2qdPzL3zzFNvox1L5LCfuht02ZOG5zWDldCzHOqkcsnSzfQLuPHNHN-mqPFAqYzmaMA_1hvl_whMWwL_rt0rb23ayHtd1QSbZ_csTL7P68rs1MmzUrBHeBUbyv2H9n2Hfxze83MXRK6iGCkH5olut24X8hPfhLrHnw=w1032-h934-no)

<br>

## <a name="orderby"></a>ORDER BY (중복시 2번째 조건으로 정렬)

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

## <a name="rownum"></a>ROWNUM

조회하는 데이터의 갯수를 결정할 때 사용하는 쿼리이다. MySQL에서는 `LIMIT` 이라는 키워드로 활용할 수 있는데, 오라클에선 `ROWNUM` 으로 구현할 수 있다.

만약 조회조건으로 `WHERE` 절을 사용할 일이 있다면, `ROWNUM`과 사용하기 위해서 [서브쿼리](#subquery) 사용이 필요하다.

예제 쿼리를 보자. 입사일이 가장 빠른 3명을 조회하는 쿼리이다. 

```SQL
SELECT 		ename, hiredate
FROM 		emp
WHERE		ROWNUM <= 3
ORDER BY 	hiredate;
```

![](https://user-images.githubusercontent.com/33862991/95941843-aa104c00-0e1c-11eb-9c87-cbaedf2a1b8a.PNG)

그런데 위의 결과는 사실 의도와 다른 결과가 조회되었다. 

`ORDER BY` 절이 사용된 위치가 `WHERE` 절이 실행된 뒤에 실행되었기 때문에 `emp` 테이블 전체에서 입사일 순으로 정렬한게 아니라 기본 정렬에서 `ROWNUM <= 1` 이라는 `WHERE` 절 조건이 적용된 쿼리 결과에 대한 `ORDER BY` 가 적용된 결과이다. 

따라서 위의 쿼리는 서브쿼리를 사용해서 아래처럼 수정해야한다.

~~~sql
SELECT		ename, hiredate
FROM		(SELECT ename, hiredate FROM emp ORDER BY hiredate)
WHERE		rownum <= 3;
~~~

![](https://user-images.githubusercontent.com/33862991/95941845-ab417900-0e1c-11eb-9e09-f29282fce80e.PNG)

다른 결과가 출력되었다. 이게 처음 의도와 맞는 결과이다.

여기에 조건을 추가하여보았다. `deptno=10` 인 사원들중 가장 입사일이 빠른 3명을 조회하는 쿼리이다.

~~~sql
SELECT 		ename, hiredate
FROM 		(SELECT ename, hiredate FROM emp WHERE deptno=10 ORDER BY hiredate)
WHERE		ROWNUM <= 3;
~~~

![](https://user-images.githubusercontent.com/33862991/95941844-ab417900-0e1c-11eb-8b07-f7a2a9f83bc2.PNG)

<br>

## <a name="distinct"></a>DISTINCT

조회 조건에서 중복을 제거하고 조회할 때 사용하는 쿼리이다.

```sql
SELECT DISTINCT NAME
FROM ANIMAL_INS;
```

`DISTINCT` 는 `SELECT` 에서 사용하는 쿼리이다. 중복을 제거해서 조회하고 싶은 컬럼 앞에 `DISTINCT` 를 붙이면 해당 컬럼은 중복이 제거되어 조회된다.

<br>

## <a name="operation"></a>연산 처리

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

## <a name="number-functions"></a> 숫자함수

### <a name="abs"></a>abs

절대값을 구하는 함수

~~~sql
SELECT -10, abs(-10)
FROM dual;
~~~

![](https://user-images.githubusercontent.com/33862991/94988088-ae7b7000-05a5-11eb-9783-00263a585545.PNG)

### <a name="floor"></a>floor

소수점이하를 버리는 함수

~~~sql
SELECT 12.3456, floor(12.3456)
FROM dual;
~~~

![](https://user-images.githubusercontent.com/33862991/94988089-af140680-05a5-11eb-92e1-57dac8137af4.PNG)

### <a name="round"></a>round

반올림하는 함수

~~~sql
SELECT  12.3456, round(12.3456)
FROM 	dual;
~~~

반올림 자릿수도 결정할 수 있다. 음수이면 십의 자리 몇번째까지를 반올림할지를, 양수이면 소숫점 몇번째까지를 반올림할지를 결정한다.

예제 쿼리이다.

~~~sql
SELECT 12.3456, round(12.3456), round(12.3456, 2), round(12.3456, -1)
FROM dual;
~~~

![](https://user-images.githubusercontent.com/33862991/94988212-8cceb880-05a6-11eb-9096-aca13a82e337.PNG)

### <a name="trunc"></a>trunc

특정 자릿수를 버리는 함수이다.

함수의 인자값으로 하나만 넣으면 정수만 남기고 소숫점은 버린다. 두번째 인자값으로 버리는 범위를 지정할 수 있는데, 양수를 넣으면 버릴 소숫점 자릿수를 결정하며, 음수를 넣으면 십의 몇째자리까지 남길지를 결정한다. 

예를 들어, `trunc(12.34, -1)` 이면, 일의자리까지 버리고 `1`을 반환하며, `trunc(12.34, -1)` 이면, 소숫점 한 자리수만 남기고 버려서 `12.3`을 반화한다.

아래는 예제 쿼리이다.

~~~sql
SELECT 1234.5678, trunc(1234.5678), trunc(1234.5678, -2), trunc(1234.5678, 2)
FROM dual;
~~~

![](https://user-images.githubusercontent.com/33862991/94988326-53e31380-05a7-11eb-9ab3-b6640113ab92.PNG)

### <a name="mod"></a>mod

나머지를 구하는 함수이다.

~~~sql
mod(n, m) : n에 m을 나누고난 나머지 반환
~~~

예졔 쿼리이다.

~~~sql
SELECT 10, mod(10, 3)
FROM dual;
~~~

![](https://user-images.githubusercontent.com/33862991/94988411-e71c4900-05a7-11eb-8e53-d7c98616340a.PNG)

<br>

## <a name="string-functions"></a> 문자열 함수

### <a name="lower"></a>lower

소문자로 변환하여 출력하는 함수이다.

~~~sql
SELECT 	'ABcDEf', lower('ABcDEf')
FROM	dual;
~~~

![](https://user-images.githubusercontent.com/33862991/94988654-c9e87a00-05a9-11eb-960f-5c4b37b69512.PNG)

### <a name="upper"></a>upper

대문자로 변환하여 출력하는 함수이다.

~~~sql
SELECT 	'aBcdeF', upper('aBcdeF')
FROM	dual;
~~~

![](https://user-images.githubusercontent.com/33862991/94988656-cbb23d80-05a9-11eb-91d3-5c0ece74beed.PNG)

### <a name="initcap"></a>initcap

첫글자만 대문자로 반환하고, 나머지 문자는 소문자로만 반환하는 함수이다.

~~~sql
SELECT  'abcDEf', initcap('abcDEf')
FROM    dual;
~~~

![](https://user-images.githubusercontent.com/33862991/94988721-4d09d000-05aa-11eb-90ae-fdaf79894fe2.PNG)

### <a name="concat"></a>concat

문자열을 결합하는 함수이다.

~~~sql
SELECT  concat(concat(concat('Person name is ',ename), ', his job is '), job)
FROM    emp;
~~~

![](https://user-images.githubusercontent.com/33862991/94993978-9f111c80-05cf-11eb-8a65-633fbb48bb66.PNG)

`concat` 연산자 대신 `||` 를 이용할 수도 있다. 개인적으론 이게 더 편한것 같다.

~~~sql
SELECT	'Person name is ' || ename || ', his job is ' || job
FROM	emp;
~~~

![](https://user-images.githubusercontent.com/33862991/94994032-f7e0b500-05cf-11eb-933a-7df70dc3adcc.PNG)

<br>

### <a name="length"></a>length

문자열 길이를 반환하는 함수이다.

~~~sql
SELECT  length('안녕, 개발자앤디!')
FROM	dual;
~~~

![](https://user-images.githubusercontent.com/33862991/94994168-e77d0a00-05d0-11eb-9bb9-9433d3f4c892.PNG)

<br>

### <a name="substr"></a>substr

~~~sql
SELECT		SUBSTR( 문자열, 시작인덱스, 마지막인덱스)
FROM		table_name;
~~~

문자열을 잘라내는 함수이다. 문자열의 시작인덱스에서부터 마지막인덱스까지를 잘라낸다.



~~~sql
SELECT	substr('Hello world', 7)
FROM	dual
~~~

![](https://user-images.githubusercontent.com/33862991/94994417-6cb4ee80-05d2-11eb-8d02-ebe399d98b4a.PNG)



`substr` 의 인자로 숫자를 2개(n,m)를 주입하면, 문자열의 n번째부터 m번째까지 선택적으로 잘라서 반환이 가능하다.

~~~sql
SELECT  substr('Hello World', 0, 5)
FROM	dual;
~~~

 ![](https://user-images.githubusercontent.com/33862991/94994967-fc0fd100-05d5-11eb-9026-88ddd251f09a.PNG)

<br>

문자열의 뒤부터 자를수도 있다.

~~~sql
SELECT	substr('Hello World', -5, 3)
FROM	dual;
~~~

![](https://user-images.githubusercontent.com/33862991/95826061-bccb4800-0d6c-11eb-99cd-bce1de695fce.PNG)

### <a name="instr"></a>instr

문자열에서 검색하려는 문자열을 찾아서 문자열의 위치(인덱스)를 반환하는 함수이다.

~~~sql
SELECT 	instr('Hello World', 'll')
FROM  	dual;
~~~

찾는 문자열이 문자열에 없으면, 0을 반환한다.

![](https://user-images.githubusercontent.com/33862991/94995051-8fe19d00-05d6-11eb-895b-a6fe3f7ee3d8.PNG)

사원의 이름중에 A라는 글자가 두번째 이후에 나타나는 사원의 이름을 조회하는 쿼리

~~~sql
SELECT  ename
FROM    emp
WHERE   instr(ename, 'A') >= 2;
-- WHERE   ename NOT LIKE 'A%' AND ename LIKE '%A%';
~~~

![](https://user-images.githubusercontent.com/33862991/94995177-902e6800-05d7-11eb-8fdc-6a75b09545c0.PNG)

### <a name="lpad-rpad"></a>lpad, rpad

문자열의 왼쪽(`lpad`), 오른쪽(`rpad`)에 문자열을 채우는 함수이다.

~~~sql
SELECT  lpad('world', 10, '_'), rpad('비밀번호 ', 20, '*')
FROM    dual;
~~~

![](https://user-images.githubusercontent.com/33862991/94995660-a853b680-05da-11eb-9627-0f0ead1d278d.PNG)

### <a name="trim"></a>trim

공백을 제거하는 함수이다. 왼쪽 공백만 제거하려면, `lpad`, 오른쪽 공백만 제거하려면, `rpad`를 이용하면 된다.

~~~sql
SELECT trim('       hello world     '), 
       ltrim('       hello world     '), 
       rtrim('       hello world     ')
FROM   dual;
~~~

![](https://user-images.githubusercontent.com/33862991/94995754-5eb79b80-05db-11eb-8b22-cb1689accf79.PNG)

### <a name="replace"></a>replace

문자열의 일부를 다른 문자열로 교체하는 함수이다.

~~~sql
SELECT  'Hello world' as original, 
        replace('Hello world', 'world', 'DevAndy') as changed
FROM    dual;
~~~

![](https://user-images.githubusercontent.com/33862991/94995755-5fe8c880-05db-11eb-84cc-de13f1444d26.PNG)

<br>

## <a name="null-nvl"></a>NULL - NVL

NVL함수는 null값을 0으로 치환하여 연산하고자 할 때 사용하는 함수이다.

~~~sql
SELECT  sal, comm, sal+comm
FROM 	emp;
~~~

comm이 null인 항목이 있을 경우 위의 쿼리를 조회해도 아무것도 출력이 안될수 있다.

![](https://user-images.githubusercontent.com/33862991/94887076-45660080-04b0-11eb-8436-cd35796e46ea.png)

~~~sql
SELECT  sal, nvl(comm,0), nvl(sal+comm,0)
FROM 	emp;
~~~

![](https://user-images.githubusercontent.com/33862991/94887080-472fc400-04b0-11eb-855b-70ded846e5c4.png)

<br>

## <a name="is-null"></a>IS NULL

컬럼의 값이 NULL인지 여부를 체크할 수 있다.  
`emp` 테이블에는 커미션을 뜻하는 `comm`이라는 컬럼이 있는데, 이 컬럼에 **값이 없는 경우** 가 있다. 

따라서 **커미션을 받지 않는 사원의 사원번호, 이름을 조회** 할 때 아래와 같은 쿼리로 조회할 수 있다.

~~~sql
SELECT  empno, ename, comm
FROM    emp
WHERE   comm IS NULL or comm = 0;
~~~

반대로 NULL이 아닌 경우는 `IS NOT NULL` 키워드로 조회할 수 있다.

<br>

## <a name="where-between"></a>WHERE - BETWEEN

WHERE 조건으로 숫자 범위를 지정할때 사용하는 연산자이다.

~~~sql
SELECT  empno, ename, sal
FROM    emp
WHERE   sal > 2000 OR sal < 1000;
~~~

위의 쿼리에서 WHERE 절은 BETWEEN을 이용하여 아래처럼 작성할수도 있다.

~~~sql
SELECT  empno, ename, sal
FROM    emp
WHERE   sal BETWEEN 1000 AND 2000;
~~~

그러나 BETWEEN은 <, >가 아닌 **<=, >= 을 모두 포함** 하므로 주의해야한다.

아래의 쿼리는 서로 같은 결과를 출력하지 않는다.

~~~sql
SELECT  empno, ename, sal
FROM    emp
WHERE   sal >= 800 AND sal < 3000
ORDER BY sal ASC;
~~~

![](https://user-images.githubusercontent.com/33862991/94983387-4b75e300-057d-11eb-9ac1-524a1ff0e3da.PNG)

~~~sql
SELECT  empno, ename, sal
FROM    emp
WHERE   sal BETWEEN 800 AND 3000
ORDER BY sal ASC;
~~~

![](https://user-images.githubusercontent.com/33862991/94983388-4ca71000-057d-11eb-8a33-5b1fa8c63579.PNG)

<br>

## <a name="where-in"></a>WHERE - IN

WHERE 조건절에서 특정 컬럼에 대해 여러 조건을 조회할 경우에 `IN` 키워드를 이용하여 간단하게 조회할 수 있다.

~~~sql
SELECT  empno, ename, job
FROM    emp
WHERE 	job = 'CLERK' AND job = 'SALESMAN' AND job = 'ANALYST'
ORDER BY job ASC;
~~~

위의 쿼리를 바꾸면 다음과 같다.

~~~sql
SELECT  empno, ename, job
FROM    emp
WHERE job IN ('CLERK', 'SALESMAN', 'ANALYST')
ORDER BY job ASC;
~~~

<br>

## <a name="decode"></a>DECODE

컬럼의 **<u>값에 따라 반환값을 결정</u>** 하는 함수이다. Java의 Switch문같은 느낌(?)의 함수같다.

~~~sql
DECODE(column, val1, result1,
      		  val2, result2,
      		  val3, result3)
~~~

deptno에 따라 각 부서 이름을 지정하여 반환하는 쿼리이다. 즉  deptno가 10이면 '인사과', 20이면 '개발부'를 반환할 수 있다.

~~~sql
SELECT  empno, ename, 
		decode(deptno, 10, '인사과', 
               		20,'개발부', 
               		30, '경영지원팀', 
               		40, '생산부')
FROM    emp;
~~~

![](https://user-images.githubusercontent.com/33862991/95004617-bd573680-0628-11eb-839d-f58f3165c9a1.PNG)

<br>

## <a name="case"></a>CASE

조건에 따라 반환값이 결정되는 함수

[DECODE](#decode)가 Java에서 Switch문과 같았다면, 오라클에서 CASE는 Java의 if-else문과 유사하다. CASE는 **<u>조건에따라 값이 결정</u>** 된다.

~~~sql
CASE WHEN condition1 THEN result1
	WHEN condition2 THEN result2
	WHEN condition3 THEN result3
END
~~~

`CASE`로 시작하여 `END`로 끝이나며, `WHEN`을 구분할때 `,` 를 사용하지 않는다.

급여별 등급을 책정하는 쿼리이다.

~~~sql
-- 급여액별 등급을 가져온다.
-- 1000 미만 : C등급
-- 1000 이상 2000미만 : B등급
-- 2000 이상 : A등급
SELECT  empno, ename, 
        CASE WHEN sal<1000 THEN 'C'
            WHEN sal>=1000 AND sal<2000 THEN 'B'
            WHEN sal>=2000 THEN 'A'
        END as grade
FROM    emp;
~~~

![](https://user-images.githubusercontent.com/33862991/95004733-4e7add00-062a-11eb-90d6-36fdf33098b4.PNG)

<br>

## <a name="group-by"></a>GROUP BY

전체 쿼리의 결과를 하나의 그룹으로 묶어서 그룹함수(`sum`, `avg`, `max`, `min`)를 사용할 수 있다.

예를 들면,

~~~sql
SELECT sum(sal)
FROM   emp;
~~~

![](https://user-images.githubusercontent.com/33862991/95005923-057e5500-0639-11eb-8fa8-8d275ec081c5.PNG)

사원테이블에서 급여총액을 구한 쿼리이다. 여기서 부서별 급여 총액을 반환하는 쿼리로 변경하려면, `GROUP BY`를 써서 다음과 같이 작성할 수 있다.

~~~sql
SELECT   sum(sal), deptno
FROM	 emp
GROUP BY deptno;
~~~

그럼 부서별로 나누어서 조회한 결과에서 그룹함수 sum을 적용한 결과를 반환하게 된다.

![](https://user-images.githubusercontent.com/33862991/95005925-0616eb80-0639-11eb-84e8-20de7ed4c2d3.PNG)

`GROUP BY` 를 사용하면, 이처럼 하나의 결과를 여러 그룹으로 나눠 그룹 각각의 총합과 평균등을 구할 수 있다.

예제 쿼리이다. 각 부서별 사원들의 급여 평균을 구하는 쿼리이다. 부서별 급여를 구하기 위해서는 부서별로 `GROUP BY`를 한 후에 그룹함수`avg`를 사용하여 결과를 출력할 수 있다.

~~~sql
SELECT		trunc(avg(sal), 2), deptno
FROM		emp
GROUP BY	deptno
ORDER BY	deptno;
~~~

![](https://user-images.githubusercontent.com/33862991/95005832-e3d09e00-0637-11eb-839e-5cde86af8e51.PNG)

<br>

## <a name="having"></a> HAVING

`GROUP BY` 로 묶인 그룹들에 대한 조건을 지정할 수 있는 쿼리이다. `HAVING`은 `GROUP BY`절의 조건절이라고 할 수 있다.

예제 쿼리를 통해 알아보자. 부서별 평균 급여가 2000 이상인 부서의 급여 평균을 조회하는 쿼리이다.

부서별 평균 급여를 먼저 조회해야하므로 `GROUP BY`를 사용하여 다음과 같은 쿼리를 작성할 수 있다.

~~~sql
SELECT      deptno, trunc(avg(sal), 2)
FROM        emp
GROUP BY    deptno
ORDER BY    deptno;
~~~

![](https://user-images.githubusercontent.com/33862991/95006011-24c9b200-063a-11eb-9438-21392a6adfbd.PNG)

이제 여기서 부서별 평균 급여가 2000 이상인 조건을 추가해야한다. 이 때 `HAVING` 을 사용한다.

~~~sql
SELECT      deptno, trunc(avg(sal), 2)
FROM        emp
GROUP BY    deptno
HAVING      avg(sal)>=2000
ORDER BY    deptno;
~~~

![](https://user-images.githubusercontent.com/33862991/95006012-25fadf00-063a-11eb-961a-a4b986171657.PNG)

<br>

## <a name="over"></a>OVER

서브쿼리에서 `GROUP BY`를 사용했을 때의 단점을 해결하기 위해 사용되는 함수이다. `OVER()` 함수는 단독으로 쓰이기 보다 분석 함수(count, max, min, [rank](#rank))와 함께 사용되는 경우가 많다고 한다.

예제 코드를 통해 `OVER()`가 어떻게 쓰이는지 알아보자.

emp 테이블에서 사원번호, 사원이름, 급여, 부서번호를 조회하는데 여기에더해 각부서별 최고 급여를 함께 조회하려고 한다.

```sql
SELECT	empno, ename, sal, deptno
FROM 	emp
```

![](https://user-images.githubusercontent.com/33862991/95311869-2eb51480-08c9-11eb-8de9-72fe42a28d9e.png)

즉, 왼쪽처럼 출력되는 결과에서 오른쪽처럼 각부서별 최고 급여 컬럼을 추가하여 조회해야한다.

~~~sql
max(sal) OVER(PARTITION BY deptno) AS MAXSALBYDEPT
~~~

급여중 최고급여를 조회하는데 여기에 `OVER` 함수를 적용한다. 그리고 `OVER` 함수에 `PARTITION BY` 키워드를 사용하여 부서번호별 최고급여를 조회하는 것으로 조건을 설정하였다.
`PARTITION BY`는 [GROUP BY](#group-by)와 같은 역할로 이해하면 좋다.

~~~sql
SELECT  empno, ename, sal, deptno, 
		max(sal)OVER(PARTITION BY deptno) AS MAXSALBYDEPT
FROM    emp;
~~~

<br>

## <a name="rank"></a>RANK

[OVER()](#over) 함수를 활용해서 순위를 출력하는 함수이다. 

예제코드를 통해 알아보자. 
emp 테이블에서 사원번호, 사원이름, 급여를 조회한다.

```sql
SELECT 	 empno, ename, sal
FROM 	 emp
ORDER BY sal;
```

![](https://user-images.githubusercontent.com/33862991/95313162-c8c98c80-08ca-11eb-8f1d-84023be70f0b.PNG)

이렇게 조회하면, 급여 순으로 출력은 되지만, 순위는 클라이언트(SQL Developer)에서만 보이고 있다. 이 순위는 클라이언트에서만 보이고 데이터라고 할수는 없다.

`RANK()` 함수를 사용하면, 이 순위마저 테이블에 삽입하여 출력할 수 있다.

~~~sql
SELECT	empno, ename, sal, RANK() OVER(ORDER BY sal) AS RANK
FROM	emp
~~~

![](https://user-images.githubusercontent.com/33862991/95313164-c9622300-08ca-11eb-9d16-add531acf77f.PNG)

<br>

## <a name="join"></a> JOIN

두 개 이상의 테이블에 있는 컬럼 값을 한 번에 가져오기 위한 쿼리.

~~~sql
SELECT *
FROM   emp, dept;
~~~

`FROM` 에서 테이블을 복수로 조회하면 JOIN을 사용하게 된다.

![](https://user-images.githubusercontent.com/33862991/95006364-d539b500-063e-11eb-9bdd-858a290956b9.png)

이렇게 `JOIN`을 사용할 땐, <span style="color: red;">**두 가지**</span> 를 <span style="color: red;"><b>주의</b></span>해야 한다.

하나는 중복이 발생할 수 있으므로, `WHERE` 절에서 **중복을 제거하는 조건을 추가** 해야하며, 두번째로는 마찬가지로 복수의 테이블을 조회하다보면 같은 이름의 컬럼이 있을 수 있으므로 RDBMS가 어떤 테이블인지를 알 수 있도록 **테이블마다 별칭을 추가** 하여, 이 별칭으로 컬럼을 구분해야 한다.

테이블마다 별칭을 추가한 쿼리이다.

~~~sql
SELECT   e.empno, e.ename, d.deptno, d.dname
FROM	 emp e, dept e;
~~~

![](https://user-images.githubusercontent.com/33862991/95006360-ceab3d80-063e-11eb-9ea3-bc0e9916c666.PNG)

이렇게 하면 `emp` 테이블과 `dept` 테이블에 동시에 존재하는 `deptno` 컬럼을 구분해서 사용할 수 있게 된다. 그러나 이것만으로는 중복을 제거할 수 없다.

`WHERE` 절을 사용하여 중복된 컬럼을 명시하면 쿼리 결과에서 중복이 제거된다.

~~~sql
SELECT   e.empno, e.ename, d.deptno, d.dname
FROM	 emp e, dept e 
WHERE	 e.deptno = d.deptno;
~~~

![](https://user-images.githubusercontent.com/33862991/95006381-00240900-063f-11eb-9124-bc3482432ac1.PNG)

조회된 컬럼 수가 줄어든걸 확인할 수 있다. `JOIN` 결과에서 중복이 제거된 것이다.

<br>

## <a name="self-join"></a>Self Join

같은 테이블을 2번 `JOIN` 하는 것을 `Self Join`이라 한다.

예제 코드를 바로 보도록 하자. emp 테이블의 스키마 구조는 다음과 같다.

~~~
EMPNO    NOT NULL NUMBER(4)    
ENAME             VARCHAR2(10) 
JOB               VARCHAR2(9)  
MGR               NUMBER(4)    
HIREDATE          DATE         
SAL               NUMBER(7,2)  
COMM              NUMBER(7,2)  
DEPTNO            NUMBER(2) 
~~~

위와 같은 스키마를 갖는 emp 테이블에서 SMITH라는 이름의 사원번호, 이름, 직속상관 이름을 조회하려고 한다.

~~~sql
SELECT	empno, ename
FROM 	emp
WHERE	ename = 'SMITH'
~~~

여기서, 직속상관의 이름을 추가하려면 emp 테이블을 한 번 더 조회해야한다. 같은 테이블인 emp 테이블을 두번 조회하는 이유는 하나는 SMITH 사원에 대한 결과값을, 다른 하나는 SMITH 사원의 직속상관에 대한 결과값을 조회하기 위함이다.

~~~sql
SELECT	e1.empno, e1.ename, e2.ename AS mgrname
FROM	emp e1, emp e2
WHERE	e1.mgr = e2.empno
	AND	e1.ename = 'SMITH';
~~~

![](https://user-images.githubusercontent.com/33862991/95009383-a8949600-065c-11eb-9d09-6c8ab8cd1334.PNG)

<br>

## <a name="outer-join"></a>Outer Join

`JOIN` 조건에 포함되지 않는 컬럼까지 가져오는 JOIN 쿼리

일반적인 JOIN과 똑같이 사용하지만, `WHERE` 절의 조건에서 결과가 부족한쪽의 컬럼에 `(+)` 를 붙혀서 사용한다.

~~~sql
SELECT 		e1.ename, e1.empno, e2.ename as mgr
FROM		emp e1, emp e2
WHERE		e1.mgr = e2.empno(+);
~~~

위의 쿼리는 사원의 이름, 사원번호, 직속상사의 이름을 출력하는 쿼리인데, Outer Join을 함으로써 `WHERE` 조건을 충족시키지 않는 컬럼도 출력할 수 있도록 하였다.

즉 위의 쿼리에서는 직속상관이 없는 사원도 Outer Join으로 출력할 수 있게된 것이다.

![](https://user-images.githubusercontent.com/33862991/95013301-71cd7880-067a-11eb-8198-d0dc17cda760.PNG)

Outer Join을 하지않고, Join으로만 조회한 경우

~~~sql
SELECT 		e1.ename, e1.empno, e2.ename as mgr
FROM		emp e1, emp e2
WHERE		e1.mgr = e2.empno;
~~~

![](https://user-images.githubusercontent.com/33862991/95013302-73973c00-067a-11eb-9e9b-4a7cd4d6b88d.PNG)

`WHERE` 조건에 따라 직속상관이 없는 KING은 출력되지 않았다.

<br>

## <a name="subquery"></a>서브쿼리

~~~sql
SELECT *
FROM   table1
WHERE  conditional = (SELECT conditional
                      FROM	table2
                      WHERE author = 'DEVANDY');
~~~

쿼리문 안의 쿼리문을 **서브쿼리** 라 한다.

예제 쿼리를 보자. 'SMITH' 와 같은 부서에 근무하는 사원들의 번호, 이름, 급여액, 부서이름을 조회하는 쿼리이다.

~~~sql
SELECT      e.empno, e.ename, e.sal, d.dname
FROM        emp e, dept d
WHERE       e.deptno = d.deptno;
~~~

![](https://user-images.githubusercontent.com/33862991/95014335-13f05f00-0681-11eb-9a57-f97b31afabcd.PNG)

여기까지 작성했다면, 이제 'SMITH' 의 부서와 같은 부서라는 조건을 `WHERE` 절에 포함시켜야 한다. 이 때 서브쿼리를 이용한다.

~~~SQL
SELECT      e.empno, e.ename, e.sal, d.dname
FROM        emp e, dept d
WHERE       e.deptno = d.deptno 
    AND e.deptno = (SELECT deptno 
                    FROM emp 
                    WHERE ename = 'SMITH');
~~~

서브쿼리로 'SMITH' 라는 이름의 사원의 deptno를 반환하고 반환된 deptno와 같은 deptno를 갖는 조건을  `WHERE` 에 포함시켰다. 

![](https://user-images.githubusercontent.com/33862991/95014337-15218c00-0681-11eb-95e6-ed46dbae8edf.PNG)	

<br>

## 서브쿼리 연산자

### <a name="in"></a>IN

서브쿼리의 결과중 하나라도 일치하면 조건이 참.

예제코드를 보자.  3000 이상의 급여를 받는 사원들과 같은 부서에 근무하는 사원의 사원번호, 이름, 급여를 조회하는 쿼리이다.

~~~SQL
SELECT      empno, ename, sal
FROM        emp
WHERE       deptno = (SELECT deptno 
                      FROM emp 
                      WHERE sal>=3000);
~~~

이렇게 하면, 아래와 같은 경고가 출력된다.

![](https://user-images.githubusercontent.com/33862991/95015222-bf4fe280-0686-11eb-8dbf-d5efbd29e424.PNG)

서브쿼리의 결과가 하나 이상의 결과가 출력되서 발생한 에러이다. 이 경우에 사용하는 서브쿼리 연산자가 `IN` 이다. `IN` 을 사용하면, 서브쿼리의 결과중 하나라도 일치하면, 일치하는 조건으로 결과를 출력한다.

~~~sql
SELECT      empno, ename, sal
FROM        emp
WHERE       deptno IN (SELECT deptno 
                      FROM emp 
                      WHERE sal>=3000);
~~~

![](https://user-images.githubusercontent.com/33862991/95015223-c0810f80-0686-11eb-9e1b-2d1c2e200b1d.PNG)

<br>

### <a name="all"></a>ALL 

서브쿼리의 결과와 모두 일치해야 조건이 참.

예제 코드를 보자. 각 부서별 급여 평균보다 더 많이 받는 사원의 사원번호, 이름, 급여를 조회하는 쿼리이다.

~~~sql
SELECT      empno, ename, sal
FROM        emp
WHERE       sal  > (SELECT avg(sal) FROM emp GROUP BY deptno);
~~~

이렇게만 하면, 에러를 유발한다.

~~~sql
SELECT avg(sal) FROM emp GROUP BY deptno;
~~~

이 쿼리의 결과가 `GROUP BY` 에 의해서 부서별로 출력되기 때문이다. 

문제에 맞는 결과를 출력하기 위해서는 서브쿼리에서 출력되는 모든 컬럼보다 급여가 더 많은 조건이 충족되야 하므로 이 때 서브쿼리 연산자 `ALL`을 사용한다.

~~~sql
SELECT      empno, ename, sal
FROM        emp
WHERE       sal  > ALL (SELECT avg(sal) FROM emp GROUP BY deptno);
~~~

![](https://user-images.githubusercontent.com/33862991/95015573-97fa1500-0688-11eb-9c78-9a42d22c0fbb.PNG)

위의 쿼리는 `ALL` 을 사용하지 않고, 서브쿼리 내에서 그룹함수 `MAX`를 이용하여 하나의 결과만 출력되도록 하여 사용할 수도 있다.

~~~sql
SELECT      empno, ename, sal
FROM        emp
WHERE       sal  > (SELECT max(avg(sal)) FROM emp GROUP BY deptno);
~~~

결과는 정확히 같다.

### <a name="any-some"></a>ANY, SOME

서브쿼리의 결과와 하나 이상 일치하면 조건이 참.

<br>

## <a name="set"></a>SET

두 개의 `SELECT` 문을 통해 얻어온 결과에 대해 집합 연산을 할 수 있는 쿼리이다. 단, `SELECT` 문을 통해 가져온 컬럼의 형태가 완전히 일치해야 사용할 수 있다.

![](https://dwgeek.com/wp-content/uploads/2019/12/Snowflake-Set-Operators.jpg)

### <a name="union"></a>UNION

2개의 쿼리에 대한 합집합 결과를 출력하는 쿼리이다.

~~~sql
SELECT   FROM   WHERE
UNION
SELECT   FROM   WHERE
~~~

### <a name="union-all"></a>UNION ALL

중복된 데이터를 포함하는 합집합이다.

~~~sql
SELECT   FROM   WHERE
UNION ALL
SELECT   FROM   WHERE
~~~

### <a name="intersect"></a>INTERSECT

교집합이다.

~~~sql
SELECT   FROM   WHERE
INTERSECT
SELECT   FROM   WHERE
~~~

### <a name="minus"></a>MINUS

차집합이다.

~~~sql
SELECT   FROM   WHERE
MINUS
SELECT   FROM   WHERE
~~~

<br>

## <a name="insert"></a>INSERT

~~~sql
INSERT INTO players(col1, col2, col3)
VALUES (val1, val2, val3);
~~~

실행결과이다.

![](https://lh3.googleusercontent.com/PkDNslNo3bKyZ3OP6t43EcwT9A9NtuufR-FmMXhAZm0zfHZu9oi0Ifd04dJDScyhoqWdFpw8zExi_g3aQkhbLpBpc-iyP-v8TKQSEx3NsYo1Vi6FW8FhaKHl7LOFtxrxfcicg0AVhfbDWtWsiL_exq5MJuddoRp35G_mDNC6YomLEHZXGjb7Ja9QOK8NpVfQXvlLBpr5Eaj0TbXHrjRgGxBfVI9s8tjyTrkmTjdig6S4H_ioJW3ieKjrmLIbB1St3b4so4j9K7WGzcFlHu_L9xSf94-UC6JT11S91GLWxhlxp4UL0oatJZHWx41mzC0VPQi67GjALG9zLjWJ2HEEO_gaCha1R53rBnMHpx-duB5JShEO2oUo6Swki0LatdJitrgq6Sxu6AhOGAlsouxXOnyOGUy_MH4-qAPybPZ0TpIlDaqWvvUM00czjBRwdGdYV-aVwkhOvgyPnEi6eI5Ol-KjvVMkdLHeWxOMZ6-qKdzgI2pailp0oxwUUOVmgPBpPdgihQzH6BUX4OLcf7F9B6tsLnzv3qm9W2nfFGYI-TEiuZRwXzFhT6SyJ0_Pb1JmrnN9UCrI5j-3ODHbuygeHyx5Uqrgpm5dWr1IPCTDweoNYPC0F1_9-Lsy3rv92trwi_x8G7rY3qKWal2VWnPszyKojiOgRNMl5J6DEL0hMU2qTyKv7mY0uty30IalSc14Fy-nj5zy7gndzjwt2ge8Y7e4uixiTiRHfNXJjInWxFSfb0W3bg=w1646-h642-no)

<br>

## <a name="dbms-xplan-display-cursor"></a>DBMS_XPLAN.DISPLAY_CURSOR

단일 SQL문에 대해 실제 수행된 실행계획을 보여주는 함수이다.

~~~sql
SELECT * FROM TABLE(DBMS_XPLAN.DISPLAY_CURSOR(NULL, NULL, 'ALLSTATS LAST -ROWS +PREDICATE'));
~~~

SQL 쿼리를 실행한후, 위의 쿼리를 실행하면 방금 실행한 쿼리가 어떻게 실행되었는지를 보여주는 함수이다.

SQL 튜닝과 관련한 함수인데, 아직 튜닝을 모르므로 여기까지만 정리.

함께 보면 좋을 글

- [DBMS_XPLAN.DISPLAY_CURSOR란?](http://www.gurubee.net/lecture/2137)

<br>