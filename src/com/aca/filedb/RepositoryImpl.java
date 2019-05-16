package com.aca.filedb;

import java.io.IOException;
import java.io.Serializable;

public class RepositoryImpl<Key, Value extends Serializable> implements Repository<Key, Value> {

    private StringRepositoryImpl stringRepository;
    private Class<Value> valueClass;

    public RepositoryImpl(Class<Value> aClass) {
        this.stringRepository = new StringRepositoryImpl(aClass.getSimpleName() + ".txt");
        this.valueClass = aClass;
    }

    @Override
    public void open() throws IOException {
        stringRepository.open();
    }

    @Override
    public void put(Key key, Value value) throws IOException {
        String stringValue = ObjectSerializer.toString(value);
        stringRepository.put(key.toString(), stringValue);
    }

    @Override
    public Value get(Key key) throws IOException {
        String stingValue = stringRepository.get(key.toString());
        Object value = ObjectSerializer.fromString(stingValue);
        if (valueClass.isInstance(value)){
            return (Value) value;
        }
        return null;
    }

    @Override
    public void close() throws IOException {
        stringRepository.close();
    }
}

