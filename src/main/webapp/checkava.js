document.addEventListener('DOMContentLoaded', function() {
    const form = document.getElementById('availability-form');
    const resultDisplay = document.getElementById('result-display');
    const popup = document.getElementById('popup'); // Popup element
    const resetButton = form.querySelector('button[type="reset"]');

    // Event listener for form submission
    form.addEventListener('submit', function(event) {
        event.preventDefault(); // Prevent the form from submitting the usual way
        
        // Show the popup message
        popup.style.display = 'block';

        // Hide the popup after 3 seconds
        setTimeout(function() {
            popup.style.display = 'none';
        }, 3000);

        // Call the function to check availability
        checkAvailability();
    });

    // Event listener for form reset
    resetButton.addEventListener('click', function() {
        resultDisplay.style.display = 'none'; // Hide results when the form is reset
    });

    function checkAvailability() {
        // Collect form data
        const serviceType = document.getElementById('service-type').value;
        const date = document.getElementById('reservation-date').value;
        const timeSlot = document.getElementById('reservation-time').value;
        const availableSlots = document.getElementById('available-slots').value;

        // URL to the servlet handling the availability check
        const url = '/abcrestaurant/availability'; // Ensure this URL matches your servlet's mapping

        // Create form data
        const formData = new URLSearchParams();
        formData.append('serviceType', serviceType);
        formData.append('date', date);
        formData.append('timeSlot', timeSlot);
        formData.append('availableSlots', availableSlots);

        // Make a POST request to the servlet
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
            // Process and display the result
            displayResult(result);
        })
        .catch(error => {
            console.error('Error:', error);
        });
    }

    function displayResult(result) {
        // Display the result in a formatted way
        let resultMessage = `Service Type: ${result.serviceType}\nDate: ${result.date}\nTime Slot: ${result.timeSlot}\nAvailable Slots: ${result.availableSlots}`;
        
        // Display the result
        resultDisplay.textContent = resultMessage;
        resultDisplay.style.display = 'block';
    }
});
