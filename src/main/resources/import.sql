# TRUNCATE TABLE CHANNEL;

INSERT INTO CHANNEL (NAME)
VALUES ('ANIME'),
       ('SPORTS'),
       ('MOVIES'),
       ('ZIPCODE'),
       ('ANIMALS'),
       ('WALLSTREETBETS'),
       ('CARS'),
       ('SHOPPING'),
       ('GAMES');

# TRUNCATE TABLE DIRECT_MESSAGE;

INSERT INTO DIRECT_MESSAGE (NAME)
VALUES ('KELLY'),
       ('RYAN'),
       ('XIONG'),
       ('YOUNGER'),
       ('DOLIO'),
       ('DAN'),
       ('DESA');

# TRUNCATE TABLE message;

INSERT INTO messages (MESSAGE_BODY, DATETIME_CREATED, USER_SENDER_ID, CHANNEL_ID, DM_ID)
VALUES
('This is message 1.', '2021-04-21', 1, 1, null),
('This is message 2.', '2021-04-22', 2,2, null),
('This is message 3.', '2021-04-23', 11, null, 1),
('This is message 4.', '2021-04-24', 4, 6, null),
('This is message 5.', '2021-04-25', 6, null, 2),
('This is message 6.', '2021-04-26', 3, null, 3),
('This is message 7.', '2021-04-27', 7, null, 2),
('This is message 8.', '2021-04-28', 4, 6, null),
('This is message 9.', '2021-04-20', 3, 5, null);

# TRUNCATE TABLE USER;

INSERT INTO USER_PROFILE (NAME, USER_NAME, PASSWORD, EMAIL)
VALUES ('Kelly Porter', 'Kelly', 'password', 'kelly@gmail.com'),
       ('Xiong Yuan', 'Xiong', '12345', 'xiong@gmail.com'),
       ('Ryan Hufford', 'Ryan', 'abcde', 'ryan@gmail.com'),
       ('Greg Don', 'Gerg', 'aaaaa', 'greg@gmail.com'),
       ('Jorge Tapia', 'Jorge', 'password', 'jorge@gmail.com'),
       ('Abeil Figueroa', 'Abe', '12345', 'abeil@gmail.com'),
       ('Adam Bennett', 'Adam', 'abcde', 'adam@gmail.com'),
       ('Desa Burton', 'Desa', 'aaaaa', 'desa@gmail.com'),
       ('Liz Thorpe', 'Liz', 'password', 'liz@gmail.com'),
       ('Will Ferrel', 'Will', '12345', 'will@gmail.com'),
       ('Ronald McDonald', 'Ronald', 'abcde', 'ronald@gmail.com'),
       ('lil Sebastian', 'Sebastian', 'aaaaa', 'sebastian@gmail.com');