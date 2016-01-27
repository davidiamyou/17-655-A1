package systemA;

import framework.SourceFilterTemplate;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Weinan Qiu
 * @since 1.0.0
 */
public class FileSourceFilter extends SourceFilterTemplate {

    private InputStream in;

    public FileSourceFilter(final String fileName) throws FileNotFoundException {
        super();
        in = new FileInputStream(fileName);
    }

    @Override
    protected byte readOneByte() {
        try {
            return (byte) in.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected boolean hasReachedEndOfStream() {
        try {
            return in.available() == 0;
        } catch (IOException e) {
            return true;
        }
    }
}
