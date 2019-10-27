# AWS

### 우분투 EC2 인스턴스에 jdk 설치하기

- `sudo apt install default-jdk`

  - 구버전 설치할 경우, [Oracle Java Archive](https://www.oracle.com/technetwork/java/archive-139210.html)에서 버전을 찾아서 설치.

- `ssh -i [aws-public-key].pem ubuntu@[ip-port@aws]`

  - AWS 서버를 실행할 때마다 ip주소가 바뀐다. 바뀐 ip주소를 입력해야 정상적으로 AWS 웹서버에 접속할 수 있다.

