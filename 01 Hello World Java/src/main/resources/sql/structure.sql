CREATE TABLE player (
  id      SERIAL,
  name    VARCHAR(100),
  surname VARCHAR(100),
  PRIMARY KEY (id)
);

CREATE TABLE team (
  id      SERIAL,
  name    VARCHAR(100),
  PRIMARY KEY (id)
);