# ELK Stack

![](https://lh3.googleusercontent.com/W9R8xaX5Hq0iy8ySzNRYvYYdUMufU7Gi1RF4iGhOWKr8HnLm_vcMe3i3cusW2GBr3yTXGGedzbZVeN3KzT2MaP8Lx5YY4AQXnh7jZwBVwNZQZqA31L9yuXXzgoXczCmmxlYaeoJlO69XOxk2iUmCFMx6ZGx6RoZix1ejY8xUbfil1Ghbb_kvcq5bCA_dF1pqYw21kbAiXkw-k9mtndUMYaxwCsDEIGnihO_0ybdoXOV0VhskS8Fgz2-jn06T5AC6VTbDha6qE7PZK_MMr8bxbhcdvwB8aPpeLtRL-4GbwRNracOxxyxvU-4lGQyv47tOqxJm_9vTIvWYaTF8jNpDz4Ux6Gub277y0eDNO-Fb9nVJcDnzr4zJRT88bG99Oo7BXGL6JU8ByaVoie9HZEA7YgS_WkXWimsgqci76Wh0PcIbYfBSZUlvKzeVnOkKliVAvJGGRU2IrbKKap9579A7x7_rY6ue3OkBrwxzWP7jL9IjItReSS5ymK7vVbXYyg_ZwWJjm9-ccvSYaVd0tX0SkFTFpBU2qzplnC_PLODSybTihKEC3wOq4MMGnWukPdBgu3-QSG3doUFU2V2YYvk4-0hLeIk6NB7p8TPJT--vq-Ija3SrGXWwh2PE0GO40khyeixrzaaCkR1YofWVQzHbo70srOZWw_XhwS1qemq9WkpjY6gi3EDgVSogT8xj1aHOsSqph9xeRqJGNt8rF-Mbfs7CXQpfd9lmxJZLj7OIj2yGR3y_BdkLcDs=w558-h300-no?authuser=1)

- [ELK 개념및 구성](#overview)
- [Elasticsearch 주요개념](#features)

<br>

## <a name="overview"></a>ELK

ELK란 Elastic Search, Logstash, Kibana를 종합적으로 아우르는 스택이다. 각각의 개념은 아래를 확인하자



### **Logstash**

![](https://www.elastic.co/guide/kr/logstash/current/static/images/logstash.png)

로그(데이터)를 수집하는 도구이다.

조던 시셀(Jordan Sissel)에 의해 탄생된 Logstash는 원래 Elasticsearch와 별개로 다양한 데이터 수집과 저장을 위해 개발된 프로젝트였습니다. 데이터의 색인, 검색 기능만을 제공하던 Elasticsearch는 데이터 수집을 위한 도구가 필요했는데, 때마침 Logstash가 출력 API로 Elasticsearch를 지원하기 시작하면서 많은 곳에서 Elasticsearch의 입력 수단으로 Logstash를 사용하기 시작했습니다. Elasticsearch와 Logstash는 서로 통합의 필요성을 느끼고 Logstash가 Elastic에 정식으로 합류하게 되어 하나의 스택으로 출범하게 되었습니다. 

출처 :  김종민님 Elastic 가이드북 ([링크](https://esbook.kimjmin.net/01-overview/1.1-elastic-stack/1.1.2-logstash))



### <a name="overview-es"></a>**Elastic Search**

![](https://coralogix.com/wp-content/uploads/2019/03/elastic-search-768x353.png)

Logstash 로 수집한 데이터를 조회하는 검색 엔진이다.

기본적으로 모든 데이터를 색인하여 저장하고 검색, 집계 등을 수행하며 결과를 클라이언트 또는 다른 프로그램으로 전달하여 동작하게 합니다.

Elasticsearch는 뛰어난 검색 능력과 대규모 분산 시스템을 구축할 수 있는 다양한 기능들(실시간 분석,  full text 검색엔진, RESTFul API, [multitenancy](https://esbook.kimjmin.net/01-overview/1.1-elastic-stack/1.1.1-elasticsearch#multitenancy))을 제공하지만, 설치 과정과 사용 방법은 비교적 쉽고 간편합니다.

출처 : 김종민님 Elastic 가이드북 ([링크](https://esbook.kimjmin.net/01-overview/1.1-elastic-stack/1.1.1-elasticsearch))



### **<a name="overview-kibana"></a>Kibana**

![](https://api.contentstack.io/v2/uploads/595260df787b639e44a2832c/download?uid=blt39890c7ef189ddca)

Logstash로 수집한 데이터를 Elastic Search로 검색/조회하는 시각화 도구이다.

Elasticsearch는 Restful 한 속성과 JSON 문서 기반의 통신을 지원하기에 http 프로토콜을 이용해 어떤 클라이언트와도 손쉽게 연동이 가능합니다. 그래서 개발자들이 Elasticsearch와 연동되는 다양한 시각화 도구를 개발하였고, 이 중 Rashid Khan이 개발한 Kibana 라는 시각화 도구가 큰 인기를 끌었습니다.

Kibana는 Elasticsearch를 가장 쉽게 시각화 할 수 있는 도구입니다. 검색, 그리고 aggregation의 집계 기능을 이용해 Elasticsearch로 부터 문서, 집계 결과 등을 불러와 웹 도구로 시각화를 합니다. **Discover**, **Visualize**, **Dashboard** 3개의 기본 메뉴와 다양한 App 들로 구성되어 있고, 플러그인을 통해 App의 설치가 가능합니다.

출처 : 김종민님 Elsatic 가이드북 ([링크](https://esbook.kimjmin.net/01-overview/1.1-elastic-stack/1.1.3-kibana))



### <a name="overview-beats"></a>Beats

Logstash가 데이터 수집기로 역할을 수행하지만, 다양한 기능으로 인해 프로그램의 부피가 컸고 실행하는데 필요한 자원이 많았다. 

> Logstash가 데이터 수집기로서의 역할을 훌륭하게 해 내고 있지만 너무 다양한 기능 때문에 프로그램의 부피가 컸고 실행하는 데에 꽤 많은 자원을 필요로 했습니다. Elasticsearch 클러스터로의 대용량 데이터 전송은 보통 하나의 소스가 아닌 다양한 시스템들로부터 수집을 하였기에 그 모든 단말 시스템에 Logstash를 설치하는 것은 적지 않은 부담이었습니다. 
>
> 그러던 중 독일에서 어느 두 개발자들이 Packetbeat라는 프로그램을 이용해 네트워크 패킷을 스니핑하여 Elasticsearch에 저장하여 모니터링 하는 시스템을 공개, 이후 Elasticsearch에 이것들을 색인해서 Kibana로 모니터링 하면 꽤 멋진 시스템이 된다고 생각하여 그렇게 실행하였고 추후 Elastic Stack에 합류하며 Beats가  공개. Elastic에서 진행중인 원격 수집기 프로젝트는 중단되고 Beats가 역할을 수행
>
> 현재 Elastic 에서는 Packetbeat, Libbeat, Filebeat, Metricbeat, Winlogbeat, Auditbeat 등을 개발하여 배포하고 있으며 전 세계 오픈소스 개발자들로부터 50여가지 이상의 Beats 들이 개발되고 있습니다.

<br>

## <a name="features"></a>Elasticsearch 주요개념

- [NRT](#)
- [Cluster](#)
- [Node](#)
- [Index](#)
- [Type](#)
- [Document](#)
- [Shard &Replica](#)

**NRT(Near Real Time)**

Elasticsearch는 NRT 검색 플랫폼이다. 문서를 색인화하는 시점부터 거의 동시에 문서가 검색가능해진다는 특징이 있다.

**Cluster**

클러스터는 하나 이상의 노드(서버)가 모인 것이며, 이를 통해 데이터를 저장하고 모든 노드를 포괄하는 통합 색인화 및 검색 기능을 제공한다.



출처 : https://www.elastic.co/guide/kr/elasticsearch/reference/current/gs-basic-concepts.html

<br>

**NRT(Near Real Time)**

Elasticsearch는 NRT 검색 플랫폼이다. 문서를 색인화하는 시점부터 거의 동시에 문서가 검색가능해진다는 특징이 있다.

**Cluster**

클러스터는 하나 이상의 노드(서버)가 모인 것이며, 이를 통해 데이터를 저장하고 모든 노드를 포괄하는 통합 색인화 및 검색 기능을 제공한다.



출처 : https://www.elastic.co/guide/kr/elasticsearch/reference/current/gs-basic-concepts.html

<br>

### ELK stack  = Elastic Search + Logstash + Kibana	

출처 : https://captcha.tistory.com/44



**Elastic Search** : 검색 엔진 (데이터 관리 및 검색 기능)

> 기본적으로 모든 데이터를 색인하여 저장하고 검색, 집계 등을 수행하며 결과를 클라이언트 또는 다른 프로그램으로 전달하여 동작하게 합니다.
>
> Elasticsearch는 뛰어난 검색 능력과 대규모 분산 시스템을 구축할 수 있는 다양한 기능들(실시간 분석,  full text 검색엔진, RESTFul API, [multitenancy](https://esbook.kimjmin.net/01-overview/1.1-elastic-stack/1.1.1-elasticsearch#multitenancy))을 제공하지만, 설치 과정과 사용 방법은 비교적 쉽고 간편합니다.
>
> 출처 : 김종민님 Elastic 가이드북 ([링크](https://esbook.kimjmin.net/01-overview/1.1-elastic-stack/1.1.1-elasticsearch))

**LogStash** : 로그(데이터) 수집 도구

> 조던 시셀(Jordan Sissel)에 의해 탄생된 Logstash는 원래 Elasticsearch와 별개로 다양한 데이터 수집과 저장을 위해 개발된 프로젝트였습니다. 데이터의 색인, 검색 기능만을 제공하던 Elasticsearch는 데이터 수집을 위한 도구가 필요했는데, 때마침 Logstash가 출력 API로 Elasticsearch를 지원하기 시작하면서 많은 곳에서 Elasticsearch의 입력 수단으로 Logstash를 사용하기 시작했습니다. Elasticsearch와 Logstash는 서로 통합의 필요성을 느끼고 Logstash가 Elastic에 정식으로 합류하게 되어 하나의 스택으로 출범하게 되었습니다. 
>
> 출처 :  김종민님 Elastic 가이드북 ([링크](https://esbook.kimjmin.net/01-overview/1.1-elastic-stack/1.1.2-logstash))

**Kibana** : 시각화 도구

> Elasticsearch는 Restful 한 속성과 JSON 문서 기반의 통신을 지원하기에 http 프로토콜을 이용해 어떤 클라이언트와도 손쉽게 연동이 가능합니다. 그래서 개발자들이 Elasticsearch와 연동되는 다양한 시각화 도구를 개발하였고, 이 중 Rashid Khan이 개발한 Kibana 라는 시각화 도구가 큰 인기를 끌었습니다.
>
> Kibana는 Elasticsearch를 가장 쉽게 시각화 할 수 있는 도구입니다. 검색, 그리고 aggregation의 집계 기능을 이용해 Elasticsearch로 부터 문서, 집계 결과 등을 불러와 웹 도구로 시각화를 합니다. **Discover**, **Visualize**, **Dashboard** 3개의 기본 메뉴와 다양한 App 들로 구성되어 있고, 플러그인을 통해 App의 설치가 가능합니다.
>
> 출처 : 김종민님 Elsatic 가이드북 ([링크](https://esbook.kimjmin.net/01-overview/1.1-elastic-stack/1.1.3-kibana))

**Beats** : Logstash가 데이터 수집기로 역할을 수행하지만, 다양한 기능으로 인해 프로그램의 부피가 컸고 실행하는데 필요한 자원이 많았다. 

> Logstash가 데이터 수집기로서의 역할을 훌륭하게 해 내고 있지만 너무 다양한 기능 때문에 프로그램의 부피가 컸고 실행하는 데에 꽤 많은 자원을 필요로 했습니다. Elasticsearch 클러스터로의 대용량 데이터 전송은 보통 하나의 소스가 아닌 다양한 시스템들로부터 수집을 하였기에 그 모든 단말 시스템에 Logstash를 설치하는 것은 적지 않은 부담이었습니다. 
>
> 그러던 중 독일에서 어느 두 개발자들이 Packetbeat라는 프로그램을 이용해 네트워크 패킷을 스니핑하여 Elasticsearch에 저장하여 모니터링 하는 시스템을 공개, 이후 Elasticsearch에 이것들을 색인해서 Kibana로 모니터링 하면 꽤 멋진 시스템이 된다고 생각하여 그렇게 실행하였고 추후 Elastic Stack에 합류하며 Beats가  공개. Elastic에서 진행중인 원격 수집기 프로젝트는 중단되고 Beats가 역할을 수행
>
> 현재 Elastic 에서는 Packetbeat, Libbeat, Filebeat, Metricbeat, Winlogbeat, Auditbeat 등을 개발하여 배포하고 있으며 전 세계 오픈소스 개발자들로부터 50여가지 이상의 Beats 들이 개발되고 있습니다.

<br>