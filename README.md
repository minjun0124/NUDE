# NUDE (Nutrition Designer)

본 프로젝트는 SSR에서 RESTful, CSR 을 거쳐 MSA 순서로 전환하며 아키텍처 및 스프링 프로젝트 학습을 목적으로 합니다.

<h3>🗂관련 저장소</h3>

- SafeFood (SafeFood Version.1)
	- SSR, JPA 적용
    - Link : https://github.com/minjun0124/SafeFood
- Nutrition-Designer (SafeFood Version.2) ---- (현재 위치)
	- CSR, RESTful 적용
    - Link : https://github.com/minjun0124/NUDE
- Nutrition-Designer-MSA (SafeFood Version.3)
	- MSA 전환
    - Link : https://github.com/minjun0124/nude-msa
___

<h3>[ 부록 ]</h3>

- [요구명세서](./readme_ref/ReqSpecification.md)
- [DB Schema](./readme_ref/NUDE-ERD.png)
- [UI (Oven)](./readme_ref/UI_Oven.pdf)
- [API Docs](./API-Docs.md)

<br>

💻프로젝트 기획 배경 및 목표
---
사용자가 목표로 설정한 영양소에 맞춰 주문할 수 있도록 도와주는 식단 개선 영양소 설계 프로젝트.

**[ 서비스 모델 ]**

