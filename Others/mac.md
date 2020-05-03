# MacOS

현재 사용중인 컴퓨터의 운영체제가 MacOS인데, 처음 개발을 공부할 때 개발도 물론이거니와 이 맥이라는 환경에 개발자로서 적응해야하는 시간도 필요했다. 그래서 공부하면서 알게 된 것들을 정리해 남겨보겠다.

- [Homebrew](#homebrew)
- [tree 패키지](#package-tree)
- [Xcode 대신 Command Line Tools 사용하기](#commandlinetools)
- [xcrun error](#xcrun-error)
- [특정포트 사용중인 프로세스 종료하기](#killproc)
- [한글 깨진 파일 UTF-8 변환해서 복구하기 (iconv)](#iconv)
- [맥 전원버튼 눌러도 안켜질때](#nopoweronmymac)
- [ios 백업 데이터 저장 디렉토리 ](#ios-backup-directory)

<br>

## <a name="homebrew"></a>Homebrew

<img src="http://www.mediafire.com/convkey/011a/ug38gl0hjk0f0s1zg.jpg" width="500" />

[Homebrew](https://brew.sh/index_ko)는 맥OS 또는 리눅스에서 기본으로 제공하지 않는 패키지를 설치/제거할 수 있는 패키지 관리자다. 리눅스의 `apt-get` 과 비슷한 역할을 한다.

보통 맥에서 필요한 패키지를 설치할 때 자주이용하는 서비스니 맥을 사용하는 개발자라면 익혀두면 좋다.

### Homebrew 설치

터미널을 열고 아래 명령어를 붙여넣기하고 입력하면 homebrew가 설치된다. 엄청 간단하다.

`/usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"`



### 패키지 설치

설치하고 싶은 패키지가 있다면, 먼저 패키지가 있는지 알아둬야 한다.

`brew search [package-name]`

있다면 `search` 대신 `install`로 바꾸어서 패키지를 설치하면 된다.

`brew install [package-name]`



### homebrew 업데이트

기본적으로 패키지를 설치하기 전에 homebrew가 자동으로 업데이트를 진행하지만, 일단 알아두자.

`brew update`

<br>

## <a name="package-tree"></a>Tree 패키지

터미널에서 디렉토리를 계층적으로 분리해서 볼 수 있는 패키지다.

깃헙에서 사용할 수 있는 익스텐션인 [Octotree](https://www.octotree.io/)와 비슷하다.



### 패키지 설치

[homebrew](#homebrew)를 이용해서 설치할 수 있다. 

`brew install tree`



### 패키지로 디렉토리 한 눈에 보기

현재 디렉토리를 터미널에서 계층적으로 구분해서 편하게 보려면 `tree .` 을 입력하면 된다.

<img src="http://www.mediafire.com/convkey/0813/u5n9x04o217pgqezg.jpg" width="500" />

<br>

## <a name="commandlinetools"></a>Xcode대신 Command Line Tools 사용하기

Mac에서 git, gcc같은 개발 관련 툴을 사용하기 위해서는 Command Line Tools가 먼저 설치되어 있어야 한다. X Code를 설치하면 X Code 메뉴탭에서 설치가 가능하긴 하지만, 굳이 X Code를 사용하지 않는 개발자가 이렇게 무거운 툴을 설치할 필요는 없다. 터미널에서 간단히 아래의 명령어를 입력하여 설치할 수 있다.

~~~
xcode-select --install
~~~

출처 : [백투더맥 - Xcode없이 맥에 '명령어 라인도구(Command Line Tools)'를 설치하는 방법](https://macnews.tistory.com/4243)

<br>

##<a name="xcrun-error"></a>xcrun error

[homebrew](#homebrew)를 사용하여 패키지를 설치하다가 발견한 에러 메세지이다. 

![](http://www.mediafire.com/convkey/59f5/9b1hga2g4vm82znzg.jpg)

CommanLineTools를 업데이트 하지 않아 발생한 에러같았다. X Code를 따로 안쓰다보니 지우고 가볍게 CommandLineTools만을 사용중인데, 따로 수동으로 업데이트를 해줘야하나보다.

`xcode-select --install` 명령어로 CommanLineTools를 업데이트 하고 나서 다시 reinstall했더니 정상적으로 설치가 되었다.

![](http://www.mediafire.com/convkey/e0a1/sfyajpnpwqt9ytbzg.jpg)

<br>

## <a name="killproc"></a>특정포트 사용중인 프로세스 종료하기

포트를 사용중인 프로세스 조회**

```
sudo lsof -i :8080 // port
```

위 명령어로 조회된 프로세스중 종료할 프로세스의 PID를 드래그해서 복사한다.

<br>

**해당 프로세스 종료하기**

```
kill 22640 // process
```

`kill`이라는 명령어와 함께 아까 복사해둔 PID를 입력하면 해당 프로세스를 종료할 수 있다. 다시 `sudo lsof -i :8080` 를 통해 프로세스가 정상적으로 종료되었는지 확인할 수 있다.

<br>

## <a name="iconv"></a>한글 깨진 파일 UTF-8 변환해서 복구하기 (iconv)

맥을 사용하면서 불편한 점 중 하나는 UTF-8으로 인코딩되지 않은 파일을 타 운영체제 사용자로부터 파일을 받을 때이다. 지금까지는 양해를 구하고 UTF-8 인코딩을 부탁하곤 했는데, 이제 그럴 필요가 없어졌다.

php 코드 한 줄만으로 한글이 깨져서 전송된 파일을 UTF-8으로 인코딩해서 복구할 수 있기 때문이다.<br>

php엔 파일의 character encoding을 바꿀 수 있는 <a href="https://www.php.net/manual/en/function.iconv.php" target="_blank">iconv</a> 라는 함수가 존재한다. 이 함수를 사용해서 간단히 문제를 해결할 수 있다.

```php
iconv -f euc-kr -t utf-8 [file] > [new file]
```

`-f` : 원 문서의 인코딩 방식

`-t` : 새로 출력되는 파일의 인코딩 방식



**인코딩 전**

<img src="http://www.mediafire.com/convkey/8d6c/eu9kzcicc80xofdzg.jpg" />

**인코딩 후**

<img src="http://www.mediafire.com/convkey/c90f/tlln4gcjwkk8uujzg.jpg" />

<br>

## <a name="nopoweronmymac"></a>맥 전원버튼 눌러도 안켜질때

전원 버튼을 눌러도 전원이 들어오지 않는 경우 하는 두가지 방법이 있다.

### SMC 리셋 방법

1. 맥북 전원을 종료한 뒤, 전원 어댑터를 연결.
2. 키보드 왼쪽에 있는 Shift + Ctrl + Option + 전원 버튼을 동시에 누른다. 
3. 눌렀던 버튼을 동시에 놓는다. 이 때 어댑터가 연결되고 있음에도 충전상태가 잠시 중단됬다가 다시 충전이 될 수 있다.
4. 전원 버튼을 다시 켜서 전원을 켠다.



### PRAM 소거

1. 맥북을 완전 종료한 뒤, Cmd + Option + P + R + 전원 버튼을 동시에 누른다.
   (P와 R이 멀리 떨어져있기 때문에 손가락 포지셔닝이 중요하다)
2. 위에서 버튼을 누르고 있으면 부팅음이 들리는데, 이 때에도 버튼을 계속 누르고 있으면 다시 한 번 부팅음이 들린다. 두번째 부팅음때 버튼을 떼면 된다.

<br>

## <a name="ios-backup-directory"></a>ios 백업 데이터 저장 디렉토리

커맨드키를 누른 상태에서 상단 바에서 Go를 클릭하면, Library를 들어갈 수 있다.

![](https://lh3.googleusercontent.com/ybCTNp1Iq0-dNEQABxlF6tn-fML95g5x97Fr2eCUxAk0qH5hW-fvK5nsXPMDnKqaQztHHEmKFoHBzfpk_Gvacn0KeXp71p0dMgaeW0hQGe3wnv72jgaiVWEI0Ao8ZGanHWuwP2pN_J3YQaDCgEBK6yywqBhqFaKz95zIY3UuJDa2siXtKO0xqIG0_jiO7ogL_iV0tPkztrlN6IaL7J_XTBL1wuVr8ORQa22vnZhaNDdIq55xsbQfuLuUnWwjfJBHPccktMxSkbtJ3_J9lmkpqpgZDjG8Z7EM3rHzokXe2_amnPHq3lqS1rBu83ouenISArZ1SLPa6fvk2_BZu4pTXBa31gfrZyX5ybDJfIHZ-xI1LwA7c76uV_6hlqVG1wSWl6x-twohQqr6q6zC9tRW5DLma9968viPVl1dyNvm517hue4UOzOtbmw1B2xXCslkk4N9V1RvTb87SPlIZdnHETuEBEjqM2WSAwDoeMhegfLdfJZPYdxyt4K1o3TjT2Hhz2-hBMbvVxRMcsac2pgHbkV3O46LD_7YuqIOhNdh85KzGUK2X_Vtjovnh2d0q4WpbTy-FQ547tzcPgVMKH5Vm8TrheWTi2bgwqTztwz_-ZdSxEeuaoJBttR3res-o7LBLzBnDD2EOtyzEfOL8-85IDqL5IYAesGMAJkxkz5EeA_qqtGXJimWK53LdiKIWeHdOZILwUpNkhxbNZo3HyPnSOYJUOXmz8UwsInHti5Vm4vMhKPwKj_IhRZ9=w434-h50-no)

Library에서부터 **[Application Support]** -> **[MobileSync]** -> **[Backup]** 에 ios 백업 데이터가 저장된다.

<br>