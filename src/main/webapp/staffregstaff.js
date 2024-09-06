// staffreg.js

document.getElementById('registration-form').addEventListener('submit', function(event) {
    event.preventDefault();

    // Display popup message
    const popup = document.getElementById('popup');
    popup.style.display = 'block';

    // Hide the popup after 3 seconds
    setTimeout(function() {
        popup.style.display = 'none';
    }, 3000);

    // Send the form data to the servlet
    sendPostRequest();
});

function sendPostRequest() {
    const url = '/abcresturant/staff'; // Ensure this URL matches your servlet's mapping

    // Collect form data
    const formData = new URLSearchParams();
    formData.append('id', document.getElementById('id').value);
    formData.append('name', document.getElementById('name').value);
    formData.append('email', document.getElementById('email').value);
    formData.append('phone', document.getElementById('phone').value);
    formData.append('role', document.getElementById('role').value);
    formData.append('password', document.getElementById('password').value);

    fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded', // Sending data as form URL encoded
        },
        body: formData.toString(), // Convert form data to URL-encoded string
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        return response.json(); // Assuming the servlet returns a JSON response
    })
    .then(result => {
        console.log('Success:', result);
    })
    .catch(error => {
        console.error('Error:', error);
    });
}

// Cancel button redirects to admin manage page
document.getElementById('cancel').addEventListener('click', function() {
    window.location.href = 'adminmanage.html';
});
