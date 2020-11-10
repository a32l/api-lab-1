DROP TABLE IF EXISTS catalog CASCADE;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START WITH 1;

CREATE TABLE catalog(
    id        INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    vendor    VARCHAR     NOT NULL,
    model     VARCHAR     NOT NULL,
    cpu       VARCHAR     NOT NULL,
    ram       INTEGER     NOT NULL
);