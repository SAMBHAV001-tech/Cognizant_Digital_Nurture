package com.cognizant.mocking;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MyServiceTest {

    @Mock
    private ExternalApi externalApi;

    @InjectMocks
    private MyService myService;

    @Test
    public void testProcessDataSuccess() {
        when(externalApi.fetchData("userQuery")).thenReturn("sample data");

        String result = myService.processData("userQuery");

        assertEquals("PROCESSED: SAMPLE DATA", result);
    }

    @Test
    public void testProcessDataNull() {
        when(externalApi.fetchData("invalidQuery")).thenReturn(null);

        String result = myService.processData("invalidQuery");

        assertEquals("NO_DATA", result);
    }

    @Test
    public void testCalculateScaledValue() {
        when(externalApi.getDataValue(100)).thenReturn(25);

        int result = myService.calculateScaledValue(100, 4);

        assertEquals(100, result);
    }
}
