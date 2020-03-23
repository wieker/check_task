DROP TABLE IF EXISTS ROUTES;

CREATE TABLE ROUTES (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  from_lat DOUBLE NOT NULL,
  from_lon DOUBLE NOT NULL,
  to_lat DOUBLE NOT NULL,
  to_lon DOUBLE NOT NULL,
  distance DOUBLE NOT NULL,
  duration DOUBLE NOT NULL,
  datetime timestamp NOT NULL
);

create table execution_state (
  datetime timestamp NOT NULL,
  version integer not null
);