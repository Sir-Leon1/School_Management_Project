INSERT INTO classes (class_name, no_of_students)
VALUES ('Chicago', 30),
       ('Florida', 30),
       ('Washington', 30),
       ('Texas', 30),
       ('Alabama', 30);

INSERT INTO subjects (subject_name)
VALUES ('Mathematics'),
       ('English'),
       ('Physics'),
       ('Chemistry'),
       ('Biology'),
       ('History'),
       ('Geography'),
       ('Computer Science'),
       ('Physical Education'),
       ('Economics'),
       ('Art');

INSERT INTO teachers (first_name, middle_name, last_name, phone_no, email)
VALUES ('John', 'A.', 'Smith', '0702934175', 'john@vilettech.mail.com'),
       ('Emma', 'B.', 'Johnson', '0702936429', 'emma@vilettech.mail.com'),
       ('James', 'C.', 'Brown', '0702935143', 'james@vilettech.mail.com'),
       ('Sophia', 'D.', 'Williams', '0702937190', 'sophia@vilettech.mail.com'),
       ('Michael', 'E.', 'Jones', '0702938234', 'michael@vilettech.mail.com'),
       ('Olivia', 'F.', 'Garcia', '0702939516', 'olivia@vilettech.mail.com'),
       ('William', 'G.', 'Miller', '0702933687', 'william@vilettech.mail.com'),
       ('Ava', 'H.', 'Davis', '0702934465', 'ava@vilettech.mail.com'),
       ('Alexander', 'I.', 'Martinez', '0702932843', 'alexander@vilettech.mail.com'),
       ('Mia', 'J.', 'Rodriguez', '0702937354', 'mia@vilettech.mail.com'),
       ('Ethan', 'K.', 'Hernandez', '0702935829', 'ethan@vilettech.mail.com');

-- Assigning each teacher to all five classes, teaching a unique subject
INSERT INTO teacher_class_subject (teacher_id, class_id, subject_id)
VALUES
    -- John Smith teaches Mathematics
    (1, 1, 1),
    (1, 2, 1),
    (1, 3, 1),
    (1, 4, 1),
    (1, 5, 1),

    -- Emma Johnson teaches English
    (2, 1, 2),
    (2, 2, 2),
    (2, 3, 2),
    (2, 4, 2),
    (2, 5, 2),

    -- James Brown teaches Physics
    (3, 1, 3),
    (3, 2, 3),
    (3, 3, 3),
    (3, 4, 3),
    (3, 5, 3),

    -- Sophia Williams teaches Chemistry
    (4, 1, 4),
    (4, 2, 4),
    (4, 3, 4),
    (4, 4, 4),
    (4, 5, 4),

    -- Michael Jones teaches Biology
    (5, 1, 5),
    (5, 2, 5),
    (5, 3, 5),
    (5, 4, 5),
    (5, 5, 5),

    -- Olivia Garcia teaches History
    (6, 1, 6),
    (6, 2, 6),
    (6, 3, 6),
    (6, 4, 6),
    (6, 5, 6),

    -- William Miller teaches Geography
    (7, 1, 7),
    (7, 2, 7),
    (7, 3, 7),
    (7, 4, 7),
    (7, 5, 7),

    -- Ava Davis teaches Computer Science
    (8, 1, 8),
    (8, 2, 8),
    (8, 3, 8),
    (8, 4, 8),
    (8, 5, 8),

    -- Alexander Martinez teaches Physical Education
    (9, 1, 9),
    (9, 2, 9),
    (9, 3, 9),
    (9, 4, 9),
    (9, 5, 9),

    -- Mia Rodriguez teaches Economics
    (10, 1, 10),
    (10, 2, 10),
    (10, 3, 10),
    (10, 4, 10),
    (10, 5, 10),

    -- Ethan Hernandez teaches Art
    (11, 1, 11),
    (11, 2, 11),
    (11, 3, 11),
    (11, 4, 11),
    (11, 5, 11);

-- Students for the "United States" class (class_id = 1)
INSERT INTO students (first_name, middle_name, last_name, age, phone1, phone2, email, guardian_phone1, guardian_phone2,
                      guardian_email, class_id)
