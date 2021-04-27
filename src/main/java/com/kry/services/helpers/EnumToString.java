package com.kry.services.helpers;

public class EnumToString {

    public String enumToString(PollStatus pollStatus)
    {
        switch (pollStatus)
        {
            case OK:
                return "OK";
            case FAIL:
                return "FAIL";
            case INVALID_URL:
                return "INVALID_URL";
        }
        return "NOT POSSIBLE";
    }
}
