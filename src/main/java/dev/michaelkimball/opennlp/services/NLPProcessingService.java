package dev.michaelkimball.opennlp.services;

import dev.michaelkimball.opennlp.config.AppConfig;
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
    private static final String YOU = "you";
    private static final String THAT = "that";
    private static final String THING = "thing";
    private static final String THEY = "they";
    private static final String PERIOD = "period";
    private static final String PROPER_NOUN = "NNP";
    private static final String NOUN = "NN";
    private static final String VERB_BASE = "VB";
    private static final String VERB_PAST = "VBD";
    private static final String VERB_PRESENT = "VBZ";
    private static final int NOT_FOUND = 0;
    private final SentenceDetectorME sentenceDetector;
    private final TokenizerME tokenizerME;
    private final POSTaggerME posTaggerME;
    private final ExaminedQuoteRepository examinedQuoteRepository;
    private final AppConfig appConfig;

    @Autowired
    public NLPProcessingService(SentenceDetectorME sentenceDetector,
                                TokenizerME tokenizerME,
                                POSTaggerME posTaggerME,
                                ExaminedQuoteRepository examinedQuoteRepository,
                                AppConfig appConfig) {
        this.sentenceDetector = sentenceDetector;
        this.tokenizerME = tokenizerME;
        this.posTaggerME = posTaggerME;
        this.examinedQuoteRepository = examinedQuoteRepository;
        this.appConfig = appConfig;
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
        examinedQuote = examinedQuote.withYou(tokenCount.getOrDefault(YOU, NOT_FOUND))
                .withThat(tokenCount.getOrDefault(THAT, NOT_FOUND))
                .withThing(tokenCount.getOrDefault(THING, NOT_FOUND))
                .withThey(tokenCount.getOrDefault(THEY, NOT_FOUND))
                .withPeriods(tokenCount.getOrDefault(PERIOD, NOT_FOUND));
        Map<String, Integer> posCount = countTokens(getPOS(tokens));
        log.debug("pos count: {}", posCount);
        examinedQuote = examinedQuote.withNouns(posCount.getOrDefault(NOUN, NOT_FOUND) +
                        posCount.getOrDefault(PROPER_NOUN, NOT_FOUND))
                .withVerbs(posCount.getOrDefault(VERB_BASE, NOT_FOUND) +
                        posCount.getOrDefault(VERB_PAST, NOT_FOUND) +
                        posCount.getOrDefault(VERB_PRESENT, NOT_FOUND));
        examinedQuoteRepository.save(examinedQuote);
    }

    public String[] getSentences(String paragraph){
        return sentenceDetector.sentDetect(paragraph);
    }

    public List<String> stripSentences(String[] sentences){
        return IntStream.range(NOT_FOUND, sentences.length)
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
            int count = tokenCount.getOrDefault(part, NOT_FOUND);
            tokenCount.put(part, count + 1);
        });
        return tokenCount;
    }

    public void bootstrap(){
        if(appConfig.hasBootstrap()) {
            processParagraph("Atticus said to Jem one day, \"I'd rather you shot at tin cans in the backyard, but I know you'll go after birds. Shoot all the blue jays you want, if you can hit 'em, but remember it's a sin to kill a mockingbird.\" That was the only time I ever heard Atticus say it was a sin to do something, and I asked Miss Maudie about it. \"Your father's right,\" she said. \"Mockingbirds don't do one thing except make music for us to enjoy. They don't eat up people's gardens, don't nest in corn cribs, they don't do one thing but sing their hearts out for us. That's why it's a sin to kill a mockingbird.");
            processParagraph("The most important things are the hardest to say. They are the things you get ashamed of, because words diminish them — words shrink things that seemed limitless when they were in your head to no more than living size when they're brought out. But it's more than that, isn't it? The most important things lie too close to wherever your secret heart is buried, like landmarks to a treasure your enemies would love to steal away. And you may make revelations that cost you dearly only to have people look at you in a funny way, not understanding what you've said at all, or why you thought it was so important that you almost cried while you were saying it. That's the worst, I think. When the secret stays locked within not for want of a teller but for want of an understanding ear.");
        }
    }
}
