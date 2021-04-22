--where do triggers go again??
--triggers
--need to add trigers for interactions particularly date/time for payments,etc

CREATE TRIGGER pledge_date_trigger
AFTER INSERT ON project.pledge.pledge_amt 
FOR EACH ROW 
EXECUTE transaction_timestamp();	--IS this RIGHT FUNCTION?

--Review with Nicole which transactions should have dates auto associated with them
