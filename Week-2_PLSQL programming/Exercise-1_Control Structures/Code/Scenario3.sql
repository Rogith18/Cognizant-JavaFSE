DELIMITER //

CREATE PROCEDURE SendLoanReminders()
BEGIN
    DECLARE done INT DEFAULT 0;
    DECLARE cname VARCHAR(100);
    DECLARE due DATE;
    DECLARE cur CURSOR FOR
        SELECT c.name, l.due_date
        FROM customers c
        JOIN loans l ON c.customer_id = l.customer_id
        WHERE l.due_date BETWEEN CURDATE() AND CURDATE() + INTERVAL 30 DAY;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;

    OPEN cur;
    read_loop: LOOP
        FETCH cur INTO cname, due;
        IF done THEN
            LEAVE read_loop;
        END IF;

        SELECT CONCAT('Reminder: Loan for ', cname, ' is due on ', due) AS Reminder;
    END LOOP;
    CLOSE cur;
END;
//

DELIMITER ;

-- To run:
CALL SendLoanReminders();
