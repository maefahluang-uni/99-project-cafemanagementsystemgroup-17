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
