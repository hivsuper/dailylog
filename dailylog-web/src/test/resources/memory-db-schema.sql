create table account
(
   seqid                bigint(20) not null auto_increment,
   username             varchar(50) not null comment 'user logon name',
   remail               varchar(100) comment 'email Address on Account',
   fpemail              varchar(100) comment 'forget password email',
   phone                varchar(15) comment 'phone number',
   productname          varchar(100) not null comment 'product name',
   producturl           varchar(500) comment 'product url',
   joindate             datetime comment 'registration date',
   createtime           datetime not null comment 'record creation time',
   primary key (seqid),
   unique key remail_productname_unique_key (remail, productname)
)
ENGINE = InnoDB;;

create table navigator
(
   seqid                bigint(20) not null auto_increment,
   name                 varchar(20) not null comment 'site name',
   url                  varchar(100) not null comment 'site link',
   title                varchar(100) default '' comment 'site title used for a label',
   createtime           datetime not null comment 'record creation time',
   primary key (seqid),
   unique key url_unique_key (url)
)
ENGINE = InnoDB;;

create table user
(
   seqId                bigint(20) not null auto_increment,
   username             varchar(100) not null,
   password             varchar(50) not null,
   lastlogintime        datetime,
   createtime           datetime not null,
   primary key (seqId),
   unique key username_unique_key (username)
)
ENGINE = InnoDB;;