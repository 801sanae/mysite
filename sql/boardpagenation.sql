--select  rownum, no, name, message
--  from guestbook
--where (page-1)*5+1 <= rownum and rownum <= (page*5) + 1; 


--select  rownum, no, name, message
--  from guestbook
--where 6 <= rownum and rownum <= 10; 


select *
from ( select  rownum as r, no, name, message
       from guestbook)
where 6 <= r;	
  
  select rownum as r, c.*  
  from ( select  no, name, message
         from guestbook
         order by reg_date desc
		) c;


	select  no, name, message
    from guestbook
    order by reg_date desc;

select title, content from board where title LIKE '하%' and content LIKE '%2';

   select a.no,
	      a.title,
	      a.member_no,
          b.name as member_name,
          a.view_cnt,
          to_char(a.reg_date, 'yyyy-mm-dd hh:mi:ss')
     from board a,
          member b
    where a.member_no = b.no
 order by a.reg_date desc;

select * from board;

insert into board values(board_no_seq.nextval, 'a','a',14,1,SYSDATE,1,2,1);

insert
  into board
values ( board_no_seq.nextval, '제목입니다.', '내용입니다.', 2, 0, SYSDATE );

delete board;


