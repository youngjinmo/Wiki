# Spring - DI

Dependency Injection

스프링에서 제공하는 모듈을 프레임워크에서 결합도(느슨한 결합)를 낮추어서 외부에서 주입하도록 한 컨셉이다. 이렇게 분리함으로써 필요한 모듈을 쉽게 가져오거나 쉽게 버전 변경 또는 제거할 수 있다.

아래 예제코드이다. 
출처 : [인프런 - 자바 스프링 프레임워크(renew ver.)](https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-%ED%94%84%EB%A0%88%EC%9E%84%EC%9B%8C%ED%81%AC_renew/)

1. 배터리 일체형

~~~java
public class ElectronicCarToy {
    private Battery battery;
    
    public tesla(){
        battery = new ElectronicBattery();
    }
}
~~~

2. 배터리 분리형

~~~java
public class ElectronicCarToy {
    
    private Battery battery;
    
    public tesla(Battery battery){
        this.battery = battery;
    } 
    
    public void setBattery(Battery battery){
        this.battery = battery;
    }
}
~~~

위의 세가지 코드를 보면, 1번이 결합도가 가장 강한 코드임을 알 수 있다. `Battery` 를 유지보수하기 어려운 단점이 있다. 2번 코드의 경우는 `setBattery()` 를 통해 결합도를 한단계 낮춘걸 알 수 있다. 이 경우엔 battery 를 유지보수하기 더 쉬운 특징이 있다. 

`tesla()` 에서 분리된 `setBattery()` 만 변경하면 되므로 `tesla()` 에서 유지보수가 더 편리할 수 있다.