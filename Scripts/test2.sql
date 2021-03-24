-- 
select * from vw_date_search ;

select sum(sell) as 'ㅁㄴㅇㄹ'  from vw_date_search;

select * from sell;

select sum(sellqty) from sell where sell_date ='2012-03-24';

select * from product p ;
select * from sell s;
select * from vw_date_search2;

select s.sell_date, p.p_code, p.p_name, s.sellqty, p.p_price,(p.p_price*s.sellqty)*1.1 as total  from product p join sell s where s.p_code =p.p_code ;

create view vw_product_search
as
select vds.sell_date, vds.p_code, p.p_name,vds.sellqty, p.p_price, vds.orderat, vds.orderat-(p.p_price*vds.sellqty)as margin
	from vw_date_search2 vds join product p where vds.p_code = p.p_code ;
	
select * from vw_product_search ;