import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

import java.io.IOException;
import java.net.URL;
import java.util.SortedMap;


public class Main {

	@Inject
	public static void main(String[] args) {

		try {
			URL url = new URL(args[0]);
			Injector injector = Guice.createInjector(new InjectionMocker());

//			FetchFactory fetch = new FetchFactoryImpl(url);
//			ExtractorFactory extractor = new ExtractorFactoryImpl();
//			DictionaryFactory dictionary = new DictionaryFactoryImpl("dict.txt");



			SpellCheckerInterface spellChecker = injector.getInstance(SpellingChecker.class);
			spellChecker.makeDict("dict.txt");
			SortedMap<String, Integer> mistakes = spellChecker.check(url);
			System.out.println(mistakes);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}

