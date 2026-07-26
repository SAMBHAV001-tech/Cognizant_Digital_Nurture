package com.cognizant.mocking;

public class MyService {

    private final ExternalApi externalApi;

    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    public String processData(String query) {
        String data = externalApi.fetchData(query);
        if (data == null) {
            return "NO_DATA";
        }
        return "PROCESSED: " + data.toUpperCase();
    }

    public int calculateScaledValue(int id, int factor) {
        int val = externalApi.getDataValue(id);
        return val * factor;
    }
}
