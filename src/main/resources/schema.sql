drop table if exists cites;
drop table if exists writes;
drop table if exists submits;
drop table if exists paper;
drop table if exists author;
drop table if exists conference;


drop sequence if exists author_authorid_seq;
drop sequence if exists conference_config_seq;
drop sequence if exists paper_paperid_seq;

drop view if exists publishesin;


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

-- FOREIGN KEY (paperIDto) REFERENCES paper(paperID) ON DELETE SET NULL ON UPDATE CASCADE
-- we want to ensure that by deleting refenced paperid (paperIDto) we also want to delete corresponding entry in cites

-- FOREIGN KEY (paperIDfrom) REFERENCES paper(paperID) ON DELETE RESTRICT ON UPDATE CASCADE
-- any erase of cited paper is prohibited because it could be that one paper was participated in creation of another
-- so for the paper which cites another ones, its important to have them