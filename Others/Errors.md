# 내가 만난 에러들

하루에도 수십번씩 만나는 다양한 에러들을 한 번쯤은 사전처럼 정리하고 싶다는 생각이 들었는데, 더이상 미루기 싫어서 시작해본다.

**에러 목록들**

- SpringBoot
  - IntelliJ shows decopiled .class
    - https://stackoverflow.com/questions/49558009/intellij-shows-decompiled-class-file-instead-of-source-code#comment86135147_49558009
- AWS
  - `aws permission denied (publickey).`
    - [EC2 인스턴스 접속시 permission denied 발생할 경우](DevOps/AWS.md/#error-while-entering-ec2)
    - https://docs.aws.amazon.com/ko_kr/AWSEC2/latest/UserGuide/TroubleshootingInstancesConnecting.html#TroubleshootingInstancesConnectingSSH
    - https://aws.amazon.com/ko/premiumsupport/knowledge-center/ec2-server-refused-our-key/
  - `*** System restart required ***`
    - 우분투 인스턴스 접속시 출력된 메세지인데, 에러메세지는 아니고 시스템 리부팅을 요구하는 메세지이다.
    - `sudo reboot`

