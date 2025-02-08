-- 🔹 기존 테이블이 존재하면 삭제
DROP TABLE IF EXISTS user_like CASCADE;
DROP TABLE IF EXISTS availability CASCADE;
DROP TABLE IF EXISTS content_cast CASCADE;
DROP TABLE IF EXISTS actor CASCADE;
DROP TABLE IF EXISTS content CASCADE;
DROP TABLE IF EXISTS ott CASCADE;
DROP TABLE IF EXISTS app_user CASCADE;

-- 🔹 사용자 테이블
CREATE TABLE app_user (
                          user_id SERIAL PRIMARY KEY,
                          email VARCHAR(255) UNIQUE NOT NULL,
                          password VARCHAR(255) NOT NULL
);

-- 🔹 OTT 서비스 테이블
CREATE TABLE ott (
                     ott_id SERIAL PRIMARY KEY,
                     ott_name VARCHAR(255) NOT NULL
);

-- 🔹 콘텐츠 테이블
CREATE TABLE content (
                         content_id SERIAL PRIMARY KEY,
                         title TEXT NOT NULL,
                         description TEXT NOT NULL,
                         category VARCHAR(50) CHECK (category IN ('DRAMA', 'MOVIE', 'ENTERTAINMENT', 'ANIMATION', 'KIDS'))
);


-- 🔹 Full-Text Search 인덱스 생성
CREATE INDEX content_search_idx ON content USING GIN (search_vector);

-- 🔹 배우 테이블
CREATE TABLE actor (
                       cast_id SERIAL PRIMARY KEY,
                       cast_name VARCHAR(255) NOT NULL
);

-- 🔹 콘텐츠-배우 매핑 테이블 (N:M 관계)
CREATE TABLE content_cast (
                              id SERIAL PRIMARY KEY,
                              content_id INT REFERENCES content(content_id) ON DELETE CASCADE,
                              cast_id INT REFERENCES actor(cast_id) ON DELETE CASCADE
);

-- 🔹 콘텐츠 제공 상태 테이블
CREATE TABLE availability (
                              availablity_id SERIAL PRIMARY KEY,
                              content_id INT REFERENCES content(content_id) ON DELETE CASCADE,
                              ott_id INT REFERENCES ott(ott_id) ON DELETE CASCADE,
                              content_status VARCHAR(50) CHECK (content_status IN ('FREE', 'SUBSCRIBER_PROVISION', 'INDIVIDUAL_PURCHASE', 'NOT_PROVIDED'))
);

-- 🔹 좋아요 테이블 (유저가 콘텐츠 좋아요)
CREATE TABLE user_like (
                           like_id SERIAL PRIMARY KEY,
                           user_id INT REFERENCES app_user(user_id) ON DELETE CASCADE,
                           content_id INT REFERENCES content(content_id) ON DELETE CASCADE,
                           UNIQUE(user_id, content_id) -- 중복 좋아요 방지
);

-- 기존 GIN 인덱스 삭제
DROP INDEX IF EXISTS content_search_idx;


-- PGroonga 기반의 검색 인덱스 생성
CREATE INDEX content_search_idx ON content USING PGroonga (title, description);
