1
select a.s_id as s_id,score1,score2 from
(select s_id, score as score1 from score where c_id='01') a
inner join
(select s_id, score as score2 from score where c_id='02') b
on a.s_id=b.s_id
where score1>score2;

2
select a.s_id as s_id,score1,score2 from
(select s_id, score as score1 from score where c_id='01') a
inner join
(select s_id, score as score2 from score where c_id='02') b
on a.s_id=b.s_id
where score1<score2;

3
select student.s_id as s_id,student.s_name as s_name,b.avg_score as avg_score from student
right join
(select s_id,avg(score) as avg_score from score
group by s_id having avg_score>60) b
on student.s_id=b.s_id;

4
select student.s_id as s_id,student.s_name as s_name,b.avg_score as avg_score from student
right join
(select s_id,avg(score) as avg_score from score
group by s_id having avg_score<60) b
on student.s_id=b.s_id;

5
select s_id, s_name, count(c_id) as c_num, sum(score) as total_score
from total
group by s_id ;

6
select count(t_name) from teacher
where t_name like '李%';

7
select distinct s_id,s_name,s_age,s_sex
from total
where t_name='张三';

8
select * from student
where s_id not in
(select distinct s_id
from total
where t_name='张三');

9
select * from student
where s_id in
(select s_id from score where c_id='01')
and s_id in
(select s_id from score where c_id='02');

10
select * from student
where s_id in
(select s_id from score where c_id='01')
and s_id not in
(select s_id from score where c_id='02');

11
SELECT s_id FROM total GROUP BY s_id HAVING count(c_id)<3;

12
SELECT * FROM student
WHERE s_id IN
(SELECT DISTINCT s_id FROM score
WHERE c_id IN
(SELECT c_id FROM score WHERE s_id='01'));

13
SELECT *FROM student
WHERE s_id IN
(SELECT s_id FROM
(SELECT score.s_id, a.c_id FROM
(select c_id from score where s_id='01') a
INNER JOIN score ON a.c_id=score.c_id) b
WHERE s_id <>'01'
GROUP BY s_id HAVING count(c_id)=
(SELECT count(c_id) FROM score WHERE s_id='01'));


14
select s_id,s_name from student
where s_id not in
(select distinct s_id from total
where t_name='张三');

15
select a.s_id,student.s_name,b.avg_score from
(select s_id from score
where score<60
group by s_id having count(*)>=2) a
left join
student on a.s_id=student.s_id
left join
(select s_id,avg(score) as avg_score
from score
group by s_id) b
on a.s_id=b.s_id;

16
SELECT a.s_id,student.s_name,student.s_age,student.s_sex,a.score from
(SELECT s_id, score FROM score WHERE c_id='01' AND score <60 order BY score DESC)a
LEFT JOIN student on a.s_id = student.s_id;

17
select s_id as '学号',
sum(case c_id when '01' then score else 0 end) as '语文',
sum(case c_id when '02' then score else 0 end) as '数学',
sum(case c_id when '03' then score else 0 end) as '英语',
avg(score) as '平均成绩'
from score
group by s_id
order by '平均成绩' desc;

#18 concat用于拼接字符串，cast调整格式，decimal(5,2)一共5位数，2位小数
select a.c_id as '课程ID',course.c_name as '课程name',
max(a.score) as '最高分',min(a.score) as '最低分',
cast(avg(a.score) as decimal(5,2)) as '平均分',
concat(cast(sum(pass)/count(*)*100 as decimal(5,2)),'%') as '及格率',
concat(cast(sum(medi)/count(*)*100 as decimal(5,2)),'%') as '中等率',
concat(cast(sum(good)/count(*)*100 as decimal(5,2)),'%') as '优良率',
concat(cast(sum(excellent)/count(*)*100 as decimal(5,2)),'%') as '优秀率' from
(select * ,
case when score>=60 then 1 else 0 end as pass,
case when score>=70 and score<80 then 1 else 0 end as medi,
case when score>=80 and score<90 then 1 else 0 end as good,
case when score>=90 then 1 else 0 end as excellent
from score) a
left join course on a.c_id=course.c_id
group by a.c_id;

#19 @局部变量  @@全局变量
select a.*,@rank:=@rank+1 as rank from
(select c_id,sum(score) as '成绩' from score
group by c_id order by sum(score) desc) a,
(select @rank:=0) b;

