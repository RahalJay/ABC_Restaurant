document.addEventListener('DOMContentLoaded', function() {
    const form = document.getElementById('availability-form');
    const resultDisplay = document.getElementById('result-display');
    const resetButton = form.querySelector('button[type="reset"]');

    // Event listener for form submission
    form.addEventListener('submit', function(event) {
        event.preventDefault(); // Prevent the form from submitting the usual way
        checkAvailability();
    });

    // Event listener for form reset
    resetButton.addEventListener('click', function() {
        resultDisplay.style.display = 'none'; // Hide results when the form is reset
    });

    function checkAvailability() {
        // Sample logic for checking availability
        const serviceType = document.getElementById('service-type').value;
        const date = document.getElementById('reservation-date').value;
        const time = document.getElementById('reservation-time').value;
        const guests = document.getElementById('guest-count').value;

        let resultMessage = `Service Type: ${serviceType}\nDate: ${date}\nTime: ${time}\nGuests: ${guests}\n\nAvailability confirmed!`;

        // Display the result
        resultDisplay.textContent = resultMessage;
        resultDisplay.style.display = 'block';
    }
});
