package demo;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import demo.MyService;
import demo.ExternalApi;

public class MyServiceTest {
	 @Test
	    public void testExternalApi() {
	        // Step 1: Create a mock
	        ExternalApi mockApi = mock(ExternalApi.class);

	        // Step 2: Stub the method
	        when(mockApi.getData()).thenReturn("Mock Data");

	        // Step 3: Inject mock into service and call method
	        MyService service = new MyService(mockApi);
	        String result = service.fetchData();

	        // Step 4: Assert
	        assertEquals("Mock Data", result);
	    }
}
