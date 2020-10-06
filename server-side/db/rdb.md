# RDB

## 모델링 절차

1. 업무 파악
   ![](https://user-images.githubusercontent.com/33862991/95164792-a447b480-07e5-11eb-94f8-db937c51f5bc.PNG)
2. 개념적 데이터 모델링
   ![](https://user-images.githubusercontent.com/33862991/95164805-a873d200-07e5-11eb-82d8-1b7c65c862c4.PNG)
3. 논리적 데이터 모델링 = ERD
   ![](https://user-images.githubusercontent.com/33862991/95164809-a9a4ff00-07e5-11eb-8ff3-4dd221e06496.PNG)
4. 물리적 데이터 모델링 = SQL
   ![](https://user-images.githubusercontent.com/33862991/95164811-aa3d9580-07e5-11eb-8692-0e565b8a1614.PNG)

<br>

## 주요 개념

- [Entity](#entity)
   - 연관된 데이터들이 묶여있는 그룹
   - 테이블에 해당한다.
- Turple
   - 테이블의 컬럼(Column)에 해당한다.
   - 테이블 구조(스키마)에서 Record라고도 불림.
   - 튜플의 개수가 Cardinality라고 한다.
- [Attribute](#attribute)
   - Entity의 속성이자, 연관된 데이터에 해당하는 요소이다.
   - 테이블의 로(Raw)에 해당한다.
- [Relation](#relation)
   - Entity간의 관계
   - PK, FK



## Entity와 Attribute의 차이

한번만 사용되는 요소라면, Attribute에 해당한다고 볼 수 있지만, 해당 개념으로부터여러 속성으로 파생될 수 있다면 본 요소는 Entity로 봐야한다.

<br>

## 식별자

### 후보키 (Candidate Key)

ERD 테이블(Entity)에서 식별자로 사용할 수 있는 속성들.

### 기본키(Primary Key)

테이블에서 대표하는 단 하나의 키.

### 대체키(Alternate Key)

후보키중 기본키를 제외한 나머지 후보키를 대체키라고 한다.

<br>

## Cardinality

관계를 표현할 수 있는 모든 테이블의 곱집합이다.

- One To One  1:1
- Many To One  M:1
- Many To Many  M:M

<br>

## Optionality

하나도 참조하지 않을수 있다.

![](http://www.gurubee.net/imgs/expert/modeling/5.3.3.jpg)

위 그림에서 2번 상황이 Optionality 라고 할 수 있다. 민원요청은 존재하지만, 민원인은 없을 수 있기 때문이다. 반대로 민원인이 존재한다면, 민원요청은 반드시 하나가 존재함을 알리는 ER 다이어그램이다.

관계형 DB 다이어그램
출처 : [개체-관계 다이어그램](https://m.blog.naver.com/PostView.nhn?blogId=alkydes&logNo=221063923603&proxyReferer=https:%2F%2Fwww.google.com%2F)