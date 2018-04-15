-- Generado por Oracle SQL Developer Data Modeler 4.1.3.901
--   en:        2018-04-15 14:00:59 CEST
--   sitio:      Oracle Database 11g
--   tipo:      Oracle Database 11g




CREATE TABLE COMENTARIOS
  (
    id_comentario     INTEGER NOT NULL ,
    descripcion       VARCHAR2 (100) ,
    fecha             DATE ,
    SOCIOS_id_socio   INTEGER NOT NULL ,
    EVENTOS_id_evento INTEGER NOT NULL
  ) ;
ALTER TABLE COMENTARIOS ADD CONSTRAINT COMENTARIOS_PK PRIMARY KEY ( id_comentario, SOCIOS_id_socio, EVENTOS_id_evento ) ;


CREATE TABLE CUOTAS
  (
    id_codigo       INTEGER NOT NULL ,
    cantidad        INTEGER NOT NULL ,
    fecha_pago      DATE NOT NULL ,
    SOCIOS_id_socio INTEGER NOT NULL ,
    descripcion     VARCHAR2 (100)
  ) ;
ALTER TABLE CUOTAS ADD CONSTRAINT CUOTAS_PK PRIMARY KEY ( id_codigo, SOCIOS_id_socio ) ;


CREATE TABLE DOCUMENTACION
  (
    cod_documento INTEGER NOT NULL ,
    estado        VARCHAR2
    --  ERROR: VARCHAR2 size not specified
    ,
    url             VARCHAR2 (200) ,
    comentario      VARCHAR2 (50) ,
    SOCIOS_id_socio INTEGER NOT NULL
  ) ;
CREATE UNIQUE INDEX DOCUMENTACION__IDX ON DOCUMENTACION
  (
    SOCIOS_id_socio ASC
  )
  ;
ALTER TABLE DOCUMENTACION ADD CONSTRAINT DOCUMENTACION_PK PRIMARY KEY ( cod_documento ) ;


CREATE TABLE EVENTOS
  (
    dia             DATE NOT NULL ,
    duracion        VARCHAR2 (200) NOT NULL ,
    lugar           VARCHAR2 (100) NOT NULL ,
    id_evento       INTEGER NOT NULL ,
    SECCION_WEB_url VARCHAR2 (200) NOT NULL
  ) ;
ALTER TABLE EVENTOS ADD CONSTRAINT EVENTOS_PK PRIMARY KEY ( id_evento ) ;


CREATE TABLE GRUPO_SCOUT
  (
    nombre_grupo    VARCHAR2 (100) ,
    id_grupo        INTEGER ,
    GRUPO_SCOUT_ID  NUMBER NOT NULL ,
    id_grupo1       INTEGER NOT NULL ,
    nombre_grupo1   VARCHAR2 (100) NOT NULL ,
    SECCION_WEB_url VARCHAR2 (200)
  ) ;
CREATE UNIQUE INDEX GRUPO_SCOUT__IDX ON GRUPO_SCOUT
  (
    SECCION_WEB_url ASC
  )
  ;
ALTER TABLE GRUPO_SCOUT ADD CONSTRAINT GRUPO_SCOUT_PKv1 PRIMARY KEY ( id_grupo1 ) ;
ALTER TABLE GRUPO_SCOUT ADD CONSTRAINT GRUPO_SCOUT_PK UNIQUE ( GRUPO_SCOUT_ID ) ;


CREATE TABLE PEDIDOS
  (
    id_pedido                      INTEGER NOT NULL ,
    objeto                         VARCHAR2 (100) NOT NULL ,
    cantidad                       INTEGER NOT NULL ,
    estado                         VARCHAR2 (100) NOT NULL ,
    resguardo                      VARCHAR2 (50) NOT NULL ,
    PRODUCTO_GRUPO_SCOUT_id_grupo1 INTEGER NOT NULL ,
    SOCIOS_id_socio                INTEGER NOT NULL ,
    PRODUCTO_id_producto           INTEGER NOT NULL
  ) ;
ALTER TABLE PEDIDOS ADD CONSTRAINT PEDIDOS_PK PRIMARY KEY ( id_pedido, PRODUCTO_GRUPO_SCOUT_id_grupo1, PRODUCTO_id_producto, SOCIOS_id_socio ) ;


CREATE TABLE PERMISOS
  (
    id_permiso             INTEGER NOT NULL ,
    escribir               CHAR (1) NOT NULL ,
    leer                   CHAR (1) NOT NULL ,
    subir_doc_y_asistencia CHAR (1) NOT NULL ,
    administrar_tienda     CHAR (1) NOT NULL ,
    gestion                CHAR (1) NOT NULL ,
    SOCIOS_id_socio        INTEGER NOT NULL
  ) ;
ALTER TABLE PERMISOS ADD CONSTRAINT PERMISOS_PK PRIMARY KEY ( id_permiso, SOCIOS_id_socio ) ;


