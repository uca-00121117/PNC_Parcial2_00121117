-- Database: parcial2
Select * from cat_libro;
select * from cat_categoria;

ALTER TABLE cat_libro ADD COLUMN s_isbn character varying(10);


CREATE TABLE public.cat_categoria(
c_categoria SERIAL PRIMARY KEY,
s_categoria varchar(50)
);

CREATE TABLE public.cat_libro(
c_libro SERIAL PRIMARY KEY,
s_titulo varchar(500),
s_autor varchar(150),
b_estado boolean,
s_isbn varchar(10),
f_ingreso timestamp without time zone,
c_categoria int
);

ALTER TABLE cat_libro ADD CONSTRAINT fk_categoria_libro FOREIGN KEY(c_categoria) REFERENCES cat_categoria(c_categoria);
-- DROP DATABASE parcial2;

CREATE DATABASE parcial2
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'es_ES.UTF-8'
    LC_CTYPE = 'es_ES.UTF-8'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;