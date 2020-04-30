package dev.michaelkimball.opennlp.services;

import dev.michaelkimball.opennlp.models.ExaminedQuote;
import dev.michaelkimball.opennlp.repositories.ExaminedQuoteRepository;
import lombok.extern.slf4j.Slf4j;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.tokenize.TokenizerME;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
@Service
public class NLPProcessingService {
    private final SentenceDetectorME sentenceDetector;
    private final TokenizerME tokenizerME;
    private final POSTaggerME posTaggerME;
    private final ExaminedQuoteRepository examinedQuoteRepository;

    @Autowired
    public NLPProcessingService(SentenceDetectorME sentenceDetector,
                                TokenizerME tokenizerME,
                                POSTaggerME posTaggerME,
                                ExaminedQuoteRepository examinedQuoteRepository) {
        this.sentenceDetector = sentenceDetector;
        this.tokenizerME = tokenizerME;
        this.posTaggerME = posTaggerME;
        this.examinedQuoteRepository = examinedQuoteRepository;
    }

    public void processParagraph(String paragraph){
        log.debug("Original Quote: {}", paragraph);
        ExaminedQuote examinedQuote = new ExaminedQuote().withOriginal(paragraph);
        String strippedSentences = String.join("\n",
                stripSentences(getSentences(paragraph)));
        log.debug("Stripped Quote: {}", strippedSentences);
        examinedQuote = examinedQuote.withStripped(strippedSentences);
        String[] tokens = getTokens(paragraph.toLowerCase());
        Map<String, Integer> tokenCount = countTokens(tokens);
        log.debug("token count: {}", tokenCount);
        examinedQuote = examinedQuote.withYou(tokenCount.getOrDefault("you", 0))
                .withThat(tokenCount.getOrDefault("that", 0))
                .withThing(tokenCount.getOrDefault("thing", 0))
                .withThey(tokenCount.getOrDefault("they", 0))
                .withPeriods(tokenCount.getOrDefault(".", 0));
        Map<String, Integer> posCount = countTokens(getPOS(tokens));
        log.debug("pos count: {}", posCount);
        examinedQuote = examinedQuote.withNouns(posCount.getOrDefault("NN", 0) +
                posCount.getOrDefault("NNP", 0))
                .withVerbs(posCount.getOrDefault("VB", 0) +
                        posCount.getOrDefault("VBD", 0) +
                        posCount.getOrDefault("VBZ", 0));
        examinedQuoteRepository.save(examinedQuote);
    }

    public String[] getSentences(String paragraph){
        return sentenceDetector.sentDetect(paragraph);
    }

    public List<String> stripSentences(String[] sentences){
        return IntStream.range(0, sentences.length)
                .filter(index -> index != 2 && index != 4)
                .mapToObj(index -> sentences[index])
                .collect(Collectors.toList());
    }

    public String[] getTokens(String paragraph){
        return tokenizerME.tokenize(paragraph);
    }

    public String[] getPOS(String[] tokens){
        return posTaggerME.tag(tokens);
    }

    public Map<String, Integer> countTokens(String[] tokens){
        Map<String, Integer> tokenCount = new HashMap<>();
        Arrays.stream(tokens).forEach(part -> {
            int count = tokenCount.getOrDefault(part, 0);
            tokenCount.put(part, count + 1);
        });
        return tokenCount;
    }
}
