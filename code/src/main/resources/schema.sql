drop table IF exists movies, metadata, theaters, showtimes;

create table movies
(
    id bigint not null
        constraint movies_pkey
            primary key,
    genre varchar(50),
    rating varchar(10),
    title varchar(255),
    year integer not null
);

alter table movies owner to springboot;

create table metadata
(
    image varchar(255) not null,
    trailer varchar(255) not null,
    id bigint not null
        constraint metadata_pkey
            primary key
        constraint fktpqv5bl8lpgto64r3gg3nvlu
            references movies
);

alter table metadata owner to springboot;

create table theaters
(
    id integer not null
        constraint theaters_pkey
            primary key,
    name varchar(255),
    price real not null
);

alter table theaters owner to springboot;

create table showtimes
(
    id integer not null
        constraint showtimes_pkey
            primary key,
    movie_id integer not null
        constraint fkeltpyuei1d5g3n6ikpsjwwil6
            references movies,
    start_time time,
    theater_id integer not null
        constraint fklbd5v4ium9mjbwh7l8nbjqjhw
            references theaters
);

alter table showtimes owner to springboot;

