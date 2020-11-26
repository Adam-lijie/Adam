package Mapper;

import cn.bdqn.doman.Employee;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {
    List<Employee> list();
    void add(Employee em);
    void del(Integer id);
    void up(Employee em);
    List<Employee> li(String empName);
    Employee byidandname(Integer id,String name);
    Employee selectbyIdname(Map<String,Object> Rtf);
    Employee selectbyidSu(List<Integer> ids);
    Employee selectbysz(Integer[] sel);
    List<Map<String,Object>> sect(String name);
    @MapKey("id")
    Map<Integer,Employee> QueryByname(String empname);
    Employee selectbyid(Integer id);



}