VALUES ('Alice', 'A.', 'Smith', 16, '0702935612', NULL, 'alice@vilettech.mail.com', '0702934723', NULL,
        'guardian1@vilettech.mail.com', 1),
       ('Ben', 'B.', 'Johnson', 17, '0702938421', '0702936523', 'ben@vilettech.mail.com', '0702931492', NULL,
        'guardian2@vilettech.mail.com', 1),
       ('Charlie', 'C.', 'Williams', 15, '0702933184', NULL, 'charlie@vilettech.mail.com', '0702937854', '0702931283',
        'guardian3@vilettech.mail.com', 1),
       ('Diana', 'D.', 'Brown', 16, '0702931125', '0702937345', 'diana@vilettech.mail.com', '0702936712', NULL,
        'guardian4@vilettech.mail.com', 1),
       ('Ethan', 'E.', 'Jones', 17, '0702935613', NULL, 'ethan@vilettech.mail.com', '0702934724', NULL,
        'guardian5@vilettech.mail.com', 1),
       ('Fiona', 'F.', 'Garcia', 16, '0702935614', NULL, 'fiona@vilettech.mail.com', '0702934725', NULL,
        'guardian6@vilettech.mail.com', 1),
       ('George', 'G.', 'Miller', 15, '0702935615', NULL, 'george@vilettech.mail.com', '0702934726', NULL,
        'guardian7@vilettech.mail.com', 1),
       ('Hannah', 'H.', 'Davis', 16, '0702935616', NULL, 'hannah@vilettech.mail.com', '0702934727', NULL,
        'guardian8@vilettech.mail.com', 1),
       ('Ian', 'I.', 'Martinez', 15, '0702935617', NULL, 'ian@vilettech.mail.com', '0702934728', NULL,
        'guardian9@vilettech.mail.com', 1),
       ('Jane', 'J.', 'Lopez', 16, '0702935618', NULL, 'jane@vilettech.mail.com', '0702934729', NULL,
        'guardian10@vilettech.mail.com', 1),
       ('Kevin', 'K.', 'Gonzalez', 17, '0702935619', NULL, 'kevin@vilettech.mail.com', '0702934730', NULL,
        'guardian11@vilettech.mail.com', 1),
       ('Laura', 'L.', 'Wilson', 16, '0702935620', NULL, 'laura@vilettech.mail.com', '0702934731', NULL,
        'guardian12@vilettech.mail.com', 1),
       ('Mike', 'M.', 'Anderson', 15, '0702935621', NULL, 'mike@vilettech.mail.com', '0702934732', NULL,
        'guardian13@vilettech.mail.com', 1),
       ('Nina', 'N.', 'Thomas', 16, '0702935622', NULL, 'nina@vilettech.mail.com', '0702934733', NULL,
        'guardian14@vilettech.mail.com', 1),
       ('Oscar', 'O.', 'Taylor', 17, '0702935623', NULL, 'oscar@vilettech.mail.com', '0702934734', NULL,
        'guardian15@vilettech.mail.com', 1),
       ('Paula', 'P.', 'Hernandez', 16, '0702935624', NULL, 'paula@vilettech.mail.com', '0702934735', NULL,
        'guardian16@vilettech.mail.com', 1),
       ('Quinn', 'Q.', 'Moore', 15, '0702935625', NULL, 'quinn@vilettech.mail.com', '0702934736', NULL,
        'guardian17@vilettech.mail.com', 1),
       ('Rose', 'R.', 'Martin', 16, '0702935626', NULL, 'rose@vilettech.mail.com', '0702934737', NULL,
        'guardian18@vilettech.mail.com', 1),
       ('Sam', 'S.', 'Jackson', 17, '0702935627', NULL, 'sam@vilettech.mail.com', '0702934738', NULL,
        'guardian19@vilettech.mail.com', 1),
       ('Tina', 'T.', 'Perez', 16, '0702935628', NULL, 'tina@vilettech.mail.com', '0702934739', NULL,
        'guardian20@vilettech.mail.com', 1),
       ('Umar', 'U.', 'White', 15, '0702935629', NULL, 'umar@vilettech.mail.com', '0702934740', NULL,
        'guardian21@vilettech.mail.com', 1),
       ('Vera', 'V.', 'Harris', 16, '0702935630', NULL, 'vera@vilettech.mail.com', '0702934741', NULL,
        'guardian22@vilettech.mail.com', 1),
       ('Will', 'W.', 'Clark', 17, '0702935631', NULL, 'will@vilettech.mail.com', '0702934742', NULL,
        'guardian23@vilettech.mail.com', 1),
       ('Xena', 'X.', 'Lewis', 16, '0702935632', NULL, 'xena@vilettech.mail.com', '0702934743', NULL,
        'guardian24@vilettech.mail.com', 1),
       ('Yara', 'Y.', 'Walker', 15, '0702935633', NULL, 'yara@vilettech.mail.com', '0702934744', NULL,
        'guardian25@vilettech.mail.com', 1),
       ('Zach', 'Z.', 'Young', 16, '0702935634', NULL, 'zach@vilettech.mail.com', '0702934745', NULL,
        'guardian26@vilettech.mail.com', 1),
       ('Ada', 'A.', 'Hall', 15, '0702935635', NULL, 'ada@vilettech.mail.com', '0702934746', NULL,
        'guardian27@vilettech.mail.com', 1),
       ('Bob', 'B.', 'Scott', 16, '0702935636', NULL, 'bob@vilettech.mail.com', '0702934747', NULL,
        'guardian28@vilettech.mail.com', 1),
       ('Cara', 'C.', 'Green', 17, '0702935637', NULL, 'cara@vilettech.mail.com', '0702934748', NULL,
        'guardian29@vilettech.mail.com', 1),
       ('Dave', 'D.', 'Adams', 16, '0702935638', NULL, 'dave@vilettech.mail.com', '0702934749', NULL,
        'guardian30@vilettech.mail.com', 1);

