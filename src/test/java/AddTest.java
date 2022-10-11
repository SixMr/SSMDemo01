import com.lhy.demo04.dao.CustomerMapper;
import com.lhy.demo04.entity.Customer;
import com.lhy.demo04.utils.addDataUtil;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 时间: 2022/10/10 20:35
 */
public class AddTest {
    @Test
    public void add() {
        addDataUtil addDataUtil = new addDataUtil();
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-mapper.xml");
        CustomerMapper customerMapper = ioc.getBean("customerMapper", CustomerMapper.class);
        Customer customer = null;
        System.out.println(addDataUtil.getChineseName());
        for (int i = 0; i < 1000; i++) {
            customer = new Customer(
                    null,
                    addDataUtil.getChineseName().substring(2),
                    String.valueOf(addDataUtil.getNum(100000000,999999999)),
                    String.valueOf(addDataUtil.getTel())

            );
            customerMapper.add(customer);
            /*System.out.println(customer);*/
        }

    }
}