#20
select a.*,@rank:=@rank+1 as rank from
(select s_id,sum(score) as '总成绩' from score
group by s_id order by sum(score) desc) a,
(select @rank:=0) b;

#21
select t_id,t_name,c_id,avg(score) as avg_score
from total
group by t_id,c_id
order by avg_score desc;

#22
SELECT result.c_id, result.s_id, result.score,
student.s_name,student.s_age,student.s_sex from
(SELECT *, if(@pa=a.c_id, @rank:=@rank+1,@rank:=1) AS rank, @pa:=a.c_id
FROM
(SELECT c_id ,s_id ,score FROM score
GROUP BY c_id, s_id ORDER BY c_id,score DESC)a,
(SELECT @rank:=0, @pa:=NULL) b) result
LEFT JOIN student ON result.s_id=student.s_id
WHERE rank BETWEEN 2 AND 3
GROUP BY c_id, score DESC;


#23
select a.c_id as '课程编号',course.c_name as '课程名称',
sum(level1) as '[100-85]人数', sum(level1)/count(1) as '[100-85]占比',
sum(level2) as '[85-70]人数', sum(level2)/count(1) as '[85-70]占比',
sum(level3) as '[70-60]人数', sum(level3)/count(1) as '[70-60]占比',
sum(level4) as '[0-60]人数', sum(level4)/count(1) as '[0-60]占比' from
(select *,
(case when score between 85 and 100 then 1 else 0 end) as 'level1',
(case when score between 70 and 84 then 1 else 0 end) as 'level2',
(case when score between 60 and 69 then 1 else 0 end) as 'level3',
(case when score between 0 and 59 then 1 else 0 end) as 'level4'
from score) a
left join course on a.c_id=course.c_id
group by a.c_id;

24
select a.*,@rank:=@rank+1 as rank from
(select s_id,avg(score) as '平均成绩' from score
group by s_id order by avg(score) desc) a,
(select @rank:=0) b;

25
select a.c_id,a.s_id,a.score
from score a
WHERE (SELECT count(b.s_id) FROM score b WHERE a.c_id =b.c_id AND a.score <b.score)<3
group by a.c_id,a.s_id;

26
SELECT c_id, count(s_id) as'选修人数'
FROM score GROUP BY c_id;

27
SELECT student.* FROM
(SELECT s_id FROM score GROUP BY s_id HAVING count(c_id) =2)a
LEFT JOIN student on a.s_id=student.s_id;


28
SELECT s_sex as'性别', count(s_sex) as '人数'
FROM student GROUP BY s_sex;

29
SELECT * FROM student WHERE s_name LIKE '%风%';


30
SELECT s_name, num  AS '同名人数' FROM
(SELECT *, count(s_name)-1 as num ##count(s_name)和count(s_id)好像没区别？
FROM student GROUP BY s_name
)a;

31
select s_name from student where year(s_age)='1990';

32 desc放在avg后面，不是c_id后面
SELECT c_id , avg(score) as'平均成绩'
FROM score GROUP BY c_id
ORDER BY avg(score)  desc, c_id;##ORDER BY 平均成绩或者ORDER BY avg(score) ；not ORDER BY '平均成绩'


33
select a.s_id,s_name,平均成绩 from
(SELECT s_id , avg(score) as'平均成绩'
FROM score GROUP BY s_id HAVING 平均成绩>=85)a
left join student on a.s_id=student.s_id;

#34?????????
select s_name, course.c_name, score FROM total
LEFT JOIN course
ON course.c_id = total.c_id
WHERE total.c_id='02' AND score <60;##对的。total.c_id前的total要加上


select s_name,c_id,score from total
where c_id='02' and score<60;

35
SELECT s_id,
sum(case when c_id='01' then score else 0 end) as '语文',
sum(case when c_id='02' then score else 0 end) as '数学',
sum(case when c_id='03' then score else 0 end) as '英语'
FROM total GROUP BY s_id;

#36##############WHERE score > 70;写在最后；not from后面
SELECT total.s_name, course.c_name, score FROM total
LEFT JOIN course
ON course.c_id=total.c_id
WHERE score > 70;


37
SELECT score.c_id, course.c_name, score FROM score
LEFT JOIN course
on score.c_id =course.c_id
WHERE score <60;


