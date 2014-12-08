$(function(){
    $('#btn-upload').click(function(e){
        e.preventDefault();
        $('#file').click();
        }
    );
});

function readURL(input) {
            if (input.files && input.files[0]) {
                var reader = new FileReader();


                reader.onload = function (e) {

                    $('#blah')
                        .attr('src', e.target.result)
                        .width(150)
                        .height(200);


                };

                reader.readAsDataURL(input.files[0]);

                             $.ajax({

                                type: "POST",
                                url: "/pin-it-done/",
                                data:{imgData: e.target.result}

                                    }).done(function(data) {


                                                                          });
            }
        }