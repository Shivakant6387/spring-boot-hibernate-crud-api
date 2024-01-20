package com.example.shiva.runner;

import com.example.shiva.model.EmployeeDetails;
import com.example.shiva.repository.EmployeeDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestRunner implements CommandLineRunner {
    @Autowired
    private EmployeeDetailRepository repository;

    @Override
    public void run(String... args) throws Exception {
//        repository.save(new EmployeeDetails(16,"B","QA",2000222.0));
//        repository.save(new EmployeeDetails(2,"A","QB",1200.0));
//        repository.save(new EmployeeDetails(3,"A","QC",2100.0));
//        repository.save(new EmployeeDetails(4,"A","QD",2300.0));
//        repository.save(new EmployeeDetails(5,"A","QE",2040.0));
//        repository.save(new EmployeeDetails(6,"A","QF",2005.0));
//        repository.save(new EmployeeDetails(7,"A","QG",20078.0));
//        repository.save(new EmployeeDetails(8,"A","QH",20087.0));
//        repository.save(new EmployeeDetails(9,"A","QI",20023.0));
//        repository.save(new EmployeeDetails(10,"A","QJ",20022.0));
//        repository.save(new EmployeeDetails(11,"A","QK",200.0));
//        repository.save(new EmployeeDetails(12,"A","QL",200121.0));
//        repository.save(new EmployeeDetails(13,"A","QM",2002345.0));

//        repository.findAll().forEach(System.out::println);


//        repository.fetchEmployeeByIdRange(1,4).forEach(System.out::println);
//        repository.searchByEmpIdRange(1,7).forEach(System.out::println);
        repository.searchByEmpByDept("QA").forEach(System.out::println);
//        repository.fetchEmpByName("A","B","C").forEach(System.out::println);
//        repository.fetchEmpByName("A").forEach(System.out::println);
//        repository.fetchEmpById(5).forEach(System.out::println);
//        repository.fetchEmpBySalary(200.0).forEach(System.out::println);
//        repository.fetchEmpBySalaryAndName(2000.0,"A","A","A").stream().map(objects -> objects[0]+","+objects[1]+","+objects[2]).forEach(System.out::println);
//        repository.fetchEmpBySalaryAndName(2000.0, "A").stream().map(objects -> objects[0]+","+objects[1]+","+objects[2]).forEach(System.out::println);
//        repository.fetchEmpNameById(2,9).forEach(System.out::println);

//        System.out.println(repository.fetchSingleRow("B"));
//        Object[] res= (Object[]) repository.fetchEmpPartialDataByName("B");
//        for (Object obj:res){
//            System.out.println(obj);
//        }

//        System.out.println(repository.fetchMaxSalary());
//        System.out.println(repository.fetchMinSalary());
//        Object[] res= (Object[]) repository.fetchAggregateData();
//        System.out.println("Max salary "+res[0]);
//        System.out.println("Min salary "+res[1]);
//        System.out.println("AVG salary "+res[2]);
//        System.out.println("Total rows  "+res[3]);
//        System.out.println("Sum of salary "+res[4]);

    }
}
