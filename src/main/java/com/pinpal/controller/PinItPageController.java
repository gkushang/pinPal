package com.pinpal.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.pinpal.page.PinItPage;
import com.pinpal.service.project.PinPalService;
import org.rendersnake.HtmlCanvas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class PinItPageController
{

    private final PinPalService _projectService;

    @Autowired
    public PinItPageController
            (
                    PinPalService projectService
            )
    {

        _projectService = projectService;
    }

    @RequestMapping(value = {"/pin-it/"})
    @ResponseBody
    public void renderProjectsPage
            (
                    HtmlCanvas html
            ) throws IOException
    {

        html.render(new PinItPage(_projectService));

    }

    @RequestMapping(value = {"/pin-it-done/"}, method = RequestMethod.POST)
    @ResponseBody
    protected void uploadPhoto
            (
                    HttpServletRequest request,
                    @RequestParam("file") MultipartFile file
            ) throws IOException, ServletException
    {

        if (!file.isEmpty())
        {
            byte[] bytes = file.getBytes();
            BufferedOutputStream stream =
                    new BufferedOutputStream(new FileOutputStream(new File("-uploaded")));
            stream.write(bytes);
            stream.close();
        }

        System.out.print("image data: " + request.getParameter("imgData"));
        System.out.print("image data: ");

    }
}

