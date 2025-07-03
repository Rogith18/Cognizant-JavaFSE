package demo;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import demo.MyService;
import demo.ExternalApi;

public class MyServiceTest {

    @Test
    public void testVerifyInteraction() {
        // Step 1: Mock object
        ExternalApi mockApi = mock(ExternalApi.class);

        // Step 2: Inject into service and call method
        MyService service = new MyService(mockApi);
        service.fetchData();

        // Step 3: Verify the interaction
        verify(mockApi).getData();
    }
}
