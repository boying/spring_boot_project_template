package boying;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by boying on 2017/7/6.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootProjectTemplateApplication.class)
public class BaseTest {
    @Before
    public void initMocks() throws Exception{
        MockitoAnnotations.initMocks(this);
    }
}
