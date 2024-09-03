document.addEventListener('DOMContentLoaded', function () {
    const form = document.getElementById('query-form');

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

    form.addEventListener('submit', function (event) {
        event.preventDefault(); // Prevent form from submitting normally
        handleFormSubmission();
    });
});
