DELIMITER //

CREATE PROCEDURE UpdateEmployeeBonus(
    IN dept_name VARCHAR(50),
    IN bonus_percent DECIMAL(5,2)
)
BEGIN
    UPDATE employees
    SET salary = salary + (salary * (bonus_percent / 100))
    WHERE department = dept_name;
END;
//

DELIMITER ;

-- Example: Add 10% bonus to HR department
CALL UpdateEmployeeBonus('HR', 10);
