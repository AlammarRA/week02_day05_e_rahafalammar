package com.example.week02_day05_e_rahafalammar;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/auth")
public class employeesController {


    ArrayList<Employees> employeeslist = new ArrayList<>();

    @GetMapping("/AllEmployees")
    public ResponseEntity getAllEmployees(){
        return ResponseEntity.status(200).body(employeeslist);
    }

    @PostMapping("/AddEmployee")
    public ResponseEntity addEmployee(@RequestBody @Valid Employees employee , Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        employeeslist.add(employee);
        return ResponseEntity.status(201).body( new ApiResponse("New user added !",201));
    }

    @PutMapping("/users/{index}")
    public ResponseEntity updateUser(@RequestBody @Valid Employees employees ,@PathVariable int index,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        if(index>=employeeslist.size()){
            return ResponseEntity.status(400).body(new ApiResponse("Invalid index",400));
        }
        employeeslist.set(index,employees);
        return ResponseEntity.status(201).body( new ApiResponse("User updated !",201));
    }

    @DeleteMapping("/users/{index}")
    public ResponseEntity deleteUser(@PathVariable int index){
        if(index>=employeeslist.size()){
            return ResponseEntity.status(400).body(new ApiResponse("Invalid index",400));
        }
        employeeslist.remove(index);
        return ResponseEntity.status(200).body(new ApiResponse("User deleted !",200));
    }

    @PutMapping("/applyForAnAnnualLeave")
    public ResponseEntity applyForAnAnnualLeave(@RequestBody @Valid Integer user,Errors errors){
        int index = 0;
        for (int i = 0; i < employeeslist.size(); i++) {
            if(employeeslist.get(i).getID().equals(user)){
                index = i;
                break;
            }
        }
        if(employeeslist.get(index).getOnLeave()==false)
            employeeslist.get(index).setOnLeave(true);
        else return ResponseEntity.status(400).body(new ApiResponse("Not Allowed",400));


        return ResponseEntity.status(201).body( new ApiResponse("You now onLeave!",201));
        }
}
