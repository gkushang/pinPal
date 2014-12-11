

jQuery(document).ready(function() {

        $(".continue-product").on('click',function() {


        var me = $(this);
        var description = $("#description").val();
        var manufacture_id = $("#manufacture-id").val();
        var item_id = $("#item-id").val();
        var sku_id = $("#sku-id").val();

             $.ajax({

                type: "POST",
                url: "/save-product/",
                data:{description:description,
                manufacture_id:manufacture_id,
                item_id:item_id,
                sku_id:sku_id}
                    }).done(function(data) {

                                                          });

            });
});


jQuery(document).ready(function() {

        $(".continue-offer").on('click',function() {

        var me = $(this);
        var retail_price = $("#r-price-id").val();
        var discount_percentage = $("#d-perc-id").val();
        var discount_price = $("#d-price-id").val();
        var start_date = $("#s-date-id").val();
        var end_date = $("#e-date-id").val();
             $.ajax({

                type: "POST",
                url: "/save-offer/"
                data:{retail_price:retail_price,
                discount_percentage:discount_percentage,
                discount_price:discount_price,
                start_date:start_date,
                end_date:end_date}
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