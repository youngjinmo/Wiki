# Network

- [네트워크 종류](#varieties-of-networks)
  - [크기에 따른 네트워크 종류](#sizes-of-networks)
  - [모양에 따른 네트워크 종류](#shapes-of-networks)
- [네트워크 아키텍쳐](#network-architecture)
  - [OSI 7계층](#osi-7-layers)
  - [7계층, 응용 계층](#application-layer)
  - [6계층, 표현 계층](#presentation-layer)
  - [5계층, 세션 계층](#session-layer)
  - [4계층, 전송 계층](#transport-layer)
  - [3계층, 네트워크 계층](#network-layer)
  - [2계층, 데이터링크 계층](#datalink-layer)
  - [1계층, 물리 계층](#physical-layer)

## <a name="varieties-of-networks"></a>네트워크 종류

일반적으로 네트워크라 하면, 라우터의 집합을 의미한다. 우리가 네트워크중 가장 친숙한 인터넷은 용도나 목적에 따라 크게 3가지로 구분될 수 있다.

- 인트라넷 : 내부망
- 익스트라넷 : 3계층 네트워크 외부망
- 인터넷 = 인트라넷 + 익스트라넷
  - 인터넷은 TCP/IP를 기본 프로토콜로 운영되는 네트워크

<br>

### <a name="sizes-of-networks"></a>크기에 따른 네트워크 종류

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

### <a name="shapes-of-networks"></a>모양에 따른 네트워크 종류

### Star Topology

<img src="https://www.computerhope.com/jargon/s/star.gif" style="float: left;" />

- 가운데 메인 단말기를 중심으로 연결되있는 네트워크 형태
- 장점
  - 메인 단말기에서 장애가 발생할 경우, 모든 네트워크가 망가질 수 있다.
- 단점
  - 그러나 연결이 단순하기 때문에 비용이 저렴하다는 특징이 있다.

<br>

### Bus Topology

<img src="https://latestcontents.com/wp-content/uploads/2014/08/Bus-Topology-or-Linear-Topology-o-Star-Topology.gif" style="float: left;" />

- 메인단말기가 연결된 간선 케이블에 모든 단말기를 연결하는 네트워크 형태

- 장점

  - Star Topology와 마찬가지로 연결이 단순하여 비용이 저렴하다는 특징이 있다.

- 단점

  - 메인 단말기에서 멀어질수록 성능저하가 발생하므로 성능 저하가 심해지는 포인트에 확장기가 필요하다
  - 또한 간선 케이블에 훼손이 발생할 경우, 메인 허브에서 간선 케이블이 연결된 반대방향의 모든 단말기들의 네트워크가 장애가 발생하는 위험이 있다.

<br>

### Tree Topology

<img src="https://everythingaboutcomputernetworks.weebly.com/uploads/3/8/2/0/38205637/61914.jpg?438" style="float: left;" />

- Bus Topology에 Tree Topology를 결합한 네트워크 형태

- 기업에서 많이 사용하는 형태의 네트워크 타입이다.

- 장점

  - 간선 케이블에서 장애가 발생하더라도 반대방향의 단말기들이 허브에 따로 연결되어 있기 때문에 인트라넷 형태로 운영이 가능하다.

<br>

### Ring Topology

<img src="https://www.computerhope.com/jargon/r/ring.gif" style="float: left;" />

- 단말기가 양방향으로 서로 연결되어 있는 네트워크 형태
- 단말과 단말이 node가 되어 연결되어있고, 전체 단말기가 Ring 형태로 연결되어 있기 때문에 하나의 단말이 문제가 발생하더라도 반대로부터 연결된 단말기와 계속 네트워크를 공유할 수 있다는 특징이 있다.

<br>

### Mesh Topology

<img src="https://www.computerhope.com/jargon/m/mesh.gif" style="float: left;" />

- Ring Topology가 단말기가 양방향으로 연결되어 있다고 한다면, Mesh Topology는 하나의 단말기가 모든 단말기와 연결되어 있는 형태의 네트워크 형태이다.
- 모든 단말기가 서로 통신하고 있기 때문에 최적의 경로로 네트워크를 공유한다는 특징이 있으며, 당연히 일부 단말기가 문제가 발생하더라도 전체 네트워크는 영향을 받지 않는다는 장점이 있다.

<br>

## <a name="network-architecture"></a>네트워크 아키텍쳐

### <a name="osi-7-layers"></a>OSI 7 계층

통신을 위한 일련의 프로토콜 조합을 네트워크 아키텍쳐라 부르는데, 이 중 가장 대표적인게 OSI 7계층이다.

OSI 7계층이란, 국제표준화기구 ISO(International Organization for Standardization)에서 제정한 모델로, 네트워크 통신에 필요한 기능을 7가지 계층으로 분리한 네트워크 아키텍쳐이다.

![](https://t1.daumcdn.net/cfile/tistory/995EFF355B74179035)

5계층부터 7계층까지를 상위 계층으로 분류하며, 1계층부터 3계층까지를 하위계층으로 분류한다.중간에 있는 4계층, 전송계층은 상위계층에 속하기도, 하위계층에 속하기도 한다.

이렇게 네트워크 기능을 7계층으로 분리한 이유는 각각의 계층에서 어떻게 통신이 일어나는지의 과정을 단계별로 파악할 수 있기 때문이다. 네트워크 장애가 발생할 경우, 특정 계층에서 발생했음을 인지하면, 다른 계층의 장비를 건드릴 필요가 없기 때문이다.

<a name="physical-layer"></a>**1계층 (Physical Layer, 물리 계층)**

주로 전기적, 기계적 특성을 이용한 통신 케이블로 데이터를 전송하는 계층이며, 물리 계층에서 사용되는 통신 단위는 bit이다. 1과 0으로 구성되어 있다고 생각하면 된다. 물리 계층에선 데이터를 전송할지, 안할지만 결정한다.

여기에 속하는 장비가 통신 케이블, 리피터, 허브 등이 속한다.

<a name="datalink-layer"></a>**2계층 (DataLink Layer, 데이터전송 계층)**

물리계층을 통해 송수신 되는 정보의 오류와 흐름을 관리하여 안전한 정보의 전달을 수행할 수 있도록 하는 역할을 수행.

데이터전송 계층에서는 맥 주소를 가지고 통신을 하며, 여기서 전송되는 단위를 프레임이라고 한다. 대표적인 장비로는 브리지, 스위치 등이 여기에 있다.

<a name="network-layer"></a>**3계층 (Network Layer, 네트워크 계층)**

네트워크 계층에서 가장 중요한 기능은 데이터를 목적지까지 가장 안전하고 빠르게 전달하는 기능(라우팅)이다. 

네트워크 계층에서 가장 대표적인 장비는 라우터인데, 요즘은 2계층으 장비중 스위치라는 장비에 라우팅 기능을 장착한 Layer 3 스위치도 있다. 공유기가 바로 여기에 속한다.

네트워크 계층은 여러개의 노드를 거칠때마다 경로를 찾아주는 역할을 하는계층으로 다양한 길이의 데이터를 네트워크들을 통해 전달하고, 그 과정에서 전송 계층이 요구하는 서비스 품질을 제공하기 위한 기능적, 절차적 수단을 제공한다.

네트워크 계층은 라우팅, 흐름 제어, 세그멘테이션(segmentation/desegmentation), 오류 제어, 인터네트워킹 등을 수행한다.

정리하면, 네트워크 계층에선 논리적인 주소(IP)를 부여하고, 경로(Route)를 설정하는 계층이다.

<a name="transport-layer"></a>**4계층 (Transport Layer, 전송 계층)**

통신을 활성화하기 위한 계층이다. 보통 TCP 프로토콜을 이용하며, 포트를 열어서 응용프로그램들이 전송을 할수있도록 한다.

전송 계층은 양 끝단(End to End)의 사용자들이 신뢰성있는 데이터를 주고 받을 수 있도록 해주며, 상위 계층(4계층:전송 계층~7계층:응용 계층)들이 데이터 전달의 유효성이나 효율성을 생각하지 않도록 해주는 계층이다.

특정 연결의 유효성을 제어하고, 연결 기반의 프로토콜을 제공하기도 하다. 전송 계층이 패킷들의 전송이 유효한지 확인하고 전송 실패한 패킷들을 다시 전송하다는 것을 의미한다. 

TCP가 가장 많이 알려진 대표적인 전송 계층 프로토콜이다.

<a name="session-layer"></a>**5계층 (Session Layer, 세션 계층)**

데이터가 통신하기 위한 논리적인 연결을 지원하는 계층이다. 4계층, 전송 계층에서도 연결을 맺고 종료할 수 있기 때문에 5계층, 세션 계층은 4 계층과 무관하게 세션 설정, 세션 유지, 세션 종료, 전송 중단시 복구 등의 기능이 있다고 한다.

세션 계층은 양 끝단의 응용 프로세스가 통신을 관리하기 위한 방법을 제공하며, 동시 송수신 방식(duplex), 반이중 방식(half-duplex), 전이중 방식(Full Duplex)의 통신과 함께, 체크 포인팅과 유휴, 종료, 다시 시작 과정 등을 수행한다.

세션 계층은 TCP/IP 세션을 만들고 없애는 책임을 갖고 있는 계층이다.

<a name="presentation-layer"></a>**6계층 (Presentation Layer, 표현 계층)**

데이터 표현이 상이한 응용 프로세스의 독립성을 제공하며 암호화하는 계층이다.

6계층, 표현계층은 코드 간의 번역을 담당하여 사용자 시스템에서 데이터의 형식상 차이를 다루는 부담을 응용 계층으로부터 덜어준다. MIME 인코딩이나 암호화 등의 동작이 이 계층에서 이루어진다.

이미지의 포맷이 JPEF인지, GIF인지 구분하는 것등이 6계층 표현계층에서 이뤄진다.

<a name="application-layer"></a>**7계층 (Application, 응용 계층)**

최종 목적지로서 HTTP, FTP, SMTP, POP3, Telnet 등과 같은 프로토콜이 여기에 속한다. 웹 브라우저나 메일 애플리케이션 등이 이 프로토콜을 보다 쉽게 사용하게 해주는 응용 프로그램인 것이다. **모든 통신의 양끝단은 HTTP나 SMTP, POP3같은 프로토콜**이지, 응용 프로그램이 아니라는 의미이다.

<br>