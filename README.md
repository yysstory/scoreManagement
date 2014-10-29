scoreManagement
===============
순수 자바로 짠 성적관리 코드입니다. 선언 가능한 명령어는 다음과 같습니다.

help

list

view 인덱스

add 이름 국어 영어 수학

delete 인덱스

update 인덱스

exit

사용예)

명령>add 김길동 23 99 22

명령>list 0 홍길동 100 100 80 1 김길동 23 99 22

...

기능요소

-명령어 수행시 추가/변경/삭제 사항은 arrayList에 임시 저장 됩니다.

-exit 명령어 수행시 해당 프로젝트 루트폴더에 자동으로 score.dat 파일에 추가/변경/삭제 사항이 저장됩니다.

그리고 프로그램이 종료 됩니다.

-프로그램 실행시 자동으로 프로젝트 루트 폴더에 있는 score.dat 파일에 저장되어있는 정보를 읽어옵니다.

:)
