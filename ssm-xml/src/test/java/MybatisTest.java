import com.test.dao.BookMapper;
import com.test.service.BookService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;

public class MybatisTest {
    @Test
    public void getBook(){
        //获取资源文件有好几种方法
        String path = "mybatis-config.xml";
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream(path);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            BookMapper mapper = sqlSession.getMapper(BookMapper.class);
            System.out.println(mapper.getBook(3));
//            mapper.insertBook(3,"go语言",10,"go基础");
            sqlSession.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void getBook1(){
        String path = "applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(path);
        BookService bookService = (BookService) context.getBean("bookService");
        System.out.println(bookService.getBook(1));
    }
}
