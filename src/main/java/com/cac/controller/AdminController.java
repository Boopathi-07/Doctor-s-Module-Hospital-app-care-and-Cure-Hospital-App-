package com.cac.controller;

import com.cac.model.Doctor; // Ensure this class exists in your project
import com.cac.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class AdminController {

    @Autowired
    private DoctorService doctorService;
    // Serve the admin add doctor page
    @GetMapping("/")
    public String showAddDoctorPage(Model model) {
        model.addAttribute("doctor", new Doctor()); // Add an empty Doctor object to the model
        return "admin-add-doctor"; // This maps to admin-add-doctor.html in src/main/resources/templates/
    }

    @GetMapping("/showDoctors")
    public String showDoctors(Model model) {
        List<Doctor> doctors = doctorService.getAllDoctors(); // Fetch all doctors from the service

        // Filter doctors whose status is active (true)
        List<Doctor> activeDoctors = doctors.stream()
                .filter(doctor -> doctor.isStatus()) // Assuming status is boolean
                .collect(Collectors.toList());

        model.addAttribute("doctors", activeDoctors); // Pass only active doctors to the model
        return "show-doctors"; // This maps to show-doctors.html in src/main/resources/templates/
    }
    @GetMapping("/disableDoctor/{doctorId}")
    public String disableDoctor(@PathVariable int doctorId, Model model) {
        // Get the doctor by ID
        Doctor doctor = doctorService.getDoctorById(doctorId);

        // If doctor exists, disable them
        if (doctor != null) {
            doctor.setStatus(false); // Set the status to inactive
            doctorService.saveDoctor(doctor); // Save the updated doctor back to the database
        }

        // After disabling, redirect to the list of active doctors
        return "redirect:/showDoctors";
    }
    @PostMapping("/addDoctor")
    public String addDoctor(@ModelAttribute Doctor doctor, RedirectAttributes redirectAttributes) {
        // Save doctor details to the database
        doctorService.addDoctor(doctor);

        // Add success message to be displayed on the homepage
        redirectAttributes.addFlashAttribute("message", "Doctor added successfully!");

        // Redirect to the homepage
        return "redirect:/";
    }


}
