function incrementQuantity() {
    var quantityInput = document.getElementById("quantity");
    var quantityDisplay = document.getElementById("quantityDisplay");
    var currentQuantity = parseInt(quantityInput.value);
    if (currentQuantity < 10) {
        quantityInput.value = currentQuantity + 1;
        quantityDisplay.value = currentQuantity + 1;
    }
}

function decrementQuantity() {
    var quantityInput = document.getElementById("quantity");
    var quantityDisplay = document.getElementById("quantityDisplay");
    var currentQuantity = parseInt(quantityInput.value);
    if (currentQuantity > 1) {
        quantityInput.value = currentQuantity - 1;
        quantityDisplay.value = currentQuantity - 1;
    }
}
//notification///
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
