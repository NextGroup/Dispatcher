#Dispatcher 컬리큘럼 진행 방향

## 공통 수업


### 0. 간단한 클래스로 만든 동기화 서버 
* 네트워크 수업 고민


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

### 6. 다양한 프로토콜도 지원해 보자. (Acceptor-Connector)
* 프로토콜 독립적인 Dispatcher 만들기. (JSON, XML 기반의 REST 방식 2 , 기존 Stream 형태)
* Event Handler는 역시 기존의 것을 건드리지 않고 재사용하고, 설정 파일에 어떤 형태의 프로토콜을 지원할지 명시하면 지원 가능하게 할것.
* 동작 샘플을 기반으로 위 패턴을 설명하고, WCF 동작 방식, JBOSS 동작 방식 리포트



### 7. 공통사항 체크
* try catch문 생활화
* stan4j 생활화
* unit test를 기반으로 꾸준히 테스트 해야함.


## 고급 주제들 

### 1. Theaad Pool을 만들고, 간단히 Watch Dog을 만들어라.
* thread pool을 만들어라 
* thread pool에 현재 남아 있는 thread 갯수를 체크하는 watchdog을 만들어라.
* 현재 Pool에 남은 Thread 갯수를 기반으로 임계점 (10개)이하 Thread 가 줄어들면 Thread를 추가 생성하는 매커니즘을 넣어라. 


### 2. Thread Pool 방식을 Boss Thread -> Leader/Follower로 교체해라. 
* https://today.java.net/pub/a/today/2008/10/23/creating-a-notifying-blocking-thread-pool-executor.html
* http://kickjava.com/src/org.apache.tomcat.util.net.index.htm
* http://kickjava.com/src/org/apache/tomcat/util/net/LeaderFollowerWorkerThread.java.htm



### 3. WatchDog을 기반으로, 모니터링 Application을 만들어라. 
