# 정규표현식

[프로그래머스 정규표현식](https://programmers.co.kr/learn/courses/11/) 강의를 들으면서 작성한 노트이다. 강의는 파이썬으로 진행되었다.

## ToC

- [숫자 대표문자 (한 글자만)](#digit-single)
- [글자 대표문자 (한 글자만)](#word-single)
- [문자 여러개](#multiple)
- [0개 이상](#atleast-one)
- [x가 있을수도 있고, 없을 수도 있고](#isExist)
- [x 또는 y가 있을수도 있고, 없을 수도 있고](#isExist-multiple)
- [특정 글자 수의 문자만 조회](#select-word-by-specific-number)
- [글자 수 조건 추가하여 문자 조회](#select-word-by-numbers)
- [특정 문자만 조회](#select-specific-word)
- [소문자 알파벳 전체를 조회하기](#select-all-small-alphabets)
- [한글단어 조회](#select-korean)
- [기타 대표문자](#select-other-words)

---

### <a name="digit-single"></a>숫자 대표문자 (한 글자만)

- `\d` : 숫자를 대표하는 정규표현식 (d:digit)

강의에서 계속 아래의 예제코드를 사용하게 된다.

```python
regex = r'\d'

search_target = '''Luke Skywarker 02-123-4567 luke@daum.net
다스베이더 070-9999-9999 darth_vader@gmail.com
princess leia 010 2454 3457 leia@gmail.com'''

import re
result = re.findall(regex, search_target)
print("\n".join(result))
```

**출력결과**

<img src="https://www.mediafire.com/convkey/659e/j9cufdbg9cq9wyczg.jpg" style="zoom:50%;" />

`result` 라는 변수가 print 함수에 의해 출력되었는데, `result` 함수를 뜯어보면, `search_target` 에서 `regex` 가 일치하는 부분만 뽑아서 한글자씩 저장이 된거다.

여기서 내가 작성한건 `regex` 변수 정의하는 부분에서 `\d` 를 채워넣었다. 여기서 `\d` 는 숫자(digit)를 대표하는 정규표현식이라고 한다.

---

### <a name="word-single"></a>글자 대표문자 (한 글자만)

- `\w` : 글자를 대표하는 정규표현식 (w:word)

- `a, b, c`와 같은 알파벳 문자와 `가,나,다` 와 같은 한글문자, `1,2,3` 같은 숫자까지 포함.

- 특수문자는 포함안되더라도 `_` 는 포함된다고 한다.

**출력결과**

<img src="https://www.mediafire.com/convkey/449d/knqqzjdjoj0ky4gzg.jpg" style="zoom:50%;" />

숫자 대표문자 `\d` 와 마찬가지로 변수 `regex`에 `\w` 를 작성하고 실행했다.

`search_target` 에서 `regex` 에 일치하는 결과물을 출력하는 코드이다. 스크린샷에서는 다 출력하지 못했지만, 숫자와 한글까지 다 정확히 출력된걸 확인할 수 있었다.

---

### <a name="multiple"></a>문자 여러개

- `\d`는 숫자 한 글자씩만 찾는 한계가 있다. 한 글자로 이루어진 단어뿐 아니라 여러 글자로 이루어진 단어로 찾을땐 `\d+` 를 이용한다.

**출력결과**

<img src="https://www.mediafire.com/convkey/f04a/2jfvjfj19cenouwzg.jpg" style="zoom:50%;" />

숫자로 이루어진 글자를 한글자씩 떼네어 잘 출력이되었다. `\w+` 로 조회해보면, 마찬가지로 문자를 한 글자가 아닌 한 단어씩 조회가 된다.

---

### <a name="atleast-one"></a>0개 이상

- `*` 은 특정 조건으로 최소한 1개 이상의 수를 조회한다.
- `[1-9]\d*` : 앞자리 숫자가 1과 9중 하나가 반드시 나오는 수를 조회한다. 즉 자연수를 찾는 방법이다.
- `\d*[9]` : 뒤에다 붙이면, 뒷자리 숫자가 9인 숫자를 조회한다.

**출력결과**

<img src="https://www.mediafire.com/convkey/103b/s7otvv0xifq1sy4zg.jpg" style="zoom:50%;" />

---

### <a name="isExist"></a>x가 있을수도 있고, 없을 수도 있고

- `x?` : x가 있을수도 있고, 없을수도 있는 조건을 포함시켜 조회할 때 사용한다.
- `[x]?` 로 작성할 수도 있다.

강의에서 사용한 예제는 전화번호이다. 찾고자 하는 전화번호가 같은번호임에도 `-` 여부에 따라   `021234567` 일수도있고, `02-123-4567` 일수도 있다. 
이때 `-?` 를 포함시켜 조회하면, `-` 가 있거나 없거나 모두 조회하게 된다.

전화번호 형태의 숫자를 조회해보았다.

전화번호(`xxx-xxx-xxx`)는 숫자(`\d+`) 3개 사이에 각각 `-` 가 포함될수도있고, 그렇지 않을수도 있기 때문에 정규표현식으로 작성해보면 `\d+` , `-?`, `\d+`, `-?`, `\d+` 를 이어붙인걸로 작성될 수 있다. `\d+-?\d+-?\d+` 

**출력 결과**

<img src="https://www.mediafire.com/convkey/a3cd/4oe6qltu2wxg1mtzg.jpg" style="zoom:50%;" />

---

### <a name="isExist-multiple"></a>x 또는 y가 있을수도 있고, 없을 수도 있고

- `[x,y]?` : x 또는 y가 있을수도 있고, 없을 수도 있다.

전화번호 예제를 계속 사용해보면, 사실 `-` 뿐 아니라 그냥 공백으로 전화번호를 구분하는 표기법도 있다. 그럼 [위](#isExist)의 정규표현식 `\d+-?\d+-?\d+` 로는 공백으로 구분한 전화번호는 조회되지 않는다. 

이땐 `?` 앞에 `-` 대신  `[- ]` 를 작성하면, `-`또는  이 있을수도 있고, 없을 수도 있는 조건이 추가되어 조회된다.

**출력 결과**

<img src="https://www.mediafire.com/convkey/a1d8/sh72klrp42subd0zg.jpg" style="zoom:50%;" />

---

### <a name="select-word-by-specific-number"></a>특정 글자 수의 문자만 조회

- `\d{n}` : n개로 이루어진 숫자 단어를 조회할 때 사용

전화번호 형태가 최근 가장 많이 쓰이는 휴대전화번호인 `xxx-xxxx-xxxx` 라면 위에서 사용한 정규표현식(`\d+[- ]?\d+[- ]?\d+`)만으로는 부족할 것이다. `\d+` 는 글자수와 상관없이 한 단어로 구성된 모든 숫자를 조회하기 때문이다.

이때 `\d{}` 를 사용하면, 원하는 글자 갯수로 구성된 단어만을 조회할 수 있다. 

일반적으로 많이 사용하는 휴대전화번호 포맷인 `xxx-xxxx-xxxx`를 조회하기 위해서는 정규표현식을 `\d{3}[- ]?\d{4}[- ]?\d{4}` 로 수정해야 한다.

**출력 결과**

<img src="https://www.mediafire.com/convkey/052f/ks4es59h599itv0zg.jpg" style="zoom:50%;" />

---

### <a name="select-word-by-numbers"></a>글자 수 조건 추가하여 문자 조회

- `\d{x, y}` : x또는 y개로 구성된 숫자 단어 조회

전화번호 포맷이 `xxx-xxxx-xxxx` 일 수도 있지만, `xx-xxx-xxxx` 이거나 `xxx-xxx-xxxx` 라면 `\d{n}` 만으로는 전체 전화번호 조회가 불가능하다. 따라서 찾고자 하는 단어의 갯수의 조건을 추가해야 한다.

앞자리 숫자가 3자리 일수도 있고, 2자리일수도 있으니 `\d{2,3}`
중간 숫자는 3자리 일수도 있고, 4자리 일수도 있으니 `\d{3,4}`
마지막 숫자는 4자리 수이므로 그냥 `\d{4}`

중간에 `-` 또는 공백이 있을수도 있고, 없을수도 있는 정규표현식(`[- ]?`)까지 채워넣으면 최종적으로 아래의 정규표현식이 완성된다.

`\d{2,3}[- ]?\d{3,4}[- ]?\d{4}`

**출력 결과**

<img src="https://www.mediafire.com/convkey/a32a/isqket3qcmiswgwzg.jpg" style="zoom:50%;" />

---

### <a name="select-specific-word"></a>특정 문자만 조회

- `[xyz]` : x, y, z만 조회한다.

소음자 모음(a,e,i,o,u)문자만 조회를 해보았다.

**출력 결과**

<img src="https://www.mediafire.com/convkey/fee4/gt4z8s38fo6721mzg.jpg" style="zoom:50%;" />

---

### <a name="select-all-small-alphabets"></a>소문자 알파벳 전체를 조회하기

- `[a-z]` : a부터 z에 해당하는 소문자 알파벳 전체를 조회한다.
- `[a-z]+` : 소문자로만 이루어진 단어 조회

**출력결과**

<img src="https://www.mediafire.com/convkey/0a60/33og25h9rw5ux1vzg.jpg" style="zoom:50%;" />

<img src="https://www.mediafire.com/convkey/8b12/eik0j7nqzqpz0hzzg.jpg" style="zoom:50%;" />

---

### <a name="select-korean"></a>한글단어 조회

- `[가-힣]` : 한글의 첫 글자는 `가`이고, 마지막 글자는 `힣`라고 한다.

한글로 구성된 단어를 찾을 땐 `[가-힣]+` 로 조회할 수 있다.

**출력 결과**

<img src="https://www.mediafire.com/convkey/7b11/r3nqdbjyvy4b6jizg.jpg" style="zoom:50%;" />

---

### <a name="select-other-words"></a>기타 대표문자

- `\s` : 공백문자 (스페이스, 탭, 뉴라인)
- `\S` : 공백문자를 **<u>제외한</u>** 문자
- `\d` : 숫자 대표문자
- `\D` : 숫자를 **<u>제외한</u>** 문자
- `\w` : 글자 대표 문자
- `\W` : 글자 대표 문자를 **<u>제외한</u>** 문자 (특수문자, 공백)

**출력 결과**

숫자를 제외하고 조회

<img src="https://www.mediafire.com/convkey/08c3/mt6k13b5u3jyd8nzg.jpg" style="zoom:50%;" />

글자 대표문자 제외하고 조회

<img src="https://www.mediafire.com/convkey/ab11/n5poizai60zj0eazg.jpg" style="zoom:50%;" />

