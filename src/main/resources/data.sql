-- app_user 데이터
INSERT INTO app_user (email, password)
VALUES ('user1@example.com', 'password123'),
       ('user2@example.com', 'securepass456'),
       ('user3@example.com', 'qwerty789');

-- content 데이터
INSERT INTO content (title, description, category)
VALUES ('Movie A', 'An exciting adventure film.', 'ACTION'),
       ('Movie B', 'A heartwarming drama.', 'DRAMA'),
       ('Movie C', 'A thrilling sci-fi epic.', 'SCI_FI'),
       ('Movie D', 'A romantic comedy.', 'ROMANCE'),
       ('Movie E', 'A suspenseful mystery.', 'MYSTERY'),
       ('Movie F', 'An animated family favorite.', 'ANIMATION'),
       ('Movie G', 'A historical drama.', 'HISTORY'),
       ('Movie H', 'A gripping horror movie.', 'HORROR'),
       ('Movie I', 'An inspiring sports story.', 'SPORTS'),
       ('Movie J', 'A classic documentary.', 'DOCUMENTARY');

-- ott 데이터
INSERT INTO ott (ott_name)
VALUES ('Wavve');

-- actor 데이터
INSERT INTO actor (cast_name)
VALUES ('Actor A'),
       ('Actor B'),
       ('Actor C'),
       ('Actor D'),
       ('Actor E');

-- content_cast 데이터
INSERT INTO content_cast (content_id, cast_id)
VALUES (1, 1),
       (1, 2),
       (2, 3),
       (3, 4),
       (4, 1),
       (5, 5),
       (6, 3),
       (7, 2),
       (8, 4),
       (9, 1);

-- user_like 데이터
INSERT INTO user_like (user_id, content_id)
VALUES (1, 1),
       (1, 3),
       (2, 4),
       (2, 5),
       (3, 6),
       (3, 2),
       (1, 8),
       (2, 9);

-- availability 데이터
INSERT INTO availability (content_id, ott_id, content_status)
VALUES (1, 1, 'FREE'),
       (2, 1, 'SUBSCRIBER_PROVISION'),
       (3, 1, 'INDIVIDUAL_PURCHASE'),
       (4, 1, 'FREE'),
       (5, 1, 'NOT_PROVIDED'),
       (6, 1, 'SUBSCRIBER_PROVISION'),
       (7, 1, 'INDIVIDUAL_PURCHASE'),
       (8, 1, 'FREE'),
       (9, 1, 'FREE'),
       (10, 1, 'NOT_PROVIDED');
