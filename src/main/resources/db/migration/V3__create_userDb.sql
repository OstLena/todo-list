CREATE TABLE IF NOT EXISTS user_table (
  user_id BIGINT AUTO_INCREMENT PRIMARY KEY,
  username varchar(45) NOT NULL,
  password varchar(64) NOT NULL,
  role varchar(45) NOT NULL,
  enabled tinyint
);
