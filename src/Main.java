import java.io.IOException;
import java.net.URL;
import java.util.SortedMap;


public class Main {


	public static void main(String[] args) {

		try {
			URL url = new URL(args[0]);
			FetchFactory fetch = new FetchFactoryImpl(url);
			ExtractorFactory extractor = new ExtractorFactoryImpl();
			DictionaryFactory dictionary = new DictionaryFactoryImpl("dict.txt");


			SpellCheckerInterface checker = new SpellingChecker(fetch, extractor, dictionary);
			SortedMap<String, Integer> mistakes = checker.check();
			System.out.println(mistakes);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}

