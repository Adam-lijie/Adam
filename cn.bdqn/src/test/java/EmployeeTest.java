import Mapper.EmployeeMapper;
import cn.bdqn.doman.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.*;

public class EmployeeTest {
    // 测试1： 查询全部的员工
    @Test
    public void testSelectAllEmployees() throws Exception{
        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis.config.xml");

        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        // 3、用SqlSessionFactory工厂去创建SqlSession
        SqlSession session = factory.openSession();

        // 4、通过SqlSession提供的方法查询数据[参数是一个查询id,组成: namespace+id]
        List<Employee> employees = session.selectList("Mapper.EmployeeMapper.selectAllEmployees");

        // 5、循环遍历
        if (employees != null && employees.size() > 0){
            for (Employee emp:employees) {
                System.out.println(emp);
            }
        }

        // 6、关闭SqlSession
        session.close();

        // 7、关闭流
        is.close();
    }
    @Test
    public void list() throws Exception{
        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis.config.xml");
        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        // 3、用SqlSessionFactory工厂去创建SqlSession
        SqlSession session = factory.openSession();
        EmployeeMapper employeeMapper=session.getMapper(EmployeeMapper.class);
        // 4、通过SqlSession提供的方法查询数据[参数是一个查询id,组成: namespace+id]
        List<Employee> employees =employeeMapper.list();
        // 5、循环遍历
        if (employees != null && employees.size() > 0){
            for (Employee emp:employees) {
                System.out.println(emp);
            }
        }
        // 6、关闭SqlSession
        session.close();

        // 7、关闭流
        is.close();
    }

