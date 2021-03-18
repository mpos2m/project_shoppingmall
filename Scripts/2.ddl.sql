-- 프로젝트
DROP SCHEMA IF EXISTS project_shoppingmall;

-- 프로젝트
CREATE SCHEMA project_shoppingmall;

-- 회원정보
CREATE TABLE project_shoppingmall.user_info (
	user_no      char(5)      NOT NULL COMMENT '회원번호', -- 회원번호
	user_id      varchar(20)  NOT NULL COMMENT '회원아이디', -- 회원아이디
	user_pass    varchar(20)  NOT NULL COMMENT '회원비밀번호', -- 회원비밀번호
	user_name    varchar(4)   NOT NULL COMMENT '회원이름', -- 회원이름
	user_birth   char(8)      NULL     COMMENT '생년월일', -- 생년월일
	user_phone   varchar(13)  NOT NULL COMMENT '휴대전화', -- 휴대전화
	user_address varchar(200) NOT NULL COMMENT '주소', -- 주소
	user_sex     char(2)      NULL     COMMENT '성별', -- 성별
	upass_find   varchar(100) NOT NULL COMMENT '비밀번호찾기 질문', -- 비밀번호찾기 질문
	upass_answer varchar(20)  NOT NULL COMMENT '비밀번호찾기 답변', -- 비밀번호찾기 답변
	user_totalp  INT          NULL     COMMENT '누적금액', -- 누적금액
	grade        varchar(5)   NULL     COMMENT '등급' -- 등급
)
COMMENT '회원정보';

-- 회원정보
ALTER TABLE project_shoppingmall.user_info
	ADD CONSTRAINT PK_user_info -- 회원정보 기본키
		PRIMARY KEY (
			user_no -- 회원번호
		);

-- 회원정보 유니크 인덱스
CREATE UNIQUE INDEX UIX_user_info
	ON project_shoppingmall.user_info ( -- 회원정보
		user_id ASC -- 회원아이디
	);

-- 판매내역
CREATE TABLE project_shoppingmall.sell (
	sell_no   INT     NOT NULL COMMENT '판매번호', -- 판매번호
	sell_date DATE    NOT NULL COMMENT '구매일자', -- 구매일자
	user_no   char(5) NOT NULL COMMENT '회원번호', -- 회원번호
	p_code    char(2) NOT NULL COMMENT '제품코드', -- 제품코드
	sellqty   int(3)  NOT NULL COMMENT '판매수량', -- 판매수량
	orderat   INT     NULL     COMMENT '주문금액' -- 주문금액
)
COMMENT '판매내역';

-- 판매내역
ALTER TABLE project_shoppingmall.sell
	ADD CONSTRAINT PK_sell -- 판매내역 기본키
		PRIMARY KEY (
			sell_no -- 판매번호
		);

-- 상품정보
CREATE TABLE project_shoppingmall.product (
	p_code  char(2)     NOT NULL COMMENT '제품코드', -- 제품코드
	p_name  varchar(20) NOT NULL COMMENT '제품명', -- 제품명
	p_price int(10)     NOT NULL COMMENT '가격', -- 가격
	p_stock int(4)      NOT NULL COMMENT '재고' -- 재고
)
COMMENT '상품정보';

-- 상품정보
ALTER TABLE project_shoppingmall.product
	ADD CONSTRAINT PK_product -- 상품정보 기본키
		PRIMARY KEY (
			p_code -- 제품코드
		);

-- 장바구니
CREATE TABLE project_shoppingmall.cart (
	cart_no INT     NOT NULL COMMENT '장바구니번호', -- 장바구니번호
	user_no char(5) NOT NULL COMMENT '회원번호', -- 회원번호
	p_code  char(2) NOT NULL COMMENT '제품코드', -- 제품코드
	cartqty int(3)  NOT NULL COMMENT '구매수량' -- 구매수량
)
COMMENT '장바구니';

-- 장바구니
ALTER TABLE project_shoppingmall.cart
	ADD CONSTRAINT PK_cart -- 장바구니 기본키
		PRIMARY KEY (
			cart_no -- 장바구니번호
		);

-- 등급
CREATE TABLE project_shoppingmall.grade (
	user_no     char(5)    NOT NULL COMMENT '회원번호', -- 회원번호
	grade       varchar(5) NOT NULL COMMENT '등급', -- 등급
	user_totalp INT        NULL     COMMENT '누적금액' -- 누적금액
)
COMMENT '등급';

-- 등급
ALTER TABLE project_shoppingmall.grade
	ADD CONSTRAINT PK_grade -- 등급 기본키
		PRIMARY KEY (
			grade -- 등급
		);

-- 관리자
CREATE TABLE project_shoppingmall.admin (
	ad_id   varchar(10) NOT NULL COMMENT '관리자아이디', -- 관리자아이디
	ad_pass varchar(20) NOT NULL COMMENT '관리자비밀번호', -- 관리자비밀번호
	ad_name varchar(4)  NOT NULL COMMENT '관리자이름' -- 관리자이름
)
COMMENT '관리자';

-- 관리자
ALTER TABLE project_shoppingmall.admin
	ADD CONSTRAINT PK_admin -- 관리자 기본키
		PRIMARY KEY (
			ad_id -- 관리자아이디
		);

-- 회원정보
ALTER TABLE project_shoppingmall.user_info
	ADD CONSTRAINT FK_grade_TO_user_info -- 등급 -> 회원정보
		FOREIGN KEY (
			grade -- 등급
		)
		REFERENCES project_shoppingmall.grade ( -- 등급
			grade -- 등급
		);

-- 판매내역
ALTER TABLE project_shoppingmall.sell
	ADD CONSTRAINT FK_user_info_TO_sell -- 회원정보 -> 판매내역
		FOREIGN KEY (
			user_no -- 회원번호
		)
		REFERENCES project_shoppingmall.user_info ( -- 회원정보
			user_no -- 회원번호
		);

-- 판매내역
ALTER TABLE project_shoppingmall.sell
	ADD CONSTRAINT FK_product_TO_sell -- 상품정보 -> 판매내역
		FOREIGN KEY (
			p_code -- 제품코드
		)
		REFERENCES project_shoppingmall.product ( -- 상품정보
			p_code -- 제품코드
		);

-- 장바구니
ALTER TABLE project_shoppingmall.cart
	ADD CONSTRAINT FK_user_info_TO_cart -- 회원정보 -> 장바구니
		FOREIGN KEY (
			user_no -- 회원번호
		)
		REFERENCES project_shoppingmall.user_info ( -- 회원정보
			user_no -- 회원번호
		);

-- 장바구니
ALTER TABLE project_shoppingmall.cart
	ADD CONSTRAINT FK_product_TO_cart -- 상품정보 -> 장바구니
		FOREIGN KEY (
			p_code -- 제품코드
		)
		REFERENCES project_shoppingmall.product ( -- 상품정보
			p_code -- 제품코드
		);

-- 등급
ALTER TABLE project_shoppingmall.grade
	ADD CONSTRAINT FK_user_info_TO_grade -- 회원정보 -> 등급
		FOREIGN KEY (
			user_no -- 회원번호
		)
		REFERENCES project_shoppingmall.user_info ( -- 회원정보
			user_no -- 회원번호
		);