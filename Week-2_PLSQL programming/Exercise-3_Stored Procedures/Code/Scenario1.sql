-- Optional: Drop old version
DROP PROCEDURE IF EXISTS ProcessMonthlyInterest;

DELIMITER //

CREATE PROCEDURE ProcessMonthlyInterest()
BEGIN
    DECLARE done INT DEFAULT 0;
    DECLARE aid INT;
    DECLARE abalance DECIMAL(12,2);

    DECLARE cur CURSOR FOR 
        SELECT account_id, balance 
        FROM accounts 
        WHERE account_type = 'savings';

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;

    OPEN cur;
    read_loop: LOOP
        FETCH cur INTO aid, abalance;
        IF done THEN
            LEAVE read_loop;
        END IF;

        -- Update balance with 1% interest
        UPDATE accounts
        SET balance = abalance + (abalance * 0.01)
        WHERE account_id = aid;

        -- Print output message
        SELECT CONCAT('Applied 1% interest to account ID ', aid, 
                      ' | Old balance: ', abalance, 
                      ' | New balance: ', abalance + (abalance * 0.01)) AS message;
    END LOOP;
    CLOSE cur;
END;
//

DELIMITER ;

-- Run it
CALL ProcessMonthlyInterest();
