create table account
(
   seqid                bigint IDENTITY PRIMARY KEY not null,
   username             varchar(50) not null,
   remail               varchar(100),
   fpemail              varchar(100),
   phone                varchar(15),
   productname          varchar(100),
   producturl           varchar(500),
   joindate             datetime,
   createtime           datetime not null
);;