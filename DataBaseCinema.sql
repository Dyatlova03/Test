--
-- PostgreSQL database dump
--

-- Dumped from database version 10.11
-- Dumped by pg_dump version 10.11

-- Started on 2020-02-12 10:50:30

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12924)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2810 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 196 (class 1259 OID 16431)
-- Name: director; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.director (
    id integer NOT NULL,
    first_name character varying NOT NULL,
    last_name character varying,
    birth_date date
);


ALTER TABLE public.director OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 16439)
-- Name: film; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.film (
    id integer NOT NULL,
    director_id integer NOT NULL,
    name text,
    release_date date NOT NULL,
    genre text
);


ALTER TABLE public.film OWNER TO postgres;

--
-- TOC entry 2801 (class 0 OID 16431)
-- Dependencies: 196
-- Data for Name: director; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.director VALUES (1, 'Martin', 'Scorsese', '1942-11-17');
INSERT INTO public.director VALUES (2, 'Peter', 'Jackson', '1961-10-31');
INSERT INTO public.director VALUES (3, 'Steven', 'Spielberg', '1946-12-18');
INSERT INTO public.director VALUES (4, 'Tim', 'Burton', '1958-08-25');
INSERT INTO public.director VALUES (5, 'James', 'Cameron', '1954-08-16');
INSERT INTO public.director VALUES (6, 'Olha', 'Dyatlova', '1997-05-03');


--
-- TOC entry 2802 (class 0 OID 16439)
-- Dependencies: 197
-- Data for Name: film; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.film VALUES (1, 1, 'The Wolf of Wall Street', '2013-12-09', 'drama, crime, biography');
INSERT INTO public.film VALUES (2, 2, 'The Hobbit: An Unexpected Journey', '2012-11-28', 'fantasy, adventure, action');
INSERT INTO public.film VALUES (3, 2, 'The Lord of the Rings: The Fellowship of the Ring', '2001-12-10', 'fantasy, adventure, drama');
INSERT INTO public.film VALUES (4, 2, 'King Kong', '2005-12-05', 'action, drama, adventure');
INSERT INTO public.film VALUES (5, 3, 'Rady Plyer One', '2018-03-11', 'fantasy, adventure, action');
INSERT INTO public.film VALUES (6, 3, 'Lincoln', '2012-10-08', 'drama, biography, military');
INSERT INTO public.film VALUES (7, 3, 'Saving Private Ryan', '1998-07-21', 'drama, military');
INSERT INTO public.film VALUES (8, 4, 'Edward Scissorhands', '1990-12-06', 'drama, fantasy');
INSERT INTO public.film VALUES (9, 4, 'Alice in Wonderland', '2010-02-25', 'fntasy, adventure, family');
INSERT INTO public.film VALUES (10, 4, 'Charlie and the Chocolate Factory', '2005-07-10', 'fantasy, adventure, family');
INSERT INTO public.film VALUES (11, 5, 'The Terminator', '1984-10-26', 'fantasy, action');
INSERT INTO public.film VALUES (12, 5, 'Avatar', '2009-12-10', 'fantasy, action, drama');
INSERT INTO public.film VALUES (13, 5, 'Titanic', '1997-11-01', 'drama, melodrama, thriller');
INSERT INTO public.film VALUES (14, 5, 'Terminator 2: Judgment Day', '1991-07-01', 'fantasy, action, thriller');


--
-- TOC entry 2675 (class 2606 OID 16438)
-- Name: director director_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.director
    ADD CONSTRAINT director_pkey PRIMARY KEY (id);


--
-- TOC entry 2677 (class 2606 OID 16446)
-- Name: film film_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.film
    ADD CONSTRAINT film_pkey PRIMARY KEY (id);


--
-- TOC entry 2678 (class 1259 OID 16452)
-- Name: fki_director_id; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_director_id ON public.film USING btree (director_id);


--
-- TOC entry 2679 (class 2606 OID 16447)
-- Name: film director_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.film
    ADD CONSTRAINT director_id FOREIGN KEY (director_id) REFERENCES public.director(id) NOT VALID;


-- Completed on 2020-02-12 10:50:31

--
-- PostgreSQL database dump complete
--

