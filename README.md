# fintech

## 프로젝트 기능 및 설계 

 ### 1.  [ ]  계좌 검색 기능

   * 은행에 따른 검색 기
   * 잔액 부족시 error
    
### 2.  [ ]  계좌 관리 (생성/삭제/금액 인출/금액 입금)

  * 계좌 등록 
    * 회원당 계좌 생성 계좌 개수 제한
    * 본인 인증 후 등록
  
  * 계좌 삭제 
    * 삭제시 본인 인증 
    * 삭제시 완저히 DB 에서 삭제

  * 계좌 조회
    * 본인 계좌 번호, 비말번호 입력 후 조회  



### 3.  [ ]  로그인/로그아웃

     * springSecurity 기능 사용 해보기 (처음 써봄)
     * 회원가입때 id, password 일치 여부

### 4.  [ ]  회원 가입 기능 구현 

    * 회원에 필요한 기능 
     - 이름, 아이디, 비밀번호, 생년월일, 사는 곳, 나이 
     + 등급에 따른 은행 송금 수수료 discount 

    * 회원 탈퇴 
     -> 비밀번호 인증 후 탈퇴 
     -> DB 완전 삭제 

### 5.  [ ] 거래기능 

   * 입금 기능
     + 계좌번호, 금액, 은행 선택

   * 출금 기능
     + 계좌번호, 금액, 은행 선택, 비밀번호
        - 비밀번호 일치하면 송금
        - 아니면 실패
        - 금액 출금 금액보다 작다면 출금 실패
   * 송금 기능
     + 송금 할 계좌, 송금 금액, 은행 입력
     + 계좌 비밀번호 입력
     + 같은 은행일 경우 수수료 X , 다른 은행일 경우 수수료 송금 금액 % 10
     + 회원 등급에 따라 수수료 면제
     + 송금 금액이 현 계좌 금액 보다 클경우 실패
     + 내역 저장
    
   * 조회 기간 설정 (paging 사용)
     + 날짜로 조회 가능 

### +A ) 추가 희망 기능 구현 
주식 매장 계좌와 연결 해서 거래 성립 


## ERD 
![image](https://github.com/Fangsangik/fintech/assets/107174112/9b666d76-1094-4cbe-9f9f-b226b7546bee)


## <h3 align="center">📚 Tech Stack 📚</h3>
<p align="center">
<div style="display: flex; align-items: flex-start;"><img src="https://techstack-generator.vercel.app/java-icon.svg" alt="icon" width="65" height="65" /></div>
 <img src="https://img.shields.io/badge/springboot-CC342D?logo=springboot">
 <img src="https://img.shields.io/badge/<svg role="img" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><title>Git</title><path d="M23.546 10.93L13.067.452c-.604-.603-1.582-.603-2.188 0L8.708 2.627l2.76 2.76c.645-.215 1.379-.07 1.889.441.516.515.658 1.258.438 1.9l2.658 2.66c.645-.223 1.387-.078 1.9.435.721.72.721 1.884 0 2.604-.719.719-1.881.719-2.6 0-.539-.541-.674-1.337-.404-1.996L12.86 8.955v6.525c.176.086.342.203.488.348.713.721.713 1.883 0 2.6-.719.721-1.889.721-2.609 0-.719-.719-.719-1.879 0-2.598.182-.18.387-.316.605-.406V8.835c-.217-.091-.424-.222-.6-.401-.545-.545-.676-1.342-.396-2.009L7.636 3.7.45 10.881c-.6.605-.6 1.584 0 2.189l10.48 10.477c.604.604 1.582.604 2.186 0l10.43-10.43c.605-.603.605-1.582 0-2.187"/></svg>


    
     
    
