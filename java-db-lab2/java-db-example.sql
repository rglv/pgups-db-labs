--
-- PostgreSQL database dump
--

-- Dumped from database version 9.4.4
-- Dumped by pg_dump version 9.4.0
-- Started on 2015-09-21 18:51:44

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 174 (class 3079 OID 11855)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: -
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2002 (class 0 OID 0)
-- Dependencies: 174
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: -
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_with_oids = false;

--
-- TOC entry 173 (class 1259 OID 16744)
-- Name: students; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE students (
    id integer NOT NULL,
    stud_id character(10),
    name character varying(255),
    birthday date
);


--
-- TOC entry 172 (class 1259 OID 16742)
-- Name: students_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE students_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 2003 (class 0 OID 0)
-- Dependencies: 172
-- Name: students_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE students_id_seq OWNED BY students.id;


--
-- TOC entry 1881 (class 2604 OID 16747)
-- Name: id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY students ALTER COLUMN id SET DEFAULT nextval('students_id_seq'::regclass);


--
-- TOC entry 1995 (class 0 OID 16744)
-- Dependencies: 173
-- Data for Name: students; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO students (id, stud_id, name, birthday) VALUES (1, '111-432-01', 'Алексеев Алексей', '1997-01-01');
INSERT INTO students (id, stud_id, name, birthday) VALUES (2, '111-432-02', 'Викторов Виктор', '1997-02-02');
INSERT INTO students (id, stud_id, name, birthday) VALUES (3, '111-432-03', 'Дарьева Дарья', '1997-03-03');


--
-- TOC entry 2004 (class 0 OID 0)
-- Dependencies: 172
-- Name: students_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('students_id_seq', 3, true);


--
-- TOC entry 1883 (class 2606 OID 16749)
-- Name: students_pk; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY students
    ADD CONSTRAINT students_pk PRIMARY KEY (id);


--
-- TOC entry 1884 (class 1259 OID 16750)
-- Name: students_stud_id_idx; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX students_stud_id_idx ON students USING btree (stud_id);


-- Completed on 2015-09-21 18:51:44

--
-- PostgreSQL database dump complete
--

