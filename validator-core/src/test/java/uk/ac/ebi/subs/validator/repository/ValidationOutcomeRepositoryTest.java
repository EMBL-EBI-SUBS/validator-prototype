package uk.ac.ebi.subs.validator.repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import uk.ac.ebi.subs.data.component.Archive;
import uk.ac.ebi.subs.validator.data.ValidationOutcome;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ValidationOutcomeRepository.class)
@EnableAutoConfiguration
public class ValidationOutcomeRepositoryTest {

    @Autowired
    ValidationOutcomeRepository validationOutcomeRepository;

    ValidationOutcome validationOutcome;

    List<Archive> expectedArchives;

    @Before
    public void buildUp() {
        expectedArchives = Arrays.asList(Archive.BioSamples, Archive.Ena);
    }

    @After
    public void tearDown() {
        validationOutcomeRepository.deleteAll();
    }

    private void persistValidationOutcome() {
        validationOutcome = new ValidationOutcome();
        validationOutcome.setUuid(UUID.randomUUID().toString());
        validationOutcome.setExpectedArchives(expectedArchives);
        validationOutcome.setExpectedOutcomes(new HashMap<>());
        validationOutcome.getExpectedOutcomes().put(Archive.BioSamples, true);

        validationOutcomeRepository.insert(validationOutcome);
    }

    @Test
    public void testPersistValidationOutcome() {
        persistValidationOutcome();

        ValidationOutcome retrievedOutcome = validationOutcomeRepository.findOne(validationOutcome.getUuid());

        System.out.println(retrievedOutcome);

        assertThat(retrievedOutcome.getExpectedOutcomes().get(Archive.BioSamples), is(true));
    }
}