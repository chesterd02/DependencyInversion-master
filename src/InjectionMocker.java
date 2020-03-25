import com.google.inject.AbstractModule;



public class InjectionMocker extends AbstractModule {
    @Override
    protected void configure() {
        bind(DictionaryInterface.class).to(Dictionary.class);
        bind(ExtractorInterface.class).to(WordExtractor.class);
        bind(FetchInterface.class).to(URLFetcher.class);
    }

}
