select * from user_info;

select * from product;

select * from admin;

select * from cart;

select * from sell;

select * from grade;

-- ----------------------------------------------------
-- admin
select ad_id, ad_pass, ad_name from admin;

select ad_id, ad_pass, ad_name from admin where ad_id = 'admin';

insert into admin values('admin2', '1234', '테스트1');

update admin set ad_pass = '12345' where ad_id ='test';

delete from admin where ad_id = 'test';

-- ---------------------------------------------------------
-- grade

select grade , totalp from grade order by totalp asc;

select grade, totalp from grade where grade = '실버';

insert into grade values('VVIP', 5000000);

update grade set totalp = 900000 where grade = '플레티넘';

delete from grade where grade ='VVIP';

-- -------------------------------------------------------
-- product

select p_code, p_name, p_price, p_stock from product;

select p_code, p_name, p_price, p_stock from product where p_name ='세탁기';

insert into product values ('AA','테스트', 10000, 100);

update product set p_stock = 150 where p_name = '테스트';

delete from product where p_name = '테스트';

-- ---------------------------------------------------------
-- user_info
select user_no, user_id, user_pass, user_name, user_birth, user_phone,
	user_address,user_sex,upass_find, upass_answer, user_totalp, grade
	from user_info ;

select user_no, user_id, user_pass, user_name, user_birth, user_phone,
	user_address,user_sex,upass_find, upass_answer, user_totalp, grade
	from user_info where user_id = 'test1';

insert into user_info values ('10000', 'test', '1234', '테스트', '19770405', '010-9741-5821', '서울 중구 마른내로 8길 13', '남자', '출신초등학교는?', '서울초등학교', 0, '브론즈' );

update user_info set user_pass = '1234' where user_id = 'test';

delete from user_info where user_no = '10000';

-- ---------------------------------------------------------------
-- sell 

select sell_no, sell_date, user_no, p_code, sellqty, orderat from sell;

select sell_no, sell_date, user_no, p_code, sellqty, orderat from sell where user_no = 12003;

select sell_no, sell_date, user_no, p_code, sellqty, orderat from sell s 
	join user_info ui on s.user_no = ui.user_no
	where user_no = '12003';
	
select * from sell;

select sell_no, sell_date, user_no, p_code, sellqty, orderat from sell where user_no = '12003';


create view vw_sell_full
as 
select s.sell_no, s.sell_date, concat(u.user_no,'(',u.user_name,')') as user_no
		, concat(p.p_code,'(',p.p_name,')') as p_code, s.sellqty, p.p_price * s.sellqty as orderat
		from sell s left join user_info u on s.user_no = u.user_no join product p on s.p_code =p.p_code 
		order by s.sell_date, u.user_no;
	
select * from vw_sell_full;

select sell_no,sell_date, user_no, p_code, sellqty, orderat from sell 
	where user_no = '12003';

select sell_no, sell_date, ui.user_no ,p_code,sellqty, orderat from sell s
	join user_info ui on s.user_no = ui.user_no where ui.user_no = '12003';

select * from sell;
insert into sell values (17,'2021-03-14', '12003', 'PA', 1,null);
delete from sell where sell_no = 17;

update sell set sell_no = 17, sell_date = '2021-03-14', user_no = '12003',
	p_code = 'PA', sellqty =5 ,orderat =1 where sell_no =17;

-- ----------------------------------------------------
-- cart

select cart_no, user_no, p_code, cartqty from cart;

select cart_no, ui.user_no, p_code, cartqty from cart c join user_info ui on c.user_no = ui.user_no where ui.user_no = '12001';

insert into cart values (6, '12008','PG',100);

delete from cart where cart_no = 7;

update cart set cart_no =7, user_no ='12004', p_code ='PC', cartqty =5 where cart_no = 7;



-- -------------------------------
select * from sell ;
select * from user_info ui2 ;

create view  vw_date_search
as
select s.sell_date as '날짜', s.user_no as '회원번호', ui.user_name as '회원명', ui.user_phone as 휴대전화, p.p_code as '제품코드', s.sellqty as 주문수량, (p.p_price * 1.1)*s.sellqty as 판매액
	from sell s left join user_info ui on s.user_no = ui.user_no join product p on s.p_code = p.p_code;


select * from vw_date_search;

select 날짜, 회원번호, 회원명, 휴대전화, 제품코드, 주문수량, 판매액 from vw_date_search ;

create view  vw_date_search2
as
select s.sell_date, s.user_no, ui.user_name, ui.user_phone, p.p_code, s.sellqty, (p.p_price * 1.1)*s.sellqty as orderat 
	from sell s left join user_info ui on s.user_no = ui.user_no join product p on s.p_code = p.p_code;

select * from vw_date_search;

select sell_date, user_no, user_name, user_phone, p_code, sellqty, orderat from vw_date_search2;



