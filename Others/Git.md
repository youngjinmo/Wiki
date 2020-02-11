# Git

Git은 버전 관리 시스템(VCS, Version Control System)의 한 종류이다. 

다른 버전관리 시스템으로는 SVN이 있다. Git과 SVN의 차이가 궁금하다면, Quora의 이 질문([What is difference between SVN and Git?](https://www.quora.com/What-is-the-difference-between-SVN-and-Git))에 대한 답변들을 살펴보길 권한다.

Git은 버전/브랜치 별로 프로젝트의 형상을 관리할 수 있기 때문에 1인개발에도 유용하며, 협업시엔 Merge 기능을 이용해 생산성을 올릴 수도 있다. 또한 코드 리뷰에 이용하기도 한다.

Git을 사용할 수 있는 GUI 기반의 응용 프로그램(<a href="https://www.sourcetreeapp.com/" target="_blank">SourceTree</a>)들도 있지만, 필자는 CLI로만 정리했다.

<br>

- [Staging과 Commit](#git-staging-commit)
- [파일단위 아닌 변경사항 단위로 Staging하기](#git-add-p)
- [Unstaging](#git-restore)
- [git log 그래프로 보기](#git-log-decorate)
- [브랜치 생성하기](#create-branch)
- [브랜치 이동하기](#move-branch)
- [브랜치 삭제하기](#delete-branch)
- [원격 저장소 브랜치 삭제하기](#delete-origin-branch)
- [브랜치 이름 변경하기](#change-branch-name)
- [커밋 합치기 with rebase](#rebase-merged)
- [커밋 순서 바꾸기 with rebase](#rebase-change-sequence)
- [커밋메세지 변경하기 with rebase](#rebase-change-commit-m)
- [원격 저장소 변경하기](#set-url)
- [Fork](#git-fork)
- [PR](#git-pr)
- [.gitignore](#git-gitignore)
- [git config 설정](#git-config)
- [Github Credential 저장](#git-credential)
- [Github에 SSH 등록하기](#add-ssh)
- [레파지토리 라이센스](#license)

<br>

## <a name="git-staging-commit"></a>Staging과 Commit

형상관리의 핵심인 스테이징과 커밋이다. 

어떤 기능을 구현했는지, 어떤 버그를 잡았는지를 커밋 메세지와 함께 커밋하면, 나중에 해당 커밋으로 복귀할 수도 있다. 타임 스탬라고 생각하면 좋다. 지금까지 한 작업을 스탬프로 찍으면 언제든 지금 찍은 스탬프로 돌아올 수 있다는 이야기이다.

<img src="https://d1lss44hh2trtw.cloudfront.net/assets/editorial/2018/02/kingdom-come-deliverance-how-to-save-your-game-re.jpg" style="zoom:80%;" />

RPG 게임을 하다가 어려운 스테이지를 앞두고 미리 게임을 저장하는 일과도 같다.



Git의 작업 흐름도와 각각 작업에 따른 명령어는 다음과 같다.

![](http://www.mediafire.com/convkey/4508/4t5cxewkb7l4z48zg.jpg)

Local과 Remote는 각각 개발자가 개발과 형상관리를 하고있는 곳을 Local, 형상관리한 파일이 저장된 원격저장소가 Remote에 해당한다. 즉 컴퓨터로 개발을 하고 Github에 형상관리를 저장해둔다면, 컴퓨터가 Local에 해당하고, Github이 Remote에 해당한다는 이야기이다.

Local은 다시 3가지로 구분될 수 있는데, working directory와 staging area, local repo가 있다. 각각의 장소의 역할은 다음과 같다.

| where                 | role                                                         |
| --------------------- | ------------------------------------------------------------ |
| **working directory** | 개발자가 작업을 하고 있는 프로젝트 디렉토리이다.<br /> `git init` 으로 버전관리되고 있는 로컬 작업환경이다. |
| **staging area**      | 형상관리 될 파일들, 즉 커밋**할** 파일들이 머무르는 장소이다. <br />커밋을 위해 커밋할 파일들을 staging area에 올려두고 커밋 메세지와 함께 커밋을 하면, local repo로 이동한다. |
| **local repo**        | 최종적으로 커밋이 보관되는 장소이다. <br />Github, Gitlab같은 원격 저장소(Remote)에 push할 수 있다. |
| **remote repo**       | Github, Gitlab과 같은 Git 호스팅 서비스에서 제공하는 원격 저장소에 해당한다. |

<br>

그럼 직접 파일을 생성하고, 커밋을 해보자.

일단 파일을 생성하고 명령어 `git init` 으로 디렉토리에 Git을 셋팅하였다.

![](http://www.mediafire.com/convkey/b76d/r5n1ssmh8kx0xg2zg.jpg)

<br>

여기서 file_01.java 파일을 커밋하기 위해서 스테이지에 올려보겠다.

![](http://www.mediafire.com/convkey/59ac/0h0th7tcljt5i4hzg.jpg)

`git status` 명령어로 보니 파일들이 서로 다르게 표시된걸 확인할 수 있다. 녹색으로 표시되는 파일이 스테이지에 올라간 파일이며, 이 파일은 커밋 대상이 된다.

만약 커밋하고 싶지 않은 파일이 staging area에 올라갔다면, `git restore --staged <file>` 로 working directory로 복귀시킬 수 있다. 아래 [내용](#git-restore)을 참고바란다.

이제 staging area에 있는 파일을 커밋하고 확인해보겠다.

![](http://www.mediafire.com/convkey/e69e/gusd02c4xmmcvelzg.jpg)

file_01.java 파일을 커밋하고 `git status` 를 확인해보니 file_01.java 파일이 사라진걸 확인할 수 있다. 커밋에 file_01.java 파일의 최신 변경사항이 반영되었기 때문에 Untracked files 목록에서 사라진 것이다. 

Untracked files들은 아직 커밋을 만들지않아서 git에서 추적(tracking)하지 못하는 파일들이다.

만약 다시 file_01.java 파일을 수정한다면 `modified` 목록에 수정된 파일이 보여질 것이다. 

![](http://www.mediafire.com/convkey/f37c/baki1lcse85ue0fzg.jpg)

Tracking 되고 있는 파일중에 변경사항이 발생했으니 새로 staging area에 올려서 커밋하라는 메세지이다.

다시 커밋을 하고, 커밋 목록만 따로 조회해보겠다. 명령어는 `git log` 를 사용한다.

![](http://www.mediafire.com/convkey/6443/7fa1yu4gaofg6grzg.jpg)

작성자와 날짜, 시간, 커밋에 포함된 파일목록 그리고 커밋 ID가 출력된다.

<br>

## <a name="git-add-p"></a>파일단위 아닌 변경사항 단위로 Staging하기

위에서 작성된 스테이징 방식(`git add file`)이 파일 단위라면, 여기서 언급되는 스테이징 방식은 작업의 변경사항 단위로 스테이징하는 방법이다.

하나의 파일 안에서도 변경한 부분이 몇 가지가 될 수 있는데, 이 때 `git add file` 을 사용하면 파일이 통째로 스테이징된다. 그러나 `git add -p` 를 사용하면 **<u>변경사항 단위로만 스테이징</u>** 할 수 있다. 더 편하고 더 분명하게 버전관리 할 수 있다고 생각된다.

이 때의 변경사항 단위를 **Hunk**라고 한다.

test 폴더를 만들어서 실습을 해보았다.

생성한 파일(test.html)에 세 줄의 코드를 추가하고, 명령어 `git add -p` 를 입력하였다.

![](https://lh3.googleusercontent.com/nOsWLkb4d1cDxvd62YTU_k71_OJRwiiXYgItZ_xQJPXHMPGHUMtXT1TaSMN0DGK_YfnzfPuqLk9n8hCdH9UBY4knvRbldaOh2KiPcg8vCJQH7KzuODPwfKojcR3OABe83KdW9ralyr0EWLmapKfAxib8Y-qRTQxz--VqdNDuCgJpMPf-hD2kCBwzK5YITWEp80LEijQpbUhPqpWZmploBXtcA1tGqebeoFSQwuqkOnyHIh4xvn47BPJWJqIMS0BcOxFFhuP1OrQyvOkqL2FHXRS0gFKMs0of7D7aU00mKPVW8ABPb46TOMzZuHVfNRG2hmndTWzIsCZStEc3z3UTAIAdh2QzzZ4TbEmzOGXRZWKHKwHfkg6Qzsjktn-M7_RGtonRDKAuey_hQi0pW55Pxjq8gv10vFws-oKzEJrC2aA4mebdx3Rdoe6JzZ5sWJSSY50Jh0J2-mYuB4c7qw9ruGL1gRuO-vwrpG3a4QHn7-KqsP9nUaFCYYf1Ejcx_GrJYpuW5smq4vUYssQxsP9zb9pqAteUf5_ob4oCsQgGFhLulzVfFlpmsb1K3AaGKTI5ErZomdsSfhnT3Yqju8mGgn6bVItQT59ACegt-CHeB8Pa6uS0EgdsZXwe-72IgnZYHfQMplcAZ1Kdj-lwckGYItDMaPRRmdBk9iuxRR0PNalivmv0SzYYvfSTJJEolEMAb8jCfbstMaUjGL4uI2dC9KofzqvOpB3S6CFt4rx6Fl9Hkh3P5A=w720-h489-no)

여기서 `s` 는 split을 의미한다. 세 줄을 한 꺼번에 스테이징하기 보다 더 세분화해서 스테이징하기 위해 split을 하는거다. split을 한 결과는 다음과 같다.

![](https://lh3.googleusercontent.com/KQzWbcfyFdb7qvH4rUYjmL8s2NNSrph-oPVYIOUiVmkBP1ERRqMPy53w0X1AXzbtcIt79H-uiNHftCrcf6z79Zhi9RqN0jb0Qa8w1rR2wQ76Is9HFMrl0mELyBz-AV2wVPk0yFSvOLuPV5HUyG4-HJmKqLq73yMW6s3hY959DrpkgZCC-BAaW5rU0fVvVWZZcgxBSK-ItoUYTQ_-m8Y1lEKE3q7XfFufwik6sqz2qeGRwg6cwXUVhcmHh6HpqlLwJEqsq4__KcuXgJrCNiev6cm6b45Dz2BBCQFx9sxl4es1vyoerosQEqbn2HDqop03OU_umWdFiU4p_H-hYqKbggr8i_QnMLIgLeKZyvoSf3SN0_fiwMRm79YbYzoimXbc8IXZadfBvRrH_8azJxyQ0UVo9aiVy6dKlOe8YOLUR66Ks7arDS-NrHur-65kbxf7FnG3pGGAa_f8YqYJahGkGjqL88aLHOKWo_OPYUCCJ_H7aAU3P_xYE27AmfTYyhp7Ef5QlGyWxtUr151Uz5paLhRgFokveUFrxIBqbcVW9U5DQsdZwVLlhh7JspUXfsJddcfJUh2fVH25BNizW1D4nogEvd7GU6ayUWn8nE7dTXKYzLodJTdB8glSOIxlKE3kU5yml0UOpolWw-zLKKnwT0z6PX6y2hJwpLtcQTwsB0odO5QDov9fnSiI9PxDo4oFou3rNBme1nkLnrxXQ89rquVp1iiX49M8MO-lVLbnieGVcBRDog=w720-h572-no)

하나의 hunk가 3개의 hunk로 쪼개져서 각각 스테이징 할 수 있었다. 세 줄의 코드중 마지막 줄 코드만 스테이징 하지 않기로 했다.

![](https://lh3.googleusercontent.com/ITFznygeA3KQNMX61PfMxOAAUu5pNO2vnwE_J83_oWu2nxoS80Aqm3JmQbaDCMNhoty_NFfGt88z2R0R05CFBbRsxfG9yLZP-GtvfltkE41BtIaMSOEsBLmrYIrW5Z2HGGcdHyqq2HtL-j53X7Kv7jeTiClJ3-L88oN4Hg17A6iXRSbGhjtm8Dv3CrZg_qOQL1iqadjribOmDlrogB4Tg_UPvQwTciNK29ITjfh5sltU1IkO-GFVmSV8PwuDLpdRmGwJQ4BGQzjGMPhDxnMNOoJLoNbNOqQd0L1QvBGP6xg83tX-PgtADpa0T3T-hzv0HZwEp6oCuyxGjs0QQcqR-fTbCo2wnlhWe1Lyg6JydTMzIi5DJvyrvkuqQ5qERSPzNKhULlLaHMxwUMCsXqPDOZhDm4PS7WSb8sM6tZsY3s_dc8Hvyro884QasSWEdO9HUj1-saiENzDuoiDsKL3npc9kGP2j8-ntzL9DGm4BuWNPAtumN7VPFqrxPpVSnaD_vqD8X9vcs-mAee9zESeDBKmAQ_vKdIApQOGzxTYF_YIti31AkuC9YQH0v74RAoDcU0-J86D4rYyt5DXu54LNA42lTfqUAXLsN1DnBCsqEsTX2wNGlihPELVDexwHckf-qk1iTfhWLAoAmQ_9NrNAmbyjwRDrzJKn4gEE5HfKABQ6TdsU8jRn-fvZrk08hFfGxm7UEGcMCRVorVVndo2X5VkWkv2ovtHrrqxKEIGN3Ki69RYnOg=w720-h337-no)

다시 `git add -p` 을 입력해보니 아까 스테이징 하지 않은 한 줄의 코드만 스테이지 여부를 묻고, 나머지 코드는 스테이징 되었음을 확인할 수 있었다. 

이처럼 `git add -p` 를 사용하면, <mark><b>변경사항 단위</b>로만 스테이징이 가능하다.</mark>

`git add -p` 에서 응답할 수 있는 명령어는 `?` 을 입력하면 볼 수 있는데, 다음과 같다.

![](https://lh3.googleusercontent.com/EZaWDiERwWHC0b9Y26t-iuMtBSjLtEmADt0p_a1950PDQwH17gLUsKtwQ86NrBgg7MZdhcLzMPn62pgebHj1c6zCGpJ2-t2Xn4Oyn8z_7HLCu_COp-bgiMWljOA1MfEetjide4LHMV8TO7f-NSzyT1GVvedWRjbCzSP2rgB80U99QUgcWvKThEYQsRvnR-OgnwWm0mKrdDfoaKSoEGIAPKfKjO0JSnoZshpz9-XWneVad0QzIUJIuvxWp71El8mweBQpk8jaf5YZVtYaVNCm-JmIUehi7V7Oaxpe0qAtHB55TSpkQ_UuQ9D5aqsWSTLhHrwtR42EptGdQ5j7jdf7HtYqAKK5bGB4bBlFhOcMiWhi6wAVkEj16-PZP71szp7bKDLxZgGBTDB75KGGQuK0T7L7sUGXqLz8KRzI5z5MtlVFNx_2w-JuDMCMcKBwc6ko_17Aj_bqjLWesfODFUBwyVX9g7PLfLngt4HUYhjYk67mw0o5GvP9o0_FFFX41Ov1yg3g3JEU6uxGGYcGkb6J0ZYQIzsSQ6VY6Ozw4AT2ylVYpcN9vB9b_mCEJGdIP-h960akfLQb1LIDfh3WvamC3HESsxB3uB8IDTw-XgzaIyiM_IV1m2YcfEjHgareU9GLdDqFLEJ5poysw9EmRZFNbL61vfyJsx_idxBfY8llBhecQdk8lmvppfNLEbKLTjKyD3nHJP58B3qZD4Ub6Nvf0N2ZlkXyxo0mOz2l0KWfx1CUdIkaBg=w1440-h366-no)

주로 쓰이는 명령어는 `y`, `n`, `q` 이다.

`y` : 해당 hunk를 스테이징한다.

`n` : 스테이징하지않고 건너뛴다.

`q` : add 과정을 종료한다.

<br>

## <a name="git-restore"></a>Unstaging (staging area➡️working directory)

staging area에서 working directory로 돌리는 방법에 관한 방법이다.

`git add .` 명령어로 작업한 파일 전체를 staging area에 올려두었는데, 이 중 커밋되면 안되는 파일을 발견했다. 이 땐 아래의 명령어를 통해 staging된 파일을 working directory로 복귀시킬 수 있다.

```
$ git restore --staged "file path"
```

<br>

file_02.java 파일을 staging area에 올려두었다가 다시 untracking file로 바꾼 상태이다.

![](http://www.mediafire.com/convkey/54a7/pln9p0sn3f2bed1zg.jpg)



`git add .` 로 여러개의 파일이 올라갔는데, 모두 unstaing하고 싶다면?

~~~
$ git restore --staged *
~~~

<br>

## <a name="git-log-decorate"></a>git log 그래프로 보기

Source Tree 같은 GUI 기반의 프로그램을 이용하면, 쉽게 git log를 그래프로 확인할 수 있지만, 터미널에서 CLI로 작업을 할 땐 어떻게 git log를 볼 수 있을까?

먼저 git log를 한 줄로 보는 방법이다. 

~~~
$ git log --all --oneline
~~~

![](https://lh3.googleusercontent.com/UMZ-qlsJ9Z1OwdSTKpiFkmbEQEh3d1kSHCNBDjnjwuJlS-JJZ5_aNNLNtEXSuSz1rnx6VkooxOZbfqb02dS-1yoFENVmbR5vSUehsHN9vHe2FgiOhs3yqGZo24RQvVCbT74OybwPWSed177XJbYv3mpbmVMLPuT5ed5W_dPKv5ZRnVTAzlbeS5vbfPry6dlFn31zfVRxGqipC9luG97F30aIqvzfOTKi_CLyBS-cyCGvUysoRX01R_p3StyH-f1f3XaxASpAtwChS0KxCK_9Prv9oAd5z4NBrOo6-px1m9C3r2cy_NcwEoKGn0E9mk9vgeCkwzo0p7jJ8fV1nm65Td77-pyjdcc436NlJorRnPOCpbkvPXEJhU3dyWCWsUbMS0k14XTa28kD_s5GsULdWGvzrz87Oe38sKw-gXmVC3g5ex598cI3bRyUYh8OrbaN7vjecAsl8z032YDV-eKsL_XhPz0LaS2FD9hMB0PcXAJ04vJRNxKDkXUvKTM7IH18Lwv77-actW4scADbcM7ZMsKwPXelDHFlDtqZgEOpMIQL6h4Pujewl6KUR-MXTP37vBVLK2YXr1c3ZTubzKayN0QhJd3OQj56r_zphSN_1DLBgTC4IzOU1G3Clojy26I8XF-gkYf1Q2vE0XbEl9TmdlzXfGCJHwxLm9H3R_6qkyBYZptSBVWIg89DCaHAByC1Daj-sjkyn6HuMb_Lt2KnvUtLxXGqpDGa4wzXimp4MUFQGLXajw=w1354-h1453-no)

이렇게 하면 시간순으로 커밋을 볼수는 있지만 브랜치간 구분이 되지 않아서 가독성이 좋지는 않다.



~~~
$ git log --all --oneline --graph --decorate
~~~

![](https://lh3.googleusercontent.com/u2dGkWciUBYLTknSWUafiNmjDCIfOnEwYd0jLdBJSHTNsRcLnXyJkj3KrN_eLsPU2cj7OLgK5kFpcmECfqbQvEbTX4barCkyC6YD9U4As4LFrkET16UZ26AT_Lzkx0d8pG4wxXZXkTDTAln9Dxq6S-Uqm84iX9klUf7szzxHk7rRgjCnjspAxzWzo8YKcbOHGOy5NSv5EnaYkqX5LbaSDxMQcfijJzlS37m7PcQFusZnQfZ6TrUGoNE7PIYQWHCNP7zndbg8AqGdzfCQIjOUy5RL8O6FnzmCgQKoP1uutsjqeVs2KN761FdQLsEKhgoqV3JnuYn11violqUUbOuMAG7uggIcb_EnrwQWBfTHAj0_pUMEEFRWZ_1-1maX_-y4FmY0cJ5bL_Wv0hb5TaVnJJoJAawo4y6_9OLBCYwz6WFplJa93N_0YWLBZEWjBkrjqxkOfDX7sTxf4QPj0A0GxT7i0Xnda9gJHypA1iM_R0W_RhBFuRVnTtejH-HbiQYeX44OXigXyNvtBuLQoN5vULJMhoPsaR5s9Zo4PJkzdf0x_RbK0Bq-6h26gu2sbxrr1pYhp5BJRCObdnq1wbSKND5i9e_T0HKztarpxH_gYrXHpzrzMX1b7U9ejv5eMcsuYfl6jT6gDd2AYZOFhx3F9BeOSjVzkl5933Mwf29noTERTbJsmjAWvINweu2tO54Pb38cRRcQYyK0ZDCucHpcj_TjDDjTpVdimhsVdXMDEN1VbeUsfg=w1347-h1453-no)

각 브랜치간 커밋을 구분하여 가독성있게 git log를 확인할 수 있게되었다.

<br>

## <a name="create-branch"></a>브랜치 생성하기

```git
$ git branch unit-Test
```

`unit-Test` 라는 이름의 브랜치를 생성할 수 있다.

<br>

## <a name="show-branches"></a>브랜치 확인하기

로컬 저장소의 모든 브랜치를 확인하고 싶다면,

```git
$ git branch
```

![](http://www.mediafire.com/convkey/113b/6naabezpnga2arlzg.jpg)

원격 저장소 브랜치까지 모두 확인하고 싶다면,

```git
$ git branch -a
```

![](http://www.mediafire.com/convkey/d579/to1uf1203n1i2d4zg.jpg)

<br>

## <a name="move-branch"></a>브랜치 이동하기

```git
$ git checkout master
```

![](http://www.mediafire.com/convkey/5812/m7xbdwsyktimcozzg.jpg)

<br>

## <a name="delete-branch"></a>브랜치 삭제하기

```git
$ git branch -D unit-Test
```

<br>

## <a name="delete-origin-branch"></a>원격 저장소 브랜치 삭제하기

```git
$ git push origin --delete unit-Test
```

원격 저장소에서 `unit-Test` 브랜치가 삭제된다.

출처 : [정광섭 - git 원격지 브랜치 삭제](https://www.lesstif.com/pages/viewpage.action?pageId=20776547)

<br>

## <a name="change-branch-name"></a>브랜치 이름 변경하기

만약 이름을 변경하길 원하는 브랜치가 선택되어 있다면, 

```git
$ git branch -m new-name
```

현재 선택된 브랜치가 아닌 다른 브랜치의 이름을 변경하고자 한다면,

```git
$ git branch -m old-name new-name
```

![](http://www.mediafire.com/convkey/e9d9/to6tbiwhaa0go37zg.jpg)

원격 저장소에서 적용하기

```git
$ git push origin :old-name
```

변경된 새 브랜치 원격 저장소에 적용하기

```git
$ git push --set-upstream origin new-name
```

![](http://www.mediafire.com/convkey/5d11/rpk9z3iwnxxto6czg.jpg)

출처 : [W3docs - How to Rename Git local and remote branches](https://www.w3docs.com/snippets/git/how-to-rename-git-local-and-remote-branches.html)

<br>

## <a name="rebase-merged"></a>커밋 합치기 with rebase

중복된 내용의 커밋이 존재할 경우, 이를 하나의 커밋으로 합치면 깔끔하게 `git log` 를  볼 수 있다.

~~~
$ git rebase -i HEAD~~
~~~

위의 명령어는 최신 노드 기준 2개의 커밋을 rebase하는 명령어이다. 만약 3개의 커밋을 정리하고자 한다면 아래와 같이 작성하면 된다.

~~~
$ git rebase -i HEAD~3
~~~



아래 실습을 해보았다.

세 개의 커밋이 있는 깃 레포지토리를 만들어봤다.

![](https://lh3.googleusercontent.com/wrFBPeM9IcBuWy-V82zcjWlkh4sBp7kCH76Eg5DQSNadJ7rr7Sd6OLkOXRBhrw5bqLLgqXzkufijOF-xsHlsv0dW84EhtFstG4DhfbIXssexZm-XRaimxLIJRCrUtWYHoFCahV5n6WJylBUttblKcy9z-vc3iDH2MSfzkBBtFpEtM5cpoSzifPUHFPyv3TskpfAv2PD1bSAVkphlkCb7gf-226wtqxcp8A_Q96zEtX1NtF0iELXu0QL3MhT6bUuZe0caq7XxDieGCU322GMqfo05bmYLgZF7qQnBy_98cN7S1MnsvZBvv5cZTaH-DeoF4aSfS4BPjnTx2v9IQg96TFHP4sKevjG5xKpxyjSYFu5KG-vtc8eSdB_adpCDzWou569iYOkaA_nIQNJwhNlgQjSuKqCJl07TXD62CtLaiSdSM1UBT-oMVOgSXDJ9kvZDtAsNz7GE4foIQnrYVarlOCqwfVn2_6ZFsTOPG4MLu_PLYHbgIS65BfO_m5VZ7e6Bvx4fbp3I1TYr9G1doOWSTlH9n8V02gZaWUUfnfmR5m6hb7RHaHsJHr92gbND0U0JVtBO_Qp2X2g_836yet9QGIKoUwta9HcRw4qwjwLnquB6ImztoYYXmuCxsg9azhytQUqAuEysm9-pGe7-1-kB7lhaLc_9lCs1dgZHHLkRrIa0W2gWrPOUXg-otco2NFwOlzx6OYKW4b4dqqSvtHmtJIEPPACc-5vAAGa4Cms0JMp7gSo8Ow=w385-h206-no)

~~~
$ git rebase -i HEAD~~
~~~

명령어를 입력하면 다음과 같은 화면이 출력된다.

![](https://lh3.googleusercontent.com/BvKCLTr8YJUl0Y8yzySJ31kZnUfGVuaAXBf7vGM4CmnVmPjPBTzA6hOMkVAhum38UytKb_gMefzqXmnjrWIChvBMEc_9qK2JaXX6VlRm3ATd15_pqQVDxMBZEE2mfWnSXgLdJi-RDeONELuWXQND8WtH0ca3VQYhrRHn6UhOuyyZ_bho6WLDwhgRvjQQTn2tw4Y-03iqOt8txzHS_URgqKviP8G8Kdzt74pVC0I29h9I_9JeW1j9hZCSqfEn42L0Hb0cFJDStnHlYJQlty9VooePVGOxlijy7RYOZmJgtavYcM-Am_pzPwbKcWmq2Rk4bIqwoyW9VVTGaSHg4SkbItexR2ht1zSVY-Dq4E-1zqq_8uXNZHIFRyURhV1k7uUC9gJJyI9ZTMKGeAiF8X-2svuuTiW6rWlcoOZ3jRV7mfpX6cganvjyNGwUhM-97jmD2_AhG36aHiOeqrQZaa5vmGuFz5SJoZfzGuiEQYb-5a4x9hvYHuG_KJJQ8gp5LpCTiUnjSJy1_xZ80XApjlc66Gel85RPNbeD2z9gC-3P03NSDlIlbzlmANVtKtrvRft19NFQdnhfphXdYdc76_IYk7okUIw0GwA_nSrDG1neRhBgUrrxu3s5XESu20azW7YG0dN_AvyZ3vI8BcoNbjE4AE7ej0bL2p92PYqQ5kxZ9nLN6OyB2LuaTMWoAusrlK2UiayWw8gTmHDHOykIYnY-Oou6XM6KFo0Fapkd_zrEnIkWmAS9gg=w525-h139-no)

HEAD를 바라보는 기준으로 2개의 커밋이 출력되었는데 `commit - B`, `commit -C` 순으로 작성된 커밋들이다.  `commit -C` 를 `commit - B` 로 합병할 생각이다. 이 때 `commit -C` 에 **pick**이라고 되어있는 부분을 **squash**라고 수정하고 입력모드를 나간다. `:wq`

그럼 합병되면서 새로 생성되는 커밋 메세지를 입력하는 창이 출력된다.

![](https://lh3.googleusercontent.com/MfifGefByB5T4WQGzYRR9aOVCtfw5sf_FopOrrR7omA5-r-Ew_i18c7CdI3ktPq8cv0Pkd1sedz5aIjsc2-gzjBaEshxyQogdMRP481HjTT_iGsR8gH_SSlFQylDMn8NNr-d15b1KVW2DODj3b4Aa13lcbnQpPh_QbLRrDQOCAmR52O8qAh-HIYDcF1zCUI_yZw3XNc-YKVzLUvyuLQ--5j28zigRKrX95H-NAlLF7k4x9MxIJ_iHN8raYqvlVX2O7QbvyGuIALPviRsSOfmn7DT8jcDsIah6Ieg3YG_eenAOfvgCh1u6wk1di9CKeM7jE6pIJAso3rmOIPIbVo3BSIst0lG-PQjQdgmNdmU76Y2kL_bSpdyQ9G0PZ5k41HRMj_HhHq4ztoq79eBUn6Drtr2pzj9uhPAh1oocMStJIY15Oro8Qs3ZFEGPhIvVX7n9yssMxdwTTzhr3QSpMBo05YmokBJKsSNuy76fpZReKl5NTiqrGLEDmBYkJBmDOOfZCqTwLgCqFNEi-iqXF7gpf9MKPRGWxxwudhMQLzNUmkLHUnuMzvPV4npe1WTPoXfb27c2tiUcexoS55nZuYO44e0yBefU34LWc1GVvMO7iInEfB674xxp3tsp5ZJukUrVi107MHXpYrLQ-BbnpySQi27k6-8kLaIUnygQGWEo4noiLj7j0dby1Cg8ETP2wy-Gvn-AOgSbs6zoXetVJWsSPUWbxRmUq2JDjlXf5IeAuliPBqgLQ=w679-h332-no)

커밋메세지를 수정하고 나가서 커밋로그를 확인해보니 잘 합병되었음을 확인하였다.

![](https://lh3.googleusercontent.com/phioJps6Zu6vum9scMQnh15VhbzDxTNAWinSj-QPuFcHyEHTxqMnqR9T4hvRKgZwP3b7u3dub1oS4PhA_hJa2Lv7u7rtnNdisG_ZT87TBTy25ejBJylUjJPmnDc-d4DBCUDz2tinJq5XgO500ljsTS_0hUQCyuSpU7E_4ozketYQOv287loie5cMwZZkgr7SKD84olkTUmfZsvEqaQz7bTcfSvmh3e_iyEHeph1d7xLUs8KsQS21C7wbq-BTn0zqhctl2b28eULgp4VImnxeH3UIPMmmgyNdT1EEk472Tt6ksBZuRHOwBgn4A1oAtINNs7eYU7pGU6y3tGN5SIvBx9L230FeSbOZHmHuvVH7vFqJD7HV-HLv4ra8Xq9Bmxro_6QosNjRklL6C3j5bQT2ZOSF3HHvUEHa95-MTRs8aDBHSNKgVF3HVp4v7YKh2V7EQ20lKg4vsmHUlJS6NOltb__P4EginGgiYq9JRQAUF5onlf8FITmIwmwk22Nj0IgN7Ftckte-uQRSZOJ_YaJRvvSWOdiJHvfP1NvynWHOUC0kbvnGPBRmz31lgwxUucfXn7q-wLOnk4gxDhiOZexyAEQVFT7sZnDVqUG5aK3hL6csEmY3RVFv6nBw3Z9x7QV5mY1mAsY5aRLZ16oyQHhaQtTA3NpvqofXQXfDFIZ1LtRQey3IGCFy0Md1Sk7FC_AHD7UuKtCb-khiSyEdm4HBfTp2qtdCCprTNtPuxgU3MrNA7Pibsg=w809-h320-no)

<br>

## <a name="rebase-change-sequence"></a>커밋 순서 바꾸기 with rebase

커밋 순서를 바꾸는것도 **rebase**로 가능하다.

위의 실습 레포지토리에서 커밋 `commit - D` 를 생성했다.

![](https://lh3.googleusercontent.com/DM4Z5n9HpqnMw7upbjSQV85VY18teMzJJsb3zfoVfD7H2OVhhmvgUpR6JJRJF2idRT4jtmG5TXd5Z46OCDfqgaSKR4oIFqnGVtQmJZXTgru-fG3_-QHBFymm5sJKhss3g-ZDyjF2QB5yGjLVTwnVjhRKdXbE5JlPrIP_GFI1_7tdcNuBykzaScnnk5DVxRJqukY7eRH2FFJxJOa_-EjRc-QLngZPz9conAvqPOx7r_Ftt9x2fXYRMdNPzczZoiYM48ATURddHur8tkK5oneccNkVKQV_pgvzzhOg40RTnmTxVSj6nmaOkvoDyDzISTClvPuggRXvElgTPmxdOl36NM0_hN33y8qmDBPeX765wbxxxAmcH3I5Ps-Gf4NUB4d25t91GS2hZBOgRjEWG7aexwZ149riQjKUyzYlifIo6xE8Mpy1L-1-F-eOGKBIxDvXci5CIv5o27FA6YmOku1RK9vVEUuFalpKEqGfQyu8URUFBup2tpjO5UCIih0ntqV0OFLaiNTa65_S74YrE4n-qqAMEiWpa3VPBjj3oMoGXHLyA0Nk4shq6lwLsZRYnFvrIUCjxYautJKtVtxFHzkpqUAP2tCnoXrTcdgkIp5IfjbVJcLf34zjThCE9N0Mz_a4fldxzNCTE_FCoN9sHL2YDYjFzTwwPE4c8mcmNwl8UMoARb-iNnD6XB2VwTj6ZvQyf02-f8EwslGJLBHTQv0meO3fyI24VIymd0pAQnxHIT-EcumFtg=w811-h456-no)

이 상태에서 **rebase**를 시도했다.

~~~
$ git rebase HEAD~~
~~~

![](https://lh3.googleusercontent.com/gv99OY72eT07pXHGwMrncAuDDDu58qnk1xSz9nmMFiyWGm7SSn6MqReUKLeERRLWmc4ar_hA_CKCGbMOrwmyKOw-gdmoFTLjSSC8YcBf76dFMBtDl1rEhGH0Lf1xI-WektXHTWCetiL2w8PnkKUoQNgYi7GU2cJ4Chhf66hPn5B9a87cYlzvf8fd6QhdqzwnsoBb3cTRiEYDq9oUKPYZeCSJC8kOxkw4pmRu5LkDUkg7eWHyud8PEQ_g7xd8I4-i6o3rMTcAcz-Kb3cIgtLcHaxFmY7AfHfmOuv9HRFp3F-7kUKR-a3fNl3xMloxZa2XuYUkO-HVrNJqYOJRmFsdAbmRk_Z9Le1T-ViFu0sKwPICeHWns83h-NlodBsKfkOtiJYvzu3GeVcs9ZwWQXveKaBZZGfyxxrzPZhZJHkz70OVHWJdeW5N2Jo7FdAJlXxIXvLPTltD4fmOkKVk8Llvqim9kVhOZ-tbDqCZ7TbJm2k8EZFegINH5qedq6ak8g8nAJkUIk7dSSDl5ixjl3hTBCOZgIYRBK-7S6shbsWU6BIEFIZNQqz15J5KDRLOolKdJk3PMXfDGArSUiSOm__SIMCUaY0yuORzdrVjBKFiX-loVtRqFxWmhT4oyraoHH1_X-CdGgNsdOsc1kJA-GQ3jZMRufpotIxcDT9HeqmzFmcFdngsX8TxNtdwdRdz1ZMRPy2e-y1W_UJw3NIl4AKujNq-hv4oBnxQzoNL23fQIjEcWgNhjA=w526-h134-no)

여기서 변경하고 싶은 커밋을 순서만 바꾸면 된다. 리눅스 명령어를 사용해서 쉽게 바꾸었다.

`yy`(한줄복사) 로 합병된 커밋(`commit - B`, `commit -C`)을 복사하고, `commit - D` 아래로 `p`(붙여넣기) 를 눌러서 붙여넣었다. 그리고 원래 위치가 변경되면서 사라질 커밋은 `dd`(한줄삭제) 를 입력해서 삭제했다.

git log를 확인해보니 순서가 제대로 변경되었음을 확인할 수 있다.

![](https://lh3.googleusercontent.com/UyHO-dqZK4R_lw7NI4Ma6pN7pxyl8nnORSlElcVmHnNT9WcPvih3jyYwZpyk4R2yuuzcgcsF03kjfJZZIyJTFmzvGF7HWQeMu_hXFUwi4DXhV6ZI_iYvKmvqkRc8AZq9WU3zHaZdhZzlIKeRDvZcPDx4ZV2d3BRmT0ohbwPlfCmgnu5FpMpoUqscn3llRWr6zy7pjISzSSMxASSi7afRLFG-9PYuKT1chgniWLVX2QlN3iwlDwt0gjK0Fk8MK8mnaQtTvtZmLN8us_4cO7-QlmVhCo9QJg-lb0yDSMxxh-3tLR7QRO4QUKvc0rRvwF_2Sg8xsMPOUtvCS0U43yQv7lEAUMeErkX2zbihyOXvP_fQJ2r1W9HaBUgwJelFFfIjx7eA5xierPeZYr27YbI2mmdda-okxkE6Qdn31RTm0dznSNNIKT_UMJCdBAikeMXp03fbyC_ndqu1_7twPAmJ_h3R28SSTyLs9F8N1jkcQnfZx-xYq3XR9PvgQI3ibxChiWJjZEGDU7NY3ZQu-qTtrDYvLLrHABUV5DM9qo0KFQvhJfpF7WHGAMZWsczocT8KtV2b-dxDfOQmDw7kGfXw4EeJ9nN_1Tpr9Q1ne0nKPZiVmFetGCr7HSHm8_GxyNUOepTpyWMOQ3uD2lMxr46kKEa2jshmyHwmb0RGGhFkk_kGOv8NRO29LzSW7g8xr2Wke5Mc1E6xHmYXE_oB0suYEPhotUSNKnE0GNrYv1RvySU61B1GGg=w809-h447-no)

<br>

## <a name="rebase-change-commit-m"></a>커밋메세지 변경하기 with rebase

~~~
$ git rebase -i HEAD~~
~~~

![](https://lh3.googleusercontent.com/yolPt_hdMMT_qlu4CKvUe_FeO_GeToFXzNM7WJDvc3b8_6BY8Pez9XyBHCI9jZ8lBJ-VGsx3R-tAxQAe2W_43Eg7YZJbU006fGjTDjMdiLo9e0es8HbsXJnnv743l8Rj5ZcS38dIz9pjw2PdAjAQQSrYM_YY9vvpYlnHgX9IXAdwktiX6wjyxslqfJwVxxyWB2k7DmLyycYsEwgb3XM9X9e6UzGZZf8IZ5I2MMkcHQFedQSC0fuCUAiKus29cjp0ytFt9CMSWNpfIRLeC9njdz434GNmvHp4Lf8Osrv1UKHi0pkFbze-mtCzS9AxxARA0q7bPAt4-0cZu-Vxk14XxP-NkOK_rZd2DperDn3ADAWcoZvezUxp8-zQIK1mNFLx9T-AtZNC8-gvBCwrmST_5RO0KEr8oMjoUXRJux_fkkb5TtwZVkXLSqG3lNERqpfwE7HYD8Hcg8VnTM2_gnVTMNw8IESxCFCiJ8FuVaRdVrvtBHsn3qpPDkWeU1timHmv_DCX94nQaGxwkBiAz0c2m5J2RSKjc53MCejcUXyxutFFDdvYXdiIOGspnT0ZJPR19lIiREiurfQg7nohIsvCEmH2Et-5gtQVOAv0jHBXOF8JCB6clh3mHs0rJoL79Z8JwFdDLFFPNkQvhgI02ZMiQIjgCRU64Y3wUB9Op4IDTRd2rt7o-tyss_8lIJQ4JualjUzRSYv6UkiXqrHm2vY6FhLJL4ekMuIVNLWlCNvH0FSDOt93Rw=w536-h137-no)

**rebase** 명령어를 입력하고 화면이 출력되었을 때, 메세지를 수정하고자 하는 커밋의 앞에 edit으로 바꿔준다. 그리고 입력모드를 나간다 `:wq`

그럼 아래와 같은 화면이 출력된다.

![](https://lh3.googleusercontent.com/7ykSpSc1fV1iwMWl_cLklSq_9kR16045Q2F0N-nXoKY55S3ZqmnwAZAXH9ElY9jw1RZyHDIhbgvOAiF53oYGGaPQzYVk3EwqyOyhOHi6uRut0VddfyHKDXPCch1ylGDkZrPs1qHXKQWMXFPjifpD7Dtu0xiz6d2blajIpRqJLYhEGpAH_njJQDACNZfvKxNBaqTw8aJtz91F4hQsGg84I884rX8UgRRzC3V_V5goWqChS8-BnluuZ0GePGxGGC93YblC2hDVP6cNC7yB9nlUq1ESeVfVvDnFOr9oo7SrTF6h75kmaa1nVOcg3XUAwnlVaqx193oMWgMY3eGGUiHiW8we9UJBp_MZLh7Ge61F_1FqO2zhdAIbeVZ-m7TG1sHLXPnjgL4SFbRr5eVpJ5uJ80kfNGX4hSW0cI1xPhoLslZtT-zdFQNmXLl_2os6-bO3WeRSEseVvCvR50ip_r_erIQm_QEvzJsef78NvTZlYvGDzB0EL5mYGMhy7nV7RwDpu0K8mBCCuUnjZOwdV0zTfKlGGp6SNnojIBmw9GItLuIjO-2sFGmacdH_clYKLmBrmgWTd3jXXX5WQaiSaXbJF_TECtn4jLk1WN_bXPkJ5MTziPcba8a6tl1aoB2jpTClpBxyTht6nwlpFWjKvvxHwks3mdIpMDcYtMzLh1J_XR72jAc0zA0wVp_gBdG1DM7lCNk75va1ed0ZNdVRrqXGG7T2BWVyG6_BakOWQNvmL0Ue9_c2YA=w594-h197-no)

위의 메세지대로 커밋 메세지를 작성하는 명령어를 입력한다.

~~~
$ git commit ---amend -m "new commit message"
~~~

새로운 메세지로 커밋 메세지가 변경되었다.

![](https://lh3.googleusercontent.com/4GusG71YPR9n8dof7TDBkUosSNPCUPEyn8OQkuOgM4y_hKps1yWXpH_k_4KPCf-C8dnBSOjSi4x8u9XI-OnemuU8pPV1SSX5bWAtETSJrHBjRbPM6kKv4ahGDXelqwCE02GAW7IIVRqT_JLW6ZPOesUVIebx6u29vvWne518J2UWPrGq8octTwvKlCPDlW6UYhvnRcsPmWU8JfUcyJmWiESRVySCRPMNNfywYDVaq3vAmh9moogXAorGGijxiW1mW_Igp9-M6vWM6oxXfqgwfzw66YhFm3yq2cTGSrkc_fKbaMnhdkTCKnf2_1UHc1K1G_PBRH5rl2kJBt155Pz8hU2ehpzLFkVHJ3chWDUh7JyGZXzhxIgFhHqemLhJM5dVHYlPSV5hyHKkwousEUysz6yhf66betz2UYbYS1PVCVjLXtviM2WswEp83MXLnDtbjk0RH2xAzimyFSxG2eOwp4p76pYCktX04DKgLY3aLYl5HKYMqBLvfNTODaphJ9c7LavCXuleFy-sbBhyeQjGn2KR68niaco7L5XKeeAHw2p5pceJCOiSRYRgjW9PQbE2SBnE-tSHvdLH_nJZzNM5jAPrPQexhE2-pTf81NwtZ7OKwAG9j9vExkkN40KyTe17dFQtgm7Ub5T3JxjEUo9h3rYW0KU-8YYiBVD96xIYXDpBEwVR747Bq1GvABoXt1RhScsf4SeU6MHBmea1uPhabHnGu8TqobbnJYRn48wLKtGCL0KS4Q=w808-h427-no)

<br>

## <a name="set-url"></a>원격 저장소 변경하기

로컬 저장소가 바라보고 있는 원격 저장소의 url을 보는 방법은 다음의 명령어로 확인가능하다.

```shell
git remote -v
```

그게 현재 로컬 저장소가 바라보는 원격 저장소의 url인데 이걸 바꾸려면 다음의 명령어로 바꿀 수 있다.

```shell
git remote set-url origin https://github.com/youngjinmo/youngjinmo.github.io.git
```

저장소를 처음만들고, 원격 저장소에 지정할 때의 명령어는 아래와 같다. 아직 지정해둔 원격 저장소가 없을 때엔  `remote`와 `origin` 사이에 `add`를, 지정해둔 원격 저장소 주소를 바꾸고 싶을 땐 `set-url`을 붙이는 차이가 있다.

```shell
git remote add origin https://github.com/youngjinmo/youngjinmo.github.io.git
```



그리고 변경사항을 푸쉬하면 제대로 이동되었음을 확인할 수 있다.

```shell
git push -u origin master
```

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

## <a name="git-pr"></a>PR

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

## <a name="git-gitignore"></a>.gitignore

git으로 버전관리를 하다보면, 버전관리할 필요가 없는 불필요한 파일이 발생하기도 한다. MacOS에서는  ".DS_Store"라는 운영체제 관련된 파일이 생성되는데 이게 저장소로 push되면, 다른 운영체제의 contributor가 작업시에 conflict가 발생될 수 있다. 

따라서 이런 파일들은 `.gitignore` 라는 파일로 버전관리목록에서 제외시켜야 한다.

### 1. `vi .gitignore`

vi에디터로 `.gitignore` 파일을 생성한다. 그리고 버전관리 하지않을 파일의 목록 또는 파일의 디렉토리명을 입력해두면, `git status`에서 확인되지 않는다.

![](http://www.mediafire.com/convkey/5bf7/95y9yh7c0yhenfqzg.jpg)

<br>

### 2. 버전관리 제외할 파일 형식 추가

![](http://www.mediafire.com/convkey/393d/uwzge9q8xfrx84izg.jpg)

`.gitignore` 에서 `.DS_Store` 파일들을 버전관리 목록에서 제외하라고 작성해두었다.

그리고 git 명령어 `git status`로 확인해보자.

![](http://www.mediafire.com/convkey/1712/ut4pr6bajecoodtzg.jpg)

더 이상 `.DS_Store` 파일이 보이지 않는 것을 확인할 수 있다.

<br>

### 3. 이미 원격저장소에 들어간 파일을 ignore하고 싶을 때

이미 원격 저장소에 들어간 파일을 `ignore`해봐야 반영되지 않을 것이다. 이땐 다음의 절차대로 하면 원격 저장소로 넘어간 파일도 ignore할 수 있게된다.

1. `ignore`하고자 하는 파일을 삭제.
2. 새로운 커밋 생성
3. `.gitignore`에 파일명 또는 포맷을 작성해서 ignore.
4. 명령어 `git status` 통해 확인

<br>

## <a name="git-config"></a>git config 설정

로컬에서 커맨드라인으로 git을 관리하기 위해서는 계정이 필요하다.

~~~
$ git config --global user.name "이름"
$ git config --global user.email "이메일"
$ git config --global user.password "패스워드"
~~~

git config를 저장하는 가장 쉬운방법이지만, 보안으로는 가장 취약한 방식이다. 

아래의 명령어를 입력하면, 현재의 쉘에 저장된 credential을 바로 확인할 수 있다.

~~~
$ git config --list
~~~

![](https://lh3.googleusercontent.com/ylZk8OqZsTmAcSjYPzFtx8_-3DSTG7cTG28pmk1DKxfQ9Bxf6h19M_Iq5im1-cdMUmpU3jSVFd78JAa8W4wHJ7_0SfQ4frGEbE2_jIMZ2wBU_CTstFP2TPlzXjJoJJ9J1OoNgdkFXQl4I8f0S8c6wqAWl4p-DnQtUrWIvTheeMBJ8PRdamb7KlSl9xsCGRUxLZ-R9HWBkPG2pvDwsvkZ9S_nSI7_hUXwh6QbST7STvPDKdywQ5XTwZ3OfeSWI_rlz0h3di5b7I2Xdr6LUoHFDoyxSbm7GKhyORnUg3e_WYrx1oXVJIoYISFMoBq_BIbKgooCyzLnv3X8D6YaK1bfQS6d71SMS3ZrXeN89zAZoSWFWCQPH8u_i1XT4qLEG9JK8dZkcBHgoL0EaKP_705HzOUVdk1DGrQ_kMazaUk3RzCVV_KAOU_zcC_7N6FsZJ3L2a9cPDLauGIaTyekC3ERtda6Wuf4Y3lqdT7ym0Q0qD43vcXvnG0VXwzmWZOZfvZlmp5Qff6VD4-FF3BAIm5LtgmfhTYfY719OGV5kTaHZ614tmE7vsNz3uYtT_2F1wcn0-mD6x4xWRAe_tFHiJIh3Ses743kAVBfrYdZu7G7TI9sKe02_eEN5k3h0pT045zKtIFRLbO_FcMB7RMARmp_eJ82wwHpjzFUHr8BtG6urdZQ3oQDd0wY_bo3Jdx1F_r0S0byZUNyIuT7AeKLIxvW53ebfOSk9yJdFRHN9mzAbvMbpiUohw=w551-h222-no)

패스워드를 입력하지 않고 바로 확인할 수 있는 방법만큼 좋은 방식같지는 않다.

## <a name="git-credential"></a>Github Credential 저장

Github Credential이란 Github의 계정정보를 말한다. 

저장소에 push/pull 하거나 private 저장소를 clone하기 위해서는 해당 저장소를 이용할 수 있는 권한이 필요한데 이 때 credential에 계정 정보를 저장해두면 저장소 이용시마다 로그인할 필요가 없다. 

터미널 명령어는 다음과 같다.

```
$ git config credential.helper store
$ git push https://github.com/repo.git
$ Username for 'https://github.com' : your github email
$ Password for 'https://your github email' : your github password
```

출처 : <a href="https://git-scm.com/docs/git-credential-store" target="_blank">git-scm - git credential store</a>

그러나 이 방식도 [git config](#git-config)와 마찬가지로 안전하다고 볼 수는 없다. 보안상 추천하는 방식은 다음과 같다.

<br>

## <a name="add-ssh"></a>Github에 SSH 등록하기

쉘에서 SSH 키를 생성한 후, 이를 Github에 저장해서 사용하려고 한다.

<a href="https://ko.wikipedia.org/wiki/%EC%8B%9C%ED%81%90%EC%96%B4_%EC%85%B8" target="_blank">위키백과</a>에 의하면, SSH(Secure Shell)는 네트워크 상의 다른 컴퓨터에 로그인하거나 Github과 같은 원격 시스템에 명령을 실행하고 다른 시스템으로 파일을 복사할 수 있는 프로토콜이라고 한다.

<img src="https://www.hostinger.com/tutorials/wp-content/uploads/sites/2/2017/07/asymmetric-encryption.jpg" style="zoom:60%;" />

SSH는 암호화되어 통신하기 때문에 통신이 노출되더라도 안전하다고 한다.

<hr>

먼저 쉘에서 SSH 키를 생성해보겠다.

터미널에서 아래 명령어를 입력한다.

~~~
$ ssh-keygen -t rsa -b 4096 -C "your_email@example.com"
~~~

그럼 key pair가 생성된다.

~~~
> Generating public/private rsa key pair.
~~~

이후에 프롬프트(Terminal)에 입력을 요구하는 메세지가 출력된다.

~~~
> Enter a file in which to save the key (/Users/you/.ssh/id_rsa): [Press enter]
~~~

엔터를 입력하고, 

~~~
> Enter passphrase (empty for no passphrase): [Type a passphrase]
> Enter same passphrase again: [Type passphrase again]
~~~

기억할 수 있는 문장을 두번 입력한다.

![](https://lh3.googleusercontent.com/v63aRqQ4LEVFAmB9KQeiKheT0Q2nk6Ssc3iftUuxt3dUhcCt77v81UCSHH_e2p_SJZPd1XuVfoUT0kgkRHEDPCMmHU2T0MpQxSFNg7gE3Qsbp38ssEIyiAyTmAd4-aInYdbciY7OuekcrVOtA1g3aY8eoykkywJQVfz3J0wGGvzPI11L1UdgxsN1ufHRZ5ZZkrAAr93v0LIh_CcF5aiaxvgIrZEKaUkoGoDL_u61fxQdKihyCoOOBPL_fJCPvT5ayRl_gPLX79iR5GRSdSfDNj15ZohJVe6g2Gt1MkUc6-bQQZ1A_aFq1fBMvQvYmUTUrKmzFugOpSkRQzlhu5Uexk5puSPElSDZh0E9uPN-S0gQ76imL0Iy8ghRVkDJf0hzZR9f1x5dcvbWAAftU-oO2rmf8uCELhsWSKjUispLqoZplM0FahKb7Y-oQa9pR73RrWPYaHEXomc93n_Td4ZdHMv3-dI3ZMwDdRtBq3yoOTJgAXLQxNTYQXc6Yt6hSLHmLWGBTJWUG2cbMP2Uj26AShI6jauybl1Ld6JbS-06i_chUal9YYN8bdznUjvxbx8PNia44kpLoOsCBbcYki1JWqpHdVeI5PHUIPlewkIdb4Q_8DdBx1Xfo-4iI9ODDBpOY5uLPMz96Bx3xGYvAZq9ZJtA0VnDVKaJhlC3bOPtH_4TcB8_kFw0MbcQBDic6uHGP3f0WKPt8d_axxqi3ZyB_HM-ae_rAoz1esIJFeK5J4ephyOqdA=w720-h437-no)



그리고 터미널에 아래의 명령어를 입력하여 `ssh-agent` 를 실행한다.

~~~
$ eval "$(ssh-agent -s)"
> Agent pid 59566
~~~

pid는 리눅스, 맥 등의 유닉스 관련 대부분의 OS 커널에서 사용하는 Process ID라고 한다. (<a href="https://www.2daygeek.com/check-find-parent-process-id-pid-ppid-linux/" target="_blank">출처</a>)

![](https://lh3.googleusercontent.com/Dfsh3V9UQhKtZV9NGO8BToyaYoPrhr-eJmF2x3uOTgopDio7mwu6W3DpntTz7XqTWoNlGeD16tFaidKP1AQsm5uIwYaTqGB3zyP9gq2iZgURQyt932OqtybGOdw9OUocpztle3Ky6EmXHX6Z2OkYdnW04zVIHp47uxWVu1yYDTWUZRFkPBT1MvPE1t7qGei_jJQ2w0ycveL-G9RmDB9PWLRgz2WtiKMUjKztO2INalCbHRngNCccJUWCADkYZg79AjiWoXvJ-lNTwqxIzzHOutpUbGiNA679xMSX7Frm9brWu2fN-ycCl7_rzmJRF50KngwtjbxImE7D8z7z670AA27Y_97gDJLros8Hp-CR6LpFF61fDERP7Bmn4Fh3FZc838pNCt4KoNi-Ey3fJAEdulntVJAaWL0_8gUraY06W89ElEi5Tgx2QZTT65Kqa6uzQlP4nL--jnsKWOgPujkcC0mwbHaXAn3SyoJFLmj0GmEBX3FpQR7_9BOSkUOjLkQwEh7VXpu3vEo59sEITrnanfMJYg899dR1CICqMtXFcM7peU0E15N2019sqF9nvV3OwrQg2ppwUik0vYn-5ijK0x3htgajHbnYZ1oVWhOG6Do0vW1EvQLD80gUWNU0uMWRveD0u-BAWxOj6D8XSAKswjwbykt-Vn5MSorfcuviQlPMrVcVYwvHqAaj8xQd72cFkWlCUFqu_jFQnLN-soj8pA6Xd_aq4yF2XaDI6EXL3P1Yy6bcew=w701-h199-no)



그리고 시에라 버전 10.12.2 이상의 맥을 사용한다면, `~/.ssh/config` 를 수정해주어야 한다.

~~~
Host *
   AddKeysToAgent yes
   UseKeychain yes
   IdentityFile ~/.ssh/id_rsa
~~~



그리고 SSH 키를 `ssh-agent`에 연결하고 기억할 수 있는 문장(`passpharase`)를 키체인에 저장한다.

`ssh-agent`는 리눅스 또는 유닉스 계열의 OS에서 로그인이 필요할 때 자동으로 config 를 도와준다고 한다.

~~~
$ ssh-add -K ~/.ssh/id_rsa
~~~



이제 Github 설정에서 방금 생성한 SSH 키를 등록할 것이다. 

생성한 키(`~/.ssh/id_rsa.pub`)를 복사한다.

~~~
$ pbcopy < ~/.ssh/id_rsa.pub
~~~



그리고 <a href="https://github.com/settings/keys" target="_blank">Github 설정</a>의 왼쪽 메뉴바에서 **[SSH and GPG key]**를 클릭한다.

![](https://help.github.com/assets/images/help/settings/settings-sidebar-ssh-keys.png)

**[New SSH key]** 를 클릭한다.

![](https://help.github.com/assets/images/help/settings/ssh-add-ssh-key.png)



**Title**은 입력하고 싶은 이름을 입력해두고, **Key**에 아까 복사해뒀던 키를 붙여넣기해주면 된다.

![](https://lh3.googleusercontent.com/YWlsn_mpoKC7bZollAK0EZQqBJGw5uGcPMB_lVF-xt7ZsDYRbmmdMiyHbNhZTXLkzfRFslXUaHaLIIVfs8Iqd3-VB2k6HXZldkNTnWqy38Vr1XeXGKQDCg35ZhduuVE82w9yeAPqVgHv1lql0Lj3eOSWXM8asS8p2GRVEI2nDfTHl-wLvFOazAEN9ufQYqeZma3uj7S818kltFpDOMKqrlQSeNmg23raoPZau1Xfi1s7oyhmE8sooK6S2SoZcSh62RUJX-bckkA4oq4SBjGAtb0mQGR6iTRTp7BDnSiKeVUs6nVEgMHGy6QmQ_y3hrXrmtGBTJdfqfMNGRcAWTFSgF068TNqzB9a5OROgcKLYPVOI7VAbITM2blPkMJYK-_KWUHfrOKabHKFzIqpkoFWnKZdBzJmxY4lbuDSwOKv_TBMY8KEC5ofLgWjDQxY_8ySQ7RiU-s3L-UonhQULoloMc91T65V8tLTJDH4aA7w6Pqvob-kQ4DpOja0BUsKd3yMTQSMlhgEIImUKc_pBz6a97Lv_vtujuWD4h8v4ou3O_mFFIdtlbS68M9ZUmrDzC3EVoKEWrF47ksJEdmJp507GQitdPWDs2JM8pnkAVlTpFCMHBsiZqPKXlrFu6TkvjGt7TGIGdoD4yMImAtyByEwgqBkdIh83CDlv2Ge2HN8Mt0LWISOiCMBT0UkVm7_982eqil_uwc4lJPzcM7vfGsL4HsPzwlKZlAEQ6xHvZ7vmoP7Q3fytQ=w1024-h541-no)



출처

- <a href="https://help.github.com/en/github/authenticating-to-github/generating-a-new-ssh-key-and-adding-it-to-the-ssh-agent" target="_blank">Github Help - Generating a new SSH key and adding it to the ssh-agent</a>

- <a href="https://help.github.com/en/github/authenticating-to-github/adding-a-new-ssh-key-to-your-github-account" target="_blank">Github Help - Adding a new SSH key to your Github account</a>

<br>

## <a name="license"></a>레파지토리 라이센스

깃헙에서 오픈소스 레파지토리를 보면 항상 보던게 있다.

![](https://lh3.googleusercontent.com/gyhdw4OLgqZO-G4R2ntt6E3SMw4XDwUdG8TUdhhDCY8ApFyD6JhOMyUaJ_A3hYCz4-uQvJWOiHH6VcPwrCwy_jhobHPuWAGI4jvx94KphmXntVGIjdR0kKDdEbwX7js9fKujH4C4dnfRMaeBJzusgkrn42vkBEMD9ESKuK-3z2GaB53vVNke9WoLdNIDE-dCfUCRX8kLkmUjOOOhDdA-cQ2O1onwNReV0FVbwD6JcYamhjnpMq_RJdGzLoI67LuoCANWnHtI3yc-I0nUDfhpaIXkBMBR8rCygE2IeRRkJIX0dlKMJvf4TJgpEMVxiAx3ZWcvVrCyowo5r3G2Qmes1dR06cKVDD8sHIRT0nogcjX6i5IU_X4fU7Qd4b31cmcs3ElxWXaF-Q6XNMCpRfVf2krkBg2q5ljwOPBg2LSOgWG7qfTDIVzxL42uZUJYRZ15oQylZ2OvjJhgIz1w8SjCo0McBoiRf93yCxhTaRdaKz3NwJlYZENYLahsfQ0F62L93nwSqCgDXEpCDo3j4eYk9uyjLCwOFZZUOZ8Pvzzt3nAtcJACCWkNSYVHwnulEP19fO7ZD_EYRVZZ9xgfSUOzPX0V5kIRMiRfMwLP2Ow2wz5Pi6zFuXFdYY25nzUBw1_24qfp22_mO_xchLe0ZRTcnVMiin2UmDwWpE61x0voayZF5xrlk-gIZn7LjVqtsHDU2AlFcKtRghstN_NfbD-iocKD906XPL-UesgfjU3b5vaEDeu9=w640-h234-no)

오픈소스에 해당하는 라이센스의 최소한의 기준을 정의하기 위해 OSD(Open Source Definition)를 정의해두고 이 정의에 따라 인증, 관리 및 촉진시키고 있다고 한다.

### License List

- [GNU General Public License(GPL) 2.0](#gpl)
- [GNU Lesser GPL(LGPL) 2.1](#lgpl)
- [Berkeley Software Distribution(BSD) License](#bsd)
- [Apache license](#apache)
- [Mozilla Public License(MPL)](#mpl)
- [MIT License](#mit)

### <a name="gpl"></a>GNU General Public License(GPL) 2.0

GPL은 현재 가장 많은 오픈소스 소프트웨어가 채택하고 있는 라이센스이다. 오픈소스 라이센스들 중에서 가장 많이 알려져 있고 의무사항들도 타 라이센스에 비해 **엄격한 편**이다.

- 소프트웨어를 배포하는 경우 저작권 표시, 보증책임이 없다는 표시 및 GPL에 의해 배포된다는 사실 명시
- 소프트웨어를 수정하거나 새로운 소프트웨어를 병합(Dynamic linking 포함)시키는 경우 **GPL에 의해 소스 코드 제공**
- GPL 소프트웨어를 배포하는 경우, 소스 코드 그 자체를 함께 배포하거나 또는 소스코드를 제공받을 수 있는 방법에 대한 정보를 함께 제공

### <a name="lgpl"></a>GNU Lesser GPL(LGPL) 2.1

GPL 라이센스를 사용하기만 해도 소스코드를 공개해야 한다는 부담 때문에 단순한 라이브러리와 모듈로의  링크를 허용한  라이선스이다. 원래는 한정된 라이브러리에만 적용하려는 의도로 ‘Library GPL’이라는 이름을 붙였으나, 모든 라이브러리에  적용된다는 오해를 사 2.1 버전으로 ‘Lesser GPL’로 변경됐다.

- 소프트웨어를 배포하는 경우 저작권 표시, 보증책임이 없다는 표시 및 LGPL에 의해 배포된다는 사실 명시
- **LGPL Library**의 일부를 수정하는 경우 수정한 Library를 LGPL에 의해 소스코드 공개

### <a name="bsd"></a>Berkeley Software Distribution(BSD) License

BSD 라이센스는 GPL/LGPL보다 덜 제한적이기 때문에 허용 범위가 넓다. 가장 큰 차이점은 소스코드를 공개하지 않아도 된다는 점이다.

- 소프트웨어를 배포하는 경우 저작권 표시, 보증책임이 없다는 표시
- 수정 프로그램에 대한 소스 코드의 공개를 요구하지 않기 때문에 **상용 소프트웨어에 무제한 사용가능**

### <a name="apache"></a>Apache License

아파치 소프트웨어 재단에서 자체적으로 만든 소프트웨어에 대한 라이센스 규정이다.

아파치 라이센스는 아파치 재단(ASF: Apache Software Foundation)의 모든 소프트웨어에 적용되며 BSD 라이센스와 비슷하여 **소스코드 공개 등의 의무가 발생하지 않는다.** 다만 **“Apache”라는 이름에 대한 상표권을 침해하지 않아야 한다**는 조항이 명시적으로 들어가 있고, 특허권에 관한 내용이 포함되어 BSD 라이센스보다는 좀더 법적으로 완결된 내용을 담고 있다. 특히 **GPL 2.0으로 배포되는 코드와 결합되는 것이 어렵다**는 문제가 었었는데, GPL 3.0에서는 이 문제를 해결하여 아파치 라이센스로 배포되는 코드가 **GPL 3.0으로 배포되는 코드와 결합하는 것이 가능**해졌다.

### <a name="mpl"></a>Mozilla Public License(MPL)

MPL은 Netscape 브라우저의 소스코드를 공개하기 위해 개발된 라이센스이다. MPL에서는 링크 등의 여부에 상관없이 원래의 소스코드가 아닌 **새로운 파일에 작성된 소스코드에 대해서는 공개의 의무가 발생하지 않는다.**

- 소프트웨어를 배포하는 경우 저작권 표시, 보증책임이 없다는 표시 및 MPL에 의해 배포된다는 사실을 명시
- **MPL 코드를 수정한 부분은 다시 MPL에 의해 배포**
- MPL 코드와 다른 코드를 결합하여 프로그램을 만들 경우 **MPL 코드를 제외한 결합 프로그램에 대한 소스코드는 공개할 필요가 없음**
- 소스코드를 적절한 형태로 제공하는 경우, 실행파일에 대한 라이센스는 MPL이 아닌 다른 것으로 선택가능
- 특허기술이 구현된 프로그램의 경우 관련 사실을 **‘LEGAL’**파일에 기록하여 배포

### <a name="mit"></a>MIT License

MIT 라이센스는 미국 매사추세츠공과대학교(MIT)에서 해당 대학 소프트웨어 공학도들을 돕기 위해 개발한 라이센스이다. 라이센스와 저작권 관련 명시만 지켜주면 되는 라이센스이다.

- 이 소프트웨어를 누구라도 무상으로 제한없이 취급해도 좋다.
- 저자 또는 저작권자는 소프트웨어에 관해서 아무런 책임을 지지 않는다.

출처 : <a href="http://guswnsxodlf.github.io/software-license" target="_blank">오픈소스 소프트웨어 라이센스의 종류와 제약</a>

<br>