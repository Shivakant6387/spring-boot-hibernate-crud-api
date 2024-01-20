package com.example.shiva.repository;

import com.example.shiva.model.EmployeeDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Objects;

public interface EmployeeDetailRepository extends JpaRepository<EmployeeDetails, Long> {
    //named parameters
    //SELECT * FROM EMPLOYEE WHERE EID>=MIN AND EID<=MAX;
    @Query("from EmployeeDetails where id>=:min and id<=:max")
    List<EmployeeDetails> fetchEmployeeByIdRange(long min, long max);

    //positonal param
    @Query("FROM EmployeeDetails where id>=?1 and id<=?2")
    public List<EmployeeDetails> searchByEmpIdRange(long min, long max);

    @Query(value = "select*from emp where dept=:dept", nativeQuery = true)
    public List<EmployeeDetails> searchByEmpByDept(String dept);

    @Query("from EmployeeDetails where name in(:name,:name1,:name2)order by name desc")
    public List<EmployeeDetails> fetchEmpByName(String name, String name1, String name2);

    @Query(value = ("SELECT * FROM emp where name=:name"), nativeQuery = true)
    public List<EmployeeDetails> fetchEmpByName(String name);

    @Query(value = ("SELECT* FROM emp where id=:id"), nativeQuery = true)
    public List<EmployeeDetails> fetchEmpById(long id);

    @Query(value = ("SELECT* FROM emp WHERE salary=:salary"), nativeQuery = true)
    public List<EmployeeDetails> fetchEmpBySalary(double salary);

    @Query("SELECT  id,name,salary FROM EmployeeDetails where salary>=:salary and name in (:name,:name1,:name2)")
    public List<Object[]> fetchEmpBySalaryAndName(double salary, String name, String name1, String name2);

    @Query("SELECT id,name,salary from EmployeeDetails where salary<=:salary and name in(:name)")
    public List<Object[]>fetchEmpBySalaryAndName(double salary,String name);
    @Query("select name from EmployeeDetails where id>=:min  and id<=:max")
    public List<String>fetchEmpNameById(long min,long max);

    @Query("select e from EmployeeDetails e where name=:name")
    public EmployeeDetails fetchSingleRow(String name);
    @Query("select id,name,salary from EmployeeDetails where name=:name")
    public Object fetchEmpPartialDataByName(String name);
    @Query("SELECT max(salary)from EmployeeDetails")
    public double fetchMaxSalary();

    @Query("Select min(salary) from EmployeeDetails")
    public double fetchMinSalary();

    @Query("select max(salary),min(salary),avg(salary),count(*),sum(salary) from EmployeeDetails")

    public Object fetchAggregateData();

}
