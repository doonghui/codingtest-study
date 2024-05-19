select sum(gr.SCORE) as SCORE,gr.EMP_NO,emp.EMP_NAME,emp.POSITION,emp.EMAIL from HR_GRADE as gr join HR_EMPLOYEES as emp on gr.EMP_NO = emp.EMP_NO 
group by gr.EMP_NO order by sum(gr.SCORE) desc limit 1;


