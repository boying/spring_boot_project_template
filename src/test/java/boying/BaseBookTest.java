package boying;

import org.springframework.transaction.annotation.Transactional;

/**
 * Created by boying on 2018/5/1.
 */
@Transactional("bookTransactionManager")
public class BaseBookTest extends BaseTest{
}
