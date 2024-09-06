document.addEventListener('DOMContentLoaded', function () {
    // Get the confirm and cancel buttons
    const confirmBtn = document.querySelector('.submit-btn');
    const cancelBtn = document.querySelector('.cancel-btn');

    // Confirm payment button event
    confirmBtn.addEventListener('click', function () {
        // Collect payment data
        const paymentId = document.getElementById('payment-id').value;
        const customerId = document.getElementById('customer-id').value;
        const amount = document.getElementById('amount').value;
        const paymentMethod = document.getElementById('payment-method').value;
        const paymentDate = new Date().toISOString().split('T')[0]; // Format date as YYYY-MM-DD
        const status = 'Completed'; // Assuming status is 'Completed' for successful payments

        // Send payment data to the server
        sendPaymentRequest(paymentId, customerId, amount, paymentMethod, paymentDate, status);

        // Display success message
        alert('Payment Successful... Thank you.');
    });

    // Cancel payment button event
    cancelBtn.addEventListener('click', function () {
        const userConfirmed = confirm('Do you really want to cancel your payment?');
        if (userConfirmed) {
            cancelPayment();  // Call the existing cancelPayment function to reset the form
        }
    });
});

function sendPaymentRequest(paymentId, customerId, amount, paymentMethod, paymentDate, status) {
    const url = '/abcresturant/payment'; // Ensure this URL matches your servlet's mapping

    // Collect form data
    const formData = new URLSearchParams();
    formData.append('paymentId', paymentId);
    formData.append('customerId', customerId);
    formData.append('amount', amount);
    formData.append('paymentMethod', paymentMethod);
    formData.append('paymentDate', paymentDate);
    formData.append('status', status);

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
