package com.example.casestudy_furama.controller;

import com.example.casestudy_furama.model.*;
import com.example.casestudy_furama.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FuramaController {
    @Autowired
    ICustomerService iCustomerService;
    @Autowired
    ICustomerTypeService iCustomerTypeService;
    @Autowired
    IEmployeeService iEmployeeService;
    @Autowired
    IDivisionService iDivisionService;
    @Autowired
    IEducation_degreeService iEducation_degreeService;
    @Autowired
    IPositionService iPositionService;
    @Autowired
    IContractService iContractService;
    @Autowired
    IFacilityService facilityService;
    @Autowired
    IFacilityTypeService iFacilityTypeService;
    @Autowired
    IRentTypeService iRentTypeService;
    List<User> usersLogin = new ArrayList<>();
    List<User> usersRegister = new ArrayList<>();
    @GetMapping("/")
    public String interfaceLogin(Model model) {

       User user = new User();
       User user1 = new User("admin","123");
       usersRegister.add(user1);
       model.addAttribute("user",user);
       return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") User user, RedirectAttributes redirectAttributes) {

        for (User user1 : usersRegister) {
            if (user1.getUserName().equals(user.getUserName())&&user1.getPassword().equals(user.getPassword())) {
                redirectAttributes.addFlashAttribute("loginSuccess", true);
                usersLogin.add(user1);
                return "redirect:/home";
            }
        }

        // Login failed (username not found)
        redirectAttributes.addFlashAttribute("loginError", true);
        return "redirect:/";
    }
//    @GetMapping("/logout")
//    public String logout() {
//        usersLogin = new ArrayList<>();
//        return "login";
//    }

    @GetMapping("/home")
    public String homePage(Model model,@RequestParam(value = "nameservice",defaultValue = "")String nameService) {
        if(usersLogin == null && usersLogin.isEmpty()){
            return "login";
        }
        if (nameService.equals("")) {
            model.addAttribute("listSer", iFacilityTypeService.facilityTypeList());
        }else {
            Facility facility = facilityService.findFacilityByName(nameService);
            model.addAttribute("listSer",facility);
        }
        return "homepage";
    }
    //customer controller
    @GetMapping("customer")
    public String homePageCustomer(Model model, @RequestParam(value = "namecustomer", defaultValue = "") String nameCustomer,@RequestParam(value = "dayOfBirth",defaultValue = "") String dateOfBirth,
                                   @RequestParam(value = "phonenumber",defaultValue = "") String phoneNumber,
                                   @RequestParam(defaultValue = "0") Integer page) {
        int size = 3;
       Page<Customer> customers = iCustomerService.findAllCustomerWithPage(nameCustomer,dateOfBirth,phoneNumber, PageRequest.of(page, size));
        model.addAttribute("listCus",customers );
        return "homepagecustomer";
    }

    @GetMapping("booking")
    public String booking(@RequestParam(value = "id")Long nameOfFacility,Model model){
        Facility facility = facilityService.findFacilityByID(nameOfFacility);
        model.addAttribute("contract", new Contract());
        model.addAttribute("listCus", iCustomerService.listAllCustomers());
        model.addAttribute("listEm",iEmployeeService.employeList());
        model.addAttribute("listSer", facility);
        return "make_contract";
    }
    @GetMapping("listoffacility")
    public String listService(@RequestParam(defaultValue = "") String idFacilityType,Model model,@RequestParam(value = "page",defaultValue = "0")Integer page,@RequestParam(defaultValue = "") String facilityName ){
        Page<Facility> facilityListByFacilityType = facilityService.findAllFacilityById_FacilityType(idFacilityType,facilityName,PageRequest.of(page,3));
        model.addAttribute("listOfFacilityByType",facilityListByFacilityType);
        return "list_of_facilitytype";
    }
    @GetMapping("/create_customer")
    public String createClient1(Model model) {
        model.addAttribute("cus", new Customer());
        model.addAttribute("listType", iCustomerTypeService.findAllCustomerType());
        return "createclient";
    }

    @PostMapping("docreateclient")
    public String saveCustomer(@Valid @ModelAttribute(value = "cus") Customer cus, BindingResult result, RedirectAttributes redirectAttributes, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("listType", iCustomerTypeService.findAllCustomerType());
            return "createclient";
        }
        iCustomerService.saveCustomer(cus);
        String mess = "Lưu Thành Công";
        redirectAttributes.addFlashAttribute("sms", mess);
        return "redirect:customer";
    }

    @GetMapping("delete_customer")
    public String deleteCustomer(String namecustomer, RedirectAttributes redirectAttributes) {
        Customer customer = iCustomerService.findCustomerByName(namecustomer);
        iCustomerService.deleteCustomer(customer);
        String mess = "Xóa Thành Công";
        redirectAttributes.addFlashAttribute("sms", mess);
        return "redirect:customer";
    }

    @GetMapping("edit_customer")
    public String editCustomer(String namecustomer, Model model) {
        Customer customer = iCustomerService.findCustomerByName(namecustomer);
        model.addAttribute("cus", customer);
        model.addAttribute("listType", iCustomerTypeService.findAllCustomerType());
        return "createclient";
    }
    //employee controller
    @GetMapping("/employee")
    public String homePageEmployee(Model model, @RequestParam(value = "nameemployee", defaultValue = "") String nameEmployee,
                                   @RequestParam(defaultValue = "0") Integer page) {
        int size = 3;
        model.addAttribute("listEm", iEmployeeService.findAllEmployeesWithPage(nameEmployee, PageRequest.of(page, size)));
        return "homepageemployee";
    }

    @GetMapping("create_employee")
    public String createEmployee(Model model) {
        model.addAttribute("listDiv", iDivisionService.divisionList());
        model.addAttribute("listEdu", iEducation_degreeService.education_degreList());
        model.addAttribute("listPos", iPositionService.positionList());
        model.addAttribute("employee", new Employee());
        return "createemployee";
    }

    @PostMapping("docreateemployee")
    public String doCreateEmployee(@Valid Employee employee, BindingResult result, RedirectAttributes redirectAttributes, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("listDiv", iDivisionService.divisionList());
            model.addAttribute("listEdu", iEducation_degreeService.education_degreList());
            model.addAttribute("listPos", iPositionService.positionList());
            return "createemployee";
        }
        iEmployeeService.saveEmployee(employee);
        String mess = "Lưu Thành Công";
        redirectAttributes.addFlashAttribute("sms", mess);
        return "redirect:/employee";

    }

    @GetMapping("delete_employee")
    public String deleteEmployee(@RequestParam(value = "nameemployee") String nameEmployee, RedirectAttributes redirectAttributes) {
        Employee employe = iEmployeeService.findEmployeeByName(nameEmployee);
        iEmployeeService.deleteEmployee(employe);
        String mess = "Xóa Thành Công";
        redirectAttributes.addFlashAttribute("sms", mess);
        return "redirect:/employee";

    }

    @GetMapping("edit_employee")
    public String editEmployee(@RequestParam(value = "nameemployee") String nameEmployee, Model model) {
        Employee employe = iEmployeeService.findEmployeeByName(nameEmployee);
        model.addAttribute("employee", employe);
        model.addAttribute("listDiv", iDivisionService.divisionList());
        model.addAttribute("listEdu", iEducation_degreeService.education_degreList());
        model.addAttribute("listPos", iPositionService.positionList());
        return "createemployee";
    }
    //contract controller
    @GetMapping("/contract")
    public String homePageContract(@RequestParam(value = "namecustomer", defaultValue = "") String nameCustomer, Model model, @RequestParam(value = "page", defaultValue = "0") Integer page) {
        int size = 3;
        model.addAttribute("listcontract", iContractService.contractWithPage(nameCustomer, PageRequest.of(page, size)));
        return "homepagecontract";
    }


    @PostMapping("/make_contract")
    public String makeContract(@Valid Contract contract, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("listCus", iCustomerService.listAllCustomers());
            model.addAttribute("listEm", iEmployeeService.employeList());
            model.addAttribute("listSer", facilityService.listAllFacility());
            return "make_contract";
        }
        iContractService.saveContract(contract);
        String mess = "Lưu Thành Công";
        redirectAttributes.addFlashAttribute("sms", mess);
        return "redirect:/contract";
    }

    @GetMapping("delete_contract")
    public String deleteContract(Long id_contract, RedirectAttributes redirectAttributes) {
        Contract contract = iContractService.findContractById(id_contract);
        iContractService.deleteContract(contract);
        String mess = "Xóa Thành Công";
        redirectAttributes.addFlashAttribute("sms", mess);
        return "redirect:contract";
    }

    @GetMapping("edit_contract")
    public String editContract(Long id_contract, Model model) {
        Contract contract = iContractService.findContractById(id_contract);
        model.addAttribute("contract", contract);
        model.addAttribute("listCus", iCustomerService.listAllCustomers());
        model.addAttribute("listEm", iEmployeeService.employeList());
        model.addAttribute("listSer", facilityService.listAllFacility());
        return "make_contract";
    }
    //service controller
    @GetMapping("service")
    public String homePageService(@RequestParam(value = "nameservice", defaultValue = "") String nameOfFacility, @RequestParam(value = "page", defaultValue = "0") int page, Model model) {
        int size = 3;
        model.addAttribute("listSer", facilityService.findAllFacilityWithPage(nameOfFacility, PageRequest.of(page, size)));
        return "home_page_service";
    }

    @GetMapping("create_service")
    public String makeService(Model model) {
        model.addAttribute("ser", new Facility());
        model.addAttribute("listFacType", iFacilityTypeService.facilityTypeList());
        model.addAttribute("listRentType", iRentTypeService.rentTypeList());
        return "make_service";
    }

    @PostMapping("do_save_service")
    public String doMakeService(@Valid @ModelAttribute(value = "ser") Facility facility, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            model.addAttribute("listFacType", iFacilityTypeService.facilityTypeList());
            model.addAttribute("listRentType", iRentTypeService.rentTypeList());
            return "make_service";
        }
        facilityService.saveFacility(facility);
        String mess = "Lưu Thành Công";
        redirectAttributes.addFlashAttribute("sms", mess);
        return "redirect:/";
    }

    @GetMapping("delete_service")
    public String delete_service(String nameOfFacility, RedirectAttributes redirectAttributes) {
        Facility facility = facilityService.findFacilityByName(nameOfFacility);
        facilityService.deleteFacility(facility);
        String mess = "Xóa Thành Công";
        redirectAttributes.addFlashAttribute("sms", mess);
        return "redirect:/service";
    }

    @GetMapping("edit_service")
    public String edit_service(String nameOfFacility, Model model) {
        Facility facility = facilityService.findFacilityByName(nameOfFacility);
        model.addAttribute("ser", facility);
        model.addAttribute("listFacType", iFacilityTypeService.facilityTypeList());
        model.addAttribute("listRentType", iRentTypeService.rentTypeList());
        return "make_service";
    }
    //catch Exception
    @ExceptionHandler(Exception.class)
    public String catchAllEx(Exception e){
        return "403";
    }

}
