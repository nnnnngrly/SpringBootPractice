-- .sql 파일은 사용한 SQL문을 정리하기 위한 용도

-- 테이블 생성
CREATE TABLE product (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    price INT NOT NULL,
    description VARCHAR(500),
    PRIMARY KEY(id)
);

-- 값 입력
-- id는 auto_increment지만 pk기에 null로 넣어준다.
INSERT INTO product
VALUES (NULL, "pen", 2000, "black pink");