# MacOS

현재 사용중인 컴퓨터의 운영체제가 MacOS인데, 처음 개발을 공부할 때 개발도 물론이거니와 이 맥이라는 환경에 개발자로서 적응해야하는 시간도 필요했다. 그래서 공부하면서 알게 된 것들을 정리해 남겨보겠다.

- [Homebrew](#homebrew)
- [tree 패키지](#package-tree)
- [Xcode 대신 Command Line Tools 사용하기](#commandlinetools)
- [xcrun error](#xcrun-error)

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

`xcode-select --install`

출처 : [백투더맥 - Xcode없이 맥에 '명령어 라인도구(Command Line Tools)'를 설치하는 방법](https://macnews.tistory.com/4243)

<br>

##<a name="xcrun-error"></a>xcrun error

[homebrew](#homebrew)를 사용하여 패키지를 설치하다가 발견한 에러 메세지이다. 

![](http://www.mediafire.com/convkey/59f5/9b1hga2g4vm82znzg.jpg)

CommanLineTools를 업데이트 하지 않아 발생한 에러같았다. X Code를 따로 안쓰다보니 지우고 가볍게 CommandLineTools만을 사용중인데, 따로 수동으로 업데이트를 해줘야하나보다.

`xcode-select --install` 명령어로 CommanLineTools를 업데이트 하고 나서 다시 reinstall했더니 정상적으로 설치가 되었다.

![](http://www.mediafire.com/convkey/e0a1/sfyajpnpwqt9ytbzg.jpg)

<br>