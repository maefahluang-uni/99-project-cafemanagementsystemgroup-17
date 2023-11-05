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