CREATE TABLE PRODUCTO
  (
    id_objeto             INTEGER ,
    nombre_objeto         VARCHAR2 (100) NOT NULL ,
    stock                 INTEGER NOT NULL ,
    pvp_objeto            NUMBER (2) NOT NULL ,
    id_producto           INTEGER NOT NULL ,
    GRUPO_SCOUT_id_grupo2 INTEGER NOT NULL
  ) ;
ALTER TABLE PRODUCTO ADD CONSTRAINT PRODUCTO_PK PRIMARY KEY ( GRUPO_SCOUT_id_grupo2, id_producto ) ;


CREATE TABLE RESPONSABLE_LEGAL
  (
    dni       VARCHAR2 (10) NOT NULL ,
    nombre    VARCHAR2 (100) NOT NULL ,
    apellidos VARCHAR2 (100) NOT NULL ,
    email     VARCHAR2 (100) NOT NULL
  ) ;
ALTER TABLE RESPONSABLE_LEGAL ADD CONSTRAINT RESPONSABLE_LEGAL_PK PRIMARY KEY ( dni ) ;


CREATE TABLE Relation_12
  (
    EVENTOS_id_evento     INTEGER NOT NULL ,
    GRUPO_SCOUT_id_grupo1 INTEGER NOT NULL
  ) ;
ALTER TABLE Relation_12 ADD CONSTRAINT Relation_12_PK PRIMARY KEY ( EVENTOS_id_evento, GRUPO_SCOUT_id_grupo1 ) ;


CREATE TABLE SCOUTER
  (
    id_educando INTEGER NOT NULL ,
    cargo       VARCHAR2 (100) NOT NULL
  ) ;
ALTER TABLE SCOUTER ADD CONSTRAINT SCOUTER_PK PRIMARY KEY ( id_educando ) ;
-- Error - Unique Constraint SCOUTER.SCOUTER_PKv1 doesn't have columns -- Error - Unique Constraint SCOUTER.SCOUTER__UN doesn't have columns 

CREATE TABLE SECCION_WEB
  (
    url                   VARCHAR2 (200) NOT NULL ,
    nombre_seccion        VARCHAR2 (100) NOT NULL ,
    GRUPO_SCOUT_id_grupo1 INTEGER
  ) ;
CREATE UNIQUE INDEX SECCION_WEB__IDX ON SECCION_WEB
  (
    GRUPO_SCOUT_id_grupo1 ASC
  )
  ;
ALTER TABLE SECCION_WEB ADD CONSTRAINT SECCION_WEB_PK PRIMARY KEY ( url ) ;


CREATE TABLE SOCIOS
  (
    id_socio                   INTEGER NOT NULL ,
    dni                        VARCHAR2 (10) NOT NULL ,
    grupo                      VARCHAR2 (100) ,
    fecha_nacimiento           DATE NOT NULL ,
    fecha_ingreso              DATE NOT NULL ,
    fecha_baja                 DATE ,
    GRUPO_SCOUT_GRUPO_SCOUT_ID NUMBER ,
    id_grupo                   NUMBER
  ) ;
ALTER TABLE SOCIOS ADD CONSTRAINT SOCIOS_PK PRIMARY KEY ( id_socio ) ;
ALTER TABLE SOCIOS ADD CONSTRAINT SOCIOS_dni_UN UNIQUE ( dni ) ;


CREATE TABLE TUTOR
  (
    SOCIOS_id_socio       INTEGER NOT NULL ,
    RESPONSABLE_LEGAL_dni VARCHAR2 (10) NOT NULL
  ) ;
ALTER TABLE TUTOR ADD CONSTRAINT TUTOR_PK PRIMARY KEY ( SOCIOS_id_socio, RESPONSABLE_LEGAL_dni ) ;


CREATE TABLE asiste
  (
    SOCIOS_id_socio   INTEGER NOT NULL ,
    EVENTOS_id_evento INTEGER NOT NULL
  ) ;
ALTER TABLE asiste ADD CONSTRAINT asiste_PK PRIMARY KEY ( SOCIOS_id_socio, EVENTOS_id_evento ) ;


ALTER TABLE COMENTARIOS ADD CONSTRAINT COMENTARIOS_EVENTOS_FK FOREIGN KEY ( EVENTOS_id_evento ) REFERENCES EVENTOS ( id_evento ) ;

ALTER TABLE COMENTARIOS ADD CONSTRAINT COMENTARIOS_SOCIOS_FK FOREIGN KEY ( SOCIOS_id_socio ) REFERENCES SOCIOS ( id_socio ) ;

ALTER TABLE CUOTAS ADD CONSTRAINT CUOTAS_SOCIOS_FK FOREIGN KEY ( SOCIOS_id_socio ) REFERENCES SOCIOS ( id_socio ) ;

ALTER TABLE DOCUMENTACION ADD CONSTRAINT DOCUMENTACION_SOCIOS_FK FOREIGN KEY ( SOCIOS_id_socio ) REFERENCES SOCIOS ( id_socio ) ;

