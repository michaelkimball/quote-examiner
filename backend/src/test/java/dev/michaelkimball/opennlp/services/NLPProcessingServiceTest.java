package dev.michaelkimball.opennlp.services;

import dev.michaelkimball.opennlp.config.AppConfig;
import dev.michaelkimball.opennlp.config.NLPConfig;
import dev.michaelkimball.opennlp.repositories.MockExaminedQuoteRepository;
import dev.michaelkimball.opennlp.repositories.MockUserRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NLPProcessingServiceTest {

    private static NLPProcessingService nlpProcessingService;

    @BeforeAll
    static void beforeAll() throws Exception{
        NLPConfig nlpConfig = new NLPConfig();
        nlpProcessingService = new NLPProcessingService(nlpConfig.sentenceDetectorME(),
                nlpConfig.tokenizerME(), nlpConfig.posTaggerME(), new MockExaminedQuoteRepository(),
                new AppConfig(false), new UserService(new MockUserRepository()));
    }

    @Test
    void getSentencesCountTwo(){
        String[] sentences = nlpProcessingService.getSentences("This is a test. This is a big test.");
        assertEquals(2, sentences.length);
        assertEquals("This is a test.", sentences[0]);
        assertEquals("This is a big test.", sentences[1]);
    }

    @Test
    void stripSentencesMissing3And5(){
        String[] sentences = {
                "This is sentence one.",
                "This is sentence two.",
                "This is sentence three.",
                "This is sentence four.",
                "This is sentence five.",
                "This is sentence six.",
        };

        List<String> strippedSentences = nlpProcessingService.stripSentences(sentences);
        assertEquals(4, strippedSentences.size());
        assertEquals("This is sentence four.", strippedSentences.get(2));
    }
}
