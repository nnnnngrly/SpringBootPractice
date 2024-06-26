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
```java
@Configuration
public class AppConfig {

    @Bean // 아래 메소드가 반환하는 객체를 Spring Bean으로 등록
    public ProductRepository productRepository(){
        return new ProductRepository();
    }
}
```
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
3. **@RequestBody**
- http://.../products
- Body에 객체를 담아서 보냄 (url 안 건드림)

4. @ModelAttribute
5. **@PathVariable**
- 정해져 있는 system의 값을 사용할 때 (사람마다 다름)
- http://.../products/**{value}**

---
# 줄여 쓰기

@Controller + @ResponseBody
- Controller + ResponseBody = RestAPI
- **@RestController**

@RequestMapping(value, method = "RequestMethod.{method}")
- @GetMapping, @PostMapping, ...@{method}Mapping'  
---
# 클린 코드를 위한 메소드 명
1. method명은 "동사" <- 동작, 기능, 행위 등을 표현하기 때문
2. 의미만 제대로 담고 있으면 됨 (굳이 자료구조를 끼울 필요는 X)

---
# @Configuration
- 설정 파일(`.xml`)을 자바로 표현했음을 알리는 어노테이션

---
# JPA
JPA (Java Persistence API) : 자바 지속(영속)성 API
- Java의 객체를 JVM 밖에서도 지속하기 위해, DB에 저장할 때 사용하는 API
- Java의 Variable Type을 DB에 맞춰 매핑/변환 (**파라다임 불일치 해결**)
  - **ORM** : Object-Relational Mapping

---
# Application.properties
프로젝트의 속성값 정의 및 변경 가능 (Logic과 관련 없는 파일 저장)
- **DB 연결**
  - JDBC를 사용하려면, "DataSource 객체" 속성을 정의해야 함
    - `spring.datasource.driver-class-name` 드라이버 설정 (어떤 DB를 사용할 것인지)
    - `spring.datasource.username` DB 계정
    - `spring.datasource.password` DB 비밀번호
    - `spring. datasource.url` 사용하고자 하는 DB의 주소
  
- Port Number 변경
- Project 이름 변경, 로그 파일 저장 경로

build.gradle - dependencies 에 추가
  - `runtimeOnly 'org.mariadb.jdbc:mariadb-java-client'`
  - `implementaton 'org.springframework.boot:spring-boot-starter-jdbc'`

---
JPA : 자바 객체 <-> "Mapping **Entity**" in EntityContext <-> DB (Entity와 DB는 1:1로 매핑)
  - Entity Context : JPA가 Entity를 관리하기 위한 공간 (Mapping을 고려하는 공간)
    - EntityManager : Entity Context에서 Entity를 관리
JDBC API -> Datasource (Interface) -> Hikari (구현체) : DB로 가는 터널 연결, SQL 전달 etc
JPA(API) -> EntityManager (Interface) -> Hibernate (구현체) : Entity를 관리
  - CRUD 작업 수행 위한 Method 제공, 라이프 사이클 관리, 영속성 관리

Entity Manager가 Interface면 여러 개의 구현체가 있을 수도 있지 않을까?
-> Spring에서 JPA의 기본 구현체로 Hibernate를 선정하였다. 

---
Entity를 관리하기 위한 annotation : @Entity
- 여기서는 "product"객체 위에 표시

---
# EntityManager가 가진 method 
1. 테이블 조회 (Select)
- `entityManager.createQuery({String:query}, {class}).getResultList()` // 전체 조회 (CRUD 미제공 -> 자체적으로 쿼리 생성)
- `find(id)` : 개별 조회
  
2. 객체 등록 (Insert)
- `persist({객체})` : 객체 저장 (J"**P**"A 니까, 영속성을 부여한다는 의미) 

---
# JPQL
SQL : SELECT * FROM product(테이블 명)
   - JPQL : SELECT p FROM Product p
     - Product Class를 p라 칭하고, 해당 테이블에서 p(전체 테이블)을 가져온다.

---
# JPA 키워드 총 정리

**JPA** : Java의 영속성을 지켜주는 API (자바의 객체를 JVM 밖에서 사용하기 위해 ORM 매핑을 통해 DB에 저장)
**Hibernate** : JPA (Interface)를 구현하기 위해 Spring이 선택한 구현체 (Default; 변경 가능)

**Entity** : DB와 1:1로 Mapping할 수 있는 자바 객체
**EntityManager** : Mapping 관리, CRUD Method 지원 ...
**EntityContext** : Java와 DB 사이에 Entity를 관리/저장하는 공간

**@Entity** : Entity로 등록하기 위한 Annotation
**@Id** : 식별자 등록을 위한 Annotation

---
# Spring Data JPA

Spring이 제공해주는 JPA Interface
- JPA : EntityManager, CreateQuery ... 복잡한 느낌 => 추상화한 느낌(Spring Data JPA)
- 메서드 간결, 보다 많은 기능 제공
- 페이징 기능 제공
  - 1 page (1~ 10번 상품), 2 page (11 ~ 20번 상품)...

---
**DTO**
데이터 전송 객체 : 데이터를 전송하기 위해 사용하는 객체 -> "사본"의 역할 수행
- Entity가 직접 Controller까지 왔다갔다 하기에는 위험함
- 사용자는 년도로 입력 -> DB에는 나이로 저장
  - 사용자의 입력을 manipulate