-- Students for the "China" class (class_id = 2)
INSERT INTO students (first_name, middle_name, last_name, age, phone1, phone2, email, guardian_phone1, guardian_phone2,
                      guardian_email, class_id)
VALUES ('Amy', 'A.', 'Zhang', 16, '0702935640', NULL, 'amy@vilettech.mail.com', '0702935750', NULL,
        'guardian31@vilettech.mail.com', 2),
       ('Brian', 'B.', 'Liu', 15, '0702935641', '0702935751', 'brian@vilettech.mail.com', '0702935752', NULL,
        'guardian32@vilettech.mail.com', 2),
       ('Chloe', 'C.', 'Huang', 17, '0702935642', NULL, 'chloe@vilettech.mail.com', '0702935753', '0702935754',
        'guardian33@vilettech.mail.com', 2),
       ('Daniel', 'D.', 'Wu', 16, '0702935643', NULL, 'daniel@vilettech.mail.com', '0702935755', NULL,
        'guardian34@vilettech.mail.com', 2),
       ('Emily', 'E.', 'Chen', 15, '0702935644', '0702935756', 'emily@vilettech.mail.com', '0702935757', NULL,
        'guardian35@vilettech.mail.com', 2),
       ('Felix', 'F.', 'Yang', 16, '0702935645', NULL, 'felix@vilettech.mail.com', '0702935758', NULL,
        'guardian36@vilettech.mail.com', 2),
       ('Grace', 'G.', 'Lin', 17, '0702935646', NULL, 'grace@vilettech.mail.com', '0702935759', NULL,
        'guardian37@vilettech.mail.com', 2),
       ('Harry', 'H.', 'Sun', 15, '0702935647', '0702935760', 'harry@vilettech.mail.com', '0702935761', NULL,
        'guardian38@vilettech.mail.com', 2),
       ('Ivy', 'I.', 'Wang', 16, '0702935648', NULL, 'ivy@vilettech.mail.com', '0702935762', NULL,
        'guardian39@vilettech.mail.com', 2),
       ('Jack', 'J.', 'Xu', 15, '0702935649', '0702935763', 'jack@vilettech.mail.com', '0702935764', NULL,
        'guardian40@vilettech.mail.com', 2),
       ('Kara', 'K.', 'Zhou', 16, '0702935650', NULL, 'kara@vilettech.mail.com', '0702935765', NULL,
        'guardian41@vilettech.mail.com', 2),
       ('Leo', 'L.', 'Tang', 17, '0702935651', NULL, 'leo@vilettech.mail.com', '0702935766', NULL,
        'guardian42@vilettech.mail.com', 2),
       ('Mina', 'M.', 'Feng', 15, '0702935652', '0702935767', 'mina@vilettech.mail.com', '0702935768', NULL,
        'guardian43@vilettech.mail.com', 2),
       ('Nate', 'N.', 'Qin', 16, '0702935653', NULL, 'nate@vilettech.mail.com', '0702935769', NULL,
        'guardian44@vilettech.mail.com', 2),
       ('Olivia', 'O.', 'Yuan', 17, '0702935654', NULL, 'olivia@vilettech.mail.com', '0702935770', NULL,
        'guardian45@vilettech.mail.com', 2),
       ('Paul', 'P.', 'Jin', 16, '0702935655', '0702935771', 'paul2@vilettech.mail.com', '0702935772', NULL,
        'guardian46@vilettech.mail.com', 2),
       ('Quincy', 'Q.', 'Cai', 15, '0702935656', NULL, 'quincy@vilettech.mail.com', '0702935773', NULL,
        'guardian47@vilettech.mail.com', 2),
       ('Ruby', 'R.', 'Shen', 16, '0702935657', NULL, 'ruby@vilettech.mail.com', '0702935774', NULL,
        'guardian48@vilettech.mail.com', 2),
       ('Sam', 'S.', 'Luo', 17, '0702935658', NULL, 'sam2@vilettech.mail.com', '0702935775', NULL,
        'guardian49@vilettech.mail.com', 2),
       ('Tina', 'T.', 'Hao', 16, '0702935659', '0702935776', 'tina2@vilettech.mail.com', '0702935777', NULL,
        'guardian50@vilettech.mail.com', 2),
       ('Ursula', 'U.', 'Pan', 15, '0702935660', NULL, 'ursula@vilettech.mail.com', '0702935778', NULL,
        'guardian51@vilettech.mail.com', 2),
       ('Victor', 'V.', 'Zhang', 16, '0702935661', NULL, 'victor@vilettech.mail.com', '0702935779', NULL,
        'guardian52@vilettech.mail.com', 2),
       ('Wendy', 'W.', 'Gao', 17, '0702935662', NULL, 'wendy@vilettech.mail.com', '0702935780', NULL,
        'guardian53@vilettech.mail.com', 2),
       ('Xander', 'X.', 'Nie', 16, '0702935663', '0702935781', 'xander@vilettech.mail.com', '0702935782', NULL,
        'guardian54@vilettech.mail.com', 2),
       ('Yvonne', 'Y.', 'Bao', 15, '0702935664', NULL, 'yvonne@vilettech.mail.com', '0702935783', NULL,
        'guardian55@vilettech.mail.com', 2),
       ('Zane', 'Z.', 'Wei', 16, '0702935665', NULL, 'zane@vilettech.mail.com', '0702935784', NULL,
        'guardian56@vilettech.mail.com', 2),
       ('Ann', 'A.', 'Hong', 17, '0702935666', NULL, 'ann@vilettech.mail.com', '0702935785', NULL,
        'guardian57@vilettech.mail.com', 2),
       ('Bill', 'B.', 'Kang', 16, '0702935667', '0702935786', 'bill@vilettech.mail.com', '0702935787', NULL,
        'guardian58@vilettech.mail.com', 2),
       ('Cathy', 'C.', 'Shi', 15, '0702935668', NULL, 'cathy@vilettech.mail.com', '0702935788', NULL,
        'guardian59@vilettech.mail.com', 2),
       ('Dean', 'D.', 'Zhu', 16, '0702935669', NULL, 'dean@vilettech.mail.com', '0702935789', NULL,
        'guardian60@vilettech.mail.com', 2);

