// Manage Reservations
function addReservationRow() {
    const table = document.getElementById('reservations-table').getElementsByTagName('tbody')[0];
    const newRow = table.insertRow();
    
    newRow.innerHTML = `
        <td>1</td>
        <td><input type="text" placeholder="Customer Name"></td>
        <td><input type="date"></td>
        <td><input type="time"></td>
        <td>
            <button onclick="confirmReservation(this)">Confirm</button>
            <button onclick="deleteRow(this)">Delete</button>
        </td>`;
}

function confirmReservation(button) {
    const row = button.parentNode.parentNode;
    const inputs = row.querySelectorAll('input');

    inputs.forEach(input => {
        const value = input.value;
        const cell = input.parentNode;
        cell.innerHTML = value;
    });

    const actionCell = row.getElementsByTagName('td')[row.getElementsByTagName('td').length - 1];
    actionCell.innerHTML = `
        <button disabled>Confirmed</button>
        <button onclick="deleteRow(this)">Delete</button>`;
}

// Delete a row
function deleteRow(button) {
    const row = button.parentNode.parentNode;
    row.parentNode.removeChild(row);
}

// Handle form submission
document.getElementById('query-form').addEventListener('submit', function(event) {
    event.preventDefault();
    alert('Query response sent!');
    this.reset();
});

document.getElementById('payment-form').addEventListener('submit', function(event) {
    event.preventDefault();
    alert('Payment updated!');
    this.reset();
});

// Logout
function logout() {
    alert('Logging out...');
    window.location.href = 'homepage.html';  // Replace with the actual home page URL
}
