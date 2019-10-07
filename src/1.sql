-- Emp 사원의 정보
-- Dept 부서 정보
-- Salgrade 급여 등급 정보

-- 사원 이름이 SMITH인 사람의 부서명??
select deptno from emp
where ename = 'SMITH'
select dname from DEPT
where deptno = 20

-- Sub Query
select dname from dept
where deptno = (select deptno from emp where ename = 'SMITH')

-- SMITH 사원의 상사 이름?
select ename from EMP
where empno = (select mgr from emp where ename = 'SMITH')

-- FORD의 상사 부서명?
select dname from dept
where deptno = (select deptno from emp where empno = (select mgr from emp where ename = 'FORD'))

-- 평균 급여보다 높은 급여를 받는 사람들의 이름과 월급을 조회
select ename, sal from EMP
where sal > (select avg(sal) from emp)

-- SMITH 사원과 같은 직종이면서, 급여를 SMITH보다 많이 받는 사원들의 이름, 직종, 월급 조회
select ename, job, sal from EMP
where job = (select job from emp where ename = 'SMITH') and sal>(select sal from emp where ename = 'SMITH')

-- MILLER 사원의 급여등급?
select grade from salgrade
where losal <= (select sal from emp where ename='MILLER')
and hisal >= (select sal from emp where ename='MILLER')

-- KING 사원과 같은 부서의 사원들 중에서 가장 급여를 적게 받는 사원의 급여 등급?
select grade from salgrade
where (select min(sal) from emp where deptno = (select deptno from emp where ename = 'KING')) between losal and hisal

-- Newyork에 근무하는 부서원들의 평균 급여 등급과 동일한 등급의 사원들의 정보
select * from EMP
where sal >= (select losal from salgrade 
where grade = (select grade from salgrade 
where (select avg(sal) from emp 
where deptno = (select deptno from dept 
where loc = 'NEW YORK')) between losal and hisal))

and sal <= (select hisal from salgrade 
where grade = (select grade from salgrade 
where (select avg(sal) from emp 
where deptno = (select deptno from dept 
where loc = 'NEW YORK')) between losal and hisal))

-- 평균급여보다 많이 받는 사원들의 부서명, 지역명
select dname, loc from DEPT where deptno = (select deptno from emp where sal > (select avg(sal) from emp)) -- (X)

select dname, loc from DEPT where deptno in ((select deptno from emp where sal > (select avg(sal) from emp))) -- (O)
select dname, loc from DEPT where deptno not in ((select deptno from emp where sal > (select avg(sal) from emp)))

select dname, loc from dept where deptno in (10, 20, 30)

-- 20번 부서의 사원들의 급여보다 많이 받는 사람들
select ename from EMP
where sal > (select sal from emp where deptno = 20) -- (X)

select ename from EMP
where sal > (select min(sal) from emp where deptno = 20) -- (O)

select ename from EMP
where sal > any (select sal from emp where deptno = 20) -- (O)

----------------------------------------------------------------------------------------

select  from (select sum(sal) s, avg(sal) a from emp) E -- 가상의 테이블 형성 및 테이블명 E로 명명

select deptno, sum(sal) s, avg(sal) a from emp
group by deptno
having avg(sal)> 2000

select * from
(select deptno, sum(Sal) s, avg(sal) a from emp
group by deptno) G
where a >2000

----------------------------------------------------------------------
-- 사원의 이름이 SMITH, 사번, 직종, 부서명, 지역명
select empno, job from emp where ename = 'SMITH'
select dname, loc from dept where deptno = (select deptno from emp where ename = 'SMITH')

select dname, loc from dept where deptno = (select deptno from emp where ename = 'SMITH'))

-- Oracle 전용 문구
select * from emp, dept
where emp.deptno = dept.deptno

select count(empno) from emp
select count(deptno) from dept

-- ANSI 조인
	-- SELECT
	-- FROM 테이블명A {(INNER / LEFT / RIGHT / OUTER, NATURAL, SELF)} JOIN 테이블명B
	-- ON {A.컬럼명 = B.컬럼명} / USING(컬럼명)
	-- WHERE 조건식

SELECT E.empno, E.job, E.deptno, D.dname, D.loc 
from emp E inner join dept D
on E.deptno = D.deptno
where ename = 'SMITH'

SELECT E.empno, E.job, E.deptno, D.dname, D.loc 
from emp E inner join dept D
on E.deptno = D.deptno
where ename = 'SMITH'
















