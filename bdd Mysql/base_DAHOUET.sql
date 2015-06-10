/*==============================================================*/
/* Nom de SGBD :  MySQL 5.0                                     */
/* Date de création :  24/05/2015 00:52:17                      */
/*==============================================================*/


drop table if exists CHALLENGE;

drop table if exists CLASSE;

drop table if exists CLUB;

drop table if exists COMMISSAIRES;

drop table if exists COMMISSION_DE_COURSE;

drop table if exists MARIN;

drop table if exists MEMBRE_DE_COMMISION;

drop table if exists PARTICIPATION;

drop table if exists PARTICIPE;

drop table if exists PERSONNE;

drop table if exists PROPRIETAIRE;

drop table if exists REGATE;

drop table if exists SERIE;

drop table if exists STATUS_DES_ARRIVEES;

drop table if exists STATUS_DE_DEPART;

drop table if exists VOILIER;

/*==============================================================*/
/* Table : CHALLENGE                                            */
/*==============================================================*/
create table CHALLENGE
(
   ID_CHALL             int not null auto_increment,
   NOM_CHALL            varchar(20) not null,
   DATE_DEBUT           date not null,
   DATE_FIN             date not null,
   primary key (ID_CHALL)
);

/*==============================================================*/
/* Table : CLASSE                                               */
/*==============================================================*/
create table CLASSE
(
   CLASSE               varchar(20) not null,
   SERIE                varchar(20) not null,
   primary key (CLASSE)
);

/*==============================================================*/
/* Table : CLUB                                                 */
/*==============================================================*/
create table CLUB
(
   ID_CLUB              int not null auto_increment,
   ID_PRESIDENT         int not null,
   NOM_CLUB             varchar(20) not null,
   ADRESSE_CLUB         varchar(50) not null,
   TEL_CLUB             bigint not null,
   primary key (ID_CLUB)
);

/*==============================================================*/
/* Table : COMMISSAIRES                                         */
/*==============================================================*/
create table COMMISSAIRES
(
   ID_COMMISSAIRE       int not null auto_increment,
   ID_PERS              int not null,
   COM_REG              varchar(15) not null,
   primary key (ID_COMMISSAIRE)
);

/*==============================================================*/
/* Table : COMMISSION_DE_COURSE                                 */
/*==============================================================*/
create table COMMISSION_DE_COURSE
(
   ID_COM               int not null auto_increment,
   ID_PRESIDENT         int not null,
   primary key (ID_COM)
);

/*==============================================================*/
/* Table : MARIN                                                */
/*==============================================================*/
create table MARIN
(
   ID_MARIN             int not null auto_increment,
   ID_PERS              int not null,
   NUM_LICENCE          bigint not null,
   DATE_LICENCE         date not null,
   primary key (ID_MARIN)
);

/*==============================================================*/
/* Table : MEMBRE_DE_COMMISION                                  */
/*==============================================================*/
create table MEMBRE_DE_COMMISION
(
   ID_COM               int not null,
   ID_COMMISSAIRE       int not null,
   primary key (ID_COM, ID_COMMISSAIRE)
);

/*==============================================================*/
/* Table : PARTICIPATION                                        */
/*==============================================================*/
create table PARTICIPATION
(
   ID_PART              int not null auto_increment,
   ID_VOILIER           int not null,
   ID_REGATE            int not null,
   H_DEP                time not null,
   STATUT_DEP           char(3) not null,
   H_ARRIV              time not null,
   STATUT_ARRIV         char(3) not null,
   ID_SKIPER            int not null,
   PLACE                int,
   primary key (ID_PART)
);

/*==============================================================*/
/* Table : PARTICIPE                                            */
/*==============================================================*/
create table PARTICIPE
(
   ID_PART              int not null,
   ID_MARIN             int not null,
   primary key (ID_PART, ID_MARIN)
);

/*==============================================================*/
/* Table : PERSONNE                                             */
/*==============================================================*/
create table PERSONNE
(
   ID_PERS              int not null auto_increment,
   NOM                  varchar(20) not null,
   PRENOM               varchar(20) not null,
   ADDRESSE             varchar(50) not null,
   TELEPHONE            bigint not null,
   DATE_N               date not null,
   MAIL                 varchar(64),
   primary key (ID_PERS)
);

/*==============================================================*/
/* Table : PROPRIETAIRE                                         */
/*==============================================================*/
create table PROPRIETAIRE
(
   ID_PROPR             int not null auto_increment,
   ID_CLUB              int not null,
   ID_PERS              int not null,
   primary key (ID_PROPR)
);

/*==============================================================*/
/* Table : REGATE                                               */
/*==============================================================*/
create table REGATE
(
   ID_REGATE            int not null auto_increment,
   ID_CHALL             int not null,
   ID_COM               int not null,
   NOM_REG              varchar(20) not null,
   DATE_REGATE          date not null,
   DISTANCE             decimal(6,3) not null,
   D_VENT               varchar(3) not null,
   I_VENT               smallint not null,
   D_COURANT            varchar(3) not null,
   V_COURANT            smallint not null,
   ETAT_MER             varchar(10) not null,
   CAP                  varchar(3) not null,
   L_BORD               decimal(6,3) not null,
   COURUE               char(1) not null,
   primary key (ID_REGATE)
);

