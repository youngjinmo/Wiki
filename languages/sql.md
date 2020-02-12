# SQL

- [계층적으로 조회하기 (이름순으로 조회시, 동명이면 생일순)](#order-hierarchy)
- [LIMIT](#limit)
- [DISTINCT](#distinct)
- [연산처리](#sql-math)

<br>

### <a name="order-hierarchy"></a>계층적으로 조회하기 (이름순으로 조회시, 동명이면 생일순)

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