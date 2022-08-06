# 쇼핑몰 만들기

## V1
- Member 로그인 기능
- Map으로 MemoryMemberRepository 구현
- 코드가 엉망진창

## V2
- Service계층 도입. controller에서 하던 ID, Password 확인을 Service로 이동.
- Service에 loginId 중복 확인 코드 추가. 중복 시에, log.error로 로그 남김
- 로그인을 위한 POST 요청 후 redirect 코드 추가. 
- RedirectAttributes를 사용해서 redirect후에도 view 렌더링에 필요한 model 데이터가 유지되도록 함. (https://baeldung-cn.com/spring-web-flash-attributes 참고함)


## 앞으로 할 일

- 관리자로 로그인 시 다른 사용자의 정보를 표 형태로 출력.
- 현재는 로그인하지 않으면 login-home으로 아예 이동 불가. 로그인하지 않아도 login-home으로 접근할 수 있도록 만들기 (로그인하지 않은 상태라면 사용자 이름 출력 대신, 로그인 버튼을 띄우기)
- 회원 중복 에러를 try-catch로 수정해서 테스트에 용이한 코드 만들기
- MemberServiceImpl 테스트코드 생성하기
