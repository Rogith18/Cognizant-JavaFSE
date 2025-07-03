DELIMITER //

CREATE PROCEDURE ApplySeniorDiscount()
BEGIN
    DECLARE done INT DEFAULT 0;
    DECLARE cid INT;
    DECLARE cname VARCHAR(100);
    DECLARE cur CURSOR FOR
        SELECT c.customer_id, c.name
        FROM customers c
        JOIN loans l ON c.customer_id = l.customer_id
        WHERE c.age > 60;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;

    OPEN cur;
    read_loop: LOOP
        FETCH cur INTO cid, cname;
        IF done THEN
            LEAVE read_loop;
        END IF;

        -- Apply 1% discount on interest
        UPDATE loans
        SET interest_rate = interest_rate - 1
        WHERE customer_id = cid;

        -- Show output
        SELECT CONCAT('Applied 1% discount to customer ', cname, ' (ID: ', cid, ')') AS message;
    END LOOP;
    CLOSE cur;
END;
//

DELIMITER ;

-- To run the procedure:
CALL ApplySeniorDiscount();
