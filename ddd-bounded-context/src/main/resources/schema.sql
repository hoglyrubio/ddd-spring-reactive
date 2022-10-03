create table CLIENT (
    ID          varchar(36) not null,
    NAME        varchar(250) not null,
    ADDRESS     varchar(250) not null,
    BIRTH_DAY   date  not null,
    primary key (ID)
);