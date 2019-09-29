-- select the number of conferences belonging to each ranking
select count(*) as amount_of_conferences, ranking from conference group by ranking order by ranking desc


--Select all the abstracts of the papers written (or co-written) by the author whose
--name is ‘Alex’ or ‘Alexander’.

select * from
paper p join writes w on p.paperId = w.paperId
join author a on a.authorid = w.authorid
where a.name in ('Alex', 'Alexander')
-- Alisa Mccaffrey

-- iii. Select the names of all the authors that cited themselves.

select a.name from
writes w join cites ci on w.paperid = ci.paperidfrom
join author a on w.authorid = a.authorid
where ci.paperidfrom=ci.paperidto

-- Create a view PublishesIn(authorID, confID) containing all the pairs (authorID, confID)
-- such that there is at least one publication by authorID accepted at confID.

CREATE VIEW PublishesIn AS
SELECT  w.authorid, s.confid from submits s join writes w on
s.paperid = w.paperid
where s.isaccepted = true


-- Select the title of all the papers co-authored by the author ‘Alex’ (the papers
-- where ‘Alex’ is the only author should not be part of the result).
select distinct paper.title from writes as papers
join writes as coauthor
on papers.paperid = coauthor.paperid
join paper on paper.paperid=papers.paperid
join author au on au.authorid = papers.authorid
where au.name = 'Alex'
and papers.authorid <> coauthor.authorid
