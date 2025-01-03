DROP TABLE IF EXISTS content_cast;
DROP TABLE IF EXISTS availability;
DROP TABLE IF EXISTS user_like;
DROP TABLE IF EXISTS actor;
DROP TABLE IF EXISTS content;
DROP TABLE IF EXISTS ott;
DROP TABLE IF EXISTS app_user;

CREATE TABLE app_user (
    user_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE content (
     content_id BIGINT AUTO_INCREMENT PRIMARY KEY,
     title VARCHAR(255) NOT NULL,
     description TEXT,
     category VARCHAR(50) NOT NULL
);

CREATE TABLE ott (
    ott_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    ott_name VARCHAR(255) NOT NULL
);

CREATE TABLE actor (
    cast_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    cast_name VARCHAR(255) NOT NULL
);

CREATE TABLE content_cast (
      id BIGINT AUTO_INCREMENT PRIMARY KEY,
      content_id BIGINT NOT NULL,
      cast_id BIGINT NOT NULL,
      CONSTRAINT fk_content_cast_content
        FOREIGN KEY (content_id) REFERENCES content(content_id),
      CONSTRAINT fk_content_cast_cast
        FOREIGN KEY (cast_id) REFERENCES actor(cast_id)
);

CREATE TABLE user_like (
    like_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    content_id BIGINT NOT NULL,
    CONSTRAINT fk_like_user
      FOREIGN KEY (user_id) REFERENCES app_user(user_id),
    CONSTRAINT fk_like_content
      FOREIGN KEY (content_id) REFERENCES content(content_id)
);

CREATE TABLE availability (
      availablity_id BIGINT AUTO_INCREMENT PRIMARY KEY,
      content_id BIGINT NOT NULL,
      ott_id BIGINT NOT NULL,
      content_status VARCHAR(50) NOT NULL,
      CONSTRAINT fk_availability_content
          FOREIGN KEY (content_id) REFERENCES content(content_id),
      CONSTRAINT fk_availability_ott
          FOREIGN KEY (ott_id) REFERENCES ott(ott_id)
);



