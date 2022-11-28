
package com.apress.demo.springblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.nio.file.Files;

/**
 * @author Siva
 */
@Controller
public class FileUploadController {
    private static final String UPLOADS_DIR = "D:/uploads/";

    @GetMapping("/fileUpload")
    public String home(Model model) {
        return "fileUpload";
    }

    @PostMapping("/uploadMyFile")
    public String handleFileUpload(@RequestParam("myFile") MultipartFile file,
                                   RedirectAttributes redirectAtttributes) {
        if (!file.isEmpty()) {
            String name = file.getOriginalFilename();
            try {
                byte[] bytes = file.getBytes();
                File uploadingDir = new File(UPLOADS_DIR);
                if (!uploadingDir.exists()) {
                    uploadingDir.mkdirs();
                }
                Files.write(new File(UPLOADS_DIR + name).toPath(), bytes);
                redirectAtttributes.addFlashAttribute("msg", "File " + name + " uploaded successfully");
            } catch (Exception e) {
                redirectAtttributes.addFlashAttribute("msg", "Failed to upload file" + name + ". Cause: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return "redirect:/fileUpload";
    }

}