ALTER TABLE EVENTOS ADD CONSTRAINT EVENTOS_SECCION_WEB_FK FOREIGN KEY ( SECCION_WEB_url ) REFERENCES SECCION_WEB ( url ) ;

ALTER TABLE Relation_12 ADD CONSTRAINT FK_ASS_1 FOREIGN KEY ( EVENTOS_id_evento ) REFERENCES EVENTOS ( id_evento ) ;

ALTER TABLE asiste ADD CONSTRAINT FK_ASS_10 FOREIGN KEY ( EVENTOS_id_evento ) REFERENCES EVENTOS ( id_evento ) ;

ALTER TABLE Relation_12 ADD CONSTRAINT FK_ASS_2 FOREIGN KEY ( GRUPO_SCOUT_id_grupo1 ) REFERENCES GRUPO_SCOUT ( id_grupo1 ) ;

ALTER TABLE TUTOR ADD CONSTRAINT FK_ASS_5 FOREIGN KEY ( SOCIOS_id_socio ) REFERENCES SOCIOS ( id_socio ) ;

ALTER TABLE TUTOR ADD CONSTRAINT FK_ASS_6 FOREIGN KEY ( RESPONSABLE_LEGAL_dni ) REFERENCES RESPONSABLE_LEGAL ( dni ) ;

ALTER TABLE asiste ADD CONSTRAINT FK_ASS_9 FOREIGN KEY ( SOCIOS_id_socio ) REFERENCES SOCIOS ( id_socio ) ;

-- Error - Foreign Key GRUPO_SCOUT_SCOUTER_FK has no columns

ALTER TABLE GRUPO_SCOUT ADD CONSTRAINT GRUPO_SCOUT_SECCION_WEB_FK FOREIGN KEY ( SECCION_WEB_url ) REFERENCES SECCION_WEB ( url ) ;

ALTER TABLE PEDIDOS ADD CONSTRAINT PEDIDOS_PRODUCTO_FK FOREIGN KEY ( PRODUCTO_GRUPO_SCOUT_id_grupo1, PRODUCTO_id_producto ) REFERENCES PRODUCTO ( GRUPO_SCOUT_id_grupo2, id_producto ) ;

ALTER TABLE PEDIDOS ADD CONSTRAINT PEDIDOS_SOCIOS_FK FOREIGN KEY ( SOCIOS_id_socio ) REFERENCES SOCIOS ( id_socio ) ;

ALTER TABLE PERMISOS ADD CONSTRAINT PERMISOS_SOCIOS_FK FOREIGN KEY ( SOCIOS_id_socio ) REFERENCES SOCIOS ( id_socio ) ;

ALTER TABLE PRODUCTO ADD CONSTRAINT PRODUCTO_GRUPO_SCOUT_FK FOREIGN KEY ( GRUPO_SCOUT_id_grupo2 ) REFERENCES GRUPO_SCOUT ( id_grupo1 ) ;

-- Error - Foreign Key Relation_12 has no columns

-- Error - Foreign Key Relation_12v1 has no columns

ALTER TABLE SCOUTER ADD CONSTRAINT SCOUTER_SOCIOS_FK FOREIGN KEY ( id_educando ) REFERENCES SOCIOS ( id_socio ) ;

ALTER TABLE SECCION_WEB ADD CONSTRAINT SECCION_WEB_GRUPO_SCOUT_FK FOREIGN KEY ( GRUPO_SCOUT_id_grupo1 ) REFERENCES GRUPO_SCOUT ( id_grupo1 ) ;

ALTER TABLE SOCIOS ADD CONSTRAINT SOCIOS_GRUPO_SCOUT_FK FOREIGN KEY ( id_grupo ) REFERENCES GRUPO_SCOUT ( GRUPO_SCOUT_ID ) ;

-- Error - Foreign Key TUTOR has no columns

-- Error - Foreign Key TUTORv1 has no columns

-- Error - Foreign Key asiste has no columns

-- Error - Foreign Key asistev1 has no columns

CREATE SEQUENCE GRUPO_SCOUT_GRUPO_SCOUT_ID_SEQ START WITH 1 NOCACHE ORDER ;
CREATE OR REPLACE TRIGGER GRUPO_SCOUT_GRUPO_SCOUT_ID_TRG BEFORE
  INSERT ON GRUPO_SCOUT FOR EACH ROW WHEN (NEW.GRUPO_SCOUT_ID IS NULL) BEGIN :NEW.GRUPO_SCOUT_ID := GRUPO_SCOUT_GRUPO_SCOUT_ID_SEQ.NEXTVAL;
END;
/


-- Informe de Resumen de Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                            15
-- CREATE INDEX                             3
-- ALTER TABLE                             36
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           1
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          1
-- CREATE MATERIALIZED VIEW                 0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                  10
-- WARNINGS                                 0
