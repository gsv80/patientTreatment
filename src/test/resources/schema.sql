DROP TABLE IF EXISTS PATIENT;
DROP TABLE IF EXISTS DISEASE;


CREATE TABLE DISEASE
(
    ID     BIGINT GENERATED ALWAYS AS IDENTITY,
    code text not null,
    descr text not null,
    PRIMARY KEY(ID)
    
);

CREATE TABLE PATIENT
(
    ID     BIGINT GENERATED ALWAYS AS IDENTITY,
    diseaseId BIGINT, 
    first_name text not null,
    last_name text not null,
    mid_name text,
    age number not null,
    PRIMARY KEY(ID),
    CONSTRAINT fk_patient 
        FOREIGN KEY(diseaseId) references DISEASE(ID)
);
