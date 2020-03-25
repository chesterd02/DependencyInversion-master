import java.io.IOException;
import java.net.URL;

public class FetchFactoryImpl implements FetchFactory {
    URL url;
    URLFetcher urlFetcher;

    public FetchFactoryImpl(URL url) throws IOException {
        this.url = url;
        urlFetcher = new URLFetcher(url);
    }

    @Override
    public URLFetcher makeURLFetcher() {
        return urlFetcher;
    }
}