-- Students for the "Japan" class (class_id = 3)
INSERT INTO students (first_name, middle_name, last_name, age, phone1, phone2, email, guardian_phone1, guardian_phone2,
                      guardian_email, class_id)
VALUES ('Aiko', 'A.', 'Sato', 16, '0702935670', NULL, 'aiko@vilettech.mail.com', '0702935790', NULL,
        'guardian61@vilettech.mail.com', 3),
       ('Benji', 'B.', 'Yamamoto', 15, '0702935671', '0702935791', 'benji@vilettech.mail.com', '0702935792', NULL,
        'guardian62@vilettech.mail.com', 3),
       ('Chiyo', 'C.', 'Tanaka', 17, '0702935672', NULL, 'chiyo@vilettech.mail.com', '0702935793', '0702935794',
        'guardian63@vilettech.mail.com', 3),
       ('Daiki', 'D.', 'Suzuki', 16, '0702935673', NULL, 'daiki@vilettech.mail.com', '0702935795', NULL,
        'guardian64@vilettech.mail.com', 3),
       ('Emiko', 'E.', 'Takahashi', 15, '0702935674', '0702935796', 'emiko@vilettech.mail.com', '0702935797', NULL,
        'guardian65@vilettech.mail.com', 3),
       ('Fumi', 'F.', 'Kobayashi', 16, '0702935675', NULL, 'fumi@vilettech.mail.com', '0702935798', NULL,
        'guardian66@vilettech.mail.com', 3),
       ('Genji', 'G.', 'Yoshida', 17, '0702935676', NULL, 'genji@vilettech.mail.com', '0702935799', NULL,
        'guardian67@vilettech.mail.com', 3),
       ('Hana', 'H.', 'Yamaguchi', 15, '0702935677', '0702935800', 'hana@vilettech.mail.com', '0702935801', NULL,
        'guardian68@vilettech.mail.com', 3),
       ('Ichiro', 'I.', 'Ito', 16, '0702935678', NULL, 'ichiro@vilettech.mail.com', '0702935802', NULL,
        'guardian69@vilettech.mail.com', 3),
       ('Junko', 'J.', 'Nakamura', 15, '0702935679', '0702935803', 'junko@vilettech.mail.com', '0702935804', NULL,
        'guardian70@vilettech.mail.com', 3),
       ('Kenta', 'K.', 'Kato', 16, '0702935680', NULL, 'kenta@vilettech.mail.com', '0702935805', NULL,
        'guardian71@vilettech.mail.com', 3),
       ('Mika', 'M.', 'Kimura', 17, '0702935681', NULL, 'mika@vilettech.mail.com', '0702935806', NULL,
        'guardian72@vilettech.mail.com', 3),
       ('Nao', 'N.', 'Shimizu', 15, '0702935682', '0702935807', 'nao@vilettech.mail.com', '0702935808', NULL,
        'guardian73@vilettech.mail.com', 3),
       ('Oda', 'O.', 'Hayashi', 16, '0702935683', NULL, 'oda@vilettech.mail.com', '0702935809', NULL,
        'guardian74@vilettech.mail.com', 3),
       ('Reiko', 'R.', 'Matsumoto', 17, '0702935684', NULL, 'reiko@vilettech.mail.com', '0702935810', NULL,
        'guardian75@vilettech.mail.com', 3),
       ('Sho', 'S.', 'Inoue', 16, '0702935685', '0702935811', 'sho@vilettech.mail.com', '0702935812', NULL,
        'guardian76@vilettech.mail.com', 3),
       ('Taiki', 'T.', 'Sasaki', 15, '0702935686', NULL, 'taiki@vilettech.mail.com', '0702935813', NULL,
        'guardian77@vilettech.mail.com', 3),
       ('Umi', 'U.', 'Fujita', 16, '0702935687', NULL, 'umi@vilettech.mail.com', '0702935814', NULL,
        'guardian78@vilettech.mail.com', 3),
       ('Yuto', 'Y.', 'Okada', 17, '0702935688', NULL, 'yuto@vilettech.mail.com', '0702935815', NULL,
        'guardian79@vilettech.mail.com', 3),
       ('Zen', 'Z.', 'Ishikawa', 16, '0702935689', '0702935816', 'zen@vilettech.mail.com', '0702935817', NULL,
        'guardian80@vilettech.mail.com', 3),
       ('Ami', 'A.', 'Ueda', 15, '0702935690', NULL, 'ami@vilettech.mail.com', '0702935818', NULL,
        'guardian81@vilettech.mail.com', 3),
       ('Bunji', 'B.', 'Murakami', 16, '0702935691', NULL, 'bunji@vilettech.mail.com', '0702935819', NULL,
        'guardian82@vilettech.mail.com', 3),
       ('Chie', 'C.', 'Takagi', 17, '0702935692', NULL, 'chie@vilettech.mail.com', '0702935820', NULL,
        'guardian83@vilettech.mail.com', 3),
       ('Daichi', 'D.', 'Abe', 16, '0702935693', '0702935821', 'daichi@vilettech.mail.com', '0702935822', NULL,
        'guardian84@vilettech.mail.com', 3),
       ('Eri', 'E.', 'Mori', 15, '0702935694', NULL, 'eri@vilettech.mail.com', '0702935823', NULL,
        'guardian85@vilettech.mail.com', 3),
       ('Fuji', 'F.', 'Ando', 16, '0702935695', NULL, 'fuji@vilettech.mail.com', '0702935824', NULL,
        'guardian86@vilettech.mail.com', 3),
       ('Goro', 'G.', 'Shibata', 17, '0702935696', NULL, 'goro@vilettech.mail.com', '0702935825', NULL,
        'guardian87@vilettech.mail.com', 3),
       ('Hiro', 'H.', 'Miyamoto', 16, '0702935697', '0702935826', 'hiro@vilettech.mail.com', '0702935827', NULL,
        'guardian88@vilettech.mail.com', 3),
       ('Itsuki', 'I.', 'Hirano', 15, '0702935698', NULL, 'itsuki@vilettech.mail.com', '0702935828', NULL,
        'guardian89@vilettech.mail.com', 3),
       ('Jun', 'J.', 'Nagata', 16, '0702935699', NULL, 'jun@vilettech.mail.com', '0702935829', NULL,
        'guardian90@vilettech.mail.com', 3);