38
SELECT a.s_id, student.s_name FROM
(SELECT s_id FROM score WHERE c_id='01' AND score >80)a
LEFT JOIN student
ON student.s_id=a.s_id;

select student.s_id,s_name from student
right join score on student.s_id=score.s_id
where c_id='01' and score>80;

39
SELECT c_id,count(c_id) as'选课人数' FROM score GROUP BY c_id;


SELECT score.c_id,course.c_name, count(score.c_id)as'选课人数' FROM score
LEFT JOIN course ON score.c_id=course.c_id
GROUP BY score.c_id;##GROUP BY score.c_id放在join后面

40
SELECT student.*, a.score FROM
(SELECT s_id, score FROM total WHERE t_name='张三' ORDER BY score DESC LIMIT 1)a
LEFT JOIN student ON a.s_id=student.s_id;

41
SELECT a.s_id, a.c_id,a.score
FROM score a, score b
WHERE a.c_id =b.c_id and a.s_id<>b.s_id and a.score = b.score;

42#union all不去重
(SELECT c_id, s_id FROM score WHERE c_id ='01' ORDER BY score LIMIT 2)
UNION ALL
(select c_id,s_id from score where c_id='02' order by score limit 2)
UNION
(select c_id,s_id from score where c_id='03' order by score limit 2)

43
SELECT c_id, count(s_id) as '选修人数' FROM score
GROUP BY c_id HAVING 选修人数>5
ORDER BY 选修人数 desc, c_id;


44
SELECT s_id FROM score
GROUP BY s_id HAVING count(c_id)>=2;

45
SELECT * FROM student
WHERE s_id IN
(SELECT s_id FROM score GROUP BY s_id HAVING count(c_id)=3);

##排序效率：count(*)=count(1)>count(id)>count(字段)

3=SELECT count(c_id) FROM course;
3=SELECT count(*) FROM course;


46#YEAR(date)，MONTH(date),day()分别返回年份，月份，日
SELECT s_id, s_name, (YEAR(NOW()) - YEAR(s_age)) as age FROM student;

SELECT s_id, s_name, (MONTH(NOW()) - MONTH(s_age)) as `month` FROM student;


SELECT YEAR(NOW()), MONTH(NOW()), DAY(NOW())

47
SELECT s_name, s_age FROM student
WHERE DATE_FORMAT(s_age,'%y-%m-%d')
BETWEEN ADDDATE(CURDATE(),-(DATE_FORMAT(NOW(),'%w')))
and ADDDATE(CURDATE(),7-DATE_FORMAT(NOW(),'%w'));


SELECT ADDDATE(CURDATE(),-(DATE_FORMAT(NOW(),'%w')))##2020-07-26
SELECT ADDDATE(CURDATE(),7-DATE_FORMAT(NOW(),'%w'))##2020-08-02

##如下格式亦可
select s_name,s_age from student
where date_format(s_age,'2020-7-30')

SELECT CURRENT_DATE;##2020-07-30
SELECT DATE_FORMAT(NOW(),'%w');##4%w表示周的天，0-周日，6-周六

select s_name,s_age from student
where date_format(s_age,'2019-%m-%d')
between adddate(curdate(),-(date_format(now(),'%w')))
and adddate(curdate(),7-date_format(now(),'%w'));

##正确格式
SELECT DATE_ADD(NOW(),INTERVAL -2 DAY)#2020-07-28 07:40:01
UNION
SELECT DATE_ADD(NOW(),INTERVAL +2 DAY);#2020-08-01 07:40:01


SELECT DATE_FORMAT(NOW(),'%b %d %Y %h:%i %p')#Jul 30 2020 07:23 AM

48
SELECT s_name, s_age FROM student
WHERE DATE_FORMAT(s_age,'%y-%m-%d')
BETWEEN ADDDATE(CURDATE(),7-(DATE_FORMAT(NOW(),'%w')))
and ADDDATE(CURDATE(),14-DATE_FORMAT(NOW(),'%w'));

49
SELECT s_name, s_age FROM student
WHERE DATE_FORMAT(s_age,'%m')=DATE_FORMAT(NOW(),'%m');

50
SELECT s_name, s_age FROM student
WHERE DATE_FORMAT(s_age,'%m')=DATE_FORMAT(NOW(),'%m')+1;