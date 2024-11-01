### 1. 발전 양상
1. plain java
   - 다형성만으로는 SOLID의 OCP, DIP를 지킬 수 없었음

2. AppConfig.java 사용
   - 외부 클래스인 AppConfig.java를 사용하여 DI를 실행
     - 객체 간의 의존 관계 설정, 객체 생성을 AppConfig.java가 함
     - SOLID 중 SRP, OCP, DIP가 지켜졌음
       - SRP : Impl이 직접 구현체 선택 + 로직 실행 -> AppConfig가 외부에서 Impl객체 생성과 함께 의존성 주입을 해줘서 Impl은 자신의 로직만 집중
       - OCP : 구현체를 직접 선택하므로 변경 시 Impl 코드와 같은 클라이언트 코드를 대거 수정함 -> AppConfig에서 의존성을 주입하므로 수정 시 AppConfig만 수정하면 됨
       - DIP : Impl이 인터페이스 뿐만 아니라 그 구현체도 같이 알고 있음 -> AppConfig가 구현체를 선택해 주입하고 있으므로 실제 Impl 클래스들은 인터페이스만 의존하게 됨
      
3. AppConfig를 스프링 기반으로 바꾸기
   - ApplicationContext = 일종의 컨테이너
     - AppConfig를 설정 정보로 받아 사용(@Configuration이 붙은 파일)
     - AppConfig 안의 메소드 위 @Bean이 붙은 메소드들을 모두 호출 -> 컨테이너에 Bean으로 등록
       - key-value 형태로 등록
       - key : 메소드명, value : 반환 객체
   - 이전에는 AppConfig를 통해서 필요한 객체를 조회 -> 지금은 스프링 컨테이너를 통해 필요한 객체(스프링 빈)을 조회해야 함 
      - getBean으로 빈 찾기
        - 메소드 명, 반환 타입을 파라미터로 
