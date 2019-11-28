package mocks;

import java.io.InputStream;

public class MockInputStream extends InputStream {

    public int read() {
        return 0;
    }

}
