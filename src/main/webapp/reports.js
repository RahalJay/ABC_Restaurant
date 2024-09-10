function addRow(tableId) {
    const table = document.getElementById(tableId).getElementsByTagName('tbody')[0];
    const newRow = table.insertRow();

    if (tableId === 'daily-sales-table') {
        newRow.innerHTML = `
            <td><input type="date" placeholder="Date"></td>
            <td><input type="text" placeholder="Item Sold"></td>
            <td><input type="number" placeholder="Quantity"></td>
            <td><input type="text" placeholder="Total Sales"></td>
            <td>
                <button onclick="saveRow(this)">Save</button>
                <button onclick="deleteRow(this)">Delete</button>
            </td>`;
    } else if (tableId === 'monthly-sales-table') {
        newRow.innerHTML = `
            <td><input type="month" placeholder="Month"></td>
            <td><input type="text" placeholder="Total Sales"></td>
            <td>
                <button onclick="saveRow(this)">Save</button>
                <button onclick="deleteRow(this)">Delete</button>
            </td>`;
    } else if (tableId === 'customer-registration-table') {
        newRow.innerHTML = `
            <td><input type="text" id="customerid" placeholder="ID"></td>
            <td><input type="text" id="name" placeholder="Name"></td>
            <td><input type="email" id="email" placeholder="Email"></td>
            <td><input type="text" id="phone" placeholder="Phone Number"></td>
            <td><input type="text" id="address" placeholder="Address"></td>
            <td><input type="password" id="password" placeholder="Password"></td>
            <td>
                <button onclick="submitForm(this, 'customer-registration-table')">Save</button>
                <button onclick="deleteRow(this)">Delete</button>
            </td>`;
    } else if (tableId === 'staff-registration-table') {
        newRow.innerHTML = `
            <td><input type="text" id="name" placeholder="Name"></td>
            <td><input type="email" id="email" placeholder="Email"></td>
            <td><input type="text" id="phone" placeholder="Phone Number"></td>
            <td><input type="password" id="password" placeholder="Password"></td>
            <td><input type="text" id="jobrole" placeholder="Job Role"></td>
            <td>
                <button onclick="submitForm(this, 'staff-registration-table')">Save</button>
                <button onclick="deleteRow(this)">Delete</button>
            </td>`;
    }
}

function submitForm(button, tableId) {
    const row = button.parentNode.parentNode;
    const inputs = row.querySelectorAll('input');

    const formData = new URLSearchParams();
    inputs.forEach(input => {
        const id = input.id;
        const value = input.value;
        formData.append(id, value);
    });

    const url = tableId === 'customer-registration-table' ? '/abcrestaurant/customer' : '/abcrestaurant/staff';

    fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded',
        },
        body: formData.toString(),
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        return response.json();
    })
    .then(result => {
        console.log('Success:', result);
        saveRow(button); 
    })
    .catch(error => {
        console.error('Error:', error);
    });
}

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

function deleteRow(button) {
    const row = button.parentNode.parentNode;
    row.parentNode.removeChild(row);
}