/*==============================================================*/
/* Table : SERIE                                                */
/*==============================================================*/
create table SERIE
(
   SERIE                varchar(20) not null,
   primary key (SERIE)
);

/*==============================================================*/
/* Table : STATUS_DES_ARRIVEES                                  */
/*==============================================================*/
create table STATUS_DES_ARRIVEES
(
   STATUT_ARRIV         char(3) not null,
   primary key (STATUT_ARRIV)
);

/*==============================================================*/
/* Table : STATUS_DE_DEPART                                     */
/*==============================================================*/
create table STATUS_DE_DEPART
(
   STATUT_DEP           char(3) not null,
   primary key (STATUT_DEP)
);

/*==============================================================*/
/* Table : VOILIER                                              */
/*==============================================================*/
create table VOILIER
(
   ID_VOILIER           int not null auto_increment,
   ID_PROPR             int not null,
   CLASSE               varchar(20) not null,
   COEFF                decimal(4,4) not null,
   NOM_VOILIER          varchar(20) not null,
   primary key (ID_VOILIER)
);

alter table CLASSE add constraint FK_EST_DE_LA_SERIE foreign key (SERIE)
      references SERIE (SERIE) on delete restrict on update restrict;

alter table CLUB add constraint FK_EST_PRESIDENT foreign key (ID_PRESIDENT)
      references PERSONNE (ID_PERS) on delete restrict on update restrict;

alter table COMMISSAIRES add constraint FK_EST_COMMISSAIRE foreign key (ID_PERS)
      references PERSONNE (ID_PERS) on delete restrict on update restrict;

alter table COMMISSION_DE_COURSE add constraint FK_PRESIDE foreign key (ID_PRESIDENT)
      references COMMISSAIRES (ID_COMMISSAIRE) on delete restrict on update restrict;

alter table MARIN add constraint FK_EST_MARIN foreign key (ID_PERS)
      references PERSONNE (ID_PERS) on delete restrict on update restrict;

alter table MEMBRE_DE_COMMISION add constraint FK_FAIT_PARTIE2 foreign key (ID_COM)
      references COMMISSION_DE_COURSE (ID_COM) on delete restrict on update restrict;

alter table MEMBRE_DE_COMMISION add constraint FK_FAIT_PARTIE3 foreign key (ID_COMMISSAIRE)
      references COMMISSAIRES (ID_COMMISSAIRE) on delete restrict on update restrict;

alter table PARTICIPATION add constraint FK_A_LE_STATUS_DE_DEPART foreign key (STATUT_DEP)
      references STATUS_DE_DEPART (STATUT_DEP) on delete restrict on update restrict;

alter table PARTICIPATION add constraint FK_A_LE_STATUS_D_ARRIVEE foreign key (STATUT_ARRIV)
      references STATUS_DES_ARRIVEES (STATUT_ARRIV) on delete restrict on update restrict;

alter table PARTICIPATION add constraint FK_CORRESPOND foreign key (ID_REGATE)
      references REGATE (ID_REGATE) on delete restrict on update restrict;

alter table PARTICIPATION add constraint FK_EST_INSCRIT foreign key (ID_VOILIER)
      references VOILIER (ID_VOILIER) on delete restrict on update restrict;

alter table PARTICIPATION add constraint FK_EST_SKIPPER foreign key (ID_SKIPER)
      references MARIN (ID_MARIN) on delete restrict on update restrict;

alter table PARTICIPE add constraint FK_PARTICIPE foreign key (ID_PART)
      references PARTICIPATION (ID_PART) on delete restrict on update restrict;

alter table PARTICIPE add constraint FK_PARTICIPE2 foreign key (ID_MARIN)
      references MARIN (ID_MARIN) on delete restrict on update restrict;

alter table PROPRIETAIRE add constraint FK_EST_MEMBRE foreign key (ID_CLUB)
      references CLUB (ID_CLUB) on delete restrict on update restrict;

alter table PROPRIETAIRE add constraint FK_EST_PROPRIETAIRE foreign key (ID_PERS)
      references PERSONNE (ID_PERS) on delete restrict on update restrict;

alter table REGATE add constraint FK_CONTIENS foreign key (ID_CHALL)
      references CHALLENGE (ID_CHALL) on delete restrict on update restrict;

alter table REGATE add constraint FK_SUPERVISE foreign key (ID_COM)
      references COMMISSION_DE_COURSE (ID_COM) on delete restrict on update restrict;

alter table VOILIER add constraint FK_APPARTIENT foreign key (ID_PROPR)
      references PROPRIETAIRE (ID_PROPR) on delete restrict on update restrict;

alter table VOILIER add constraint FK_EST_DE_LA_CLASSE foreign key (CLASSE)
      references CLASSE (CLASSE) on delete restrict on update restrict;

