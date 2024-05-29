# 스프링의 주요 개념
1. IoC
2. DI
3. Container
4. Spring Bean

## IoC
IoC : Inversion of Control (제어의 역전)
- 프로그램의 흐름을 제어하는 주체가 정반대로 뒤집히는 것
- 객체의 흐름을 제어하는 주체가 정반대로 뒤집힌다. (객체의 생성, 사용, ... 라이프 사이클)
    - 객체의 생성을 Spring이 대신 해준다. (기존 : `new Class`와 같이 사용자가 생성했어야 했음)

## DI
DI : Dependency Injection (의존성 주입)
- 객체를 사용한다 = 객체를 생성한 후, 객체의 메소드/필드를 사용한다.
    - 근데 객체 생성은 IoC에 따라 Spring이 대신 해줌
