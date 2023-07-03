import com.mongodb.client.MongoClients;
//import com.test.config.RootConfig;
import com.test.controller.AsyncController;
import com.test.controller.CacheController;
import com.test.pojo.Book;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;


public class BeanTest {
//    @Test
//    public void testAsync(){
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//        context.register(RootConfig.class);
//        context.refresh();
//        AsyncController asyncController = context.getBean(AsyncController.class);
//        asyncController.getStr();
//        asyncController.getStr1();
//    }

    @Test
    public void getMongo(){
        MongoOperations operations = new MongoTemplate(MongoClients.create(),"runoob");
        System.out.println(operations.getCollectionNames());
        System.out.println(operations.getCollection("runoob").find());
    }

    @Test
    public void getBean() {
//        StopWatch stopWatch = new StopWatch();
//        stopWatch.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        BeanDefinitionBuilder builder = BeanDefinitionBuilder
                .genericBeanDefinition(Book.class.getName())
                .addPropertyValue("bookName", "Java");
        BeanDefinition definition = builder.getBeanDefinition();

        System.out.println(definition);
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        factory.registerBeanDefinition("book", definition);
        factory.addBeanPostProcessor(new InstantiationAwareBeanPostProcessor() {
            public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
                return null;
            }
        });
        System.out.println(factory.getBeanDefinitionNames());
        System.out.println(factory.getBean("book"));
//        stopWatch.stop();
//        System.out.println("程序运行时间 " + stopWatch.prettyPrint());

    }

    @Test
    public void KK(){
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        System.out.println(context.getBean("a"));
    }
}

