package admin.demo.service;

import admin.demo.model.Department;
import admin.demo.model.dto.AdminDataCard;
import admin.demo.model.dto.UserCount;
import admin.demo.repository.AccountRepository;
import admin.demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class DashboardService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private AccountRepository accountRepository;

    //Admin Data Card Details
    public List<AdminDataCard> getAdminCardDetails() {
        List<AdminDataCard> adminDataCardList = new ArrayList<>();

        //Number of Departments
        AdminDataCard departmentCount = new AdminDataCard(); //make an instance to store department count
        Integer deptCount = departmentRepository.getDepartmentsCount();
        departmentCount.setName("Departments");
        departmentCount.setValue(deptCount.toString());

        adminDataCardList.add(departmentCount); //push the instance to arrayList

        //Number of Registered Users
        AdminDataCard registeredUserCount = new AdminDataCard(); //make an instance to store registered user count
        Integer regUserCount = accountRepository.getRegisteredUserCount();
        registeredUserCount.setName("Registered Users");
        registeredUserCount.setValue(regUserCount.toString());

        adminDataCardList.add(registeredUserCount);

        //Number of user roles
        AdminDataCard userRoleCount = new AdminDataCard(); //make an instance to store user role count
        Integer userRCount = accountRepository.getUserRoleCount();
        userRoleCount.setName("User Roles");
        userRoleCount.setValue(userRCount.toString());

        adminDataCardList.add(userRoleCount);

        return adminDataCardList;

    }

    public ArrayList<Integer> getRegisteredUsers() {
        ArrayList<LocalDate> regDates = (ArrayList<LocalDate>) accountRepository.getRegisteredDates();
        ArrayList<Integer> months =  new ArrayList<>(); //for store months
        ArrayList<Integer> monthsCount = new ArrayList<>(); //for store the month count
        for(int i =0; i<regDates.size(); i++){
            int month = regDates.get(i).getMonthValue();
            months.add(month);
        }
        int countJan = Collections.frequency(months,1);
        monthsCount.add(countJan);
        int countFeb= Collections.frequency(months,2);
        monthsCount.add(countFeb);
        int countMarch= Collections.frequency(months,3);
        monthsCount.add(countMarch);
        int countApril= Collections.frequency(months,4);
        monthsCount.add(countApril);
        int countMay= Collections.frequency(months,5);
        monthsCount.add(countMay);
        int countJune= Collections.frequency(months,6);
        monthsCount.add(countJune);
        int countJuly= Collections.frequency(months,7);
        monthsCount.add(countJuly);
        int countAugust= Collections.frequency(months,8);
        monthsCount.add(countAugust);
        int countSep= Collections.frequency(months,9);
        monthsCount.add(countSep);
        int countOct= Collections.frequency(months,10);
        monthsCount.add(countOct);
        int countNov= Collections.frequency(months,11);
        monthsCount.add(countNov);
        int countDec= Collections.frequency(months,12);
        monthsCount.add(countDec);


        return monthsCount;
    }

    public List<UserCount> getUserCounts() {
        List<UserCount> userCount = new ArrayList<>();

        List<Department> departmentList = departmentRepository.findAll();

        for(int i=0; i<departmentList.size(); i++){
            Integer deptUserCount = accountRepository.getUserCount(departmentList.get(i).getName().toLowerCase(Locale.ROOT));
            UserCount countObject = new UserCount();
            countObject.setName(departmentList.get(i).getName());
            countObject.setValue(deptUserCount);

            userCount.add(countObject);
        }
        return userCount;

    }
}
