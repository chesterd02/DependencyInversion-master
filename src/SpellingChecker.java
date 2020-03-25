import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;


public class SpellingChecker implements SpellCheckerInterface{
        private FetchFactory fetcher;
        private ExtractorFactory extractor;
        private DictionaryFactory dictionary;





    public SpellingChecker(FetchFactory fetcher, ExtractorFactory extractor, DictionaryFactory dictionary) {
        this.fetcher = fetcher;
        this.extractor = extractor;
        this.dictionary = dictionary;
    }


    public SortedMap<String, Integer> check() throws IOException {

		// download the document content
		//
		String content = fetcher.makeURLFetcher().fetch();

		// extract words from the content
		//
		List<String> words = extractor.makeWordExtractor().extract(content);

		// find spelling mistakes
		//
		SortedMap<String, Integer> mistakes = new TreeMap<>();

        for (String word : words) {
            if (!dictionary.makeDict().isValidWord(word)) {
                if (mistakes.containsKey(word)) {
                    int oldCount = mistakes.get(word);
                    mistakes.put(word, oldCount + 1);
                } else {
                    mistakes.put(word, 1);
                }
            }
        }

		return mistakes;
	}
}

