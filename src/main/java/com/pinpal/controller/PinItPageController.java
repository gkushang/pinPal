package com.pinpal.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;

import com.pinpal.page.PinItPage;
import com.pinpal.service.project.ProjectService;
import org.rendersnake.HtmlCanvas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class PinItPageController
{

    private final ProjectService _projectService;

    @Autowired
    public PinItPageController
            (
                    ProjectService projectService
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
                    HttpServletRequest request
            )
    {

        System.out.print("image data: ");
        System.out.print("image data: " + request.getParameter("imgData"));

    }
}