- 기존 [SafeFood 프로젝트](https://github.com/minjun0124/SafeFood) 의 서비스 모델을 변경한다.

**[ 추가될 기능 ]**
- 식단 개선에 도움을 주는 것을 목표로 한다.
- 사용자가 일 단위, 주 단위로 설정한 섭취할 목표 영양소를 그래프로 나타낸다.
- 사용자가 장바구니에 담은 상품의 영양소와 설정한 목표치를 대조하여 보여주며</br>
    목표치와 근사한 영양소를 섭취할 수 있도록 한다.
- 아이템 선호도 기반의 추천 알고리즘(Slope-one 알고리즘)을 도입하여 상품을 추천한다.

**[ 제거된 기능 ]**

- 사용자의 알러지 정보를 기반으로 안전한 식품을 섭취할 수 있도록 정보를 제공한다.
- 섭취한 영양소를 기반으로 부족한 영양소를 채울 수 있는 식품을 추천한다.

<br>
<br>

✏학습 목표
---
각 서비스에 최적화된 언어와 DB를 선택하여 이기종으로 개발되며 MSA의 인기가 증가하고 있다.</br>
그리고 이기종으로 개발된 서비스들의 통신에 HTTP 기반의 통신을 이용하는 REST가 주로 사용되고 있다.</br>
기존 프로젝트에 RESTful을 적용하고 그 특징에 대해 알아본다.</br>

<br>

🛠개발 환경
---
- Java 11
- SpringBoot 2.5.2
- Spring-Security 5.5
- Spring-Data-JPA
- Lombok
- JWT
- MariaDB

<br>

⚙주요 적용 내용 및 학습 내용
---

<h3>인증/인가</h3>

```
Multi Platform에 적합한 토큰 기반 인증/인가 방식으로 전환한다. (기존 프로젝트는 Session 기반)
  - Spring Security 적용
  - JWT 활용
```


<h3>RESTful에 대한 학습과 전환</h3>

```
- View(Front-end)를 분리하여 CSR기반으로 구현할 것을 가정
- 효율적인 RESTful 설계를 위해 필요한 내용을  학습
  - 올바른 URI 설계
  - HTTP Method 활용 방안
  - 적절한 HTTP 상태 코드 선택
  - HATEOAS 사용 이유와 활용 방안
  - URI Versioning
- Exception Handling
  - AOP를 활용한 ExceptionHandling
  - Exception Customizing
```

<h3>JPA</h3>

```
Auditing 적용
 - JPA에서 제공하는 Auditing을 적용
 - 데이터 생성, 수정 추적의 기반
```

<br>

# 💡Discussion

<h3>프로젝트 수행 중 느낀 점, 기술적인 내용 정리</h3>
<br>

[ 01. REST API ]
---

API 설계
- 기본적으로 사용자 시나리오와 확장될 요청을 고려하여 설계한다. 이로써 불필요한 추가 요청을 줄이고 쿼리를 단순화하여 효율을 높일 수 있다.

HATEOAS
- Richardson 성숙도 모델 Level3에 해당
- REST API 에는 불필요한 Request를 어떻게 줄일 수 있을까 하는 고민이 담겨있다.
- 그런 점에서 HATEOAS는 Response 에 추가적으로 확인할 수 있는 정보의 Link 등을 담아
    내려줌으로써 불필요한 Request를 줄일 수 있는 것이다.

HAL Browser
- REST API 설계시 Response 메시지에 부가 정보들을 담아서 함께 제공하는 방식
    즉, HAL을 API Response 메시지에 적용하면 그 메시지가 JSON 포맷이건 XML 포맷이건
    API를 쉽게 (검색)찾을 수 있는 메타 정보들을 포함하게 할 수 있다는 것이다.

REST API Version 관리
- 일반 브라우저 실행 가능(URI만 바꿔주면 됨)
    - URI Versioning
    - Request Parameter Versioning

- 일반 브라우저 실행 불가능(application update 필요)
    - Media Type Versioning (aka "content negotiation" or "accept header")
    - Headers Versioning

주의
- URI Pollution
- Misuse of HTTP Headers
- Caching
- API Documentation

<br>

[ 02. JWT ]
---
RFC7519 web 표준으로 Json객체를 사용해서 토큰 자체에 정보들을 저장하고 있는 Web Token<br>
<br>
JWT는 Header, Payload, Signature 3부분으로 구성
- Header : signature 정보를 해싱하기 위한 알고리즘 정보를 가지고 있음
- Payload : 서버와 클라이언트가 주고받는, 시스템에서 실제로 사용될 정보에 대한
    내용들을 담고 있음
- Signature : 토큰의 유효성 검증을 위한 문자열. 이 문자열을 통해 서버에서는 이 토큰이 유효한 토큰인지를 검증

JWT 장점
- 중앙의 인증서버, 데이터 스토어에 대한 의존성 없음
- 시스템 수평 확장에 유리
- Base64 URL Safe Encoding > URL, Cookie, Header 모두 사용 가능

JWT 단점
- Payload 의 정보가 많아지면 네트워크 사용량 증가, 데이터 설계 고려 필요
- 토큰이 클라이언트에 저장, 서버에서 클라이언트의 토큰을 조작할 수 없음

JWT 대규모 서비스에 적용 시 주의할 점

```
가령 "시스템은 사용자에게 발급된 토큰 중 특정 토큰을 지정하여 사용을 중지시킬 수 있다" 라는 요구사항이
있다고 한다면 토큰의 만료시간만 가지고 해당 요구사항을 충족시킬 수는 없다. 그때는 서버사이드에서 해당
요구사항을 충족하기 위한 추가 개발이 필요하다.
```
      
위 요구사항을 충족하기 위한 몇가지 방안

- 권한 DB의 Version 정보를 관리해서 권한이 수정되면 Version을 변경하고 JWT 내의 Version 정보와 비교해서 틀리면 Update
	  
- JWT 만료 날짜를 짧게 유지한다.
	  
- 토큰을 Redis 혹은 DB 같은곳에 저장해놓고 권한이 변경되면 해당 토큰을 업데이트 대상 토큰으로 저장하여 놓고 권한이 필요한 API를 요청할 시 업데이트 대상 토큰을 검증하는 필터를 구현하여 업데이트
	  
- JWT 페이로드에 발급 시간을 저장해 놓고 권한이 변경된 시간과 비교 업데이트 

