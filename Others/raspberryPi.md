# Raspberry Pi

<img src="https://media.wired.com/photos/5d5c33225006670008f3b6c4/master/w_582,c_limit/raspberry-pi-4-board-SOURCE-Raspberrypi_org.jpg" style="zoom:75%;" />

라즈베리파이는 영국의 라즈베리파이 재단에서 교육용으로 개발한 신용카드 규격의 싱글보드 컴퓨터이다. 첫 1세대 모델의 가격이 25달러여서 당시 큰 화제를 모았었다.

라즈비안OS를 설치하고, 웹 서버로 활용해보기 위해 라즈베리파이를 이것저것 만져보고 있는중이다.

### ToC

- [SSH 활성화](#enable-ssh)
- [맥에서 라즈베리파이 SSH 접속](#ssh-mac)
- [도커 설치](#install-docker)

<hr>

## <a name="enable-ssh"></a>SSH 활성화

라즈베리파이에 SSH로 접속하기 위해서 라즈베리파이의 설정에서 SSH를 활성화해야한다.

라즈베리파이의 설정에서 터미널을 실행하고 아래의 명령어를 입력한다.

~~~
pi@raspberrypi: $ sudo raspi-config
~~~

이후에 **Interfacing Option**을 선택하고, **SSH**를 선택한다.
**Yes**를 선택하고 마지막으로 **Ok**를 누르면 라즈베리파이의 SSH가 활성화된다.



또는 아래의 명령어들로 바로 SSH를 활성화 할 수 있다.

~~~
pi@raspberrypi: $ sudo systemctl enable ssh
pi@raspberrypi: $ sudo systemctl start ssh
~~~



출처 : <a href="https://www.raspberrypi.org/documentation/remote-access/ssh/" target="_blank">라즈베리파이 재단 - SSH(Secure Shell)</a>

<br>

## <a name="ssh-mac"></a>맥에서 SSH 접속

라즈베리파이에 접속한 상태에서 터미널에서 `ifconfig`를 입력해서 ip주소를 확인한다.

~~~
# 여긴 라즈베리파이 터미널
$ ifconfig
~~~

그리고 나오는 ip주소를 아래 명령어에 붙여서 **맥에서** 입력한다.

~~~
# 여긴 맥 터미널
$ ssh pi@<pi-ip>
~~~

![](https://lh3.googleusercontent.com/GX-2Eu6IL-oEGBR7nPZbBil4VPkthC7XjNkUAR6FA2jkMHZzCRvcS6u795_JhUxRJ2TcwtYcD6MO0gJ1fvq0x0tmb4LJN669O2M3r2ZuqD9phuFzHumMvVulv4eLg8mJzN2CPCo9GPGpXsUopIzBmG-s_v78F_JRp-uYfCvvqIBUJqxqNR-P6hZeoSD17BV60nwNRAqZCbBS3jYpWU-mJooFjlc0fvqUsiNDS6b2EgQUJvLCna-HYyJr4E-NyCAv_4fZ8xMePuQL1etkbdK-Aj29wAyAvDe9npMeRlQ-QJPCvLOBlIT3poalJb8OBOA9glEs3BpxsgDKOQsVOTlTLhspBkLdPEeMCjoqXVbkdiNLC2-1aVGgn6C0D07VtWHF-ipbiyHZumN-5oFaGqLC1eBdra1-_JcV8r11TCD6haXXT8gjqBER3XL_RHgCwQ3WElGbFqoGYGnZ3JLvePNwbni7P4dwXFgUx7KqEOR-BdH8BsBJNyOgh5uN966eBgpGVATxfasnszkF250p5Sio8XLBYVNLJ2GSZ88403Efzbopkr-gx9HqLE95b0WZnN5XSJJbQsDkxXO-QlfnOUL1XZXkxnTryjxPSyT1atm_lUEHD9fqSqMhPYkMlr-rVKtLNo8p4KJhRECuJx3t1CPv3z7gidKBDwimFE6YFwhjMdbOeaAbXtbuklVwrZAQ46f96WpsaGhSCb0lUXEbz0Iisq8n5hTKiXVEJEdFxxGnL6qj6etwFA=w1024-h339-no)



출처 : <a href="https://www.raspberrypi.org/documentation/remote-access/ssh/unix.md" target="_blank">라즈베리파이 재단 - SSH using Linux or Mac OS</a>

<br>

## <a name="install-docker"></a>도커 설치

리눅스에서 데이터를 전송할 때 사용하는 `curl`(Client URL, )을 사용하여 도커를 설치한다.

~~~
pi@raspberrypi: $ curl -sSL https://get.docker.com | sh
~~~

![](https://lh3.googleusercontent.com/Vv735tM025aGohM8x_nSO-1ZUZLxwKyHh-1ZMT0YOd1twrsFNBMogagSb3GhF9n03jiPOLTjFKrGyIVhB4f2oQrnbUyNfZRsbWgilGdoNiKxvzoY36IND5xkwPXWKJ_PahTG0gZHI8wODyhTwMV-J1eE-Qu2CW9haMhW6NVfFHCc7XsLRizaoJnDAQNZuddDtp7BtTMRbvK4qs3l2t_j9Su1UXjyEWbg3h7SgffWLWa-FgiRfnUVdKcB7T2aY8YU7Ofe-oOAKCuFgLMUFBEoMrrBZYXfcCruvCnucnlVoR3k29qnqwRw1-MLnTZkhXwu0flKjMKflKW43QcvvTJL0BqMa4J1rJz8sxLjg6l9-mOR6dn86HUGPx5FXrJ_9kaEYkKM6KxZfdXtplJB9q_MlpRhsqA0K_b8KI5QpKKfVlqpiFBqI80zIwTao-RIiZS0U__KYbXmpy2ECpqKbmGx7cOD2ljgjYcB7x2-C1pFXgp5rFpnY7xz3WKF7sms_6QzVKUnRgYthf9jJpcY-f4iCIOW4F5AFQI_gzrvd8lN3cBgmSb4AoxooYwJteXCuigvX2y0I3IabAFEX2Q0_RvEkPgepjn5u_9W38ss1wBJZzjbektE_6u29yfg5w0mPtYZ4fOkF6HdrZW7abI5cx3rruT-hw08xpru4T43r94QCn1nvOytcBVaq5YKthHJVrZBYTcAO0ZjEvuVsu2Zgmzk0HENteenY19tHAJtoLsKeXYOUacxLA=w887-h636-no)

![](https://lh3.googleusercontent.com/jd3ZlIzqDs-KivEuYAepCvF_4vMBkkLmvaNjGJHhp9SwUlJbXcAsGIodlLlTvex9UfK-Zpq3njyf61NxseBMrVWtt43ykSu7hANH0b1SJVkD0p2ViQAlAmQWP0SejqJm3ypb9fVLbV27R8bKpNkOt4-G5xc9pLjzlOqXm9rSonmgE6xHxUuOZvaWEbi29vwLLmowA2XAiT-B-QTbEMRgR3_ngmEFPVl4ripu-p22bji3c4v6nlhBVokP7_Sjx4Qsd3cWpBj4YeBuAf4pLdQGXFx4qcn2rKyD9FhFd2kbybRNgDiZsx2o2ef4IACB6AEMrLh-GXNzrD50T9vGD2YUlPmSXZ4bLqeGEZkjqVSYlVkuz2VsufQt0SXaADFUsd30qYoDzY5yRTKXbfHC06rUzv4r00YowSQdTBWWn7nlqdaR_ZTnUn22U0cvH-6ij1sZPxbo97TElCCC-IQ7CjPc2Nej7ZJW6WbCIp0_RM-nX62rZMipfwlcbMy_FvpKQHturzyVhoYmS640vgQAck5DUL3KbiZrkg2J3QeEOdxEHMKVNhCMPUc4Q1S1vfUXj6pEyFmd7cCV7c_24O1MI7l_xyaMFglA4SNfok7bTmUy0VPYZQC9QdBAY8QJDsdS-fdC_XqVyzzYpm90h0OVluVlY3OmpHXE78bz0BwFZTEVNH-Ki3odpFP_WYxcpo_7ugjP4xI2p3g7reDKJ_NdyzceMgGibB-VZY1KdHppm-vStUcrNpoABA=w1009-h330-no)



도커 설치가 완료되었는지 확인하기 위해 `hello-world` 라는 이미지를 불러와서 실행해보자.

~~~
pi@raspberrypi: $ docker run hello-world
~~~

![](https://lh3.googleusercontent.com/23Y32Ny3ttLX33RcFVLC1JYOYstejVxijljj6g1xgujp_BTX8nOkWVEf27huYkktksf8NlJZP4t1O7eyglwmNPsrMUMVObcfAgNgaBB06Xi2l9RpzJ3KneEJVGYu85UAclQXMraIYLeg0E3heDAZUm9UmEhNINjatkypwYOcGMOTKd96vYcJa5QQqpUELbgbu-da0Do-X6Wi5mcd3V6g4SGmXxxbvIjjLUgox6-hNp8HvjYOpczjF0tMdn7GGWTPgmrtFawJFTTKOfLipIgiwBEOSXshO08niTgN-h-ja05WgS4FKlA4Ddpx57gxOylnqHY9_zAx1yagS09RP7tBHqiQ2sOGnPn0rVrx8mkjw4gte4EespdygJwjby0I7HmQDFhn270oTkUrz_Oeoi4bpzTkALdfTB6o18J2uvcnXtdcOuJHrOy8Eixpu7kF5P6n2nS29Qs6dZLbzg4ptI86jZVHLNc1NfzWoH9J7Jfcicm9BZHLYieUirBmdoN_AqFNrtxyenxc-5VPZcT8cL8BIR83I10lqtOLg0BS83SlLwvHXwaHqMPppn1PwRT3sKACWPGqYVbGPdbW6iyC6CVJZMA9gUfWiI62wpcX6GjoNuBG3r8DlBFSKiBxJ94BDVoSPIVRmKiGyh-62em5G9RAmk7x5dbwZhFJsD1UvsjsgfnRRBhrruoH19eRsRwEFZ1fvAhErqyC8788QUn2i2N9KTIOkZU29Mq_GaYB9gosIN5uG0kDlg=w1009-h712-no)



이외에도 아래의 라이브러리들을 설치하라고 하는데, 파이썬 개발에 필요해서 그런지, 어떤 이유인지 솔직히 아직 이해하지 못했다.

~~~
pi@raspberrypi: $ sudo apt-get install libffi-dev libssl-dev
pi@raspberrypi: $ sudo apt-get install -y python python-pip
pi@raspberrypi: $ sudo apt-get remove python-configparser
~~~



도커 컴포즈를 설치하고자 한다면 아래의 명령어를 추가하면 된다.

~~~
sudo pip install docker-compose
~~~



출처 

<a href="https://github.com/gwonsungjun/wiki/blob/master/Linux/Ubuntu/curl.md" target="_blank">gwonsungjun - curl 사용법</a>

<a href="https://dev.to/rohansawant/installing-docker-and-docker-compose-on-the-raspberry-pi-in-5-simple-steps-3mgl" target="_blank">Rohan Sawant - Installing Docker and Docker Compose on the Raspberry Pi in 5 Simple Steps</a>

<br>