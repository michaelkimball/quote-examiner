package dev.michaelkimball.opennlp.controllers;

import dev.michaelkimball.opennlp.services.NLPProcessingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/nlp")
public class NLPController {

    private final NLPProcessingService nlpProcessingService;

    @Autowired
    public NLPController(NLPProcessingService nlpProcessingService) {
        this.nlpProcessingService = nlpProcessingService;
    }

    @PostMapping()
    public ResponseEntity<Void> postExamineParagraph(@RequestBody String paragraph) {
        nlpProcessingService.processParagraph(paragraph);
        return ResponseEntity.noContent().build();
    }
}
