import java.io.IOException;

public class DictionaryFactoryImpl implements DictionaryFactory {
    String file;
    Dictionary dict;

    public DictionaryFactoryImpl(String file)throws IOException {
        this.file = file;
        dict = new Dictionary(file);
    }

    @Override
    public Dictionary makeDict() {
        return dict;
    }

}
