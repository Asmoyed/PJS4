package com.logic.dto.serialization;

public class ObjectNotSerializableException extends Exception
{
    public ObjectNotSerializableException(String msg)
    {
        super(msg);
    }
}
