

insert into DISEASE( ID, code, descr)
    values ( 999, '050.55', 'some description for 050.55');
 
insert into PATIENT( id, first_name, last_name, mid_name, age, diseaseId)
    values ( 99, 'derek', 'hopes', '', 35, 999);

select * from DISEASE;