-- Students for the "Germany" class (class_id = 4)
INSERT INTO students (first_name, middle_name, last_name, age, phone1, phone2, email, guardian_phone1, guardian_phone2,
                      guardian_email, class_id)
VALUES ('Hans', 'H.', 'Müller', 16, '0702935800', NULL, 'hans@vilettech.mail.com', '0702935900', NULL,
        'guardian91@vilettech.mail.com', 4),
       ('Fritz', 'F.', 'Schmidt', 15, '0702935801', '0702935901', 'fritz@vilettech.mail.com', '0702935902', NULL,
        'guardian92@vilettech.mail.com', 4),
       ('Klara', 'K.', 'Weber', 17, '0702935802', NULL, 'klara@vilettech.mail.com', '0702935903', '0702935904',
        'guardian93@vilettech.mail.com', 4),
       ('Lukas', 'L.', 'Schneider', 16, '0702935803', NULL, 'lukas@vilettech.mail.com', '0702935905', NULL,
        'guardian94@vilettech.mail.com', 4),
       ('Anna', 'A.', 'Fischer', 15, '0702935804', '0702935906', 'anna@vilettech.mail.com', '0702935907', NULL,
        'guardian95@vilettech.mail.com', 4),
       ('Sophie', 'S.', 'Meyer', 16, '0702935805', NULL, 'sophie@vilettech.mail.com', '0702935908', NULL,
        'guardian96@vilettech.mail.com', 4),
       ('Felix', 'F.', 'Hoffmann', 17, '0702935806', NULL, 'felix2@vilettech.mail.com', '0702935909', NULL,
        'guardian97@vilettech.mail.com', 4),
       ('Paul', 'P.', 'Schäfer', 15, '0702935807', '0702935910', 'paul@vilettech.mail.com', '0702935911', NULL,
        'guardian98@vilettech.mail.com', 4),
       ('Lena', 'L.', 'Koch', 16, '0702935808', NULL, 'lena@vilettech.mail.com', '0702935912', NULL,
        'guardian99@vilettech.mail.com', 4),
       ('Jonas', 'J.', 'Bauer', 15, '0702935809', '0702935913', 'jonas@vilettech.mail.com', '0702935914', NULL,
        'guardian100@vilettech.mail.com', 4),
       ('Marie', 'M.', 'Richter', 16, '0702935810', NULL, 'marie@vilettech.mail.com', '0702935915', NULL,
        'guardian101@vilettech.mail.com', 4),
       ('Tom', 'T.', 'Schwarz', 17, '0702935811', NULL, 'tom@vilettech.mail.com', '0702935916', NULL,
        'guardian102@vilettech.mail.com', 4),
       ('Nina', 'N.', 'Klein', 15, '0702935812', '0702935917', 'nina2@vilettech.mail.com', '0702935918', NULL,
        'guardian103@vilettech.mail.com', 4),
       ('Julius', 'J.', 'Wolf', 16, '0702935813', NULL, 'julius@vilettech.mail.com', '0702935919', NULL,
        'guardian104@vilettech.mail.com', 4),
       ('Lia', 'L.', 'Schröder', 17, '0702935814', NULL, 'lia@vilettech.mail.com', '0702935920', NULL,
        'guardian105@vilettech.mail.com', 4),
       ('Leon', 'L.', 'Wagner', 16, '0702935815', '0702935921', 'leon@vilettech.mail.com', '0702935922', NULL,
        'guardian106@vilettech.mail.com', 4),
       ('Mia', 'M.', 'Witt', 15, '0702935816', NULL, 'mia@vilettech.mail.com', '0702935923', NULL,
        'guardian107@vilettech.mail.com', 4),
       ('Elias', 'E.', 'Hahn', 16, '0702935817', NULL, 'elias@vilettech.mail.com', '0702935924', NULL,
        'guardian108@vilettech.mail.com', 4),
       ('Sophie', 'S.', 'Schulte', 17, '0702935818', NULL, 'sophie2@vilettech.mail.com', '0702935925', NULL,
        'guardian109@vilettech.mail.com', 4),
       ('Kian', 'K.', 'Kramer', 16, '0702935819', '0702935926', 'kian@vilettech.mail.com', '0702935927', NULL,
        'guardian110@vilettech.mail.com', 4),
       ('Fiona', 'F.', 'Bergmann', 15, '0702935820', NULL, 'fiona2@vilettech.mail.com', '0702935928', NULL,
        'guardian111@vilettech.mail.com', 4),
       ('David', 'D.', 'Peters', 16, '0702935821', NULL, 'david@vilettech.mail.com', '0702935929', NULL,
        'guardian112@vilettech.mail.com', 4),
       ('Elena', 'E.', 'Lang', 17, '0702935822', NULL, 'elena@vilettech.mail.com', '0702935930', NULL,
        'guardian113@vilettech.mail.com', 4),
       ('Theo', 'T.', 'Neumann', 16, '0702935823', '0702935931', 'theo@vilettech.mail.com', '0702935932', NULL,
        'guardian114@vilettech.mail.com', 4),
       ('Nora', 'N.', 'Walter', 15, '0702935824', NULL, 'nora@vilettech.mail.com', '0702935933', NULL,
        'guardian115@vilettech.mail.com', 4),
       ('Milo', 'M.', 'Schmitt', 16, '0702935825', NULL, 'milo@vilettech.mail.com', '0702935934', NULL,
        'guardian116@vilettech.mail.com', 4),
       ('Paula', 'P.', 'Hoffmann', 17, '0702935826', NULL, 'paula2@vilettech.mail.com', '0702935935', NULL,
        'guardian117@vilettech.mail.com', 4),
       ('Jonas', 'J.', 'Fuchs', 16, '0702935827', '0702935936', 'jonas2@vilettech.mail.com', '0702935937', NULL,
        'guardian118@vilettech.mail.com', 4),
       ('Mara', 'M.', 'Krause', 15, '0702935828', NULL, 'mara@vilettech.mail.com', '0702935938', NULL,
        'guardian119@vilettech.mail.com', 4),
       ('Luka', 'L.', 'Franke', 16, '0702935829', NULL, 'luka@vilettech.mail.com', '0702935939', NULL,
        'guardian120@vilettech.mail.com', 4),
       ('Leonie', 'L.', 'Götz', 17, '0702935830', NULL, 'leonie@vilettech.mail.com', '0702935940', NULL,
        'guardian121@vilettech.mail.com', 4),
       ('Tim', 'T.', 'Ziegler', 16, '0702935831', '0702935941', 'tim@vilettech.mail.com', '0702935942', NULL,
        'guardian122@vilettech.mail.com', 4),
       ('Amelie', 'A.', 'Schulte', 15, '0702935832', NULL, 'amelie@vilettech.mail.com', '0702935943', NULL,
        'guardian123@vilettech.mail.com', 4);

