/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2014/1/14 0:39:03                            */
/*==============================================================*/


drop table if exists account;

drop table if exists navigator;

drop table if exists user;

/*==============================================================*/
/* Table: account                                               */
/*==============================================================*/
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
   unique key AK_Key_2 (remail, productname)
)
ENGINE = MYISAM
DEFAULT CHARACTER SET = utf8;

/*==============================================================*/
/* Table: navigator                                             */
/*==============================================================*/
create table navigator
(
   seqid                bigint(20) not null auto_increment,
   name                 varchar(20) not null comment 'site name',
   url                  varchar(300) not null comment 'site link',
   title                varchar(100) default '' comment 'site title used for a label',
   createtime           datetime not null comment 'record creation time',
   primary key (seqid),
   unique key AK_Key_2 (url)
)
ENGINE = MYISAM
DEFAULT CHARACTER SET = utf8;

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   seqId                bigint(20) not null auto_increment,
   username             varchar(100) not null,
   password             varchar(50) not null,
   lastlogintime        datetime,
   createtime           datetime not null,
   primary key (seqId),
   unique key AK_Key_2 (username)
)
ENGINE = MYISAM
DEFAULT CHARACTER SET = utf8;

