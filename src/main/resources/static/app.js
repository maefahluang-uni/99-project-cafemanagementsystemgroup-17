// Initialize the item count
let itemCount = 0;

// Add an event listener to all "Select" buttons
const selectButtons = document.querySelectorAll(".select-button");

selectButtons.forEach(button => {
    button.addEventListener("click", () => {
        itemCount++;
        updateItemCountDisplay();
    });
});

// Function to update the item count display
function updateItemCountDisplay() {
    const itemCountDisplay = document.getElementById("item-count");
    itemCountDisplay.textContent = itemCount;
}
//new add for show detail //
    // Function to display selected items in the modal
function showSelectedItems() {
    const selectedItemsList = document.getElementById("selectedItemsList");
    selectedItemsList.innerHTML = "";

    selectedItems.forEach(item => {
        const listItem = document.createElement("li");
        listItem.textContent = item;
        selectedItemsList.appendChild(listItem);
    });

    $('#selectedItemsModal').modal('show');
}