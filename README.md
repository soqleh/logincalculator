# login calculator
#### [기능]
1. localhost:8080 접속 시 로그인/회원가입 기능 제공
2. 로그인하지 않은 상태에서는 계산기 일반 제공
3. 로그인하면 로그아웃 버튼과 계산이력 실행 버튼 제공

#### [DB]
1. H2 db 사용
2. member DB(OneToMany)와 History DB(ManyToOne) 매핑

#### 로그인
Spring Security Form Login 인증 방식 사용

#### 테스트 코드
1. Member/ History에 대한 기본 JUnit Test 작성
