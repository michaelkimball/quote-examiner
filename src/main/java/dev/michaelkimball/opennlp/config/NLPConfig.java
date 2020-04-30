package dev.michaelkimball.opennlp.config;

import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.InputStream;

@Configuration
public class NLPConfig {
    @Bean
    public SentenceDetectorME sentenceDetectorME() throws Exception{
        InputStream is = getClass().getResourceAsStream("/models/en-sent.bin");
        SentenceModel model = new SentenceModel(is);
        return new SentenceDetectorME(model);
    }

    @Bean
    public TokenizerME tokenizerME() throws Exception{
        InputStream is = getClass().getResourceAsStream("/models/en-token.bin");
        TokenizerModel model = new TokenizerModel(is);
        return new TokenizerME(model);
    }

    @Bean
    public POSTaggerME posTaggerME() throws Exception{
        InputStream is = getClass().getResourceAsStream("/models/en-pos-maxent.bin");
        POSModel model = new POSModel(is);
        return new POSTaggerME(model);
    }
}
