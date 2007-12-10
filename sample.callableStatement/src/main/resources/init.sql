drop table USERS cascade constraints;

create table USERS  (
   ID                   number                          not null,
   USER_NAME            varchar2(20)                    not null,
   constraint PK_USERS primary key (ID)
);

create or replace procedure insert_demo_max(username varchar2) is
  v_id number;
begin
  select max(id) + 1 into v_id from users;

  if v_id is null then
    v_id := 1;
  end if;

  insert into users (id, user_name) values (v_id, username);
end insert_demo_max;
/