# 1. 스프링의 주요 개념
1. IoC
2. DI

## 1.1. IoC
IoC : Inversion of Control (제어의 역전)
- 프로그램의 흐름을 제어하는 주체가 정반대로 뒤집히는 것
- 객체의 흐름을 제어하는 주체가 정반대로 뒤집힌다. (객체의 생성, 사용, ... 라이프 사이클)
    - 객체의 생성을 Spring이 대신 해준다. (기존 : `new Class`와 같이 사용자가 생성했어야 했음)

## 1.2. DI
DI : Dependency Injection (의존성 주입)
- 객체를 사용한다 = 객체를 생성한 후, 객체의 메소드/필드를 사용한다.
    - 근데 객체 생성은 IoC에 따라 Spring이 대신 해줌
    - IoC에 따라 의존성 주입은 Spring에게 요청해야 함

### 1.2.1. Spring Container (DI Container)
스프링이 **"객체를 생성해서"**를 담아두는 공간/박스
- DI Container에 저장되는 객체를 **"Spring Bean'**이라고 한다.

---

# 2. Spring MVC
M(Model) : 데이터를 처리(연산), 로직
- Service : 가져온 데이터를 처리함
- Repository : DB와 소통하여 데이터를 가져옴
V(View) : 화면
- 최근에 Spring는 API 제작 용도로만 사용하기 때문에, View는 잘 언급되지 않음
C(Controller) : Model과 View를 이어주는 가교 역할
- Spring에서는 Model과 Client를 이어주는 역할
=> Spring에서는 **Service, Repository, Controller** 패턴으로 구성

---
# Spring IoC & Bean 등록 방법
Spring Bean 등록 : 직접 객체를 생성하는 대신, 스프링이 객체를 생성하고 관리하도록 요청하는 것
- 1) @Component 어노테이션 사용
- 2) @Configuration + @Bean 사용
=> @Autowired를 통해 등록된 빈을 사용할 수 있음

---
# DI 방법은 사실 세 가지
1. 필드로 주입
- @Autowired + 필드 마련
    - spring이 알아서 생성하기 때문에, 변경에 유연성이 낮음

2. Setter로 주입
- @Autowired + setter 메소드
    - setter는 public으로 열려 있어서 위험해서 탈락

3. 생성자로 주입받음
- @Autowired + 생성자
    - 생성자에 원하는 변수를 담을 수 있어 유연성이 높음

---
# REST API URL 생성 규칙
상품 조회 : /products (GET Method를 사용하는 것을 알고 있기에)
상품 등록 : /products (POST Method를 사용하는 것을 알고 있기에)
HTTP Method와 결합하여 의미를 알 수 있도록 + 일반적으로 복수형으로

---
# 요청 받을 때 데이터도 같이 받는 방법
1. HttpServletRequest
2. **@RequestParam**
- Query String 방식 (값을 입력받을 때 사용하는데 사람마다 다름)
- http://.../products***?name={value}**
1. **@RequestBody**
- http://.../products
- Body에 객체를 담아서 보냄 (url 안 건드림)

1. @ModelAttribute
2. **@PathVariable**
- 정해져 있는 system의 값을 사용할 때 (사람마다 다름)
- http://.../products/**{value}**