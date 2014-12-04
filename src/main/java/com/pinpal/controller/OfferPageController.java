package com.pinpal.controller;

import java.io.IOException;

import com.pinpal.page.OfferPage;
import com.pinpal.service.project.ProjectService;
import org.rendersnake.HtmlCanvas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class OfferPageController
{

    private final ProjectService _projectService;

    @Autowired
    public OfferPageController
            (
                    ProjectService projectService
            )
    {

        _projectService = projectService;
    }

    @RequestMapping(value = {"/offer/"})
    @ResponseBody
    public void renderProjectsPage
            (
                    HtmlCanvas html
            ) throws IOException
    {
        html.render(new OfferPage(_projectService));
    }

    @RequestMapping(value = {"/upload-product/"}, method = RequestMethod.POST)
    @ResponseBody
    protected void uploadPhoto
            (

            )
    {


    }
}

