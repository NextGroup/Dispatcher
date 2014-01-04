#Dispatcher 숙제 

##Basic Topic


###1. 공통 doxygen 구축

* logger를 log4j, log4cpp로 변경 
* try catch문 생활화
* unit test를 기반으로 꾸준히 테스트 해야함. 

###2. 설정 파일을 기반으로 한 Dispatcher 뼈대 만들기
   * 동기 기반의 Dispatcher 만들기*
   * 프로토콜을 만들어라. (header+payload)
   * Event Handler의 추가및 삭제를 파일 변경으로 할수 있어야 한다. 
   서버의 포트나 / 설정 정보를 별도의 설정 파일로 관리해서 시작시 읽어와 수행하게 만든다.

###3. 비동기 (Java - APM , C++ - IOCP) Dispatcher 만들기
  * 기존 동기와 비동기가 동시에 동작하는 서버 만들기 
  * 설정 파일에서 동기, 비동기 두개의 ip,port 정보를 설정하면, 자동으로 생성되게 만들기


###4. Acceptor-Connector 
 * 프로토콜 독립적인 Dispatcher 만들기.  (JSON, XML 기반의 REST 방식 2 , 기존 Stream 형태)
 * Event Handler는 역시 기존의 것을 건드리지 않고 재사용하고, 설정 파일에 어떤 형태의 프로토콜을 지원할지 명시하면 지원 가능하게 할것.

 *  동작 샘플을 기반으로 위 패턴을 설명하고, WCF 동작 방식, JBOSS 동작 방식 리포트 

##Advanced Topic

###5. Thread Pool 방식을 Boss Thread 방식에서 Leader Follower로 교체 가능하게 설계 해라.
   http://book.javanb.com/java-threads-3rd/jthreads3-CHP-12-SECT-1.html

###6. Thread Pool을 관리하는 Watch Dog을 개발해라. 

###7. WatchDog의 기능을 확장하여, 모니터링 Application을 만들어라. 
