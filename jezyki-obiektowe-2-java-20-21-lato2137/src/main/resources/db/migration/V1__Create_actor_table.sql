create table actor (
    id integer not null auto_increment,
    created datetime,
    deleted integer,
    first_name varchar(255),
    last_name varchar(255),
    modified datetime not null,
    primary key (id)
) engine=InnoDB;