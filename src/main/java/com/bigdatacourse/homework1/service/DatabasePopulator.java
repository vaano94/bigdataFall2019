package com.bigdatacourse.homework1.service;

import com.bigdatacourse.homework1.model.Author;
import com.bigdatacourse.homework1.model.Cites;
import com.bigdatacourse.homework1.model.Conference;
import com.bigdatacourse.homework1.model.Paper;
import com.bigdatacourse.homework1.model.Submits;
import com.bigdatacourse.homework1.model.Writes;
import net.bytebuddy.utility.RandomString;
import org.hibernate.Session;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.sql.Date;
import java.util.List;
import java.util.Random;

@Service
public class DatabasePopulator {

    @PersistenceContext
    private EntityManager entityManager;

    private Session session;

    @Transactional
    public void populate() throws IOException {

        recreateDatabase();


        String conferencesAsString = getResourceAsString("confereces.txt");
        String[] conferences = conferencesAsString.split("\r\n");

        String publication = getResourceAsString("publication.txt");

        String namesAsString = getResourceAsString("names.txt");
        String[] names = namesAsString.split("\r\n");

        String papersAsString = getResourceAsString("papers.txt");
        String[] papers = namesAsString.split("\r\n");


        try {

            System.out.println(entityManager);
            for (int i = 0; i < 199; i++) {
                populateAuthor(names[i]);
            }
            for (int i = 0; i < 45; i++) {
                populateConference(conferences[i]);
            }
            for (int i = 0; i < 28; i++) {
                populatePaper(papers[i]);
            }
            session.flush();
            List<Paper> papersList = session.createQuery("from Paper", Paper.class).list();
            List<Conference> conferenceList = session.createQuery("from Conference", Conference.class).list();
            List<Author> authorList = session.createQuery("from Author", Author.class).list();
            for (int i = 0; i < 25; i++) {
                populateCites(papersList);
            }


            for (int i = 0; i < 100; i++) {
                populateSubmits(papersList, conferenceList);
            }


//        session.flush();
            for (int i = 0; i < 400; i++) {
                populateWrites(papersList, authorList);
            }

        } catch (Exception e) {
            System.out.println("exception in main loop");
        }

    }

    private void recreateDatabase() throws IOException {
        session = entityManager.unwrap(Session.class);
        String schemaExecute = "schema.sql";
        String resourceAsString = getResourceAsString(schemaExecute);
        session.createNativeQuery(resourceAsString).executeUpdate();
    }

    @Transactional
    void populateWrites(List<Paper> papersList, List<Author> authorList) {
        session = entityManager.unwrap(Session.class);
        Writes writes = new Writes();
        int paperSize = papersList.size();
        Integer paperIdIdx = new Random().nextInt(paperSize);

        int authorSize = authorList.size();
        try {
        Integer authorIdx = new Random().nextInt(authorSize);
        writes.setAuthorid(authorList.get(authorIdx).getAuthorid());
        writes.setPaperid(papersList.get(paperIdIdx).getPaperid());
        session.save(writes);
        } catch (Exception e) {
              System.out.println("Exception in populateWrites");
//            populateCites(i);
        }
    }

    @Transactional
    void populateAuthor(String name) {
        session = entityManager.unwrap(Session.class);
        Author author = new Author();
        author.setName(name);
        author.setEmail(RandomString.make() + "@email.com");
        author.setAffiliation(new RandomString(3).nextString());
        session.save(author);
    }

    @Transactional
    void populateConference(String conferenceName) {
        session = entityManager.unwrap(Session.class);
        Conference conference = new Conference();
        conference.setRanking(new BigInteger(String.valueOf(new Random().nextInt(50))));
        conference.setRanking(new BigInteger("1"));
        conference.setName(conferenceName);
        session.save(conference);
    }

    @Transactional
    void populatePaper(String paperName) {
        session = entityManager.unwrap(Session.class);
        Paper paper = new Paper();
        paper.setTitle(paperName);
        paper.setExtract(RandomString.make(100));
        session.save(paper);
    }

    @Transactional
    void populateCites(List<Paper> papersList) {
        session = entityManager.unwrap(Session.class);
        Cites cite = new Cites();
        int size = papersList.size();
        Integer from = new Random().nextInt(size);
        Integer too = new Random().nextInt(size);
        if (from == 0 || too == 0) return;
        cite.setPaperidfrom(papersList.get(from).getPaperid());
        cite.setPaperidto(papersList.get(too).getPaperid());
        try {
            session.save(cite);
        } catch (Exception e) {
            System.out.println("Encountered repetitive key");
//            populateCites(i);
        }
    }

    @Transactional
    void populateSubmits(List<Paper> papersList, List<Conference> conferenceList) {
        try {
        session = entityManager.unwrap(Session.class);
        Submits submits = new Submits();
        int paperSize = papersList.size();
        Integer paperIdIdx = new Random().nextInt(paperSize);
        int confSize = conferenceList.size();
        Integer confIdIdx = new Random().nextInt(confSize);
        submits.setConfid(conferenceList.get(confIdIdx).getConfid());
        submits.setPaperid(papersList.get(paperIdIdx).getPaperid());
        submits.setIsaccepted(new Random().nextBoolean());
        submits.setDate(new Date(2019, 2, 3));

            session.save(submits);
        } catch (Exception e) {
            System.out.println("Encountered repetitive key");
        }
    }

    private String getResourceAsString(String resource) throws IOException {
        File classPathResource = new ClassPathResource(resource).getFile();
        return new String(Files.readAllBytes(classPathResource.toPath()));
    }

}
