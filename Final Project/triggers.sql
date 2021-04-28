--where do triggers go again??
--triggers
--need to add trigers for interactions particularly date/time for payments,etc
DROP TRIGGER pledge_date_trigger;
DROP TRIGGER scholarship_amt_paid_date_trigger;


CREATE TRIGGER pledge_date_trigger
AFTER INSERT ON project.pledge.pledge_amt 
FOR EACH ROW 
EXECUTE transaction_timestamp() ON project.pledge.date_pledged ;	--IS this RIGHT FUNCTION?

CREATE TRIGGER scholarship_amt_paid_date_trigger
AFTER INSERT ON project.scholarship.amt_paid 
FOR EACH ROW 
EXECUTE transaction_timestamp();

--Review with Nicole which transactions should have dates auto associated with them
