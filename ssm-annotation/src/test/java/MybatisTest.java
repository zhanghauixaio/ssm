import com.test.config.RootConfig;
import com.test.service.BookService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MybatisTest {
    @Test
    public void getBook1(){
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(RootConfig.class);
        context.refresh();
        BookService bookService = (BookService) context.getBean("bookService");
        System.out.println(bookService.getBook(1));
    }

}
