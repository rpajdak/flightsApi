CREATE TABLE aircraft(
                          id serial PRIMARY KEY,
                          iata_code varchar(99) NOT NULL,
                          icao_code varchar(99) NOT NULL,
                          reg_number varchar(99) NOT NULL
);

CREATE TABLE airline(
                         id serial PRIMARY KEY,
                         iata_code varchar(99) NOT NULL,
                         icao_code varchar(99) NOT NULL
);

CREATE TABLE airport(
                         id serial PRIMARY KEY,
                         iata_code varchar(99) NOT NULL,
                         icao_code varchar(99) NOT NULL
);

CREATE TABLE flight_number(
                              id serial PRIMARY KEY,
                              iata_number varchar(99) NOT NULL,
                              icao_number varchar(99) NOT NULL,
                              flight_number varchar(99) NOT NULL
);

