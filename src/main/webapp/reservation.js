document.addEventListener('DOMContentLoaded', function () {
    const reservationForm = document.getElementById('reservation');
    const popup = document.getElementById('popup');
    const closePopupButton = document.getElementById('close-popup');
    const cancelButton = document.getElementById('cancel');
    const reservationIDField = document.getElementById('id');

    // Function to generate a three-digit Reservation ID
    function generateReservationID() {
        return Math.floor(100 + Math.random() * 900).toString(); // Generate a random three-digit number
    }

    // Set the generated Reservation ID when the page loads and make it read-only
    reservationIDField.value = generateReservationID();
    reservationIDField.readOnly = true; // Prevent user from editing the ID

    // Show the popup when the form is submitted
    reservationForm.addEventListener('submit', function (event) {
        event.preventDefault(); // Prevents the default form submission

        // Display popup message
        popup.style.display = 'block';

        setTimeout(function () {
            popup.style.display = 'none';
        }, 3000);

        // Send the form data to the servlet
        sendPostRequest();
    });

    // Close the popup and reset the form when the close button is clicked
    closePopupButton.addEventListener('click', function () {
        popup.style.display = 'none'; // Hides the popup
        reservationForm.reset(); // Resets the form fields
        reservationIDField.value = generateReservationID(); // Regenerate ID after reset
        reservationIDField.readOnly = true; // Ensure the ID remains read-only
    });

    // Redirect to the home page when the cancel button is clicked
    cancelButton.addEventListener('click', function () {
        window.location.href = 'home.html'; // Redirects to the home page
    });

    function sendPostRequest() {
        const url = '/abcresturant/reservation'; // Ensure this URL matches your servlet's mapping

        // Collect form data
        const formData = new URLSearchParams();
        formData.append('id', reservationIDField.value);
        formData.append('customerId', document.getElementById('customer-id').value);
        formData.append('reservationDate', document.getElementById('reservation-date').value);
        formData.append('reservationTime', document.getElementById('reservation-time').value);
        formData.append('reservationType', document.getElementById('reservation-type').value);

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
});
