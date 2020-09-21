# Oracle DBMS

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
- [오라클에서 전체 테이블 조회하기](#show-all-tables)
- [오라클 버전 확인하기](#v-version)
- [오라클 DB 계정 생성하고 전환하기](#create-account)
- [오라클 DB 계정 삭제하기](#drop-account)
- [테이블 생성하기](#create-table)
- [데이터 구조 조회하기 (DESC)](#desc)
- [데이터 삽입하기](#insert-into-table)
- [테이블 컬럼 데이터 타입 변경하기](#truncate)
- [테이블 삭제하기](#drop-table)
- [테이블 전체 컬럼 조회](#show-all-columns)
- [선택적 데이터 조회](#show-specific-columns)
- [조건에 따른 데이터 조회](#show-columns-while-condition)
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

##<a name="desc"></a>데이터 구조 조회하기 (DESC)

~~~sql
DESC (table_name);
~~~

<br>

## <a name="insert-into-table"></a>데이터 삽입하기

~~~sql
INSERT INTO players(col1, col2, col3)
VALUES (val1, val2, val3);
~~~

실행결과이다.

![](https://lh3.googleusercontent.com/PkDNslNo3bKyZ3OP6t43EcwT9A9NtuufR-FmMXhAZm0zfHZu9oi0Ifd04dJDScyhoqWdFpw8zExi_g3aQkhbLpBpc-iyP-v8TKQSEx3NsYo1Vi6FW8FhaKHl7LOFtxrxfcicg0AVhfbDWtWsiL_exq5MJuddoRp35G_mDNC6YomLEHZXGjb7Ja9QOK8NpVfQXvlLBpr5Eaj0TbXHrjRgGxBfVI9s8tjyTrkmTjdig6S4H_ioJW3ieKjrmLIbB1St3b4so4j9K7WGzcFlHu_L9xSf94-UC6JT11S91GLWxhlxp4UL0oatJZHWx41mzC0VPQi67GjALG9zLjWJ2HEEO_gaCha1R53rBnMHpx-duB5JShEO2oUo6Swki0LatdJitrgq6Sxu6AhOGAlsouxXOnyOGUy_MH4-qAPybPZ0TpIlDaqWvvUM00czjBRwdGdYV-aVwkhOvgyPnEi6eI5Ol-KjvVMkdLHeWxOMZ6-qKdzgI2pailp0oxwUUOVmgPBpPdgihQzH6BUX4OLcf7F9B6tsLnzv3qm9W2nfFGYI-TEiuZRwXzFhT6SyJ0_Pb1JmrnN9UCrI5j-3ODHbuygeHyx5Uqrgpm5dWr1IPCTDweoNYPC0F1_9-Lsy3rv92trwi_x8G7rY3qKWal2VWnPszyKojiOgRNMl5J6DEL0hMU2qTyKv7mY0uty30IalSc14Fy-nj5zy7gndzjwt2ge8Y7e4uixiTiRHfNXJjInWxFSfb0W3bg=w1646-h642-no)

<br>

## <a name="drop-table"></a>테이블 삭제하기

~~~sql
DROP (table_name);
~~~

<br>

## <a name="show-all-columns"></a>테이블 전체 컬럼 조회

`dept` 라는 테이블의 모든 컬럼을 조회하는 쿼리이다.

~~~sql
SELECT
   *
FROM
   dept;
~~~



실행결과이다.

![](https://lh3.googleusercontent.com/O-Xad05myu5pRNQ-La3nOgF5UkK5iMRspt4JO9szKtgOgsPPkDcIHCR_ZC6TohJkrFT1Gw0bYb36YRwlPvKfR9kILMVvcmXUbcnRh-L4hG70hZu3iDdibPzuHx0DS9Vl30OKY9Um5Xv8_Io5moiVJNwoDmUAUJZbQxXRoImQ86p9Ka5b409m1UCngDZNm7QS1f7osPh-U5QzkyudKotGapHNwTwv-ETse2fp1erL_rjpuLyD1GhrV_iP3uAb9Ztq7F2HQBAQK27ijBJixiihX-b5kf1I7hPTuY9CxzvkyT_xorRT-FBaatbUeAZKaaJtTBkJgruStuB26cfyq6NCHv57-c31RgegaawH0MHhLCLdEwQCQlDj_H7gffqM7WMgw6mDqYteif42HoP68SQlZ_r9ANBvVyew0H9q6hn4YLl5uHlDF-xpAtBx3m2BmieOvu5pqqb6gL_lVsJxdxR48tABknXO-nI5RveDG3JeQI3BE2sv8O1OD8YFW32OC4sxbG-kIMmNBCtG6AMtSEJmyW9SrQX3G1AV_D01_JxrN2wcN4Z3RqTzzbtC-J3zyptX5jKMhrT3DGeSQxxTBdk9mn3wTobTs8OCDytVjtE5skeNRYKkozw12UTRulOtIArn2F242rtl8NgWwSPzxWlUlLjkZsiDfEl5IUYw_UMII6vm8Te3RtCO0sGIIizVlHkbWiqjCOJrNYCnj0hmMZaBCO6bX6D3WUKTGbuv9ANabxH74DACuA=w910-h576-no)

<br>

## <a name="v-version"></a>오라클 버전 확인하기

~~~bash
SELECT *
FROM v$version
~~~

<br>

## <a name="show-specific-columns"></a>선택적 데이터 조회

`dept` 테이블내에 `dname`, `loc` 컬럼만 조회하고자 하는 쿼리이다.

~~~sql
SELECT
   dname, loc
FROM
   dept;
~~~

실행 결과이다.

![](https://lh3.googleusercontent.com/BepKMO6crNSJ1DblqY_QMdN_WbXsBZ6gxcn33YkkGVqRLtROW6XpcDoUMra8WSMYgHJy_X7o8AZurVjw5Ahpf2kj6Tepdeh5mXwLTSXE4lU2zS3O369ddqwsAzhD9vg8pxHNoUlXpwNNh9SaHO3b2e2KQ2V4ql2DnCJb_XlD5KWCBJDMRu3_blI230CZ5F52bMQUzBoHP7KGmD4wk88u9PMtR1a1G2H9OFEyQcOK_PUGs1kxV1g56SnIIZqmWZcgcv5gsO6K-B8qfAhnlpIZWFIiRS-HGxFpxvUvvKN__fTKPQkAGMzO5MNA6gPqhJbneNyoPgenFb-w4tRj3SnhyUjDPRl576iGRO4fLM4O_ZZ8JmS3KJ1pk5v2XfoXsCNFrUHPuD-DPmgdHnOzjJpsi5uDq3K-gWKk1E1mL4AV_9msg917fEXQ2-yqCx1Kx3mtBGpGcWZghp39lgNlhZ_3XS9MouMEs1jQy25ztD1tTSafAjkfiFhcWjB8SWxQq6nzudpGoHPgZbaQDSJ03fi3V2tPieEm8kaO4A1CMjuIUscAebR3bwcQcMp0KhRQMpZ8ACnDUyb1hIOoa8Cd4eyOcTVI6dxgZY58oHZTMt--IhsgHLsJm6-7rbcxHl-6pCjsS1HX3as5Su5_nDhAkYiD7aXFTd8693sWIjzjStprFtR43-yvqyRuwPsmyJ3W-3a1ytDtIiiV8YsZHaJo5WAjIUeoZNSRB33FS4iK58eX0yPGkCk5pA=w878-h596-no)

<br>

## <a name="show-columns-while-condition"></a>조건에 따른 데이터 조회

`deptno` 컬럼이 30 이상인 데이터만 조회하는 쿼리이다.

~~~sql
SELECT
   dname, loc
FROM
   dept
WHERE
   deptno>=30;
~~~

실행 결과이다.

![](https://lh3.googleusercontent.com/0mB4qMo6AFSQipylQvtcUfX35gERBcss2GJfSASab3Oz3r8s4TtCdnZSMHD4O5wOBSdKY9Q1qJY3o5T11jt3a9Y6I9k-GSZbcUKSooffcgdx_Wvc3K5KcxZ0pt_MojIpLHyt_U8gKFtIeGa42dzH7yKhTEFcpPSvlohSsFqh7ZJqIMpBbbz8ULHy0gAJPiei7yAQz58T90js9favZ6a3eWECefP5Q5b1-oUGZ_liiU0StG7Icx2KxtU10b0SbdZw25wNkf4UrpuZRQHQztZGaotlbR6KU0g-vTnaBysBI0-7xEC_2UoQL_4F7LmHQiY676MSCMzvtMG208qsimGS9kTr5FQM9RLrWrggxju5OMaJDIaBizRNvgAJabrPDkBLemSgbJvTT-s4utrXEnEVnA5u5Zomg3zbLDPvckeTGdZVLZl45fANn8SrTnZBFrf9hdC7eikWo9dz8oJrzHsnhNHufuMDeek9BW9AqLBQZIXcucZ9e_utvLZf-KrftYoOO39AUmX_f6Fh35UBtfZY9Sbxsqqyxot0WpJ07RJXsjlsyVeJjYXFZhqrLILVOsguiojl4S7H-JCQbnEJ2qdPzL3zzFNvox1L5LCfuht02ZOG5zWDldCzHOqkcsnSzfQLuPHNHN-mqPFAqYzmaMA_1hvl_whMWwL_rt0rb23ayHtd1QSbZ_csTL7P68rs1MmzUrBHeBUbyv2H9n2Hfxze83MXRK6iGCkH5olut24X8hPfhLrHnw=w1032-h934-no)

<br>

## <a name="select-order"></a>정렬하여 조회하기 (이름순으로 조회시, 동명이면 생일순)

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

## <a name="limit"></a>데이터 조회 수 결정하기 (LIMIT)

조회하는 데이터의 갯수를 결정할 때 사용하는 쿼리이다.

```SQL
SELECT NAME
FROM ANIMAL_INS
ORDER BY DATATIME ASC
LIMIT 1;
```

날짜(`DATETIME`)순으로 정렬했을 때, 데이터를 하나만 조회하는 쿼리이다. 즉 가장 최신 데이터를 조회한 것이다. `LIMIT`을 활용하면 최대값, 최소값도 구할 수 있다.

<br>

## <a name="distinct"></a>중복제거 조회하기 (DISTINCT)

조회 조건에서 중복을 제거하고 조회할 때 사용하는 쿼리이다.

```sql
SELECT DISTINCT NAME
FROM ANIMAL_INS;
```

`DISTINCT` 는 `SELECT` 에서 사용하는 쿼리이다. 중복을 제거해서 조회하고 싶은 컬럼 앞에 `DISTINCT` 를 붙이면 해당 컬럼은 중복이 제거되어 조회된다.

<br>

## <a name="sql-math"></a>연산 처리

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