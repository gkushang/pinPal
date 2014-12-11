

jQuery(document).ready(function() {

        $(".continue-product").on('click',function() {


        var me = $(this);
        var description = $("#description").val();
        var manufacture_id = $("#manufacture-id").val();
//        var item-id = $("#item-id").val();
//        var sku-id = $("#sku-id").val();

             $.ajax({

                type: "POST",
                url: "/save-product/",
                data:{description:description,
                manufacture_id:manufacture_id}
//                       item-id:item-id,
//                       sku-id:sku-id}
                    }).done(function(data) {

                                                          });

            });
});


jQuery(document).ready(function() {

        $(".continue-offer").on('click',function() {

        var me = $(this);

             $.ajax({

                type: "POST",
                url: "/save-offer/"

                    }).done(function(data) {



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