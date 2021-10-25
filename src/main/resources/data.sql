DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS wish_list;
DROP TABLE IF EXISTS wish_item;

CREATE TABLE users (
                              username VARCHAR(50) PRIMARY KEY,
                              password VARCHAR(20) NOT NULL,
                              role VARCHAR DEFAULT 'ROLE_USER'
);

CREATE TABLE wish_list (
                          id INT AUTO_INCREMENT  PRIMARY KEY,
                          name_list VARCHAR(200) NOT NULL,
                          user_id VARCHAR(50),
                          FOREIGN KEY (user_id) REFERENCES users(username)
);

CREATE TABLE wish_item (
                           id VARCHAR(100)  PRIMARY KEY,
                           title VARCHAR(200),
                           idBook VARCHAR(100),
                           cantidad INT,
                           id_wish_list INT,
                           FOREIGN KEY (id_wish_list) REFERENCES wish_list(id)
);

