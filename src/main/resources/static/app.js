function incrementCounter(button) {
    var form = button.closest("form");
    var counter = form.querySelector(".form-control");
    var quantityInput = form.querySelector("input[name='quantity']");

    var currentCounter = parseInt(counter.textContent);
    if (currentCounter < 10) {
        counter.textContent = currentCounter + 1;
        quantityInput.value = currentCounter + 1;
    }
}

function decrementCounter(button) {
    var form = button.closest("form");
    var counter = form.querySelector(".form-control");
    var quantityInput = form.querySelector("input[name='quantity']");

    var currentCounter = parseInt(counter.textContent);
    if (currentCounter > 1) {
        counter.textContent = currentCounter - 1;
        quantityInput.value = currentCounter - 1;
    }
}

//Show cart///
function showCartNotification() {
    var notification = document.getElementById('cart-notification');
    notification.style.display = 'block';
    setTimeout(function () {
        hideCartNotification();
    }, 3000); // Hide the notification after 3 seconds (adjust as needed)
}

function hideCartNotification() {
    var notification = document.getElementById('cart-notification');
    notification.style.display = 'none';
}
//button to open cart modal /
$(document).ready(function () {
    // Function to show/hide the cart button when the navigation bar is collapsed
    function toggleCartButton() {
        if ($(".navbar-collapse").hasClass("show")) {
            // Navigation bar is expanded
            $("#cartButton").addClass("d-none");
        } else {
            // Navigation bar is collapsed
            $("#cartButton").removeClass("d-none");
        }
    }

    // Initial toggle
    toggleCartButton();

    // Listen for Bootstrap collapse events on the navigation toggle
    $(".navbar-toggler").on("click", function () {
        toggleCartButton();
    });
});
///hide form ///
$(document).ready(function() {
    // Hide the form initially
    $('.product-form').hide();

    // Toggle form visibility when clicking on the picture
    $('.toggle-form').click(function() {
        $('.product-form').toggle();
    });
});
