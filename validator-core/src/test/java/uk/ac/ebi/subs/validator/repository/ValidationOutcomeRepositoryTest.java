package uk.ac.ebi.subs.validator.repository;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import uk.ac.ebi.subs.data.component.Archive;
import uk.ac.ebi.subs.validator.data.ValidationOutcome;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ValidationOutcomeRepository.class)
@EnableAutoConfiguration
public class ValidationOutcomeRepositoryTest {

    @Autowired
    ValidationOutcomeRepository validationOutcomeRepository;

    private ValidationOutcome validationOutcome;

    @Before
    public void buildUp() {
        Map<Archive, Boolean> expectedOutcomes = new HashMap<>();
        expectedOutcomes.put(Archive.BioSamples, true);
        expectedOutcomes.put(Archive.ArrayExpress, false);
        expectedOutcomes.put(Archive.Ena, false);

        validationOutcome = new ValidationOutcome();
        validationOutcome.setUuid(UUID.randomUUID().toString());
        validationOutcome.setExpectedOutcomes(expectedOutcomes);
        validationOutcome.setVersion("1.0");
        validationOutcome.setSubmissionId("123");
        validationOutcome.setEntityUuid("44566");

        // First
        validationOutcomeRepository.insert(validationOutcome);

        validationOutcome.setUuid(UUID.randomUUID().toString());
        validationOutcome.setSubmissionId("456");
        validationOutcome.setEntityUuid("98876");

        // Second
        validationOutcomeRepository.insert(validationOutcome);
    }

    @Test
    public void persistValidationOutcomeTest() {
        ValidationOutcome retrievedOutcome = validationOutcomeRepository.findOne(validationOutcome.getUuid());
        System.out.println(retrievedOutcome);

        assertThat(retrievedOutcome.getExpectedOutcomes().get(Archive.BioSamples), is(true));
    }

    @Test
    public void findBySubmissionIdAndEntityUuidTest() {
        List<ValidationOutcome> validationOutcomes = validationOutcomeRepository.findBySubmissionIdAndEntityUuid("123", "44566");
        System.out.println(validationOutcomes);

        Assert.assertEquals(1, validationOutcomes.size());
    }

    @After
    public void tearDown() {
        validationOutcomeRepository.deleteAll();
    }

}