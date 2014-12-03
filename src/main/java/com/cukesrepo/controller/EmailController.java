package com.cukesrepo.controller;


import com.cukesrepo.exceptions.EmailException;
import com.cukesrepo.exceptions.FeatureNotFoundException;
import com.cukesrepo.exceptions.ProjectNotFoundException;
import com.cukesrepo.service.email.EmailService;
import com.cukesrepo.service.feature.FeatureService;
import com.cukesrepo.service.project.ProjectService;
import org.apache.commons.lang.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;


@Controller
public class EmailController {

    private final FeatureService _featureService;
    private final ProjectService _projectService;
    private final EmailService _emailService;


    @Autowired
    public EmailController
            (
                    FeatureService featureService,
                    ProjectService projectService,
                    EmailService emailService
            ) {

        Validate.notNull(featureService, "featureService cannot be null");
        Validate.notNull(projectService, "projectService cannot be null");
        Validate.notNull(emailService, "emailService cannot be null");

        _featureService = featureService;
        _projectService = projectService;
        _emailService = emailService;

    }

    @RequestMapping(value = {"/{featureId}/{projectId}/email/review-request"}, method = RequestMethod.GET)
    @ResponseBody
    public void sendReviewRequest(@PathVariable String featureId, @PathVariable String projectId) throws IOException {


        try {

            _emailService.sendReviewRequest
                    (
                            _projectService.getProjectById(projectId),
                            _featureService.getFeatureId(projectId, featureId).get()
                    );

            _featureService.setEmailSent(projectId, featureId);

        } catch (FeatureNotFoundException e) {
            throw new RuntimeException("Feture not found. Replace this with rendering error page: ", e);

        } catch (ProjectNotFoundException e) {
            throw new RuntimeException("Project not found. Replace this with rendering error page: ", e);

        } catch (EmailException e) {
            throw new RuntimeException("Email sent failed. Replace this with rendering error page: ", e);

        }
    }


}
