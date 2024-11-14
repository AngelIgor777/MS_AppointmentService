create table clinics
(
    clinic_id serial primary key ,
    name varchar(255) not null unique,
    description text
);

create table doctor_info
(
    user_id bigint not null unique,
    clinic_id bigint references clinics (clinic_id),
    birthdate date,
    gender varchar(50),
    address varchar(128),
    phone_number varchar(16),
    email varchar(64),
    cabinet varchar(8),
    floor int,
    specialty varchar(64),
    years_of_experience int,
    description text
);
-- Таблица записей
create table records
(
    id serial primary key,
    patient_id bigint,
    doctor_id bigint references doctor_info (user_id),
    date date,
    time time,
    status varchar(105),
    type varchar(105),
    notes text
);
