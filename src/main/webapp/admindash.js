// Add a new row to the table
function addRow(tableId) {
    const table = document.getElementById(tableId).getElementsByTagName('tbody')[0];
    const newRow = table.insertRow();

    if (tableId === 'reservations-table') {
        newRow.innerHTML = `
            <td><input type="text" placeholder="Reservation ID"></td>
            <td><input type="text" placeholder="Customer Name"></td>
            <td><input type="date"></td>
            <td><input type="time"></td>
            <td>
                <button onclick="saveRow(this)">Save</button>
                <button onclick="deleteRow(this)">Delete</button>
            </td>`;
    }
}

// Save the data from the input fields to the table cells
function saveRow(button) {
    const row = button.parentNode.parentNode;
    const inputs = row.querySelectorAll('input');

    inputs.forEach(input => {
        const value = input.value;
        const cell = input.parentNode;
        cell.innerHTML = value;
    });

    const actionCell = row.getElementsByTagName('td')[row.getElementsByTagName('td').length - 1];
    actionCell.innerHTML = `
        <button onclick="editRow(this)">Edit</button>
        <button onclick="deleteRow(this)">Delete</button>`;
}

// Edit an existing row
function editRow(button) {
    const row = button.parentNode.parentNode;
    const cells = row.getElementsByTagName('td');

    for (let i = 0; i < cells.length - 1; i++) {
        const value = cells[i].innerHTML;
        cells[i].innerHTML = `<input type="text" value="${value}">`;
    }

    const actionCell = cells[cells.length - 1];
    actionCell.innerHTML = `<button onclick="saveRow(this)">Save</button>
                            <button onclick="deleteRow(this)">Delete</button>`;
}

// Delete a row from the table
function deleteRow(button) {
    const row = button.parentNode.parentNode;
    row.parentNode.removeChild(row);
}

// Redirect to Reports HTML form
function generateDailySales() {
    window.location.href = "reports.html";
}

function generateMonthlySales() {
    // Additional code for generating monthly sales reports
}
