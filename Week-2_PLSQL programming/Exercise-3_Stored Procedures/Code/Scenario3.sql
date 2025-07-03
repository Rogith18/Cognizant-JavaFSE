DELIMITER //

CREATE PROCEDURE TransferFunds(
    IN from_account INT,
    IN to_account INT,
    IN amount DECIMAL(12,2)
)
BEGIN
    DECLARE from_balance DECIMAL(12,2);

    -- Check balance of source account
    SELECT balance INTO from_balance
    FROM accounts
    WHERE account_id = from_account;

    IF from_balance >= amount THEN
        -- Deduct from source
        UPDATE accounts
        SET balance = balance - amount
        WHERE account_id = from_account;

        -- Add to destination
        UPDATE accounts
        SET balance = balance + amount
        WHERE account_id = to_account;

        SELECT 'Transfer successful' AS status;
    ELSE
        SELECT 'Insufficient funds' AS status;
    END IF;
END;
//

DELIMITER ;

-- Example usage:
CALL TransferFunds(1, 2, 500.00);
