# Linux

리눅스는 <a href="https://github.com/torvalds" target="_blank">리누스 토발스</a>가 개발한 컴퓨터 운영체제(OS)이다. <a href="https://github.com/torvalds/linux" target="_blank">오픈소스 운영체제</a>이며, 다중 사용자, 다중 작업(멀티태스킹), 다중 스레드를 지원하는 네트워크 운영체제라고 한다.

리눅스를 운영체제라고 했지만, 정확히는 운영체제라기보다 리눅스 커널이라고 하는게 맞다. 그러나 통상적으로 리눅스 커널과 우분투, 페도라와 같은 운영체제들도 리눅스라고 칭하고 있다.

리눅스의 역사나 배경에 대해서도 차후 더 알아보고 정리해야 할 것 같다.

- [명령어](#linux-commands)
  - [find](#linux-find)
  - [Symbolic Link](#linux-symboliclink)
  - [grep](#linux-grep)
- [Vi Editor](#linux-vi)
  - [입력 명령어](#vi-input)
  - [이동 명령어](#vi-move)
  - [파일 상태 명령어](#vi-filestatus)

<br>

## <a name="command-of-linux"></a>명령어

### <a name="linux-find"></a>find

**리눅스에서 파일이나 디렉토리를 검색**할 때 사용하는 명령어이다.

경로 Desktop/test 에서 용량 3mb 미만의 파일을 콘솔에 출력할 때 다음과 같이 명령한다.

`$ find Desktop/test -size -3M -type f`

경로 Desktop/test 에서 용량 10mb이상의 디렉토리를 `ls -l` 형태로 출력할 때 다음과 같이 명령한다.

`$ find Desktop/test -size +10M -type d -exec ls -l {} \;`

<br>

### <a name="linux-symboliclink"></a>심볼릭 링크 생성/사용하기

심볼릭 링크는 디렉토리 또는 파일에 더 빠르게 접근하기 위한 별명을 설정하는 일과 같다. `디렉토리 --심볼릭링크`

`ln -s [target] [symbolic_link_name]`

<img src="http://www.mediafire.com/convkey/1fa6/at0glqvdxyrry4czg.jpg" width="700" />

<br>

### <a name="linux-grep"></a>grep

유닉스를 위해 만들어진 텍스트 검색 기능의 명령어이다. <i>**g**rep | **r**egular **e**xpression | **p**rint</i>의 약자라고 한다.

`grep [pattern] [file]` 포맷으로 입력하면 [file]에서 [pattern]이 어디있는지를 알려준다.

![](http://www.mediafire.com/convkey/0dc1/t7dwrw36pfdc0l2zg.jpg)



`grep`은 옵셥으로 검색할 수도 있다.

[lorem-ipsum](https://www.lipsum.com/)에서 텍스트를 가져와서 lorem-ipsum.txt라는 파일을 만들었다. 여기서 **There**를 검색하면 다음과 같이 출력된다.

![](http://www.mediafire.com/convkey/c3d8/9azmf260ppue6huzg.jpg)

그런데 자세히 보면 대문자가 없을뿐 중간에 there가 쓰인 다른 문장도 찾을 수 있다. 이럴 때 `-i` 옵션을 사용해서 검색하면, 대소문자를 구분하지 않고 검색결과를 출력해준다.

![](http://www.mediafire.com/convkey/fff7/75me6ct6gtfe6odzg.jpg)

`grep` 의 옵션은 다음과 같다.

옵션은 중복해서 사용할 수 있다. 대소문자를 구별하지 않으면, 패턴이 일치하는 라인의 수를 출력하고 싶다면, `grep -ic "PATTERN" FILE` 형식으로 검색하면 된다.

| option | description                             | example                    |
| ------ | --------------------------------------- | -------------------------- |
| -i     | 비교시 대소문자를 구별 안함             | `grep -i "PATTERN" FILE `  |
| -c     | 패턴이 일치하는 라인의 수를 출력        | `grep -c "PATTERN" FILE`   |
| -v     | 지정한 패턴과 일치하지 않는 라인만 출력 | `grep -v "PATTERN" FILE`   |
| -n     | 행의 번호를 함께 출력                   | `grep -n "PATTERN" FILE`   |
| -w     | 패턴이 전체 단어와 일치하는 행만 출력   | `grep -w "PATTERN" FILE`   |
| -m     | 최대 검색 결과 갯수 제한                | `grep -m 1 "PATTERN" FILE` |



**References**

- [개발자를 위한 레시피 - 리눅스 grep 명령어 사용법](https://recipes4dev.tistory.com/157)

<br>

## <a name="linux-vi"></a>Vi Editor

### <a name="vi-input"></a>입력 명령어

| 입력키 | 작업                                                |
| ------ | --------------------------------------------------- |
| i      | 커서의 **<u>현재 위치</u>**에서 **입력** 시작       |
| a      | 현재 커서보다 **<u>한 칸 뒤</u>**에서 **입력**시작  |
| A      | 현재 커서 위치의 **<u>줄의 끝</u>**에서 **입력** 시 |
| o      | 현재 커서의 **<u>다음줄</u>**에서부터 **입력시작**  |
| u      | 직전 작업 되돌리기(undo)                            |
| U      | 전체 변경사항 되돌리기                              |
| ESC    | 입력모드 종료                                       |
| dd     | 커서가 가리키는 **<u>한 줄</u>** **삭제**           |
| 3dd    | 커서가 가리키는 줄부터 **<u>3줄</u>** **삭제**      |
| dw     | 커서가 가리키는 **<u>단어 하나</u>** **삭제**       |
| 4dw    | 커서가 가리키는 **<u>단어 4개</u>** **삭제**        |
| D      | 현재 커서로부터 **<u>뒤의 컨텐츠</u>** **삭제**     |
| x      | 한 문자형(char) **<u>삭제</u>**                     |
| r      | 한 문자형(char) **<u>변경</u>**                     |
| yw     | 커서가 가리키는 **<u>한 단어</u>** **복사**         |
| y$     | 커서가 가리키는 **<u>줄의 끝까지</u>** **복사**     |
| yy     | 커서가 가리키는 **<u>줄 전체</u>** **복사**         |
| yj     | 커서가 가리키는 **<u>줄과 다음 줄</u>** 복사        |
| yk     | 커서가 가리키는 **<u>줄과 앞의 줄</u>** **복사**    |
| p      | 붙여넣기 (paste)                                    |

<br>

### <a name="vi-move"></a>이동 명령어

| 입력키 | 작업 |
| ------ | ---- |
| k      | ↑    |
| j      | ↓    |
| h      | ←    |
| l      | →    |

<br>

### <a name="vi-filestatus"></a>파일 상태 변경 명령어

| 입력키 | 작업              |
| ------ | ----------------- |
| :w     | 파일 저장         |
| :q     | 종료하기          |
| :wq    | 저장하고 종료하기 |



**References**

- [VI Text Edito with Commonds: Linux/Unix Tutorial](https://www.guru99.com/the-vi-editor.html)

<br>