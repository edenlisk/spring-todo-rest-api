CREATE TABLE IF NOT EXISTS todo (
    id INTEGER NOT NULL AUTO_INCREMENT,
    user_id VARCHAR(50) NOT NULL,
    description VARCHAR(50) NOT NULL,
    category VARCHAR(30) NOT NULL,
    is_completed BOOLEAN NOT NULL,
    target_date DATE NOT NULL,
    PRIMARY KEY (id)
);
--
INSERT INTO todo(user_id, description, category, is_completed, target_date)
VALUES ('user1', 'Learn to Dance', 'Hobby', false, '2021-12-31'),
       ('user1', 'Do Laundry', 'Housework', false, '2021-12-31'),
       ('user1', 'Buy Groceries', 'Shopping', false, '2021-12-31'),
       ('user1', 'Complete Assignment', 'Work', false, '2021-12-31');
