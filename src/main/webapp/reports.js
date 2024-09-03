// Add a new row to the table
function addRow(tableId) {
    const table = document.getElementById(tableId).getElementsByTagName('tbody')[0];
    const newRow = table.insertRow();

    if (tableId === 'daily-sales-table') {
        newRow.innerHTML = `
            <td><input type="date" value="2024-08-22"></td>
            <td><input type="text" placeholder="Item Sold"></td>
            <td><input type="number" placeholder="Quantity"></td>
            <td><input type="text" placeholder="Total Sales"></td>
            <td>
                <button onclick="saveRow(this)">Save</button>
                <button onclick="deleteRow(this)">Delete</button>
            </td>`;
    } else if (tableId === 'monthly-sales-table') {
        newRow.innerHTML = `
            <td><input type="month" value="2024-08"></td>
            <td><input type="text" placeholder="Total Sales"></td>
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
