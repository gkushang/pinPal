jQuery(document).ready(function() {

        $("input[id^='add-comment']").on('click',function() {

        var me = $(this);

        var comments = "";

        var scenario_number=me.attr('content');

        var project_id=$('#project-id').val();

        var feature_id=$('#feature-id').val();

        if(!$('#comments' + scenario_number).is(':visible'))
        {
                $('#comments' + scenario_number).val('');
                $('#comments' + scenario_number).attr('placeholder','Enter comment');
                $('#comments' + scenario_number).show();
                me.val("Submit Comment");

        }  else
        {
            comments = $("#comments" + scenario_number).val();

             $('#comments' + scenario_number).attr('content','');
                            $('#comments' + scenario_number).attr('placeholder','Enter comment');

            $("#comments" + scenario_number).hide();

            me.val("Comment");

        }
            $.ajax({

              type: "POST",
                url: "/" + project_id + "/"+ feature_id + "/"+ scenario_number + "/add-comment",
                  data:{comments: comments},
                }).done(function(data) {

                        if((comments.length > 0))
                        {
                           $('#comment-shows-here' + scenario_number).append
                           (
                           '<div class=comment-box-div> <p class=username-comment> ' + "" +'</p><textarea disabled class=display_p id=display-comment-p'+ scenario_number + '>' + comments + '</textarea></div>'
                           );
                        }

                    });

            });

});