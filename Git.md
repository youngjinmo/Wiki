# Git

Git은 버전 관리 시스템(VCS, Version Control System)의 한 종류이다. 

다른 버전관리 시스템으로는 SVN이 있다. Git과 SVN의 차이가 궁금하다면, Quora의 이 질문([What is difference between SVN and Git?](https://www.quora.com/What-is-the-difference-between-SVN-and-Git))에 대한 답변들을 살펴보길 권한다.

Git은 버전/브랜치 별로 프로젝트의 형상을 관리할 수 있기 때문에 1인개발에도 유용하며, 협업시엔 Merge 기능을 이용해 생산성을 올릴 수도 있다. 또한 코드 리뷰에 이용하기도 한다.

개발자라면 형상관리는 필수다.

<br>

## <a name="git-fork"></a>Fork

Fork는 다른 사람의 저장소를 내 저장소를 가져오는 기능이다. 정확히는 내가 Fork한 시점까지의 버전/커밋만 가져올 수 있다. 이후에 원래의 저장소, Upstream 저장소에 변경사항이 발생해도 내 저장소에 자동으로 반영되지는 않는다. 이 때엔 수동으로 Upstream 저장소의 변경사항을 동기화(`fetch`)하고 변경사항을 가져와야 한다. 자세한 방법은 [여기](https://youngjinmo.github.io/2019/09/git-sync-forked-repo/)를 참고바란다.

### 1. Fork할 저장소에서 Fork버튼을 클릭해서 가져온다.

![](http://www.mediafire.com/convkey/a78d/ozcxdz0mxotz4eozg.jpg)

### 2. Fork 저장소 확인

![](http://www.mediafire.com/convkey/bfca/349f4f3e0xz9iu3zg.jpg)

![](http://www.mediafire.com/convkey/68dc/3wsmvml6eq37oqezg.jpg)

### Clone과 Fork의 차이

Git 호스팅 서비스(Github, Gitlab)는 원격 저장소이다. 이런 원격 저장소에서 내 컴퓨터로 즉 로컬로 가져오는게 Clone이고, 원격저장소 내에서 내 이름의 저장소로 가져오는 행위는 Fork이다. 이 부분을 헷갈리지 않을 필요가 있다.

<br>

## <a name="git-pull-request"></a>PR

깃헙에서 PR이라는 단어를 자주봤을 것이다. PR은 Pull Request의 약어이다. 말 그대로 내가 작성한 커밋을 Pull 해달라고 요청하는 것이다. PR이 사용되는 경우는 아래의 경우에 해당된다.

프로젝트에 사용하는 공용 저장소를 [Fork](#git-fork)해서 자신의 저장소로 가져왔다. 여기에서 기능을 추가해서 커밋을 했는데 이게 프로젝트에 반영되려면 원격 저장소(Upstream)에 PR를 하는 것이다.

오픈소스에 기여(Contribution)하는 방법도 이와 같다. 오픈소스를 사용하다가 버그가 발견되었을 때, 해당 버그를 해결하기 위해 Fork한 저장소에서 버그를 해결한 코드를 작성후, PR을 하고, 원작자가 이를 받아들여서 오픈소스에 반영되면 내 이름이 컨트리뷰터에 오르게 된다.

PR하는 방법을 살펴보자.

### 1. 내 저장소에서 PR 요청

Github에 접속하면 Pull Request가 활성화되어있는 걸 확인할 수 있다. 

그 왼쪽의 메세지를 읽어보면, *'이 브랜치에 10개의 커밋이 [Upstream Owner:branch]를 바라보고 있다'*고 알려주고 있다. 이는 Upstream에 PR을 보낼 수 있는 10개의 커밋이 있다는 이야기이다.

![](http://www.mediafire.com/convkey/6ce7/3swf98prpdu4fu7zg.jpg)

### 2. Upstream 저장소의 브랜치와 내 저장소의 브랜치를 맞추고 PR

Upstream 저장소의 어떤 브랜치에 내 커밋을 병합(merge)할 것인지, 또 내가 보낼 커밋은 어떤 브랜치의 커밋인지를 맞춘뒤 Create pull request 버튼을 클릭하면 Merge 커밋메세지를 작성할 수 있다. Upstream의 오너가 이를 수용해서 merge하면 내가 작성한 커밋이 한꺼번에 Upstream의 브랜치에 반영된다.

![](http://www.mediafire.com/convkey/6bc0/1vj19nj4yncrlq3zg.jpg)

<br>