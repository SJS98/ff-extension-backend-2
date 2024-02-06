package dev.extlogic.service;

import opennlp.tools.postag.POSModel;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class Level_2_Methods {
    public List<String> extractSentenceOfStep(String step) throws IOException {
        // Load sentence model
        InputStream sentenceModelStream = new FileInputStream("C:\\Users\\User\\Downloads\\ext-logic\\ext-logic\\src\\ResourceData\\en-sent.zip");
        SentenceModel sentenceModel = new SentenceModel(sentenceModelStream);
        SentenceDetectorME sentenceDetector = new SentenceDetectorME(sentenceModel);

        // Load tokenizer model
        InputStream tokenizerModelStream = new FileInputStream("C:\\Users\\User\\Downloads\\ext-logic\\ext-logic\\src\\ResourceData\\en-token.zip");
        TokenizerModel tokenizerModel = new TokenizerModel(tokenizerModelStream);
        TokenizerME tokenizer = new TokenizerME(tokenizerModel);

        InputStream posIn = new FileInputStream("");
        POSModel posModel = new POSModel(posIn);

        // Detect sentences
        String[] sentences = sentenceDetector.sentDetect(step);

        // Extract steps from each sentence
        for (String sentence : sentences) {
            String[] tokens = tokenizer.tokenize(sentence);
            System.out.println("Steps: " + String.join(" ", tokens));
        }

//        // Close streams
//        sentenceModelStream.close();
//        tokenizerModelStream.close();

//        InputStream modelIn = new FileInputStream("C:\\Users\\User\\Downloads\\ext-logic\\ext-logic\\src\\ResourceData\\en-sent.zip");
//        SentenceModel model = new SentenceModel(modelIn);
//        SentenceDetectorME sentenceDetector = new SentenceDetectorME(model);
//        String text = step;
//        String[] sentences = sentenceDetector.sentDetect(text);

        return List.of(new String[0]);
    }

    public List<String> separateSentences(String step) throws IOException{
        List<String> sentences = new ArrayList<>();
        InputStream modelIn = new FileInputStream("C:\\Users\\User\\Downloads\\ext-logic\\ext-logic\\src\\ResourceData\\en-sent.zip");
        SentenceModel model = new SentenceModel(modelIn);
        SentenceDetectorME sentenceDetector = new SentenceDetectorME(model);
        String[] dotSeparated = sentenceDetector.sentDetect(step);
        for (String sentence1: dotSeparated) {
            String[] andSeparated = sentence1.toLowerCase().split("and");
            for (String sentence : andSeparated) {
                sentences.add(sentence.trim());
            }
        }
        return sentences;
    }


}