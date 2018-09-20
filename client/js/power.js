/*====================================
=            GLOBAL ITEMS            =
====================================*/
var $theLastClickedPopupTarget = false;


/*======================================
=            WHEN DOM READY            =
======================================*/
$(function() {

    // Form Submission
    $('form').submit(function() {

        $this = $(this);

        // Get ALL the Data
        var email = $this.find('input[type="email"]').val();
        var phone = $this.find('input[type="phone"]').val();
        var formData = {};
        $this.find('input, textarea, select').each(function() {
            formData[$(this).attr('name')] = $(this).val();
        });

        // Send all the data somewhere (ajax)
        // REMEMBER: AJAX requires HTTP in the URL for security
        $.ajax({
            url: 'contact.json',
            type: 'GET', // POST
            data: formData,
            success: function(result) {

                // Result is the data we retrieved in return
                if (result.is_success) {
                    alert(result.message);
                } else {
                    alert('You failed me!!!!!!!!');
                }

            }
        });


        return false;
    });



});



/*=========================================
=            WHEN WINDOW LOADS            =
=========================================*/
$(window).on('load', function() {

});


/*=========================================
=            WHEN USER RESIZES            =
=========================================*/
$(window).resize(function() {
    placeResizeNumbers();

    // Popup is open, handle for resize
    if ($theLastClickedPopupTarget) {
        var theLastClickedPopupTargetHeight = $theLastClickedPopupTarget.find('.guts').outerHeight();
        var windowHeight = $(window).height();

        if (theLastClickedPopupTargetHeight >= windowHeight) {
            $theLastClickedPopupTarget.addClass('not-enough-space-panic-mode');
        } else {
            $theLastClickedPopupTarget.removeClass('not-enough-space-panic-mode');
        }
    }
});


/*=========================================
=            WHEN USER SCROLLS            =
=========================================*/
$(window).scroll(function() {
    placeScrollPosition();
    lightsOffLogic();
});

