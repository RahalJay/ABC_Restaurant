document.addEventListener('DOMContentLoaded', function () {
    const form = document.getElementById('query-form');

    form.addEventListener('submit', function (event) {
        event.preventDefault(); // Prevent form from submitting normally

        // Display a popup message
        const popup = document.getElementById('popup');
        popup.style.display = 'block';

        setTimeout(function () {
            popup.style.display = 'none';
        }, 3000);

        // Send the form data to the servlet
        sendPostRequest();
    });

    function sendPostRequest() {
        const url = '/abcresturant/query'; // Ensure this URL matches your servlet's mapping

        // Collect form data
        const formData = new URLSearchParams();
        formData.append('queryId', document.getElementById('query-id').value);
        formData.append('customerId', document.getElementById('customer-id').value);
        formData.append('queryType', document.getElementById('query-type').value);
        formData.append('queryDescription', document.getElementById('query-description').value);
        formData.append('status', 'Pending'); // Default status
        formData.append('response', ''); // No response initially

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

    function handleFormSubmission() {
        // Perform any form validation or data processing here if needed

        // Create a success message element
        const successMessage = document.createElement('div');
        successMessage.classList.add('success-message');
        successMessage.innerHTML = `
            <h3>Your Query was added successfully!</h3>
            <p>Thank you for reaching out. We will get back to you shortly.</p>
        `;

        // Append the success message to the body or a specific container
        document.body.appendChild(successMessage);

        // Optionally, remove the message after a few seconds
        setTimeout(() => {
            successMessage.remove();
        }, 5000);

        // Clear the form fields after submission
        form.reset();
    }
});
