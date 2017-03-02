-- Table: users
CREATE TABLE users (
  id       INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL
)
  ENGINE = InnoDB;

-- Table: roles
CREATE TABLE roles (
  id   INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL
)
  ENGINE = InnoDB;

-- Table for mapping user and roles: user_roles
CREATE TABLE user_roles (
  user_id INT NOT NULL,
  role_id INT NOT NULL,

  FOREIGN KEY (user_id) REFERENCES users (id),
  FOREIGN KEY (role_id) REFERENCES roles (id),

  UNIQUE (user_id, role_id)
)
  ENGINE = InnoDB;

-- Table for mapping teacher and rooms: teacher_rooms
CREATE TABLE teacher_rooms (
  teacher_id INT NOT NULL,
  room_id INT NOT NULL,

  FOREIGN KEY (teacher_id) REFERENCES teachers (record_id),
  FOREIGN KEY (room_id) REFERENCES rooms (record_id),

  UNIQUE (teacher_id, room_id)
)
  ENGINE = InnoDB;

-- Insert data
INSERT INTO users VALUES (1, 'admin', '$2a$11$PhvUUcUvR7iDGo4Qx6uyoODGHpcRuh0i8D.cKfhAC4bhkleui29BO');
INSERT INTO roles VALUES (1, 'ROLE_USER');
INSERT INTO roles VALUES (2, 'ROLE_ADMIN');
INSERT INTO user_roles VALUES (1, 2);