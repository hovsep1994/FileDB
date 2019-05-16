package com.aca.filedb;

import java.io.Closeable;
import java.io.IOException;

public interface Repository<Key, Value> extends Closeable {

    void open() throws IOException;

    void put(Key key, Value value) throws IOException;

    Value get(Key key) throws IOException;

}
