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
import uk.ac.ebi.subs.validator.data.ValidationResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ValidationResultRepository.class)
@EnableAutoConfiguration
public class ValidationResultRepositoryTest {

    @Autowired
    ValidationResultRepository validationResultRepository;

    private ValidationResult validationResult;

    @Before
    public void buildUp() {
        Map<Archive, Boolean> expectedResults = new HashMap<>();
        expectedResults.put(Archive.BioSamples, true);
        expectedResults.put(Archive.ArrayExpress, false);
        expectedResults.put(Archive.Ena, false);

        validationResult = new ValidationResult();
        validationResult.setUuid(UUID.randomUUID().toString());
        validationResult.setExpectedResults(expectedResults);
        validationResult.setVersion(1);
        validationResult.setSubmissionId("123");
        validationResult.setEntityUuid("44566");

        // First
        validationResultRepository.insert(validationResult);

        validationResult.setUuid(UUID.randomUUID().toString());
        validationResult.setSubmissionId("456");
        validationResult.setEntityUuid("98876");

        // Second
        validationResultRepository.insert(validationResult);
    }

    @Test
    public void persistValidationResultTest() {
        ValidationResult retrievedResult = validationResultRepository.findOne(validationResult.getUuid());
        System.out.println(retrievedResult);

        assertThat(retrievedResult.getExpectedResults().get(Archive.BioSamples), is(true));
    }

    @Test
    public void findBySubmissionIdAndEntityUuidTest() {
        List<ValidationResult> validationResults = validationResultRepository.findBySubmissionIdAndEntityUuid("123", "44566");
        System.out.println(validationResults);

        Assert.assertEquals(1, validationResults.size());
    }

    @After
    public void tearDown() {
        validationResultRepository.deleteAll();
    }

}