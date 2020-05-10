package dev.michaelkimball.opennlp.controllers;

import dev.michaelkimball.opennlp.models.Paragraph;
import dev.michaelkimball.opennlp.services.NLPProcessingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Void> postExamineParagraph(@RequestBody Paragraph paragraph) {
        nlpProcessingService.processParagraph(paragraph.getParagraph());
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "{_:^(?!index\\.html|nlp).*$}")
    public String redirectApi() {
        return "forward:/";
    }
}