    @Test
    public void add () throws Exception{
        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis.config.xml");
        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        // 3、用SqlSessionFactory工厂去创建SqlSession
        SqlSession session = factory.openSession(true);
        // 4、通过SqlSession提供的方法查询数据[参数是一个查询id,组成: namespace+id]
        Employee em=new Employee();
        em.setEmpName("李想");
        em.setSex("男");
        em.setBirthday(new Date());
        em.setAddress("河南");
        em.setEmail("241.com");
        EmployeeMapper employeeMapper=session.getMapper(EmployeeMapper.class);
        employeeMapper.add(em);
        session.close();
        // 7、关闭流
        is.close();
    }
    @Test
    public void del() throws Exception{
        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis.config.xml");
        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        // 3、用SqlSessionFactory工厂去创建SqlSession
        SqlSession session = factory.openSession(true);
        // 4、通过SqlSession提供的方法查询数据[参数是一个查询id,组成: namespace+id]
        EmployeeMapper employeeMapper=session.getMapper(EmployeeMapper.class);
        employeeMapper.del(13);
        session.close();
        // 7、关闭流
        is.close();
    }
    @Test
    public void up() throws Exception{
        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis.config.xml");
        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        // 3、用SqlSessionFactory工厂去创建SqlSession
        SqlSession session = factory.openSession(true);
        // 4、通过SqlSession提供的方法查询数据[参数是一个查询id,组成: namespace+id]
        Employee em=new Employee();
        em.setEmpName("李11");
        em.setSex("女");
        em.setBirthday(new Date());
        em.setAddress("信阳");
        em.setEmail("888.com");
        em.setId(1);
        EmployeeMapper employeeMapper=session.getMapper(EmployeeMapper.class);
        employeeMapper.up(em);
        session.close();
        // 7、关闭流
        is.close();
    }
    @Test
    public void li() throws Exception{
        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis.config.xml");
        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        // 3、用SqlSessionFactory工厂去创建SqlSession
        SqlSession session = factory.openSession();
        EmployeeMapper employeeMapper=session.getMapper(EmployeeMapper.class);
        // 4、通过SqlSession提供的方法查询数据[参数是一个查询id,组成: namespace+id]
        List<Employee> employees =employeeMapper.li("洁");
        // 5、循环遍历
        if (employees != null && employees.size() > 0){
            for (Employee emp:employees) {
                System.out.println(emp);
            }
        }
        // 6、关闭SqlSession
        session.close();

        // 7、关闭流
        is.close();
    }
    @Test
    public void byidandname() throws Exception{
        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis.config.xml");
        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        // 3、用SqlSessionFactory工厂去创建SqlSession
        SqlSession session = factory.openSession();
        EmployeeMapper employeeMapper=session.getMapper(EmployeeMapper.class);
        // 4、通过SqlSession提供的方法查询数据[参数是一个查询id,组成: namespace+id]
     Employee employees =employeeMapper.byidandname (1,"李洁");
        // 5、循环遍历
                System.out.println(employees);
        // 6、关闭SqlSession
        session.close();
        // 7、关闭流
        is.close();
    }
    @Test
    public void selectbyIdname() throws Exception{
        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis.config.xml");
        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        // 3、用SqlSessionFactory工厂去创建SqlSession
        SqlSession session = factory.openSession();
        EmployeeMapper employeeMapper=session.getMapper(EmployeeMapper.class);
        // 4、通过SqlSession提供的方法查询数据[参数是一个查询id,组成: namespace+id]
        Map<String,Object> wzm=new HashMap<String, Object>();
        wzm.put("byid",1);
        wzm.put("byname","李洁");
        Employee employees =employeeMapper.selectbyIdname (wzm);
        // 5、循环遍历
        System.out.println(employees);
        // 6、关闭SqlSession
        session.close();
        // 7、关闭流
        is.close();
    }
    @Test
    public void selectbyidSu() throws Exception{
        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis.config.xml");
        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        // 3、用SqlSessionFactory工厂去创建SqlSession
        SqlSession session = factory.openSession();
        EmployeeMapper employeeMapper=session.getMapper(EmployeeMapper.class);
        List<Integer> lep=new ArrayList<Integer>();
        lep.add(14);
        Employee mplo=employeeMapper.selectbyidSu(lep);
        System.out.println(mplo);
        // 6、关闭SqlSession
        session.close();
        // 7、关闭流
        is.close();
    }
    @Test
    public void selectbysz() throws Exception{
        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis.config.xml");
        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        // 3、用SqlSessionFactory工厂去创建SqlSession
        SqlSession session = factory.openSession();
        EmployeeMapper employeeMapper=session.getMapper(EmployeeMapper.class);
       Integer[] arr={14};
        Employee mplo=employeeMapper.selectbysz(arr);
        System.out.println(mplo);
        // 6、关闭SqlSession
        session.close();
        // 7、关闭流
        is.close();
    }
    @Test
    public void sect() throws Exception{
        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis.config.xml");
        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        // 3、用SqlSessionFactory工厂去创建SqlSession
        SqlSession session = factory.openSession();
        EmployeeMapper employeeMapper=session.getMapper(EmployeeMapper.class);
       List<Map<String,Object>> Wbh=employeeMapper.sect("%李%");
        System.out.println(Wbh);
        // 6、关闭SqlSession
        session.close();
        // 7、关闭流
        is.close();
    }
    @Test
    public void QueryByname() throws Exception{
        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis.config.xml");
        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        // 3、用SqlSessionFactory工厂去创建SqlSession
        SqlSession session = factory.openSession();
        EmployeeMapper employeeMapper=session.getMapper(EmployeeMapper.class);
        Map<Integer,Employee> Wbh=employeeMapper.QueryByname("%李%");
        System.out.println(Wbh);
        // 6、关闭SqlSession
        session.close();
        // 7、关闭流
        is.close();
    }
    @Test
    public void selectbyid() throws Exception{
        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis.config.xml");
        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        // 3、用SqlSessionFactory工厂去创建SqlSession
        SqlSession session = factory.openSession();
        EmployeeMapper employeeMapper=session.getMapper(EmployeeMapper.class);
        Employee selectidall=employeeMapper.selectbyid(14);
        System.out.println(selectidall);
        // 6、关闭SqlSession
        session.close();
        // 7、关闭流
        is.close();
    }
}
