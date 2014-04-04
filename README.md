#Dispatcher 컬리큘럼 진행 방향

## 공통 수업

### 1. 기본 Dispatcher 이해하고 돌려보기
* 사이텍 미디어 예제를 잘 이해하는 것. 


### 2. 프로토콜 추가에 유연한 Dispathcer (Reactor)
* 프로토콜이 추가 될때마다 switch문에 계속 코드를 추가해야할까? 
* 해결 방안으로 설명하는 Reactor 패턴 (Protocol 도입 , EventHandler, Handle Map 구축 위주로) 

### 3. XML 설정좀 편하게 해보자. 
* protocol 코드상에서 관리해야 하나?  -> xml로 빼보자. 
* event handler를 xml에서 관리해 보자. 
* 파싱도 좋은데 좀 쉽게 해보는 방법이 없을까? simple framework의 도입

### 4. log 관리 좀 나이스하게 해볼까?
* log4xxx 패턴 소개
* log4j 사용법 소개 
* 실제 Dispatcher패턴에 적용해 보자. 

### 5. 비동기 Dispatcher도 만들어 보자. (동기/비동기 다되어야 함 - Proactor)
* 기존 동기와 비동기가 동시에 동작하는 서버 만들어 보자. 
* xml 설정 파일에서 동기, 비동기 두개의 ip,port 정보를 설정하면, 서비스 시작시 읽어오게 만들기
* 동기/비동기 * Blocking / Non Blocking를 이해하고 동기+Blocking / 비동기 + Non Blocking 모델을 다 만들어라 (Advanced) 

### 6. 다양한 프로토콜도 지원해 보자. (Acceptor-Connector)
* 프로토콜 독립적인 Dispatcher 만들기. (JSON, XML 기반의 REST 방식 2 , 기존 Stream 형태)
  Stream 기반의 0x0101:add:3:4 
  HTTP 기반의 XML Restful 통신  

* 설정 파일에 어떤 형태의 프로토콜을 지원할지 명시하면 지원 가능하게 할것.
   Event Handler를 추가하는것 역시 소스코드 수정이 아닌 설정 파일 변경으로 쉽게 추가/삭제 할수 있게 만들 것. 

* 동작 샘플을 기반으로 위 패턴을 설명하고, WCF 동작 방식, JBOSS 동작 방식 리포트



### 7. 공통사항 체크
* try catch문 생활화
* stan4j 생활화
* unit test를 기반으로 꾸준히 테스트 해야함.


## 고급 주제들 

### 1. Theaad Pool을 만들어라 
* thread pool을 만들어라 


* http://javacan.tistory.com/12 
* http://blog.naver.com/PostView.nhn?blogId=julymorning4&logNo=100192878746 

### 2. WatchDog을 만들어서 별도의 모니터링 Application을 만들어라. 
http://www.javacodegeeks.com/2013/01/java-thread-pool-example-using-executors-and-threadpoolexecutor.html



