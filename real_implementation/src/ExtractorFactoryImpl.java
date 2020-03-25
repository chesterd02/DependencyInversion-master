public class ExtractorFactoryImpl implements ExtractorFactory {
    @Override
    public WordExtractor makeWordExtractor() {
        return new WordExtractor();
    }
}
