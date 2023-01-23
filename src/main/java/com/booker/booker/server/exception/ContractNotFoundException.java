package com.booker.booker.server.exception;

public class ContractNotFoundException extends RuntimeException
{
    public ContractNotFoundException( String message )
    {
        super( message );
    }
}
