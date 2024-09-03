// scripts.js

document.addEventListener('DOMContentLoaded', function() {
    const registrationForm = document.getElementById('registration-form');
    const popup = document.getElementById('popup');
    const cancelButton = document.getElementById('cancel'); 


    registrationForm.addEventListener('submit', function(event) {
        event.preventDefault();

        // Collect form data
        const formData = new FormData(registrationForm);

        // Make AJAX request to the servlet using fetch API
        fetch('registerCustomer', {
            method: 'POST',
            body: formData
        })
        .then(response => response.text())
        .then(data => {
            // Display popup message from the servlet response
            popup.innerHTML = data; 
            popup.style.display = 'block';

            // Hide the popup after 3 seconds
            setTimeout(function() {
                popup.style.display = 'none';
            }, 3000);
        })
        .catch(error => console.error('Error:', error));
    });

    // Function to cancel registration
    if (cancelButton) {
        cancelButton.addEventListener('click', function() {
            window.location.href = 'home.html'; 
        });
    }
});


