# Network

## 목적에 따른 네트워크 종류

- 인트라넷 : 내부망
- 익스트라넷 : 3계층 네트워크 외부망
- 인터넷 = 인트라넷 + 익스트라넷
  - 인터넷은 TCP/IP를 기본 프로토콜로 운영되는 네트워크

<br>

### 크기에 따른 네트워크 종류

![img](https://t1.daumcdn.net/cfile/tistory/995DCD465CAF21FD07)

- PAN : Personal Area Network
  - 가장 작은 규모의 네트워크
- LAN : Local Area Network
  - 근거리 영역 네트워크
  - 부지내 여러대의 컴퓨터를 연결하는 통신 하드웨어
  - 이더넷
  - 더 읽어볼 글 : [코딩팩토리 - LAN(근거리 통신망)](https://coding-factory.tistory.com/341?category=758268)
- MAN : Metropolitan Area Network
  - 대도시 영역 네트워크
- WAN : Wide Area Network
  - 광대역 네트워크
  - 이렇게 네트워크 규모가 다른 이유는 한번에 WAN에 접근하려는 경우 네트워크 성능(속도)도 떨어질뿐더러 비용도 크게 발생하지 때문에 성능과 비용절감을 위해 WAN과 PAN 사이에 MAN - LAN으로 연결해서 접근하는것이 필요하다.
- VAN : Value Added Network
  - 부가가치 통신망 정보의 축적과 제공, 통신속도와 형식의 변화, 통신 경로의 선택 등 여러 종류의 정보 서비스
  - 더 읽어볼 글 : [코딩팩토리 VAN(부가 가치 통신망)](https://coding-factory.tistory.com/342?category=758268)

<br>

### 모양에 따른 네트워크 종류

### Star Topology

<img src="https://www.computerhope.com/jargon/s/star.gif" style="float: left;" />

- 가운데 메인 단말기를 중심으로 연결되있는 네트워크 형태

- 장점

- - 메인 단말기에서 장애가 발생할 경우, 모든 네트워크가 망가질 수 있다.

- 단점

- - 그러나 연결이 단순하기 때문에 비용이 저렴하다는 특징이 있다.



### Bus Topology

<img src="https://latestcontents.com/wp-content/uploads/2014/08/Bus-Topology-or-Linear-Topology-o-Star-Topology.gif" style="float: left;" />

- 메인단말기가 연결된 간선 케이블에 모든 단말기를 연결하는 네트워크 형태

- 장점

- - Star Topology와 마찬가지로 연결이 단순하여 비용이 저렴하다는 특징이 있다.

- 단점

- - 메인 단말기에서 멀어질수록 성능저하가 발생하므로 성능 저하가 심해지는 포인트에 확장기가 필요하다
  - 또한 간선 케이블에 훼손이 발생할 경우, 메인 허브에서 간선 케이블이 연결된 반대방향의 모든 단말기들의 네트워크가 장애가 발생하는 위험이 있다.



### Tree Topology

<img src="https://everythingaboutcomputernetworks.weebly.com/uploads/3/8/2/0/38205637/61914.jpg?438" style="float: left;" />

- Bus Topology에 Tree Topology를 결합한 네트워크 형태

- 기업에서 많이 사용하는 형태의 네트워크 타입이다.

- 장점

- - 간선 케이블에서 장애가 발생하더라도 반대방향의 단말기들이 허브에 따로 연결되어 있기 때문에 인트라넷 형태로 운영이 가능하다.



### Ring Topology

<img src="https://www.computerhope.com/jargon/r/ring.gif" style="float: left;" />

- 단말기가 양방향으로 서로 연결되어 있는 네트워크 형태
- 단말과 단말이 node가 되어 연결되어있고, 전체 단말기가 Ring 형태로 연결되어 있기 때문에 하나의 단말이 문제가 발생하더라도 반대로부터 연결된 단말기와 계속 네트워크를 공유할 수 있다는 특징이 있다.



### Mesh Topology

<img src="https://www.computerhope.com/jargon/m/mesh.gif" style="float: left;" />

- Ring Topology가 단말기가 양방향으로 연결되어 있다고 한다면, Mesh Topology는 하나의 단말기가 모든 단말기와 연결되어 있는 형태의 네트워크 형태이다.
- 모든 단말기가 서로 통신하고 있기 때문에 최적의 경로로 네트워크를 공유한다는 특징이 있으며, 당연히 일부 단말기가 문제가 발생하더라도 전체 네트워크는 영향을 받지 않는다는 장점이 있다.

<br>

## OSI 7 Layer 모델

### 특징

OSI 7 Layer(OSI 7계층)은 네트워크에서 통신이 일어나는 과정을 7단계로 나눈 개념이다.

![](https://t1.daumcdn.net/cfile/tistory/995EFF355B74179035)

각 계층간 역할은 분리되어 있다. 이에 대해서 더 읽어보면 좋을 글 : [erroftDev - OSI 7 계층이란, 나눈 이유](https://shlee0882.tistory.com/110)

위 이미지에서 구분한 것처럼 Session Layer까지가 상위계층, Network Layer부터는 하위 계층이다. Transport Layer는 상위 계층이 될수도, 하위 계층으로도 분류될 수 있는 특징을 갖고 있다.



### 상위계층

**Application Layer, 7계층**

- HTTP: 80 -> HTTPS: 443
- FTP: 20, 21
- Telnet: 23
- SMTP : 메인 발신
- IMAP, POP : 메일 수신

**Presentation Layer, 6계층**

- 일률화:
- 암호화:
- 압축화: 네트워크 성능(속도)를 개선하는 역할

<br>