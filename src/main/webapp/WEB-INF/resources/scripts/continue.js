

jQuery(document).ready(function() {

        $(".continue-product").on('click',function() {


        var me = $(this);

             $.ajax({

                type: "POST",
                url: "/upload-photo/"

                    }).done(function(data) {

                    top.location.href = "/product/";

                                                          });

            });
});


jQuery(document).ready(function() {

        $(".continue-offer").on('click',function() {

        var me = $(this);

             $.ajax({

                type: "POST",
                url: "/upload-product/"

                    }).done(function(data) {

                    top.location.href = "/offer/";

                                                          });

            });
});


jQuery(document).ready(function() {

        $(".continue-pinit").on('click',function() {


        var me = $(this);

             $.ajax({

                type: "POST",
                url: "/pin-it-done/"

                    }).done(function(data) {

                    top.location.href = "/pin-it/";

                                                          });

            });
});