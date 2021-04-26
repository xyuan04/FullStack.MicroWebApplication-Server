TRUNCATE TABLE messages;

INSERT INTO messages (MESSAGE_BODY, DATETIME_CREATED, USER_SENDER_ID, CHANNEL_ID, DM_ID)
VALUES
('This is message 1.', 2021-04-21, 1, 1, null),
('This is message 2.', 2021-04-22, 2,2, null),
('This is message 3.', 2021-04-23, 11, null, 1),
('This is message 4.', 2021-04-24, 4, 6, null),
('This is message 5.', 2021-04-25, 6, null, 2),
('This is message 6.', 2021-04-26, 3, null, 3),
('This is message 7.', 2021-04-27, 7, null, 2),
('This is message 8.', 2021-04-28, 4, 6, null),
('This is message 9.', 2021-04-20, 3, 5, null);