-- Students for the "South Korea" class (class_id = 5)
INSERT INTO students (first_name, middle_name, last_name, age, phone1, phone2, email, guardian_phone1, guardian_phone2,
                      guardian_email, class_id)
VALUES ('Min-Joon', 'M.', 'Kim', 16, '0702935900', NULL, 'min-joon@vilettech.mail.com', '0702936000', NULL,
        'guardian131@vilettech.mail.com', 5),
       ('Seo-Yeon', 'S.', 'Lee', 15, '0702935901', '0702936001', 'seo-yeon@vilettech.mail.com', '0702936002', NULL,
        'guardian132@vilettech.mail.com', 5),
       ('Ji-Hoon', 'J.', 'Park', 17, '0702935902', NULL, 'ji-hoon@vilettech.mail.com', '0702936003', '0702936004',
        'guardian133@vilettech.mail.com', 5),
       ('Soo-Jin', 'S.', 'Jeong', 16, '0702935903', NULL, 'soo-jin@vilettech.mail.com', '0702936005', NULL,
        'guardian134@vilettech.mail.com', 5),
       ('Tae-Hyun', 'T.', 'Choi', 15, '0702935904', '0702936006', 'tae-hyun@vilettech.mail.com', '0702936007', NULL,
        'guardian135@vilettech.mail.com', 5),
       ('Yuna', 'Y.', 'Kang', 16, '0702935905', NULL, 'yuna@vilettech.mail.com', '0702936008', NULL,
        'guardian136@vilettech.mail.com', 5),
       ('Hyun-Woo', 'H.', 'Lim', 17, '0702935906', NULL, 'hyun-woo@vilettech.mail.com', '0702936009', NULL,
        'guardian137@vilettech.mail.com', 5),
       ('Jin-Soo', 'J.', 'Han', 15, '0702935907', '0702936010', 'jin-soo@vilettech.mail.com', '0702936011', NULL,
        'guardian138@vilettech.mail.com', 5),
       ('Hana', 'H.', 'Seo', 16, '0702935908', NULL, 'hana2@vilettech.mail.com', '0702936012', NULL,
        'guardian139@vilettech.mail.com', 5),
       ('Dae-Ho', 'D.', 'Yoon', 15, '0702935909', '0702936013', 'dae-ho@vilettech.mail.com', '0702936014', NULL,
        'guardian140@vilettech.mail.com', 5),
       ('Bora', 'B.', 'Ryu', 16, '0702935910', NULL, 'bora@vilettech.mail.com', '0702936015', NULL,
        'guardian141@vilettech.mail.com', 5),
       ('Kyung-Soo', 'K.', 'Shin', 17, '0702935911', NULL, 'kyung-soo@vilettech.mail.com', '0702936016', NULL,
        'guardian142@vilettech.mail.com', 5),
       ('Eun-Ji', 'E.', 'Song', 15, '0702935912', '0702936017', 'eun-ji@vilettech.mail.com', '0702936018', NULL,
        'guardian143@vilettech.mail.com', 5),
       ('Seung-Won', 'S.', 'Ahn', 16, '0702935913', NULL, 'seung-won@vilettech.mail.com', '0702936019', NULL,
        'guardian144@vilettech.mail.com', 5),
       ('Na-Rae', 'N.', 'Hwang', 17, '0702935914', NULL, 'na-rae@vilettech.mail.com', '0702936020', NULL,
        'guardian145@vilettech.mail.com', 5),
       ('Joon-Seo', 'J.', 'Chun', 16, '0702935915', '0702936021', 'joon-seo@vilettech.mail.com', '0702936022', NULL,
        'guardian146@vilettech.mail.com', 5),
       ('Hye-Jin', 'H.', 'Kwon', 15, '0702935916', NULL, 'hye-jin@vilettech.mail.com', '0702936023', NULL,
        'guardian147@vilettech.mail.com', 5),
       ('Dong-Hyun', 'D.', 'Hwang', 16, '0702935917', NULL, 'dong-hyun@vilettech.mail.com', '0702936024', NULL,
        'guardian148@vilettech.mail.com', 5),
       ('Soo-Min', 'S.', 'Yoon', 17, '0702935918', NULL, 'soo-min@vilettech.mail.com', '0702936025', NULL,
        'guardian149@vilettech.mail.com', 5),
       ('Kwang-Soo', 'K.', 'Suh', 16, '0702935919', '0702936026', 'kwang-soo@vilettech.mail.com', '0702936027', NULL,
        'guardian150@vilettech.mail.com', 5),
       ('Ji-Hye', 'J.', 'Lim', 15, '0702935920', NULL, 'ji-hye@vilettech.mail.com', '0702936028', NULL,
        'guardian151@vilettech.mail.com', 5),
       ('Hyun-Jung', 'H.', 'Yoo', 16, '0702935921', NULL, 'hyun-jung@vilettech.mail.com', '0702936029', NULL,
        'guardian152@vilettech.mail.com', 5),
       ('Jae-Woo', 'J.', 'Kim', 17, '0702935922', NULL, 'jae-woo@vilettech.mail.com', '0702936030', NULL,
        'guardian153@vilettech.mail.com', 5),
       ('Ha-Na', 'H.', 'Jung', 16, '0702935923', '0702936031', 'ha-na@vilettech.mail.com', '0702936032', NULL,
        'guardian154@vilettech.mail.com', 5),
       ('Sung-Jin', 'S.', 'Oh', 15, '0702935924', NULL, 'sung-jin@vilettech.mail.com', '0702936033', NULL,
        'guardian155@vilettech.mail.com', 5),
       ('Yu-Na', 'Y.', 'Jeong', 16, '0702935925', NULL, 'yu-na@vilettech.mail.com', '0702936034', NULL,
        'guardian156@vilettech.mail.com', 5),
       ('Woo-Jin', 'W.', 'Koo', 17, '0702935926', NULL, 'woo-jin@vilettech.mail.com', '0702936035', NULL,
        'guardian157@vilettech.mail.com', 5),
       ('Jin-Young', 'J.', 'Park', 16, '0702935927', '0702936036', 'jin-young@vilettech.mail.com', '0702936037', NULL,
        'guardian158@vilettech.mail.com', 5),
       ('Seol-Hee', 'S.', 'Han', 15, '0702935928', NULL, 'seol-hee@vilettech.mail.com', '0702936038', NULL,
        'guardian159@vilettech.mail.com', 5),
       ('Soo-Ja', 'S.', 'Lee', 16, '0702935929', NULL, 'soo-ja@vilettech.mail.com', '0702936039', NULL,
        'guardian160@vilettech.mail.com', 5);
