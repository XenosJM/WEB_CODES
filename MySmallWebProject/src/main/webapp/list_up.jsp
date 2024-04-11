<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 

유저 pc에 저장소 설정
(자신의 캐릭터의 정보)

DB에 필요한 테이블 갯수..
1. 유저정보가 저장될 테이블
2. 보스 혹은 유니크객체 



@ 유저정보
- 회원번호 (고유키)
- 아이디 (유니크)
- 비밀번호
- 나이
- 성별
- 관심장르 (장르에 따라 시나리오 변경이 될수있기에)
- 닉네임 (앞으로 만들어질 캐릭터에 붙을 이름, 이를 참조하여 저장된 캐릭터를 불러올때 사용한다.)
- 이메일 (유니크)(아이디, 비밀번호 찾기용.)

DB에 적용될 쿼리
SELECT에서 AND를 사용해 사용자가 진행중인 시나리오 검색
...

몬스터가 어떤 장비를 가지고 있을지 세부스탯은 어떻게 될지는 랜덤하게 결정


Json 파일에 들어갈 목록
- 몬스터 정보(정적인 부분 : 이름, 가지고있는 장비, 소모품, 기술 등)
- 보스 정보(정적인 부분 : 이름, 가지고있는 장비, 소모품, 기술 등)
- 시나리오 정보(정적인 부분 : 시나리오의 배경, 시나리오의 줄기, 내용)


게임의 전반적인 데이터
- 몬스터의 세부정보(동적인 부분 : 체력, 기본적인 상태(힘, 지능, 체력 등))
- 보스 세부정보(동적인 부분 : 체력, 기본적인 상태(힘, 지능, 체력 등))
- 시나리오 정보(동적인 부분 : 시나리오의 방향성,  
로그테이블
- 게임 전체 로그
- 플레이한 시나리오 로그

게임진행에 필요한 기능
...

 --%>


</body>
</html>