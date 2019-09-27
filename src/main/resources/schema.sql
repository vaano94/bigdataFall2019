drop table if exists cites;
drop table if exists writes;
drop table if exists submits;
drop table if exists paper;
drop table if exists author;
drop table if exists conference;


drop sequence if exists author_authorid_seq;
drop sequence if exists conference_config_seq;
drop sequence if exists paper_paperid_seq;



 create table paper(
 	paperID SERIAL PRIMARY KEY,
 	title varchar,
 	abstract_ varchar
 );

 create table author(
 	authorID SERIAL PRIMARY KEY,
 	name varchar,
 	email varchar,
 	affiliation varchar
 );

 create table writes(
 	authorID integer,
 	paperID integer,
 	primary key (authorID, paperID),
 	FOREIGN KEY (authorID) REFERENCES author(authorID) ON DELETE CASCADE ON UPDATE CASCADE,
 	FOREIGN KEY (paperID) REFERENCES paper(paperID) ON DELETE CASCADE ON UPDATE CASCADE
 );

 create table conference(
 	confID SERIAL PRIMARY KEY,
 	name varchar,
 	ranking numeric
 );

 create table submits(
 	paperID integer,
 	confID integer,
 	isAccepted boolean,
 	date_ date,
 	primary key (paperID, confID),
 	FOREIGN KEY (paperID) REFERENCES paper(paperID) ON DELETE RESTRICT ON UPDATE CASCADE,
 	FOREIGN KEY (confID) REFERENCES conference(confID) ON DELETE CASCADE ON UPDATE CASCADE
 );

 create table cites(
 	paperIDfrom integer,
 	paperIDto integer,
 	primary key (paperIDfrom, paperIDto),
 	FOREIGN KEY (paperIDfrom) REFERENCES paper(paperID) ON DELETE RESTRICT ON UPDATE CASCADE,
 	FOREIGN KEY (paperIDto) REFERENCES paper(paperID) ON DELETE CASCADE ON UPDATE CASCADE
 );