CREATE TABLE IF NOT EXISTS todos (
    id INTEGER NOT NULL AUTO_INCREMENT,
    userId VARCHAR(50) NOT NULL,
    description VARCHAR(50) NOT NULL,
    category VARCHAR(30) NOT NULL,
    isCompleted BOOLEAN NOT NULL,
    targetDate DATE NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO todos(userId, description, category, isCompleted, targetDate)
VALUES ('user1', 'Learn to Dance', 'Hobby', false, '2021-12-31'),
       ('user1', 'Do Laundry', 'Housework', false, '2021-12-31'),
       ('user1', 'Buy Groceries', 'Shopping', false, '2021-12-31'),
       ('user1', 'Complete Assignment', 'Work', false, '2021-12-31');
