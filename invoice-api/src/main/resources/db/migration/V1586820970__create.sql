create sequence HOME_SEQ start 1 increment 50;
create table CLIENT (CLIENT_ID int8 not null, CLIENT_NAME varchar(255) not null, PHONE_NUMBER varchar(255), primary key (CLIENT_ID));
create table CLIENT_INVOICE (ClientEntity_CLIENT_ID int8 not null, invoices_INVOICE_ID int8 not null, primary key (ClientEntity_CLIENT_ID, invoices_INVOICE_ID));
create table INVOICE (INVOICE_ID int8 not null, AMOUNT float4 not null, DUE_DATE timestamp, ISSUED_DATE timestamp, client_CLIENT_ID int8, primary key (INVOICE_ID));
alter table CLIENT_INVOICE add constraint UK_c3ltdv1mea4poqmnntt96tybv unique (invoices_INVOICE_ID);
alter table CLIENT_INVOICE add constraint FKn3ym7hjoax1j2smugp0d3fy8m foreign key (invoices_INVOICE_ID) references INVOICE;
alter table CLIENT_INVOICE add constraint FKfi167qj4x7w320eh4h103ag0a foreign key (ClientEntity_CLIENT_ID) references CLIENT;
alter table INVOICE add constraint FKjks7ot0gtcfqxjnxvmpwjn5je foreign key (client_CLIENT_ID) references CLIENT;